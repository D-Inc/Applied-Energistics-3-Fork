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

package appeng.core.lib.definitions;


import java.util.Optional;

import org.apache.commons.lang3.tuple.Pair;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import appeng.api.definitions.IBlockDefinition;
import appeng.api.definitions.IItemDefinition;


public class BlockDefinition<B extends Block> extends Definition<B> implements IBlockDefinition<B>
{

	private IItemDefinition<? extends ItemBlock> item;

	public BlockDefinition( ResourceLocation identifier, B block )
	{
		super( identifier, block );
	}

	public <I extends ItemBlock> void setItem( IItemDefinition<I> item )
	{
		this.item = item;
	}

	@Override
	public <I extends ItemBlock> Optional<IItemDefinition<I>> maybeItem()
	{
		return Optional.ofNullable( (IItemDefinition<I>) item );
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
				Block block = maybe().get();
				if( other instanceof IBlockState )
				{
					return ( (IBlockState) other ).getBlock() == block;
				}
				if( other instanceof Pair )
				{
					IBlockAccess world = (IBlockAccess) ( ( (Pair) other ).getLeft() instanceof IBlockAccess ? ( (Pair) other ).getLeft() : ( (Pair) other ).getRight() instanceof IBlockAccess ? ( (Pair) other ).getRight() : null );
					BlockPos pos = (BlockPos) ( ( (Pair) other ).getLeft() instanceof BlockPos ? ( (Pair) other ).getLeft() : ( (Pair) other ).getRight() instanceof BlockPos ? ( (Pair) other ).getRight() : null );
					if( world != null && pos != null )
					{
						return isSameAs( world.getBlockState( pos ) );
					}
				}
			}
			return false;
		}
	}
}
