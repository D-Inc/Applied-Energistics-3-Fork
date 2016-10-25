
package appeng.core.lib.bootstrap;


import java.util.function.Supplier;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import appeng.api.definitions.IBlockDefinition;
import appeng.api.definitions.ITileDefinition;
import appeng.core.lib.definitions.Definitions;
import appeng.core.lib.features.TileDefinition;


public class TileDefinitionBuilder<T extends TileEntity> extends DefinitionBuilder<Class<T>, ITileDefinition<T, Class<T>>, TileDefinitionBuilder<T>> implements ITileBuilder<T, TileDefinitionBuilder<T>>
{

	private Definitions<Block> blockDefinitions;

	public TileDefinitionBuilder( FeatureFactory factory, ResourceLocation registryName, Supplier<Class<T>> clas, Definitions<Block> blockDefinitions )
	{
		super( factory, registryName, clas.get() );
		this.blockDefinitions = blockDefinitions;
	}

	@Override
	protected ITileDefinition<T, Class<T>> def( Class<T> t )
	{
		if( t == null )
		{
			return new TileDefinition<T, Class<T>>( registryName, null, null );
		}

		TileEntity.addMapping( t, registryName.toString() );

		return new TileDefinition<T, Class<T>>( registryName, t, (IBlockDefinition) blockDefinitions.get( registryName ) );
	}

}
