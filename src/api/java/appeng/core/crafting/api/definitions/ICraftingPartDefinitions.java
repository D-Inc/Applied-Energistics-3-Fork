
package appeng.core.crafting.api.definitions;


import net.minecraft.util.ResourceLocation;

import appeng.api.definitions.IDefinitions;
import appeng.core.AppEng;
import appeng.core.me.api.definitions.IPartDefinition;
import appeng.core.me.api.part.PartRegistryEntry;
import appeng.core.me.api.parts.IPart;


public interface ICraftingPartDefinitions<P extends IPart<P>> extends IDefinitions<PartRegistryEntry<P>, IPartDefinition<P>>
{

	default IPartDefinition<P> patternTerminal()
	{
		return get( new ResourceLocation( AppEng.MODID, "pattern_terminal" ) );
	}

}
