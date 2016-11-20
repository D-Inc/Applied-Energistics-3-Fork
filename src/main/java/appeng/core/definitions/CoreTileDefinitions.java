
package appeng.core.definitions;


import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import appeng.api.definitions.ITileDefinition;
import appeng.core.AppEng;
import appeng.core.api.definitions.ICoreTileDefinitions;
import appeng.core.block.BlockCharger;
import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.definitions.Definitions;
import appeng.core.lib.features.AEFeature;
import appeng.core.tile.TileCharger;
import appeng.core.tile.TileCrank;
import appeng.core.tile.TileGrinder;
import appeng.core.tile.TileInscriber;
import appeng.core.tile.TileVibrationChamber;


public class CoreTileDefinitions extends Definitions<Class<? extends TileEntity>, ITileDefinition<? extends TileEntity>> implements ICoreTileDefinitions
{

	private final ITileDefinition crank;
	private final ITileDefinition charger;
	private final ITileDefinition grinder;
	private final ITileDefinition inscriber;
	private final ITileDefinition vibrationChamber;


	public CoreTileDefinitions( FeatureFactory registry )
	{
		this.crank = registry.tile( new ResourceLocation( AppEng.MODID, "crank" ), TileCrank.class ).features( AEFeature.GrindStone ).build();
		this.charger = registry.tile( new ResourceLocation( AppEng.MODID, "charger" ), TileCharger.class ).build();
		this.grinder = registry.tile( new ResourceLocation( AppEng.MODID, "grinder" ), TileGrinder.class ).features( AEFeature.GrindStone ).build();
		this.inscriber = registry.tile( new ResourceLocation( AppEng.MODID, "inscriber"), TileInscriber.class ).features( AEFeature.Inscriber ).build();
		this.vibrationChamber = registry.tile( new ResourceLocation( AppEng.MODID, "vibration_chamber"), TileVibrationChamber.class ).features( AEFeature.PowerGen ).build();
		
		init();
	}

}
