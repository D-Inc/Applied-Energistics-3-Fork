
package appeng.core.lib.bootstrap;


import java.util.function.Consumer;

import appeng.api.definitions.IDefinition;
import appeng.core.lib.features.AEFeature;
import appeng.core.lib.features.SubDefinitionsProvider;


public interface IDefinitionBuilder<T, D extends IDefinition<T>, B extends IDefinitionBuilder<T, D, B>>
{

	<S extends SubDefinitionsProvider<T, ?, ?, ?>> B subDefinitionsProvider( S provider );

	B features( AEFeature... features );

	B addFeatures( AEFeature... features );

	B preInit( Consumer<T> callback );

	B init( Consumer<T> callback );

	B postInit( Consumer<T> callback );

	D build();

}
