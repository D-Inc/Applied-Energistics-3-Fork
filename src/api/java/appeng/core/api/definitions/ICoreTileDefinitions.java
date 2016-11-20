
package appeng.core.api.definitions;


import net.minecraft.tileentity.TileEntity;

import appeng.api.definitions.IDefinitions;
import appeng.api.definitions.ITileDefinition;


public interface ICoreTileDefinitions extends IDefinitions<Class<? extends TileEntity>, ITileDefinition<? extends TileEntity, Class<? extends TileEntity>>>
{

    default ITileDefinition<? extends TileEntity, ? extends Class<? extends TileEntity>> blockCrank()
    {
        return get( "crank" );
    }

    default ITileDefinition<? extends TileEntity, ? extends Class<? extends TileEntity>> blockCharger()
    {
        return get( "charger" );
    }

    default ITileDefinition<? extends TileEntity, ? extends Class<? extends TileEntity>> blockGrinder()
    {
        return get( "grinder" );
    }

    default ITileDefinition<? extends TileEntity, ? extends Class<? extends TileEntity>> blockInscriber()
    {
        return get( "inscriber" );
    }

    default ITileDefinition<? extends TileEntity, ? extends Class<? extends TileEntity>> blockVibrationChamber()
    {
        return get( "vibration_chamber" );
    }


}
