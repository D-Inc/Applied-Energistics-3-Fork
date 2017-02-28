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

package appeng.core.crafting.item;


import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import appeng.core.crafting.AppEngCrafting;
import appeng.core.crafting.definitions.CraftingItemDefinitions;
import appeng.core.lib.AEConfig;
import appeng.core.lib.features.AEFeature;
import appeng.core.lib.item.AEBaseItemBlock;


public class ItemCraftingStorage extends AEBaseItemBlock
{

	public ItemCraftingStorage( final Block id )
	{
		super( id );
	}

	@Override
	public ItemStack getContainerItem( final ItemStack itemStack )
	{
		return AppEngCrafting.INSTANCE.<Item, CraftingItemDefinitions>definitions( Item.class ).blockCraftingUnit().maybeStack( 1 ).orElse( ItemStack.EMPTY );
	}

	@Override
	public boolean hasContainerItem( final ItemStack stack )
	{
		return AEConfig.instance.isFeatureEnabled( AEFeature.EnableDisassemblyCrafting );
	}
}
