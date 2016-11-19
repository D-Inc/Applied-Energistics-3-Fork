
package appeng.core.crafting.api.definitions;


import appeng.api.definitions.IBlockDefinition;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

import appeng.api.definitions.IDefinitions;
import appeng.api.definitions.IItemDefinition;
import net.minecraft.item.ItemBlock;


public interface ICraftingItemDefinitions extends IDefinitions<Item, IItemDefinition<Item>>
{
    default IItemDefinition<? extends Item> itemEncodedPattern(){
        return get( "encoded_pattern" );
    }

    default IItemDefinition<? extends ItemBlock> blockCraftingMonitor(){
        return ( IItemDefinition< ? extends ItemBlock > ) get( "crafting_monitor" );
    }

    default IItemDefinition<? extends ItemBlock> blockCraftingStorage1k(){
        return ( IItemDefinition< ? extends ItemBlock > ) get( "crafting_storage_1k");
    }

    default IItemDefinition<? extends ItemBlock> blockCraftingStorage4k(){
        return ( IItemDefinition< ? extends ItemBlock > ) get( "crafting_storage_4k");
    }

    default IItemDefinition<? extends ItemBlock> blockCraftingStorage16k(){
        return ( IItemDefinition< ? extends ItemBlock > ) get( "crafting_storage_16k");
    }

    default IItemDefinition<? extends ItemBlock> blockCraftingStorage64k(){
        return ( IItemDefinition< ? extends ItemBlock > ) get( "crafting_storage_64k");
    }

    default IItemDefinition<? extends ItemBlock> blockCraftingUnit(){
        return ( IItemDefinition< ? extends ItemBlock > ) get( "crafting_unit");
    }

    default IItemDefinition<? extends ItemBlock > blockCraftingAccelerator(){
        return ( IItemDefinition< ? extends ItemBlock > ) get( "crafting_accelerator");
    }

    default IItemDefinition<? extends ItemBlock> blockMolecularAssembler(){
        return ( IItemDefinition< ? extends ItemBlock > ) get( "molecular_assembler" );
    }
}
