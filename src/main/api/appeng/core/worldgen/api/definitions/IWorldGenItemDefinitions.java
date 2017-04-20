
package appeng.core.worldgen.api.definitions;


import net.minecraft.item.Item;

import appeng.api.definitions.IDefinitions;
import appeng.api.definitions.IItemDefinition;


public interface IWorldGenItemDefinitions extends IDefinitions<Item, IItemDefinition<Item>>
{
    default IItemDefinition<Item> blockQuartzOre()
    {
        return get( "quartz_ore" );
    }

    default IItemDefinition<Item> blockQuartzOreCharged()
    {
        return get( "charged_quartz_ore" );
    }

    default IItemDefinition<Item> SSkyStoneChest()
    {
        return get( "skystone_chest" );
    }

    default IItemDefinition<Item> blockSmoothSkyStoneChest()
    {
        return get( "smooth_skystone_chest" );
    }
    
    default IItemDefinition<Item> blocketeoriteCompass()
    {
        return get( "meteorite_compass" );
    }
}
