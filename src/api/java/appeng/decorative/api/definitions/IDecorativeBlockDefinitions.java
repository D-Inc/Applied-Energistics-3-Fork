
package appeng.decorative.api.definitions;


import appeng.decorative.block.BlockStairCommon;
import net.minecraft.block.Block;

import appeng.api.definitions.IBlockDefinition;
import appeng.api.definitions.IDefinitions;


public interface IDecorativeBlockDefinitions extends IDefinitions<Block, IBlockDefinition<Block>>
{
    default IBlockDefinition<Block> quartzBlock()
    {
        return get( "quartz_block" );
    }

    default IBlockDefinition<Block> quartzPillar()
    {
        return get( "quartz_pillar" );
    }

    default IBlockDefinition<Block> chiseledQuartzBlock()
    {
        return get( "chiseled_quartz_block" );
    }

    default IBlockDefinition<Block> quartzGlass()
    {
        return get( "quartz_glass" );
    }

    default IBlockDefinition<Block> quartzVibrantGlass()
    {
        return get( "quartz_vibrant_glass" );
    }

    default IBlockDefinition<Block> quartzFixture()
    {
        return get( "quartz_fixture" );
    }

    default IBlockDefinition<Block> fluixBlock()
    {
        return get( "fluix_block" );
    }

    default IBlockDefinition<Block> skyStoneBlock()
    {
        return get( "sky_stone_block" );
    }

    default IBlockDefinition<Block> smoothSkyStoneBlock()
    {
        return get( "smooth_skystone" );
    }

    default IBlockDefinition<Block> skyStoneBrick()
    {
        return get( "skystone_brick" );
    }

    default IBlockDefinition<Block> skyStoneSmallBrick()
    {
        return get( "skystone_small_brick" );
    }

    default IBlockDefinition<Block> skyStoneStairs()
    {
        return get( "skystone_stairs" );
    }

    default IBlockDefinition<Block> smoothSkyStoneStairs()
    {
        return get( "smooth_skystone_stairs" );
    }

    default IBlockDefinition<Block> skyStoneBrickStairs()
    {
        return get( "skystone_brick_stairs" );
    }

    default IBlockDefinition<Block> skyStoneSmallBrickStairs()
    {
        return get( "skystone_small_brick_stairs" );
    }

    default IBlockDefinition<Block> fluixStairs()
    {
        return get( "fluix_stairs" );
    }

    default IBlockDefinition<Block> quartzStairs()
    {
        return get( "quartz_stairs" );
    }

    default IBlockDefinition<Block> chiseledQuartzStairs()
    {
        return get( "chiseled_quartz_stairs" );
    }

    default IBlockDefinition<Block> quartzPillarStairs()
    {
        return get( "quartz_pillar_stairs" );
    }


    
}
