
package appeng.core.worldgen.api.definitions;


import net.minecraft.block.Block;

import appeng.api.definitions.IBlockDefinition;
import appeng.api.definitions.IDefinitions;


public interface IWorldGenBlockDefinitions extends IDefinitions<Block, IBlockDefinition<Block>>
{
    default IBlockDefinition<? extends Block> quartzOre()
    {
        return get( "quartz_ore" );
    }

    default IBlockDefinition<? extends Block> quartzOreCharged()
    {
        return get( "charged_quartz_ore" );
    }

    default IBlockDefinition<? extends Block> skyStoneChest()
    {
        return get( "skystone_chest" );
    }

    default IBlockDefinition<? extends Block> smoothSkyStoneChest()
    {
        return get( "smooth_skystone_chest" );
    }
}
