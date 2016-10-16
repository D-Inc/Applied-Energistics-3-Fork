
package appeng.miscellaneous.api;


import appeng.api.definitions.IDefinitions;


public interface IMiscellaneous
{

	String NAME = "misc";

	<T, D extends IDefinitions<T>> D definitions( Class<T> clas );;

}
