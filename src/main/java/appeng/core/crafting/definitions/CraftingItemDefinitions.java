
package appeng.core.crafting.definitions;


import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

import appeng.api.definitions.IItemDefinition;
import appeng.core.AppEng;
import appeng.core.crafting.AppEngCrafting;
import appeng.core.crafting.api.definitions.ICraftingItemDefinitions;
import appeng.core.crafting.item.ItemPattern;
import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.definitions.Definitions;
import appeng.core.me.item.ItemCard;


public class CraftingItemDefinitions extends Definitions<Item, IItemDefinition<Item>> implements ICraftingItemDefinitions
{

	private final IItemDefinition pattern;

	private final IItemDefinition craftingCard;

	public CraftingItemDefinitions( FeatureFactory registry )
	{
		this.pattern = registry.item( new ResourceLocation( AppEng.MODID, "pattern" ), new ItemPattern() ).build();

		this.craftingCard = registry.item( new ResourceLocation( AppEng.MODID, "crafting_card" ), new ItemCard( AppEngCrafting.INSTANCE.CRAFTING ) ).build();

		init( registry.buildDefaultItemBlocks() );
	}

}
