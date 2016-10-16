
package appeng.core.crafting.api;


import appeng.api.definitions.IDefinitions;


public interface ICrafting
{

	String NAME = "crafting";

	<T, D extends IDefinitions<T>> D definitions( Class<T> clas );

}
