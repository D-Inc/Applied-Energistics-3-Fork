
package appeng.core.lib.bootstrap;


import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.function.Consumer;

import javax.annotation.Nullable;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.IForgeRegistryEntry;

import appeng.api.definitions.IDefinition;
import appeng.core.lib.AEConfig;
import appeng.core.lib.features.AEFeature;


public abstract class DefinitionBuilder<T, D extends IDefinition<T>, B extends DefinitionBuilder<T, D, B>> implements IDefinitionBuilder<T, D, B>
{

	protected final FeatureFactory factory;

	protected final ResourceLocation registryName;

	private final T instance;

	private final EnumSet<AEFeature> features = EnumSet.noneOf( AEFeature.class );

	private final List<Consumer<T>> preInitCallbacks = new ArrayList<>();

	private final List<Consumer<T>> initCallbacks = new ArrayList<>();

	private final List<Consumer<T>> postInitCallbacks = new ArrayList<>();

	public DefinitionBuilder( FeatureFactory factory, ResourceLocation registryName, T instance )
	{
		this.factory = factory;
		this.registryName = registryName;
		this.instance = instance;
	}

	@Override
	public B features( AEFeature... features )
	{
		this.features.clear();
		addFeatures( features );
		return (B) this;
	}

	@Override
	public B addFeatures( AEFeature... features )
	{
		Collections.addAll( this.features, features );
		return (B) this;
	}

	@Override
	public B preInit( Consumer<T> callback )
	{
		preInitCallbacks.add( callback );
		return (B) this;
	}

	@Override
	public B init( Consumer<T> callback )
	{
		initCallbacks.add( callback );
		return (B) this;
	}

	@Override
	public B postInit( Consumer<T> callback )
	{
		postInitCallbacks.add( callback );
		return (B) this;
	}

	@Override
	public final D build()
	{
		if( !AEConfig.instance.areFeaturesEnabled( features ) )
		{
			return def( null );
		}

		preInitCallbacks.add( t -> register( t ) );

		preInitCallbacks.forEach( consumer -> factory.addPreInit( side -> consumer.accept( instance ) ) );
		initCallbacks.forEach( consumer -> factory.addInit( side -> consumer.accept( instance ) ) );
		postInitCallbacks.forEach( consumer -> factory.addPostInit( side -> consumer.accept( instance ) ) );

		return def( setRegistryName( instance ) );
	}

	protected T setRegistryName( T t )
	{
		if( t instanceof IForgeRegistryEntry )
		{
			( (IForgeRegistryEntry) t ).setRegistryName( registryName );
		}
		return t;
	}

	protected void register( T t )
	{
		if( t instanceof IForgeRegistryEntry )
		{
			GameRegistry.findRegistry( ( (IForgeRegistryEntry) t ).getRegistryType() ).register( (IForgeRegistryEntry) t );
		}
	}

	protected abstract D def( @Nullable T t );

}
