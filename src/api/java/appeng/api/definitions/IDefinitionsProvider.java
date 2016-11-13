
package appeng.api.definitions;

public interface IDefinitionsProvider
{

	<T, D extends IDefinitions<T>> D definitions( Class<T> clas );

}
