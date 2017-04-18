
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

	private final IMaterialDefinition certusQuartzCrystal;
	private final IMaterialDefinition certusQuartzCrystalCharged;

	private final IMaterialDefinition certusQuartzDust;
	private final IMaterialDefinition netherQuartzDust;

	private final IMaterialDefinition goldDust;
	private final IMaterialDefinition ironDust;

	private final IMaterialDefinition silicon;

	private final IMaterialDefinition fluixCrystal;
	private final IMaterialDefinition fluixDust;
	private final IMaterialDefinition fluixPearl;

	private final IMaterialDefinition purifiedCertusQuartzCrystal;
	private final IMaterialDefinition purifiedNetherQuartzCrystal;
	private final IMaterialDefinition purifiedFluixCrystal;

	private final IMaterialDefinition woodenGear;

	private final IMaterialDefinition skyDust;
	private final IMaterialDefinition enderDust;

	public CoreMaterialDefinitions( FeatureFactory registry )
	{
		certusQuartzCrystal = registry.material( "certus_quartz_crystal", new Material() ).model( new ModelResourceLocation( new ResourceLocation( AppEng.MODID, MATERIALSMODELSLOCATION + "certus_quartz_crystal" ), MATERIALSMODELSVARIANT ) ).build();
		certusQuartzCrystalCharged = registry.material( "certus_quartz_crystal_charged", new Material() ).model( new ModelResourceLocation( new ResourceLocation( AppEng.MODID, MATERIALSMODELSLOCATION + "certus_quartz_crystal_charged" ), MATERIALSMODELSVARIANT ) ).build();

		certusQuartzDust = registry.material( "certus_quartz_dust", new Material() ).model( new ModelResourceLocation( new ResourceLocation( AppEng.MODID, MATERIALSMODELSLOCATION + "certus_quartz_dust" ), MATERIALSMODELSVARIANT ) ).build();
		netherQuartzDust = registry.material( "nether_quartz_dust", new Material() ).model( new ModelResourceLocation( new ResourceLocation( AppEng.MODID, MATERIALSMODELSLOCATION + "nether_quartz_dust" ), MATERIALSMODELSVARIANT ) ).build();

		goldDust = registry.material( "gold_dust", new Material() ).model( new ModelResourceLocation( new ResourceLocation( AppEng.MODID, MATERIALSMODELSLOCATION + "gold_dust" ), MATERIALSMODELSVARIANT ) ).build();
		ironDust = registry.material( "iron_dust", new Material() ).model( new ModelResourceLocation( new ResourceLocation( AppEng.MODID, MATERIALSMODELSLOCATION + "iron_dust" ), MATERIALSMODELSVARIANT ) ).build();

		silicon = registry.material( "silicon", new Material() ).model( new ModelResourceLocation( new ResourceLocation( AppEng.MODID, MATERIALSMODELSLOCATION + "silicon" ), MATERIALSMODELSVARIANT ) ).build();

		fluixCrystal = registry.material( "fluix_crystal", new Material() ).model( new ModelResourceLocation( new ResourceLocation( AppEng.MODID, MATERIALSMODELSLOCATION + "fluix_crystal" ), MATERIALSMODELSVARIANT ) ).build();
		fluixDust = registry.material( "fluix_dust", new Material() ).model( new ModelResourceLocation( new ResourceLocation( AppEng.MODID, MATERIALSMODELSLOCATION + "fluix_dust" ), MATERIALSMODELSVARIANT ) ).build();
		fluixPearl = registry.material( "fluix_pearl", new Material() ).model( new ModelResourceLocation( new ResourceLocation( AppEng.MODID, MATERIALSMODELSLOCATION + "fluix_pearl" ), MATERIALSMODELSVARIANT ) ).build();

		purifiedCertusQuartzCrystal = registry.material( "purified_certus_quartz_crystal", new Material() ).model( new ModelResourceLocation( new ResourceLocation( AppEng.MODID, MATERIALSMODELSLOCATION + "purified_certus_quartz_crystal" ), MATERIALSMODELSVARIANT ) ).build();
		purifiedNetherQuartzCrystal = registry.material( "purified_nether_quartz_crystal", new Material() ).model( new ModelResourceLocation( new ResourceLocation( AppEng.MODID, MATERIALSMODELSLOCATION + "purified_nether_quartz_crystal" ), MATERIALSMODELSVARIANT ) ).build();
		purifiedFluixCrystal = registry.material( "purified_fluix_crystal", new Material() ).model( new ModelResourceLocation( new ResourceLocation( AppEng.MODID, MATERIALSMODELSLOCATION + "purified_fluix_crystal" ), MATERIALSMODELSVARIANT ) ).build();

		woodenGear = registry.material( "wooden_gear", new Material() ).model( new ModelResourceLocation( new ResourceLocation( AppEng.MODID, MATERIALSMODELSLOCATION + "wooden_gear" ), MATERIALSMODELSVARIANT ) ).build();

		skyDust = registry.material( "sky_dust", new Material() ).model( new ModelResourceLocation( new ResourceLocation( AppEng.MODID, MATERIALSMODELSLOCATION + "sky_dust" ), MATERIALSMODELSVARIANT ) ).build();
		enderDust = registry.material( "ender_dust", new Material() ).model( new ModelResourceLocation( new ResourceLocation( AppEng.MODID, MATERIALSMODELSLOCATION + "ender_dust" ), MATERIALSMODELSVARIANT ) ).build();

		init();
	}

}
