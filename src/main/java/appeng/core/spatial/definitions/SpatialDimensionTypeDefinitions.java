
package appeng.core.spatial.definitions;


import net.minecraft.world.DimensionType;

import appeng.api.definitions.IDefinition;
import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.definitions.Definitions;
import appeng.core.spatial.api.definitions.ISpatialDimensionTypeDefinitions;


public class SpatialDimensionTypeDefinitions extends Definitions<DimensionType, IDefinition<DimensionType>> implements ISpatialDimensionTypeDefinitions
{

	public SpatialDimensionTypeDefinitions( FeatureFactory registry )
	{
		init();
	}

}
