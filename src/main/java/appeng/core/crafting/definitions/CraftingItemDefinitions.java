
package appeng.core.crafting.definitions;


import net.minecraft.item.Item;

import appeng.api.definitions.IItemDefinition;
import appeng.core.crafting.api.definitions.ICraftingItemDefinitions;
import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.definitions.Definitions;


public class CraftingItemDefinitions extends Definitions<Item, IItemDefinition<Item>> implements ICraftingItemDefinitions
{

	public CraftingItemDefinitions( FeatureFactory registry )
	{
		init();
	}

}
