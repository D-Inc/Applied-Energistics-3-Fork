
package appeng.core.me.definitions;


import net.minecraftforge.fml.common.registry.EntityEntry;

import appeng.api.definitions.IEntityDefinition;
import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.definitions.Definitions;
import appeng.core.me.api.definitions.IMEEntityDefinitions;
import appeng.core.me.entity.EntitySingularity;


public class MEEntityDefinitions extends Definitions<EntityEntry, IEntityDefinition<EntityEntry>> implements IMEEntityDefinitions
{

	private final IEntityDefinition singularity;

	public MEEntityDefinitions( FeatureFactory factory )
	{
		singularity = factory.entity( "singularity", new EntityEntry( EntitySingularity.class, "Singularity" ) ).build();

		init();
	}

}
