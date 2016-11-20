
package appeng.core.me.api.definitions;


import appeng.api.definitions.IItemDefinition;
import net.minecraft.item.Item;

import appeng.api.definitions.IDefinitions;
import appeng.api.definitions.IItemDefinition;
import net.minecraft.item.Item;


public interface IMEItemDefinitions extends IDefinitions<Item, IItemDefinition<Item>>
{

    default IItemDefinition<? extends Item> cellCreative()
    {
        return get( "creative_storage_cell" );
    }

    default IItemDefinition<? extends Item> viewCell()
    {
        return get( "view_cell" );
    }

    default IItemDefinition<? extends Item> cell1k()
    {
        return get( "basic_storage_cell_1k" );
    }

    default IItemDefinition<? extends Item> cell4k()
    {
        return get( "basic_storage_cell_4k" );
    }

    default IItemDefinition<? extends Item> cell16k()
    {
        return get( "basic_storage_cell_16k" );
    }

    default IItemDefinition<? extends Item> cell64k()
    {
        return get( "basic_storage_cell_64k" );
    }


    default IItemDefinition<? extends Item> blockMultiPart()
    {
        return get( "multipart_block" );
    }

    default IItemDefinition<? extends Item> blockWirelessAccessPoint()
    {
        return get( "wireless_access_point" );
    }

    default IItemDefinition<? extends Item> blockSecurityStation()
    {
        return get( "security_station" );
    }

    default IItemDefinition<? extends Item> blockQuantumRing()
    {
        return get( "quantum_ring" );
    }

    default IItemDefinition<? extends Item> blockQuantumLink()
    {
        return get( "quantum_link" );
    }

    default IItemDefinition<? extends Item> blockController()
    {
        return get( "controller" );
    }

    default IItemDefinition<? extends Item> blockDrive()
    {
        return get( "drive" );
    }

    default IItemDefinition<? extends Item> blockChest()
    {
        return get( "chest" );
    }

    default IItemDefinition<? extends Item> blockInterface()
    {
        return get( "interface" );
    }

    default IItemDefinition<? extends Item> blockCellWorkbench()
    {
        return get( "cell_workbench" );
    }

    default IItemDefinition<? extends Item> blockIOPort()
    {
        return get( "ioport" );
    }

    default IItemDefinition<? extends Item> blockCondenser()
    {
        return get( "condenser" );
    }

    default IItemDefinition<? extends Item> blockEnergyAcceptor()
    {
        return get( "energy_acceptor" );
    }

    default IItemDefinition<? extends Item> blockEnergyCell()
    {
        return get( "energy_cell" );
    }

    default IItemDefinition<? extends Item> blockEnergyCellDense()
    {
        return get( "dense_energy_cell" );
    }

    default IItemDefinition<? extends Item> blockEnergyCellCreative()
    {
        return get( "creative_energy_cell" );
    }
    
}
