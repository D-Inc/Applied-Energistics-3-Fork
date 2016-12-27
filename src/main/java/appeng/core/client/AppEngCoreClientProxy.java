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

package appeng.core.client;


import java.io.IOException;

import com.google.common.collect.ImmutableMap;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.resources.IReloadableResourceManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import appeng.core.AppEng;
import appeng.core.api.util.AECableType;
import appeng.core.api.util.AEColor;
import appeng.core.hooks.TickHandler;
import appeng.core.hooks.TickHandler.PlayerColor;
import appeng.core.lib.AELog;
import appeng.core.lib.CommonHelper;
import appeng.core.lib.client.render.RenderFloatingItem;
import appeng.core.lib.client.render.effects.AssemblerFX;
import appeng.core.lib.client.render.effects.CraftingFx;
import appeng.core.lib.client.render.effects.EnergyFx;
import appeng.core.lib.client.render.effects.LightningArcFX;
import appeng.core.lib.client.render.effects.LightningFX;
import appeng.core.lib.client.render.effects.VibrantFX;
import appeng.core.lib.client.render.model.ModelsCache;
import appeng.core.lib.client.render.model.UVLModelLoader;
import appeng.core.lib.entity.EntityFloatingItem;
import appeng.core.lib.helpers.IMouseWheelItem;
import appeng.core.lib.sync.network.NetworkHandler;
import appeng.core.lib.sync.packets.PacketAssemblerAnimation;
import appeng.core.lib.sync.packets.PacketValueConfig;
import appeng.core.lib.util.Platform;
import appeng.core.me.item.PartType;
import appeng.core.me.part.AEBasePart;
import appeng.core.server.AppEngCoreServerProxy;
import appeng.miscellaneous.client.render.RenderTinyTNTPrimed;
import appeng.miscellaneous.entity.EntityTinyTNTPrimed;
import appeng.tools.client.render.texture.ParticleTextures;


public class AppEngCoreClientProxy extends AppEngCoreServerProxy
{

	@Override
	public void preInit( FMLPreInitializationEvent event )
	{
		MinecraftForge.EVENT_BUS.register( this );
		ModelLoaderRegistry.registerLoader( UVLModelLoader.INSTANCE );
		( (IReloadableResourceManager) Minecraft.getMinecraft().getResourceManager() ).registerReloadListener( ModelsCache.INSTANCE );
	}

	@Override
	public void init( FMLInitializationEvent event )
	{

	}

	@Override
	public void postInit( FMLPostInitializationEvent event )
	{
		final RenderManager inst = Minecraft.getMinecraft().getRenderManager();

		inst.entityRenderMap.put( EntityTinyTNTPrimed.class, new RenderTinyTNTPrimed( inst ) );
		inst.entityRenderMap.put( EntityFloatingItem.class, new RenderFloatingItem( inst ) );
	}

	@SubscribeEvent
	public void postPlayerRender( final RenderLivingEvent.Pre p )
	{
		final PlayerColor player = TickHandler.INSTANCE.getPlayerColors().get( p.getEntity().getEntityId() );
		if( player != null )
		{
			final AEColor col = player.myColor;

			final float r = 0xff & ( col.mediumVariant >> 16 );
			final float g = 0xff & ( col.mediumVariant >> 8 );
			final float b = 0xff & ( col.mediumVariant );
			GL11.glColor3f( r / 255.0f, g / 255.0f, b / 255.0f );
		}
	}

	private void spawnAssembler( final World world, final double posX, final double posY, final double posZ, final Object o )
	{
		final PacketAssemblerAnimation paa = (PacketAssemblerAnimation) o;

		final AssemblerFX fx = new AssemblerFX( Minecraft.getMinecraft().world, posX, posY, posZ, 0.0D, 0.0D, 0.0D, paa.rate, paa.is );
		Minecraft.getMinecraft().effectRenderer.addEffect( fx );
	}

	private void spawnVibrant( final World w, final double x, final double y, final double z )
	{
		if( CommonHelper.proxy.shouldAddParticles( Platform.getRandom() ) )
		{
			final double d0 = ( Platform.getRandomFloat() - 0.5F ) * 0.26D;
			final double d1 = ( Platform.getRandomFloat() - 0.5F ) * 0.26D;
			final double d2 = ( Platform.getRandomFloat() - 0.5F ) * 0.26D;

			final VibrantFX fx = new VibrantFX( w, x + d0, y + d1, z + d2, 0.0D, 0.0D, 0.0D );
			Minecraft.getMinecraft().effectRenderer.addEffect( fx );
		}
	}

	private void spawnCrafting( final World w, final double posX, final double posY, final double posZ )
	{
		final float x = (float) ( ( ( Platform.getRandomInt() % 100 ) * 0.01 ) - 0.5 ) * 0.7f;
		final float y = (float) ( ( ( Platform.getRandomInt() % 100 ) * 0.01 ) - 0.5 ) * 0.7f;
		final float z = (float) ( ( ( Platform.getRandomInt() % 100 ) * 0.01 ) - 0.5 ) * 0.7f;

		final CraftingFx fx = new CraftingFx( w, posX + x, posY + y, posZ + z, Items.DIAMOND );

		fx.setMotionX( -x * 0.2f );
		fx.setMotionY( -y * 0.2f );
		fx.setMotionZ( -z * 0.2f );

		Minecraft.getMinecraft().effectRenderer.addEffect( fx );
	}

	private void spawnEnergy( final World w, final double posX, final double posY, final double posZ )
	{
		final float x = (float) ( ( ( Platform.getRandomInt() % 100 ) * 0.01 ) - 0.5 ) * 0.7f;
		final float y = (float) ( ( ( Platform.getRandomInt() % 100 ) * 0.01 ) - 0.5 ) * 0.7f;
		final float z = (float) ( ( ( Platform.getRandomInt() % 100 ) * 0.01 ) - 0.5 ) * 0.7f;

		final EnergyFx fx = new EnergyFx( w, posX + x, posY + y, posZ + z, Items.DIAMOND );

		fx.setMotionX( -x * 0.1f );
		fx.setMotionY( -y * 0.1f );
		fx.setMotionZ( -z * 0.1f );

		Minecraft.getMinecraft().effectRenderer.addEffect( fx );
	}

	private void spawnLightning( final World world, final double posX, final double posY, final double posZ )
	{
		final LightningFX fx = new LightningFX( world, posX, posY + 0.3f, posZ, 0.0f, 0.0f, 0.0f );
		Minecraft.getMinecraft().effectRenderer.addEffect( fx );
	}

	private void spawnLightningArc( final World world, final double posX, final double posY, final double posZ, final Vec3d second )
	{
		final LightningFX fx = new LightningArcFX( world, posX, posY, posZ, second.xCoord, second.yCoord, second.zCoord, 0.0f, 0.0f, 0.0f );
		Minecraft.getMinecraft().effectRenderer.addEffect( fx );
	}

	@SubscribeEvent
	public void onModelBakeEvent( final ModelBakeEvent event )
	{
		UVLModelLoader.INSTANCE.setLoader( event.getModelLoader() );
	}

	@SubscribeEvent
	public void wheelEvent( final MouseEvent me )
	{
		if( me.getDwheel() == 0 )
		{
			return;
		}

		final Minecraft mc = Minecraft.getMinecraft();
		final EntityPlayer player = mc.player;
		if( player.isSneaking() )
		{
			final EnumHand hand;
			if( player.getHeldItem( EnumHand.MAIN_HAND ) != null && player.getHeldItem( EnumHand.MAIN_HAND ).getItem() instanceof IMouseWheelItem )
			{
				hand = EnumHand.MAIN_HAND;
			}
			else if( player.getHeldItem( EnumHand.OFF_HAND ) != null && player.getHeldItem( EnumHand.OFF_HAND ).getItem() instanceof IMouseWheelItem )
			{
				hand = EnumHand.OFF_HAND;
			}
			else
			{
				return;
			}

			final ItemStack is = player.getHeldItem( hand );
			try
			{
				NetworkHandler.instance.sendToServer( new PacketValueConfig( "Item", me.getDwheel() > 0 ? "WheelUp" : "WheelDown" ) );
				me.setCanceled( true );
			}
			catch( final IOException e )
			{
				AELog.debug( e );
			}
		}
	}

	@SubscribeEvent
	public void onTextureStitch( final TextureStitchEvent.Pre event )
	{
		ParticleTextures.registerSprite( event );
		for( AECableType type : AECableType.VALIDCABLES )
		{
			for( IModel model : new IModel[] { ModelsCache.INSTANCE.getOrLoadModel( type.getModel() ), ModelsCache.INSTANCE.getOrLoadModel( type.getConnectionModel() ), ModelsCache.INSTANCE.getOrLoadModel( type.getStraightModel() ) } )
			{
				for( ResourceLocation location : model.getTextures() )
				{
					for( AEColor color : AEColor.values() )
					{
						if( type.displayedChannels() > 0 )
						{
							for( int i = 0; i <= type.displayedChannels(); i++ )
							{
								event.getMap().registerSprite( AEBasePart.replaceProperties( location, ImmutableMap.of( "color", color.name(), "channels", String.valueOf( i ) ) ) );
							}
						}
						else
						{
							event.getMap().registerSprite( AEBasePart.replaceProperties( location, ImmutableMap.of( "color", color.name() ) ) );
						}
					}
				}
			}
		}
		for( PartType part : PartType.values() )
		{
			if( !part.isCable() )
			{
				IModel model = ModelsCache.INSTANCE.getOrLoadModel( part.getModel() );
				for( ResourceLocation location : model.getTextures() )
				{
					for( AEColor color : AEColor.values() )
					{
						event.getMap().registerSprite( AEBasePart.replaceProperties( location, ImmutableMap.of( "color", color.name() ) ) );
					}
				}
			}
		}

		for( ResourceLocation location : ModelsCache.INSTANCE.getOrLoadModel( new ResourceLocation( AppEng.MODID, "part/cable_facade" ) ).getTextures() )
		{
			event.getMap().registerSprite( location );
		}
	}
}