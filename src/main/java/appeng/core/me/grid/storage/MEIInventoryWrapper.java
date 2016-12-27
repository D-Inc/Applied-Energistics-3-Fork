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

package appeng.core.me.grid.storage;


import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

import appeng.core.api.config.Actionable;
import appeng.core.lib.util.InventoryAdaptor;
import appeng.core.lib.util.Platform;
import appeng.core.lib.util.item.AEItemStack;
import appeng.core.me.api.networking.security.BaseActionSource;
import appeng.core.me.api.storage.IMEInventory;
import appeng.core.me.api.storage.StorageChannel;
import appeng.core.me.api.storage.data.IAEItemStack;
import appeng.core.me.api.storage.data.IItemList;


public class MEIInventoryWrapper implements IMEInventory<IAEItemStack>
{

	private final IInventory target;
	private final InventoryAdaptor adaptor;

	public MEIInventoryWrapper( final IInventory m, final InventoryAdaptor ia )
	{
		this.target = m;
		this.adaptor = ia;
	}

	@Override
	public IAEItemStack injectItems( final IAEItemStack iox, final Actionable mode, final BaseActionSource src )
	{
		final ItemStack input = iox.getItemStack();

		if( this.adaptor != null )
		{
			final ItemStack is = mode == Actionable.SIMULATE ? this.adaptor.simulateAdd( input ) : this.adaptor.addItems( input );
			if( is == null )
			{
				return null;
			}
			return AEItemStack.create( is );
		}

		final ItemStack out = Platform.cloneItemStack( input );

		if( mode == Actionable.MODULATE ) // absolutely no need for a first run in simulate mode.
		{
			for( int x = 0; x < this.target.getSizeInventory(); x++ )
			{
				final ItemStack t = this.target.getStackInSlot( x );

				if( Platform.isSameItem( t, input ) )
				{
					final int oriStack = t.getCount();
					t.grow(out.getCount());

					this.target.setInventorySlotContents( x, t );

					if( t.getCount() > this.target.getInventoryStackLimit() )
					{
						t.setCount(this.target.getInventoryStackLimit());
					}

					if( t.getCount() > t.getMaxStackSize() )
					{
						t.setCount(t.getMaxStackSize());
					}

					out.shrink(t.getCount() - oriStack);

					if( out.getCount() <= 0 )
					{
						return null;
					}
				}
			}
		}

		for( int x = 0; x < this.target.getSizeInventory(); x++ )
		{
			ItemStack t = this.target.getStackInSlot( x );

			if( t == null )
			{
				t = Platform.cloneItemStack( input );
				t.setCount(out.getCount());

				if( t.getCount() > this.target.getInventoryStackLimit() )
				{
					t.setCount(this.target.getInventoryStackLimit());
				}

				out.shrink(t.getCount());
				if( mode == Actionable.MODULATE )
				{
					this.target.setInventorySlotContents( x, t );
				}

				if( out.getCount() <= 0 )
				{
					return null;
				}
			}
		}

		return AEItemStack.create( out );
	}

	@Override
	public IAEItemStack extractItems( final IAEItemStack request, final Actionable mode, final BaseActionSource src )
	{
		final ItemStack Req = request.getItemStack();

		int request_stackSize = Req.getCount();

		if( request_stackSize > Req.getMaxStackSize() )
		{
			request_stackSize = Req.getMaxStackSize();
		}

		Req.setCount(request_stackSize);

		ItemStack Gathered = null;
		if( this.adaptor != null )
		{
			Gathered = this.adaptor.removeItems( Req.getCount(), Req, null );
		}
		else
		{
			Gathered = request.getItemStack();
			Gathered.setCount(0);

			// try to find matching inventories that already have it...
			for( int x = 0; x < this.target.getSizeInventory(); x++ )
			{
				final ItemStack sub = this.target.getStackInSlot( x );

				if( Platform.isSameItem( sub, Req ) )
				{
					int reqNum = Req.getCount();

					if( reqNum > sub.getCount() )
					{
						reqNum = Req.getCount();
					}

					ItemStack retrieved = null;

					if( sub.getCount() < Req.getCount() )
					{
						retrieved = Platform.cloneItemStack( sub );
						sub.setCount(0);
					}
					else
					{
						retrieved = sub.splitStack( Req.getCount() );
					}

					if( sub.getCount() <= 0 )
					{
						this.target.setInventorySlotContents( x, null );
					}
					else
					{
						this.target.setInventorySlotContents( x, sub );
					}

					if( retrieved != null )
					{
						Gathered.grow(retrieved.getCount());
						Req.shrink(retrieved.getCount());
					}

					if( request_stackSize == Gathered.getCount() )
					{
						return AEItemStack.create( Gathered );
					}
				}
			}

			if( Gathered.getCount() == 0 )
			{
				return null;
			}
		}

		return AEItemStack.create( Gathered );
	}

	@Override
	public IItemList<IAEItemStack> getAvailableItems( final IItemList<IAEItemStack> out )
	{
		for( int x = 0; x < this.target.getSizeInventory(); x++ )
		{
			out.addStorage( AEItemStack.create( this.target.getStackInSlot( x ) ) );
		}

		return out;
	}

	@Override
	public StorageChannel getChannel()
	{
		return StorageChannel.ITEMS;
	}
}
