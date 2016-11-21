
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

	default IItemDefinition<? extends Item> blockQuartzBlock()
	{
		return get( "quartz_block" );
	}

	default IItemDefinition<? extends Item> blockQuartzPillar()
	{
		return get( "quartz_pillar" );
	}

	default IItemDefinition<? extends Item> blockChiseledQuartzBlock()
	{
		return get( "chiseled_quartz_block" );
	}

	default IItemDefinition<? extends Item> blockQuartzGlass()
	{
		return get( "quartz_glass" );
	}

	default IItemDefinition<? extends Item> blockQuartzVibrantGlass()
	{
		return get( "quartz_vibrant_glass" );
	}

	default IItemDefinition<? extends Item> blockQuartzFixture()
	{
		return get( "quartz_fixture" );
	}

	default IItemDefinition<? extends Item> blockFluixBlock()
	{
		return get( "fluix_block" );
	}

	default IItemDefinition<? extends Item> blockSkyStoneBlock()
	{
		return get( "sky_stone_block" );
	}

	default IItemDefinition<? extends Item> blockSmoothSkyStoneBlock()
	{
		return get( "smooth_skystone" );
	}

	default IItemDefinition<? extends Item> blockSkyStoneBrick()
	{
		return get( "skystone_brick" );
	}

	default IItemDefinition<? extends Item> blockSkyStoneSmallBrick()
	{
		return get( "skystone_small_brick" );
	}

	default IItemDefinition<? extends Item> blockSkyStoneStairs()
	{
		return get( "skystone_stairs" );
	}

	default IItemDefinition<? extends Item> blockSmoothSkyStoneStairs()
	{
		return get( "smooth_skystone_stairs" );
	}

	default IItemDefinition<? extends Item> blockSkyStoneBrickStairs()
	{
		return get( "skystone_brick_stairs" );
	}

	default IItemDefinition<? extends Item> blockSkyStoneSmallBrickStairs()
	{
		return get( "skystone_small_brick_stairs" );
	}

	default IItemDefinition<? extends Item> blockFluixStairs()
	{
		return get( "fluix_stairs" );
	}

	default IItemDefinition<? extends Item> blockQuartzStairs()
	{
		return get( "quartz_stairs" );
	}

	default IItemDefinition<? extends Item> blockChiseledQuartzStairs()
	{
		return get( "chiseled_quartz_stairs" );
	}

	default IItemDefinition<? extends Item> blockQuartzPillarStairs()
	{
		return get( "quartz_pillar_stairs" );
	}

}
