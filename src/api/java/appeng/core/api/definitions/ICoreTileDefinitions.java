
package appeng.core.api.definitions;


import appeng.api.definitions.ITileDefinition;
import net.minecraft.tileentity.TileEntity;

import appeng.api.definitions.IDefinition;
import appeng.api.definitions.IDefinitions;

import java.sql.Time;


public interface ICoreTileDefinitions extends IDefinitions<ITileDefinition<? extends TileEntity>>
{

    default ITileDefinition<? extends TileEntity> tileCrank()
    {
        return get( "crank" );
    }

    default ITileDefinition<? extends TileEntity> tileCharger()
    {
        return get( "charger" );
    }

    default ITileDefinition<? extends TileEntity> tileGrinder()
    {
        return get( "grinder" );
    }

    default ITileDefinition<? extends TileEntity> tileInscriber()
    {
        return get( "inscriber" );
    }

    default ITileDefinition<? extends TileEntity> tileVibrationChamber()
    {
        return get( "vibration_chamber" );
    }


}
