
package appeng.core.crafting.api.definitions;


import net.minecraft.block.Block;

import appeng.api.definitions.IBlockDefinition;
import appeng.api.definitions.IDefinitions;


public interface ICraftingBlockDefinitions extends IDefinitions<Block, IBlockDefinition<Block>>
{
    default IBlockDefinition<? extends Block> blockCraftingMonitor(){
        return get( "crafting_monitor" );
    }

    default IBlockDefinition<? extends Block> blockCraftingStorage1k(){
        return get( "crafting_storage_1k");
    }

    default IBlockDefinition<? extends Block> blockCraftingStorage4k(){
        return get( "crafting_storage_4k");
    }

    default IBlockDefinition<? extends Block> blockCraftingStorage16k(){
        return get( "crafting_storage_16k");
    }

    default IBlockDefinition<? extends Block> blockCraftingStorage64k(){
        return get( "crafting_storage_64k");
    }

    default IBlockDefinition<? extends Block> blockCraftingUnit(){
        return get( "crafting_unit");
    }

    default IBlockDefinition<? extends Block> blockCraftingAccelerator(){
        return get( "crafting_accelerator");
    }

    default IBlockDefinition<? extends Block> blockMolecularAssembler(){
        return get( "molecular_assembler" );
    }
}
