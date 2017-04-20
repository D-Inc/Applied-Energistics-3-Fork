package appeng.api.definitions.sub;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;

public interface IBlockSubDefinition<BS extends IBlockState, B extends Block, S extends IBlockSubDefinition<BS, B, S>> extends ISubDefinition<BS, B, S>
{

}
