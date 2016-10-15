
package appeng.core.api;


import appeng.api.definitions.IDefinitions;


public interface ICore
{

	String NAME = "core";

	<T> IDefinitions<T> definitions( Class<T> clas );

}
