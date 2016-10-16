
package appeng.core.definitions;


import net.minecraft.tileentity.TileEntity;

import appeng.core.api.definitions.ICoreTileDefinitions;
import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.definitions.Definitions;


public class CoreTileDefinitions extends Definitions<Class<TileEntity>> implements ICoreTileDefinitions
{

	public CoreTileDefinitions( FeatureFactory registry )
	{
		init();
	}

}
