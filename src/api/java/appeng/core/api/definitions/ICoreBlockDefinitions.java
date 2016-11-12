
package appeng.core.api.definitions;


import net.minecraft.block.Block;

import appeng.api.definitions.IDefinition;
import appeng.api.definitions.IDefinitions;


public interface ICoreBlockDefinitions extends IDefinitions<Block>
{

	default IDefinition<? extends Block> blockCrank()
	{
		return get( "crank" );
	}

	default IDefinition<? extends Block> blockCharger()
	{
		return get( "charger" );
	}

	default IDefinition<? extends Block> blockGrinder()
	{
		return get( "grinder" );
	}

	default IDefinition<? extends Block> blockInscriber()
	{
		return get( "inscriber" );
	}

	default IDefinition<? extends Block> blockVibrationChamber()
	{
		return get( "vibration_chamber" );
	}


}
