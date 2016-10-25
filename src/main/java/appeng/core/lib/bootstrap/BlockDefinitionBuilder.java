
package appeng.core.lib.bootstrap;


import java.util.function.Function;
import java.util.function.Supplier;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import appeng.api.definitions.IBlockDefinition;
import appeng.core.CreativeTab;
import appeng.core.lib.block.AEBaseTileBlock;
import appeng.core.lib.features.BlockDefinition;
import appeng.core.lib.util.Platform;


class BlockDefinitionBuilder<B extends Block> extends DefinitionBuilder<B, IBlockDefinition<B>, BlockDefinitionBuilder<B>> implements IBlockBuilder<B, BlockDefinitionBuilder<B>>
{

	private CreativeTabs creativeTab = CreativeTab.instance;

	private Function<Block, ItemBlock> itemFactory;

	@SideOnly( Side.CLIENT )
	private BlockRendering blockRendering;

	@SideOnly( Side.CLIENT )
	private ItemRendering itemRendering;

	BlockDefinitionBuilder( FeatureFactory factory, ResourceLocation id, Supplier<B> supplier )
	{
		super( factory, id, supplier.get() );

		if( Platform.isClient() )
		{
			blockRendering = new BlockRendering();
			itemRendering = new ItemRendering();
		}
	}

	public BlockDefinitionBuilder<B> rendering( BlockRenderingCustomizer callback )
	{
		if( Platform.isClient() )
		{
			customizeForClient( callback );
		}

		return this;
	}

	@Override
	public BlockDefinitionBuilder<B> item( Function<Block, ItemBlock> factory )
	{
		this.itemFactory = factory;
		return this;
	}

	@SideOnly( Side.CLIENT )
	private void customizeForClient( BlockRenderingCustomizer callback )
	{
		callback.customize( blockRendering, itemRendering );
	}

	@Override
	public IBlockDefinition<B> def( B block )
	{
		if( block == null )
		{
			return new BlockDefinition<B>( registryName, block );
		}

		block.setCreativeTab( creativeTab );
		block.setUnlocalizedName( "appliedenergistics2." + registryName );

		if( Platform.isClient() )
		{
			if( block instanceof AEBaseTileBlock )
			{
				AEBaseTileBlock tileBlock = (AEBaseTileBlock) block;
				blockRendering.apply( factory, block, tileBlock.getTileEntityClass() );
			}
			else
			{
				blockRendering.apply( factory, block, null );
			}
		}

		return new BlockDefinition( registryName, block );
	}
}
