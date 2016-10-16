
package appeng.core.spatial.api;


import appeng.api.definitions.IDefinitions;


public interface ISpatial
{

	String NAME = "spatial";

	<T, D extends IDefinitions<T>> D definitions( Class<T> clas );

}
