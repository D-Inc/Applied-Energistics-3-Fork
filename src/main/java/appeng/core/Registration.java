/*
 * This file is part of Applied Energistics 2.
 * Copyright (c) 2013 - 2015, AlgorithmX2, All rights reserved.
 *
 * Applied Energistics 2 is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Applied Energistics 2 is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Applied Energistics 2.  If not, see <http://www.gnu.org/licenses/lgpl>.
 */

package appeng.core;


import java.util.HashSet;
import java.util.Set;

import com.google.common.base.Preconditions;

import net.minecraft.item.ItemStack;
import net.minecraft.world.DimensionType;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import appeng.api.definitions.IItemDefinition;
import appeng.core.api.config.Upgrades;
import appeng.core.api.features.IWirelessTermHandler;
import appeng.core.api.features.IWorldGen.WorldGenType;
import appeng.core.hooks.TickHandler;
import appeng.core.lib.AEConfig;
import appeng.core.lib.AppEngApi;
import appeng.core.lib.api.definitions.ApiBlocks;
import appeng.core.lib.api.definitions.ApiItems;
import appeng.core.lib.api.definitions.ApiParts;
import appeng.core.lib.features.AEFeature;
import appeng.core.lib.features.registries.GridCacheRegistry;
import appeng.core.lib.features.registries.RegistryContainer;
import appeng.core.lib.features.registries.entries.BasicCellHandler;
import appeng.core.lib.features.registries.entries.CreativeCellHandler;
import appeng.core.lib.localization.GuiText;
import appeng.core.lib.localization.PlayerMessages;
import appeng.core.lib.util.Platform;
import appeng.core.me.api.networking.crafting.ICraftingGrid;
import appeng.core.me.api.networking.energy.IEnergyGrid;
import appeng.core.me.api.networking.pathing.IPathingGrid;
import appeng.core.me.api.networking.security.ISecurityGrid;
import appeng.core.me.api.networking.spatial.ISpatialCache;
import appeng.core.me.api.networking.storage.IStorageGrid;
import appeng.core.me.api.networking.ticking.ITickManager;
import appeng.core.me.api.parts.IPartHelper;
import appeng.core.me.block.BlockCableBus;
import appeng.core.me.grid.cache.CraftingGridCache;
import appeng.core.me.grid.cache.EnergyGridCache;
import appeng.core.me.grid.cache.GridStorageCache;
import appeng.core.me.grid.cache.P2PCache;
import appeng.core.me.grid.cache.PathGridCache;
import appeng.core.me.grid.cache.SecurityCache;
import appeng.core.me.grid.cache.SpatialPylonCache;
import appeng.core.me.grid.cache.TickManagerCache;
import appeng.core.me.grid.storage.AEExternalHandler;
import appeng.core.me.part.PartPlacement;
import appeng.core.spatial.world.BiomeGenStorage;
import appeng.core.spatial.world.StorageWorldProvider;
import appeng.core.worldgen.loot.ChestLoot;
import appeng.core.worldgen.world.MeteoriteWorldGen;
import appeng.core.worldgen.world.QuartzWorldGen;

@Deprecated
public final class Registration
{
	private DimensionType storageDimensionType;
	private Biome storageBiome;

	public Biome getStorageBiome()
	{
		return this.storageBiome;
	}

	public DimensionType getStorageDimensionType()
	{
		return storageDimensionType;
	}

	void preInitialize( final FMLPreInitializationEvent event )
	{
		this.registerSpatial( false );
	}

	private void registerSpatial( final boolean force )
	{
		if( !AEConfig.instance.isFeatureEnabled( AEFeature.SpatialIO ) )
		{
			return;
		}

		final AEConfig config = AEConfig.instance;

		if( this.storageBiome == null )
		{
			if( force && config.storageBiomeID == -1 )
			{
				config.storageBiomeID = Platform.findEmpty( Biome.REGISTRY, 0, 256 );
				if( config.storageBiomeID == -1 )
				{
					throw new IllegalStateException( "Biome Array is full, please free up some Biome ID's or disable spatial." );
				}

				this.storageBiome = new BiomeGenStorage();
				config.save();
			}

			if( !force && config.storageBiomeID != -1 )
			{
				this.storageBiome = new BiomeGenStorage();
			}
		}

		if( config.storageProviderID != -1 )
		{
			storageDimensionType = DimensionType.register( "Storage Cell", "_cell", config.storageProviderID, StorageWorldProvider.class, false );
		}

		if( config.storageProviderID == -1 && force )
		{
			final Set<Integer> ids = new HashSet<>();
			for( DimensionType type : DimensionType.values() )
			{
				ids.add( type.getId() );
			}

			config.storageProviderID = -11;

			while( ids.contains( config.storageProviderID ) )
			{
				config.storageProviderID--;
			}

			storageDimensionType = DimensionType.register( "Storage Cell", "_cell", config.storageProviderID, StorageWorldProvider.class, false );

			config.save();
		}
	}

	public void initialize( FMLInitializationEvent event )
	{
		Preconditions.checkNotNull( event );

		final AppEngApi api = AppEngApi.INSTANCE;
		final IPartHelper partHelper = api.partHelper();
		final RegistryContainer registries = api.registries();

		// TODO Pre-1.8 - readd layers
		// partHelper.registerNewLayer( "appeng.parts.layers.LayerISidedInventory",
		// "net.minecraft.inventory.ISidedInventory" );
		// partHelper.registerNewLayer( "appeng.parts.layers.LayerIFluidHandler",
		// "net.minecraftforge.fluids.IFluidHandler" );
		// partHelper.registerNewLayer( "appeng.parts.layers.LayerITileStorageMonitorable",
		// "appeng.api.implementations.tiles.ITileStorageMonitorable" );

		// if( IntegrationRegistry.INSTANCE.isEnabled( IntegrationType.IC2 ) )
		// {
		// partHelper.registerNewLayer( "appeng.parts.layers.LayerIEnergySink", "ic2.api.energy.tile.IEnergySink" );
		// partHelper.registerNewLayer( "appeng.parts.layers.LayerIEnergySource", "ic2.api.energy.tile.IEnergySource" );
		// }
		//
		// if( IntegrationRegistry.INSTANCE.isEnabled( IntegrationType.RF ) )
		// {
		// partHelper.registerNewLayer( "appeng.parts.layers.LayerIEnergyHandler", "cofh.api.energy.IEnergyReceiver" );
		// }
		//
		// if( IntegrationRegistry.INSTANCE.isEnabled( IntegrationType.OpenComputers ) )
		// {
		// partHelper.registerNewLayer( "appeng.parts.layers.LayerSidedEnvironment",
		// "li.cil.oc.api.network.SidedEnvironment" );
		// }

		FMLCommonHandler.instance().bus().register( TickHandler.INSTANCE );
		MinecraftForge.EVENT_BUS.register( TickHandler.INSTANCE );

		MinecraftForge.EVENT_BUS.register( new PartPlacement() );

		if( AEConfig.instance.isFeatureEnabled( AEFeature.ChestLoot ) )
		{
			MinecraftForge.EVENT_BUS.register( new ChestLoot() );
		}

		final GridCacheRegistry gcr = registries.gridCache();
		gcr.registerGridCache( ITickManager.class, TickManagerCache.class );
		gcr.registerGridCache( IEnergyGrid.class, EnergyGridCache.class );
		gcr.registerGridCache( IPathingGrid.class, PathGridCache.class );
		gcr.registerGridCache( IStorageGrid.class, GridStorageCache.class );
		gcr.registerGridCache( P2PCache.class, P2PCache.class );
		gcr.registerGridCache( ISpatialCache.class, SpatialPylonCache.class );
		gcr.registerGridCache( ISecurityGrid.class, SecurityCache.class );
		gcr.registerGridCache( ICraftingGrid.class, CraftingGridCache.class );

		registries.externalStorage().addExternalStorageInterface( new AEExternalHandler() );

		registries.cell().addCellHandler( new BasicCellHandler() );
		registries.cell().addCellHandler( new CreativeCellHandler() );

		api.definitions().materials().matterBall().maybeStack( 1 ).ifPresent( ammoStack -> {
			final double weight = 32;

			registries.matterCannon().registerAmmo( (ItemStack) ammoStack, weight );
		} );
	}

	void postInit( final FMLPostInitializationEvent event )
	{
		this.registerSpatial( true );

		final AppEngApi api = AppEngApi.INSTANCE;
		final RegistryContainer registries = api.registries();
		final ApiParts parts = definitions.parts();
		final ApiBlocks blocks = definitions.blocks();
		final ApiItems items = definitions.items();

		// add to localization..
		PlayerMessages.values();
		GuiText.values();

		blocks.multiPart().block().maybe().ifPresent( block -> ( (BlockCableBus) block ).setupTile() );

		// Interface
		Upgrades.CRAFTING.registerItem( parts.iface(), 1 );
		Upgrades.CRAFTING.registerItem( (IItemDefinition) blocks.iface().block().maybeItem().get(), 1 );

		// IO Port!
		Upgrades.SPEED.registerItem( (IItemDefinition) blocks.iOPort().block().maybeItem().get(), 3 );
		Upgrades.REDSTONE.registerItem( (IItemDefinition) blocks.iOPort().block().maybeItem().get(), 1 );

		// Level Emitter!
		Upgrades.FUZZY.registerItem( parts.levelEmitter(), 1 );
		Upgrades.CRAFTING.registerItem( parts.levelEmitter(), 1 );

		// Import Bus
		Upgrades.FUZZY.registerItem( parts.importBus(), 1 );
		Upgrades.REDSTONE.registerItem( parts.importBus(), 1 );
		Upgrades.CAPACITY.registerItem( parts.importBus(), 2 );
		Upgrades.SPEED.registerItem( parts.importBus(), 4 );

		// Export Bus
		Upgrades.FUZZY.registerItem( parts.exportBus(), 1 );
		Upgrades.REDSTONE.registerItem( parts.exportBus(), 1 );
		Upgrades.CAPACITY.registerItem( parts.exportBus(), 2 );
		Upgrades.SPEED.registerItem( parts.exportBus(), 4 );
		Upgrades.CRAFTING.registerItem( parts.exportBus(), 1 );

		// Storage Cells
		Upgrades.FUZZY.registerItem( items.cell1k(), 1 );
		Upgrades.INVERTER.registerItem( items.cell1k(), 1 );

		Upgrades.FUZZY.registerItem( items.cell4k(), 1 );
		Upgrades.INVERTER.registerItem( items.cell4k(), 1 );

		Upgrades.FUZZY.registerItem( items.cell16k(), 1 );
		Upgrades.INVERTER.registerItem( items.cell16k(), 1 );

		Upgrades.FUZZY.registerItem( items.cell64k(), 1 );
		Upgrades.INVERTER.registerItem( items.cell64k(), 1 );

		Upgrades.FUZZY.registerItem( items.portableCell(), 1 );
		Upgrades.INVERTER.registerItem( items.portableCell(), 1 );

		Upgrades.FUZZY.registerItem( items.viewCell(), 1 );
		Upgrades.INVERTER.registerItem( items.viewCell(), 1 );

		// Storage Bus
		Upgrades.FUZZY.registerItem( parts.storageBus(), 1 );
		Upgrades.INVERTER.registerItem( parts.storageBus(), 1 );
		Upgrades.CAPACITY.registerItem( parts.storageBus(), 5 );

		// Formation Plane
		Upgrades.FUZZY.registerItem( parts.formationPlane(), 1 );
		Upgrades.INVERTER.registerItem( parts.formationPlane(), 1 );
		Upgrades.CAPACITY.registerItem( parts.formationPlane(), 5 );

		// Matter Cannon
		Upgrades.FUZZY.registerItem( items.massCannon(), 1 );
		Upgrades.INVERTER.registerItem( items.massCannon(), 1 );
		Upgrades.SPEED.registerItem( items.massCannon(), 4 );

		// Molecular Assembler
		Upgrades.SPEED.registerItem( (IItemDefinition) blocks.molecularAssembler().block().maybeItem().get(), 5 );

		// Inscriber
		Upgrades.SPEED.registerItem( (IItemDefinition) blocks.inscriber().block().maybeItem().get(), 3 );

		items.wirelessTerminal().maybe().ifPresent( terminal -> {
			registries.wireless().registerWirelessHandler( (IWirelessTermHandler) terminal );
		} );

		// add villager trading to black smiths for a few basic materials
		if( AEConfig.instance.isFeatureEnabled( AEFeature.VillagerTrading ) )
		{
			// TODO Pre-1.8 - VILLAGER TRADING
			// VillagerRegistry.instance().getRegisteredVillagers()..registerVillageTradeHandler( 3, new AETrading() );
		}

		if( AEConfig.instance.isFeatureEnabled( AEFeature.CertusQuartzWorldGen ) )
		{
			GameRegistry.registerWorldGenerator( new QuartzWorldGen(), 0 );
		}

		if( AEConfig.instance.isFeatureEnabled( AEFeature.MeteoriteWorldGen ) )
		{
			GameRegistry.registerWorldGenerator( new MeteoriteWorldGen(), 0 );
		}

		/*
		 * world gen
		 */
		for( final WorldGenType type : WorldGenType.values() )
		{
			registries.worldgen().disableWorldGenForProviderID( type, StorageWorldProvider.class );

			// nether
			registries.worldgen().disableWorldGenForDimension( type, -1 );

			// end
			registries.worldgen().disableWorldGenForDimension( type, 1 );
		}

		// whitelist from config
		for( final int dimension : AEConfig.instance.meteoriteDimensionWhitelist )
		{
			registries.worldgen().enableWorldGenForDimension( WorldGenType.Meteorites, dimension );
		}
	}
}
