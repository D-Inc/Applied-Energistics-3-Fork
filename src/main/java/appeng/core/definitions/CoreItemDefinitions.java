
package appeng.core.definitions;


import appeng.core.block.*;
import appeng.core.item.ItemCrystalSeed;
import appeng.core.item.ItemCrystalSeedRendering;
import appeng.core.item.ItemMultiItem;
import appeng.core.me.item.ItemMultipartRendering;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;

import appeng.api.definitions.IItemDefinition;
import appeng.core.AppEng;
import appeng.core.api.definitions.ICoreItemDefinitions;
import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.definitions.Definitions;
import appeng.core.lib.features.AEFeature;
import scala.App;


public class CoreItemDefinitions extends Definitions<Item> implements ICoreItemDefinitions
{

	private final IItemDefinition crystalSeed;
	private final IItemDefinition multi;

	public CoreItemDefinitions( FeatureFactory registry )
	{
		crystalSeed = registry.item( new ResourceLocation( AppEng.MOD_NAME, "crystal_seed" ), new ItemCrystalSeed() ).rendering( new ItemCrystalSeedRendering() ).build();
		multi = registry.item( new ResourceLocation( AppEng.MOD_NAME, "multiItem" ), new ItemMultiItem() ).build();
		init();
	}

}
