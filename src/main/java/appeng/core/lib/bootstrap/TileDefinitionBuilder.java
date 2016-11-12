
package appeng.core.lib.bootstrap;


import appeng.api.definitions.IDefinitions;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import appeng.api.definitions.IBlockDefinition;
import appeng.api.definitions.ITileDefinition;
import appeng.core.lib.definitions.Definitions;
import appeng.core.lib.features.TileDefinition;


public class TileDefinitionBuilder<T extends TileEntity> extends DefinitionBuilder<Class<T>, ITileDefinition<T>, TileDefinitionBuilder<T>> implements ITileBuilder<T, TileDefinitionBuilder<T>>
{

	private IDefinitions<IBlockDefinition<?>> blockDefinitions;

	public TileDefinitionBuilder( FeatureFactory factory, ResourceLocation registryName, Class<T> tile, IDefinitions<IBlockDefinition<?>> blockDefinitions )
	{
		super( factory, registryName, tile );
		this.blockDefinitions = blockDefinitions;
	}

	@Override
	protected ITileDefinition<T> def( Class<T> t )
	{
		if( t == null )
		{
			return new TileDefinition<T>( registryName, null, null );
		}

		TileEntity.addMapping( t, registryName.toString() );

		return new TileDefinition<T>( registryName, t, (IBlockDefinition) blockDefinitions.get( registryName ) );
	}

}
