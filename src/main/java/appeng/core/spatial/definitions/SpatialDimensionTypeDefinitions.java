
package appeng.core.spatial.definitions;


import net.minecraft.world.DimensionType;

import appeng.api.definitions.IDimensionTypeDefinition;
import appeng.core.lib.AEConfig;
import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.definitions.Definitions;
import appeng.core.spatial.api.definitions.ISpatialDimensionTypeDefinitions;
import appeng.core.spatial.world.StorageWorldProvider;


public class SpatialDimensionTypeDefinitions extends Definitions<DimensionType, IDimensionTypeDefinition<DimensionType>> implements ISpatialDimensionTypeDefinitions
{

	private final IDimensionTypeDefinition spatialStorage;

	public SpatialDimensionTypeDefinitions( FeatureFactory registry )
	{
		this.spatialStorage = registry.dimensionType( "spatial_storage", AEConfig.instance.storageProviderID, "Storage Cell", "_cell", StorageWorldProvider.class, false ).build();

		init();
	}

}
