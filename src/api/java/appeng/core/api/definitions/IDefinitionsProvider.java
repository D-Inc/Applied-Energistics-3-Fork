
package appeng.core.api.definitions;


import appeng.api.definitions.IDefinitions;


public interface IDefinitionsProvider
{

	<T, D extends IDefinitions<T>> D definitions( Class<T> clas );

}
