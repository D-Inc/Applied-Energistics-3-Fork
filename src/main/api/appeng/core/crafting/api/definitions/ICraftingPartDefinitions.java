
package appeng.core.crafting.api.definitions;


import net.minecraft.util.ResourceLocation;

import appeng.api.definitions.IDefinitions;
import appeng.core.AppEng;
import appeng.core.me.api.definitions.IPartDefinition;
import appeng.core.me.api.part.PartRegistryEntry;


public interface ICraftingPartDefinitions extends IDefinitions<PartRegistryEntry, IPartDefinition<PartRegistryEntry>>
{

	default IPartDefinition<PartRegistryEntry> patternTerminal()
	{
		return get( new ResourceLocation( AppEng.MODID, "pattern_terminal" ) );
	}

}
