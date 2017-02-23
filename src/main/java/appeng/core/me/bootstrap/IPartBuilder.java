
package appeng.core.me.bootstrap;


import appeng.core.lib.bootstrap.IDefinitionBuilder;
import appeng.core.me.api.definitions.IPartDefinition;
import appeng.core.me.api.part.PartRegistryEntry;
import appeng.core.me.api.parts.IPart;


public interface IPartBuilder<P extends IPart<P>, PP extends IPartBuilder<P, PP>> extends IDefinitionBuilder<PartRegistryEntry<P>, IPartDefinition<P>, PP>
{

}
