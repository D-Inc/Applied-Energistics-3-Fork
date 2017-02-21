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

package appeng.core.lib.features.registries;


import appeng.core.api.features.IWorldGen;


/**
 * represents all registries
 *
 * @author AlgorithmX2
 * @author thatsIch
 * @version rv2
 * @since rv0
 */
@Deprecated
public class RegistryContainer
{
	private final GrinderRecipeManager grinder = new GrinderRecipeManager();
	private final InscriberRegistry inscriber = new InscriberRegistry();
	private final ExternalStorageRegistry storage = new ExternalStorageRegistry();
	private final CellRegistry cell = new CellRegistry();
	private final LocatableRegistry locatable = new LocatableRegistry();
	private final SpecialComparisonRegistry comparison = new SpecialComparisonRegistry();
	private final WirelessRegistry wireless = new WirelessRegistry();
	private final GridCacheRegistry gridCache = new GridCacheRegistry();
	private final P2PTunnelRegistry p2pTunnel = new P2PTunnelRegistry();
	private final MatterCannonAmmoRegistry matterCannonReg = new MatterCannonAmmoRegistry();
	private final PlayerRegistry playerRegistry = new PlayerRegistry();

	public GridCacheRegistry gridCache()
	{
		return this.gridCache;
	}

	public ExternalStorageRegistry externalStorage()
	{
		return this.storage;
	}

	public SpecialComparisonRegistry specialComparison()
	{
		return this.comparison;
	}

	public WirelessRegistry wireless()
	{
		return this.wireless;
	}

	public CellRegistry cell()
	{
		return this.cell;
	}

	public GrinderRecipeManager grinder()
	{
		return this.grinder;
	}

	public InscriberRegistry inscriber()
	{
		return this.inscriber;
	}

	public LocatableRegistry locatable()
	{
		return this.locatable;
	}

	public P2PTunnelRegistry p2pTunnel()
	{
		return this.p2pTunnel;
	}

	public MatterCannonAmmoRegistry matterCannon()
	{
		return this.matterCannonReg;
	}

	public PlayerRegistry players()
	{
		return this.playerRegistry;
	}

	public IWorldGen worldgen()
	{
		return WorldGenRegistry.INSTANCE;
	}
}
