
package appeng.core.lib.features;


import java.util.Optional;

import net.minecraft.util.ResourceLocation;

import appeng.api.definitions.IDefinition;
import appeng.api.definitions.sub.ISubDefinition;


public class Definition<T> implements IDefinition<T>
{

	private final ResourceLocation identifier;
	private final Optional<T> t;

	public Definition( ResourceLocation identifier, T t )
	{
		this.identifier = identifier;
		this.t = Optional.ofNullable( t );
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
	public final <D> Optional<ISubDefinition<T, D>> maybeSubDefinition()
	{
		return null;
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
