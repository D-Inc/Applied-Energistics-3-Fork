/*
 * This file is part of Applied Energistics 2.
 * Copyright (c) 2013 - 2014, AlgorithmX2, All rights reserved.
 *
 * Applied Energistics 2 is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Applied Energistics 2 is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Applied Energistics 2.  If not, see <http://www.gnu.org/licenses/lgpl>.
 */

package appeng.core.crafting.container;


import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

import appeng.core.lib.AppEngApi;
import appeng.core.lib.container.slot.IOptionalSlotHost;
import appeng.core.lib.helpers.IContainerCraftingPacket;
import appeng.core.lib.sync.AppEngPacket;
import appeng.core.lib.sync.packets.PacketPatternSlot;
import appeng.core.me.api.networking.energy.IEnergySource;
import appeng.core.me.api.networking.security.BaseActionSource;
import appeng.core.me.api.storage.IStorageMonitorable;
import appeng.core.me.container.SlotCraftingTerm;


public class SlotPatternTerm extends SlotCraftingTerm
{

	private final int groupNum;
	private final IOptionalSlotHost host;

	public SlotPatternTerm( final EntityPlayer player, final BaseActionSource mySrc, final IEnergySource energySrc, final IStorageMonitorable storage, final IInventory cMatrix, final IInventory secondMatrix, final IInventory output, final int x, final int y, final IOptionalSlotHost h, final int groupNumber, final IContainerCraftingPacket c )
	{
		super( player, mySrc, energySrc, storage, cMatrix, secondMatrix, output, x, y, c );

		this.host = h;
		this.groupNum = groupNumber;
	}

	public AppEngPacket getRequest( final boolean shift ) throws IOException
	{
		return new PacketPatternSlot( this.getPattern(), AppEngApi.internalApi().storage().createItemStack( this.getStack() ), shift );
	}

	@Override
	public ItemStack getStack()
	{
		if( !this.isEnabled() )
		{
			if( this.getDisplayStack() != null )
			{
				this.clearStack();
			}
		}

		return super.getStack();
	}

	@Override
	public boolean isEnabled()
	{
		if( this.host == null )
		{
			return false;
		}

		return this.host.isSlotEnabled( this.groupNum );
	}
}
