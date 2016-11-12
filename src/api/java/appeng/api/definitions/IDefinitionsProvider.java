
package appeng.api.definitions;

public interface IDefinitionsProvider
{

	<I, D extends IDefinitions<I, IDefinition<I>>> D definition( Class<I> clazz );

}
