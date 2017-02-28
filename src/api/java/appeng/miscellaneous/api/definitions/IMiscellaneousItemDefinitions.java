
package appeng.miscellaneous.api.definitions;


import net.minecraft.item.Item;

import appeng.api.definitions.IDefinitions;
import appeng.api.definitions.IItemDefinition;
import net.minecraft.item.ItemBlock;


public interface IMiscellaneousItemDefinitions extends IDefinitions<Item, IItemDefinition<Item>>
{

    default IItemDefinition<Item> blockLightDetector()
    {
        return get( "light_detecting_fixture" );
    }

}
