
package appeng.core.spatial.definitions;


import net.minecraft.block.Block;

import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.definitions.Definitions;
import appeng.core.spatial.api.definitions.ISpatialBlockDefinitions;


public class SpatialBlockDefinitions extends Definitions<Block> implements ISpatialBlockDefinitions
{

	public SpatialBlockDefinitions( FeatureFactory registry )
	{
		init();
	}

}
