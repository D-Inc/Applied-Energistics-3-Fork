
package appeng.tools.definitions;


import net.minecraft.block.Block;

import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.definitions.Definitions;
import appeng.tools.api.definitions.IToolsBlockDefinitions;


public class ToolsBlockDefinitions extends Definitions<Block> implements IToolsBlockDefinitions
{

	public ToolsBlockDefinitions( FeatureFactory registry )
	{
		init();
	}

}
