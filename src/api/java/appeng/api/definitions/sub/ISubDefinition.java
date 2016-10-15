
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
	 * Applies property to this sub definition to create a new sub definition.
	 * 
	 * @param property property to change
	 * @param value new value of property
	 * @return new {@linkplain ISubDefinition} with modified property, or <tt>this</tt> if property and/or value is invalid.
	 */
	@Nonnull
	<P> ISubDefinition<T, D> withProperty( ISubDefinitionProperty<T, D, P> property, P value );

}
