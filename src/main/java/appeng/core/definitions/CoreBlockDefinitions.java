
package appeng.core.definitions;


import net.minecraft.block.Block;

import appeng.api.definitions.ITileDefinition;
import appeng.core.api.definitions.ICoreBlockDefinitions;
import appeng.core.block.BlockCrank;
import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.definitions.Definitions;
import appeng.core.lib.features.AEFeature;


public class CoreBlockDefinitions extends Definitions<Block> implements ICoreBlockDefinitions
{

	private final ITileDefinition crank;

	public CoreBlockDefinitions(FeatureFactory registry)
	{
		this.crank = registry.block( "crank", BlockCrank::new ).features( AEFeature.GrindStone ).build();
		init();
	}

}
