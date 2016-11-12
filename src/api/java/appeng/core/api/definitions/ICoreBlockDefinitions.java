
package appeng.core.api.definitions;


import appeng.api.definitions.IBlockDefinition;
import net.minecraft.block.Block;

import appeng.api.definitions.IDefinition;
import appeng.api.definitions.IDefinitions;


public interface ICoreBlockDefinitions extends IDefinitions<Block, IBlockDefinition<Block> >
{

	default IBlockDefinition<Block> blockCrank()
	{
		return get( "crank" );
	}

	default IBlockDefinition<Block> blockCharger()
	{
		return get( "charger" );
	}

	default IBlockDefinition<Block> blockGrinder()
	{
		return get( "grinder" );
	}

	default IBlockDefinition<Block> blockInscriber()
	{
		return get( "inscriber" );
	}

	default IBlockDefinition<Block> blockVibrationChamber()
	{
		return get( "vibration_chamber" );
	}


}
