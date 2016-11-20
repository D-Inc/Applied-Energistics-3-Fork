
package appeng.core.worldgen.definitions;


import appeng.core.AppEng;
import appeng.core.lib.features.AEFeature;
import appeng.core.worldgen.tile.TileSkyChest;
import net.minecraft.tileentity.TileEntity;

import appeng.api.definitions.ITileDefinition;
import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.definitions.Definitions;
import appeng.core.worldgen.api.definitions.IWorldGenTileDefinitions;
import net.minecraft.util.ResourceLocation;


public class WorldGenTileDefinitions extends Definitions<Class<TileEntity>, ITileDefinition<TileEntity>> implements IWorldGenTileDefinitions
{

	private final ITileDefinition skyStoneChest;

	public WorldGenTileDefinitions( FeatureFactory registry )
	{
		skyStoneChest = registry.tile( new ResourceLocation( AppEng.MOD_ID, "skystone_chest" ), TileSkyChest.class ).features( AEFeature.SkyStoneChests ).build();
		init();
	}

}
