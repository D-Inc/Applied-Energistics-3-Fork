
package appeng.core.lib.bootstrap;


import appeng.api.definitions.IDefinition;
import appeng.core.lib.features.AEFeature;


public interface IDefinitionBuilder<D extends IDefinition<?>, B extends IDefinitionBuilder<D, B>>
{

	B features( AEFeature... features );

	B addFeatures( AEFeature... features );

	D build();

}
