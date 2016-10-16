
package appeng.core.spatial.definitions;


import net.minecraft.item.Item;

import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.definitions.Definitions;
import appeng.core.spatial.api.definitions.ISpatialItemDefinitions;


public class SpatialItemDefinitions extends Definitions<Item> implements ISpatialItemDefinitions
{

	public SpatialItemDefinitions( FeatureFactory registry )
	{
		init();
	}

}
