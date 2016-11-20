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

package appeng.core.lib.stats;


import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;

import appeng.api.definitions.IItemDefinition;
import appeng.core.lib.AppEngApi;


public enum Achievements
{
	// done
	Compass( -2, -4, (IItemDefinition) AppEngApi.internalApi().definitions().blocks().skyCompass().maybeItem().get(), AchievementType.Craft ),

	// done
	Presses( -2, -2, AppEngApi.internalApi().definitions().materials().logicProcessorPress(), AchievementType.Custom ),

	// done
	SpatialIO( -4, -4, (IItemDefinition) AppEngApi.internalApi().definitions().blocks().spatialIOPort().block().maybeItem().get(), AchievementType.Craft ),

	// done
	SpatialIOExplorer( -4, -2, AppEngApi.internalApi().definitions().items().spatialCell128(), AchievementType.Custom ),

	// done
	StorageCell( -6, -4, AppEngApi.internalApi().definitions().items().cell64k(), AchievementType.CraftItem ),

	// done
	IOPort( -6, -2, (IItemDefinition) AppEngApi.internalApi().definitions().blocks().iOPort().block().maybeItem().get(), AchievementType.Craft ),

	// done
	CraftingTerminal( -8, -4, AppEngApi.internalApi().definitions().parts().craftingTerminal(), AchievementType.Craft ),

	// done
	PatternTerminal( -8, -2, AppEngApi.internalApi().definitions().parts().patternTerminal(), AchievementType.Craft ),

	// done
	ChargedQuartz( 0, -4, AppEngApi.internalApi().definitions().materials().certusQuartzCrystalCharged(), AchievementType.Pickup ),

	// done
	Fluix( 0, -2, AppEngApi.internalApi().definitions().materials().fluixCrystal(), AchievementType.Pickup ),

	// done
	Charger( 0, 0, (IItemDefinition) AppEngApi.internalApi().definitions().blocks().charger().block().maybeItem().get(), AchievementType.Craft ),

	// done
	CrystalGrowthAccelerator( -2, 0, (IItemDefinition) AppEngApi.internalApi().definitions().blocks().quartzGrowthAccelerator().block().maybeItem().get(), AchievementType.Craft ),

	// done
	GlassCable( 2, 0, AppEngApi.internalApi().definitions().parts().cableGlass(), AchievementType.Craft ),

	// done
	Networking1( 4, -6, AppEngApi.internalApi().definitions().parts().cableCovered(), AchievementType.Custom ),

	// done
	Controller( 4, -4, AppEngApi.internalApi().definitions().blocks().controller().block().maybeItem().get(), AchievementType.Craft ),

	// done
	Networking2( 4, 0, AppEngApi.internalApi().definitions().parts().cableSmart(), AchievementType.Custom ),

	// done
	Networking3( 4, 2, AppEngApi.internalApi().definitions().parts().cableDense(), AchievementType.Custom ),

	// done
	P2P( 2, -2, AppEngApi.internalApi().definitions().parts().p2PTunnelME(), AchievementType.Craft ),

	// done
	Recursive( 6, -2, (IItemDefinition) AppEngApi.internalApi().definitions().blocks().iface(), AchievementType.Craft ),

	// done
	CraftingCPU( 6, 0, (IItemDefinition) AppEngApi.internalApi().definitions().blocks().craftingStorage64k(), AchievementType.CraftItem ),

	// done
	Facade( 6, 2, AppEngApi.internalApi().definitions().items().facade(), AchievementType.CraftItem ),

	// done
	NetworkTool( 8, 0, AppEngApi.internalApi().definitions().items().networkTool(), AchievementType.Craft ),

	// done
	PortableCell( 8, 2, AppEngApi.internalApi().definitions().items().portableCell(), AchievementType.Craft ),

	// done
	StorageBus( 10, 0, AppEngApi.internalApi().definitions().parts().storageBus(), AchievementType.Craft ),

	// done
	QNB( 10, 2, (IItemDefinition) AppEngApi.internalApi().definitions().blocks().quantumLink().block().maybeItem().get(), AchievementType.Craft );

	private final ItemStack stack;
	private final AchievementType type;
	private final int x;
	private final int y;

	private Achievement parent;
	private Achievement stat;

	Achievements( final int x, final int y, final IItemDefinition which, final AchievementType type )
	{
		this.stack = (ItemStack) which.maybeStack( 1 ).orElse( null );
		this.type = type;
		this.x = x;
		this.y = y;
	}

	Achievements( final int x, final int y, final ItemStack which, final AchievementType type )
	{
		this.stack = which;
		this.type = type;
		this.x = x;
		this.y = y;
	}

	void setParent( final Achievements parent )
	{
		this.parent = parent.getAchievement();
	}

	public Achievement getAchievement()
	{
		if( this.stat == null && this.getStack() != null )
		{
			this.stat = new Achievement( "achievement.ae2." + this.name(), "ae2." + this.name(), this.x, this.y, this.getStack(), this.parent );
			this.stat.registerStat();
		}

		return this.stat;
	}

	public void addToPlayer( final EntityPlayer player )
	{
		player.addStat( this.getAchievement(), 1 );
	}

	AchievementType getType()
	{
		return this.type;
	}

	ItemStack getStack()
	{
		return this.stack;
	}

}
