
package appeng.core.crafting.definitions;


import net.minecraft.util.ResourceLocation;

import appeng.core.AppEng;
import appeng.core.crafting.api.definitions.ICraftingPartDefinitions;
import appeng.core.crafting.part.PartPatternTerminal;
import appeng.core.lib.definitions.Definitions;
import appeng.core.lib.features.AEFeature;
import appeng.core.me.api.definitions.IPartDefinition;
import appeng.core.me.api.part.PartRegistryEntry;
import appeng.core.me.api.parts.IPart;
import appeng.core.me.bootstrap.MEFeatureFactory;


public class CraftingPartDefinitions<P extends IPart<P>> extends Definitions<PartRegistryEntry, IPartDefinition<PartRegistryEntry>> implements ICraftingPartDefinitions
{

	private final IPartDefinition patternTerminal;

	public CraftingPartDefinitions( MEFeatureFactory registry )
	{
		patternTerminal = registry.part( new ResourceLocation( AppEng.MODID, "pattern_terminal" ), new PartRegistryEntry( PartPatternTerminal.class ) ).addFeatures( AEFeature.Patterns ).build();

		init();
	}

}
