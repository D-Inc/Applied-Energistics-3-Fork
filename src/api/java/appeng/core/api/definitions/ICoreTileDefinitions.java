
package appeng.core.api.definitions;


import net.minecraft.tileentity.TileEntity;

import appeng.api.definitions.IDefinition;
import appeng.api.definitions.IDefinitions;


public interface ICoreTileDefinitions extends IDefinitions<Class<? extends TileEntity>>
{

    default IDefinition<? extends Class<? extends TileEntity>> blockCrank()
    {
        return get( "crank" );
    }

    default IDefinition<? extends Class<? extends TileEntity>> blockCharger()
    {
        return get( "charger" );
    }

    default IDefinition<? extends Class<? extends TileEntity>> blockGrinder()
    {
        return get( "grinder" );
    }

    default IDefinition<? extends Class<? extends TileEntity>> blockInscriber()
    {
        return get( "inscriber" );
    }

    default IDefinition<? extends Class<? extends TileEntity>> blockVibrationChamber()
    {
        return get( "vibration_chamber" );
    }


}
