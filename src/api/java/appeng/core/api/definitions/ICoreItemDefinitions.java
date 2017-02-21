
package appeng.core.api.definitions;


import net.minecraft.item.Item;

import appeng.api.definitions.IDefinitions;
import appeng.api.definitions.IItemDefinition;


public interface ICoreItemDefinitions extends IDefinitions<Item, IItemDefinition<Item>>
{

	default IItemDefinition<? extends Item> crystalSeed()
	{
		return get( "crystal_seed" );
	}

	default IItemDefinition<? extends Item> material()
	{
		return get( "material" );
	}

	default IItemDefinition<? extends Item> blockCrank()
	{
		return get( "crank" );
	}

	default IItemDefinition<? extends Item> blockCharger()
	{
		return get( "charger" );
	}

	default IItemDefinition<? extends Item> blockGrinder()
	{
		return get( "grinder" );
	}

	default IItemDefinition<? extends Item> blockInscriber()
	{
		return get( "inscriber" );
	}

	default IItemDefinition<? extends Item> blockVibrationChamber()
	{
		return get( "vibration_chamber" );
	}

}
