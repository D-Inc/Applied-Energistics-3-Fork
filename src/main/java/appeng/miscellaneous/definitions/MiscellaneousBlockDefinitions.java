
package appeng.miscellaneous.definitions;


import net.minecraft.block.Block;
import net.minecraft.block.BlockDispenser;
import net.minecraft.util.ResourceLocation;

import appeng.api.definitions.IBlockDefinition;
import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.definitions.Definitions;
import appeng.core.lib.features.AEFeature;
import appeng.miscellaneous.AppEngMiscellaneous;
import appeng.miscellaneous.api.definitions.IMiscellaneousBlockDefinitions;
import appeng.miscellaneous.block.BlockLightDetector;
import appeng.miscellaneous.block.BlockPaint;
import appeng.miscellaneous.block.BlockQuartzGrowthAccelerator;
import appeng.miscellaneous.block.BlockSkyCompass;
import appeng.miscellaneous.block.BlockTinyTNT;
import appeng.tools.hooks.DispenserBehaviorTinyTNT;


public class MiscellaneousBlockDefinitions extends Definitions<Block, IBlockDefinition<Block>> implements IMiscellaneousBlockDefinitions
{
	
	private final IBlockDefinition skyCompass;
	private final IBlockDefinition tinyTNT;
	private final IBlockDefinition quartzGrowthAccelerator;
	private final IBlockDefinition lightDetector;
	private final IBlockDefinition paint;

	public MiscellaneousBlockDefinitions( FeatureFactory registry )
	{
		this.skyCompass = registry.block( new ResourceLocation( AppEngMiscellaneous.MODID, "sky_compass" ), new BlockSkyCompass() ).features( AEFeature.MeteoriteCompass ).build();

		this.tinyTNT = registry.block( new ResourceLocation( AppEngMiscellaneous.MODID, "tiny_tnt" ), new BlockTinyTNT() ).features( AEFeature.TinyTNT ).createDefaultItemBlock().postInit( ( block ) -> {
			BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject( block.maybeItem().get().maybe().get(), new DispenserBehaviorTinyTNT() );
		} ).build();
		
		this.quartzGrowthAccelerator = registry.block( new ResourceLocation( AppEngMiscellaneous.MODID, "quartz_growth_accelerator" ), new BlockQuartzGrowthAccelerator() ).createDefaultItemBlock().build();
		
		this.lightDetector = registry.block( new ResourceLocation( AppEngMiscellaneous.MODID, "light_detector" ), new BlockLightDetector() ).features( AEFeature.LightDetector ).createDefaultItemBlock().build();
		this.paint = registry.block( new ResourceLocation( AppEngMiscellaneous.MODID, "paint" ), new BlockPaint() ).features( AEFeature.PaintBalls ).createDefaultItemBlock().build();
		
		init();
	}

}
