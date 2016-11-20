
package appeng.decorative.definitions;


import net.minecraft.tileentity.TileEntity;

import appeng.api.definitions.ITileDefinition;
import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.definitions.Definitions;
import appeng.decorative.api.definitions.IDecorativeTileDefinitions;


public class DecorativeTileDefinitions extends Definitions<Class<? extends TileEntity>, ITileDefinition<? extends TileEntity, Class<? extends TileEntity>>> implements IDecorativeTileDefinitions
{

	public DecorativeTileDefinitions( FeatureFactory registry )
	{
		init();
	}

}
