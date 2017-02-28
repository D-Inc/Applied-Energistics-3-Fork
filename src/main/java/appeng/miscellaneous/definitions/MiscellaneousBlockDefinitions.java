
package appeng.miscellaneous.definitions;


import net.minecraft.block.Block;
import net.minecraft.block.BlockDispenser;
import net.minecraft.util.ResourceLocation;

import appeng.api.definitions.IBlockDefinition;
import appeng.core.block.BlockCrystalGrowthAccelerator;
import appeng.core.block.BlockTinyTNT;
import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.definitions.Definitions;
import appeng.core.lib.features.AEFeature;
import appeng.core.worldgen.block.BlockSkyCompass;
import appeng.decorative.block.BlockPaint;
import appeng.miscellaneous.AppEngMiscellaneous;
import appeng.miscellaneous.api.definitions.IMiscellaneousBlockDefinitions;
import appeng.miscellaneous.block.BlockLightDetectingFixture;
import appeng.tools.hooks.DispenserBehaviorTinyTNT;


public class MiscellaneousBlockDefinitions extends Definitions<Block, IBlockDefinition<Block>> implements IMiscellaneousBlockDefinitions
{
	
	private final IBlockDefinition lightDetectingFixture;

	public MiscellaneousBlockDefinitions( FeatureFactory registry )
	{		
		this.lightDetectingFixture = registry.block( new ResourceLocation( AppEngMiscellaneous.MODID, "light_detecting_fixture" ), new BlockLightDetectingFixture() ).features( AEFeature.LightDetector ).createDefaultItemBlock().build();
		
		init();
	}

}
