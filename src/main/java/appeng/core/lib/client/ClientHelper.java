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

package appeng.core.lib.client;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.google.common.collect.ImmutableMap;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiErrorScreen;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.fml.client.CustomModLoadingErrorDisplayException;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import appeng.core.AppEng;
import appeng.core.api.util.AECableType;
import appeng.core.api.util.AEColor;
import appeng.core.hooks.TickHandler;
import appeng.core.hooks.TickHandler.PlayerColor;
import appeng.core.lib.AEConfig;
import appeng.core.lib.AELog;
import appeng.core.lib.CommonHelper;
import appeng.core.lib.block.AEBaseBlock;
import appeng.core.lib.client.render.effects.AssemblerFX;
import appeng.core.lib.client.render.effects.CraftingFx;
import appeng.core.lib.client.render.effects.EnergyFx;
import appeng.core.lib.client.render.effects.LightningArcFX;
import appeng.core.lib.client.render.effects.LightningFX;
import appeng.core.lib.client.render.effects.VibrantFX;
import appeng.core.lib.client.render.model.ModelsCache;
import appeng.core.lib.client.render.model.UVLModelLoader;
import appeng.core.lib.helpers.IMouseWheelItem;
import appeng.core.lib.server.ServerHelper;
import appeng.core.lib.sync.network.NetworkHandler;
import appeng.core.lib.sync.packets.PacketAssemblerAnimation;
import appeng.core.lib.sync.packets.PacketValueConfig;
import appeng.core.lib.util.Platform;
import appeng.core.me.api.parts.CableRenderMode;
import appeng.core.me.item.PartType;
import appeng.core.me.part.AEBasePart;
import appeng.core.transformer.MissingCoreMod;
import appeng.tools.client.render.texture.ParticleTextures;


public class ClientHelper extends ServerHelper
{

	@Override
	public World getWorld()
	{
		if( Platform.isClient() )
		{
			return Minecraft.getMinecraft().world;
		}
		else
		{
			return super.getWorld();
		}
	}

	@Override
	public void bindTileEntitySpecialRenderer( final Class<? extends TileEntity> tile, final AEBaseBlock blk )
	{

	}

	@Override
	public List<EntityPlayer> getPlayers()
	{
		if( Platform.isClient() )
		{
			final List<EntityPlayer> o = new ArrayList<>();
			o.add( Minecraft.getMinecraft().player );
			return o;
		}
		else
		{
			return super.getPlayers();
		}
	}

	@Override
	public void spawnEffect( final EffectType effect, final World world, final double posX, final double posY, final double posZ, final Object o )
	{
		if( AEConfig.instance.enableEffects )
		{
			switch( effect )
			{
				case Assembler:
					this.spawnAssembler( world, posX, posY, posZ, o );
					return;
				case Vibrant:
					this.spawnVibrant( world, posX, posY, posZ );
					return;
				case Crafting:
					this.spawnCrafting( world, posX, posY, posZ );
					return;
				case Energy:
					this.spawnEnergy( world, posX, posY, posZ );
					return;
				case Lightning:
					this.spawnLightning( world, posX, posY, posZ );
					return;
				case LightningArc:
					this.spawnLightningArc( world, posX, posY, posZ, (Vec3d) o );
					return;
				default:
			}
		}
	}

	@Override
	public boolean shouldAddParticles( final Random r )
	{
		final int setting = Minecraft.getMinecraft().gameSettings.particleSetting;
		if( setting == 2 )
		{
			return false;
		}
		if( setting == 0 )
		{
			return true;
		}
		return r.nextInt( 2 * ( setting + 1 ) ) == 0;
	}

	@Override
	public RayTraceResult getRTR()
	{
		return Minecraft.getMinecraft().objectMouseOver;
	}

	@Override
	public void doRenderItem( final ItemStack itemstack, final World w )
	{
		if( itemstack != null )
		{
			final EntityItem entityitem = new EntityItem( w, 0.0D, 0.0D, 0.0D, itemstack );
			entityitem.getEntityItem().setCount(1);

			// set all this stuff and then do shit? meh?
			entityitem.hoverStart = 0;
			entityitem.setNoDespawn();
			entityitem.rotationYaw = 0;

			GL11.glPushMatrix();
			GL11.glTranslatef( 0, -0.04F, 0 );
			GL11.glColor4f( 1.0F, 1.0F, 1.0F, 1.0F );
			// GL11.glDisable( GL11.GL_CULL_FACE );

			// TODO Pre-1.8 - RENDER ITEM FOR STORAGE MONITOR!

			GL11.glPopMatrix();
		}
	}

	@Override
	public CableRenderMode getRenderMode()
	{
		if( Platform.isServer() )
		{
			return super.getRenderMode();
		}

		final Minecraft mc = Minecraft.getMinecraft();
		final EntityPlayer player = mc.player;

		return this.renderModeForPlayer( player );
	}

	@Override
	public void triggerUpdates()
	{
		final Minecraft mc = Minecraft.getMinecraft();
		if( mc == null || mc.player == null || mc.world == null )
		{
			return;
		}

		final EntityPlayer player = mc.player;

		final int x = (int) player.posX;
		final int y = (int) player.posY;
		final int z = (int) player.posZ;

		final int range = 16 * 16;

		mc.world.markBlockRangeForRenderUpdate( x - range, y - range, z - range, x + range, y + range, z + range );
	}

	@Override
	public void missingCoreMod()
	{
		throw new MissingCoreMod();
	}

	@Override
	public void moduleLoadingException( String exceptionText, String guiText )
	{
		throw new CustomModLoadingErrorDisplayException( exceptionText, null ){

			@Override
			public void initGui( GuiErrorScreen errorScreen, FontRenderer fontRenderer )
			{

			}

			@Override
			public void drawScreen( GuiErrorScreen errorScreen, FontRenderer fontRenderer, int mouseRelX, int mouseRelY, float tickTime )
			{
				errorScreen.drawDefaultBackground();
				errorScreen.drawCenteredString( fontRenderer, guiText, errorScreen.width / 2, 75, 0xFFFFFF );
			}
		};
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