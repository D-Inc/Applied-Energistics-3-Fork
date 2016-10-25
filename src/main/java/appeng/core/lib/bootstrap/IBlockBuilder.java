
package appeng.core.lib.bootstrap;


import java.util.function.Function;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

import appeng.api.definitions.IBlockDefinition;


public interface IBlockBuilder<B extends Block> extends IDefinitionBuilder<B, IBlockDefinition<B>, IBlockBuilder<B>>
{

	IBlockBuilder<B> rendering( BlockRenderingCustomizer callback );

	IBlockBuilder<B> item( Function<Block, ItemBlock> factory );

}
