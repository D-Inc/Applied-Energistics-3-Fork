
package appeng.core.definitions;


import appeng.api.definitions.IDefinition;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBanner;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;

import appeng.api.definitions.IItemDefinition;
import appeng.core.AppEng;
import appeng.core.api.definitions.ICoreItemDefinitions;
import appeng.core.item.ItemCrystalSeed;
import appeng.core.item.ItemCrystalSeedRendering;
import appeng.core.item.ItemMultiItem;
import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.definitions.Definitions;

import java.util.Map;


public class CoreItemDefinitions extends Definitions<Item> implements ICoreItemDefinitions
{

	private final IItemDefinition crystalSeed;
	private final IItemDefinition multi;

	public CoreItemDefinitions( FeatureFactory registry )
	{
		this.crystalSeed = registry.item( new ResourceLocation( AppEng.MOD_NAME, "crystal_seed" ), new ItemCrystalSeed() ).rendering( new ItemCrystalSeedRendering() ).build();
		this.multi = registry.item( new ResourceLocation( AppEng.MOD_NAME, "multiItem" ), new ItemMultiItem() ).build();
		init( registry.buildDefaultItemBlocks() );
	}

}
