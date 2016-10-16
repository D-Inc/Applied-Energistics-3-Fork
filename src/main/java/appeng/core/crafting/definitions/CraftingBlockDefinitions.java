
package appeng.core.crafting.definitions;


import net.minecraft.block.Block;

import appeng.core.crafting.api.definitions.ICraftingBlockDefinitions;
import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.definitions.Definitions;


public class CraftingBlockDefinitions extends Definitions<Block> implements ICraftingBlockDefinitions
{

	public CraftingBlockDefinitions( FeatureFactory registry )
	{
		init();
	}

}
