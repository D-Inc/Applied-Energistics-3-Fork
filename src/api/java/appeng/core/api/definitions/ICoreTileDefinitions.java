
package appeng.core.api.definitions;


import appeng.api.definitions.ITileDefinition;
import net.minecraft.tileentity.TileEntity;

import appeng.api.definitions.IDefinition;
import appeng.api.definitions.IDefinitions;
import net.minecraft.tileentity.TileEntityBanner;


public interface ICoreTileDefinitions extends IDefinitions<Class<TileEntity>, ITileDefinition<TileEntity>>
{

    default ITileDefinition<TileEntity> tileCrank()
    {
        return get( "crank" );
    }

    default ITileDefinition<TileEntity> tileCharger()
    {
        return get( "charger" );
    }

    default ITileDefinition<TileEntity> tileGrinder()
    {
        return get( "grinder" );
    }

    default ITileDefinition<TileEntity> tileInscriber()
    {
        return get( "inscriber" );
    }

    default ITileDefinition<TileEntity> tileVibrationChamber()
    {
        return get( "vibration_chamber" );
    }


}
