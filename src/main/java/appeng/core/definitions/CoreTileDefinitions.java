
package appeng.core.definitions;


import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import appeng.api.definitions.ITileDefinition;
import appeng.core.AppEng;
import appeng.core.api.definitions.ICoreTileDefinitions;
import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.definitions.Definitions;
import appeng.core.lib.features.AEFeature;
import appeng.core.tile.TileCrank;


public class CoreTileDefinitions extends Definitions<Class<? extends TileEntity>> implements ICoreTileDefinitions
{

	private final ITileDefinition crank;

	public CoreTileDefinitions( FeatureFactory registry )
	{
		crank = registry.tile( new ResourceLocation( AppEng.MOD_ID, "crank" ), TileCrank.class ).features( AEFeature.GrindStone ).build();
		init();
	}

}
