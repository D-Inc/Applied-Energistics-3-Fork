
package appeng.core.api.definitions;


import net.minecraft.tileentity.TileEntity;

import appeng.api.definitions.IDefinitions;
import appeng.api.definitions.ITileDefinition;


public interface ICoreTileDefinitions extends IDefinitions<Class<TileEntity>, ITileDefinition<TileEntity>>
{

	default ITileDefinition<TileEntity> crank()
	{
		return get( "crank" );
	}

	default ITileDefinition<TileEntity> charger()
	{
		return get( "charger" );
	}

	default ITileDefinition<TileEntity> grinder()
	{
		return get( "grinder" );
	}

	default ITileDefinition<TileEntity> vibrationChamber()
	{
		return get( "vibration_chamber" );
	}

	default ITileDefinition<TileEntity> energyAcceptor()
	{
		return get( "energy_acceptor" );
	}

	default ITileDefinition<TileEntity> energyCell()
	{
		return get( "energy_cell" );
	}

	default ITileDefinition<TileEntity> energyCellDense()
	{
		return get( "energy_cell_dense" );
	}

	default ITileDefinition<TileEntity> energyCellCreative()
	{
		return get( "energy_cell_creative" );
	}

	default ITileDefinition<TileEntity> crystalGrowthAccelerator()
	{
		return get( "crystal_growth_accelerator" );
	}

}
