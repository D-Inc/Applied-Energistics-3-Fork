
package appeng.api.definitions.sub;


import javax.annotation.Nonnull;

import appeng.api.definitions.IDefinition;


public interface ISubDefinitionVariant<T, D extends IDefinition>
{

	/**
	 * @return name of this variant.
	 */
	@Nonnull
	String name();

}
