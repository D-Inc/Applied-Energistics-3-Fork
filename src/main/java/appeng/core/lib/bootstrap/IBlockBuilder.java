
package appeng.core.lib.bootstrap;


import net.minecraft.block.Block;

import appeng.api.definitions.IBlockDefinition;
import appeng.core.lib.features.SubDefinitionsProvider;


public interface IBlockBuilder<B extends Block, S extends SubDefinitionsProvider<B, ?, ?, ?>, BB extends IBlockBuilder<B, S, BB>> extends IDefinitionBuilder<B, IBlockDefinition<B>, S, BB>
{

	BB rendering( BlockRenderingCustomizer callback );

}
