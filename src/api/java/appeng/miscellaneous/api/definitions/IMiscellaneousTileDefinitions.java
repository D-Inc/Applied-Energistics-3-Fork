
package appeng.miscellaneous.api.definitions;


import net.minecraft.tileentity.TileEntity;

import appeng.api.definitions.IDefinitions;
import appeng.api.definitions.ITileDefinition;


public interface IMiscellaneousTileDefinitions extends IDefinitions<Class<TileEntity>, ITileDefinition<TileEntity>>
{
    default ITileDefinition<TileEntity> skyCompass()
    {
        return get( "sky_compass" );
    }

    default ITileDefinition<TileEntity> tinyTNT()
    {
        return get( "tiny_tnt" );
    }

    default ITileDefinition<TileEntity> quartzGrowthAccelerator()
    {
        return get( "quartz_growth_accelerator" );
    }

    default ITileDefinition<TileEntity> lightDetector()
    {
        return get( "light_detector" );
    }

    default ITileDefinition<TileEntity> paint()
    {
        return get( "paint" );
    }
}
