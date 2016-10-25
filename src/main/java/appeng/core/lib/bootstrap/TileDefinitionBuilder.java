
package appeng.core.lib.bootstrap;


import java.util.function.Supplier;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import appeng.api.definitions.ITileDefinition;
import appeng.core.lib.features.TileDefinition;


class TileDefinitionBuilder<T extends TileEntity> extends DefinitionBuilder<Class<T>, ITileDefinition<T, Class<T>>, TileDefinitionBuilder<T>> implements ITileBuilder<T, TileDefinitionBuilder<T>>
{

	TileDefinitionBuilder( FeatureFactory factory, ResourceLocation id, Supplier<Class<T>> supplier )
	{
		super( factory, id, supplier.get() );
	}

	@Override
	protected ITileDefinition<T, Class<T>> def( Class<T> t )
	{
		if( t == null )
		{
			return new TileDefinition<T, Class<T>>( registryName, null, null );
		}

		TileEntity.addMapping( t, registryName.toString() );

		return new TileDefinition<T, Class<T>>( registryName, t, null );
	}

}
