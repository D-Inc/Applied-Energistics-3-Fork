
package appeng.decorative.api.definitions;


import net.minecraft.item.Item;

import appeng.api.definitions.IDefinition;
import appeng.api.definitions.IDefinitions;
import appeng.api.definitions.IItemDefinition;
import net.minecraft.item.ItemBlock;


public interface IDecorativeItemDefinitions extends IDefinitions<Item, IItemDefinition<Item>>
{

	default IDefinition<Item> paintBall()
	{
		return get( "paint_ball" );
	}

	default IDefinition<Item> facade()
	{
		return get( "facade" );
	}

	default IItemDefinition<Item> blockQuartzBlock()
	{
		return get( "quartz_block" );
	}

	default IItemDefinition<Item> blockQuartzPillar()
	{
		return get( "quartz_pillar" );
	}

	default IItemDefinition<Item> blockChiseledQuartzBlock()
	{
		return get( "chiseled_quartz_block" );
	}

	default IItemDefinition<Item> blockQuartzGlass()
	{
		return get( "quartz_glass" );
	}

	default IItemDefinition<Item> blockQuartzVibrantGlass()
	{
		return get( "quartz_vibrant_glass" );
	}

	default IItemDefinition<Item> blockQuartzFixture()
	{
		return get( "quartz_fixture" );
	}

	default IItemDefinition<Item> blockFluixBlock()
	{
		return get( "fluix_block" );
	}

	default IItemDefinition<Item> blockSkyStoneBlock()
	{
		return get( "sky_stone_block" );
	}

	default IItemDefinition<Item> blockSmoothSkyStoneBlock()
	{
		return get( "smooth_skystone" );
	}

	default IItemDefinition<Item> blockSkyStoneBrick()
	{
		return get( "skystone_brick" );
	}

	default IItemDefinition<Item> blockSkyStoneSmallBrick()
	{
		return get( "skystone_small_brick" );
	}

	default IItemDefinition<Item> blockSkyStoneStairs()
	{
		return get( "skystone_stairs" );
	}

	default IItemDefinition<Item> blockSmoothSkyStoneStairs()
	{
		return get( "smooth_skystone_stairs" );
	}

	default IItemDefinition<Item> blockSkyStoneBrickStairs()
	{
		return get( "skystone_brick_stairs" );
	}

	default IItemDefinition<Item> blockSkyStoneSmallBrickStairs()
	{
		return get( "skystone_small_brick_stairs" );
	}

	default IItemDefinition<Item> blockFluixStairs()
	{
		return get( "fluix_stairs" );
	}

	default IItemDefinition<Item> blockQuartzStairs()
	{
		return get( "quartz_stairs" );
	}

	default IItemDefinition<Item> blockChiseledQuartzStairs()
	{
		return get( "chiseled_quartz_stairs" );
	}

	default IItemDefinition<Item> blockQuartzPillarStairs()
	{
		return get( "quartz_pillar_stairs" );
	}

}
