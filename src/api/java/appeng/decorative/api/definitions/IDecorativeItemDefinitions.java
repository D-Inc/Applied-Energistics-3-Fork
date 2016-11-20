
package appeng.decorative.api.definitions;


import net.minecraft.item.Item;

import appeng.api.definitions.IDefinition;
import appeng.api.definitions.IDefinitions;
import appeng.api.definitions.IItemDefinition;
import net.minecraft.item.ItemBlock;


public interface IDecorativeItemDefinitions extends IDefinitions<Item, IItemDefinition<Item>>
{

	default IDefinition<? extends Item> paintBall()
	{
		return get( "paint_ball" );
	}

	default IDefinition<? extends Item> facade()
	{
		return get( "facade" );
	}

	default IItemDefinition<? extends ItemBlock> blockQuartzBlock()
	{
		return ( IItemDefinition<? extends ItemBlock> ) get( "quartz_block" );
	}

	default IItemDefinition<? extends ItemBlock> blockQuartzPillar()
	{
		return ( IItemDefinition<? extends ItemBlock> ) get( "quartz_pillar" );
	}

	default IItemDefinition<? extends ItemBlock> blockChiseledQuartzBlock()
	{
		return ( IItemDefinition<? extends ItemBlock> ) get( "chiseled_quartz_block" );
	}

	default IItemDefinition<? extends ItemBlock> blockQuartzGlass()
	{
		return ( IItemDefinition<? extends ItemBlock> ) get( "quartz_glass" );
	}

	default IItemDefinition<? extends ItemBlock> blockQuartzVibrantGlass()
	{
		return ( IItemDefinition<? extends ItemBlock> ) get( "quartz_vibrant_glass" );
	}

	default IItemDefinition<? extends ItemBlock> blockQuartzFixture()
	{
		return ( IItemDefinition<? extends ItemBlock> ) get( "quartz_fixture" );
	}

	default IItemDefinition<? extends ItemBlock> blockFluixBlock()
	{
		return ( IItemDefinition<? extends ItemBlock> ) get( "fluix_block" );
	}

	default IItemDefinition<? extends ItemBlock> blockSkyStoneBlock()
	{
		return ( IItemDefinition<? extends ItemBlock> ) get( "sky_stone_block" );
	}

	default IItemDefinition<? extends ItemBlock> blockSmoothSkyStoneBlock()
	{
		return ( IItemDefinition<? extends ItemBlock> ) get( "smooth_skystone" );
	}

	default IItemDefinition<? extends ItemBlock> blockSkyStoneBrick()
	{
		return ( IItemDefinition<? extends ItemBlock> ) get( "skystone_brick" );
	}

	default IItemDefinition<? extends ItemBlock> blockSkyStoneSmallBrick()
	{
		return ( IItemDefinition<? extends ItemBlock> ) get( "skystone_small_brick" );
	}

	default IItemDefinition<? extends ItemBlock> blockSkyStoneStairs()
	{
		return ( IItemDefinition<? extends ItemBlock> ) get( "skystone_stairs" );
	}

	default IItemDefinition<? extends ItemBlock> blockSmoothSkyStoneStairs()
	{
		return ( IItemDefinition<? extends ItemBlock> ) get( "smooth_skystone_stairs" );
	}

	default IItemDefinition<? extends ItemBlock> blockSkyStoneBrickStairs()
	{
		return ( IItemDefinition<? extends ItemBlock> ) get( "skystone_brick_stairs" );
	}

	default IItemDefinition<? extends ItemBlock> blockSkyStoneSmallBrickStairs()
	{
		return ( IItemDefinition<? extends ItemBlock> ) get( "skystone_small_brick_stairs" );
	}

	default IItemDefinition<? extends ItemBlock> blockFluixStairs()
	{
		return ( IItemDefinition<? extends ItemBlock> ) get( "fluix_stairs" );
	}

	default IItemDefinition<? extends ItemBlock> blockQuartzStairs()
	{
		return ( IItemDefinition<? extends ItemBlock> ) get( "quartz_stairs" );
	}

	default IItemDefinition<? extends ItemBlock> blockChiseledQuartzStairs()
	{
		return ( IItemDefinition<? extends ItemBlock> ) get( "chiseled_quartz_stairs" );
	}

	default IItemDefinition<? extends ItemBlock> blockQuartzPillarStairs()
	{
		return ( IItemDefinition<? extends ItemBlock> ) get( "quartz_pillar_stairs" );
	}

}
