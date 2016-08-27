
package appeng.core.me.part.automation;


import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import appeng.api.config.Upgrades;
import appeng.core.lib.tile.inventory.IAEAppEngInventory;


public class BlockUpgradeInventory extends UpgradeInventory
{
	private final Block block;

	public BlockUpgradeInventory( final Block block, final IAEAppEngInventory parent, final int s )
	{
		super( parent, s );
		this.block = block;
	}

	@Override
	public int getMaxInstalled( final Upgrades upgrades )
	{
		int max = 0;

		for( final ItemStack is : upgrades.getSupported().keySet() )
		{
			final Item encodedItem = is.getItem();

			if( encodedItem instanceof ItemBlock && Block.getBlockFromItem( encodedItem ) == this.block )
			{
				max = upgrades.getSupported().get( is );
				break;
			}
		}

		return max;
	}
}
