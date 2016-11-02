
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


public class CoreItemDefinitions extends Definitions<Item> implements ICoreItemDefinitions
{

	private final IItemDefinition crystalSeed;
	private final IItemDefinition multi;

	private final IItemDefinition crank;
	private final IItemDefinition charger;
	private final IItemDefinition grinder;
	private final IItemDefinition inscriber;
	private final IItemDefinition vibrationChamber;

	public CoreItemDefinitions( FeatureFactory registry )
	{
		this.crystalSeed = registry.item( new ResourceLocation( AppEng.MOD_NAME, "crystal_seed" ), new ItemCrystalSeed() ).rendering( new ItemCrystalSeedRendering() ).build();
		this.multi = registry.item( new ResourceLocation( AppEng.MOD_NAME, "multiItem" ), new ItemMultiItem() ).build();

		this.crank = registry.defaultItemBlock( new ResourceLocation( AppEng.MOD_ID, "crank" ) ).build();
		this.charger = registry.defaultItemBlock( new ResourceLocation( AppEng.MOD_ID, "charger" ) ).build();
		this.grinder = registry.defaultItemBlock( new ResourceLocation( AppEng.MOD_ID, "grinder" ) ).build();
		this.inscriber = registry.defaultItemBlock( new ResourceLocation( AppEng.MOD_ID, "inscriber" ) ).build();
		this.vibrationChamber = registry.defaultItemBlock( new ResourceLocation( AppEng.MOD_ID, "vibration_chamber" ) ).build();

		init();
	}

}
