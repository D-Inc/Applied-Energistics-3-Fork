
package appeng.core.lib.bootstrap;


import java.util.function.BiConsumer;
import java.util.function.Function;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

import appeng.api.definitions.IBlockDefinition;
import appeng.core.lib.features.AEFeature;


public interface IBlockBuilder extends IDefinitionBuilder<IBlockDefinition, IBlockBuilder>
{

	IBlockBuilder preInit( BiConsumer<Block, Item> callback );

	IBlockBuilder init( BiConsumer<Block, Item> callback );

	IBlockBuilder postInit( BiConsumer<Block, Item> callback );

	IBlockBuilder rendering( BlockRenderingCustomizer callback );

	IBlockBuilder item( Function<Block, ItemBlock> factory );

}
