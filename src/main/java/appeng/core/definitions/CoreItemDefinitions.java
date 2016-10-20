
package appeng.core.definitions;


import appeng.api.definitions.IItemDefinition;
import appeng.core.lib.features.ItemDefinition;
import net.minecraft.item.Item;

import appeng.core.api.definitions.ICoreItemDefinitions;
import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.definitions.Definitions;


public class CoreItemDefinitions extends Definitions<Item> implements ICoreItemDefinitions
{

//	private final ItemDefinition

	public CoreItemDefinitions( FeatureFactory registry )
	{
		init();
	}

}
