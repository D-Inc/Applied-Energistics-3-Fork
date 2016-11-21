
package appeng.core.me.api.definitions;


import net.minecraft.tileentity.TileEntity;

import appeng.api.definitions.IDefinitions;
import appeng.api.definitions.ITileDefinition;


public interface IMETileDefinitions extends IDefinitions<Class<TileEntity>, ITileDefinition<TileEntity>>
{

    default ITileDefinition<? extends TileEntity> multiPart()
    {
        return get( "multipart_block" );
    }

    default ITileDefinition<? extends TileEntity> wirelessAccessPoint()
    {
        return get( "wireless_access_point" );
    }


    default ITileDefinition<? extends TileEntity> securityStation()
    {
        return get( "security_station" );
    }

    //TODO 1.11-CN:R - Subdefine.
    default ITileDefinition<? extends TileEntity> quantumRing()
    {
        return get( "quantum_ring" );
    }

//	default ITileDefinition<? extends TileEntity> quantumLink()
//    {
//        return get( "quantum_link" );
//    }

    default ITileDefinition<? extends TileEntity> controller()
    {
        return get( "controller" );
    }

    default ITileDefinition<? extends TileEntity> drive()
    {
        return get( "drive" );
    }

    default ITileDefinition<? extends TileEntity> chest()
    {
        return get( "chest" );
    }

    default ITileDefinition<? extends TileEntity> iface()
    {
        return get( "interface" );
    }

    default ITileDefinition<? extends TileEntity> cellWorkbench()
    {
        return get( "cell_workbench" );
    }

    default ITileDefinition<? extends TileEntity> iOPort()
    {
        return get( "ioport" );
    }

    default ITileDefinition<? extends TileEntity> condenser()
    {
        return get( "condenser" );
    }

    default ITileDefinition<? extends TileEntity> energyAcceptor()
    {
        return get( "energy_acceptor" );
    }

    default ITileDefinition<? extends TileEntity> energyCell()
    {
        return get( "energy_cell" );
    }

    default ITileDefinition<? extends TileEntity> energyCellDense()
    {
        return get( "dense_energy_cell" );
    }

    default ITileDefinition<? extends TileEntity> energyCellCreative()
    {
        return get( "creative_energy_cell" );
    }

    
}
