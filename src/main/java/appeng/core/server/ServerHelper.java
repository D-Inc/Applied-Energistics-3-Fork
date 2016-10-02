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

package appeng.core.server;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;

import appeng.api.parts.CableRenderMode;
import appeng.core.lib.CommonHelper;
import appeng.core.lib.block.AEBaseBlock;
import appeng.core.lib.client.EffectType;
import appeng.core.lib.sync.AppEngPacket;
import appeng.core.lib.sync.network.NetworkHandler;
import appeng.core.lib.util.Platform;
import appeng.tools.item.ToolNetworkTool;


public abstract class ServerHelper extends CommonHelper
{

	private EntityPlayer renderModeBased;

	@Override
	public void preinit()
	{

	}

	@Override
	public void init()
	{

	}

	@Override
	public World getWorld()
	{
		throw new UnsupportedOperationException( "This is a server..." );
	}

	@Override
	public void bindTileEntitySpecialRenderer( final Class<? extends TileEntity> tile, final AEBaseBlock blk )
	{
		throw new UnsupportedOperationException( "This is a server..." );
	}

	@Override
	public List<EntityPlayer> getPlayers()
	{
		if( !Platform.isClient() )
		{
			final MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();

			if( server != null )
			{
				return (List) server.getPlayerList().getPlayerList();
			}
		}

		return new ArrayList<EntityPlayer>();
	}

	@Override
	public void sendToAllNearExcept( final EntityPlayer p, final double x, final double y, final double z, final double dist, final World w, final AppEngPacket packet )
	{
		if( Platform.isClient() )
		{
			return;
		}

		for( final EntityPlayer o : this.getPlayers() )
		{
			final EntityPlayerMP entityplayermp = (EntityPlayerMP) o;

			if( entityplayermp != p && entityplayermp.worldObj == w )
			{
				final double dX = x - entityplayermp.posX;
				final double dY = y - entityplayermp.posY;
				final double dZ = z - entityplayermp.posZ;

				if( dX * dX + dY * dY + dZ * dZ < dist * dist )
				{
					NetworkHandler.instance.sendTo( packet, entityplayermp );
				}
			}
		}
	}

	@Override
	public void spawnEffect( final EffectType type, final World worldObj, final double posX, final double posY, final double posZ, final Object o )
	{
		// :P
	}

	@Override
	public boolean shouldAddParticles( final Random r )
	{
		return false;
	}

	@Override
	public RayTraceResult getRTR()
	{
		return null;
	}

	@Override
	public void doRenderItem( final ItemStack sis, final World tile )
	{

	}

	@Override
	public void postInit()
	{

	}

	@Override
	public CableRenderMode getRenderMode()
	{
		if( this.renderModeBased == null )
		{
			return CableRenderMode.Standard;
		}

		return this.renderModeForPlayer( this.renderModeBased );
	}

	@Override
	public void triggerUpdates()
	{

	}

	@Override
	public void updateRenderMode( final EntityPlayer player )
	{
		this.renderModeBased = player;
	}

	@Override
	public void missingCoreMod()
	{
		throw new IllegalStateException( "Unable to Load Core Mod, please verify that AE2 is properly install in the mods folder, with a .jar extension." );
	}

	@Override
	public void moduleLoadingException( String exceptionText, String guiText )
	{
		throw new IllegalStateException( exceptionText );
	}

	protected CableRenderMode renderModeForPlayer( final EntityPlayer player )
	{
		if( player != null )
		{
			for( int x = 0; x < InventoryPlayer.getHotbarSize(); x++ )
			{
				final ItemStack is = player.inventory.getStackInSlot( x );

				if( is != null && is.getItem() instanceof ToolNetworkTool )
				{
					final NBTTagCompound c = is.getTagCompound();
					if( c != null && c.getBoolean( "hideFacades" ) )
					{
						return CableRenderMode.CableView;
					}
				}
			}
		}

		return CableRenderMode.Standard;
	}

}
