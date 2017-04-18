
package appeng.core.crafting.definitions;


import appeng.core.crafting.api.definitions.ICraftingPartDefinitions;
import appeng.core.lib.definitions.Definitions;
import appeng.core.me.api.definitions.IPartDefinition;
import appeng.core.me.api.part.PartRegistryEntry;
import appeng.core.me.api.parts.IPart;
import appeng.core.me.bootstrap.MEFeatureFactory;


public class CraftingPartDefinitions<P extends IPart<P>> extends Definitions<PartRegistryEntry<P>, IPartDefinition<P>> implements ICraftingPartDefinitions<P>
{

	public CraftingPartDefinitions( MEFeatureFactory registry )
	{
		init();
	}

}
