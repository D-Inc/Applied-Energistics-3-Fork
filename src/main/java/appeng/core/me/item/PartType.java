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

import appeng.core.AppEng;
import appeng.core.crafting.part.PartPatternTerminal;
import appeng.core.lib.features.AEFeature;
import appeng.core.lib.localization.GuiText;
import appeng.core.me.api.parts.IPart;
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
import appeng.core.me.part.reporting.PartConversionMonitor;
import appeng.core.me.part.reporting.PartCraftingTerminal;
import appeng.core.me.part.reporting.PartDarkPanel;
import appeng.core.me.part.reporting.PartInterfaceTerminal;
import appeng.core.me.part.reporting.PartPanel;
import appeng.core.me.part.reporting.PartSemiDarkPanel;
import appeng.core.me.part.reporting.PartStorageMonitor;
import appeng.core.me.part.reporting.PartTerminal;


public enum PartType
{
	InvalidType( -1, new ResourceLocation( AppEng.MODID, "invalid" ), EnumSet.of( AEFeature.Core ), null ),

	CableGlass( 0, new ResourceLocation( AppEng.MODID, "cable_glass" ), EnumSet.of( AEFeature.Core ), PartCableGlass.class )
	{
		@Override
		public boolean isCable()
		{
			return true;
		}
	},

	CableCovered( 20, new ResourceLocation( AppEng.MODID, "cable_covered" ), EnumSet.of( AEFeature.Core ), PartCableCovered.class )
	{
		@Override
		public boolean isCable()
		{
			return true;
		}
	},

	CableSmart( 40, new ResourceLocation( AppEng.MODID, "cable_smart" ), EnumSet.of( AEFeature.Channels ), PartCableSmart.class )
	{
		@Override
		public boolean isCable()
		{
			return true;
		}
	},

	CableDense( 60, new ResourceLocation( AppEng.MODID, "cable_dense" ), EnumSet.of( AEFeature.Channels ), PartDenseCable.class )
	{
		@Override
		public boolean isCable()
		{
			return true;
		}
	},

	ToggleBus( 80, new ResourceLocation( AppEng.MODID, "toggle_bus" ), EnumSet.of( AEFeature.Core ), PartToggleBus.class ),

	InvertedToggleBus( 100, new ResourceLocation( AppEng.MODID, "inverted_toggle_bus" ), EnumSet.of( AEFeature.Core ), PartInvertedToggleBus.class ),

	CableAnchor( 120, new ResourceLocation( AppEng.MODID, "cable_anchor" ), EnumSet.of( AEFeature.Core ), PartCableAnchor.class ),

	QuartzFiber( 140, new ResourceLocation( AppEng.MODID, "quartz_fiber" ), EnumSet.of( AEFeature.Core ), PartQuartzFiber.class ),

	Monitor( 160, new ResourceLocation( AppEng.MODID, "monitor" ), EnumSet.of( AEFeature.Core ), PartPanel.class ),

	SemiDarkMonitor( 180, new ResourceLocation( AppEng.MODID, "semi_dark_monitor" ), EnumSet.of( AEFeature.Core ), PartSemiDarkPanel.class ),

	DarkMonitor( 200, new ResourceLocation( AppEng.MODID, "dark_monitor" ), EnumSet.of( AEFeature.Core ), PartDarkPanel.class ),

	StorageBus( 220, new ResourceLocation( AppEng.MODID, "storage_bus" ), EnumSet.of( AEFeature.StorageBus ), PartStorageBus.class ),

	ImportBus( 240, new ResourceLocation( AppEng.MODID, "import_bus" ), EnumSet.of( AEFeature.ImportBus ), PartImportBus.class ),

	ExportBus( 260, new ResourceLocation( AppEng.MODID, "export_bus" ), EnumSet.of( AEFeature.ExportBus ), PartExportBus.class ),

	LevelEmitter( 280, new ResourceLocation( AppEng.MODID, "level_emitter" ), EnumSet.of( AEFeature.LevelEmitter ), PartLevelEmitter.class ),

	AnnihilationPlane( 300, new ResourceLocation( AppEng.MODID, "annihilation_plane" ), EnumSet.of( AEFeature.AnnihilationPlane ), PartAnnihilationPlane.class ),

	IdentityAnnihilationPlane( 301, new ResourceLocation( AppEng.MODID, "identity_annihilation_plane" ), EnumSet.of( AEFeature.AnnihilationPlane, AEFeature.IdentityAnnihilationPlane ), PartIdentityAnnihilationPlane.class ),

	FormationPlane( 320, new ResourceLocation( AppEng.MODID, "formation_plane" ), EnumSet.of( AEFeature.FormationPlane ), PartFormationPlane.class ),

	PatternTerminal( 340, new ResourceLocation( AppEng.MODID, "pattern_terminal" ), EnumSet.of( AEFeature.Patterns ), PartPatternTerminal.class ),

	CraftingTerminal( 360, new ResourceLocation( AppEng.MODID, "crafting_terminal" ), EnumSet.of( AEFeature.CraftingTerminal ), PartCraftingTerminal.class ),

	Terminal( 380, new ResourceLocation( AppEng.MODID, "terminal" ), EnumSet.of( AEFeature.Core ), PartTerminal.class ),

	StorageMonitor( 400, new ResourceLocation( AppEng.MODID, "storage_monitor" ), EnumSet.of( AEFeature.StorageMonitor ), PartStorageMonitor.class ),

	ConversionMonitor( 420, new ResourceLocation( AppEng.MODID, "conversion_monitor" ), EnumSet.of( AEFeature.PartConversionMonitor ), PartConversionMonitor.class ),

	Interface( 440, new ResourceLocation( AppEng.MODID, "interface" ), EnumSet.of( AEFeature.Core ), PartInterface.class ),

	InterfaceTerminal( 480, new ResourceLocation( AppEng.MODID, "interface_terminal" ), EnumSet.of( AEFeature.InterfaceTerminal ), PartInterfaceTerminal.class );

	private final int baseDamage;
	private final ResourceLocation name;
	private final Set<AEFeature> features;
	private final Class<? extends IPart> myPart;
	private final GuiText extraName;
	private Constructor<? extends IPart> constructor;

	PartType( final int baseMetaValue, final ResourceLocation name, final Set<AEFeature> features, final Class<? extends IPart> c )
	{
		this( baseMetaValue, name, features, c, null );
	}

	PartType( final int baseMetaValue, final ResourceLocation name, final Set<AEFeature> features, final Class<? extends IPart> c, final GuiText en )
	{
		this.baseDamage = baseMetaValue;
		this.name = name;
		this.features = Collections.unmodifiableSet( features );
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
