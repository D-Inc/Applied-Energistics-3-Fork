
package appeng.miscellaneous.api.definitions;


import net.minecraft.item.Item;

import appeng.api.definitions.IDefinitions;
import appeng.api.definitions.IItemDefinition;
import net.minecraft.item.ItemBlock;


public interface IMiscellaneousItemDefinitions extends IDefinitions<Item, IItemDefinition<Item>>
{
    default IItemDefinition<? extends ItemBlock > blockSkyCompass()
    {
        return ( IItemDefinition< ? extends ItemBlock > ) get( "sky_compass" );
    }

    default IItemDefinition<? extends ItemBlock> blockTinyTNT()
    {
        return ( IItemDefinition< ? extends ItemBlock > ) get( "tiny_tnt" );
    }

    default IItemDefinition<? extends ItemBlock> blockQuartzGrowthAccelerator()
    {
        return ( IItemDefinition< ? extends ItemBlock > ) get( "quartz_growth_accelerator" );
    }

    default IItemDefinition<? extends ItemBlock> blockLightDetector()
    {
        return ( IItemDefinition< ? extends ItemBlock > ) get( "light_detector" );
    }

    default IItemDefinition<? extends ItemBlock> blockPaint()
    {
        return ( IItemDefinition< ? extends ItemBlock > ) get( "paint" );
    }
}
