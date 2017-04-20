
package appeng.core.api.definitions;


import net.minecraft.block.Block;

import appeng.api.definitions.IBlockDefinition;
import appeng.api.definitions.IDefinitions;


public interface ICoreBlockDefinitions extends IDefinitions<Block, IBlockDefinition<Block>>
{

	default IBlockDefinition<Block> crank()
	{
		return get( "crank" );
	}

	default IBlockDefinition<Block> charger()
	{
		return get( "charger" );
	}

	default IBlockDefinition<Block> grinder()
	{
		return get( "grinder" );
	}

	default IBlockDefinition<Block> vibrationChamber()
	{
		return get( "vibration_chamber" );
	}

	default IBlockDefinition<Block> energyAcceptor()
	{
		return get( "energy_acceptor" );
	}

	default IBlockDefinition<Block> energyCell()
	{
		return get( "energy_cell" );
	}

	default IBlockDefinition<Block> energyCellDense()
	{
		return get( "energy_cell_dense" );
	}

	default IBlockDefinition<Block> energyCellCreative()
	{
		return get( "energy_cell_creative" );
	}

	default IBlockDefinition<Block> crystalGrowthAccelerator()
	{
		return get( "crystal_growth_accelerator" );
	}

	default IBlockDefinition<Block> tinyTNT()
	{
		return get( "tiny_tnt" );
	}

	default IBlockDefinition<Block> skyStone()
	{
		return get( "sky_stone" );
	}

	default IBlockDefinition<Block> quartzGlass()
	{
		return get( "quartz_glass" );
	}

	default IBlockDefinition<Block> quartzVibrantGlass()
	{
		return get( "quartz_vibrant_glass" );
	}

}
