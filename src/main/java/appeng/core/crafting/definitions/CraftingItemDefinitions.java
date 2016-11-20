
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
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;


public class CraftingItemDefinitions extends Definitions<Item, IItemDefinition<Item>> implements ICraftingItemDefinitions
{

	private final IItemDefinition encodedPattern;

	public CraftingItemDefinitions( FeatureFactory registry )
	{
		this.encodedPattern = registry.item( new ResourceLocation( AppEng.MOD_NAME, "encoded_pattern" ), new ItemEncodedPattern() ).build();
		init( registry.buildDefaultItemBlocks() );
	}

}
