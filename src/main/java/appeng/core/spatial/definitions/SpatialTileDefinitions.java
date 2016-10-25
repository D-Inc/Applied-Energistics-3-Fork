
package appeng.core.spatial.definitions;


import net.minecraft.tileentity.TileEntity;

import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.definitions.Definitions;
import appeng.core.spatial.api.definitions.ISpatialTileDefinitions;


public class SpatialTileDefinitions extends Definitions<Class<? extends TileEntity>> implements ISpatialTileDefinitions
{

	public SpatialTileDefinitions( FeatureFactory registry )
	{
		init();
	}

}
