
package appeng.core.definitions;


import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import appeng.api.definitions.ITileDefinition;
import appeng.core.AppEng;
import appeng.core.api.definitions.ICoreTileDefinitions;
import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.definitions.Definitions;
import appeng.core.lib.features.AEFeature;
import appeng.core.tile.TileCharger;
import appeng.core.tile.TileCrank;
import appeng.core.tile.TileCreativeEnergyCell;
import appeng.core.tile.TileCrystalGrowthAccelerator;
import appeng.core.tile.TileDenseEnergyCell;
import appeng.core.tile.TileEnergyAcceptor;
import appeng.core.tile.TileEnergyCell;
import appeng.core.tile.TileGrinder;
import appeng.core.tile.TileVibrationChamber;
import appeng.miscellaneous.AppEngMiscellaneous;


public class CoreTileDefinitions extends Definitions<Class<TileEntity>, ITileDefinition<TileEntity>> implements ICoreTileDefinitions
{

	private final ITileDefinition crank;
	private final ITileDefinition charger;
	private final ITileDefinition grinder;
	private final ITileDefinition vibrationChamber;

	private final ITileDefinition energyAcceptor;
	private final ITileDefinition energyCell;
	private final ITileDefinition energyCellDense;
	private final ITileDefinition energyCellCreative;
	
	private final ITileDefinition crystalGrowthAccelerator;

	public CoreTileDefinitions( FeatureFactory registry )
	{
		this.crank = registry.tile( new ResourceLocation( AppEng.MODID, "crank" ), TileCrank.class ).features( AEFeature.GrindStone ).build();
		this.charger = registry.tile( new ResourceLocation( AppEng.MODID, "charger" ), TileCharger.class ).build();
		this.grinder = registry.tile( new ResourceLocation( AppEng.MODID, "grinder" ), TileGrinder.class ).features( AEFeature.GrindStone ).build();
		this.vibrationChamber = registry.tile( new ResourceLocation( AppEng.MODID, "vibration_chamber"), TileVibrationChamber.class ).features( AEFeature.PowerGen ).build();
		
		this.energyAcceptor = registry.tile( new ResourceLocation( AppEng.MODID, "energy_acceptor" ), TileEnergyAcceptor.class ).build();
		this.energyCell = registry.tile( new ResourceLocation( AppEng.MODID, "energy_cell" ), TileEnergyCell.class ).build();
		this.energyCellDense = registry.tile( new ResourceLocation( AppEng.MODID, "dense_energy_cell" ), TileDenseEnergyCell.class ).features( AEFeature.DenseEnergyCells ).build();
		this.energyCellCreative = registry.tile( new ResourceLocation( AppEng.MODID, "creative_energy_cell" ), TileCreativeEnergyCell.class ).features( AEFeature.Creative ).build();
		
		this.crystalGrowthAccelerator = registry.tile( new ResourceLocation( AppEngMiscellaneous.MODID, "crystal_growth_accelerator" ), TileCrystalGrowthAccelerator.class ).build();
		
		init();
	}

}
