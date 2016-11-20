
package appeng.tools.definitions;


import net.minecraft.tileentity.TileEntity;

import appeng.api.definitions.ITileDefinition;
import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.definitions.Definitions;
import appeng.tools.api.definitions.IToolsTileDefinitions;


public class ToolsTileDefinitions extends Definitions<Class<? extends TileEntity>, ITileDefinition<? extends TileEntity>> implements IToolsTileDefinitions
{

	public ToolsTileDefinitions( FeatureFactory registry )
	{
		init();
	}

}
