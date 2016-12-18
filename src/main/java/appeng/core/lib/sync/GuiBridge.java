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

package appeng.core.lib.sync;


import java.lang.reflect.Constructor;
import java.util.List;

import com.google.common.collect.Lists;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.relauncher.ReflectionHelper;

//TODO: IComparableDefinition class not available. -legracen
import appeng.api.definitions.IComparableDefinition;
import appeng.core.api.config.SecurityPermissions;
import appeng.core.api.exceptions.AppEngException;
import appeng.core.api.features.IWirelessTermHandler;
import appeng.core.api.implementations.IUpgradeableHost;
import appeng.core.api.implementations.guiobjects.IGuiItem;
import appeng.core.api.implementations.guiobjects.INetworkTool;
import appeng.core.api.implementations.guiobjects.IPortableCell;
import appeng.core.api.util.AEPartLocation;
import appeng.core.api.util.DimensionalCoord;
import appeng.core.container.ContainerGrinder;
import appeng.core.container.ContainerInscriber;
import appeng.core.container.ContainerVibrationChamber;
import appeng.core.crafting.container.ContainerCraftAmount;
import appeng.core.crafting.container.ContainerCraftConfirm;
import appeng.core.crafting.container.ContainerCraftingCPU;
import appeng.core.crafting.container.ContainerCraftingStatus;
import appeng.core.crafting.container.ContainerCraftingTerm;
import appeng.core.crafting.container.ContainerMAC;
import appeng.core.crafting.container.ContainerPatternTerm;
import appeng.core.crafting.tile.TileCraftingTile;
import appeng.core.crafting.tile.TileMolecularAssembler;
import appeng.core.lib.AppEngApi;
import appeng.core.lib.api.definitions.ApiMaterials;
import appeng.core.lib.client.gui.AEBaseGui;
import appeng.core.lib.client.gui.GuiNull;
import appeng.core.lib.container.AEBaseContainer;
import appeng.core.lib.container.ContainerNull;
import appeng.core.lib.container.ContainerOpenContext;
import appeng.core.lib.container.ContainerPriority;
import appeng.core.lib.container.ContainerUpgradeable;
import appeng.core.lib.helpers.IInterfaceHost;
import appeng.core.lib.helpers.IPriorityHost;
import appeng.core.lib.helpers.WirelessTerminalGuiObject;
import appeng.core.lib.stats.Achievements;
import appeng.core.lib.util.Platform;
import appeng.core.me.api.networking.IGrid;
import appeng.core.me.api.networking.IGridNode;
import appeng.core.me.api.networking.energy.IEnergyGrid;
import appeng.core.me.api.networking.security.IActionHost;
import appeng.core.me.api.networking.security.ISecurityGrid;
import appeng.core.me.api.parts.IPart;
import appeng.core.me.api.parts.IPartHost;
import appeng.core.me.api.storage.ITerminalHost;
import appeng.core.me.container.ContainerCellWorkbench;
import appeng.core.me.container.ContainerChest;
import appeng.core.me.container.ContainerCondenser;
import appeng.core.me.container.ContainerDrive;
import appeng.core.me.container.ContainerFormationPlane;
import appeng.core.me.container.ContainerIOPort;
import appeng.core.me.container.ContainerInterface;
import appeng.core.me.container.ContainerInterfaceTerminal;
import appeng.core.me.container.ContainerLevelEmitter;
import appeng.core.me.container.ContainerMEMonitorable;
import appeng.core.me.container.ContainerMEPortableCell;
import appeng.core.me.container.ContainerNetworkStatus;
import appeng.core.me.container.ContainerNetworkTool;
import appeng.core.me.container.ContainerQNB;
import appeng.core.me.container.ContainerSecurity;
import appeng.core.me.container.ContainerStorageBus;
import appeng.core.me.container.ContainerWireless;
import appeng.core.me.container.ContainerWirelessTerm;
import appeng.core.me.item.QuartzKnifeObj;
import appeng.core.me.part.automation.PartFormationPlane;
import appeng.core.me.part.automation.PartLevelEmitter;
import appeng.core.me.part.misc.PartStorageBus;
import appeng.core.me.part.reporting.PartCraftingTerminal;
import appeng.core.me.part.reporting.PartInterfaceTerminal;
import appeng.core.me.part.reporting.PartPatternTerminal;
import appeng.core.me.tile.TileCellWorkbench;
import appeng.core.me.tile.TileChest;
import appeng.core.me.tile.TileCondenser;
import appeng.core.me.tile.TileDrive;
import appeng.core.me.tile.TileIOPort;
import appeng.core.me.tile.TileQuantumBridge;
import appeng.core.me.tile.TileSecurity;
import appeng.core.me.tile.TileWireless;
import appeng.core.spatial.container.ContainerSpatialIOPort;
import appeng.core.spatial.tile.TileSpatialIOPort;
import appeng.core.tile.TileGrinder;
import appeng.core.tile.TileInscriber;
import appeng.core.tile.TileVibrationChamber;
import appeng.core.worldgen.container.ContainerSkyChest;
import appeng.core.worldgen.tile.TileSkyChest;
import appeng.tools.container.ContainerQuartzKnife;


public enum GuiBridge implements IGuiHandler
{
	GUI_Handler(),

	GUI_GRINDER( ContainerGrinder.class, TileGrinder.class, GuiHostType.WORLD, null ),

	GUI_QNB( ContainerQNB.class, TileQuantumBridge.class, GuiHostType.WORLD, SecurityPermissions.BUILD ),

	GUI_SKYCHEST( ContainerSkyChest.class, TileSkyChest.class, GuiHostType.WORLD, null ),

	GUI_CHEST( ContainerChest.class, TileChest.class, GuiHostType.WORLD, SecurityPermissions.BUILD ),

	GUI_WIRELESS( ContainerWireless.class, TileWireless.class, GuiHostType.WORLD, SecurityPermissions.BUILD ),

	GUI_ME( ContainerMEMonitorable.class, ITerminalHost.class, GuiHostType.WORLD, null ),

	GUI_PORTABLE_CELL( ContainerMEPortableCell.class, IPortableCell.class, GuiHostType.ITEM, null ),

	GUI_WIRELESS_TERM( ContainerWirelessTerm.class, WirelessTerminalGuiObject.class, GuiHostType.ITEM, null ),

	GUI_NETWORK_STATUS( ContainerNetworkStatus.class, INetworkTool.class, GuiHostType.ITEM, null ),

	GUI_CRAFTING_CPU( ContainerCraftingCPU.class, TileCraftingTile.class, GuiHostType.WORLD, SecurityPermissions.CRAFT ),

	GUI_NETWORK_TOOL( ContainerNetworkTool.class, INetworkTool.class, GuiHostType.ITEM, null ),

	GUI_QUARTZ_KNIFE( ContainerQuartzKnife.class, QuartzKnifeObj.class, GuiHostType.ITEM, null ),

	GUI_DRIVE( ContainerDrive.class, TileDrive.class, GuiHostType.WORLD, SecurityPermissions.BUILD ),

	GUI_VIBRATION_CHAMBER( ContainerVibrationChamber.class, TileVibrationChamber.class, GuiHostType.WORLD, null ),

	GUI_CONDENSER( ContainerCondenser.class, TileCondenser.class, GuiHostType.WORLD, null ),

	GUI_INTERFACE( ContainerInterface.class, IInterfaceHost.class, GuiHostType.WORLD, SecurityPermissions.BUILD ),

	GUI_BUS( ContainerUpgradeable.class, IUpgradeableHost.class, GuiHostType.WORLD, SecurityPermissions.BUILD ),

	GUI_IOPORT( ContainerIOPort.class, TileIOPort.class, GuiHostType.WORLD, SecurityPermissions.BUILD ),

	GUI_STORAGEBUS( ContainerStorageBus.class, PartStorageBus.class, GuiHostType.WORLD, SecurityPermissions.BUILD ),

	GUI_FORMATION_PLANE( ContainerFormationPlane.class, PartFormationPlane.class, GuiHostType.WORLD, SecurityPermissions.BUILD ),

	GUI_PRIORITY( ContainerPriority.class, IPriorityHost.class, GuiHostType.WORLD, SecurityPermissions.BUILD ),

	GUI_SECURITY( ContainerSecurity.class, TileSecurity.class, GuiHostType.WORLD, SecurityPermissions.SECURITY ),

	GUI_CRAFTING_TERMINAL( ContainerCraftingTerm.class, PartCraftingTerminal.class, GuiHostType.WORLD, SecurityPermissions.CRAFT ),

	GUI_PATTERN_TERMINAL( ContainerPatternTerm.class, PartPatternTerminal.class, GuiHostType.WORLD, SecurityPermissions.CRAFT ),

	// extends (Container/Gui) + Bus
	GUI_LEVEL_EMITTER( ContainerLevelEmitter.class, PartLevelEmitter.class, GuiHostType.WORLD, SecurityPermissions.BUILD ),

	GUI_SPATIAL_IO_PORT( ContainerSpatialIOPort.class, TileSpatialIOPort.class, GuiHostType.WORLD, SecurityPermissions.BUILD ),

	GUI_INSCRIBER( ContainerInscriber.class, TileInscriber.class, GuiHostType.WORLD, null ),

	GUI_CELL_WORKBENCH( ContainerCellWorkbench.class, TileCellWorkbench.class, GuiHostType.WORLD, null ),

	GUI_MAC( ContainerMAC.class, TileMolecularAssembler.class, GuiHostType.WORLD, null ),

	GUI_CRAFTING_AMOUNT( ContainerCraftAmount.class, ITerminalHost.class, GuiHostType.ITEM_OR_WORLD, SecurityPermissions.CRAFT ),

	GUI_CRAFTING_CONFIRM( ContainerCraftConfirm.class, ITerminalHost.class, GuiHostType.ITEM_OR_WORLD, SecurityPermissions.CRAFT ),

	GUI_INTERFACE_TERMINAL( ContainerInterfaceTerminal.class, PartInterfaceTerminal.class, GuiHostType.WORLD, SecurityPermissions.BUILD ),

	GUI_CRAFTING_STATUS( ContainerCraftingStatus.class, ITerminalHost.class, GuiHostType.ITEM_OR_WORLD, SecurityPermissions.CRAFT );

	private final Class tileClass;
	private final Class containerClass;
	private Class guiClass;
	private GuiHostType type;
	private SecurityPermissions requiredPermission;

	GuiBridge()
	{
		this.tileClass = null;
		this.guiClass = null;
		this.containerClass = null;
	}

	GuiBridge( final Class containerClass, final SecurityPermissions requiredPermission )
	{
		this.requiredPermission = requiredPermission;
		this.containerClass = containerClass;
		this.tileClass = null;
		this.getGui();
	}

	/**
	 * I honestly wish I could just use the GuiClass Names myself, but I can't access them without MC's Server
	 * Exploding.
	 */
	private void getGui()
	{
		if( Platform.isClient() )
		{
			AEBaseGui.class.getName();

			final String start = this.containerClass.getName();
			final String guiClass = start.replaceFirst( "container.", "client.gui." ).replace( ".Container", ".Gui" );

			if( start.equals( guiClass ) )
			{
				throw new IllegalStateException( "Unable to find gui class" );
			}
			this.guiClass = ReflectionHelper.getClass( this.getClass().getClassLoader(), guiClass );
			if( this.guiClass == null )
			{
				throw new IllegalStateException( "Cannot Load class: " + guiClass );
			}
		}
	}

	GuiBridge( final Class containerClass, final Class tileClass, final GuiHostType type, final SecurityPermissions requiredPermission )
	{
		this.requiredPermission = requiredPermission;
		this.containerClass = containerClass;
		this.type = type;
		this.tileClass = tileClass;
		this.getGui();
	}

	@Override
	public Object getServerGuiElement( final int ordinal, final EntityPlayer player, final World w, final int x, final int y, final int z )
	{
		final AEPartLocation side = AEPartLocation.fromOrdinal( ordinal & 0x07 );
		final GuiBridge ID = values()[ordinal >> 4];
		final boolean stem = ( ( ordinal >> 3 ) & 1 ) == 1;
		if( ID.type.isItem() )
		{
			ItemStack it = null;
			if( stem )
			{
				it = player.inventory.getCurrentItem();
			}
			else if( x >= 0 && x < player.inventory.mainInventory.size() )
			{
				it = player.inventory.getStackInSlot( x );
			}
			final Object myItem = this.getGuiObject( it, player, w, x, y, z );
			if( myItem != null && ID.CorrectTileOrPart( myItem ) )
			{
				return this.updateGui( ID.ConstructContainer( player.inventory, side, myItem ), w, x, y, z, side, myItem );
			}
		}
		if( ID.type.isTile() )
		{
			final TileEntity TE = w.getTileEntity( new BlockPos( x, y, z ) );
			if( TE instanceof IPartHost )
			{
				( (IPartHost) TE ).getPart( side );
				final IPart part = ( (IPartHost) TE ).getPart( side );
				if( ID.CorrectTileOrPart( part ) )
				{
					return this.updateGui( ID.ConstructContainer( player.inventory, side, part ), w, x, y, z, side, part );
				}
			}
			else
			{
				if( ID.CorrectTileOrPart( TE ) )
				{
					return this.updateGui( ID.ConstructContainer( player.inventory, side, TE ), w, x, y, z, side, TE );
				}
			}
		}
		return new ContainerNull();
	}

	private Object getGuiObject( final ItemStack it, final EntityPlayer player, final World w, final int x, final int y, final int z )
	{
		if( it != null )
		{
			if( it.getItem() instanceof IGuiItem )
			{
				return ( (IGuiItem) it.getItem() ).getGuiObject( it, w, new BlockPos( x, y, z ) );
			}

			final IWirelessTermHandler wh = AppEngApi.internalApi().registries().wireless().getWirelessTerminalHandler( it );
			if( wh != null )
			{
				return new WirelessTerminalGuiObject( wh, it, player, w, x, y, z );
			}
		}

		return null;
	}

	public boolean CorrectTileOrPart( final Object tE )
	{
		if( this.tileClass == null )
		{
			throw new IllegalArgumentException( "This Gui Cannot use the standard Handler." );
		}

		return this.tileClass.isInstance( tE );
	}

	private Object updateGui( final Object newContainer, final World w, final int x, final int y, final int z, final AEPartLocation side, final Object myItem )
	{
		if( newContainer instanceof AEBaseContainer )
		{
			final AEBaseContainer bc = (AEBaseContainer) newContainer;
			bc.setOpenContext( new ContainerOpenContext( myItem ) );
			bc.getOpenContext().setWorld( w );
			bc.getOpenContext().setX( x );
			bc.getOpenContext().setY( y );
			bc.getOpenContext().setZ( z );
			bc.getOpenContext().setSide( side );
		}

		return newContainer;
	}

	public Object ConstructContainer( final InventoryPlayer inventory, final AEPartLocation side, final Object tE )
	{
		try
		{
			final Constructor[] c = this.containerClass.getConstructors();
			if( c.length == 0 )
			{
				throw new AppEngException( "Invalid Gui Class" );
			}

			final Constructor target = this.findConstructor( c, inventory, tE );

			if( target == null )
			{
				throw new IllegalStateException( "Cannot find " + this.containerClass.getName() + "( " + this.typeName( inventory ) + ", " + this.typeName( tE ) + " )" );
			}

			final Object o = target.newInstance( inventory, tE );

			/**
			 * triggers achievement when the player sees presses.
			 */
			if( o instanceof AEBaseContainer )
			{
				final AEBaseContainer bc = (AEBaseContainer) o;
				for( final Object so : bc.inventorySlots )
				{
					if( so instanceof Slot )
					{
						final ItemStack is = ( (Slot) so ).getStack();

						final ApiMaterials materials = AppEngApi.internalApi().definitions().materials();
						this.addPressAchievementToPlayer( is, materials, inventory.player );
					}
				}
			}

			return o;
		}
		catch( final Throwable t )
		{
			throw new IllegalStateException( t );
		}
	}

	private Constructor findConstructor( final Constructor[] c, final InventoryPlayer inventory, final Object tE )
	{
		for( final Constructor con : c )
		{
			final Class[] types = con.getParameterTypes();
			if( types.length == 2 )
			{
				if( types[0].isAssignableFrom( inventory.getClass() ) && types[1].isAssignableFrom( tE.getClass() ) )
				{
					return con;
				}
			}
		}
		return null;
	}

	private String typeName( final Object inventory )
	{
		if( inventory == null )
		{
			return "NULL";
		}

		return inventory.getClass().getName();
	}

	private void addPressAchievementToPlayer( final ItemStack newItem, final ApiMaterials possibleMaterials, final EntityPlayer player )
	{
		final IComparableDefinition logic = possibleMaterials.logicProcessorPress();
		final IComparableDefinition eng = possibleMaterials.engProcessorPress();
		final IComparableDefinition calc = possibleMaterials.calcProcessorPress();
		final IComparableDefinition silicon = possibleMaterials.siliconPress();

		final List<IComparableDefinition> presses = Lists.newArrayList( logic, eng, calc, silicon );

		for( final IComparableDefinition press : presses )
		{
			if( press.isSameAs( newItem ) )
			{
				Achievements.Presses.addToPlayer( player );

				return;
			}
		}
	}

	@Override
	public Object getClientGuiElement( final int ordinal, final EntityPlayer player, final World w, final int x, final int y, final int z )
	{
		final AEPartLocation side = AEPartLocation.fromOrdinal( ordinal & 0x07 );
		final GuiBridge ID = values()[ordinal >> 4];
		final boolean stem = ( ( ordinal >> 3 ) & 1 ) == 1;
		if( ID.type.isItem() )
		{
			ItemStack it = null;
			if( stem )
			{
				it = player.inventory.getCurrentItem();
			}
			else if( x >= 0 && x < player.inventory.mainInventory.size() )
			{
				it = player.inventory.getStackInSlot( x );
			}
			final Object myItem = this.getGuiObject( it, player, w, x, y, z );
			if( myItem != null && ID.CorrectTileOrPart( myItem ) )
			{
				return ID.ConstructGui( player.inventory, side, myItem );
			}
		}
		if( ID.type.isTile() )
		{
			final TileEntity TE = w.getTileEntity( new BlockPos( x, y, z ) );
			if( TE instanceof IPartHost )
			{
				( (IPartHost) TE ).getPart( side );
				final IPart part = ( (IPartHost) TE ).getPart( side );
				if( ID.CorrectTileOrPart( part ) )
				{
					return ID.ConstructGui( player.inventory, side, part );
				}
			}
			else
			{
				if( ID.CorrectTileOrPart( TE ) )
				{
					return ID.ConstructGui( player.inventory, side, TE );
				}
			}
		}
		return new GuiNull( new ContainerNull() );
	}

	public Object ConstructGui( final InventoryPlayer inventory, final AEPartLocation side, final Object tE )
	{
		try
		{
			final Constructor[] c = this.guiClass.getConstructors();
			if( c.length == 0 )
			{
				throw new AppEngException( "Invalid Gui Class" );
			}

			final Constructor target = this.findConstructor( c, inventory, tE );

			if( target == null )
			{
				throw new IllegalStateException( "Cannot find " + this.containerClass.getName() + "( " + this.typeName( inventory ) + ", " + this.typeName( tE ) + " )" );
			}

			return target.newInstance( inventory, tE );
		}
		catch( final Throwable t )
		{
			throw new IllegalStateException( t );
		}
	}

	public boolean hasPermissions( final TileEntity te, final int x, final int y, final int z, final AEPartLocation side, final EntityPlayer player )
	{
		final World w = player.getEntityWorld();
		final BlockPos pos = new BlockPos( x, y, z );

		if( Platform.hasPermissions( te != null ? new DimensionalCoord( te ) : new DimensionalCoord( player.worldObj, pos ), player ) )
		{
			if( this.type.isItem() )
			{
				final ItemStack it = player.inventory.getCurrentItem();
				if( it != null && it.getItem() instanceof IGuiItem )
				{
					final Object myItem = ( (IGuiItem) it.getItem() ).getGuiObject( it, w, pos );
					if( this.CorrectTileOrPart( myItem ) )
					{
						return true;
					}
				}
			}

			if( this.type.isTile() )
			{
				final TileEntity TE = w.getTileEntity( pos );
				if( TE instanceof IPartHost )
				{
					( (IPartHost) TE ).getPart( side );
					final IPart part = ( (IPartHost) TE ).getPart( side );
					if( this.CorrectTileOrPart( part ) )
					{
						return this.securityCheck( part, player );
					}
				}
				else
				{
					if( this.CorrectTileOrPart( TE ) )
					{
						return this.securityCheck( TE, player );
					}
				}
			}
		}
		return false;
	}

	private boolean securityCheck( final Object te, final EntityPlayer player )
	{
		if( te instanceof IActionHost && this.requiredPermission != null )
		{

			final IGridNode gn = ( (IActionHost) te ).getActionableNode();
			if( gn != null )
			{
				final IGrid g = gn.getGrid();
				if( g != null )
				{
					final boolean requirePower = false;
					if( requirePower )
					{
						final IEnergyGrid eg = g.getCache( IEnergyGrid.class );
						if( !eg.isNetworkPowered() )
						{
							return false;
						}
					}

					final ISecurityGrid sg = g.getCache( ISecurityGrid.class );
					if( sg.hasPermission( player, this.requiredPermission ) )
					{
						return true;
					}
				}
			}

			return false;
		}
		return true;
	}

	public GuiHostType getType()
	{
		return this.type;
	}

}
