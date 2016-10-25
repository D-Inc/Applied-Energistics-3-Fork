
package appeng.core.lib.bootstrap;


import java.util.function.Supplier;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import appeng.api.definitions.IItemDefinition;
import appeng.core.CreativeTab;
import appeng.core.lib.definitions.Definitions;
import appeng.core.lib.features.BlockDefinition;
import appeng.core.lib.features.ItemDefinition;
import appeng.core.lib.util.Platform;


class ItemDefinitionBuilder<I extends Item> extends DefinitionBuilder<I, IItemDefinition<I>, ItemDefinitionBuilder<I>> implements IItemBuilder<I, ItemDefinitionBuilder<I>>
{

	@SideOnly( Side.CLIENT )
	private ItemRendering itemRendering;

	private Definitions<Block> blockDefinitions;

	private CreativeTabs creativeTab = CreativeTab.instance;

	ItemDefinitionBuilder( FeatureFactory factory, ResourceLocation registryName, Supplier<I> supplier, Definitions<Block> blockDefinitions )
	{
		super( factory, registryName, supplier.get() );
		this.blockDefinitions = blockDefinitions;
		if( Platform.isClient() )
		{
			itemRendering = new ItemRendering();
		}
	}

	@Override
	public ItemDefinitionBuilder<I> creativeTab( CreativeTabs tab )
	{
		this.creativeTab = tab;
		return this;
	}

	@Override
	public ItemDefinitionBuilder<I> rendering( ItemRenderingCustomizer callback )
	{
		if( Platform.isClient() )
		{
			customizeForClient( callback );
		}

		return this;
	}

	@SideOnly( Side.CLIENT )
	private void customizeForClient( ItemRenderingCustomizer callback )
	{
		callback.customize( itemRendering );
	}

	@Override
	public IItemDefinition<I> def( I item )
	{
		item.setUnlocalizedName( "appliedenergistics2." + registryName );
		item.setCreativeTab( creativeTab );

		if( Platform.isClient() )
		{
			itemRendering.apply( factory, item );
		}

		ItemDefinition definition = new ItemDefinition( registryName, item );

		if( item instanceof ItemBlock && blockDefinitions.get( registryName ) != null )
		{
			( (BlockDefinition) blockDefinitions.get( registryName ) ).setItem( definition );
		}

		return definition;
	}
}
