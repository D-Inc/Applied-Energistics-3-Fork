
package appeng.core.spatial.definitions;


import net.minecraft.block.Block;

import appeng.api.definitions.IBlockDefinition;
import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.definitions.Definitions;
import appeng.core.spatial.api.definitions.ISpatialBlockDefinitions;


public class SpatialBlockDefinitions extends Definitions<Block, IBlockDefinition<Block>> implements ISpatialBlockDefinitions
{

	public SpatialBlockDefinitions( FeatureFactory registry )
	{
		init();
	}

}
