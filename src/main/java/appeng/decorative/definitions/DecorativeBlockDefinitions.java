
package appeng.decorative.definitions;


import net.minecraft.block.Block;

import appeng.api.definitions.IBlockDefinition;
import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.definitions.Definitions;
import appeng.decorative.api.definitions.IDecorativeBlockDefinitions;


public class DecorativeBlockDefinitions extends Definitions<Block, IBlockDefinition<Block>> implements IDecorativeBlockDefinitions
{

	public DecorativeBlockDefinitions( FeatureFactory registry )
	{
		init();
	}

}
