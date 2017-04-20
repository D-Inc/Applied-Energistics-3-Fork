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

package appeng.decorative.item;


import com.google.common.collect.ImmutableMap;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

import appeng.api.item.IStateItem;
import appeng.api.item.IStateItem.State.Property;
import appeng.core.api.util.AEColor;
import appeng.core.lib.item.AEBaseItem;
import appeng.core.lib.localization.GuiText;


public class ItemPaintBall extends AEBaseItem implements IStateItem<ItemPaintBall>
{

	private static final Property<AEColor, ItemPaintBall> COLOR = new Property<AEColor, ItemPaintBall>(){

		@Override
		public String getName()
		{
			return "color";
		}

		@Override
		public boolean isValid( AEColor color )
		{
			return color != null;
		}

	};

	private static final Property<Boolean, ItemPaintBall> LUMEN = new Property<Boolean, ItemPaintBall>(){

		@Override
		public String getName()
		{
			return "lumen";
		}

		@Override
		public boolean isValid( Boolean lumen )
		{
			return lumen != null;
		}
	};

	public ItemPaintBall()
	{
		this.setHasSubtypes( true );
	}

	@Override
	public boolean isValid( Property property )
	{
		return property == COLOR || property == LUMEN;
	}

	@Override
	public Property getProperty( String name )
	{
		return name.equals( COLOR.getName() ) ? COLOR : name.equals( LUMEN.getName() ) ? LUMEN : null;
	}

	@Override
	public State getState( ItemStack itemstack )
	{
		AEColor color = AEColor.values()[itemstack.getItemDamage() & 15];
		boolean lumen = ( ( itemstack.getItemDamage() >> 4 ) & 1 ) == 1;
		return new State( this, ImmutableMap.of( COLOR, color, LUMEN, lumen ) );
	}

	@Override
	public ItemStack getItemStack( State state, int amount )
	{
		return new ItemStack( this, amount, ( (AEColor) state.getValue( COLOR ) ).ordinal() | ( ( (boolean) state.getValue( LUMEN ) ? 1 : 0 ) << 4 ) );
	}

	@Override
	public String getItemStackDisplayName( final ItemStack is )
	{
		return super.getItemStackDisplayName( is ) + " - " + this.getExtraName( is );
	}

	private String getExtraName( final ItemStack is )
	{
		return ( isLumen( is ) ? GuiText.Lumen.getLocal() + ' ' : "" ) + this.getColor( is );
	}

	public AEColor getColor( final ItemStack is )
	{
		return (AEColor) getState( is ).getValue( COLOR );
	}

	@Override
	public void getSubItems( final Item sameItem, final CreativeTabs creativeTab, final NonNullList<ItemStack> itemStacks )
	{
		for( final AEColor c : AEColor.VALID_COLORS )
		{
			if( c != AEColor.Transparent )
			{
				itemStacks.add( getItemStack( new State( this, ImmutableMap.of( COLOR, c, LUMEN, false ) ), 1 ) );
			}
		}

		for( final AEColor c : AEColor.VALID_COLORS )
		{
			if( c != AEColor.Transparent )
			{
				itemStacks.add( getItemStack( new State( this, ImmutableMap.of( COLOR, c, LUMEN, true ) ), 1 ) );
			}
		}
	}

	public static boolean isLumen( final ItemStack is )
	{
		return (boolean) ( (ItemPaintBall) is.getItem() ).getState( is ).getValue( LUMEN );
	}

}
