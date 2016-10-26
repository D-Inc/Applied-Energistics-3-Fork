
package appeng.core.definitions;


import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;

import appeng.api.definitions.IBlockDefinition;
import appeng.core.AppEng;
import appeng.core.api.definitions.ICoreBlockDefinitions;
import appeng.core.block.BlockCrank;
import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.definitions.Definitions;
import appeng.core.lib.features.AEFeature;


public class CoreBlockDefinitions extends Definitions<Block> implements ICoreBlockDefinitions
{

	private final IBlockDefinition crank;
	// private final ITileDefinition charger;
	// private final ITileDefinition grinder;
	// private final ITileDefinition inscriber;
	// private final ITileDefinition vibrationChamber;

	public CoreBlockDefinitions( FeatureFactory registry )
	{
		this.crank = registry.block( new ResourceLocation( AppEng.MOD_ID, "crank" ), new BlockCrank() ).features( AEFeature.GrindStone ).build();
		// this.charger = registry.block( "charger", BlockCharger::new ).build();
		// this.grinder = registry.block( "grinder", BlockGrinder::new ).build();
		// this.inscriber = registry.block( "inscriber", BlockInscriber::new ).build();
		// this.vibrationChamber = registry.block( "vibration_chamber", BlockVibrationChamber::new ).build();
		init();
	}

}
