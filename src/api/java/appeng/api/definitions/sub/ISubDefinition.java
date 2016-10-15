
package appeng.api.definitions.sub;


import javax.annotation.Nonnull;

import appeng.api.definitions.IDefinition;


public interface ISubDefinition<T, D> extends IDefinition<D>
{

	/**
	 * @return parent of this {@linkplain ISubDefinition}
	 */
	@Nonnull
	IDefinition<T> parent();

	/**
	 * @return variant of this {@linkplain ISubDefinition}
	 */
	@Nonnull
	ISubDefinitionVariant<D, IDefinition<T>> variant();

}
