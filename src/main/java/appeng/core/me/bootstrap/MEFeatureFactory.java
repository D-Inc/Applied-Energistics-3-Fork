
package appeng.core.me.bootstrap;


import net.minecraft.util.ResourceLocation;

import appeng.core.AppEng;
import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.features.AEFeature;
import appeng.core.me.api.part.PartRegistryEntry;
import appeng.core.me.api.parts.IPart;


public class MEFeatureFactory extends FeatureFactory
{

	public MEFeatureFactory()
	{
		super();
	}

	public MEFeatureFactory( FeatureFactory parent, AEFeature... defaultFeatures )
	{
		super( parent, defaultFeatures );
	}

	@Deprecated
	public <P extends IPart<P>> PartDefinitionBuilder<P> part( String id, PartRegistryEntry<P> biome )
	{
		return part( new ResourceLocation( AppEng.MODID, id ), biome );
	}

	public <P extends IPart<P>> PartDefinitionBuilder<P> part( ResourceLocation id, PartRegistryEntry<P> biome )
	{
		return new PartDefinitionBuilder<P>( this, id, biome ).features( defaultFeatures );
	}

	@Override
	public FeatureFactory features( AEFeature... features )
	{
		return new MEFeatureFactory( this, features );
	}

}
