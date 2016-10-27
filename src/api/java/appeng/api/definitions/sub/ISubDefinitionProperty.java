
package appeng.api.definitions.sub;


public interface ISubDefinitionProperty<T, D, V>
{

	/**
	 * Gets the name of this property.
	 * 
	 * @return name of this property
	 */
	String getName();

	/**
	 * Checks whether value is a valid value.
	 * 
	 * @param value value to check
	 * @return Whether value is valid
	 */
	boolean isValid( V value );

}
