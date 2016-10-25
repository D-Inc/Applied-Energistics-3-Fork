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


import java.util.Optional;

import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import appeng.api.definitions.ITileDefinition;
import appeng.core.lib.block.AEBaseTileBlock;


public final class TileDefinition<TE extends TileEntity, T extends Class<TE>> implements ITileDefinition<TE, T>
{

	private final Optional<AEBaseTileBlock> block;

	public TileDefinition( ResourceLocation registryName, AEBaseTileBlock block, ItemBlock item )
	{
		super( registryName, block, item );
		this.block = Optional.ofNullable( block );
	}

	@Override
	public Optional<? extends Class<? extends TileEntity>> maybeEntity()
	{
		return this.block.map( AEBaseTileBlock::getTileEntityClass );
	}
}
