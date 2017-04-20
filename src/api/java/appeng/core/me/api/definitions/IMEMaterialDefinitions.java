
package appeng.core.me.api.definitions;


import appeng.api.definitions.IDefinitions;
import appeng.api.definitions.IMaterialDefinition;
import appeng.core.api.material.Material;


public interface IMEMaterialDefinitions extends IDefinitions<Material, IMaterialDefinition<Material>>
{

	default IMaterialDefinition<Material> siliconPress()
	{
		return get( "silicon_press" );
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

	default IMaterialDefinition<Material> siliconPrint()
	{
		return get( "silicon_print" );
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

	default IMaterialDefinition<Material> cellHousing()
	{
		return get( "cell_housing" );
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

	default IMaterialDefinition<Material> formationCore()
	{
		return get( "formation_core" );
	}

	default IMaterialDefinition<Material> annihilationCore()
	{
		return get( "annihilation_core" );
	}

	default IMaterialDefinition<Material> wirelessReceiver()
	{
		return get( "wireless_receiver" );
	}

}
