
package appeng.core.worldgen.api.definitions;


import net.minecraft.tileentity.TileEntity;

import appeng.api.definitions.IDefinitions;
import appeng.api.definitions.ITileDefinition;


public interface IWorldGenTileDefinitions extends IDefinitions<Class<? extends TileEntity>, ITileDefinition<? extends TileEntity>>
{
    default ITileDefinition<? extends TileEntity> skyStoneChest()
    {
        return get( "skystone_chest" );
    }
}
