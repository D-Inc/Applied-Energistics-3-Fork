
package appeng.core.spatial.api.definitions;


import net.minecraft.item.Item;

import appeng.api.definitions.IDefinitions;
import appeng.api.definitions.IItemDefinition;
import net.minecraft.item.ItemBlock;


public interface ISpatialItemDefinitions extends IDefinitions<Item, IItemDefinition<Item>>
{
    default IItemDefinition<? extends Item> spatialCell2()
    {
        return get( "spatial_storage_cell_2_cubed" );
    }

    default IItemDefinition<? extends Item> spatialCell16()
    {
        return get( "spatial_storage_cell_16_cubed" );
    }

    default IItemDefinition<? extends Item> spatialCell128()
    {
        return get( "spatial_storage_cell_128_cubed" );
    }

    default IItemDefinition<? extends ItemBlock> blockMatrixFrame()
    {
        return ( IItemDefinition< ? extends ItemBlock > ) get( "matrix_frame" );
    }

    default IItemDefinition<? extends ItemBlock> blockSpatialPylon()
    {
        return ( IItemDefinition< ? extends ItemBlock > ) get( "spatial_pylon" );
    }

    default IItemDefinition<? extends ItemBlock> blockSpatialIOPort()
    {
        return ( IItemDefinition< ? extends ItemBlock > ) get( "spatial_ioport" );
    }
}
