
package appeng.core.lib.definitions;


import java.lang.reflect.Field;

import com.google.common.collect.ImmutableMap;

import appeng.api.definitions.IDefinition;
import appeng.api.definitions.IDefinitions;


public class Definitions<T> implements IDefinitions<T>
{

	private ImmutableMap<String, IDefinition<T>> map;

	/**
	 * Make sure to call in the end of the constructor.
	 */
	protected final void init()
	{
		assert map == null;
		ImmutableMap.Builder builder = ImmutableMap.builder();
		for( Field field : this.getClass().getDeclaredFields() )
		{
			if( field.getType().isAssignableFrom( IDefinition.class ) )
			{
				try
				{
					field.setAccessible( true );
					IDefinition<T> def = (IDefinition<T>) field.get( this );
					builder.put( def.identifier(), def );
				}
				catch( ReflectiveOperationException e )
				{
					// ;(
				}
			}
		}
		map = builder.build();
	}

	@Override
	public IDefinition<T> get( String identifier )
	{
		return map.get( identifier );
	}

}
