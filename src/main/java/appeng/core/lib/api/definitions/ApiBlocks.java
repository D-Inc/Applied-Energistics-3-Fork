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


import net.minecraft.block.Block;
import net.minecraft.block.BlockDispenser;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

import appeng.api.definitions.IBlockDefinition;
import appeng.api.definitions.ITileDefinition;
import appeng.core.AppEng;
import appeng.core.block.BlockCharger;
import appeng.core.block.BlockGrinder;
import appeng.core.block.BlockInscriber;
import appeng.core.block.BlockVibrationChamber;
import appeng.core.crafting.block.BlockCraftingMonitor;
import appeng.core.crafting.block.BlockCraftingStorage;
import appeng.core.crafting.block.BlockCraftingUnit;
import appeng.core.crafting.block.BlockCraftingUnit.CraftingUnitType;
import appeng.core.crafting.block.BlockMolecularAssembler;
import appeng.core.crafting.block.ItemCraftingStorage;
import appeng.core.lib.bootstrap.BlockRenderingCustomizer;
import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.bootstrap.IBlockRendering;
import appeng.core.lib.bootstrap.IItemRendering;
import appeng.core.lib.features.AEFeature;
import appeng.core.lib.item.AEBaseItemBlockChargeable;
import appeng.core.me.block.BlockCableBus;
import appeng.core.me.block.BlockCellWorkbench;
import appeng.core.me.block.BlockChest;
import appeng.core.me.block.BlockCondenser;
import appeng.core.me.block.BlockController;
import appeng.core.me.block.BlockCreativeEnergyCell;
import appeng.core.me.block.BlockDenseEnergyCell;
import appeng.core.me.block.BlockDrive;
import appeng.core.me.block.BlockEnergyAcceptor;
import appeng.core.me.block.BlockEnergyCell;
import appeng.core.me.block.BlockEnergyCellRendering;
import appeng.core.me.block.BlockIOPort;
import appeng.core.me.block.BlockInterface;
import appeng.core.me.block.BlockQuantumLinkChamber;
import appeng.core.me.block.BlockQuantumRing;
import appeng.core.me.block.BlockSecurity;
import appeng.core.me.block.BlockWireless;
import appeng.core.me.block.CableBusColor;
import appeng.core.me.block.CableModelCustomizer;
import appeng.core.spatial.block.BlockMatrixFrame;
import appeng.core.spatial.block.BlockSpatialIOPort;
import appeng.core.spatial.block.BlockSpatialPylon;
import appeng.core.worldgen.block.BlockChargedQuartzOre;
import appeng.core.worldgen.block.BlockQuartz;
import appeng.core.worldgen.block.BlockQuartzOre;
import appeng.core.worldgen.block.BlockSkyChest;
import appeng.core.worldgen.block.BlockSkyChest.SkyChestType;
import appeng.core.worldgen.block.BlockSkyStone;
import appeng.core.worldgen.block.BlockSkyStone.SkystoneType;
import appeng.core.worldgen.client.render.SkyChestRenderingCustomizer;
import appeng.debug.BlockChunkloader;
import appeng.debug.BlockCubeGenerator;
import appeng.debug.BlockItemGen;
import appeng.debug.BlockPhantomNode;
import appeng.decorative.block.BlockChiseledQuartz;
import appeng.decorative.block.BlockFluix;
import appeng.decorative.block.BlockQuartzGlass;
import appeng.decorative.block.BlockQuartzLamp;
import appeng.decorative.block.BlockQuartzPillar;
import appeng.decorative.block.BlockStairCommon;
import appeng.miscellaneous.block.BlockLightDetector;
import appeng.miscellaneous.block.BlockPaint;
import appeng.miscellaneous.block.BlockQuartzGrowthAccelerator;
import appeng.miscellaneous.block.BlockQuartzTorch;
import appeng.miscellaneous.block.BlockSkyCompass;
import appeng.miscellaneous.block.BlockTinyTNT;
import appeng.tools.hooks.DispenserBehaviorTinyTNT;


/**
 * Internal implementation for the API blocks
 */
public final class ApiBlocks// implements IBlocks
{

	public ApiBlocks( FeatureFactory registry )
	{
		// TODO Pre-1.8 - Re-Add Slabs...
		/*
		 * this.skyStoneSlab = constructor.registerBlockDefinition( new AEBaseSlabBlock( skyStone_stone,
		 * EnumSet.of(AEFeature.DecorativeQuartzBlocks), false, "SkyStoneSlabBlock" ) );
		 * this.skyStoneBlockSlab = constructor.registerBlockDefinition( new AEBaseSlabBlock( skyStone_block,
		 * EnumSet.of(AEFeature.DecorativeQuartzBlocks), false, "SkyStoneBlockSlabBlock" ) );
		 * this.skyStoneBrickSlab = constructor.registerBlockDefinition( new AEBaseSlabBlock( skyStone_brick,
		 * EnumSet.of(AEFeature.DecorativeQuartzBlocks), false, "SkyStoneBrickSlabBlock" ) );
		 * this.skyStoneSmallBrickSlab = constructor.registerBlockDefinition( new AEBaseSlabBlock( skyStone_smallbrick,
		 * EnumSet.of(AEFeature.DecorativeQuartzBlocks), false, "SkyStoneSmallBrickSlabBlock" ) );
		 * this.fluixSlab = constructor.registerBlockDefinition( new AEBaseSlabBlock( fluixBlock,
		 * EnumSet.of(AEFeature.DecorativeQuartzBlocks), false, "FluixSlabBlock" ) );
		 * this.quartzSlab = constructor.registerBlockDefinition( new AEBaseSlabBlock( quartzBlock,
		 * EnumSet.of(AEFeature.DecorativeQuartzBlocks), false, "QuartzSlabBlock" ) );
		 * this.chiseledQuartzSlab = constructor.registerBlockDefinition( new AEBaseSlabBlock( chiseledQuartzBlock,
		 * EnumSet.of(AEFeature.DecorativeQuartzBlocks), false, "ChiseledQuartzSlabBlock" ) );
		 * this.quartzPillarSlab = constructor.registerBlockDefinition( new AEBaseSlabBlock( quartzPillar,
		 * EnumSet.of(AEFeature.DecorativeQuartzBlocks), false, "QuartzPillarSlabBlock" ) )
		 */

	}

	/* @Override */
	public IBlockDefinition quartzOre()
	{
		return null;
	}

	/* @Override */
	public IBlockDefinition quartzOreCharged()
	{
		return null;
	}

	/* @Override */
	public IBlockDefinition matrixFrame()
	{
		return null;
	}

	/* @Override */
	public IBlockDefinition quartzBlock()
	{
		return null;
	}

	/* @Override */
	public IBlockDefinition quartzPillar()
	{
		return null;
	}

	/* @Override */
	public IBlockDefinition chiseledQuartzBlock()
	{
		return null;
	}

	/* @Override */
	public IBlockDefinition quartzGlass()
	{
		return null;
	}

	/* @Override */
	public IBlockDefinition quartzVibrantGlass()
	{
		return null;
	}

	/* @Override */
	public IBlockDefinition quartzFixture()
	{
		return null;
	}

	/* @Override */
	public IBlockDefinition fluixBlock()
	{
		return null;
	}

	/* @Override */
	public IBlockDefinition skyStoneBlock()
	{
		return null;
	}

	/* @Override */
	public IBlockDefinition smoothSkyStoneBlock()
	{
		return null;
	}

	/* @Override */
	public IBlockDefinition skyStoneBrick()
	{
		return null;
	}

	/* @Override */
	public IBlockDefinition skyStoneSmallBrick()
	{
		return null;
	}

	/* @Override */
	public IBlockDefinition skyStoneChest()
	{
		return null;
	}

	/* @Override */
	public IBlockDefinition smoothSkyStoneChest()
	{
		return null;
	}

	/* @Override */
	public IBlockDefinition skyCompass()
	{
		return null;
	}

	/* @Override */
	public IBlockDefinition skyStoneStairs()
	{
		return null;
	}

	/* @Override */
	public IBlockDefinition smoothSkyStoneStairs()
	{
		return null;
	}

	/* @Override */
	public IBlockDefinition skyStoneBrickStairs()
	{
		return null;
	}

	/* @Override */
	public IBlockDefinition skyStoneSmallBrickStairs()
	{
		return null;
	}

	/* @Override */
	public IBlockDefinition fluixStairs()
	{
		return null;
	}

	/* @Override */
	public IBlockDefinition quartzStairs()
	{
		return null;
	}

	/* @Override */
	public IBlockDefinition chiseledQuartzStairs()
	{
		return null;
	}

	/* @Override */
	public IBlockDefinition quartzPillarStairs()
	{
		return null;
	}

	/*
	 * @Override
	 * public IBlockDefinition skyStoneSlab()
	 * {
	 * return null;
	 * }
	 * @Override
	 * public IBlockDefinition skyStoneBlockSlab()
	 * {
	 * return null;
	 * }
	 * @Override
	 * public IBlockDefinition skyStoneBrickSlab()
	 * {
	 * return null;
	 * }
	 * @Override
	 * public IBlockDefinition skyStoneSmallBrickSlab()
	 * {
	 * return null;
	 * }
	 * @Override
	 * public IBlockDefinition fluixSlab()
	 * {
	 * return null;
	 * }
	 * @Override
	 * public IBlockDefinition quartzSlab()
	 * {
	 * return null;
	 * }
	 * @Override
	 * public IBlockDefinition chiseledQuartzSlab()
	 * {
	 * return null;
	 * }
	 * @Override
	 * public IBlockDefinition quartzPillarSlab()
	 * {
	 * return null;
	 * }
	 */

	/* @Override */
	public ITileDefinition grindstone()
	{
		return null;
	}

	/* @Override */
	public ITileDefinition inscriber()
	{
		return null;
	}

	/* @Override */
	public ITileDefinition wirelessAccessPoint()
	{
		return null;
	}

	/* @Override */
	public ITileDefinition charger()
	{
		return null;
	}

	/* @Override */
	public IBlockDefinition<? extends Block> tinyTNT()
	{
		return null;
	}

	/* @Override */
	public ITileDefinition securityStation()
	{
		return null;
	}

	/* @Override */
	public ITileDefinition quantumRing()
	{
		return null;
	}

	/* @Override */
	public ITileDefinition quantumLink()
	{
		return null;
	}

	/* @Override */
	public ITileDefinition spatialPylon()
	{
		return null;
	}

	/* @Override */
	public ITileDefinition spatialIOPort()
	{
		return null;
	}

	/* @Override */
	public ITileDefinition multiPart()
	{
		return null;
	}

	/* @Override */
	public ITileDefinition controller()
	{
		return null;
	}

	/* @Override */
	public ITileDefinition drive()
	{
		return null;
	}

	/* @Override */
	public ITileDefinition chest()
	{
		return null;
	}

	/* @Override */
	public ITileDefinition iface()
	{
		return null;
	}

	/* @Override */
	public ITileDefinition cellWorkbench()
	{
		return null;
	}

	/* @Override */
	public ITileDefinition iOPort()
	{
		return null;
	}

	/* @Override */
	public ITileDefinition condenser()
	{
		return null;
	}

	/* @Override */
	public ITileDefinition energyAcceptor()
	{
		return null;
	}

	/* @Override */
	public ITileDefinition vibrationChamber()
	{
		return null;
	}

	/* @Override */
	public ITileDefinition quartzGrowthAccelerator()
	{
		return null;
	}

	/* @Override */
	public ITileDefinition energyCell()
	{
		return null;
	}

	/* @Override */
	public ITileDefinition energyCellDense()
	{
		return null;
	}

	/* @Override */
	public ITileDefinition energyCellCreative()
	{
		return null;
	}

	/* @Override */
	public ITileDefinition craftingUnit()
	{
		return null;
	}

	/* @Override */
	public ITileDefinition craftingAccelerator()
	{
		return null;
	}

	/* @Override */
	public ITileDefinition craftingStorage1k()
	{
		return null;
	}

	/* @Override */
	public ITileDefinition craftingStorage4k()
	{
		return null;
	}

	/* @Override */
	public ITileDefinition craftingStorage16k()
	{
		return null;
	}

	/* @Override */
	public ITileDefinition craftingStorage64k()
	{
		return null;
	}

	/* @Override */
	public ITileDefinition craftingMonitor()
	{
		return null;
	}

	/* @Override */
	public ITileDefinition molecularAssembler()
	{
		return null;
	}

	/* @Override */
	public ITileDefinition lightDetector()
	{
		return null;
	}

	/* @Override */
	//TODO: Number of arguments error at this point. need to check class. -legracen
	public ITileDefinition paint()
	{
		return null;
	}

	public IBlockDefinition chunkLoader()
	{
		return null;
	}

	public IBlockDefinition itemGen()
	{
		return null;
	}

	public IBlockDefinition phantomNode()
	{
		return null;
	}

	public IBlockDefinition cubeGenerator()
	{
		return null;
	}
}
