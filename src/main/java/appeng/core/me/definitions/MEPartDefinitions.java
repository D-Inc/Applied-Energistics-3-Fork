
package appeng.core.me.definitions;


import appeng.core.lib.definitions.Definitions;
import appeng.core.me.api.definitions.IMEPartDefinitions;
import appeng.core.me.api.definitions.IPartDefinition;
import appeng.core.me.api.part.PartRegistryEntry;
import appeng.core.me.api.parts.IPart;
import appeng.core.me.bootstrap.MEFeatureFactory;


public class MEPartDefinitions<P extends IPart<P>> extends Definitions<PartRegistryEntry<P>, IPartDefinition<P>> implements IMEPartDefinitions<P>
{

	public MEPartDefinitions( MEFeatureFactory registry )
	{
		init();
	}

}
