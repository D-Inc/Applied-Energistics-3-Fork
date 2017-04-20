
package appeng.core.definitions;


import net.minecraft.block.Block;
import net.minecraft.block.BlockDispenser;
import net.minecraft.util.ResourceLocation;

import appeng.api.definitions.IBlockDefinition;
import appeng.core.AppEng;
import appeng.core.api.definitions.ICoreBlockDefinitions;
import appeng.core.block.BlockCharger;
import appeng.core.block.BlockCrank;
import appeng.core.block.BlockCreativeEnergyCell;
import appeng.core.block.BlockCrystalGrowthAccelerator;
import appeng.core.block.BlockDenseEnergyCell;
import appeng.core.block.BlockEnergyAcceptor;
import appeng.core.block.BlockEnergyCell;
import appeng.core.block.BlockEnergyCellRendering;
import appeng.core.block.BlockGrinder;
import appeng.core.block.BlockQuartzGlass;
import appeng.core.block.BlockSkyStone;
import appeng.core.block.BlockSkyStone.SkystoneType;
import appeng.core.block.BlockTinyTNT;
import appeng.core.block.BlockVibrantQuartzGlass;
import appeng.core.block.BlockVibrationChamber;
import appeng.core.lib.bootstrap.BlockRenderingCustomizer;
import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.bootstrap.IBlockRendering;
import appeng.core.lib.bootstrap.IItemRendering;
import appeng.core.lib.definitions.Definitions;
import appeng.core.lib.features.AEFeature;
import appeng.core.lib.item.AEBaseItemBlockChargeable;
import appeng.decorative.AppEngDecorative;
import appeng.miscellaneous.AppEngMiscellaneous;
import appeng.tools.hooks.DispenserBehaviorTinyTNT;


public class CoreBlockDefinitions extends Definitions<Block, IBlockDefinition<Block>> implements ICoreBlockDefinitions
{

	private final IBlockDefinition crank;
	private final IBlockDefinition charger;
	private final IBlockDefinition grinder;
	private final IBlockDefinition vibrationChamber;
	
	private final IBlockDefinition energyAcceptor;
	private final IBlockDefinition energyCell;
	private final IBlockDefinition energyCellDense;
	private final IBlockDefinition energyCellCreative;
	
	private final IBlockDefinition crystalGrowthAccelerator;
	
	private final IBlockDefinition tinyTNT;
	
	private final IBlockDefinition skyStone;
	
	private final IBlockDefinition quartzGlass;
	private final IBlockDefinition quartzVibrantGlass;

	public CoreBlockDefinitions( FeatureFactory registry )
	{
		this.crank = registry.block( new ResourceLocation( AppEng.MODID, "crank" ), new BlockCrank() ).createDefaultItemBlock().features( AEFeature.GrindStone ).build();
		this.charger = registry.block( new ResourceLocation( AppEng.MODID, "charger" ), new BlockCharger() ).createDefaultItemBlock().rendering( new BlockRenderingCustomizer(){
			@Override
			public void customize( IBlockRendering rendering, IItemRendering itemRendering )
			{
				rendering.tesr( BlockCharger.createTesr() );
			}
		} ).build();
		this.grinder = registry.block( new ResourceLocation( AppEng.MODID, "grinder" ), new BlockGrinder() ).features( AEFeature.GrindStone ).createDefaultItemBlock().build();
		this.vibrationChamber = registry.block( new ResourceLocation( AppEng.MODID, "vibration_chamber" ), new BlockVibrationChamber() ).features( AEFeature.PowerGen ).createDefaultItemBlock().build();
		
		this.energyAcceptor = registry.block( new ResourceLocation( AppEng.MODID, "energy_acceptor" ), new BlockEnergyAcceptor() ).createDefaultItemBlock().build();
		this.energyCell = registry.block( new ResourceLocation( AppEng.MODID, "energy_cell" ), new BlockEnergyCell() ).withItemBlock( AEBaseItemBlockChargeable::new ).rendering( new BlockEnergyCellRendering( new ResourceLocation( AppEng.MODID, "energy_cell" ) ) ).build();
		this.energyCellDense = registry.block( new ResourceLocation( AppEng.MODID, "dense_energy_cell" ), new BlockDenseEnergyCell() ).features( AEFeature.DenseEnergyCells ).withItemBlock( AEBaseItemBlockChargeable::new ).rendering( new BlockEnergyCellRendering( new ResourceLocation( AppEng.MODID, "dense_energy_cell" ) ) ).build();
		this.energyCellCreative = registry.block( new ResourceLocation( AppEng.MODID, "creative_energy_cell" ), new BlockCreativeEnergyCell() ).features( AEFeature.Creative ).withItemBlock( AEBaseItemBlockChargeable::new ).build();

		this.crystalGrowthAccelerator = registry.block( new ResourceLocation( AppEngMiscellaneous.MODID, "crystal_growth_accelerator" ), new BlockCrystalGrowthAccelerator() ).createDefaultItemBlock().build();
		
		this.tinyTNT = registry.block( new ResourceLocation( AppEngMiscellaneous.MODID, "tiny_tnt" ), new BlockTinyTNT() ).features( AEFeature.TinyTNT ).createDefaultItemBlock().postInit( ( block ) -> {
			BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject( block.maybeItem().get().maybe().get(), new DispenserBehaviorTinyTNT() );
		} ).build();
		
		this.skyStone = registry.block( new ResourceLocation( AppEngDecorative.MODID, "sky_stone" ), new BlockSkyStone( SkystoneType.STONE ) ).createDefaultItemBlock().build();
		
		this.quartzGlass = registry.block( new ResourceLocation( AppEngDecorative.MODID, "quartz_glass" ), new BlockQuartzGlass() ).createDefaultItemBlock().build();
		this.quartzVibrantGlass = registry.block( new ResourceLocation( AppEngDecorative.MODID, "quartz_vibrant_glass" ), new BlockVibrantQuartzGlass() ).addFeatures( AEFeature.DecorativeLights ).createDefaultItemBlock().build();
		
		init();
	}

}
