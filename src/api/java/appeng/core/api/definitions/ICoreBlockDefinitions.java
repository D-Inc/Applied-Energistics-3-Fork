
package appeng.core.api.definitions;


import net.minecraft.block.Block;

import appeng.api.definitions.IDefinition;
import appeng.api.definitions.IDefinitions;


public interface ICoreBlockDefinitions extends IDefinitions<Block>
{

	default IDefinition<Block> blockCrank(){
		return get( "crank" );
	}

	default IDefinition<Block> blockCharger()
	{
		return get( "charger" );
	}

	default IDefinition<Block> blockGrinder()
	{
		return get( "grinder" );
	}

	default IDefinition<Block> blockInscriber()
	{
		return get( "inscriber" );
	}

	default IDefinition<Block> blockVibrationChamber()
	{
		return get( "vibration_chamber" );
	}


}
