
package appeng.core.definitions;


import appeng.api.definitions.IBlockDefinition;
import appeng.core.block.*;
import net.minecraft.block.Block;

import appeng.api.definitions.ITileDefinition;
import appeng.core.api.definitions.ICoreBlockDefinitions;
import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.definitions.Definitions;
import appeng.core.lib.features.AEFeature;


public class CoreBlockDefinitions extends Definitions<Block> implements ICoreBlockDefinitions
{

	private final ITileDefinition crank;
//	private final ITileDefinition charger;
//	private final ITileDefinition grinder;
//	private final ITileDefinition inscriber;
//	private final ITileDefinition vibrationChamber;

	public CoreBlockDefinitions(FeatureFactory registry)
	{
		this.crank = registry.block( "crank", BlockCrank::new ).features( AEFeature.GrindStone ).build();
//		this.charger = registry.block( "charger", BlockCharger::new ).build();
//		this.grinder = registry.block( "grinder", BlockGrinder::new ).build();
//		this.inscriber = registry.block( "inscriber", BlockInscriber::new ).build();
//		this.vibrationChamber = registry.block( "vibration_chamber", BlockVibrationChamber::new ).build();
		init();
	}

}
