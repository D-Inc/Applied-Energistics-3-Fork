
package appeng.core.crafting.definitions;


import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import appeng.api.definitions.ITileDefinition;
import appeng.core.AppEng;
import appeng.core.crafting.api.definitions.ICraftingTileDefinitions;
import appeng.core.crafting.tile.TileCraftingMonitorTile;
import appeng.core.crafting.tile.TileCraftingStorageTile;
import appeng.core.crafting.tile.TileCraftingTile;
import appeng.core.crafting.tile.TileMolecularAssembler;
import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.definitions.Definitions;
import appeng.core.lib.features.AEFeature;


public class CraftingTileDefinitions extends Definitions<Class<TileEntity>, ITileDefinition<TileEntity>> implements ICraftingTileDefinitions
{

	private final ITileDefinition craftingMonitor;
	private final ITileDefinition craftingStorage;
	private final ITileDefinition craftingUnit;
	private final ITileDefinition molecularAssembler;

	public CraftingTileDefinitions( FeatureFactory registry )
	{
		FeatureFactory crafting = registry.features( AEFeature.CraftingCPU );
		craftingMonitor = crafting.tile( new ResourceLocation( AppEng.MODID, "crafting_monitor" ) , TileCraftingMonitorTile.class ).build();
		craftingStorage = crafting.tile( new ResourceLocation( AppEng.MODID, "crafting_storage" ) , TileCraftingStorageTile.class ).build();
		craftingUnit = crafting.tile( new ResourceLocation( AppEng.MODID, "crafting_unit" ) , TileCraftingTile.class ).build();
		molecularAssembler = registry.tile( new ResourceLocation( AppEng.MODID, "molecular_assembler" ) , TileMolecularAssembler.class).build();
		init();
	}

}
