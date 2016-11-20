package appeng.core.me.api.definitions;


import net.minecraft.block.Block;

import appeng.api.definitions.IBlockDefinition;
import appeng.api.definitions.IDefinitions;


public interface IMEBlockDefinitions extends IDefinitions<Block, IBlockDefinition<Block>>
{
    default IBlockDefinition<? extends Block> multiPart()
    {
        return get( "multipart_block" );
    }

    default IBlockDefinition<? extends Block> wirelessAccessPoint()
    {
        return get( "wireless_access_point" );
    }

    default IBlockDefinition<? extends Block> securityStation()
    {
        return get( "security_station" );
    }

    default IBlockDefinition<? extends Block> quantumRing()
    {
        return get( "quantum_ring" );
    }

    default IBlockDefinition<? extends Block> quantumLink()
    {
        return get( "quantum_link" );
    }

    default IBlockDefinition<? extends Block> controller()
    {
        return get( "controller" );
    }

    default IBlockDefinition<? extends Block> drive()
    {
        return get( "drive" );
    }

    default IBlockDefinition<? extends Block> chest()
    {
        return get( "chest" );
    }

    default IBlockDefinition<? extends Block> iface()
    {
        return get( "interface" );
    }

    default IBlockDefinition<? extends Block> cellWorkbench()
    {
        return get( "cell_workbench" );
    }

    default IBlockDefinition<? extends Block> iOPort()
    {
        return get( "ioport" );
    }

    default IBlockDefinition<? extends Block> condenser()
    {
        return get( "condenser" );
    }

    default IBlockDefinition<? extends Block> energyAcceptor()
    {
        return get( "energy_acceptor" );
    }

    default IBlockDefinition<? extends Block> energyCell()
    {
        return get( "energy_cell" );
    }

    default IBlockDefinition<? extends Block> energyCellDense()
    {
        return get( "dense_energy_cell" );
    }

    default IBlockDefinition<? extends Block> energyCellCreative()
    {
        return get( "creative_energy_cell" );
    }

}
