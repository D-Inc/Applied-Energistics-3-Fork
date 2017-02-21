
package appeng.miscellaneous.api.definitions;


import net.minecraft.block.Block;

import appeng.api.definitions.IBlockDefinition;
import appeng.api.definitions.IDefinitions;


public interface IMiscellaneousBlockDefinitions extends IDefinitions<Block, IBlockDefinition<Block>>
{
    default IBlockDefinition<Block> skyCompass()
    {
        return get( "sky_compass" );
    }

    default IBlockDefinition<Block> tinyTNT()
    {
        return get( "tiny_tnt" );
    }

    default IBlockDefinition<Block> quartzGrowthAccelerator()
    {
        return get( "quartz_growth_accelerator" );
    }

    default IBlockDefinition<Block> lightDetector()
    {
        return get( "light_detector" );
    }

    default IBlockDefinition<Block> paint()
    {
        return get( "paint" );
    }

}
