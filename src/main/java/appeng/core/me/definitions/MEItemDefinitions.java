
package appeng.core.me.definitions;


import net.minecraft.item.Item;

import appeng.api.definitions.IItemDefinition;
import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.definitions.Definitions;
import appeng.core.me.api.definitions.IMEItemDefinitions;


public class MEItemDefinitions extends Definitions<Item, IItemDefinition<Item>> implements IMEItemDefinitions
{

	public MEItemDefinitions( FeatureFactory registry )
	{
		init();
	}

}
