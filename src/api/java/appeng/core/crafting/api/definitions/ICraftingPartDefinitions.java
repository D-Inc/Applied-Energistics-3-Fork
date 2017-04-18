
package appeng.core.crafting.api.definitions;


import appeng.api.definitions.IDefinitions;
import appeng.core.me.api.definitions.IPartDefinition;
import appeng.core.me.api.part.PartRegistryEntry;
import appeng.core.me.api.parts.IPart;


public interface ICraftingPartDefinitions<P extends IPart<P>> extends IDefinitions<PartRegistryEntry<P>, IPartDefinition<P>>
{

}
