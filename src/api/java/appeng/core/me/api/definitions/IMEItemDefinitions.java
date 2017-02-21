
package appeng.core.me.api.definitions;


import appeng.api.definitions.IItemDefinition;
import net.minecraft.item.Item;

import appeng.api.definitions.IDefinitions;
import appeng.api.definitions.IItemDefinition;
import net.minecraft.item.Item;


public interface IMEItemDefinitions extends IDefinitions<Item, IItemDefinition<Item>>
{

    default IItemDefinition<Item> cellCreative()
    {
        return get( "creative_storage_cell" );
    }

    default IItemDefinition<Item> viewCell()
    {
        return get( "view_cell" );
    }

    default IItemDefinition<Item> cell1k()
    {
        return get( "basic_storage_cell_1k" );
    }

    default IItemDefinition<Item> cell4k()
    {
        return get( "basic_storage_cell_4k" );
    }

    default IItemDefinition<Item> cell16k()
    {
        return get( "basic_storage_cell_16k" );
    }

    default IItemDefinition<Item> cell64k()
    {
        return get( "basic_storage_cell_64k" );
    }


    default IItemDefinition<Item> blockMultiPart()
    {
        return get( "multipart_block" );
    }

    default IItemDefinition<Item> blockWirelessAccessPoint()
    {
        return get( "wireless_access_point" );
    }

    default IItemDefinition<Item> blockSecurityStation()
    {
        return get( "security_station" );
    }

    default IItemDefinition<Item> blockQuantumRing()
    {
        return get( "quantum_ring" );
    }

    default IItemDefinition<Item> blockQuantumLink()
    {
        return get( "quantum_link" );
    }

    default IItemDefinition<Item> blockController()
    {
        return get( "controller" );
    }

    default IItemDefinition<Item> blockDrive()
    {
        return get( "drive" );
    }

    default IItemDefinition<Item> blockChest()
    {
        return get( "chest" );
    }

    default IItemDefinition<Item> blockInterface()
    {
        return get( "interface" );
    }

    default IItemDefinition<Item> blockCellWorkbench()
    {
        return get( "cell_workbench" );
    }

    default IItemDefinition<Item> blockIOPort()
    {
        return get( "ioport" );
    }

    default IItemDefinition<Item> blockCondenser()
    {
        return get( "condenser" );
    }

    default IItemDefinition<Item> blockEnergyAcceptor()
    {
        return get( "energy_acceptor" );
    }

    default IItemDefinition<Item> blockEnergyCell()
    {
        return get( "energy_cell" );
    }

    default IItemDefinition<Item> blockEnergyCellDense()
    {
        return get( "dense_energy_cell" );
    }

    default IItemDefinition<Item> blockEnergyCellCreative()
    {
        return get( "creative_energy_cell" );
    }
    
}
