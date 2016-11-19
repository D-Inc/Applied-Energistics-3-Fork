
package appeng.core.crafting.api.definitions;

import net.minecraft.tileentity.TileEntity;

import appeng.api.definitions.IDefinitions;
import appeng.api.definitions.ITileDefinition;


public interface ICraftingTileDefinitions extends IDefinitions<Class<? extends TileEntity>, ITileDefinition<? extends TileEntity, Class<? extends TileEntity>>>
{

    default ITileDefinition tileCraftingMonitor(){
        return get( "crafting_monitor ");
    }

    default ITileDefinition tileCraftingStorage(){
        return get( "crafting_storage" );
    }

    default ITileDefinition tileCraftingUnit(){
        return get( "crafting_unit" );
    }

    default ITileDefinition tileMolecularAssembler(){
        return get( "molecular_assembler" );
    }


}
