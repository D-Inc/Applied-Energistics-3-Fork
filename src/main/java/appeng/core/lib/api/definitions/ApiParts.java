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

package appeng.core.lib.api.definitions;


import appeng.api.definitions.IItemDefinition;
import appeng.core.api.exceptions.MissingDefinition;
import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.me.api.parts.IPartHelper;
import appeng.core.me.item.ItemMultiPart;
import appeng.core.me.item.PartType;

//TODO 1.11-CN:A - @Elix_x has plans...
/**
 * Internal implementation for the API parts
 */
public  class ApiParts// implements IParts
{
	private  IItemDefinition cableSmart;
	private  IItemDefinition cableCovered;
	private  IItemDefinition cableGlass;
	private  IItemDefinition cableDense;
	// private  AEColoredItemDefinition lumenCableSmart;
	// private  AEColoredItemDefinition lumenCableCovered;
	// private  AEColoredItemDefinition lumenCableGlass;
	// private  AEColoredItemDefinition lumenCableDense;
	private  IItemDefinition quartzFiber;
	private  IItemDefinition toggleBus;
	private  IItemDefinition invertedToggleBus;
	private  IItemDefinition storageBus;
	private  IItemDefinition importBus;
	private  IItemDefinition exportBus;
	private  IItemDefinition iface;
	private  IItemDefinition levelEmitter;
	private  IItemDefinition annihilationPlane;
	private  IItemDefinition identityAnnihilationPlane;
	private  IItemDefinition formationPlane;
	private  IItemDefinition p2PTunnelME;
	private  IItemDefinition p2PTunnelRedstone;
	private  IItemDefinition p2PTunnelItems;
	private  IItemDefinition p2PTunnelLiquids;
	// private  IItemDefinition p2PTunnelEU;
	// private  IItemDefinition p2PTunnelRF;
	private  IItemDefinition p2PTunnelLight;
	// private  IItemDefinition p2PTunnelOpenComputers;
	// private  IItemDefinition p2PTunnelPneumaticCraft;
	private  IItemDefinition cableAnchor;
	private  IItemDefinition monitor;
	private  IItemDefinition semiDarkMonitor;
	private  IItemDefinition darkMonitor;
	private  IItemDefinition interfaceTerminal;
	private  IItemDefinition patternTerminal;
	private  IItemDefinition craftingTerminal;
	private  IItemDefinition terminal;
	private  IItemDefinition storageMonitor;
	private  IItemDefinition conversionMonitor;

	public ApiParts( FeatureFactory registry, IPartHelper partHelper )
	{
//		 ItemMultiPart itemMultiPart = new ItemMultiPart( partHelper );
//		registry.item( "multipart", () -> itemMultiPart ).rendering( new ItemMultipartRendering( itemMultiPart ) ).build();
//
//		this.cableSmart = constructColoredDefinition( itemMultiPart, PartType.CableSmart );
//		this.cableCovered = constructColoredDefinition( itemMultiPart, PartType.CableCovered );
//		this.cableGlass = constructColoredDefinition( itemMultiPart, PartType.CableGlass );
//		this.cableDense = constructColoredDefinition( itemMultiPart, PartType.CableDense );
//		// this.lumenCableSmart = Optional.absent(); // has yet to be implemented, no PartType defined for it yet
//		// this.lumenCableCovered = Optional.absent(); // has yet to be implemented, no PartType defined for it yet
//		// this.lumenCableGlass = Optional.absent(); // has yet to be implemented, no PartType defined for it yet
//		// this.lumenCableDense = Optional.absent(); // has yet to be implemented, no PartType defined for it yet
//		this.quartzFiber = new DamagedItemDefinition( "part.quartz_fiber", itemMultiPart.createPart( PartType.QuartzFiber ) );
//		this.toggleBus = new DamagedItemDefinition( "part.toggle_bus", itemMultiPart.createPart( PartType.ToggleBus ) );
//		this.invertedToggleBus = new DamagedItemDefinition( "part.toggle_bus.inverted", itemMultiPart.createPart( PartType.InvertedToggleBus ) );
//		this.storageBus = new DamagedItemDefinition( "part.bus.storage", itemMultiPart.createPart( PartType.StorageBus ) );
//		this.importBus = new DamagedItemDefinition( "part.bus.import", itemMultiPart.createPart( PartType.ImportBus ) );
//		this.exportBus = new DamagedItemDefinition( "part.bus.export", itemMultiPart.createPart( PartType.ExportBus ) );
//		this.iface = new DamagedItemDefinition( "part.interface", itemMultiPart.createPart( PartType.Interface ) );
//		this.levelEmitter = new DamagedItemDefinition( "part.level_emitter", itemMultiPart.createPart( PartType.LevelEmitter ) );
//		this.annihilationPlane = new DamagedItemDefinition( "part.plane.annihilation", itemMultiPart.createPart( PartType.AnnihilationPlane ) );
//		this.identityAnnihilationPlane = new DamagedItemDefinition( "part.plane.annihiliation.identity", itemMultiPart.createPart( PartType.IdentityAnnihilationPlane ) );
//		this.formationPlane = new DamagedItemDefinition( "part.plane.formation", itemMultiPart.createPart( PartType.FormationPlane ) );
//		this.p2PTunnelME = new DamagedItemDefinition( "part.tunnel.me", itemMultiPart.createPart( PartType.P2PTunnelME ) );
//		this.p2PTunnelRedstone = new DamagedItemDefinition( "part.tunnel.redstone", itemMultiPart.createPart( PartType.P2PTunnelRedstone ) );
//		this.p2PTunnelItems = new DamagedItemDefinition( "part.tunnel.item", itemMultiPart.createPart( PartType.P2PTunnelItems ) );
//		this.p2PTunnelLiquids = new DamagedItemDefinition( "part.tunnel.fluid", itemMultiPart.createPart( PartType.P2PTunnelLiquids ) );
//		// this.p2PTunnelEU = new DamagedItemDefinition( itemMultiPart.createPart( PartType.P2PTunnelEU ) );
//		// this.p2PTunnelRF = new DamagedItemDefinition( itemMultiPart.createPart( PartType.P2PTunnelRF ) );
//		this.p2PTunnelLight = new DamagedItemDefinition( "part.tunnel.light", itemMultiPart.createPart( PartType.P2PTunnelLight ) );
//		// this.p2PTunnelOpenComputers = new DamagedItemDefinition( itemMultiPart.createPart(
//		// PartType.P2PTunnelOpenComputers ) );
//		// this.p2PTunnelPneumaticCraft = new DamagedItemDefinition( itemMultiPart.createPart(
//		// PartType.P2PTunnelPressure ) );
//		this.cableAnchor = new DamagedItemDefinition( "part.cable_anchor", itemMultiPart.createPart( PartType.CableAnchor ) );
//		this.monitor = new DamagedItemDefinition( "part.monitor", itemMultiPart.createPart( PartType.Monitor ) );
//		this.semiDarkMonitor = new DamagedItemDefinition( "part.monitor.semi_dark", itemMultiPart.createPart( PartType.SemiDarkMonitor ) );
//		this.darkMonitor = new DamagedItemDefinition( "part.monitor.dark", itemMultiPart.createPart( PartType.DarkMonitor ) );
//		this.interfaceTerminal = new DamagedItemDefinition( "part.terminal.interface", itemMultiPart.createPart( PartType.InterfaceTerminal ) );
//		this.patternTerminal = new DamagedItemDefinition( "part.terminal.pattern", itemMultiPart.createPart( PartType.PatternTerminal ) );
//		this.craftingTerminal = new DamagedItemDefinition( "part.terminal.crafting", itemMultiPart.createPart( PartType.CraftingTerminal ) );
//		this.terminal = new DamagedItemDefinition( "part.terminal", itemMultiPart.createPart( PartType.Terminal ) );
//		this.storageMonitor = new DamagedItemDefinition( "part.monitor.storage", itemMultiPart.createPart( PartType.StorageMonitor ) );
//		this.conversionMonitor = new DamagedItemDefinition( "part.monitor.conversion", itemMultiPart.createPart( PartType.ConversionMonitor ) );
	}

	private static IItemDefinition constructColoredDefinition(  ItemMultiPart target,  PartType type )
	{
		return null;
		/* ColoredItemDefinition definition = new ColoredItemDefinition();

		for(  AEColor color : AEColor.values() )
		{
			 ItemStackSrc multiPartSource = target.createPart( type, color );

			definition.add( color, multiPartSource );
		}

		return definition;*/
	}

	/*@Override*/
	public IItemDefinition cableSmart()
	{
		return this.cableSmart;
	}

	/*@Override*/
	public IItemDefinition cableCovered()
	{
		return this.cableCovered;
	}

	/*@Override*/
	public IItemDefinition cableGlass()
	{
		return this.cableGlass;
	}

	/*@Override*/
	public IItemDefinition cableDense()
	{
		return this.cableDense;
	}

	/*@Override*/
	public IItemDefinition lumenCableSmart()
	{
		throw new MissingDefinition( "Lumen Smart Cable has yet to be implemented." );
		// return this.lumenCableSmart;
	}

	/*@Override*/
	public IItemDefinition lumenCableCovered()
	{
		throw new MissingDefinition( "Lumen Covered Cable has yet to be implemented." );
		// return this.lumenCableCovered;
	}

	/*@Override*/
	public IItemDefinition lumenCableGlass()
	{
		throw new MissingDefinition( "Lumen Glass Cable has yet to be implemented." );
		// return this.lumenCableGlass;
	}

	/*@Override*/
	public IItemDefinition lumenCableDense()
	{
		throw new MissingDefinition( "Lumen Dense Cable has yet to be implemented." );
		// return this.lumenCableDense;
	}

	/*@Override*/
	public IItemDefinition quartzFiber()
	{
		return this.quartzFiber;
	}

	/*@Override*/
	public IItemDefinition toggleBus()
	{
		return this.toggleBus;
	}

	/*@Override*/
	public IItemDefinition invertedToggleBus()
	{
		return this.invertedToggleBus;
	}

	/*@Override*/
	public IItemDefinition storageBus()
	{
		return this.storageBus;
	}

	/*@Override*/
	public IItemDefinition importBus()
	{
		return this.importBus;
	}

	/*@Override*/
	public IItemDefinition exportBus()
	{
		return this.exportBus;
	}

	/*@Override*/
	public IItemDefinition iface()
	{
		return this.iface;
	}

	/*@Override*/
	public IItemDefinition levelEmitter()
	{
		return this.levelEmitter;
	}

	/*@Override*/
	public IItemDefinition annihilationPlane()
	{
		return this.annihilationPlane;
	}

	/*@Override*/
	public IItemDefinition identityAnnihilationPlane()
	{
		return this.identityAnnihilationPlane;
	}

	/*@Override*/
	public IItemDefinition formationPlane()
	{
		return this.formationPlane;
	}

	/*@Override*/
	public IItemDefinition p2PTunnelME()
	{
		return this.p2PTunnelME;
	}

	/*@Override*/
	public IItemDefinition p2PTunnelRedstone()
	{
		return this.p2PTunnelRedstone;
	}

	/*@Override*/
	public IItemDefinition p2PTunnelItems()
	{
		return this.p2PTunnelItems;
	}

	/*@Override*/
	public IItemDefinition p2PTunnelLiquids()
	{
		return this.p2PTunnelLiquids;
	}

	/*
	 * @Override
	 * public IItemDefinition p2PTunnelEU()
	 * {
	 * return this.p2PTunnelEU;
	 * }
	 * @Override
	 * public IItemDefinition p2PTunnelRF()
	 * {
	 * return this.p2PTunnelRF;
	 * }
	 */

	/*@Override*/
	public IItemDefinition p2PTunnelLight()
	{
		return this.p2PTunnelLight;
	}

	/*
	 * @Override
	 * public IItemDefinition p2PTunnelOpenComputers()
	 * {
	 * return this.p2PTunnelOpenComputers;
	 * }
	 * @Override
	 * public IItemDefinition p2PTunnelPneumaticCraft()
	 * {
	 * return this.p2PTunnelPneumaticCraft;
	 * }
	 */

	/*@Override*/
	public IItemDefinition cableAnchor()
	{
		return this.cableAnchor;
	}

	/*@Override*/
	public IItemDefinition monitor()
	{
		return this.monitor;
	}

	/*@Override*/
	public IItemDefinition semiDarkMonitor()
	{
		return this.semiDarkMonitor;
	}

	/*@Override*/
	public IItemDefinition darkMonitor()
	{
		return this.darkMonitor;
	}

	/*@Override*/
	public IItemDefinition interfaceTerminal()
	{
		return this.interfaceTerminal;
	}

	/*@Override*/
	public IItemDefinition patternTerminal()
	{
		return this.patternTerminal;
	}

	/*@Override*/
	public IItemDefinition craftingTerminal()
	{
		return this.craftingTerminal;
	}

	/*@Override*/
	public IItemDefinition terminal()
	{
		return this.terminal;
	}

	/*@Override*/
	public IItemDefinition storageMonitor()
	{
		return this.storageMonitor;
	}

	/*@Override*/
	public IItemDefinition conversionMonitor()
	{
		return this.conversionMonitor;
	}
}
