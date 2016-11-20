
package appeng.core.worldgen.api.definitions;


import net.minecraft.item.Item;

import appeng.api.definitions.IDefinitions;
import appeng.api.definitions.IItemDefinition;
import net.minecraft.item.ItemBlock;


public interface IWorldGenItemDefinitions extends IDefinitions<Item, IItemDefinition<Item>>
{
    default IItemDefinition<? extends ItemBlock > quartzOre()
    {
        return ( IItemDefinition< ? extends ItemBlock > ) get( "quartz_ore" );
    }

    default IItemDefinition<? extends ItemBlock> quartzOreCharged()
    {
        return ( IItemDefinition< ? extends ItemBlock > ) get( "charged_quartz_ore" );
    }

    default IItemDefinition<? extends ItemBlock> skyStoneChest()
    {
        return ( IItemDefinition< ? extends ItemBlock > ) get( "skystone_chest" );
    }

    default IItemDefinition<? extends ItemBlock> smoothSkyStoneChest()
    {
        return ( IItemDefinition< ? extends ItemBlock > ) get( "smooth_skystone_chest" );
    }
}
