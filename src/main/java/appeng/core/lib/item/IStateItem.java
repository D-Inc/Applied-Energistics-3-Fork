
package appeng.core.lib.item;


import java.util.Map;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import appeng.api.definitions.sub.ISubDefinitionProperty;
import appeng.core.lib.item.IStateItem.State;
import appeng.core.lib.item.IStateItem.State.Property;


public interface IStateItem<S extends State<S>>
{

	boolean isValid( Property property );

	Property getProperty( String name );

	S getState( ItemStack itemstack );

	ItemStack getStack( S state );

	default S getDefaultState()
	{
		return getState( new ItemStack( (Item) this ) );
	}

	public interface State<S extends State<S>>
	{

		<I extends Item & IStateItem<S>> I getItem();

		Map<Property, ?> getProperties();

		<V> S withProperty( Property<V, ?> property, V value );

		public interface Property<V, I extends Item & IStateItem> extends ISubDefinitionProperty<I, ItemStack, V>
		{

		}

	}

}
