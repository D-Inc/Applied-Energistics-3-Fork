
package appeng.core.crafting.api.definitions;


import net.minecraft.block.Block;

import appeng.api.definitions.IBlockDefinition;
import appeng.api.definitions.IDefinitions;


public interface ICraftingBlockDefinitions extends IDefinitions<Block, IBlockDefinition<Block>>
{
    default IBlockDefinition<? extends Block> craftingMonitor(){
        return get( "crafting_monitor" );
    }

    default IBlockDefinition<? extends Block> craftingStorage1k(){
        return get( "crafting_storage_1k");
    }

    default IBlockDefinition<? extends Block> craftingStorage4k(){
        return get( "crafting_storage_4k");
    }

    default IBlockDefinition<? extends Block> craftingStorage16k(){
        return get( "crafting_storage_16k");
    }

    default IBlockDefinition<? extends Block> craftingStorage64k(){
        return get( "crafting_storage_64k");
    }

    default IBlockDefinition<? extends Block> craftingUnit(){
        return get( "crafting_unit");
    }

    default IBlockDefinition<? extends Block> craftingAccelerator(){
        return get( "crafting_accelerator");
    }

    default IBlockDefinition<? extends Block> molecularAssembler(){
        return get( "molecular_assembler" );
    }
}
