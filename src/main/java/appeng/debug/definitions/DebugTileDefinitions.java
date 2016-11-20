
package appeng.debug.definitions;


import appeng.api.definitions.ITileDefinition;
import appeng.core.lib.features.AEFeature;
import appeng.debug.*;
import net.minecraft.tileentity.TileEntity;

import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.definitions.Definitions;
import net.minecraft.util.ResourceLocation;


public class DebugTileDefinitions extends Definitions<Class<TileEntity>, ITileDefinition<TileEntity>>
{

	private final ITileDefinition itemGen;
	private final ITileDefinition chunkLoader;
	private final ITileDefinition phantomNode;
	private final ITileDefinition cubeGenerator;

	public DebugTileDefinitions( FeatureFactory registry )
	{
		this.itemGen = registry.tile( new ResourceLocation( AppEngDebug.MODID, "debug_item_gen"), TileItemGen.class ).features( AEFeature.UnsupportedDeveloperTools, AEFeature.Creative ).build();
		this.chunkLoader = registry.tile( new ResourceLocation( AppEngDebug.MODID, "debug_chunk_loader" ), TileChunkLoader.class ).features( AEFeature.UnsupportedDeveloperTools, AEFeature.Creative ).build();
		this.phantomNode = registry.tile( new ResourceLocation( AppEngDebug.MODID, "debug_phantom_node" ), TilePhantomNode.class ).features( AEFeature.UnsupportedDeveloperTools, AEFeature.Creative ).build();
		this.cubeGenerator = registry.tile( new ResourceLocation( AppEngDebug.MODID, "debug_cube_gen" ), TileCubeGenerator.class ).features( AEFeature.UnsupportedDeveloperTools, AEFeature.Creative ).build();

		init();
	}

}
