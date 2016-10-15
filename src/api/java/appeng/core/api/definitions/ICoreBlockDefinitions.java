
package appeng.core.api.definitions;


import net.minecraft.block.Block;

import appeng.api.definitions.IDefinition;
import appeng.api.definitions.IDefinitions;


public interface ICoreBlockDefinitions extends IDefinitions<Block>
{

	default IDefinition<Block> blockCrank(){
		return get( "crank" );
	}

}
