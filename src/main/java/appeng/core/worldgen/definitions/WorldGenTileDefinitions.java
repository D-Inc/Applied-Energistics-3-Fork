
package appeng.core.worldgen.definitions;


import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import appeng.api.definitions.ITileDefinition;
import appeng.core.AppEng;
import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.definitions.Definitions;
import appeng.core.lib.features.AEFeature;
import appeng.core.worldgen.api.definitions.IWorldGenTileDefinitions;
import appeng.core.worldgen.tile.TileSkyChest;
import appeng.core.worldgen.tile.TileSkyCompass;
import appeng.miscellaneous.AppEngMiscellaneous;


public class WorldGenTileDefinitions extends Definitions<Class<TileEntity>, ITileDefinition<TileEntity>> implements IWorldGenTileDefinitions
{

	private final ITileDefinition skyStoneChest;
	
	private final ITileDefinition skyCompass;

	public WorldGenTileDefinitions( FeatureFactory registry )
	{
		this.skyStoneChest = registry.tile( new ResourceLocation( AppEng.MODID, "skystone_chest" ), TileSkyChest.class ).features( AEFeature.SkyStoneChests ).build();

		this.skyCompass = registry.tile( new ResourceLocation( AppEngMiscellaneous.MODID, "sky_compass" ), TileSkyCompass.class ).addFeatures( AEFeature.MeteoriteCompass ).build();

		init();
	}

}
