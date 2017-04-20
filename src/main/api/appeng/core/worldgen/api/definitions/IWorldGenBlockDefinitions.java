
package appeng.core.worldgen.api.definitions;


import net.minecraft.block.Block;

import appeng.api.definitions.IBlockDefinition;
import appeng.api.definitions.IDefinitions;


public interface IWorldGenBlockDefinitions extends IDefinitions<Block, IBlockDefinition<Block>>
{
    default IBlockDefinition<Block> quartzOre()
    {
        return get( "quartz_ore" );
    }

    default IBlockDefinition<Block> quartzOreCharged()
    {
        return get( "charged_quartz_ore" );
    }

    default IBlockDefinition<Block> skyStoneChest()
    {
        return get( "skystone_chest" );
    }

    default IBlockDefinition<Block> smoothSkyStoneChest()
    {
        return get( "smooth_skystone_chest" );
    }
    
    default IBlockDefinition<Block> meteoriteCompass()
    {
        return get( "meteorite_compass" );
    }
}
