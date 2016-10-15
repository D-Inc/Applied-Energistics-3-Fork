
package appeng.core.definitions;


import net.minecraft.item.Item;

import appeng.api.definitions.IItemDefinition;
import appeng.core.api.definitions.ICoreItemDefinitions;
import appeng.core.item.ItemCrystalSeed;
import appeng.core.item.ItemCrystalSeedRendering;
import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.definitions.Definitions;


public class CoreItemDefinitions extends Definitions<Item> implements ICoreItemDefinitions
{

	// TODO 1.10.2-APIBOOM - Only an example. Shouldn't be here.
	private final IItemDefinition crystalSeed;

	public CoreItemDefinitions(FeatureFactory registry)
	{
		this.crystalSeed = registry.item( "crystal_seed", ItemCrystalSeed::new ).rendering( new ItemCrystalSeedRendering() ).build();
		init();
	}

}
