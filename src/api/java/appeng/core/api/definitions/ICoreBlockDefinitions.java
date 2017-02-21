
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

	default IBlockDefinition<Block> inscriber()
	{
		return get( "inscriber" );
	}

	default IBlockDefinition<Block> vibrationChamber()
	{
		return get( "vibration_chamber" );
	}


}
