
package appeng.core.spatial.definitions;


import net.minecraft.world.biome.Biome;

import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.definitions.Definitions;
import appeng.core.spatial.api.definitions.ISpatialBiomeDefinitions;


public class SpatialBiomeDefinitions extends Definitions<Biome> implements ISpatialBiomeDefinitions
{

	public SpatialBiomeDefinitions( FeatureFactory registry )
	{
		init();
	}

}
