
package appeng.miscellaneous.definitions;


import net.minecraft.tileentity.TileEntity;

import appeng.api.definitions.ITileDefinition;
import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.definitions.Definitions;
import appeng.core.lib.features.AEFeature;
import appeng.miscellaneous.api.definitions.IMiscellaneousTileDefinitions;
import appeng.miscellaneous.block.BlockLightDetector;
import appeng.miscellaneous.block.BlockPaint;
import appeng.miscellaneous.block.BlockQuartzGrowthAccelerator;
import appeng.miscellaneous.tile.TileLightDetector;
import appeng.miscellaneous.tile.TilePaint;
import appeng.miscellaneous.tile.TileQuartzGrowthAccelerator;


public class MiscellaneousTileDefinitions extends Definitions<Class<? extends TileEntity>, ITileDefinition<? extends TileEntity, Class<? extends TileEntity>>> implements IMiscellaneousTileDefinitions
{

	private final ITileDefinition quartzGrowthAccelerator;

	private final ITileDefinition lightDetector;
	private final ITileDefinition paint;

	public MiscellaneousTileDefinitions( FeatureFactory registry )
	{
		this.quartzGrowthAccelerator = registry.tile( "quartz_growth_accelerator", TileQuartzGrowthAccelerator.class ).build();

		this.lightDetector = registry.tile( "light_detector", TileLightDetector.class ).features( AEFeature.LightDetector ).build();
		this.paint = registry.tile( "paint", TilePaint.class ).features( AEFeature.PaintBalls ).build();

		init();
	}

}
