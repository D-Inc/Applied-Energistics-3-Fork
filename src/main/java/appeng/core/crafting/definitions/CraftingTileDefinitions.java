
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
import appeng.core.lib.features.AEFeature;
import appeng.core.lib.features.BlockDefinition;
import appeng.core.lib.features.TileDefinition;
import net.minecraft.tileentity.TileEntity;

import appeng.api.definitions.ITileDefinition;
import appeng.core.crafting.api.definitions.ICraftingTileDefinitions;
import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.definitions.Definitions;
import net.minecraft.util.ResourceLocation;


public class CraftingTileDefinitions extends Definitions<Class<? extends TileEntity>, ITileDefinition<? extends TileEntity>> implements ICraftingTileDefinitions
{

	private final ITileDefinition craftingMonitor;
	private final ITileDefinition craftingStorage;
	private final ITileDefinition craftingUnit;
	private final ITileDefinition molecularAssembler;

	public CraftingTileDefinitions( FeatureFactory registry )
	{
		FeatureFactory crafting = registry.features( AEFeature.CraftingCPU );
		craftingMonitor = crafting.tile( new ResourceLocation( AppEng.NAME, "crafting_monitor" ) , TileCraftingMonitorTile.class ).build();
		craftingStorage = crafting.tile( new ResourceLocation( AppEng.NAME, "crafting_storage" ) , TileCraftingStorageTile.class ).build();
		craftingUnit = crafting.tile( new ResourceLocation( AppEng.NAME, "crafting_unit" ) , TileCraftingTile.class ).build();
		molecularAssembler = registry.tile( new ResourceLocation( AppEng.NAME, "molecular_assembler" ) , TileMolecularAssembler.class).build();
		init();
	}

}
