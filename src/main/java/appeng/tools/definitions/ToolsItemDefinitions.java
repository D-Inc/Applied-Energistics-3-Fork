
package appeng.tools.definitions;


import net.minecraft.item.Item;

import appeng.api.definitions.IItemDefinition;
import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.definitions.Definitions;
import appeng.tools.api.definitions.IToolsItemDefinitions;


public class ToolsItemDefinitions extends Definitions<Item, IItemDefinition<Item>> implements IToolsItemDefinitions
{

	public ToolsItemDefinitions( FeatureFactory registry )
	{
		init();
	}

}
