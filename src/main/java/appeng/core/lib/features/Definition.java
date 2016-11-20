
package appeng.core.lib.features;


import java.util.Optional;

import net.minecraft.util.ResourceLocation;

import appeng.api.definitions.IDefinition;
import appeng.api.definitions.sub.ISubDefinition;
import appeng.api.definitions.sub.ISubDefinitionProperty;


public class Definition<T> implements IDefinition<T>
{

	private final ResourceLocation identifier;
	private final Optional<T> t;
	private Optional<SubDefinitionsProvider> subDefinitionsProvider = Optional.empty();

	public Definition( ResourceLocation identifier, T t )
	{
		this.identifier = identifier;
		this.t = Optional.ofNullable( t );
	}

	public void setSubDefinitionsProvider( SubDefinitionsProvider subDefinitionsProvider )
	{
		this.subDefinitionsProvider = Optional.of( subDefinitionsProvider );
	}

	@Override
	public final ResourceLocation identifier()
	{
		return identifier;
	}

	@Override
	public final Optional<T> maybe()
	{
		return t;
	}

	@Override
	public final <D, P extends ISubDefinitionProperty<T, D, ?>, S extends ISubDefinition<T, D, P, S>> Optional<S> maybeSubDefinition()
	{
		return subDefinitionsProvider.isPresent() ? (Optional<S>) Optional.of( subDefinitionsProvider.get().getDefaultSub() ) : Optional.empty();
	}

	@Override
	public boolean isEnabled()
	{
		return t.isPresent();
	}

	@Override
	public boolean isSameAs( Object other )
	{
		return t.isPresent() && t.get() == other;
	}

}
