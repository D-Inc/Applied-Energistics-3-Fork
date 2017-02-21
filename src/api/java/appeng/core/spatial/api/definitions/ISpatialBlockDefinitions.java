
package appeng.core.spatial.api.definitions;


import net.minecraft.block.Block;

import appeng.api.definitions.IBlockDefinition;
import appeng.api.definitions.IDefinitions;


public interface ISpatialBlockDefinitions extends IDefinitions<Block, IBlockDefinition<Block>>
{
    default IBlockDefinition<Block> matrixFrame()
    {
        return get( "matrix_frame" );
    }

    default IBlockDefinition<Block> spatialPylon()
    {
        return get( "spatial_pylon" );
    }

    default IBlockDefinition<Block> spatialIOPort()
    {
        return get( "spatial_ioport" );
    }

}
