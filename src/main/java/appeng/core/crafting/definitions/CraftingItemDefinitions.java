
package appeng.core.crafting.definitions;


import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

import appeng.api.definitions.IItemDefinition;
import appeng.core.AppEng;
import appeng.core.crafting.api.definitions.ICraftingItemDefinitions;
import appeng.core.crafting.item.ItemEncodedPattern;
import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.definitions.Definitions;


public class CraftingItemDefinitions extends Definitions<Item, IItemDefinition<Item>> implements ICraftingItemDefinitions
{

	private final IItemDefinition encodedPattern;

	public CraftingItemDefinitions( FeatureFactory registry )
	{
		this.encodedPattern = registry.item( new ResourceLocation( AppEng.NAME, "encoded_pattern" ), new ItemEncodedPattern() ).build();
		init( registry.buildDefaultItemBlocks() );
	}

}
