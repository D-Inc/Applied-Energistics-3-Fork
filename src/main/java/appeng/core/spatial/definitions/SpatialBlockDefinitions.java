
package appeng.core.spatial.definitions;


import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;

import appeng.api.definitions.IBlockDefinition;
import appeng.core.AppEng;
import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.definitions.Definitions;
import appeng.core.lib.features.AEFeature;
import appeng.core.spatial.api.definitions.ISpatialBlockDefinitions;
import appeng.core.spatial.block.BlockMatrixFrame;
import appeng.core.spatial.block.BlockSpatialIOPort;
import appeng.core.spatial.block.BlockSpatialPylon;


public class SpatialBlockDefinitions extends Definitions<Block, IBlockDefinition<Block>> implements ISpatialBlockDefinitions
{

	private final IBlockDefinition matrixFrame;
	private final IBlockDefinition spatialPylon;
	private final IBlockDefinition spatialIOPort;
	
	public SpatialBlockDefinitions( FeatureFactory registry )
	{
		this.matrixFrame = registry.block( new ResourceLocation( AppEng.MODID, "matrix_frame" ), new BlockMatrixFrame() ).features( AEFeature.SpatialIO ).createDefaultItemBlock().build();

		this.spatialPylon = registry.block( new ResourceLocation( AppEng.MODID, "spatial_pylon" ), new BlockSpatialPylon() ).features( AEFeature.SpatialIO ).createDefaultItemBlock().build();
		this.spatialIOPort = registry.block( new ResourceLocation( AppEng.MODID, "spatial_ioport" ), new BlockSpatialIOPort() ).features( AEFeature.SpatialIO ).createDefaultItemBlock().build();
		
		init();
	}

}
