
package appeng.core.spatial.definitions;


import net.minecraft.block.Block;

import appeng.api.definitions.IBlockDefinition;
import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.definitions.Definitions;
import appeng.core.lib.features.AEFeature;
import appeng.core.spatial.api.definitions.ISpatialBlockDefinitions;
import appeng.core.spatial.block.BlockMatrixFrame;


public class SpatialBlockDefinitions extends Definitions<Block, IBlockDefinition<Block>> implements ISpatialBlockDefinitions
{

	private final IBlockDefinition matrixFrame;
	
	public SpatialBlockDefinitions( FeatureFactory registry )
	{
		this.matrixFrame = registry.block( "matrix_frame", new BlockMatrixFrame() ).features( AEFeature.SpatialIO ).createDefaultItemBlock().build();

		init();
	}

}
