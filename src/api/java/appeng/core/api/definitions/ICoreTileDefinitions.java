
package appeng.core.api.definitions;


import net.minecraft.tileentity.TileEntity;

import appeng.api.definitions.IDefinitions;
import appeng.api.definitions.ITileDefinition;


public interface ICoreTileDefinitions extends IDefinitions<Class<TileEntity>, ITileDefinition<TileEntity>>
{

    default ITileDefinition<? extends TileEntity> crank()
    {
        return get( "crank" );
    }

    default ITileDefinition<? extends TileEntity> charger()
    {
        return get( "charger" );
    }

    default ITileDefinition<? extends TileEntity> grinder()
    {
        return get( "grinder" );
    }

    default ITileDefinition<? extends TileEntity> inscriber()
    {
        return get( "inscriber" );
    }

    default ITileDefinition<? extends TileEntity> vibrationChamber()
    {
        return get( "vibration_chamber" );
    }


}
