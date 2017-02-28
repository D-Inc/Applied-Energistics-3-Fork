
package appeng.miscellaneous.definitions;


import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import appeng.api.definitions.ITileDefinition;
import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.definitions.Definitions;
import appeng.core.lib.features.AEFeature;
import appeng.core.tile.TileQuartzGrowthAccelerator;
import appeng.miscellaneous.AppEngMiscellaneous;
import appeng.miscellaneous.api.definitions.IMiscellaneousTileDefinitions;
import appeng.miscellaneous.tile.TileLightDetector;
import appeng.miscellaneous.tile.TilePaint;
import appeng.miscellaneous.tile.TileSkyCompass;


public class MiscellaneousTileDefinitions extends Definitions<Class<TileEntity>, ITileDefinition<TileEntity>> implements IMiscellaneousTileDefinitions
{

	private final ITileDefinition quartzGrowthAccelerator;
	private final ITileDefinition skyCompass;
	private final ITileDefinition lightDetector;
	private final ITileDefinition paint;

	public MiscellaneousTileDefinitions( FeatureFactory registry )
	{
		this.quartzGrowthAccelerator = registry.tile( new ResourceLocation( AppEngMiscellaneous.MODID, "quartz_growth_accelerator" ), TileQuartzGrowthAccelerator.class ).build();
		this.skyCompass = registry.tile( new ResourceLocation( AppEngMiscellaneous.MODID, "sky_compass" ), TileSkyCompass.class ).addFeatures( AEFeature.MeteoriteCompass ).build();
		this.lightDetector = registry.tile( new ResourceLocation( AppEngMiscellaneous.MODID, "light_detector" ), TileLightDetector.class ).features( AEFeature.LightDetector ).build();
		this.paint = registry.tile( new ResourceLocation( AppEngMiscellaneous.MODID, "paint" ), TilePaint.class ).features( AEFeature.PaintBalls ).build();

		init();
	}

}
