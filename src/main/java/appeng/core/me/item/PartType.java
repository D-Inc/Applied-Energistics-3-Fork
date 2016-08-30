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


import java.lang.reflect.Constructor;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

import net.minecraft.util.ResourceLocation;

import appeng.api.parts.IPart;
import appeng.core.AppEng;
import appeng.core.integration.IntegrationType;
import appeng.core.lib.features.AEFeature;
import appeng.core.lib.localization.GuiText;
import appeng.core.me.part.automation.PartAnnihilationPlane;
import appeng.core.me.part.automation.PartExportBus;
import appeng.core.me.part.automation.PartFormationPlane;
import appeng.core.me.part.automation.PartIdentityAnnihilationPlane;
import appeng.core.me.part.automation.PartImportBus;
import appeng.core.me.part.automation.PartLevelEmitter;
import appeng.core.me.part.misc.PartCableAnchor;
import appeng.core.me.part.misc.PartInterface;
import appeng.core.me.part.misc.PartInvertedToggleBus;
import appeng.core.me.part.misc.PartStorageBus;
import appeng.core.me.part.misc.PartToggleBus;
import appeng.core.me.part.networking.PartCableCovered;
import appeng.core.me.part.networking.PartCableGlass;
import appeng.core.me.part.networking.PartCableSmart;
import appeng.core.me.part.networking.PartDenseCable;
import appeng.core.me.part.networking.PartQuartzFiber;
import appeng.core.me.part.p2p.PartP2PItems;
import appeng.core.me.part.p2p.PartP2PLight;
import appeng.core.me.part.p2p.PartP2PLiquids;
import appeng.core.me.part.p2p.PartP2PRedstone;
import appeng.core.me.part.p2p.PartP2PTunnelME;
import appeng.core.me.part.reporting.PartConversionMonitor;
import appeng.core.me.part.reporting.PartCraftingTerminal;
import appeng.core.me.part.reporting.PartDarkPanel;
import appeng.core.me.part.reporting.PartInterfaceTerminal;
import appeng.core.me.part.reporting.PartPanel;
import appeng.core.me.part.reporting.PartPatternTerminal;
import appeng.core.me.part.reporting.PartSemiDarkPanel;
import appeng.core.me.part.reporting.PartStorageMonitor;
import appeng.core.me.part.reporting.PartTerminal;


public enum PartType
{
	InvalidType( -1, new ResourceLocation( AppEng.MOD_ID, "invalid" ), EnumSet.of( AEFeature.Core ), EnumSet.noneOf( IntegrationType.class ), null ),

	CableGlass( 0, new ResourceLocation( AppEng.MOD_ID, "cable_glass" ), EnumSet.of( AEFeature.Core ), EnumSet.noneOf( IntegrationType.class ), PartCableGlass.class )
	{
		@Override
		public boolean isCable()
		{
			return true;
		}
	},

	CableCovered( 20, new ResourceLocation( AppEng.MOD_ID, "cable_covered" ), EnumSet.of( AEFeature.Core ), EnumSet.noneOf( IntegrationType.class ), PartCableCovered.class )
	{
		@Override
		public boolean isCable()
		{
			return true;
		}
	},

	CableSmart( 40, new ResourceLocation( AppEng.MOD_ID, "cable_smart" ), EnumSet.of( AEFeature.Channels ), EnumSet.noneOf( IntegrationType.class ), PartCableSmart.class )
	{
		@Override
		public boolean isCable()
		{
			return true;
		}
	},

	CableDense( 60, new ResourceLocation( AppEng.MOD_ID, "cable_dense" ), EnumSet.of( AEFeature.Channels ), EnumSet.noneOf( IntegrationType.class ), PartDenseCable.class )
	{
		@Override
		public boolean isCable()
		{
			return true;
		}
	},

	ToggleBus( 80, new ResourceLocation( AppEng.MOD_ID, "toggle_bus" ), EnumSet.of( AEFeature.Core ), EnumSet.noneOf( IntegrationType.class ), PartToggleBus.class ),

	InvertedToggleBus( 100, new ResourceLocation( AppEng.MOD_ID, "inverted_toggle_bus" ), EnumSet.of( AEFeature.Core ), EnumSet.noneOf( IntegrationType.class ), PartInvertedToggleBus.class ),

	CableAnchor( 120, new ResourceLocation( AppEng.MOD_ID, "cable_anchor" ), EnumSet.of( AEFeature.Core ), EnumSet.noneOf( IntegrationType.class ), PartCableAnchor.class ),

	QuartzFiber( 140, new ResourceLocation( AppEng.MOD_ID, "quartz_fiber" ), EnumSet.of( AEFeature.Core ), EnumSet.noneOf( IntegrationType.class ), PartQuartzFiber.class ),

	Monitor( 160, new ResourceLocation( AppEng.MOD_ID, "monitor" ), EnumSet.of( AEFeature.Core ), EnumSet.noneOf( IntegrationType.class ), PartPanel.class ),

	SemiDarkMonitor( 180, new ResourceLocation( AppEng.MOD_ID, "semi_dark_monitor" ), EnumSet.of( AEFeature.Core ), EnumSet.noneOf( IntegrationType.class ), PartSemiDarkPanel.class ),

	DarkMonitor( 200, new ResourceLocation( AppEng.MOD_ID, "dark_monitor" ), EnumSet.of( AEFeature.Core ), EnumSet.noneOf( IntegrationType.class ), PartDarkPanel.class ),

	StorageBus( 220, new ResourceLocation( AppEng.MOD_ID, "storage_bus" ), EnumSet.of( AEFeature.StorageBus ), EnumSet.noneOf( IntegrationType.class ), PartStorageBus.class ),

	ImportBus( 240, new ResourceLocation( AppEng.MOD_ID, "import_bus" ), EnumSet.of( AEFeature.ImportBus ), EnumSet.noneOf( IntegrationType.class ), PartImportBus.class ),

	ExportBus( 260, new ResourceLocation( AppEng.MOD_ID, "export_bus" ), EnumSet.of( AEFeature.ExportBus ), EnumSet.noneOf( IntegrationType.class ), PartExportBus.class ),

	LevelEmitter( 280, new ResourceLocation( AppEng.MOD_ID, "level_emitter" ), EnumSet.of( AEFeature.LevelEmitter ), EnumSet.noneOf( IntegrationType.class ), PartLevelEmitter.class ),

	AnnihilationPlane( 300, new ResourceLocation( AppEng.MOD_ID, "annihilation_plane" ), EnumSet.of( AEFeature.AnnihilationPlane ), EnumSet.noneOf( IntegrationType.class ), PartAnnihilationPlane.class ),

	IdentityAnnihilationPlane( 301, new ResourceLocation( AppEng.MOD_ID, "identity_annihilation_plane" ), EnumSet.of( AEFeature.AnnihilationPlane, AEFeature.IdentityAnnihilationPlane ), EnumSet.noneOf( IntegrationType.class ), PartIdentityAnnihilationPlane.class ),

	FormationPlane( 320, new ResourceLocation( AppEng.MOD_ID, "formation_plane" ), EnumSet.of( AEFeature.FormationPlane ), EnumSet.noneOf( IntegrationType.class ), PartFormationPlane.class ),

	PatternTerminal( 340, new ResourceLocation( AppEng.MOD_ID, "pattern_terminal" ), EnumSet.of( AEFeature.Patterns ), EnumSet.noneOf( IntegrationType.class ), PartPatternTerminal.class ),

	CraftingTerminal( 360, new ResourceLocation( AppEng.MOD_ID, "crafting_terminal" ), EnumSet.of( AEFeature.CraftingTerminal ), EnumSet.noneOf( IntegrationType.class ), PartCraftingTerminal.class ),

	Terminal( 380, new ResourceLocation( AppEng.MOD_ID, "terminal" ), EnumSet.of( AEFeature.Core ), EnumSet.noneOf( IntegrationType.class ), PartTerminal.class ),

	StorageMonitor( 400, new ResourceLocation( AppEng.MOD_ID, "storage_monitor" ), EnumSet.of( AEFeature.StorageMonitor ), EnumSet.noneOf( IntegrationType.class ), PartStorageMonitor.class ),

	ConversionMonitor( 420, new ResourceLocation( AppEng.MOD_ID, "conversion_monitor" ), EnumSet.of( AEFeature.PartConversionMonitor ), EnumSet.noneOf( IntegrationType.class ), PartConversionMonitor.class ),

	Interface( 440, new ResourceLocation( AppEng.MOD_ID, "interface" ), EnumSet.of( AEFeature.Core ), EnumSet.noneOf( IntegrationType.class ), PartInterface.class ),

	P2PTunnelME( 460, new ResourceLocation( AppEng.MOD_ID, "p2p_tunnel_me" ), EnumSet.of( AEFeature.P2PTunnel, AEFeature.P2PTunnelME ), EnumSet.noneOf( IntegrationType.class ), PartP2PTunnelME.class, GuiText.METunnel ),

	P2PTunnelRedstone( 461, new ResourceLocation( AppEng.MOD_ID, "p2p_tunnel_redstone" ), EnumSet.of( AEFeature.P2PTunnel, AEFeature.P2PTunnelRedstone ), EnumSet.noneOf( IntegrationType.class ), PartP2PRedstone.class, GuiText.RedstoneTunnel ),

	P2PTunnelItems( 462, new ResourceLocation( AppEng.MOD_ID, "p2p_tunnel_items" ), EnumSet.of( AEFeature.P2PTunnel, AEFeature.P2PTunnelItems ), EnumSet.noneOf( IntegrationType.class ), PartP2PItems.class, GuiText.ItemTunnel ),

	P2PTunnelLiquids( 463, new ResourceLocation( AppEng.MOD_ID, "p2p_tunnel_liquids" ), EnumSet.of( AEFeature.P2PTunnel, AEFeature.P2PTunnelLiquids ), EnumSet.noneOf( IntegrationType.class ), PartP2PLiquids.class, GuiText.FluidTunnel ),

	// P2PTunnelEU( 465, EnumSet.of( AEFeature.P2PTunnel, AEFeature.P2PTunnelEU ), EnumSet.of( IntegrationType.IC2 ),
	// PartP2PIC2Power.class, GuiText.EUTunnel ),

	// P2PTunnelRF( 466, EnumSet.of( AEFeature.P2PTunnel, AEFeature.P2PTunnelRF ), EnumSet.of( IntegrationType.RF ),
	// PartP2PRFPower.class, GuiText.RFTunnel ),

	P2PTunnelLight( 467, new ResourceLocation( AppEng.MOD_ID, "p2p_tunnel_light" ), EnumSet.of( AEFeature.P2PTunnel, AEFeature.P2PTunnelLight ), EnumSet.noneOf( IntegrationType.class ), PartP2PLight.class, GuiText.LightTunnel ),

	// P2PTunnelOpenComputers( 468, EnumSet.of( AEFeature.P2PTunnel, AEFeature.P2PTunnelOpenComputers ), EnumSet.of(
	// IntegrationType.OpenComputers ), PartP2POpenComputers.class, GuiText.OCTunnel ),

	// P2PTunnelPressure( 469, EnumSet.of( AEFeature.P2PTunnel, AEFeature.P2PTunnelPressure ), EnumSet.of(
	// IntegrationType.PneumaticCraft ), PartP2PPressure.class, GuiText.PressureTunnel ),

	InterfaceTerminal( 480, new ResourceLocation( AppEng.MOD_ID, "interface_terminal" ), EnumSet.of( AEFeature.InterfaceTerminal ), EnumSet.noneOf( IntegrationType.class ), PartInterfaceTerminal.class );

	private final int baseDamage;
	private final ResourceLocation name;
	private final Set<AEFeature> features;
	private final Set<IntegrationType> integrations;
	private final Class<? extends IPart> myPart;
	private final GuiText extraName;
	private Constructor<? extends IPart> constructor;

	PartType( final int baseMetaValue, final ResourceLocation name, final Set<AEFeature> features, final Set<IntegrationType> integrations, final Class<? extends IPart> c )
	{
		this( baseMetaValue, name, features, integrations, c, null );
	}

	PartType( final int baseMetaValue, final ResourceLocation name, final Set<AEFeature> features, final Set<IntegrationType> integrations, final Class<? extends IPart> c, final GuiText en )
	{
		this.baseDamage = baseMetaValue;
		this.name = name;
		this.features = Collections.unmodifiableSet( features );
		this.integrations = Collections.unmodifiableSet( integrations );
		this.myPart = c;
		this.extraName = en;
	}

	int getBaseDamage()
	{
		return this.baseDamage;
	}

	public ResourceLocation getName()
	{
		return name;
	}

	public ResourceLocation getModel()
	{
		return new ResourceLocation( name.getResourceDomain(), "part/" + name.getResourcePath() );
	}

	public boolean isCable()
	{
		return false;
	}

	Set<AEFeature> getFeature()
	{
		return this.features;
	}

	Set<IntegrationType> getIntegrations()
	{
		return this.integrations;
	}

	Class<? extends IPart> getPart()
	{
		return this.myPart;
	}

	GuiText getExtraName()
	{
		return this.extraName;
	}

	Constructor<? extends IPart> getConstructor()
	{
		return this.constructor;
	}

	void setConstructor( final Constructor<? extends IPart> constructor )
	{
		this.constructor = constructor;
	}

}
