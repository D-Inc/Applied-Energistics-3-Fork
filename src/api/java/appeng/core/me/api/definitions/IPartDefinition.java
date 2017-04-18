
package appeng.core.me.api.definitions;


import java.util.Optional;

import net.minecraft.item.Item;

import appeng.api.definitions.IDefinition;
import appeng.api.definitions.IItemDefinition;
import appeng.core.me.api.part.PartRegistryEntry;
import appeng.core.me.api.parts.IPart;


public interface IPartDefinition<P extends IPart<P>> extends IDefinition<PartRegistryEntry<P>>
{

	// TODO 1.11.2-CD:PR - Temporary solution to fixing compile errors. Remove once in CD:PR branch.
	@Deprecated
	<I extends Item> Optional<IItemDefinition<I>> maybeItem();

}
