
package appeng.core.spatial.definitions;


import net.minecraft.item.Item;

import appeng.api.definitions.IItemDefinition;
import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.definitions.Definitions;
import appeng.core.lib.features.AEFeature;
import appeng.core.spatial.api.definitions.ISpatialItemDefinitions;
import appeng.core.spatial.item.ItemSpatialStorageCell;


public class SpatialItemDefinitions extends Definitions<Item, IItemDefinition<Item>> implements ISpatialItemDefinitions
{

	private final IItemDefinition spatialCell2;
	private final IItemDefinition spatialCell16;
	private final IItemDefinition spatialCell128;
	
	public SpatialItemDefinitions( FeatureFactory registry )
	{
		FeatureFactory spatialCells = registry.features( AEFeature.SpatialIO );
		this.spatialCell2 = spatialCells.item( "spatial_storage_cell_2_cubed", new ItemSpatialStorageCell( 2 ) ).build();
		this.spatialCell16 = spatialCells.item( "spatial_storage_cell_16_cubed", new ItemSpatialStorageCell( 16 ) ).build();
		this.spatialCell128 = spatialCells.item( "spatial_storage_cell_128_cubed", new ItemSpatialStorageCell( 128 ) ).build();
		
		init();
	}

}
