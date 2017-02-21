
package appeng.core.lib.bootstrap;


import net.minecraft.util.ResourceLocation;
import net.minecraft.world.DimensionType;

import appeng.api.definitions.IDimensionTypeDefinition;
import appeng.api.definitions.IMaterialDefinition;
import appeng.core.lib.definitions.DimensionTypeDefinition;


public class DimensionTypeDefinitionBuilder<D extends DimensionType> extends DefinitionBuilder<D, IDimensionTypeDefinition<D>, DimensionTypeDefinitionBuilder<D>> implements IDimensionTypeBuilder<D, DimensionTypeDefinitionBuilder<D>>
{

	DimensionTypeDefinitionBuilder( FeatureFactory factory, ResourceLocation registryName, D dimensionType )
	{
		super( factory, registryName, dimensionType );
	}

	@Override
	public IDimensionTypeDefinition<D> def( D dimensionType )
	{
		return new DimensionTypeDefinition( registryName, dimensionType );
	}
}
