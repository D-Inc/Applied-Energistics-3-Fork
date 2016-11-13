
package appeng.miscellaneous.definitions;


import net.minecraft.tileentity.TileEntity;

import appeng.api.definitions.ITileDefinition;
import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.definitions.Definitions;
import appeng.miscellaneous.api.definitions.IMiscellaneousTileDefinitions;


public class MiscellaneousTileDefinitions extends Definitions<Class<? extends TileEntity>, ITileDefinition<? extends TileEntity, Class<? extends TileEntity>>> implements IMiscellaneousTileDefinitions
{

	public MiscellaneousTileDefinitions( FeatureFactory registry )
	{
		init();
	}

}
