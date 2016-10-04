
package appeng.core.lib.module;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import net.minecraftforge.fml.common.SidedProxy;


/**
 * Used to provide sided proxies to core modules. Works similarly to {@link SidedProxy}, but for modules.
 * <br>
 * Use this on a field in your main module class (works on static and/or private and/or final fields).
 * The class given must be assignable to the type of the field you put this over.
 */
@Retention( RetentionPolicy.RUNTIME )
@Target( ElementType.FIELD )
public @interface ModuleSidedProxy
{
	/**
	 * The full name of the client side class to load and populate.
	 * Defaults to the nested class named "ClientProxy" in the current class.
	 */
	String clientSide() default "";

	/**
	 * The full name of the server side class to load and populate.
	 * Defaults to the nested class named "ServerProxy" in the current class.
	 */
	String serverSide() default "";
}
