
package appeng.core.api.definitions;


import net.minecraft.tileentity.TileEntity;

import appeng.api.definitions.IDefinitions;
import appeng.api.definitions.ITileDefinition;


public interface ICoreTileDefinitions extends IDefinitions<Class<TileEntity>, ITileDefinition<TileEntity>>
{

    default ITileDefinition<TileEntity> crank()
    {
        return get( "crank" );
    }

    default ITileDefinition<TileEntity> charger()
    {
        return get( "charger" );
    }

    default ITileDefinition<TileEntity> grinder()
    {
        return get( "grinder" );
    }

    default ITileDefinition<TileEntity> inscriber()
    {
        return get( "inscriber" );
    }

    default ITileDefinition<TileEntity> vibrationChamber()
    {
        return get( "vibration_chamber" );
    }


}
