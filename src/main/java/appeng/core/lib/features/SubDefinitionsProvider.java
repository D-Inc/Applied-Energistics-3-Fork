
package appeng.core.lib.features;


import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.ImmutableMap;

import net.minecraft.util.ResourceLocation;

import appeng.api.definitions.IDefinition;
import appeng.api.definitions.sub.ISubDefinition;
import appeng.api.definitions.sub.ISubDefinitionProperty;
import appeng.core.lib.features.SubDefinitionsProvider.SubDefinition;


public abstract class SubDefinitionsProvider<T, D, S extends SubDefinition>
{

	private Definition<T> defaultD;
	private S defaultSD;
	private final ImmutableMap<ISubDefinitionProperty<T, D, ?>, ?> defaultP;

	public SubDefinitionsProvider( Map<ISubDefinitionProperty<T, D, ?>, ?> defaultP )
	{
		this.defaultP = ImmutableMap.copyOf( defaultP );
	}

	void setDefault( Definition<T> def )
	{
		assert defaultD == null && defaultSD == null;
		this.defaultD = def;
		this.defaultSD = instantiate( defaultD.identifier(), fromProperties( defaultP ), defaultP );
	}

	public Definition<T> getDefault()
	{
		return defaultD;
	}

	public S getDefaultSub()
	{
		return defaultSD;
	}

	<P> S withProperty( SubDefinition def, ISubDefinitionProperty<T, D, P> property, P value )
	{
		assert property.isValid( value );
		Map map = new HashMap();
		map.putAll( def.properties );
		map.put( property, value );
		return (S) instantiate( def.identifier(), (D) fromProperties( map ), ImmutableMap.copyOf( map ) );
	}

	abstract D fromProperties( Map<ISubDefinitionProperty<T, D, ?>, ?> properties );

	abstract S instantiate( ResourceLocation identifier, D t, ImmutableMap<ISubDefinitionProperty<T, D, ?>, ?> properties );

	public abstract class SubDefinition extends Definition<D> implements ISubDefinition<T, D>
	{

		private ImmutableMap<ISubDefinitionProperty<T, D, ?>, ?> properties;

		public SubDefinition( ResourceLocation identifier, D t, ImmutableMap<ISubDefinitionProperty<T, D, ?>, ?> properties )
		{
			super( identifier, t );
			this.properties = properties;
		}

		@Override
		public IDefinition<T> parent()
		{
			return defaultD;
		}

		@Override
		public <P> ISubDefinition<T, D> withProperty( ISubDefinitionProperty<T, D, P> property, P value )
		{
			return SubDefinitionsProvider.this.withProperty( this, property, value );
		}

	}

}
