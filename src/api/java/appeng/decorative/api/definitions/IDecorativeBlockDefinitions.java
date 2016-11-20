
package appeng.decorative.api.definitions;


import appeng.decorative.block.BlockStairCommon;
import net.minecraft.block.Block;

import appeng.api.definitions.IBlockDefinition;
import appeng.api.definitions.IDefinitions;


public interface IDecorativeBlockDefinitions extends IDefinitions<Block, IBlockDefinition<Block>>
{
    default IBlockDefinition<? extends Block> quartzBlock()
    {
        return get( "quartz_block" );
    }

    default IBlockDefinition<? extends Block> quartzPillar()
    {
        return get( "quartz_pillar" );
    }

    default IBlockDefinition<? extends Block> chiseledQuartzBlock()
    {
        return get( "chiseled_quartz_block" );
    }

    default IBlockDefinition<? extends Block> quartzGlass()
    {
        return get( "quartz_glass" );
    }

    default IBlockDefinition<? extends Block> quartzVibrantGlass()
    {
        return get( "quartz_vibrant_glass" );
    }

    default IBlockDefinition<? extends Block> quartzFixture()
    {
        return get( "quartz_fixture" );
    }

    default IBlockDefinition<? extends Block> fluixBlock()
    {
        return get( "fluix_block" );
    }

    default IBlockDefinition<? extends Block> skyStoneBlock()
    {
        return get( "sky_stone_block" );
    }

    default IBlockDefinition<? extends Block> smoothSkyStoneBlock()
    {
        return get( "smooth_skystone" );
    }

    default IBlockDefinition<? extends Block> skyStoneBrick()
    {
        return get( "skystone_brick" );
    }

    default IBlockDefinition<? extends Block> skyStoneSmallBrick()
    {
        return get( "skystone_small_brick" );
    }

    default IBlockDefinition<? extends BlockStairCommon> skyStoneStairs()
    {
        return ( IBlockDefinition< ? extends BlockStairCommon > ) get( "skystone_stairs" );
    }

    default IBlockDefinition<? extends BlockStairCommon> smoothSkyStoneStairs()
    {
        return ( IBlockDefinition< ? extends BlockStairCommon > ) get( "smooth_skystone_stairs" );
    }

    default IBlockDefinition<? extends BlockStairCommon> skyStoneBrickStairs()
    {
        return ( IBlockDefinition< ? extends BlockStairCommon > ) get( "skystone_brick_stairs" );
    }

    default IBlockDefinition<? extends BlockStairCommon> skyStoneSmallBrickStairs()
    {
        return ( IBlockDefinition< ? extends BlockStairCommon > ) get( "skystone_small_brick_stairs" );
    }

    default IBlockDefinition<? extends BlockStairCommon> fluixStairs()
    {
        return ( IBlockDefinition< ? extends BlockStairCommon > ) get( "fluix_stairs" );
    }

    default IBlockDefinition<? extends BlockStairCommon> quartzStairs()
    {
        return ( IBlockDefinition< ? extends BlockStairCommon > ) get( "quartz_stairs" );
    }

    default IBlockDefinition<? extends BlockStairCommon> chiseledQuartzStairs()
    {
        return ( IBlockDefinition< ? extends BlockStairCommon > ) get( "chiseled_quartz_stairs" );
    }

    default IBlockDefinition<? extends BlockStairCommon> quartzPillarStairs()
    {
        return ( IBlockDefinition< ? extends BlockStairCommon > ) get( "quartz_pillar_stairs" );
    }


    
}
