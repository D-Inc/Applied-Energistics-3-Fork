
package appeng.core.me.definitions;


import net.minecraft.tileentity.TileEntity;

import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.definitions.Definitions;
import appeng.core.me.api.definitions.IMETileDefinitions;


public class METileDefinitions extends Definitions<Class<TileEntity>> implements IMETileDefinitions
{

	public METileDefinitions( FeatureFactory registry )
	{
		init();
	}

}
