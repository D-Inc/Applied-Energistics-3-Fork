
package appeng.core.lib.bootstrap;


import net.minecraft.util.ResourceLocation;

import appeng.api.definitions.IMaterialDefinition;
import appeng.core.api.material.Material;
import appeng.core.lib.definitions.MaterialDefinition;


public class MaterialDefinitionBuilder<M extends Material> extends DefinitionBuilder<M, M, IMaterialDefinition<M>, MaterialDefinitionBuilder<M>> implements IMaterialBuilder<M, MaterialDefinitionBuilder<M>>
{

	MaterialDefinitionBuilder( FeatureFactory factory, ResourceLocation registryName, M material )
	{
		super( factory, registryName, material );
	}

	@Override
	public IMaterialDefinition<M> def( M material )
	{
		material.setUnlocalizedName( registryName.getResourceDomain() + "." + registryName.getResourcePath() );

		return new MaterialDefinition( registryName, material );
	}
}
