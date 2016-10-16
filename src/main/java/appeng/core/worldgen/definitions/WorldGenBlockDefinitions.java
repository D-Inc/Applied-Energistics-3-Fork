
package appeng.core.worldgen.definitions;


import net.minecraft.block.Block;

import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.definitions.Definitions;
import appeng.core.worldgen.api.definitions.IWorldGenBlockDefinitions;


public class WorldGenBlockDefinitions extends Definitions<Block> implements IWorldGenBlockDefinitions
{

	public WorldGenBlockDefinitions( FeatureFactory registry )
	{
		init();
	}

}
