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

package appeng.core.crafting.me;


import appeng.core.api.config.Actionable;
import appeng.core.lib.AppEngApi;
import appeng.core.me.api.networking.security.BaseActionSource;
import appeng.core.me.api.storage.IMEInventory;
import appeng.core.me.api.storage.IMEMonitor;
import appeng.core.me.api.storage.StorageChannel;
import appeng.core.me.api.storage.data.IAEItemStack;
import appeng.core.me.api.storage.data.IItemList;


public class MECraftingInventory implements IMEInventory<IAEItemStack>
{

	private final MECraftingInventory par;

	private final IMEInventory<IAEItemStack> target;
	private final IItemList<IAEItemStack> localCache;

	private final boolean logExtracted;
	private final IItemList<IAEItemStack> extractedCache;

	private final boolean logInjections;
	private final IItemList<IAEItemStack> injectedCache;

	private final boolean logMissing;
	private final IItemList<IAEItemStack> missingCache;

	public MECraftingInventory()
	{
		this.localCache = AppEngApi.internalApi().storage().createItemList();
		this.extractedCache = null;
		this.injectedCache = null;
		this.missingCache = null;
		this.logExtracted = false;
		this.logInjections = false;
		this.logMissing = false;
		this.target = null;
		this.par = null;
	}

	public MECraftingInventory( final MECraftingInventory parent )
	{
		this.target = parent;
		this.logExtracted = parent.logExtracted;
		this.logInjections = parent.logInjections;
		this.logMissing = parent.logMissing;

		if( this.logMissing )
		{
			this.missingCache = AppEngApi.internalApi().storage().createItemList();
		}
		else
		{
			this.missingCache = null;
		}

		if( this.logExtracted )
		{
			this.extractedCache = AppEngApi.internalApi().storage().createItemList();
		}
		else
		{
			this.extractedCache = null;
		}

		if( this.logInjections )
		{
			this.injectedCache = AppEngApi.internalApi().storage().createItemList();
		}
		else
		{
			this.injectedCache = null;
		}

		this.localCache = this.target.getAvailableItems( AppEngApi.internalApi().storage().createItemList() );

		this.par = parent;
	}

	public MECraftingInventory( final IMEMonitor<IAEItemStack> target, final BaseActionSource src, final boolean logExtracted, final boolean logInjections, final boolean logMissing )
	{
		this.target = target;
		this.logExtracted = logExtracted;
		this.logInjections = logInjections;
		this.logMissing = logMissing;

		if( logMissing )
		{
			this.missingCache = AppEngApi.internalApi().storage().createItemList();
		}
		else
		{
			this.missingCache = null;
		}

		if( logExtracted )
		{
			this.extractedCache = AppEngApi.internalApi().storage().createItemList();
		}
		else
		{
			this.extractedCache = null;
		}

		if( logInjections )
		{
			this.injectedCache = AppEngApi.internalApi().storage().createItemList();
		}
		else
		{
			this.injectedCache = null;
		}

		this.localCache = AppEngApi.internalApi().storage().createItemList();
		for( final IAEItemStack is : target.getStorageList() )
		{
			this.localCache.add( target.extractItems( is, Actionable.SIMULATE, src ) );
		}

		this.par = null;
	}

	public MECraftingInventory( final IMEInventory<IAEItemStack> target, final boolean logExtracted, final boolean logInjections, final boolean logMissing )
	{
		this.target = target;
		this.logExtracted = logExtracted;
		this.logInjections = logInjections;
		this.logMissing = logMissing;

		if( logMissing )
		{
			this.missingCache = AppEngApi.internalApi().storage().createItemList();
		}
		else
		{
			this.missingCache = null;
		}

		if( logExtracted )
		{
			this.extractedCache = AppEngApi.internalApi().storage().createItemList();
		}
		else
		{
			this.extractedCache = null;
		}

		if( logInjections )
		{
			this.injectedCache = AppEngApi.internalApi().storage().createItemList();
		}
		else
		{
			this.injectedCache = null;
		}

		this.localCache = target.getAvailableItems( AppEngApi.internalApi().storage().createItemList() );
		this.par = null;
	}

	@Override
	public IAEItemStack injectItems( final IAEItemStack input, final Actionable mode, final BaseActionSource src )
	{
		if( input == null )
		{
			return null;
		}

		if( mode == Actionable.MODULATE )
		{
			if( this.logInjections )
			{
				this.injectedCache.add( input );
			}
			this.localCache.add( input );
		}

		return null;
	}

	@Override
	public IAEItemStack extractItems( final IAEItemStack request, final Actionable mode, final BaseActionSource src )
	{
		if( request == null )
		{
			return null;
		}

		final IAEItemStack list = this.localCache.findPrecise( request );
		if( list == null || list.getCount() == 0 )
		{
			return null;
		}

		if( list.getCount() >= request.getCount() )
		{
			if( mode == Actionable.MODULATE )
			{
				list.shrink( request.getCount() );
				if( this.logExtracted )
				{
					this.extractedCache.add( request );
				}
			}

			return request;
		}

		final IAEItemStack ret = request.copy();
		ret.setCount( list.getCount() );

		if( mode == Actionable.MODULATE )
		{
			list.reset();
			if( this.logExtracted )
			{
				this.extractedCache.add( ret );
			}
		}

		return ret;
	}

	@Override
	public IItemList<IAEItemStack> getAvailableItems( final IItemList<IAEItemStack> out )
	{
		for( final IAEItemStack is : this.localCache )
		{
			out.add( is );
		}

		return out;
	}

	@Override
	public StorageChannel getChannel()
	{
		return StorageChannel.ITEMS;
	}

	public IItemList<IAEItemStack> getItemList()
	{
		return this.localCache;
	}

	public boolean commit( final BaseActionSource src )
	{
		final IItemList<IAEItemStack> added = AppEngApi.internalApi().storage().createItemList();
		final IItemList<IAEItemStack> pulled = AppEngApi.internalApi().storage().createItemList();
		boolean failed = false;

		if( this.logInjections )
		{
			for( final IAEItemStack inject : this.injectedCache )
			{
				IAEItemStack result = null;
				added.add( result = this.target.injectItems( inject, Actionable.MODULATE, src ) );

				if( result != null )
				{
					failed = true;
					break;
				}
			}
		}

		if( failed )
		{
			for( final IAEItemStack is : added )
			{
				this.target.extractItems( is, Actionable.MODULATE, src );
			}

			return false;
		}

		if( this.logExtracted )
		{
			for( final IAEItemStack extra : this.extractedCache )
			{
				IAEItemStack result = null;
				pulled.add( result = this.target.extractItems( extra, Actionable.MODULATE, src ) );

				if( result == null || result.getCount() != extra.getCount() )
				{
					failed = true;
					break;
				}
			}
		}

		if( failed )
		{
			for( final IAEItemStack is : added )
			{
				this.target.extractItems( is, Actionable.MODULATE, src );
			}

			for( final IAEItemStack is : pulled )
			{
				this.target.injectItems( is, Actionable.MODULATE, src );
			}

			return false;
		}

		if( this.logMissing && this.par != null )
		{
			for( final IAEItemStack extra : this.missingCache )
			{
				this.par.addMissing( extra );
			}
		}

		return true;
	}

	private void addMissing( final IAEItemStack extra )
	{
		this.missingCache.add( extra );
	}

	void ignore( final IAEItemStack what )
	{
		final IAEItemStack list = this.localCache.findPrecise( what );
		if( list != null )
		{
			list.setCount( 0 );
		}
	}
}
