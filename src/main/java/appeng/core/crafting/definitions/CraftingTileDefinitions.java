
package appeng.core.crafting.definitions;


import net.minecraft.tileentity.TileEntity;

import appeng.core.crafting.api.definitions.ICraftingTileDefinitions;
import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.definitions.Definitions;


public class CraftingTileDefinitions extends Definitions<Class<TileEntity>> implements ICraftingTileDefinitions
{

	public CraftingTileDefinitions( FeatureFactory registry )
	{
		init();
	}

}
