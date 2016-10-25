
package appeng.core.definitions;


import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;

import appeng.api.definitions.IItemDefinition;
import appeng.core.AppEng;
import appeng.core.api.definitions.ICoreItemDefinitions;
import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.definitions.Definitions;
import appeng.core.lib.features.AEFeature;


public class CoreItemDefinitions extends Definitions<Item> implements ICoreItemDefinitions
{

	private final IItemDefinition crank;

	public CoreItemDefinitions( FeatureFactory registry )
	{
		crank = registry.item( new ResourceLocation( AppEng.MOD_ID, "crank" ), () -> new ItemBlock( null ) ).features( AEFeature.GrindStone ).build();
		init();
	}

}
