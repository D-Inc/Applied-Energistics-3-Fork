
package appeng.core.definitions;


import appeng.core.block.*;
import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;

import appeng.api.definitions.IBlockDefinition;
import appeng.core.AppEng;
import appeng.core.api.definitions.ICoreBlockDefinitions;
import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.definitions.Definitions;
import appeng.core.lib.features.AEFeature;


public class CoreBlockDefinitions extends Definitions<Block> implements ICoreBlockDefinitions
{

	private final IBlockDefinition crank;
	private final IBlockDefinition charger;
	private final IBlockDefinition grinder;
	private final IBlockDefinition inscriber;
	private final IBlockDefinition vibrationChamber;

	public CoreBlockDefinitions( FeatureFactory registry )
	{
		this.crank = registry.block( new ResourceLocation( AppEng.MOD_ID, "crank" ), new BlockCrank() ).createDefaultItemBlock().features( AEFeature.GrindStone ).build();
		this.charger = registry.block( new ResourceLocation( AppEng.MOD_ID, "charger" ), new BlockCharger() ).createDefaultItemBlock().build();
		this.grinder = registry.block( new ResourceLocation( AppEng.MOD_ID, "grinder" ), new BlockGrinder() ).createDefaultItemBlock().build();
		this.inscriber = registry.block( new ResourceLocation( AppEng.MOD_ID, "inscriber"), new BlockInscriber() ).createDefaultItemBlock().build();
		this.vibrationChamber = registry.block( new ResourceLocation( AppEng.MOD_ID, "vibration_chamber"), new BlockVibrationChamber() ).createDefaultItemBlock().build();
		init();
	}

}
