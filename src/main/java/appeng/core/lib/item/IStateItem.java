
package appeng.core.lib.item;


import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.ImmutableMap;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import appeng.api.definitions.sub.ISubDefinitionProperty;
import appeng.core.lib.item.IStateItem.State.Property;


public interface IStateItem
{

	boolean isValid( Property property );

	Property getProperty( String name );

	State getState( ItemStack itemstack );

	ItemStack getItemStack( State state );

	default State getDefaultState()
	{
		return getState( new ItemStack( (Item) this ) );
	}

	public class State<I extends Item & IStateItem>
	{

		private final I item;
		private final ImmutableMap<Property, ?> properties;

		public State( I item, Map<Property, ?> properties )
		{
			this.item = item;
			this.properties = ImmutableMap.copyOf( properties );
		}

		public I getItem()
		{
			return item;
		}

		public ItemStack toItemStack()
		{
			return item.getItemStack( this );
		}

		public Map<Property, ?> getProperties()
		{
			return properties;
		}

		public <V> State withProperty( Property<V, ?> property, V value )
		{
			assert item.isValid( property ) && property.isValid( value );
			Map map = new HashMap<>();
			map.putAll( properties );
			map.put( property, value );
			return (State) new State( item, map );
		}

		public interface Property<V, I extends Item & IStateItem> extends ISubDefinitionProperty<I, State, V>
		{

		}

	}

}
