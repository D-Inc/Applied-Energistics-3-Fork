package appeng.core.lib.bootstrap;

import appeng.api.definitions.IDefinition;
import appeng.api.definitions.IItemDefinition;
import appeng.core.lib.features.ItemDefinition;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

import javax.annotation.Nonnull;

public interface IItemBlockCustomizer
{
    @Nonnull ItemBlock createItemBlock( Block b);

    /**
     *
     * @param builder the to-be-completed definition
     * @return the completed definition
     */
    @Nonnull default <I extends Item> IItemDefinition<I> build( @Nonnull ItemDefinitionBuilder<I> builder){
        return builder.build();
    }

}
