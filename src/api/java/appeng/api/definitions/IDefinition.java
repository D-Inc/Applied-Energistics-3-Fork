
package appeng.api.definitions;


import java.util.Optional;

import javax.annotation.Nonnull;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.Triple;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import appeng.api.definitions.sub.ISubDefinition;


public interface IDefinition<T>
{

	/**
	 * @return the unique name of the definition which will be used to register the underlying structure. Will never be null.
	 */
	@Nonnull
	ResourceLocation identifier();

	/**
	 * @return Implementation if applicable
	 */
	Optional<T> maybe();

	/**
	 * @return {@linkplain ISubDefinition} representation if applicable
	 */
	<D> Optional<ISubDefinition<T, D>> maybeSubDefinition();

	/**
	 * @return <tt>true</tt> if definition is enabled
	 */
	boolean isEnabled();

	/**
	 * Compare other with implementation.
	 * <br>
	 * Implemented in a smart way - for example - Comparing {@linkplain ItemStack} (<tt>other</tt>) to Item (<tt>this</tt>) will compare actual {@linkplain ItemStack#getItem()} and <tt>this</tt>.
	 * <br>
	 * Supports {@linkplain Pair}s and {@linkplain Triple}s when applicable.
	 * 
	 * @param other compared object
	 * @return whether the objects are the same
	 */
	boolean isSameAs( Object other );

}
