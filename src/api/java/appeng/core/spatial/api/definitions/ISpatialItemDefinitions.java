
package appeng.core.spatial.api.definitions;


import net.minecraft.item.Item;

import appeng.api.definitions.IDefinitions;
import appeng.api.definitions.IItemDefinition;
import net.minecraft.item.ItemBlock;


public interface ISpatialItemDefinitions extends IDefinitions<Item, IItemDefinition<Item>>
{
    default IItemDefinition<Item> spatialCell2()
    {
        return get( "spatial_storage_cell_2_cubed" );
    }

    default IItemDefinition<Item> spatialCell16()
    {
        return get( "spatial_storage_cell_16_cubed" );
    }

    default IItemDefinition<Item> spatialCell128()
    {
        return get( "spatial_storage_cell_128_cubed" );
    }

    default IItemDefinition<Item> blockMatrixFrame()
    {
        return get( "matrix_frame" );
    }

    default IItemDefinition<Item> blockSpatialPylon()
    {
        return get( "spatial_pylon" );
    }

    default IItemDefinition<Item> blockSpatialIOPort()
    {
        return get( "spatial_ioport" );
    }
}
