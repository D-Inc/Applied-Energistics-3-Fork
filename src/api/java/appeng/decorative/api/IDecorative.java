
package appeng.decorative.api;


import appeng.api.definitions.IDefinitions;


public interface IDecorative
{

	String NAME = "decorative";

	<T, D extends IDefinitions<T>> D definitions( Class<T> clas );

}
