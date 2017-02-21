
package appeng.core.definitions;


import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.util.ResourceLocation;

import appeng.api.definitions.IMaterialDefinition;
import appeng.core.AppEng;
import appeng.core.api.definitions.ICoreMaterialDefinitions;
import appeng.core.api.material.Material;
import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.definitions.Definitions;


public class CoreMaterialDefinitions extends Definitions<Material, IMaterialDefinition<Material>> implements ICoreMaterialDefinitions
{

	private static final String MATERIALSMODELSLOCATION = "material/";
	private static final String MATERIALSMODELSVARIANT = "inventory";

	// TODO 1.11.2-CD:A - Not all materials belong to the core module. Move them accordingly.

	private final IMaterialDefinition certusQuartzCrystal;
	private final IMaterialDefinition certusQuartzCrystalCharged;

	private final IMaterialDefinition certusQuartzDust;
	private final IMaterialDefinition netherQuartzDust;

	private final IMaterialDefinition flour;

	private final IMaterialDefinition goldDust;
	private final IMaterialDefinition ironDust;

	private final IMaterialDefinition silicon;

	private final IMaterialDefinition matterBall;

	private final IMaterialDefinition fluixCrystal;
	private final IMaterialDefinition fluixDust;
	private final IMaterialDefinition fluixPearl;

	private final IMaterialDefinition purifiedCertusQuartzCrystal;
	private final IMaterialDefinition purifiedNetherQuartzCrystal;
	private final IMaterialDefinition purifiedFluixCrystal;

	private final IMaterialDefinition calcProcessorPress;
	private final IMaterialDefinition engProcessorPress;
	private final IMaterialDefinition logicProcessorPress;

	private final IMaterialDefinition calcProcessorPrint;
	private final IMaterialDefinition engProcessorPrint;
	private final IMaterialDefinition logicProcessorPrint;

	private final IMaterialDefinition siliconPress;
	private final IMaterialDefinition siliconPrint;

	private final IMaterialDefinition namePress;

	private final IMaterialDefinition logicProcessor;
	private final IMaterialDefinition calcProcessor;
	private final IMaterialDefinition engProcessor;

	private final IMaterialDefinition basicCard;
	private final IMaterialDefinition advCard;

	private final IMaterialDefinition cell2SpatialPart;
	private final IMaterialDefinition cell16SpatialPart;
	private final IMaterialDefinition cell128SpatialPart;

	private final IMaterialDefinition cell1kPart;
	private final IMaterialDefinition cell4kPart;
	private final IMaterialDefinition cell16kPart;
	private final IMaterialDefinition cell64kPart;
	private final IMaterialDefinition cellHousing;

	private final IMaterialDefinition woodenGear;

	private final IMaterialDefinition formationCore;
	private final IMaterialDefinition annihilationCore;

	private final IMaterialDefinition skyDust;
	private final IMaterialDefinition enderDust;

	public CoreMaterialDefinitions( FeatureFactory registry )
	{
		certusQuartzCrystal = registry.material( "certus_quartz_crystal", new Material() ).model( new ModelResourceLocation( new ResourceLocation( AppEng.MODID, MATERIALSMODELSLOCATION + "certus_quartz_crystal" ), MATERIALSMODELSVARIANT ) ).build();
		certusQuartzCrystalCharged = registry.material( "certus_quartz_crystal_charged", new Material() ).model( new ModelResourceLocation( new ResourceLocation( AppEng.MODID, MATERIALSMODELSLOCATION + "certus_quartz_crystal_charged" ), MATERIALSMODELSVARIANT ) ).build();
		certusQuartzDust = registry.material( "certus_quartz_dust", new Material() ).model( new ModelResourceLocation( new ResourceLocation( AppEng.MODID, MATERIALSMODELSLOCATION + "certus_quartz_dust" ), MATERIALSMODELSVARIANT ) ).build();
		netherQuartzDust = registry.material( "nether_quartz_dust", new Material() ).model( new ModelResourceLocation( new ResourceLocation( AppEng.MODID, MATERIALSMODELSLOCATION + "nether_quartz_dust" ), MATERIALSMODELSVARIANT ) ).build();
		flour = registry.material( "flour", new Material() ).model( new ModelResourceLocation( new ResourceLocation( AppEng.MODID, MATERIALSMODELSLOCATION + "flour" ), MATERIALSMODELSVARIANT ) ).build();
		goldDust = registry.material( "gold_dust", new Material() ).model( new ModelResourceLocation( new ResourceLocation( AppEng.MODID, MATERIALSMODELSLOCATION + "gold_dust" ), MATERIALSMODELSVARIANT ) ).build();
		ironDust = registry.material( "iron_dust", new Material() ).model( new ModelResourceLocation( new ResourceLocation( AppEng.MODID, MATERIALSMODELSLOCATION + "iron_dust" ), MATERIALSMODELSVARIANT ) ).build();
		silicon = registry.material( "silicon", new Material() ).model( new ModelResourceLocation( new ResourceLocation( AppEng.MODID, MATERIALSMODELSLOCATION + "silicon" ), MATERIALSMODELSVARIANT ) ).build();
		matterBall = registry.material( "matter_ball", new Material() ).model( new ModelResourceLocation( new ResourceLocation( AppEng.MODID, MATERIALSMODELSLOCATION + "matter_ball" ), MATERIALSMODELSVARIANT ) ).build();
		fluixCrystal = registry.material( "fluix_crystal", new Material() ).model( new ModelResourceLocation( new ResourceLocation( AppEng.MODID, MATERIALSMODELSLOCATION + "fluix_crystal" ), MATERIALSMODELSVARIANT ) ).build();
		fluixDust = registry.material( "fluix_dust", new Material() ).model( new ModelResourceLocation( new ResourceLocation( AppEng.MODID, MATERIALSMODELSLOCATION + "fluix_dust" ), MATERIALSMODELSVARIANT ) ).build();
		fluixPearl = registry.material( "fluix_pearl", new Material() ).model( new ModelResourceLocation( new ResourceLocation( AppEng.MODID, MATERIALSMODELSLOCATION + "fluix_pearl" ), MATERIALSMODELSVARIANT ) ).build();
		purifiedCertusQuartzCrystal = registry.material( "purified_certus_quartz_crystal", new Material() ).model( new ModelResourceLocation( new ResourceLocation( AppEng.MODID, MATERIALSMODELSLOCATION + "purified_certus_quartz_crystal" ), MATERIALSMODELSVARIANT ) ).build();
		purifiedNetherQuartzCrystal = registry.material( "purified_nether_quartz_crystal", new Material() ).model( new ModelResourceLocation( new ResourceLocation( AppEng.MODID, MATERIALSMODELSLOCATION + "purified_nether_quartz_crystal" ), MATERIALSMODELSVARIANT ) ).build();
		purifiedFluixCrystal = registry.material( "purified_fluix_crystal", new Material() ).model( new ModelResourceLocation( new ResourceLocation( AppEng.MODID, MATERIALSMODELSLOCATION + "purified_fluix_crystal" ), MATERIALSMODELSVARIANT ) ).build();
		calcProcessorPress = registry.material( "calc_processor_press", new Material() ).model( new ModelResourceLocation( new ResourceLocation( AppEng.MODID, MATERIALSMODELSLOCATION + "calc_processor_press" ), MATERIALSMODELSVARIANT ) ).build();
		engProcessorPress = registry.material( "eng_processor_press", new Material() ).model( new ModelResourceLocation( new ResourceLocation( AppEng.MODID, MATERIALSMODELSLOCATION + "eng_processor_press" ), MATERIALSMODELSVARIANT ) ).build();
		logicProcessorPress = registry.material( "logic_processor_press", new Material() ).model( new ModelResourceLocation( new ResourceLocation( AppEng.MODID, MATERIALSMODELSLOCATION + "logic_processor_press" ), MATERIALSMODELSVARIANT ) ).build();
		calcProcessorPrint = registry.material( "calc_processor_print", new Material() ).model( new ModelResourceLocation( new ResourceLocation( AppEng.MODID, MATERIALSMODELSLOCATION + "calc_processor_print" ), MATERIALSMODELSVARIANT ) ).build();
		engProcessorPrint = registry.material( "eng_processor_print", new Material() ).model( new ModelResourceLocation( new ResourceLocation( AppEng.MODID, MATERIALSMODELSLOCATION + "eng_processor_print" ), MATERIALSMODELSVARIANT ) ).build();
		logicProcessorPrint = registry.material( "logic_processor_print", new Material() ).model( new ModelResourceLocation( new ResourceLocation( AppEng.MODID, MATERIALSMODELSLOCATION + "logic_processor_print" ), MATERIALSMODELSVARIANT ) ).build();
		siliconPress = registry.material( "silicon_press", new Material() ).model( new ModelResourceLocation( new ResourceLocation( AppEng.MODID, MATERIALSMODELSLOCATION + "silicon_press" ), MATERIALSMODELSVARIANT ) ).build();
		siliconPrint = registry.material( "silicon_print", new Material() ).model( new ModelResourceLocation( new ResourceLocation( AppEng.MODID, MATERIALSMODELSLOCATION + "silicon_print" ), MATERIALSMODELSVARIANT ) ).build();
		namePress = registry.material( "name_press", new Material() ).model( new ModelResourceLocation( new ResourceLocation( AppEng.MODID, MATERIALSMODELSLOCATION + "name_press" ), MATERIALSMODELSVARIANT ) ).build();
		logicProcessor = registry.material( "logic_processor", new Material() ).model( new ModelResourceLocation( new ResourceLocation( AppEng.MODID, MATERIALSMODELSLOCATION + "logic_processor" ), MATERIALSMODELSVARIANT ) ).build();
		calcProcessor = registry.material( "calc_processor", new Material() ).model( new ModelResourceLocation( new ResourceLocation( AppEng.MODID, MATERIALSMODELSLOCATION + "calc_processor" ), MATERIALSMODELSVARIANT ) ).build();
		engProcessor = registry.material( "eng_processor", new Material() ).model( new ModelResourceLocation( new ResourceLocation( AppEng.MODID, MATERIALSMODELSLOCATION + "eng_processor" ), MATERIALSMODELSVARIANT ) ).build();
		basicCard = registry.material( "basic_card", new Material() ).model( new ModelResourceLocation( new ResourceLocation( AppEng.MODID, MATERIALSMODELSLOCATION + "basic_card" ), MATERIALSMODELSVARIANT ) ).build();
		advCard = registry.material( "adv_card", new Material() ).model( new ModelResourceLocation( new ResourceLocation( AppEng.MODID, MATERIALSMODELSLOCATION + "adv_card" ), MATERIALSMODELSVARIANT ) ).build();
		cell2SpatialPart = registry.material( "cell_2_spatial_part", new Material() ).model( new ModelResourceLocation( new ResourceLocation( AppEng.MODID, MATERIALSMODELSLOCATION + "cell_2_spatial_part" ), MATERIALSMODELSVARIANT ) ).build();
		cell16SpatialPart = registry.material( "cell_16_spatial_part", new Material() ).model( new ModelResourceLocation( new ResourceLocation( AppEng.MODID, MATERIALSMODELSLOCATION + "cell_16_spatial_part" ), MATERIALSMODELSVARIANT ) ).build();
		cell128SpatialPart = registry.material( "cell_128_spatial_part", new Material() ).model( new ModelResourceLocation( new ResourceLocation( AppEng.MODID, MATERIALSMODELSLOCATION + "cell_128_spatial_part" ), MATERIALSMODELSVARIANT ) ).build();
		cell1kPart = registry.material( "cell_1k_part", new Material() ).model( new ModelResourceLocation( new ResourceLocation( AppEng.MODID, MATERIALSMODELSLOCATION + "cell_1k_part" ), MATERIALSMODELSVARIANT ) ).build();
		cell4kPart = registry.material( "cell_4k_part", new Material() ).model( new ModelResourceLocation( new ResourceLocation( AppEng.MODID, MATERIALSMODELSLOCATION + "cell_4k_part" ), MATERIALSMODELSVARIANT ) ).build();
		cell16kPart = registry.material( "cell_16k_part", new Material() ).model( new ModelResourceLocation( new ResourceLocation( AppEng.MODID, MATERIALSMODELSLOCATION + "cell_16k_part" ), MATERIALSMODELSVARIANT ) ).build();
		cell64kPart = registry.material( "cell_64k_part", new Material() ).model( new ModelResourceLocation( new ResourceLocation( AppEng.MODID, MATERIALSMODELSLOCATION + "cell_64k_part" ), MATERIALSMODELSVARIANT ) ).build();
		cellHousing = registry.material( "cell_housing", new Material() ).model( new ModelResourceLocation( new ResourceLocation( AppEng.MODID, MATERIALSMODELSLOCATION + "cell_housing" ), MATERIALSMODELSVARIANT ) ).build();
		woodenGear = registry.material( "wooden_gear", new Material() ).model( new ModelResourceLocation( new ResourceLocation( AppEng.MODID, MATERIALSMODELSLOCATION + "wooden_gear" ), MATERIALSMODELSVARIANT ) ).build();
		formationCore = registry.material( "formation_core", new Material() ).model( new ModelResourceLocation( new ResourceLocation( AppEng.MODID, MATERIALSMODELSLOCATION + "formation_core" ), MATERIALSMODELSVARIANT ) ).build();
		annihilationCore = registry.material( "annihilation_core", new Material() ).model( new ModelResourceLocation( new ResourceLocation( AppEng.MODID, MATERIALSMODELSLOCATION + "annihilation_core" ), MATERIALSMODELSVARIANT ) ).build();
		skyDust = registry.material( "sky_dust", new Material() ).model( new ModelResourceLocation( new ResourceLocation( AppEng.MODID, MATERIALSMODELSLOCATION + "sky_dust" ), MATERIALSMODELSVARIANT ) ).build();
		enderDust = registry.material( "ender_dust", new Material() ).model( new ModelResourceLocation( new ResourceLocation( AppEng.MODID, MATERIALSMODELSLOCATION + "ender_dust" ), MATERIALSMODELSVARIANT ) ).build();

		init();
	}

}
