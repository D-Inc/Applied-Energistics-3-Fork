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

package appeng.core.lib.features;


import org.apache.commons.lang3.tuple.Pair;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import appeng.api.definitions.IBlockDefinition;
import appeng.api.definitions.ITileDefinition;


public final class TileDefinition<TE extends TileEntity, T extends Class<TE>> extends Definition<T> implements ITileDefinition<TE, T>
{

	private final IBlockDefinition block;

	public TileDefinition( ResourceLocation identifier, T tile, IBlockDefinition block )
	{
		super( identifier, tile );
		this.block = block;
	}

	@Override
	public <B extends Block> IBlockDefinition<B> block()
	{
		return block;
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
				Class<TE> clas = maybe().get();
				if( other instanceof TileEntity )
				{
					return other.getClass() == clas;
				}
				if( other instanceof Pair )
				{
					IBlockAccess world = (IBlockAccess) ( ( (Pair) other ).getLeft() instanceof IBlockAccess ? ( (Pair) other ).getLeft() : ( (Pair) other ).getRight() instanceof IBlockAccess ? ( (Pair) other ).getRight() : null );
					BlockPos pos = (BlockPos) ( ( (Pair) other ).getLeft() instanceof BlockPos ? ( (Pair) other ).getLeft() : ( (Pair) other ).getRight() instanceof BlockPos ? ( (Pair) other ).getRight() : null );
					if( world != null && pos != null )
					{
						return isSameAs( world.getTileEntity( pos ) );
					}
				}
			}
			return false;
		}
	}

}
