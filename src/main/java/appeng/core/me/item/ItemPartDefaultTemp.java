
package appeng.core.me.item;


import net.minecraft.item.Item;

import appeng.core.me.api.part.PartRegistryEntry;
import appeng.core.me.api.parts.IPart;

@Deprecated
public class ItemPartDefaultTemp<P extends IPart<P>> extends Item
{

	private final PartRegistryEntry<P> part;

	public ItemPartDefaultTemp( PartRegistryEntry<P> part )
	{
		this.part = part;
	}

}
