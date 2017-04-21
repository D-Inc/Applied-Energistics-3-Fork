
package appeng.core.me.item;


import net.minecraft.item.Item;

import appeng.core.me.api.part.PartRegistryEntry;


@Deprecated
public class ItemPartDefaultTemp<P extends PartRegistryEntry> extends Item
{

	private final P part;

	public ItemPartDefaultTemp( P part )
	{
		this.part = part;
	}

}
