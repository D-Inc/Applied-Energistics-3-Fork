
package appeng.core.lib.bootstrap;


import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableMap;

import org.apache.commons.lang3.tuple.Pair;

import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import appeng.api.definitions.IBlockDefinition;
import appeng.api.definitions.sub.ISubDefinitionProperty;
import appeng.core.lib.bootstrap.BlockSubDefinitionsProvider.IBlockStateWrapper;
import appeng.core.lib.definitions.Definition;
import appeng.core.lib.definitions.SubDefinitionsProvider;
import appeng.core.lib.definitions.SubDefinitionsProvider.SubDefinition;


public class BlockSubDefinitionsProvider<B extends Block> extends SubDefinitionsProvider<B, IBlockState, IBlockStateWrapper, ISubDefinitionProperty<B, IBlockState, ?>>
{

	private final B block;
	private final ImmutableBiMap<IProperty, IPropertyWrapper> wrappers;

	public BlockSubDefinitionsProvider( IBlockDefinition<B> block )
	{
		super();
		this.block = block.maybe().get();
		ImmutableBiMap.Builder builder = ImmutableBiMap.builder();
		for( IProperty prop : this.block.getBlockState().getProperties() )
		{
			builder.put( prop, new IPropertyWrapper( prop ) );
		}
		this.wrappers = builder.build();

		Map def = new HashMap();
		for( Entry<IProperty<?>, Comparable<?>> e : this.block.getDefaultState().getProperties().entrySet() )
		{
			def.put( getProperty( e.getKey().getName() ), e.getValue() );
		}
		setDefault( (Definition<B>) block, def );
	}

	@Override
	public ISubDefinitionProperty<B, IBlockState, ?> getProperty( String name )
	{
		return wrappers.get( block.getBlockState().getProperty( name ) );
	}

	@Override
	public boolean isValid( ISubDefinitionProperty<B, IBlockState, ?> property )
	{
		return wrappers.containsValue( property );
	}

	@Override
	public IBlockState fromProperties( Map<ISubDefinitionProperty<B, IBlockState, ?>, ?> properties )
	{
		IBlockState state = (IBlockState) getDefaultSub().maybe().get();
		for( Entry<ISubDefinitionProperty<B, IBlockState, ?>, ?> e : properties.entrySet() )
		{
			state = state.withProperty( wrappers.inverse().get( e.getKey() ), (Comparable) e.getValue() );
		}
		return state;
	}

	@Override
	public IBlockStateWrapper instantiate( ResourceLocation identifier, IBlockState instance, ImmutableMap<ISubDefinitionProperty<B, IBlockState, ?>, ?> properties )
	{
		return new IBlockStateWrapper( identifier, instance, properties );
	}

	public class IBlockStateWrapper extends SubDefinition<IBlockStateWrapper>
	{

		public IBlockStateWrapper( ResourceLocation identifier, IBlockState state, ImmutableMap<ISubDefinitionProperty<B, IBlockState, ?>, ?> properties )
		{
			super( identifier, state, properties );
		}

		@Override
		public boolean isSameAs( Object other )
		{
			if( super.isSameAs( other ) )
			{
				return true;
			}
			else
			{
				if( isEnabled() )
				{
					IBlockState state = maybe().get();
					if( other instanceof Pair )
					{
						IBlockAccess world = (IBlockAccess) ( ( (Pair) other ).getLeft() instanceof IBlockAccess ? ( (Pair) other ).getLeft() : ( (Pair) other ).getRight() instanceof IBlockAccess ? ( (Pair) other ).getRight() : null );
						BlockPos pos = (BlockPos) ( ( (Pair) other ).getLeft() instanceof BlockPos ? ( (Pair) other ).getLeft() : ( (Pair) other ).getRight() instanceof BlockPos ? ( (Pair) other ).getRight() : null );
						if( world != null && pos != null )
						{
							return isSameAs( world.getBlockState( pos ) );
						}
					}
				}
				return false;
			}
		}

	}

	public class IPropertyWrapper<V extends Comparable<V>> implements ISubDefinitionProperty<B, IBlockState, V>
	{

		private final IProperty<V> property;

		public IPropertyWrapper( IProperty<V> property )
		{
			this.property = property;
		}

		@Override
		public String getName()
		{
			return this.property.getName();
		}

		@Override
		public boolean isValid( V value )
		{
			return this.property.getAllowedValues().contains( value );
		}

	}

}
