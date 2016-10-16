
package appeng.core.me.definitions;


import net.minecraft.block.Block;

import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.definitions.Definitions;
import appeng.core.me.api.definitions.IMEBlockDefinitions;


public class MEBlockDefinitions extends Definitions<Block> implements IMEBlockDefinitions
{

	public MEBlockDefinitions( FeatureFactory registry )
	{
		init();
	}

}
