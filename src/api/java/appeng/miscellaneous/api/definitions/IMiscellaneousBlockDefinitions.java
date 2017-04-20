
package appeng.miscellaneous.api.definitions;


import net.minecraft.block.Block;

import appeng.api.definitions.IBlockDefinition;
import appeng.api.definitions.IDefinitions;


public interface IMiscellaneousBlockDefinitions extends IDefinitions<Block, IBlockDefinition<Block>>
{

	default IBlockDefinition<Block> lightDetectingFixture()
	{
		return get( "light_detecting_fixture" );
	}

}
