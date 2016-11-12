
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
import appeng.core.tile.TileGrinder;
import appeng.core.tile.TileInscriber;
import appeng.core.tile.TileVibrationChamber;


public class CoreTileDefinitions extends Definitions<Class<TileEntity>, ITileDefinition<TileEntity>> implements ICoreTileDefinitions
{

	private final ITileDefinition crank;
	private final ITileDefinition charger;
	private final ITileDefinition grinder;
	private final ITileDefinition inscriber;
	private final ITileDefinition vibrationChamber;

	public CoreTileDefinitions( FeatureFactory registry )
	{
		this.crank = registry.tile( new ResourceLocation( AppEng.MOD_ID, "crank" ), TileCrank.class ).features( AEFeature.GrindStone ).build();
		this.charger = registry.tile( new ResourceLocation( AppEng.MOD_ID, "charger" ), TileCharger.class ).build();
		this.grinder = registry.tile( new ResourceLocation( AppEng.MOD_ID, "grinder" ), TileGrinder.class ).build();
		this.inscriber = registry.tile( new ResourceLocation( AppEng.MOD_ID, "inscriber"), TileInscriber.class ).build();
		this.vibrationChamber = registry.tile( new ResourceLocation( AppEng.MOD_ID, "vibration_chamber"), TileVibrationChamber.class ).build();
		init();
	}

}
