
package appeng.debug.definitions;


import net.minecraft.item.Item;

import appeng.api.definitions.IItemDefinition;
import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.definitions.Definitions;


public class DebugItemDefinitions extends Definitions<Item, IItemDefinition<Item>>
{

	public DebugItemDefinitions( FeatureFactory registry )
	{
		init();
	}

}
