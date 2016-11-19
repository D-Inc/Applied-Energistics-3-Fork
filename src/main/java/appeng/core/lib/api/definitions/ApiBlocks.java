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

package appeng.core.lib.api.definitions;


import net.minecraft.block.Block;
import net.minecraft.block.BlockDispenser;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

import appeng.api.definitions.IBlockDefinition;
import appeng.api.definitions.ITileDefinition;
import appeng.core.AppEng;
import appeng.core.block.BlockCharger;
import appeng.core.block.BlockGrinder;
import appeng.core.block.BlockInscriber;
import appeng.core.block.BlockVibrationChamber;
import appeng.core.crafting.block.BlockCraftingMonitor;
import appeng.core.crafting.block.BlockCraftingStorage;
import appeng.core.crafting.block.BlockCraftingUnit;
import appeng.core.crafting.block.BlockCraftingUnit.CraftingUnitType;
import appeng.core.crafting.block.BlockMolecularAssembler;
import appeng.core.crafting.block.ItemCraftingStorage;
import appeng.core.lib.bootstrap.BlockRenderingCustomizer;
import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.bootstrap.IBlockRendering;
import appeng.core.lib.bootstrap.IItemRendering;
import appeng.core.lib.features.AEFeature;
import appeng.core.lib.item.AEBaseItemBlockChargeable;
import appeng.core.me.block.BlockCableBus;
import appeng.core.me.block.BlockCellWorkbench;
import appeng.core.me.block.BlockChest;
import appeng.core.me.block.BlockCondenser;
import appeng.core.me.block.BlockController;
import appeng.core.me.block.BlockCreativeEnergyCell;
import appeng.core.me.block.BlockDenseEnergyCell;
import appeng.core.me.block.BlockDrive;
import appeng.core.me.block.BlockEnergyAcceptor;
import appeng.core.me.block.BlockEnergyCell;
import appeng.core.me.block.BlockEnergyCellRendering;
import appeng.core.me.block.BlockIOPort;
import appeng.core.me.block.BlockInterface;
import appeng.core.me.block.BlockQuantumLinkChamber;
import appeng.core.me.block.BlockQuantumRing;
import appeng.core.me.block.BlockSecurity;
import appeng.core.me.block.BlockWireless;
import appeng.core.me.block.CableBusColor;
import appeng.core.me.block.CableModelCustomizer;
import appeng.core.spatial.block.BlockMatrixFrame;
import appeng.core.spatial.block.BlockSpatialIOPort;
import appeng.core.spatial.block.BlockSpatialPylon;
import appeng.core.worldgen.block.BlockChargedQuartzOre;
import appeng.core.worldgen.block.BlockQuartz;
import appeng.core.worldgen.block.BlockQuartzOre;
import appeng.core.worldgen.block.BlockSkyChest;
import appeng.core.worldgen.block.BlockSkyChest.SkyChestType;
import appeng.core.worldgen.block.BlockSkyStone;
import appeng.core.worldgen.block.BlockSkyStone.SkystoneType;
import appeng.core.worldgen.client.render.SkyChestRenderingCustomizer;
import appeng.debug.BlockChunkloader;
import appeng.debug.BlockCubeGenerator;
import appeng.debug.BlockItemGen;
import appeng.debug.BlockPhantomNode;
import appeng.decorative.block.BlockChiseledQuartz;
import appeng.decorative.block.BlockFluix;
import appeng.decorative.block.BlockQuartzGlass;
import appeng.decorative.block.BlockQuartzLamp;
import appeng.decorative.block.BlockQuartzPillar;
import appeng.decorative.block.BlockStairCommon;
import appeng.miscellaneous.block.BlockLightDetector;
import appeng.miscellaneous.block.BlockPaint;
import appeng.miscellaneous.block.BlockQuartzGrowthAccelerator;
import appeng.miscellaneous.block.BlockQuartzTorch;
import appeng.miscellaneous.block.BlockSkyCompass;
import appeng.miscellaneous.block.BlockTinyTNT;
import appeng.tools.hooks.DispenserBehaviorTinyTNT;


/**
 * Internal implementation for the API blocks
 */
public final class ApiBlocks// implements IBlocks
{

	private final ITileDefinition wirelessAccessPoint;
	private final ITileDefinition charger;
	private final ITileDefinition securityStation;
	private final ITileDefinition quantumRing;
	private final ITileDefinition quantumLink;
	private final ITileDefinition spatialPylon;
	private final ITileDefinition spatialIOPort;
	private final ITileDefinition multiPart;
	private final ITileDefinition controller;
	private final ITileDefinition drive;
	private final ITileDefinition chest;
	private final ITileDefinition iface;
	private final ITileDefinition cellWorkbench;
	private final ITileDefinition iOPort;
	private final ITileDefinition condenser;
	private final ITileDefinition energyAcceptor;
	private final ITileDefinition vibrationChamber;
	private final ITileDefinition quartzGrowthAccelerator;
	private final ITileDefinition energyCell;
	private final ITileDefinition energyCellDense;
	private final ITileDefinition energyCellCreative;
	private final ITileDefinition craftingUnit;
	private final ITileDefinition craftingAccelerator;
	private final ITileDefinition craftingStorage1k;
	private final ITileDefinition craftingStorage4k;
	private final ITileDefinition craftingStorage16k;
	private final ITileDefinition craftingStorage64k;
	private final ITileDefinition craftingMonitor;
	private final ITileDefinition molecularAssembler;
	private final ITileDefinition lightDetector;
	private final ITileDefinition paint;

	public ApiBlocks( FeatureFactory registry )
	{
		this.wirelessAccessPoint = registry.block( "wireless_access_point", new BlockWireless() ).features( AEFeature.WirelessAccessTerminal ).build();
		this.charger = registry.block( "charger", new BlockCharger() ).rendering( new BlockRenderingCustomizer(){
			@Override
			public void customize( IBlockRendering rendering, IItemRendering itemRendering )
			{
				rendering.tesr( BlockCharger.createTesr() );
			}
		} ).build();
		this.securityStation = registry.block( "security_station", new BlockSecurity() ).features( AEFeature.Security ).build();
		this.quantumRing = registry.block( "quantum_ring", new BlockQuantumRing() ).features( AEFeature.QuantumNetworkBridge ).build();
		this.quantumLink = registry.block( "quantum_link", new BlockQuantumLinkChamber() ).features( AEFeature.QuantumNetworkBridge ).build();
		this.spatialPylon = registry.block( "spatial_pylon", new BlockSpatialPylon() ).features( AEFeature.SpatialIO ).build();
		this.spatialIOPort = registry.block( "spatial_ioport", new BlockSpatialIOPort() ).features( AEFeature.SpatialIO ).build();
		this.controller = registry.block( "controller", new BlockController() ).features( AEFeature.Channels ).build();
		this.drive = registry.block( "drive", new BlockDrive() ).features( AEFeature.StorageCells, AEFeature.MEDrive ).build();
		this.chest = registry.block( "chest", new BlockChest() ).features( AEFeature.StorageCells, AEFeature.MEChest ).build();
		this.iface = registry.block( "interface", new BlockInterface() ).build();
		this.cellWorkbench = registry.block( "cell_workbench", new BlockCellWorkbench() ).features( AEFeature.StorageCells ).build();
		this.iOPort = registry.block( "ioport", new BlockIOPort() ).features( AEFeature.StorageCells, AEFeature.IOPort ).build();
		this.condenser = registry.block( "condenser", new BlockCondenser() ).build();
		this.energyAcceptor = registry.block( "energy_acceptor", new BlockEnergyAcceptor() ).build();
		this.vibrationChamber = registry.block( "vibration_chamber", new BlockVibrationChamber() ).features( AEFeature.PowerGen ).build();
		this.quartzGrowthAccelerator = registry.block( "quartz_growth_accelerator", new BlockQuartzGrowthAccelerator() ).build();
		this.energyCell = registry.block( "energy_cell", new BlockEnergyCell::new ).item( AEBaseItemBlockChargeable() ).rendering( new BlockEnergyCellRendering( new ResourceLocation( AppEng.MOD_ID, "energy_cell" ) ) ).build();
		this.energyCellDense = registry.block( "dense_energy_cell", new BlockDenseEnergyCell::new ).features( AEFeature.DenseEnergyCells ).item( AEBaseItemBlockChargeable() ).rendering( new BlockEnergyCellRendering( new ResourceLocation( AppEng.MOD_ID, "dense_energy_cell" ) ) ).build();
		this.energyCellCreative = registry.block( "creative_energy_cell", new BlockCreativeEnergyCell::new ).features( AEFeature.Creative ).item( AEBaseItemBlockChargeable() ).build();

		FeatureFactory crafting = registry.features( AEFeature.CraftingCPU );
		this.craftingUnit = crafting.block( "crafting_unit", new BlockCraftingUnit( CraftingUnitType.UNIT ) ).build();
		this.craftingAccelerator = crafting.block( "crafting_accelerator", new BlockCraftingUnit( CraftingUnitType.ACCELERATOR ) ).build();
		this.craftingStorage1k = crafting.block( "crafting_storage_1k", new new BlockCraftingStorage( CraftingUnitType.STORAGE_1K ) ).item( ItemCraftingStorage() ).build();
		this.craftingStorage4k = crafting.block( "crafting_storage_4k", new new BlockCraftingStorage( CraftingUnitType.STORAGE_4K ) ).item( ItemCraftingStorage() ).build();
		this.craftingStorage16k = crafting.block( "crafting_storage_16k", new new BlockCraftingStorage( CraftingUnitType.STORAGE_16K ) ).item( ItemCraftingStorage() ).build();
		this.craftingStorage64k = crafting.block( "crafting_storage_64k", new new BlockCraftingStorage( CraftingUnitType.STORAGE_64K ) ).item( ItemCraftingStorage() ).build();
		this.craftingMonitor = crafting.block( "crafting_monitor", new BlockCraftingMonitor() ).build();

		this.molecularAssembler = registry.block( "molecular_assembler", new BlockMolecularAssembler() ).features( AEFeature.MolecularAssembler ).build();
		this.lightDetector = registry.block( "light_detector", new BlockLightDetector() ).features( AEFeature.LightDetector ).build();
		this.paint = registry.block( "paint", new BlockPaint() ).features( AEFeature.PaintBalls ).build();

		this.multiPart = registry.block( "multipart_block", new BlockCableBus() ).rendering( new BlockRenderingCustomizer(){
			@Override
			@SideOnly( Side.CLIENT )
			public void customize( IBlockRendering rendering, IItemRendering itemRendering )
			{
				rendering.modelCustomizer( new CableModelCustomizer()::customizeModel ).blockColor( new CableBusColor() );
			}
		} ).build();

		// TODO Pre-1.8 - Re-Add Slabs...
		/*
		 * this.skyStoneSlab = constructor.registerBlockDefinition( new AEBaseSlabBlock( skyStone_stone,
		 * EnumSet.of(AEFeature.DecorativeQuartzBlocks), false, "SkyStoneSlabBlock" ) );
		 * this.skyStoneBlockSlab = constructor.registerBlockDefinition( new AEBaseSlabBlock( skyStone_block,
		 * EnumSet.of(AEFeature.DecorativeQuartzBlocks), false, "SkyStoneBlockSlabBlock" ) );
		 * this.skyStoneBrickSlab = constructor.registerBlockDefinition( new AEBaseSlabBlock( skyStone_brick,
		 * EnumSet.of(AEFeature.DecorativeQuartzBlocks), false, "SkyStoneBrickSlabBlock" ) );
		 * this.skyStoneSmallBrickSlab = constructor.registerBlockDefinition( new AEBaseSlabBlock( skyStone_smallbrick,
		 * EnumSet.of(AEFeature.DecorativeQuartzBlocks), false, "SkyStoneSmallBrickSlabBlock" ) );
		 * this.fluixSlab = constructor.registerBlockDefinition( new AEBaseSlabBlock( fluixBlock,
		 * EnumSet.of(AEFeature.DecorativeQuartzBlocks), false, "FluixSlabBlock" ) );
		 * this.quartzSlab = constructor.registerBlockDefinition( new AEBaseSlabBlock( quartzBlock,
		 * EnumSet.of(AEFeature.DecorativeQuartzBlocks), false, "QuartzSlabBlock" ) );
		 * this.chiseledQuartzSlab = constructor.registerBlockDefinition( new AEBaseSlabBlock( chiseledQuartzBlock,
		 * EnumSet.of(AEFeature.DecorativeQuartzBlocks), false, "ChiseledQuartzSlabBlock" ) );
		 * this.quartzPillarSlab = constructor.registerBlockDefinition( new AEBaseSlabBlock( quartzPillar,
		 * EnumSet.of(AEFeature.DecorativeQuartzBlocks), false, "QuartzPillarSlabBlock" ) )
		 */

	}

	/* @Override */
	public IBlockDefinition quartzOre()
	{
		return this.quartzOre;
	}

	/* @Override */
	public IBlockDefinition quartzOreCharged()
	{
		return this.quartzOreCharged;
	}

	/* @Override */
	public IBlockDefinition matrixFrame()
	{
		return this.matrixFrame;
	}

	/* @Override */
	public IBlockDefinition quartzBlock()
	{
		return this.quartzBlock;
	}

	/* @Override */
	public IBlockDefinition quartzPillar()
	{
		return this.quartzPillar;
	}

	/* @Override */
	public IBlockDefinition chiseledQuartzBlock()
	{
		return this.chiseledQuartzBlock;
	}

	/* @Override */
	public IBlockDefinition quartzGlass()
	{
		return this.quartzGlass;
	}

	/* @Override */
	public IBlockDefinition quartzVibrantGlass()
	{
		return this.quartzVibrantGlass;
	}

	/* @Override */
	public IBlockDefinition quartzFixture()
	{
		return this.quartzFixture;
	}

	/* @Override */
	public IBlockDefinition fluixBlock()
	{
		return this.fluixBlock;
	}

	/* @Override */
	public IBlockDefinition skyStoneBlock()
	{
		return this.skyStoneBlock;
	}

	/* @Override */
	public IBlockDefinition smoothSkyStoneBlock()
	{
		return this.smoothSkyStoneBlock;
	}

	/* @Override */
	public IBlockDefinition skyStoneBrick()
	{
		return this.skyStoneBrick;
	}

	/* @Override */
	public IBlockDefinition skyStoneSmallBrick()
	{
		return this.skyStoneSmallBrick;
	}

	/* @Override */
	public IBlockDefinition skyStoneChest()
	{
		return this.skyStoneChest;
	}

	/* @Override */
	public IBlockDefinition smoothSkyStoneChest()
	{
		return this.smoothSkyStoneChest;
	}

	/* @Override */
	public IBlockDefinition skyCompass()
	{
		return this.skyCompass;
	}

	/* @Override */
	public IBlockDefinition skyStoneStairs()
	{
		return this.skyStoneStairs;
	}

	/* @Override */
	public IBlockDefinition smoothSkyStoneStairs()
	{
		return this.smoothSkyStoneStairs;
	}

	/* @Override */
	public IBlockDefinition skyStoneBrickStairs()
	{
		return this.skyStoneBrickStairs;
	}

	/* @Override */
	public IBlockDefinition skyStoneSmallBrickStairs()
	{
		return this.skyStoneSmallBrickStairs;
	}

	/* @Override */
	public IBlockDefinition fluixStairs()
	{
		return this.fluixStairs;
	}

	/* @Override */
	public IBlockDefinition quartzStairs()
	{
		return this.quartzStairs;
	}

	/* @Override */
	public IBlockDefinition chiseledQuartzStairs()
	{
		return this.chiseledQuartzStairs;
	}

	/* @Override */
	public IBlockDefinition quartzPillarStairs()
	{
		return this.quartzPillarStairs;
	}

	/*
	 * @Override
	 * public IBlockDefinition skyStoneSlab()
	 * {
	 * return this.skyStoneSlab;
	 * }
	 * @Override
	 * public IBlockDefinition skyStoneBlockSlab()
	 * {
	 * return this.skyStoneBlockSlab;
	 * }
	 * @Override
	 * public IBlockDefinition skyStoneBrickSlab()
	 * {
	 * return this.skyStoneBrickSlab;
	 * }
	 * @Override
	 * public IBlockDefinition skyStoneSmallBrickSlab()
	 * {
	 * return this.skyStoneSmallBrickSlab;
	 * }
	 * @Override
	 * public IBlockDefinition fluixSlab()
	 * {
	 * return this.fluixSlab;
	 * }
	 * @Override
	 * public IBlockDefinition quartzSlab()
	 * {
	 * return this.quartzSlab;
	 * }
	 * @Override
	 * public IBlockDefinition chiseledQuartzSlab()
	 * {
	 * return this.chiseledQuartzSlab;
	 * }
	 * @Override
	 * public IBlockDefinition quartzPillarSlab()
	 * {
	 * return this.quartzPillarSlab;
	 * }
	 */

	/* @Override */
	public ITileDefinition grindstone()
	{
		return this.grindstone;
	}

	/* @Override */
	public ITileDefinition inscriber()
	{
		return this.inscriber;
	}

	/* @Override */
	public ITileDefinition wirelessAccessPoint()
	{
		return this.wirelessAccessPoint;
	}

	/* @Override */
	public ITileDefinition charger()
	{
		return this.charger;
	}

	/* @Override */
	public IBlockDefinition<? extends Block> tinyTNT()
	{
		return this.tinyTNT;
	}

	/* @Override */
	public ITileDefinition securityStation()
	{
		return this.securityStation;
	}

	/* @Override */
	public ITileDefinition quantumRing()
	{
		return this.quantumRing;
	}

	/* @Override */
	public ITileDefinition quantumLink()
	{
		return this.quantumLink;
	}

	/* @Override */
	public ITileDefinition spatialPylon()
	{
		return this.spatialPylon;
	}

	/* @Override */
	public ITileDefinition spatialIOPort()
	{
		return this.spatialIOPort;
	}

	/* @Override */
	public ITileDefinition multiPart()
	{
		return this.multiPart;
	}

	/* @Override */
	public ITileDefinition controller()
	{
		return this.controller;
	}

	/* @Override */
	public ITileDefinition drive()
	{
		return this.drive;
	}

	/* @Override */
	public ITileDefinition chest()
	{
		return this.chest;
	}

	/* @Override */
	public ITileDefinition iface()
	{
		return this.iface;
	}

	/* @Override */
	public ITileDefinition cellWorkbench()
	{
		return this.cellWorkbench;
	}

	/* @Override */
	public ITileDefinition iOPort()
	{
		return this.iOPort;
	}

	/* @Override */
	public ITileDefinition condenser()
	{
		return this.condenser;
	}

	/* @Override */
	public ITileDefinition energyAcceptor()
	{
		return this.energyAcceptor;
	}

	/* @Override */
	public ITileDefinition vibrationChamber()
	{
		return this.vibrationChamber;
	}

	/* @Override */
	public ITileDefinition quartzGrowthAccelerator()
	{
		return this.quartzGrowthAccelerator;
	}

	/* @Override */
	public ITileDefinition energyCell()
	{
		return this.energyCell;
	}

	/* @Override */
	public ITileDefinition energyCellDense()
	{
		return this.energyCellDense;
	}

	/* @Override */
	public ITileDefinition energyCellCreative()
	{
		return this.energyCellCreative;
	}

	/* @Override */
	public ITileDefinition craftingUnit()
	{
		return this.craftingUnit;
	}

	/* @Override */
	public ITileDefinition craftingAccelerator()
	{
		return this.craftingAccelerator;
	}

	/* @Override */
	public ITileDefinition craftingStorage1k()
	{
		return this.craftingStorage1k;
	}

	/* @Override */
	public ITileDefinition craftingStorage4k()
	{
		return this.craftingStorage4k;
	}

	/* @Override */
	public ITileDefinition craftingStorage16k()
	{
		return this.craftingStorage16k;
	}

	/* @Override */
	public ITileDefinition craftingStorage64k()
	{
		return this.craftingStorage64k;
	}

	/* @Override */
	public ITileDefinition craftingMonitor()
	{
		return this.craftingMonitor;
	}

	/* @Override */
	public ITileDefinition molecularAssembler()
	{
		return this.molecularAssembler;
	}

	/* @Override */
	public ITileDefinition lightDetector()
	{
		return this.lightDetector;
	}

	/* @Override */
	public ITileDefinition<? extends TileEntity, Class<? extends TileEntity>> paint()
	{
		return this.paint;
	}

	public IBlockDefinition chunkLoader()
	{
		return this.chunkLoader;
	}

	public IBlockDefinition itemGen()
	{
		return this.itemGen;
	}

	public IBlockDefinition phantomNode()
	{
		return this.phantomNode;
	}

	public IBlockDefinition cubeGenerator()
	{
		return this.cubeGenerator;
	}
}
