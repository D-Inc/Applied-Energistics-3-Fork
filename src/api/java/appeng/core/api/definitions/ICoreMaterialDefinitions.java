
package appeng.core.api.definitions;


import appeng.api.definitions.IDefinitions;
import appeng.api.definitions.IMaterialDefinition;
import appeng.core.api.material.Material;


public interface ICoreMaterialDefinitions extends IDefinitions<Material, IMaterialDefinition<Material>>
{

	default IMaterialDefinition<Material> certusQuartzCrystal()
	{
		return get( "certus_quartz_crystal" );
	}

	default IMaterialDefinition<Material> certusQuartzCrystalCharged()
	{
		return get( "certus_quartz_crystal_charged" );
	}

	default IMaterialDefinition<Material> certusQuartzDust()
	{
		return get( "certus_quartz_dust" );
	}

	default IMaterialDefinition<Material> netherQuartzDust()
	{
		return get( "nether_quartz_dust" );
	}

	default IMaterialDefinition<Material> goldDust()
	{
		return get( "gold_dust" );
	}

	default IMaterialDefinition<Material> ironDust()
	{
		return get( "iron_dust" );
	}

	default IMaterialDefinition<Material> silicon()
	{
		return get( "silicon" );
	}

	default IMaterialDefinition<Material> matterBall()
	{
		return get( "matter_ball" );
	}

	default IMaterialDefinition<Material> fluixCrystal()
	{
		return get( "fluix_crystal" );
	}

	default IMaterialDefinition<Material> fluixDust()
	{
		return get( "fluix_dust" );
	}

	default IMaterialDefinition<Material> fluixPearl()
	{
		return get( "fluix_pearl" );
	}

	default IMaterialDefinition<Material> purifiedCertusQuartzCrystal()
	{
		return get( "purified_certus_quartz_crystal" );
	}

	default IMaterialDefinition<Material> purifiedNetherQuartzCrystal()
	{
		return get( "purified_nether_quartz_crystal" );
	}

	default IMaterialDefinition<Material> purifiedFluixCrystal()
	{
		return get( "purified_fluix_crystal" );
	}

	default IMaterialDefinition<Material> calcProcessorPress()
	{
		return get( "calc_processor_press" );
	}

	default IMaterialDefinition<Material> engProcessorPress()
	{
		return get( "eng_processor_press" );
	}

	default IMaterialDefinition<Material> logicProcessorPress()
	{
		return get( "logic_processor_press" );
	}

	default IMaterialDefinition<Material> calcProcessorPrint()
	{
		return get( "calc_processor_print" );
	}

	default IMaterialDefinition<Material> engProcessorPrint()
	{
		return get( "eng_processor_print" );
	}

	default IMaterialDefinition<Material> logicProcessorPrint()
	{
		return get( "logic_processor_print" );
	}

	default IMaterialDefinition<Material> siliconPress()
	{
		return get( "silicon_press" );
	}

	default IMaterialDefinition<Material> siliconPrint()
	{
		return get( "silicon_print" );
	}

	default IMaterialDefinition<Material> logicProcessor()
	{
		return get( "logic_processor" );
	}

	default IMaterialDefinition<Material> calcProcessor()
	{
		return get( "calc_processor" );
	}

	default IMaterialDefinition<Material> engProcessor()
	{
		return get( "eng_processor" );
	}

	default IMaterialDefinition<Material> basicCard()
	{
		return get( "basic_card" );
	}

	default IMaterialDefinition<Material> advCard()
	{
		return get( "adv_card" );
	}

	default IMaterialDefinition<Material> cell2SpatialPart()
	{
		return get( "cell_2_spatial_part" );
	}

	default IMaterialDefinition<Material> cell16SpatialPart()
	{
		return get( "cell_16_spatial_part" );
	}

	default IMaterialDefinition<Material> cell128SpatialPart()
	{
		return get( "cell_128_spatial_part" );
	}

	default IMaterialDefinition<Material> cell1kPart()
	{
		return get( "cell_1k_part" );
	}

	default IMaterialDefinition<Material> cell4kPart()
	{
		return get( "cell_4k_part" );
	}

	default IMaterialDefinition<Material> cell16kPart()
	{
		return get( "cell_16k_part" );
	}

	default IMaterialDefinition<Material> cell64kPart()
	{
		return get( "cell_64k_part" );
	}

	default IMaterialDefinition<Material> cellHousing()
	{
		return get( "cell_housing" );
	}

	default IMaterialDefinition<Material> woodenGear()
	{
		return get( "wooden_gear" );
	}

	default IMaterialDefinition<Material> formationCore()
	{
		return get( "formation_core" );
	}

	default IMaterialDefinition<Material> annihilationCore()
	{
		return get( "annihilation_core" );
	}

	default IMaterialDefinition<Material> skyDust()
	{
		return get( "sky_dust" );
	}

	default IMaterialDefinition<Material> enderDust()
	{
		return get( "ender_dust" );
	}

	default IMaterialDefinition<Material> wirelessReceiver()
	{
		return get( "wireless_receiver" );
	}

}
