
package appeng.core.crafting.definitions;


import net.minecraft.tileentity.TileEntity;

import appeng.api.definitions.ITileDefinition;
import appeng.core.crafting.api.definitions.ICraftingTileDefinitions;
import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.definitions.Definitions;


public class CraftingTileDefinitions extends Definitions<Class<? extends TileEntity>, ITileDefinition<? extends TileEntity, Class<? extends TileEntity>>> implements ICraftingTileDefinitions
{

	public CraftingTileDefinitions( FeatureFactory registry )
	{
		init();
	}

}
