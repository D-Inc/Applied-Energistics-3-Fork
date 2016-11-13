
package appeng.core.lib.bootstrap;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Maps;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import appeng.api.definitions.IDefinition;
import appeng.api.definitions.IDefinitionsProvider;
import appeng.api.definitions.IItemDefinition;
import appeng.core.AppEng;
import appeng.core.lib.bootstrap.components.InitComponent;
import appeng.core.lib.bootstrap.components.ModelOverrideComponent;
import appeng.core.lib.bootstrap.components.PostInitComponent;
import appeng.core.lib.bootstrap.components.PreInitComponent;
import appeng.core.lib.features.AEFeature;
import appeng.core.lib.features.BlockDefinition;
import appeng.core.lib.util.Platform;


public class FeatureFactory
{

	private final AEFeature[] defaultFeatures;

	private final List<IBootstrapComponent> bootstrapComponents;

	@SideOnly( Side.CLIENT )
	ModelOverrideComponent modelOverrideComponent;

	private final Map<ResourceLocation, BlockDefinition<? extends Block>> defaultItemBlocks = Maps.newHashMap();

	public FeatureFactory()
	{
		this.defaultFeatures = new AEFeature[] { AEFeature.Core };
		this.bootstrapComponents = new ArrayList<>();

		if( Platform.isClient() )
		{
			modelOverrideComponent = new ModelOverrideComponent();
			this.bootstrapComponents.add( modelOverrideComponent );
		}
	}

	private FeatureFactory( FeatureFactory parent, AEFeature... defaultFeatures )
	{
		this.defaultFeatures = defaultFeatures.clone();
		this.bootstrapComponents = parent.bootstrapComponents;
		if( Platform.isClient() )
		{
			this.modelOverrideComponent = parent.modelOverrideComponent;
		}
	}

	public <T extends TileEntity> TileDefinitionBuilder<T> tile( ResourceLocation id, Class<T> tile )
	{
		return new TileDefinitionBuilder<T>( this, id, tile, ( (IDefinitionsProvider) AppEng.instance().getCurrent() ).definitions( Block.class ) ).features( defaultFeatures );
	}

	public <B extends Block> BlockDefinitionBuilder<B> block( ResourceLocation id, B block )
	{
		return new BlockDefinitionBuilder<B>( this, id, block ).features( defaultFeatures );
	}

	public <I extends Item> ItemDefinitionBuilder<I> item( ResourceLocation id, I item )
	{
		return new ItemDefinitionBuilder<I>( this, id, item ).features( defaultFeatures );
	}

	<B extends Block> void addDefaultItemBlock( ResourceLocation id, BlockDefinition<B> def)
	{
		defaultItemBlocks.put( id, def );
	}

	public Map<ResourceLocation, IDefinition<? extends Item>> buildDefaultItemBlocks()
	{
		Map<ResourceLocation, IDefinition<? extends Item>> result = Maps.newHashMap();
		this.defaultItemBlocks.forEach( ( id, def ) -> def.maybe().ifPresent( (block) -> 
		{
			IItemDefinition itemDef = this.item( id, new ItemBlock( block ) ).features().build();
			def.setItem( itemDef );
			result.put( id, itemDef );
		} ) );
		this.defaultItemBlocks.clear();
		return result;
	}

	public FeatureFactory features( AEFeature... features )
	{
		return new FeatureFactory( this, features );
	}

	void addBootstrapComponent( IBootstrapComponent component )
	{
		this.bootstrapComponents.add( component );
	}

	void addPreInit( PreInitComponent component )
	{
		this.bootstrapComponents.add( component );
	}

	void addInit( InitComponent component )
	{
		this.bootstrapComponents.add( component );
	}

	void addPostInit( PostInitComponent component )
	{
		this.bootstrapComponents.add( component );
	}

	public List<IBootstrapComponent> getBootstrapComponents()
	{
		return bootstrapComponents;
	}

}
