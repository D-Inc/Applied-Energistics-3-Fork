
package appeng.core.me.api.definitions;


import appeng.api.definitions.IDefinition;
import appeng.core.me.api.part.PartRegistryEntry;
import appeng.core.me.api.parts.IPart;


public interface IPartDefinition<P extends IPart<P>> extends IDefinition<PartRegistryEntry<P>>
{

}
