
package appeng.core.crafting.api.definitions;


import net.minecraft.item.Item;

import appeng.api.definitions.IDefinitions;
import appeng.api.definitions.IItemDefinition;


public interface ICraftingItemDefinitions extends IDefinitions<Item, IItemDefinition<Item>>
{

	default IItemDefinition<? extends Item> encodedPattern()
	{
		return get( "encoded_pattern" );
	}

	default IItemDefinition<? extends Item> blockCraftingMonitor()
	{
		return get( "crafting_monitor" );
	}

	default IItemDefinition<? extends Item> blockCraftingStorage1k()
	{
		return get( "crafting_storage_1k" );
	}

	default IItemDefinition<? extends Item> blockCraftingStorage4k()
	{
		return get( "crafting_storage_4k" );
	}

	default IItemDefinition<? extends Item> blockCraftingStorage16k()
	{
		return get( "crafting_storage_16k" );
	}

	default IItemDefinition<? extends Item> blockCraftingStorage64k()
	{
		return get( "crafting_storage_64k" );
	}

	default IItemDefinition<? extends Item> blockCraftingUnit()
	{
		return get( "crafting_unit" );
	}

	default IItemDefinition<? extends Item> blockCraftingAccelerator()
	{
		return get( "crafting_accelerator" );
	}

	default IItemDefinition<? extends Item> blockMolecularAssembler()
	{
		return get( "molecular_assembler" );
	}

}
