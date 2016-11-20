/*
 * This file is part of Applied Energistics 2.
 * Copyright (c) 2013 - 2015, AlgorithmX2, All rights reserved.
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

package appeng.core.lib.features;


import java.util.Optional;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import appeng.api.definitions.IItemDefinition;


public class ItemDefinition<I extends Item> extends Definition<I> implements IItemDefinition<I>
{

	public ItemDefinition( ResourceLocation identifier, I item )
	{
		super( identifier, item );
	}

	@Override
	public Optional<ItemStack> maybeStack( int stackSize )
	{
		return isEnabled() ? Optional.of( new ItemStack( maybe().get(), stackSize ) ) : Optional.empty();
	}

	@Override
	public boolean isSameAs( Object other )
	{
		if( super.isSameAs( other ) )
		{
			return true;
		}
		else
		{
			if( isEnabled() )
			{
				Item item = maybe().get();
				if( other instanceof ItemStack )
				{
					return ( (ItemStack) other ).getItem() == item;
				}
			}
			return false;
		}
	}

}
