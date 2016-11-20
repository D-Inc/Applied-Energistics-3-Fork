
package appeng.core.definitions;


import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

import appeng.api.definitions.IItemDefinition;
import appeng.core.AppEng;
import appeng.core.api.definitions.ICoreItemDefinitions;
import appeng.core.item.ItemCrystalSeed;
import appeng.core.item.ItemCrystalSeedRendering;
import appeng.core.item.ItemMultiItem;
import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.definitions.Definitions;


public class CoreItemDefinitions extends Definitions<Item, IItemDefinition<Item>> implements ICoreItemDefinitions
{

	private final IItemDefinition crystal_seed;
	private final IItemDefinition multi_item;

	public CoreItemDefinitions( FeatureFactory registry )
	{
		this.crystal_seed = registry.item( new ResourceLocation( AppEng.MOD_NAME, "crystal_seed" ), new ItemCrystalSeed() ).rendering( new ItemCrystalSeedRendering() ).build();
		this.multi_item = registry.item( new ResourceLocation( AppEng.MOD_NAME, "multi_tem" ), new ItemMultiItem() ).build();
		init( registry.buildDefaultItemBlocks() );
	}

}
