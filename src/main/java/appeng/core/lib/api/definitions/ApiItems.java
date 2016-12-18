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
//TODO: AEColoredItemDefinition class does not exist. -legracen
import appeng.core.api.util.AEColoredItemDefinition;
import appeng.core.crafting.item.ItemEncodedPattern;
import appeng.core.item.ItemCrystalSeed;
import appeng.core.item.ItemCrystalSeedRendering;
import appeng.core.item.MaterialType;
import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.features.AEFeature;
import appeng.core.me.CreativeTabFacade;
import appeng.core.me.item.ItemBasicStorageCell;
import appeng.core.me.item.ItemCreativeStorageCell;
import appeng.core.me.item.ItemViewCell;
import appeng.core.me.item.ToolWirelessTerminal;
import appeng.core.spatial.item.ItemSpatialStorageCell;
import appeng.debug.ToolDebugCard;
import appeng.debug.ToolEraser;
import appeng.debug.ToolMeteoritePlacer;
import appeng.debug.ToolReplicatorCard;
import appeng.decorative.item.ItemFacade;
import appeng.tools.item.ToolBiometricCard;
import appeng.tools.item.ToolChargedStaff;
import appeng.tools.item.ToolColorApplicator;
import appeng.tools.item.ToolEntropyManipulator;
import appeng.tools.item.ToolMassCannon;
import appeng.tools.item.ToolMemoryCard;
import appeng.tools.item.ToolNetworkTool;
import appeng.tools.item.ToolPortableCell;
import appeng.tools.item.ToolQuartzAxe;
import appeng.tools.item.ToolQuartzCuttingKnife;
import appeng.tools.item.ToolQuartzHoe;
import appeng.tools.item.ToolQuartzPickaxe;
import appeng.tools.item.ToolQuartzSpade;
import appeng.tools.item.ToolQuartzSword;
import appeng.tools.item.ToolQuartzWrench;


/**
 * Internal implementation for the API items
 */
public final class ApiItems// implements IItems
{
	
	public ApiItems( FeatureFactory registry )
	{
		
	}

	/* @Override */
	public IItemDefinition certusQuartzAxe()
	{
		return this.certusQuartzAxe;
	}

	/* @Override */
	public IItemDefinition certusQuartzHoe()
	{
		return this.certusQuartzHoe;
	}

	/* @Override */
	public IItemDefinition certusQuartzShovel()
	{
		return this.certusQuartzShovel;
	}

	/* @Override */
	public IItemDefinition certusQuartzPick()
	{
		return this.certusQuartzPick;
	}

	/* @Override */
	public IItemDefinition certusQuartzSword()
	{
		return this.certusQuartzSword;
	}

	/* @Override */
	public IItemDefinition certusQuartzWrench()
	{
		return this.certusQuartzWrench;
	}

	/* @Override */
	public IItemDefinition certusQuartzKnife()
	{
		return this.certusQuartzKnife;
	}

	/* @Override */
	public IItemDefinition netherQuartzAxe()
	{
		return this.netherQuartzAxe;
	}

	/* @Override */
	public IItemDefinition netherQuartzHoe()
	{
		return this.netherQuartzHoe;
	}

	/* @Override */
	public IItemDefinition netherQuartzShovel()
	{
		return this.netherQuartzShovel;
	}

	/* @Override */
	public IItemDefinition netherQuartzPick()
	{
		return this.netherQuartzPick;
	}

	/* @Override */
	public IItemDefinition netherQuartzSword()
	{
		return this.netherQuartzSword;
	}

	/* @Override */
	public IItemDefinition netherQuartzWrench()
	{
		return this.netherQuartzWrench;
	}

	/* @Override */
	public IItemDefinition netherQuartzKnife()
	{
		return this.netherQuartzKnife;
	}

	/* @Override */
	public IItemDefinition entropyManipulator()
	{
		return this.entropyManipulator;
	}

	/* @Override */
	public IItemDefinition wirelessTerminal()
	{
		return this.wirelessTerminal;
	}

	/* @Override */
	public IItemDefinition biometricCard()
	{
		return this.biometricCard;
	}

	/* @Override */
	public IItemDefinition chargedStaff()
	{
		return this.memoryCard;
	}

	/* @Override */
	public IItemDefinition massCannon()
	{
		return this.massCannon;
	}

	/* @Override */
	public IItemDefinition memoryCard()
	{
		return this.memoryCard;
	}

	/* @Override */
	public IItemDefinition networkTool()
	{
		return this.networkTool;
	}

	/* @Override */
	public IItemDefinition portableCell()
	{
		return this.portableCell;
	}

	/* @Override */
	public IItemDefinition cellCreative()
	{
		return this.cellCreative;
	}

	/* @Override */
	public IItemDefinition viewCell()
	{
		return this.viewCell;
	}

	/* @Override */
	public IItemDefinition cell1k()
	{
		return this.cell1k;
	}

	/* @Override */
	public IItemDefinition cell4k()
	{
		return this.cell4k;
	}

	/* @Override */
	public IItemDefinition cell16k()
	{
		return this.cell16k;
	}

	/* @Override */
	public IItemDefinition cell64k()
	{
		return this.cell64k;
	}

	/* @Override */
	public IItemDefinition spatialCell2()
	{
		return this.spatialCell2;
	}

	/* @Override */
	public IItemDefinition spatialCell16()
	{
		return this.spatialCell16;
	}

	/* @Override */
	public IItemDefinition spatialCell128()
	{
		return this.spatialCell128;
	}

	/* @Override */
	public IItemDefinition facade()
	{
		return this.facade;
	}

	/* @Override */
	public IItemDefinition encodedPattern()
	{
		return this.encodedPattern;
	}

	/* @Override */
	public IItemDefinition colorApplicator()
	{
		return this.colorApplicator;
	}

	/* @Override */
	public AEColoredItemDefinition coloredPaintBall()
	{
		return this.coloredPaintBall;
	}

	/* @Override */
	public AEColoredItemDefinition coloredLumenPaintBall()
	{
		return this.coloredLumenPaintBall;
	}

	public IItemDefinition paintBall()
	{
		return this.paintBall;
	}

	public IItemDefinition toolEraser()
	{
		return this.toolEraser;
	}

	public IItemDefinition toolMeteoritePlacer()
	{
		return this.toolMeteoritePlacer;
	}

	public IItemDefinition toolDebugCard()
	{
		return this.toolDebugCard;
	}

	public IItemDefinition toolReplicatorCard()
	{
		return this.toolReplicatorCard;
	}
}
