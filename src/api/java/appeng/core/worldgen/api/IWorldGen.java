
package appeng.core.worldgen.api;


import appeng.api.definitions.IDefinitions;


public interface IWorldGen
{

	String NAME = "worldgen";

	<T, D extends IDefinitions<T>> D definitions( Class<T> clas );

}
