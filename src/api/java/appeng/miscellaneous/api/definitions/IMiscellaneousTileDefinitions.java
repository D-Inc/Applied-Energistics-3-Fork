
package appeng.miscellaneous.api.definitions;


import net.minecraft.tileentity.TileEntity;

import appeng.api.definitions.IDefinitions;
import appeng.api.definitions.ITileDefinition;


public interface IMiscellaneousTileDefinitions extends IDefinitions<Class<TileEntity>, ITileDefinition<TileEntity>>
{
    default ITileDefinition<? extends TileEntity> skyCompass()
    {
        return get( "sky_compass" );
    }

    default ITileDefinition<? extends TileEntity> tinyTNT()
    {
        return get( "tiny_tnt" );
    }

    default ITileDefinition<? extends TileEntity> quartzGrowthAccelerator()
    {
        return get( "quartz_growth_accelerator" );
    }

    default ITileDefinition<? extends TileEntity> lightDetector()
    {
        return get( "light_detector" );
    }

    default ITileDefinition<? extends TileEntity> paint()
    {
        return get( "paint" );
    }
}
