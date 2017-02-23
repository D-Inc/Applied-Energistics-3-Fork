
package appeng.core.me.api.definitions;


import appeng.api.definitions.IDefinitions;
import appeng.core.me.api.part.PartRegistryEntry;
import appeng.core.me.api.parts.IPart;


public interface IMEPartDefinitions<P extends IPart<P>> extends IDefinitions<PartRegistryEntry<P>, IPartDefinition<P>>
{

}
