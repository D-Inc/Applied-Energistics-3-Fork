
package appeng.debug.definitions;


import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;

import appeng.api.definitions.IBlockDefinition;
import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.definitions.Definitions;
import appeng.core.lib.features.AEFeature;
import appeng.debug.AppEngDebug;
import appeng.debug.BlockChunkloader;
import appeng.debug.BlockCubeGenerator;
import appeng.debug.BlockItemGen;
import appeng.debug.BlockPhantomNode;


public class DebugBlockDefinitions extends Definitions<Block, IBlockDefinition<Block>>
{

	private final IBlockDefinition itemGen;
	private final IBlockDefinition chunkLoader;
	private final IBlockDefinition phantomNode;
	private final IBlockDefinition cubeGenerator;

	public DebugBlockDefinitions( FeatureFactory registry )
	{
		this.itemGen = registry.block( new ResourceLocation( AppEngDebug.MODID, "debug_item_gen"), new BlockItemGen() ).features( AEFeature.UnsupportedDeveloperTools, AEFeature.Creative ).createDefaultItemBlock().build();
		this.chunkLoader = registry.block( new ResourceLocation( AppEngDebug.MODID, "debug_chunk_loader" ), new BlockChunkloader() ).features( AEFeature.UnsupportedDeveloperTools, AEFeature.Creative ).createDefaultItemBlock().build();
		this.phantomNode = registry.block( new ResourceLocation( AppEngDebug.MODID, "debug_phantom_node" ), new BlockPhantomNode() ).features( AEFeature.UnsupportedDeveloperTools, AEFeature.Creative ).createDefaultItemBlock().build();
		this.cubeGenerator = registry.block( new ResourceLocation( AppEngDebug.MODID, "debug_cube_gen" ), new BlockCubeGenerator() ).features( AEFeature.UnsupportedDeveloperTools, AEFeature.Creative ).createDefaultItemBlock().build();
		init();
	}

}
