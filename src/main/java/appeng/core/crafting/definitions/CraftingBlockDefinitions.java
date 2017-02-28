
package appeng.core.crafting.definitions;


import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;

import appeng.api.definitions.IBlockDefinition;
import appeng.core.AppEng;
import appeng.core.crafting.api.definitions.ICraftingBlockDefinitions;
import appeng.core.crafting.block.BlockCraftingMonitor;
import appeng.core.crafting.block.BlockCraftingStorage;
import appeng.core.crafting.block.BlockCraftingUnit;
import appeng.core.crafting.block.BlockMolecularAssembler;
import appeng.core.crafting.item.ItemCraftingStorage;
import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.definitions.Definitions;
import appeng.core.lib.features.AEFeature;


public class CraftingBlockDefinitions extends Definitions<Block, IBlockDefinition<Block>> implements ICraftingBlockDefinitions
{

	private final IBlockDefinition craftingMonitor;
	private final IBlockDefinition craftingStorage1k;
	private final IBlockDefinition craftingStorage4k;
	private final IBlockDefinition craftingStorage16k;
	private final IBlockDefinition craftingStorage64k;
	private final IBlockDefinition craftingUnit;
	private final IBlockDefinition craftingCoProcessingUnit;
	
	private final IBlockDefinition molecularAssembler;

	public CraftingBlockDefinitions( FeatureFactory registry )
	{
		FeatureFactory crafting = registry.features( AEFeature.CraftingCPU );
		craftingMonitor = crafting.block( new ResourceLocation( AppEng.NAME, "crafting_monitor" ), new BlockCraftingMonitor() ).createDefaultItemBlock().build();
		craftingStorage1k = crafting.block( new ResourceLocation( AppEng.NAME, "crafting_storage_1k" ), new BlockCraftingStorage( BlockCraftingUnit.CraftingUnitType.STORAGE_1K ) ).withItemBlock( ItemCraftingStorage::new ).build();
		craftingStorage4k = crafting.block( new ResourceLocation( AppEng.NAME, "crafting_storage_4k" ), new BlockCraftingStorage( BlockCraftingUnit.CraftingUnitType.STORAGE_4K ) ).withItemBlock( ItemCraftingStorage::new ).build();
		craftingStorage16k = crafting.block( new ResourceLocation( AppEng.NAME, "crafting_storage_16k" ), new BlockCraftingStorage( BlockCraftingUnit.CraftingUnitType.STORAGE_16K ) ).withItemBlock( ItemCraftingStorage::new ).build();
		craftingStorage64k = crafting.block( new ResourceLocation( AppEng.NAME, "crafting_storage_64k" ), new BlockCraftingStorage( BlockCraftingUnit.CraftingUnitType.STORAGE_64K ) ).withItemBlock( ItemCraftingStorage::new ).build();
		craftingCoProcessingUnit = crafting.block( new ResourceLocation( AppEng.NAME, "crafting_co_processing_unit" ), new BlockCraftingUnit( BlockCraftingUnit.CraftingUnitType.COPROCESSINGUNIT ) ).createDefaultItemBlock().build();
		craftingUnit = crafting.block( new ResourceLocation( AppEng.NAME, "crafting_unit" ), new BlockCraftingUnit( BlockCraftingUnit.CraftingUnitType.UNIT ) ).createDefaultItemBlock().build();
		
		molecularAssembler = registry.block( new ResourceLocation( AppEng.NAME, "molecular_assembler" ), new BlockMolecularAssembler() ).createDefaultItemBlock().build();
		init();
	}

}
