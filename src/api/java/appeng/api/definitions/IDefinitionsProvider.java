
package appeng.api.definitions;

public interface IDefinitionsProvider
{

	<T> IDefinitions definitions( Class<T> clas );

}
