
package appeng.core.crafting.definitions;


import appeng.api.definitions.IDefinitionsProvider;
import appeng.core.AppEng;
import appeng.core.api.definitions.ICoreBlockDefinitions;
import appeng.core.crafting.api.definitions.ICraftingBlockDefinitions;
import appeng.core.crafting.block.ItemCraftingStorage;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

import appeng.api.definitions.IItemDefinition;
import appeng.core.crafting.api.definitions.ICraftingItemDefinitions;
import appeng.core.crafting.item.ItemEncodedPattern;
import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.definitions.Definitions;
import appeng.core.lib.features.AEFeature;
import net.minecraft.util.ResourceLocation;


public class CraftingItemDefinitions extends Definitions<Item, IItemDefinition<Item>> implements ICraftingItemDefinitions
{

	private final IItemDefinition encoded_pattern;
	private IItemDefinition crafting_storage_1k;
	private IItemDefinition crafting_storage_4k;
	private IItemDefinition crafting_storage_16k;
	private IItemDefinition crafting_storage_64k;

	public CraftingItemDefinitions( FeatureFactory registry )
	{
		this.encoded_pattern = registry.item( new ResourceLocation( AppEng.MOD_NAME, "encoded_pattern" ), new ItemEncodedPattern() ).build();

		CraftingBlockDefinitions blocks = ( ( IDefinitionsProvider ) (AppEng.instance().getCurrent() ) ).definitions( Block.class );
		blocks.blockCraftingStorage1k().maybe().ifPresent( (block) -> {
			crafting_storage_1k = registry.item( new ResourceLocation( AppEng.MOD_NAME, "crafting_storage_1k" ), new ItemCraftingStorage( block ) ).build();
			blocks.crafting_storage_1k.setItem( crafting_storage_1k );
		} );
		blocks.blockCraftingStorage4k().maybe().ifPresent( (block) -> {
			crafting_storage_4k = registry.item( new ResourceLocation( AppEng.MOD_NAME, "crafting_storage_4k" ), new ItemCraftingStorage( block ) ).build();
			blocks.crafting_storage_4k.setItem( crafting_storage_4k );
		} );
		blocks.blockCraftingStorage16k().maybe().ifPresent( (block) -> {
			crafting_storage_16k = registry.item( new ResourceLocation( AppEng.MOD_NAME, "crafting_storage_16k" ), new ItemCraftingStorage( block ) ).build();
			blocks.crafting_storage_16k.setItem( crafting_storage_16k );
		} );
		blocks.blockCraftingStorage64k().maybe().ifPresent( (block) -> {
			crafting_storage_64k = registry.item( new ResourceLocation( AppEng.MOD_NAME, "crafting_storage_64k" ), new ItemCraftingStorage( block ) ).build();
			blocks.crafting_storage_64k.setItem( crafting_storage_64k );
		} );

		init( registry.buildDefaultItemBlocks() );
	}

}
