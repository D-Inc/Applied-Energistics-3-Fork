
package appeng.core.definitions;


import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;

import appeng.api.definitions.IBlockDefinition;
import appeng.core.AppEng;
import appeng.core.api.definitions.ICoreBlockDefinitions;
import appeng.core.block.BlockCharger;
import appeng.core.block.BlockCrank;
import appeng.core.block.BlockGrinder;
import appeng.core.block.BlockInscriber;
import appeng.core.block.BlockVibrationChamber;
import appeng.core.lib.bootstrap.BlockRenderingCustomizer;
import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.bootstrap.IBlockRendering;
import appeng.core.lib.bootstrap.IItemRendering;
import appeng.core.lib.definitions.Definitions;
import appeng.core.lib.features.AEFeature;


public class CoreBlockDefinitions extends Definitions<Block, IBlockDefinition<Block>> implements ICoreBlockDefinitions
{

	private final IBlockDefinition crank;
	private final IBlockDefinition charger;
	private final IBlockDefinition grinder;
	private final IBlockDefinition inscriber;
	private final IBlockDefinition vibrationChamber;

	public CoreBlockDefinitions( FeatureFactory registry )
	{
		this.crank = registry.block( new ResourceLocation( AppEng.MOD_ID, "crank" ), new BlockCrank() ).createDefaultItemBlock().features( AEFeature.GrindStone ).build();
		this.charger = registry.block( new ResourceLocation( AppEng.MOD_ID, "charger" ), new BlockCharger() ).createDefaultItemBlock().rendering( new BlockRenderingCustomizer(){
			@Override
			public void customize( IBlockRendering rendering, IItemRendering itemRendering )
			{
				rendering.tesr( BlockCharger.createTesr() );
			}
		} ).build();
		this.grinder = registry.block( new ResourceLocation( AppEng.MOD_ID, "grinder" ), new BlockGrinder() ).features( AEFeature.GrindStone ).createDefaultItemBlock().build();
		this.inscriber = registry.block( new ResourceLocation( AppEng.MOD_ID, "inscriber" ), new BlockInscriber() ).features( AEFeature.Inscriber ).createDefaultItemBlock().build();
		this.vibrationChamber = registry.block( new ResourceLocation( AppEng.MOD_ID, "vibration_chamber" ), new BlockVibrationChamber() ).features( AEFeature.PowerGen ).createDefaultItemBlock().build();

		init();
	}

}
