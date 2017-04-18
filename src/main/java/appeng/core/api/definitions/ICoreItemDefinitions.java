
package appeng.core.api.definitions;


import net.minecraft.item.Item;

import appeng.api.definitions.IDefinitions;
import appeng.api.definitions.IItemDefinition;


public interface ICoreItemDefinitions extends IDefinitions<Item, IItemDefinition<Item>>
{

	default IItemDefinition<Item> material()
	{
		return get( "material" );
	}
	
	default IItemDefinition<Item> crystalSeed()
	{
		return get( "crystal_seed" );
	}

    default IItemDefinition<Item> certusQuartzWrench()
    {
        return get( "certus_quartz_wrench" );
    }

    default IItemDefinition<Item> certusQuartzKnife()
    {
    	return get( "certus_quartz_cutting_knife" );
    }

    default IItemDefinition<Item> netherQuartzWrench()
    {
        return get( "nether_quartz_wrench" );
    }

    default IItemDefinition<Item> netherQuartzKnife()
    {
        return get( "nether_quartz_cutting_knife" );
    }
    
    
    
	default IItemDefinition<Item> blockCrank()
	{
		return get( "crank" );
	}

	default IItemDefinition<Item> blockCharger()
	{
		return get( "charger" );
	}

	default IItemDefinition<Item> blockGrinder()
	{
		return get( "grinder" );
	}

	default IItemDefinition<Item> blockVibrationChamber()
	{
		return get( "vibration_chamber" );
	}

	default IItemDefinition<Item> blockEnergyAcceptor()
	{
		return get( "energy_acceptor" );
	}

	default IItemDefinition<Item> blockEnergyCell()
	{
		return get( "energy_cell" );
	}

	default IItemDefinition<Item> blockEnergyCellDense()
	{
		return get( "energy_cell_dense" );
	}

	default IItemDefinition<Item> blockEnergyCellCreative()
	{
		return get( "energy_cell_creative" );
	}

	default IItemDefinition<Item> blockCrystalGrowthAccelerator()
	{
		return get( "crystal_growth_accelerator" );
	}

	default IItemDefinition<Item> blockTinyTNT()
	{
		return get( "tiny_tnt" );
	}

	default IItemDefinition<Item> blockSkyStone()
	{
		return get( "sky_stone" );
	}

	default IItemDefinition<Item> blockQuartzGlass()
	{
		return get( "quartz_glass" );
	}

	default IItemDefinition<Item> blockQuartzVibrantGlass()
	{
		return get( "quartz_vibrant_glass" );
	}

}
