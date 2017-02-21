
package appeng.core.crafting.api.definitions;


import net.minecraft.item.Item;

import appeng.api.definitions.IDefinitions;
import appeng.api.definitions.IItemDefinition;


public interface ICraftingItemDefinitions extends IDefinitions<Item, IItemDefinition<Item>>
{

	default IItemDefinition<Item> encodedPattern()
	{
		return get( "encoded_pattern" );
	}

	default IItemDefinition<Item> blockCraftingMonitor()
	{
		return get( "crafting_monitor" );
	}

	default IItemDefinition<Item> blockCraftingStorage1k()
	{
		return get( "crafting_storage_1k" );
	}

	default IItemDefinition<Item> blockCraftingStorage4k()
	{
		return get( "crafting_storage_4k" );
	}

	default IItemDefinition<Item> blockCraftingStorage16k()
	{
		return get( "crafting_storage_16k" );
	}

	default IItemDefinition<Item> blockCraftingStorage64k()
	{
		return get( "crafting_storage_64k" );
	}

	default IItemDefinition<Item> blockCraftingUnit()
	{
		return get( "crafting_unit" );
	}

	default IItemDefinition<Item> blockCraftingAccelerator()
	{
		return get( "crafting_accelerator" );
	}

	default IItemDefinition<Item> blockMolecularAssembler()
	{
		return get( "molecular_assembler" );
	}

}
