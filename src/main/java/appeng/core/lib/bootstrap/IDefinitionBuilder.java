
package appeng.core.lib.bootstrap;


import java.util.function.Consumer;

import appeng.api.definitions.IDefinition;
import appeng.core.lib.features.AEFeature;


public interface IDefinitionBuilder<T, D extends IDefinition<T>, B extends IDefinitionBuilder<T, D, B>>
{

	B features( AEFeature... features );

	B addFeatures( AEFeature... features );

	B preInit( Consumer<T> callback );

	B init( Consumer<T> callback );

	B postInit( Consumer<T> callback );

	D build();

}
