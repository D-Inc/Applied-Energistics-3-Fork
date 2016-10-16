
package appeng.core.me.api;


import appeng.api.definitions.IDefinitions;


public interface IME
{

	String NAME = "me";

	<T, D extends IDefinitions<T>> D definitions( Class<T> clas );

}
