
package appeng.core.crafting.definitions;


import appeng.core.AppEng;
import appeng.core.crafting.block.BlockCraftingMonitor;
import appeng.core.crafting.block.BlockCraftingStorage;
import appeng.core.crafting.block.BlockCraftingUnit;
import appeng.core.crafting.block.BlockMolecularAssembler;
import appeng.core.lib.features.BlockDefinition;
import net.minecraft.block.Block;

import appeng.api.definitions.IBlockDefinition;
import appeng.core.crafting.api.definitions.ICraftingBlockDefinitions;
import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.definitions.Definitions;
import net.minecraft.util.ResourceLocation;


public class CraftingBlockDefinitions extends Definitions<Block, IBlockDefinition<Block>> implements ICraftingBlockDefinitions
{

	private final BlockDefinition crafting_monitor;
	/*package*/ final BlockDefinition crafting_storage_1k;
	/*package*/ final BlockDefinition crafting_storage_4k;
	/*package*/ final BlockDefinition crafting_storage_16k;
	/*package*/ final BlockDefinition crafting_storage_64k;
	private final BlockDefinition crafting_unit;
	private final BlockDefinition crafting_accelerator;
	private final BlockDefinition molecular_assembler;

	public CraftingBlockDefinitions( FeatureFactory registry )
	{
		crafting_monitor = ( BlockDefinition ) registry.block( new ResourceLocation( AppEng.MOD_NAME, "crafting_monitor" ) , new BlockCraftingMonitor() ).createDefaultItemBlock().build();
		crafting_storage_1k = ( BlockDefinition ) registry.block( new ResourceLocation( AppEng.MOD_NAME, "crafting_storage_1k" ) , new BlockCraftingStorage( BlockCraftingUnit.CraftingUnitType.STORAGE_1K ) ).build();
		crafting_storage_4k = ( BlockDefinition ) registry.block( new ResourceLocation( AppEng.MOD_NAME, "crafting_storage_4k" ) , new BlockCraftingStorage( BlockCraftingUnit.CraftingUnitType.STORAGE_4K ) ).build();
		crafting_storage_16k = ( BlockDefinition ) registry.block( new ResourceLocation( AppEng.MOD_NAME, "crafting_storage_16k" ) , new BlockCraftingStorage( BlockCraftingUnit.CraftingUnitType.STORAGE_16K ) ).build();
		crafting_storage_64k = ( BlockDefinition ) registry.block( new ResourceLocation( AppEng.MOD_NAME, "crafting_storage_64k" ) , new BlockCraftingStorage( BlockCraftingUnit.CraftingUnitType.STORAGE_64K ) ).build();
		crafting_accelerator = ( BlockDefinition ) registry.block( new ResourceLocation( AppEng.MOD_NAME, "crafting_accelerator" ) , new BlockCraftingUnit( BlockCraftingUnit.CraftingUnitType.ACCELERATOR ) ).createDefaultItemBlock().build();
		crafting_unit = ( BlockDefinition ) registry.block( new ResourceLocation( AppEng.MOD_NAME, "crafting_unit" ) , new BlockCraftingUnit( BlockCraftingUnit.CraftingUnitType.UNIT ) ).createDefaultItemBlock().build();
		molecular_assembler = ( BlockDefinition ) registry.block( new ResourceLocation( AppEng.MOD_NAME, "molecular_assembler" ) , new BlockMolecularAssembler()).createDefaultItemBlock().build();
		init();
	}

}
