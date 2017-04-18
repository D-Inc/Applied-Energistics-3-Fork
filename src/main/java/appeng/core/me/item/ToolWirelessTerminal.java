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

package appeng.core.me.item;


import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import appeng.core.api.config.Settings;
import appeng.core.api.config.SortDir;
import appeng.core.api.config.SortOrder;
import appeng.core.api.config.ViewItems;
import appeng.core.api.features.IWirelessTermHandler;
import appeng.core.api.util.IConfigManager;
import appeng.core.lib.AEConfig;
import appeng.core.lib.AppEngApi;
import appeng.core.lib.item.powered.AEBasePoweredItem;
import appeng.core.lib.localization.GuiText;
import appeng.core.lib.util.ConfigManager;
import appeng.core.lib.util.IConfigManagerHost;
import appeng.core.lib.util.Platform;
import appeng.core.me.AppEngME;
import appeng.core.me.definitions.MEItemDefinitions;


public class ToolWirelessTerminal extends AEBasePoweredItem implements IWirelessTermHandler
{

	public ToolWirelessTerminal()
	{
		super( AEConfig.instance.wirelessTerminalBattery );
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick( final World w, final EntityPlayer player, final EnumHand hand )
	{
		ItemStack item = player.getHeldItem( hand );
		AppEngApi.internalApi().registries().wireless().openWirelessTerminalGui( item, w, player );
		return new ActionResult<ItemStack>( EnumActionResult.SUCCESS, item );
	}

	@SideOnly( Side.CLIENT )
	@Override
	public boolean isFull3D()
	{
		return false;
	}

	@Override
	public void addInformation( final ItemStack stack, final EntityPlayer player, final List<String> lines, final boolean displayMoreInfo )
	{
		super.addInformation( stack, player, lines, displayMoreInfo );

		if( stack.hasTagCompound() )
		{
			final NBTTagCompound tag = Platform.openNbtData( stack );
			if( tag != null )
			{
				final String encKey = tag.getString( "encryptionKey" );

				if( encKey == null || encKey.isEmpty() )
				{
					lines.add( GuiText.Unlinked.getLocal() );
				}
				else
				{
					lines.add( GuiText.Linked.getLocal() );
				}
			}
		}
		else
		{
			lines.add( I18n.translateToLocal( "AppEng.GuiITooltip.Unlinked" ) );
		}
	}

	@Override
	public boolean canHandle( final ItemStack is )
	{
		return AppEngME.INSTANCE.<Item, MEItemDefinitions>definitions( Item.class ).wirelessTerminal().isSameAs( is );
	}

	@Override
	public boolean usePower( final EntityPlayer player, final double amount, final ItemStack is )
	{
		return this.extractAEPower( is, amount ) >= amount - 0.5;
	}

	@Override
	public boolean hasPower( final EntityPlayer player, final double amt, final ItemStack is )
	{
		return this.getAECurrentPower( is ) >= amt;
	}

	@Override
	public IConfigManager getConfigManager( final ItemStack target )
	{
		final ConfigManager out = new ConfigManager( new IConfigManagerHost(){

			@Override
			public void updateSetting( final IConfigManager manager, final Enum settingName, final Enum newValue )
			{
				final NBTTagCompound data = Platform.openNbtData( target );
				manager.writeToNBT( data );
			}
		} );

		out.registerSetting( Settings.SORT_BY, SortOrder.NAME );
		out.registerSetting( Settings.VIEW_MODE, ViewItems.ALL );
		out.registerSetting( Settings.SORT_DIRECTION, SortDir.ASCENDING );

		out.readFromNBT( (NBTTagCompound) Platform.openNbtData( target ).copy() );
		return out;
	}

	@Override
	public String getEncryptionKey( final ItemStack item )
	{
		final NBTTagCompound tag = Platform.openNbtData( item );
		return tag.getString( "encryptionKey" );
	}

	@Override
	public void setEncryptionKey( final ItemStack item, final String encKey, final String name )
	{
		final NBTTagCompound tag = Platform.openNbtData( item );
		tag.setString( "encryptionKey", encKey );
		tag.setString( "name", name );
	}
}
