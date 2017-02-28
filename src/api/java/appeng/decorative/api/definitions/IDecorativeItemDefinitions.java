
package appeng.decorative.api.definitions;


import net.minecraft.item.Item;

import appeng.api.definitions.IDefinitions;
import appeng.api.definitions.IItemDefinition;


public interface IDecorativeItemDefinitions extends IDefinitions<Item, IItemDefinition<Item>>
{

	default IItemDefinition<Item> paintBall()
	{
		return get( "paintBall" );
	}

	default IItemDefinition<Item> colorApplicator()
	{
		return get( "colorApplicator" );
	}



	default IItemDefinition<Item> blockQuartzItem()
	{
		return get( "quartz_block" );
	}

	default IItemDefinition<Item> blockQuartzPillar()
	{
		return get( "quartz_pillar" );
	}

	default IItemDefinition<Item> blockChiseledQuartzItem()
	{
		return get( "chiseled_quartz_block" );
	}

	default IItemDefinition<Item> blockQuartzFixture()
	{
		return get( "quartz_fixture" );
	}

	default IItemDefinition<Item> blockFluixItem()
	{
		return get( "fluix_block" );
	}

	default IItemDefinition<Item> blockSkyStoneItem()
	{
		return get( "sky_stone_block" );
	}

	default IItemDefinition<Item> blockSkyStoneBrick()
	{
		return get( "sky_stone_brick" );
	}

	default IItemDefinition<Item> blockSkyStoneSmallBrick()
	{
		return get( "sky_stone_small_brick" );
	}

	default IItemDefinition<Item> blockSkyStoneStairs()
	{
		return get( "sky_stone_stairs" );
	}

	default IItemDefinition<Item> blockSmoothSkyStoneStairs()
	{
		return get( "smooth_sky_stone_stairs" );
	}

	default IItemDefinition<Item> blockSkyStoneBrickStairs()
	{
		return get( "sky_stone_brick_stairs" );
	}

	default IItemDefinition<Item> blockSkyStoneSmallBrickStairs()
	{
		return get( "sky_stone_small_brick_stairs" );
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

	default IItemDefinition<Item> blockPaint()
	{
		return get( "paint" );
	}
}
