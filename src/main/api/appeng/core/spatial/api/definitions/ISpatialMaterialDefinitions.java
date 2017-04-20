
package appeng.core.spatial.api.definitions;


import appeng.api.definitions.IDefinitions;
import appeng.api.definitions.IMaterialDefinition;
import appeng.core.api.material.Material;


public interface ISpatialMaterialDefinitions extends IDefinitions<Material, IMaterialDefinition<Material>>
{

	default IMaterialDefinition<Material> cell2SpatialPart()
	{
		return get( "cell_2_spatial_part" );
	}

	default IMaterialDefinition<Material> cell16SpatialPart()
	{
		return get( "cell_16_spatial_part" );
	}

	default IMaterialDefinition<Material> cell128SpatialPart()
	{
		return get( "cell_128_spatial_part" );
	}

}
