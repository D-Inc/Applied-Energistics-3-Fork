
package appeng.core.spatial.definitions;


import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.util.ResourceLocation;

import appeng.api.definitions.IMaterialDefinition;
import appeng.core.AppEng;
import appeng.core.api.material.Material;
import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.definitions.Definitions;
import appeng.core.spatial.api.definitions.ISpatialMaterialDefinitions;


public class SpatialMaterialDefinitions extends Definitions<Material, IMaterialDefinition<Material>> implements ISpatialMaterialDefinitions
{

	private static final String MATERIALSMODELSLOCATION = "material/";
	private static final String MATERIALSMODELSVARIANT = "inventory";

	private final IMaterialDefinition cell2SpatialPart;
	private final IMaterialDefinition cell16SpatialPart;
	private final IMaterialDefinition cell128SpatialPart;

	public SpatialMaterialDefinitions( FeatureFactory registry )
	{
		cell2SpatialPart = registry.material( "cell_2_spatial_part", new Material() ).model( new ModelResourceLocation( new ResourceLocation( AppEng.MODID, MATERIALSMODELSLOCATION + "cell_2_spatial_part" ), MATERIALSMODELSVARIANT ) ).build();
		cell16SpatialPart = registry.material( "cell_16_spatial_part", new Material() ).model( new ModelResourceLocation( new ResourceLocation( AppEng.MODID, MATERIALSMODELSLOCATION + "cell_16_spatial_part" ), MATERIALSMODELSVARIANT ) ).build();
		cell128SpatialPart = registry.material( "cell_128_spatial_part", new Material() ).model( new ModelResourceLocation( new ResourceLocation( AppEng.MODID, MATERIALSMODELSLOCATION + "cell_128_spatial_part" ), MATERIALSMODELSVARIANT ) ).build();

		init();
	}

}
