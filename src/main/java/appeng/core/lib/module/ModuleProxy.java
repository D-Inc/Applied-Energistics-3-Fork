package appeng.core.lib.module;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * Used to provide proxies to core modules. If you are an addon/external module developer, see @SidedProxy.
 * Use this on a field in your main module class.
 * You can use null for a value if you do not need that side.
 * The class given must be assignable to the type of the field you put this over.
 * Similar to @SidedProxy
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ModuleProxy {
    String clientSide();
    String serverSide();
}
