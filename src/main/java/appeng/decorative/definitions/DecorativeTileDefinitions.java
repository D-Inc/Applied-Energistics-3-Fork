
package appeng.decorative.definitions;


import net.minecraft.tileentity.TileEntity;

import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.definitions.Definitions;
import appeng.decorative.api.definitions.IDecorativeTileDefinitions;


public class DecorativeTileDefinitions extends Definitions<Class<TileEntity>> implements IDecorativeTileDefinitions
{

	public DecorativeTileDefinitions( FeatureFactory registry )
	{
		init();
	}

}
