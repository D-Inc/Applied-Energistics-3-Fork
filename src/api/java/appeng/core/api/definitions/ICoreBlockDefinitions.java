
package appeng.core.api.definitions;


import net.minecraft.block.Block;

import appeng.api.definitions.IBlockDefinition;
import appeng.api.definitions.IDefinitions;


public interface ICoreBlockDefinitions extends IDefinitions<Block, IBlockDefinition<Block>>
{

	default IBlockDefinition<? extends Block> crank()
	{
		return get( "crank" );
	}

	default IBlockDefinition<? extends Block> charger()
	{
		return get( "charger" );
	}

	default IBlockDefinition<? extends Block> grinder()
	{
		return get( "grinder" );
	}

	default IBlockDefinition<? extends Block> inscriber()
	{
		return get( "inscriber" );
	}

	default IBlockDefinition<? extends Block> vibrationChamber()
	{
		return get( "vibration_chamber" );
	}


}
