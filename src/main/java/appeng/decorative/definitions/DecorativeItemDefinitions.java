
package appeng.decorative.definitions;


import net.minecraft.item.Item;

import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.definitions.Definitions;
import appeng.decorative.api.definitions.IDecorativeItemDefinitions;


public class DecorativeItemDefinitions extends Definitions<Item> implements IDecorativeItemDefinitions
{

	public DecorativeItemDefinitions( FeatureFactory registry )
	{
		init();
	}

}
