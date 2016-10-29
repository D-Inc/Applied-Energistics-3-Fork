
package appeng.core.api.definitions;


import appeng.api.definitions.IDefinition;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;

import appeng.api.definitions.IDefinitions;


public interface ICoreTileDefinitions extends IDefinitions<Class<? extends TileEntity>>
{

    default IDefinition<Class<? extends TileEntity>> blockCrank()
    {
        return get( "crank" );
    }

    default IDefinition<Class<? extends TileEntity>> blockCharger()
    {
        return get( "charger" );
    }

    default IDefinition<Class<? extends TileEntity>> blockGrinder()
    {
        return get( "grinder" );
    }

    default IDefinition<Class<? extends TileEntity>> blockInscriber()
    {
        return get( "inscriber" );
    }

    default IDefinition<Class<? extends TileEntity>> blockVibrationChamber()
    {
        return get( "vibration_chamber" );
    }


}
