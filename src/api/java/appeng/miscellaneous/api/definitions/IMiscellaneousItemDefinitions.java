
package appeng.miscellaneous.api.definitions;


import net.minecraft.item.Item;

import appeng.api.definitions.IDefinitions;
import appeng.api.definitions.IItemDefinition;
import net.minecraft.item.ItemBlock;


public interface IMiscellaneousItemDefinitions extends IDefinitions<Item, IItemDefinition<Item>>
{
    default IItemDefinition<Item > blockSkyCompass()
    {
        return get( "sky_compass" );
    }

    default IItemDefinition<Item> blockTinyTNT()
    {
        return get( "tiny_tnt" );
    }

    default IItemDefinition<Item> blockQuartzGrowthAccelerator()
    {
        return get( "quartz_growth_accelerator" );
    }

    default IItemDefinition<Item> blockLightDetector()
    {
        return get( "light_detector" );
    }

    default IItemDefinition<Item> blockPaint()
    {
        return get( "paint" );
    }
}
