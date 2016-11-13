
package appeng.core.worldgen.definitions;


import net.minecraft.block.Block;

import appeng.api.definitions.IBlockDefinition;
import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.definitions.Definitions;
import appeng.core.worldgen.api.definitions.IWorldGenBlockDefinitions;


public class WorldGenBlockDefinitions extends Definitions<Block, IBlockDefinition<Block>> implements IWorldGenBlockDefinitions
{

	public WorldGenBlockDefinitions( FeatureFactory registry )
	{
		init();
	}

}
