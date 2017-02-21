
package appeng.core.lib.definitions;


import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.ImmutableMap;

import net.minecraft.util.ResourceLocation;

import appeng.api.definitions.IDefinition;
import appeng.api.definitions.sub.ISubDefinition;
import appeng.api.definitions.sub.ISubDefinitionProperty;
import appeng.core.lib.definitions.SubDefinitionsProvider.SubDefinition;


public abstract class SubDefinitionsProvider<T, D, S extends SubDefinition, P extends ISubDefinitionProperty<T, D, ?>>
{

	private Definition<T> defaultD;
	private S defaultSD;

	protected void setDefault( Definition<T> def, Map<ISubDefinitionProperty<T, D, ?>, ?> defaultP )
	{
		assert defaultD == null && defaultSD == null;
		this.defaultD = def;
		ImmutableMap<ISubDefinitionProperty<T, D, ?>, ?> defaultPI = ImmutableMap.copyOf( defaultP );
		this.defaultSD = instantiate( defaultD.identifier(), fromProperties( defaultPI ), defaultPI );
	}

	public Definition<T> getDefault()
	{
		return defaultD;
	}

	public S getDefaultSub()
	{
		return defaultSD;
	}

	<V> S withProperty( SubDefinition def, P property, V value )
	{
		assert isValid( property ) && ( (ISubDefinitionProperty<T, D, V>) property ).isValid( value );
		Map map = new HashMap();
		map.putAll( def.properties );
		map.put( property, value );
		return (S) instantiate( def.identifier(), (D) fromProperties( map ), ImmutableMap.copyOf( map ) );
	}

	public abstract P getProperty( String name );

	public abstract boolean isValid( P property );

	public abstract D fromProperties( Map<ISubDefinitionProperty<T, D, ?>, ?> properties );

	public abstract S instantiate( ResourceLocation identifier, D instance, ImmutableMap<ISubDefinitionProperty<T, D, ?>, ?> properties );

	public class SubDefinition<S extends ISubDefinition<T, D, P, ? extends S>> extends Definition<D> implements ISubDefinition<T, D, P, S>
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
		public <V> S withProperty( P property, V value )
		{
			return (S) SubDefinitionsProvider.this.withProperty( this, property, value );
		}

	}

}
