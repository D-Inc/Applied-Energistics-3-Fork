
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

	default IMaterialDefinition<Material> woodenGear()
	{
		return get( "wooden_gear" );
	}

	default IMaterialDefinition<Material> skyDust()
	{
		return get( "sky_dust" );
	}

	default IMaterialDefinition<Material> enderDust()
	{
		return get( "ender_dust" );
	}

}
