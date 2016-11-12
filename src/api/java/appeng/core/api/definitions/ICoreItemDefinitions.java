
package appeng.core.api.definitions;


import net.minecraft.item.Item;

import appeng.api.definitions.IDefinition;
import appeng.api.definitions.IDefinitions;
import net.minecraft.item.ItemBlock;


public interface ICoreItemDefinitions extends IDefinitions<Item>
{

	default IDefinition<? extends Item> crystalSeed()
	{
		return get( "crystal_seed" );
	}

	default IDefinition<? extends Item> multiItem()
	{
		return get( "multiItem" );
	}

	default IDefinition<ItemBlock> blockCrank()
	{
		return ( IDefinition<ItemBlock> ) get( "crank" );
	}

	default IDefinition<ItemBlock> blockCharger()
	{
		return ( IDefinition<ItemBlock> ) get( "charger" );
	}

	default IDefinition<ItemBlock> blockGrinder()
	{
		return ( IDefinition<ItemBlock> ) get( "grinder" );
	}

	default IDefinition<ItemBlock> blockInscriber()
	{
		return ( IDefinition<ItemBlock> ) get( "inscriber" );
	}

	default IDefinition<ItemBlock> blockVibrationChamber()
	{
		return ( IDefinition<ItemBlock> ) get( "vibration_chamber" );
	}

}
