
package appeng.core.me.definitions;


import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.util.ResourceLocation;

import appeng.api.definitions.IMaterialDefinition;
import appeng.core.AppEng;
import appeng.core.api.material.Material;
import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.definitions.Definitions;
import appeng.core.me.api.definitions.IMEMaterialDefinitions;


public class MEMaterialDefinitions extends Definitions<Material, IMaterialDefinition<Material>> implements IMEMaterialDefinitions
{

	private static final String MATERIALSMODELSLOCATION = "material/";
	private static final String MATERIALSMODELSVARIANT = "inventory";

	private final IMaterialDefinition siliconPress;
	private final IMaterialDefinition calcProcessorPress;
	private final IMaterialDefinition engProcessorPress;
	private final IMaterialDefinition logicProcessorPress;

	private final IMaterialDefinition siliconPrint;
	private final IMaterialDefinition calcProcessorPrint;
	private final IMaterialDefinition engProcessorPrint;
	private final IMaterialDefinition logicProcessorPrint;

	private final IMaterialDefinition cellHousing;
	private final IMaterialDefinition cell1kPart;
	private final IMaterialDefinition cell4kPart;
	private final IMaterialDefinition cell16kPart;
	private final IMaterialDefinition cell64kPart;

	private final IMaterialDefinition formationCore;
	private final IMaterialDefinition annihilationCore;

	private final IMaterialDefinition wirelessReceiver;

	public MEMaterialDefinitions( FeatureFactory registry )
	{
		siliconPress = registry.material( "silicon_press", new Material() ).model( new ModelResourceLocation( new ResourceLocation( AppEng.MODID, MATERIALSMODELSLOCATION + "silicon_press" ), MATERIALSMODELSVARIANT ) ).build();
		calcProcessorPress = registry.material( "calc_processor_press", new Material() ).model( new ModelResourceLocation( new ResourceLocation( AppEng.MODID, MATERIALSMODELSLOCATION + "calc_processor_press" ), MATERIALSMODELSVARIANT ) ).build();
		engProcessorPress = registry.material( "eng_processor_press", new Material() ).model( new ModelResourceLocation( new ResourceLocation( AppEng.MODID, MATERIALSMODELSLOCATION + "eng_processor_press" ), MATERIALSMODELSVARIANT ) ).build();
		logicProcessorPress = registry.material( "logic_processor_press", new Material() ).model( new ModelResourceLocation( new ResourceLocation( AppEng.MODID, MATERIALSMODELSLOCATION + "logic_processor_press" ), MATERIALSMODELSVARIANT ) ).build();

		siliconPrint = registry.material( "silicon_print", new Material() ).model( new ModelResourceLocation( new ResourceLocation( AppEng.MODID, MATERIALSMODELSLOCATION + "silicon_print" ), MATERIALSMODELSVARIANT ) ).build();
		calcProcessorPrint = registry.material( "calc_processor_print", new Material() ).model( new ModelResourceLocation( new ResourceLocation( AppEng.MODID, MATERIALSMODELSLOCATION + "calc_processor_print" ), MATERIALSMODELSVARIANT ) ).build();
		engProcessorPrint = registry.material( "eng_processor_print", new Material() ).model( new ModelResourceLocation( new ResourceLocation( AppEng.MODID, MATERIALSMODELSLOCATION + "eng_processor_print" ), MATERIALSMODELSVARIANT ) ).build();
		logicProcessorPrint = registry.material( "logic_processor_print", new Material() ).model( new ModelResourceLocation( new ResourceLocation( AppEng.MODID, MATERIALSMODELSLOCATION + "logic_processor_print" ), MATERIALSMODELSVARIANT ) ).build();

		cellHousing = registry.material( "cell_housing", new Material() ).model( new ModelResourceLocation( new ResourceLocation( AppEng.MODID, MATERIALSMODELSLOCATION + "cell_housing" ), MATERIALSMODELSVARIANT ) ).build();
		cell1kPart = registry.material( "cell_1k_part", new Material() ).model( new ModelResourceLocation( new ResourceLocation( AppEng.MODID, MATERIALSMODELSLOCATION + "cell_1k_part" ), MATERIALSMODELSVARIANT ) ).build();
		cell4kPart = registry.material( "cell_4k_part", new Material() ).model( new ModelResourceLocation( new ResourceLocation( AppEng.MODID, MATERIALSMODELSLOCATION + "cell_4k_part" ), MATERIALSMODELSVARIANT ) ).build();
		cell16kPart = registry.material( "cell_16k_part", new Material() ).model( new ModelResourceLocation( new ResourceLocation( AppEng.MODID, MATERIALSMODELSLOCATION + "cell_16k_part" ), MATERIALSMODELSVARIANT ) ).build();
		cell64kPart = registry.material( "cell_64k_part", new Material() ).model( new ModelResourceLocation( new ResourceLocation( AppEng.MODID, MATERIALSMODELSLOCATION + "cell_64k_part" ), MATERIALSMODELSVARIANT ) ).build();

		formationCore = registry.material( "formation_core", new Material() ).model( new ModelResourceLocation( new ResourceLocation( AppEng.MODID, MATERIALSMODELSLOCATION + "formation_core" ), MATERIALSMODELSVARIANT ) ).build();
		annihilationCore = registry.material( "annihilation_core", new Material() ).model( new ModelResourceLocation( new ResourceLocation( AppEng.MODID, MATERIALSMODELSLOCATION + "annihilation_core" ), MATERIALSMODELSVARIANT ) ).build();

		wirelessReceiver = registry.material( "wireless_receiver", new Material() ).model( new ModelResourceLocation( new ResourceLocation( AppEng.MODID, MATERIALSMODELSLOCATION + "wireless_receiver" ), MATERIALSMODELSVARIANT ) ).build();

		init();
	}

}
