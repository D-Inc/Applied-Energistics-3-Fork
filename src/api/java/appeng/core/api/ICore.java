
package appeng.core.api;


import appeng.api.definitions.IDefinitions;


public interface ICore
{

	String NAME = "core";

	<T, D extends IDefinitions<T>> D definitions( Class<T> clas );

}
