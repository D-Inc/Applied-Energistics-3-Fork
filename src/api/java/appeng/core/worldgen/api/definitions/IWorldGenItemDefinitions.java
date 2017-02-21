
package appeng.core.worldgen.api.definitions;


import net.minecraft.item.Item;

import appeng.api.definitions.IDefinitions;
import appeng.api.definitions.IItemDefinition;
import net.minecraft.item.ItemBlock;


public interface IWorldGenItemDefinitions extends IDefinitions<Item, IItemDefinition<Item>>
{
    default IItemDefinition<Item> quartzOre()
    {
        return get( "quartz_ore" );
    }

    default IItemDefinition<Item> quartzOreCharged()
    {
        return get( "charged_quartz_ore" );
    }

    default IItemDefinition<Item> skyStoneChest()
    {
        return get( "skystone_chest" );
    }

    default IItemDefinition<Item> smoothSkyStoneChest()
    {
        return get( "smooth_skystone_chest" );
    }
}
