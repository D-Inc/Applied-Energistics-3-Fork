
package appeng.core.spatial.api.definitions;


import net.minecraft.block.Block;

import appeng.api.definitions.IBlockDefinition;
import appeng.api.definitions.IDefinitions;


public interface ISpatialBlockDefinitions extends IDefinitions<Block, IBlockDefinition<Block>>
{
    default IBlockDefinition<? extends Block> matrixFrame()
    {
        return get( "matrix_frame" );
    }

    default IBlockDefinition<? extends Block> spatialPylon()
    {
        return get( "spatial_pylon" );
    }

    default IBlockDefinition<? extends Block> spatialIOPort()
    {
        return get( "spatial_ioport" );
    }

}
