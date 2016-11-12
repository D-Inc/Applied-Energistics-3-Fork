
package appeng.core.api.definitions;


import appeng.api.definitions.IItemDefinition;
import net.minecraft.item.Item;

import appeng.api.definitions.IDefinition;
import appeng.api.definitions.IDefinitions;
import net.minecraft.item.ItemBlock;


public interface ICoreItemDefinitions extends IDefinitions<Item, IItemDefinition<Item>>
{

	default IItemDefinition<Item> crystalSeed()
	{
		return get( "crystal_seed" );
	}

	default IItemDefinition<Item> multiItem()
	{
		return get( "multiItem" );
	}

	default IItemDefinition<ItemBlock> blockCrank()
	{
		return ( IItemDefinition<ItemBlock> ) get( "crank" );
	}

	default IItemDefinition<ItemBlock> blockCharger()
	{
		return ( IItemDefinition<ItemBlock> ) get( "charger" );
	}

	default IItemDefinition<ItemBlock> blockGrinder()
	{
		return ( IItemDefinition<ItemBlock> ) get( "grinder" );
	}

	default IItemDefinition<ItemBlock> blockInscriber()
	{
		return ( IItemDefinition<ItemBlock> ) get( "inscriber" );
	}

	default IItemDefinition<ItemBlock> blockVibrationChamber()
	{
		return ( IItemDefinition<ItemBlock> ) get( "vibration_chamber" );
	}

}
