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

package appeng.core.me.definitions;


import java.util.Optional;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

import appeng.api.definitions.IItemDefinition;
import appeng.core.lib.definitions.Definition;
import appeng.core.me.AppEngME;
import appeng.core.me.api.definitions.IPartDefinition;
import appeng.core.me.api.part.PartRegistryEntry;
import appeng.core.me.api.parts.IPart;


public class PartDefinition<P extends IPart<P>> extends Definition<PartRegistryEntry<P>> implements IPartDefinition<P>
{

	private final Optional item;

	public PartDefinition( ResourceLocation identifier, PartRegistryEntry<P> t, IItemDefinition<?> item )
	{
		super( identifier, t );
		this.item = Optional.fromNullable( item );
	}

	@Override
	public <I extends Item> Optional<IItemDefinition<I>> maybeItem()
	{
		return item;
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
				if( other instanceof IPart )
				{
					return AppEngME.INSTANCE.getRegistryName( ( (IPart<?>) other ).getClass() ).equals( identifier() );
				}
			}
			return false;
		}
	}

}
