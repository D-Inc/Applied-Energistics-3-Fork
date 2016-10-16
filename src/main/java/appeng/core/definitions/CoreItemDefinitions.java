
package appeng.core.definitions;


import net.minecraft.item.Item;

import appeng.core.api.definitions.ICoreItemDefinitions;
import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.definitions.Definitions;


public class CoreItemDefinitions extends Definitions<Item> implements ICoreItemDefinitions
{

	public CoreItemDefinitions( FeatureFactory registry )
	{
		init();
	}

}
