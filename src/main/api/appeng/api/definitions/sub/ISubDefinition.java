
package appeng.api.definitions.sub;


import javax.annotation.Nonnull;

import appeng.api.definitions.IDefinition;


public interface ISubDefinition<T, D, S extends ISubDefinition<T, D, S>> extends IDefinition<D>
{

	/**
	 * @return parent of this {@linkplain ISubDefinition}
	 */
	@Nonnull
	IDefinition<T> parent();

	/**
	 * Checks whether this subdefinition has given property.<br>
	 * <br>
	 * Note: All subdefinitions of the same definition have the same properties, but different values.
	 * 
	 * @param property property to check
	 * @return whether this subdefinition has the property
	 */
	boolean hasProperty( ISubDefinitionProperty<?> property );

	/**
	 * Applies property to this sub definition to create a new sub definition.<br>
	 * <br>
	 * If this subdefinition does not have the property ({@linkplain #hasProperty(ISubDefinitionProperty)}) or the value is invalid ({@linkplain ISubDefinitionProperty#isValid(Object)}, this method does nothing.
	 * 
	 * @param property property to change
	 * @param value new value of property
	 * @return new {@linkplain ISubDefinition} with modified property, or <tt>this</tt> if property and/or value is invalid.
	 */
	@Nonnull
	<V> S withProperty( ISubDefinitionProperty<V> property, V value );

}
