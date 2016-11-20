
package appeng.decorative.definitions;


import net.minecraft.block.Block;

import appeng.api.definitions.IBlockDefinition;
import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.definitions.Definitions;
import appeng.core.lib.features.AEFeature;
import appeng.core.worldgen.block.BlockQuartz;
import appeng.core.worldgen.block.BlockSkyStone;
import appeng.core.worldgen.block.BlockSkyStone.SkystoneType;
import appeng.decorative.api.definitions.IDecorativeBlockDefinitions;
import appeng.decorative.block.BlockChiseledQuartz;
import appeng.decorative.block.BlockFluix;
import appeng.decorative.block.BlockQuartzGlass;
import appeng.decorative.block.BlockQuartzLamp;
import appeng.decorative.block.BlockQuartzPillar;
import appeng.decorative.block.BlockStairCommon;
import appeng.miscellaneous.block.BlockQuartzTorch;


public class DecorativeBlockDefinitions extends Definitions<Block, IBlockDefinition<Block>> implements IDecorativeBlockDefinitions
{
	
	private final IBlockDefinition quartzBlock;
	private final IBlockDefinition quartzPillar;
	private final IBlockDefinition chiseledQuartzBlock;
	private final IBlockDefinition quartzGlass;
	private final IBlockDefinition quartzVibrantGlass;
	private final IBlockDefinition quartzFixture;
	private final IBlockDefinition fluixBlock;
	private final IBlockDefinition skyStoneBlock;
	private final IBlockDefinition smoothSkyStoneBlock;
	private final IBlockDefinition skyStoneBrick;
	private final IBlockDefinition skyStoneSmallBrick;
	

	private final IBlockDefinition skyStoneStairs;
	private final IBlockDefinition smoothSkyStoneStairs;
	private final IBlockDefinition skyStoneBrickStairs;
	private final IBlockDefinition skyStoneSmallBrickStairs;
	private final IBlockDefinition fluixStairs;
	private final IBlockDefinition quartzStairs;
	private final IBlockDefinition chiseledQuartzStairs;
	private final IBlockDefinition quartzPillarStairs;
	/*
	 * private final IBlockDefinition skyStoneSlab;
	 * private final IBlockDefinition skyStoneBlockSlab;
	 * private final IBlockDefinition skyStoneBrickSlab;
	 * private final IBlockDefinition skyStoneSmallBrickSlab;
	 * private final IBlockDefinition fluixSlab;
	 * private final IBlockDefinition quartzSlab;
	 * private final IBlockDefinition chiseledQuartzSlab;
	 * private final IBlockDefinition quartzPillarSlab;
	 */

	public DecorativeBlockDefinitions( FeatureFactory registry )
	{
		FeatureFactory deco = registry.features( AEFeature.DecorativeQuartzBlocks );
		this.quartzBlock = deco.block( "quartz_block", new BlockQuartz() ).build();
		this.quartzPillar = deco.block( "quartz_pillar", new BlockQuartzPillar() ).build();
		this.chiseledQuartzBlock = deco.block( "chiseled_quartz_block", new BlockChiseledQuartz() ).build();
		this.quartzGlass = deco.block( "quartz_glass", new BlockQuartzGlass() ).build();
		this.quartzVibrantGlass = deco.block( "quartz_vibrant_glass", new BlockQuartzLamp() ).addFeatures( AEFeature.DecorativeLights ).build();
		this.quartzFixture = registry.block( "quartz_fixture", new BlockQuartzTorch() ).features( AEFeature.DecorativeLights ).build();

		this.fluixBlock = deco.block( "fluix_block", new BlockFluix() ).build();
		this.skyStoneBlock = deco.block( "sky_stone_block", new BlockSkyStone( SkystoneType.STONE ) ).build();
		this.smoothSkyStoneBlock = deco.block( "smooth_skystone", new BlockSkyStone( SkystoneType.BLOCK ) ).build();
		this.skyStoneBrick = deco.block( "skystone_brick", new BlockSkyStone( SkystoneType.BRICK ) ).build();
		this.skyStoneSmallBrick = deco.block( "skystone_small_brick", new BlockSkyStone( SkystoneType.SMALL_BRICK ) ).build();

		this.skyStoneStairs = makeStairs( "skystone_stairs", registry, this.skyStoneBlock() );
		this.smoothSkyStoneStairs = makeStairs( "smooth_skystone_stairs", registry, this.smoothSkyStoneBlock() );
		this.skyStoneBrickStairs = makeStairs( "skystone_brick_stairs", registry, this.skyStoneBrick() );
		this.skyStoneSmallBrickStairs = makeStairs( "skystone_small_brick_stairs", registry, this.skyStoneSmallBrick() );
		this.fluixStairs = makeStairs( "fluix_stairs", registry, this.fluixBlock() );
		this.quartzStairs = makeStairs( "quartz_stairs", registry, this.quartzBlock() );
		this.chiseledQuartzStairs = makeStairs( "chiseled_quartz_stairs", registry, this.chiseledQuartzBlock() );
		this.quartzPillarStairs = makeStairs( "quartz_pillar_stairs", registry, this.quartzPillar() );
		
		init();
	}

	private static IBlockDefinition makeStairs( String registryName, FeatureFactory registry, IBlockDefinition<Block> block )
	{
		return registry.block( registryName, new BlockStairCommon( block.maybe().get(), block.identifier().getResourcePath() ) ).features( AEFeature.DecorativeQuartzBlocks ).build();
	}

}
