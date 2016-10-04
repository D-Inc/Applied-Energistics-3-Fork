package appeng.core.lib.module;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import net.minecraftforge.fml.common.Mod;

/**
 * Populate given field with instance of module with given name or class. Works similarly to {@link Mod#Instance}, but for modules.
 * <br>
 * Field <b>must be static</b> unless it is located inside module class.
 * Works with private and/or final fields.
 * 
 * @author Elix_x
 */
@Retention( RetentionPolicy.RUNTIME )
@Target( ElementType.FIELD )
public @interface Instance
{
	/**
	 * @return Name or class of module to inject it's instance.
	 */
	String value();

}