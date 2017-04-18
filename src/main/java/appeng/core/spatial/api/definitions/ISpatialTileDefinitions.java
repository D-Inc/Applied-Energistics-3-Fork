
package appeng.core.spatial.api.definitions;


import net.minecraft.tileentity.TileEntity;

import appeng.api.definitions.IDefinitions;
import appeng.api.definitions.ITileDefinition;


public interface ISpatialTileDefinitions extends IDefinitions<Class<TileEntity>, ITileDefinition<TileEntity>>
{
    default ITileDefinition<TileEntity> spatialPylon()
    {
        return get( "spatial_pylon" );
    }

    default ITileDefinition<TileEntity> spatialIOPort()
    {
        return get( "spatial_ioport" );
    }

}
