
package appeng.tools.api;


import appeng.api.definitions.IDefinitions;


public interface ITools
{

	String NAME = "tools";

	<T, D extends IDefinitions<T>> D definitions( Class<T> clas );

}
