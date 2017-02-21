package appeng.core.me.api.definitions;


import net.minecraft.block.Block;

import appeng.api.definitions.IBlockDefinition;
import appeng.api.definitions.IDefinitions;


public interface IMEBlockDefinitions extends IDefinitions<Block, IBlockDefinition<Block>>
{
    default IBlockDefinition<Block> multiPart()
    {
        return get( "multipart_block" );
    }

    default IBlockDefinition<Block> wirelessAccessPoint()
    {
        return get( "wireless_access_point" );
    }

    default IBlockDefinition<Block> securityStation()
    {
        return get( "security_station" );
    }

    default IBlockDefinition<Block> quantumRing()
    {
        return get( "quantum_ring" );
    }

    default IBlockDefinition<Block> quantumLink()
    {
        return get( "quantum_link" );
    }

    default IBlockDefinition<Block> controller()
    {
        return get( "controller" );
    }

    default IBlockDefinition<Block> drive()
    {
        return get( "drive" );
    }

    default IBlockDefinition<Block> chest()
    {
        return get( "chest" );
    }

    default IBlockDefinition<Block> iface()
    {
        return get( "interface" );
    }

    default IBlockDefinition<Block> cellWorkbench()
    {
        return get( "cell_workbench" );
    }

    default IBlockDefinition<Block> iOPort()
    {
        return get( "ioport" );
    }

    default IBlockDefinition<Block> condenser()
    {
        return get( "condenser" );
    }

    default IBlockDefinition<Block> energyAcceptor()
    {
        return get( "energy_acceptor" );
    }

    default IBlockDefinition<Block> energyCell()
    {
        return get( "energy_cell" );
    }

    default IBlockDefinition<Block> energyCellDense()
    {
        return get( "dense_energy_cell" );
    }

    default IBlockDefinition<Block> energyCellCreative()
    {
        return get( "creative_energy_cell" );
    }

}
