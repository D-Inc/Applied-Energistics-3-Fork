
package appeng.core.worldgen.definitions;


import net.minecraft.tileentity.TileEntity;

import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.definitions.Definitions;
import appeng.core.worldgen.api.definitions.IWorldGenTileDefinitions;


public class WorldGenTileDefinitions extends Definitions<Class<TileEntity>> implements IWorldGenTileDefinitions
{

	public WorldGenTileDefinitions( FeatureFactory registry )
	{
		init();
	}

}
