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

package appeng.core.tile;


import appeng.core.api.config.AccessRestriction;
import appeng.core.api.config.Actionable;
import appeng.core.api.config.PowerMultiplier;
import appeng.core.api.util.AECableType;
import appeng.core.api.util.AEPartLocation;
import appeng.core.me.api.networking.energy.IAEPowerStorage;
import appeng.core.me.tile.AENetworkTile;


public class TileCreativeEnergyCell extends AENetworkTile implements IAEPowerStorage
{

	public TileCreativeEnergyCell()
	{
		this.getProxy().setIdlePowerUsage( 0 );
	}

	@Override
	public AECableType getCableConnectionType( final AEPartLocation dir )
	{
		return AECableType.COVERED;
	}

	@Override
	public double injectAEPower( final double amt, final Actionable mode )
	{
		return 0;
	}

	@Override
	public double getAEMaxPower()
	{
		return Long.MAX_VALUE / 10000;
	}

	@Override
	public double getAECurrentPower()
	{
		return Long.MAX_VALUE / 10000;
	}

	@Override
	public boolean isAEPublicPowerStorage()
	{
		return true;
	}

	@Override
	public AccessRestriction getPowerFlow()
	{
		return AccessRestriction.READ_WRITE;
	}

	@Override
	public double extractAEPower( final double amt, final Actionable mode, final PowerMultiplier pm )
	{
		return amt;
	}
}
