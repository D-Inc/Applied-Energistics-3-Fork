package appeng.core.lib.module;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Annotate {@link Module} with this annotation and make sure it has no-args constructor to add it to AE.
 * @author elix_x
 *
 */
@Retention( RUNTIME )
@Target( TYPE )
public @interface AEModule
{
	/**
	 * 
	 * @return Name of the module
	 */
	String value();
	
}
