
package appeng.debug.definitions;


import net.minecraft.block.Block;

import appeng.api.definitions.IBlockDefinition;
import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.definitions.Definitions;


public class DebugBlockDefinitions extends Definitions<Block, IBlockDefinition<Block>>
{

	public DebugBlockDefinitions( FeatureFactory registry )
	{
		init();
	}

}
