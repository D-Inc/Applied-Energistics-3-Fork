
package appeng.core.lib.bootstrap;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import appeng.api.definitions.IItemDefinition;
import appeng.core.api.util.AEColor;
import appeng.core.api.util.AEColoredItemDefinition;
import appeng.core.lib.bootstrap.components.InitComponent;
import appeng.core.lib.bootstrap.components.ModelOverrideComponent;
import appeng.core.lib.bootstrap.components.PostInitComponent;
import appeng.core.lib.bootstrap.components.PreInitComponent;
import appeng.core.lib.features.AEFeature;
import appeng.core.lib.features.ActivityState;
import appeng.core.lib.features.ColoredItemDefinition;
import appeng.core.lib.features.ItemStackSrc;
import appeng.core.lib.util.Platform;


public class FeatureFactory
{

	private final AEFeature[] defaultFeatures;

	private final List<IBootstrapComponent> bootstrapComponents;

	@SideOnly( Side.CLIENT )
	ModelOverrideComponent modelOverrideComponent;

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

	public IBlockBuilder block( String id, Supplier<Block> block )
	{
		return new BlockDefinitionBuilder( this, id, block ).features( defaultFeatures );
	}

	public IItemBuilder item( String id, Supplier<Item> item )
	{
		return new ItemDefinitionBuilder( this, id, item ).features( defaultFeatures );
	}

	public AEColoredItemDefinition colored( IItemDefinition target, int offset )
	{
		ColoredItemDefinition definition = new ColoredItemDefinition();

		Optional<? extends Item> opt = target.maybe();
		opt.ifPresent( targetItem ->
        {
			for( final AEColor color : AEColor.VALID_COLORS )
			{
				final ActivityState state = ActivityState.from( target.isEnabled() );

				definition.add( color, new ItemStackSrc( targetItem, offset + color.ordinal(), state ) );
			}
		} );

		return definition;
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
