
package appeng.core.crafting.definitions;


import appeng.core.AppEng;
import appeng.core.crafting.block.BlockCraftingMonitor;
import appeng.core.crafting.block.BlockCraftingStorage;
import appeng.core.crafting.block.BlockCraftingUnit;
import appeng.core.crafting.block.BlockMolecularAssembler;
import appeng.core.crafting.tile.TileCraftingMonitorTile;
import appeng.core.crafting.tile.TileCraftingStorageTile;
import appeng.core.crafting.tile.TileCraftingTile;
import appeng.core.crafting.tile.TileMolecularAssembler;
import appeng.core.lib.features.BlockDefinition;
import appeng.core.lib.features.TileDefinition;
import net.minecraft.tileentity.TileEntity;

import appeng.api.definitions.ITileDefinition;
import appeng.core.crafting.api.definitions.ICraftingTileDefinitions;
import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.definitions.Definitions;
import net.minecraft.util.ResourceLocation;


public class CraftingTileDefinitions extends Definitions<Class<? extends TileEntity>, ITileDefinition<? extends TileEntity, Class<? extends TileEntity>>> implements ICraftingTileDefinitions
{

	private final TileDefinition crafting_monitor;
	private final TileDefinition crafting_storage;
	private final TileDefinition crafting_unit;
	private final TileDefinition molecular_assembler;

	public CraftingTileDefinitions( FeatureFactory registry )
	{
		crafting_monitor = ( TileDefinition ) registry.tile( new ResourceLocation( AppEng.MOD_NAME, "crafting_monitor" ) , TileCraftingMonitorTile.class ).build();
		crafting_storage = ( TileDefinition ) registry.tile( new ResourceLocation( AppEng.MOD_NAME, "crafting_storage" ) , TileCraftingStorageTile.class ).build();
		crafting_unit = ( TileDefinition ) registry.tile( new ResourceLocation( AppEng.MOD_NAME, "crafting_unit" ) , TileCraftingTile.class ).build();
		molecular_assembler = ( TileDefinition ) registry.tile( new ResourceLocation( AppEng.MOD_NAME, "molecular_assembler" ) , TileMolecularAssembler.class).build();
		init();
	}

}
