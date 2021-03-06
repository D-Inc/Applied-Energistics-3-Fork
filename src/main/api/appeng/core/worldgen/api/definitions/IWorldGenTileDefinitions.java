
package appeng.core.worldgen.api.definitions;


import net.minecraft.tileentity.TileEntity;

import appeng.api.definitions.IDefinitions;
import appeng.api.definitions.ITileDefinition;


public interface IWorldGenTileDefinitions extends IDefinitions<Class<TileEntity>, ITileDefinition<TileEntity>>
{
	default ITileDefinition<TileEntity> skyStoneChest()
    {
        return get( "skystone_chest" );
    }
	
	default ITileDefinition<TileEntity> skyCompass()
    {
        return get( "sky_compass" );
    }
	
}
