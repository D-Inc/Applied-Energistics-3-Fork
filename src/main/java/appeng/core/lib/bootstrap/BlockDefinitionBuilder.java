
package appeng.core.lib.bootstrap;


import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import appeng.api.definitions.IBlockDefinition;
import appeng.core.CreativeTab;
import appeng.core.lib.block.AEBaseTileBlock;
import appeng.core.lib.features.BlockDefinition;
import appeng.core.lib.util.Platform;


public class BlockDefinitionBuilder<B extends Block> extends DefinitionBuilder<B, IBlockDefinition<B>, BlockDefinitionBuilder<B>> implements IBlockBuilder<B, BlockDefinitionBuilder<B>>
{

	private CreativeTabs creativeTab = CreativeTab.instance;

	private boolean createDefaultItemBlock = false;

	private BlockSubDefinitionsProvider<B> subDefs;

	@SideOnly( Side.CLIENT )
	private BlockRendering blockRendering;

	@SideOnly( Side.CLIENT )
	private ItemRendering itemRendering;

	BlockDefinitionBuilder( FeatureFactory factory, ResourceLocation id, B block )
	{
		super( factory, id, block );

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

	public BlockDefinitionBuilder<B> createDefaultItemBlock()
	{
		createDefaultItemBlock = true;
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
			return new BlockDefinition<B>( registryName, null );
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

		BlockDefinition definition = new BlockDefinition<B>( registryName, block );
		if( !block.getBlockState().getProperties().isEmpty() )
		{
			definition.setSubDefinitionsProvider( new BlockSubDefinitionsProvider( definition ) );
		}

		if( createDefaultItemBlock )
		{
			this.factory.addDefaultItemBlock( registryName, definition );
		}
		return definition;
	}

}
