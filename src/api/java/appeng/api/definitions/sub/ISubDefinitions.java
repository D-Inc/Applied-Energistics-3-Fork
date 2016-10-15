
package appeng.api.definitions.sub;


import java.util.List;
import java.util.Optional;

import javax.annotation.Nonnull;

import appeng.api.definitions.IDefinition;


public interface ISubDefinitions<T, D>
{

	/**
	 * @return list of subimplementations. Never null, if there are no sub implementations, list is empty.
	 */
	@Nonnull
	List<ISubDefinition<T, D>> subDefinitions();

	/**
	 * Gets subdefinition of this with specified variant.
	 * 
	 * @param variant of this definition
	 * @return subdefinition of this with specified variant, if such ex
	 */
	@Nonnull
	ISubDefinition<T, D> getSubDefinition( ISubDefinitionVariant<D, IDefinition<T>> variant );

	/**
	 * Returns {@link ISubDefinitionVariant} from name
	 * 
	 * @param name of {@link ISubDefinitionVariant}
	 * @return {@link ISubDefinitionVariant} if such exists
	 */
	Optional<ISubDefinitionVariant<D, IDefinition<T>>> getVariant( String name );

}
