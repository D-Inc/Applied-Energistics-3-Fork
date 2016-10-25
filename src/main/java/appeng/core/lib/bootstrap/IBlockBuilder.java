
package appeng.core.lib.bootstrap;


import java.util.function.Function;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

import appeng.api.definitions.IBlockDefinition;


public interface IBlockBuilder<B extends Block, BB extends IBlockBuilder<B, BB>> extends IDefinitionBuilder<B, IBlockDefinition<B>, BB>
{

	BB rendering( BlockRenderingCustomizer callback );

	BB item( Function<Block, ItemBlock> factory );

}
