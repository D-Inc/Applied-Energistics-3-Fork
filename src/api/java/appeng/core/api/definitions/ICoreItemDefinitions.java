
package appeng.core.api.definitions;


import net.minecraft.block.Block;
import net.minecraft.item.Item;

import appeng.api.definitions.IDefinition;
import appeng.api.definitions.IDefinitions;
import net.minecraft.item.ItemBlock;


public interface ICoreItemDefinitions extends IDefinitions<Item>
{

	default IDefinition<Item> crystalSeed()
	{
		return get( "crystal_seed" );
	}

	default IDefinition<Item> multiItem()
	{
		return get( "multiItem" );
	}

	default IDefinition<Item> blockCrank()
	{
		return get( "crank" );
	}

	default IDefinition<Item> blockCharger()
	{
		return get( "charger" );
	}

	default IDefinition<Item> blockGrinder()
	{
		return get( "grinder" );
	}

	default IDefinition<Item> blockInscriber()
	{
		return get( "inscriber" );
	}

	default IDefinition<Item> blockVibrationChamber()
	{
		return get( "vibration_chamber" );
	}

}
