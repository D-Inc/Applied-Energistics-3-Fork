
package appeng.core.spatial.definitions;


import net.minecraft.world.biome.Biome;

import appeng.api.definitions.IDefinition;
import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.definitions.Definitions;
import appeng.core.spatial.api.definitions.ISpatialBiomeDefinitions;


public class SpatialBiomeDefinitions extends Definitions<Biome, IDefinition<Biome>> implements ISpatialBiomeDefinitions
{

	public SpatialBiomeDefinitions( FeatureFactory registry )
	{
		init();
	}

}
