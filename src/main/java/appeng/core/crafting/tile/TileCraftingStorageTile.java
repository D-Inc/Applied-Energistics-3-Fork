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

package appeng.core.crafting.tile;


import java.util.Optional;

import net.minecraft.item.ItemStack;

import appeng.api.definitions.IItemDefinition;
import appeng.core.crafting.block.BlockCraftingUnit;
import appeng.core.lib.AppEngApi;
import appeng.core.lib.api.definitions.ApiBlocks;


public class TileCraftingStorageTile extends TileCraftingTile
{
	private static final int KILO_SCALAR = 1024;

	@Override
	protected ItemStack getItemFromTile( final Object obj )
	{
		final ApiBlocks blocks = AppEngApi.internalApi().definitions().blocks();
		final int storage = ( (TileCraftingTile) obj ).getStorageBytes() / KILO_SCALAR;

		Optional<ItemStack> is;

		switch( storage )
		{
			case 4:
				is = ( (IItemDefinition) blocks.craftingStorage4k().block().maybeItem().get() ).maybeStack( 1 );
				break;
			case 16:
				is = ( (IItemDefinition) blocks.craftingStorage16k().block().maybeItem().get() ).maybeStack( 1 );
				break;
			case 64:
				is = ( (IItemDefinition) blocks.craftingStorage64k().block().maybeItem().get() ).maybeStack( 1 );
				break;
			default:
				is = Optional.empty();
				break;
		}

		return is.orElseGet( () -> super.getItemFromTile( obj ) );
	}

	@Override
	public boolean isAccelerator()
	{
		return false;
	}

	@Override
	public boolean isStorage()
	{
		return true;
	}

	@Override
	public int getStorageBytes()
	{
		if( this.worldObj == null || this.notLoaded() )
		{
			return 0;
		}

		final BlockCraftingUnit unit = (BlockCraftingUnit) this.worldObj.getBlockState( this.pos ).getBlock();
		switch( unit.type )
		{
			default:
			case STORAGE_1K:
				return 1024;
			case STORAGE_4K:
				return 4 * 1024;
			case STORAGE_16K:
				return 16 * 1024;
			case STORAGE_64K:
				return 64 * 1024;
		}
	}
}
