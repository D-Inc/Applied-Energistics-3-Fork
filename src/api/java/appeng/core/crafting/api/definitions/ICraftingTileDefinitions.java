
package appeng.core.crafting.api.definitions;

import net.minecraft.tileentity.TileEntity;

import appeng.api.definitions.IDefinitions;
import appeng.api.definitions.ITileDefinition;


public interface ICraftingTileDefinitions extends IDefinitions<Class<TileEntity>, ITileDefinition<TileEntity>>
{

    default ITileDefinition<TileEntity> craftingMonitor(){
        return get( "crafting_monitor ");
    }

    default ITileDefinition<TileEntity> craftingStorage(){
        return get( "crafting_storage" );
    }

    default ITileDefinition<TileEntity> craftingUnit(){
        return get( "crafting_unit" );
    }

    default ITileDefinition<TileEntity> molecularAssembler(){
        return get( "molecular_assembler" );
    }


}
