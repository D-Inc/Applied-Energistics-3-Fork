
package appeng.core.lib.bootstrap;


import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.ImmutableMap;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

import appeng.api.definitions.IItemDefinition;
import appeng.api.definitions.sub.ISubDefinitionProperty;
import appeng.core.lib.bootstrap.ItemSubDefinitionsProvider.IStateItemSubDefinition;
import appeng.core.lib.definitions.SubDefinitionsProvider;
import appeng.core.lib.definitions.SubDefinitionsProvider.SubDefinition;
import appeng.core.lib.item.IStateItem;
import appeng.core.lib.item.IStateItem.State;
import appeng.core.lib.item.IStateItem.State.Property;


public class ItemSubDefinitionsProvider<I extends Item & IStateItem<I>> extends SubDefinitionsProvider<I, State<I>, IStateItemSubDefinition, IStateItem.State.Property<?, I>>
{

	private final I item;

	public ItemSubDefinitionsProvider( IItemDefinition<I> item )
	{
		this.item = item.maybe().get();
	}

	@Override
	public Property<?, I> getProperty( String name )
	{
		return item.getProperty( name );
	}

	@Override
	public boolean isValid( Property<?, I> property )
	{
		return item.isValid( property );
	}

	@Override
	public State fromProperties( Map<ISubDefinitionProperty<I, State<I>, ?>, ?> properties )
	{
		State state = item.getDefaultState();
		for( Entry<ISubDefinitionProperty<I, State<I>, ?>, ?> e : properties.entrySet() )
		{
			state = state.withProperty( (Property) e.getKey(), e.getValue() );
		}
		return state;
	}

	@Override
	public IStateItemSubDefinition instantiate( ResourceLocation identifier, State<I> instance, ImmutableMap<ISubDefinitionProperty<I, State<I>, ?>, ?> properties )
	{
		return new IStateItemSubDefinition( identifier, instance, properties );
	}

	public class IStateItemSubDefinition extends SubDefinition<IStateItemSubDefinition>
	{

		public IStateItemSubDefinition( ResourceLocation identifier, State<I> itemstack, ImmutableMap<ISubDefinitionProperty<I, State<I>, ?>, ?> properties )
		{
			super( identifier, itemstack, properties );
		}

	}

}
