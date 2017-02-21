
package appeng.core.api.definitions;


import net.minecraft.item.Item;

import appeng.api.definitions.IDefinitions;
import appeng.api.definitions.IItemDefinition;


public interface ICoreItemDefinitions extends IDefinitions<Item, IItemDefinition<Item>>
{

	default IItemDefinition<Item> crystalSeed()
	{
		return get( "crystal_seed" );
	}

	default IItemDefinition<Item> material()
	{
		return get( "material" );
	}

	default IItemDefinition<Item> blockCrank()
	{
		return get( "crank" );
	}

	default IItemDefinition<Item> blockCharger()
	{
		return get( "charger" );
	}

	default IItemDefinition<Item> blockGrinder()
	{
		return get( "grinder" );
	}

	default IItemDefinition<Item> blockInscriber()
	{
		return get( "inscriber" );
	}

	default IItemDefinition<Item> blockVibrationChamber()
	{
		return get( "vibration_chamber" );
	}

}
