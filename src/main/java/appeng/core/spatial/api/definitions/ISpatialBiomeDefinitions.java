
package appeng.core.spatial.api.definitions;


import net.minecraft.world.biome.Biome;

import appeng.api.definitions.IBiomeDefinition;
import appeng.api.definitions.IDefinitions;


public interface ISpatialBiomeDefinitions extends IDefinitions<Biome, IBiomeDefinition<Biome>>
{

	default IBiomeDefinition<? extends Biome> spatialStorage()
	{
		return get( "spatial_storage" );
	}

}
