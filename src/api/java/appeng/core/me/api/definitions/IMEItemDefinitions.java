
package appeng.core.me.api.definitions;


import appeng.api.definitions.IItemDefinition;
import net.minecraft.item.Item;

import appeng.api.definitions.IDefinitions;
import appeng.api.definitions.IItemDefinition;
import net.minecraft.item.ItemBlock;


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


    default IItemDefinition<? extends ItemBlock> blockMultiPart()
    {
        return ( IItemDefinition< ? extends ItemBlock > ) get( "multipart_block" );
    }

    default IItemDefinition<? extends ItemBlock> blockWirelessAccessPoint()
    {
        return ( IItemDefinition< ? extends ItemBlock > ) get( "wireless_access_point" );
    }

    default IItemDefinition<? extends ItemBlock> blockSecurityStation()
    {
        return ( IItemDefinition< ? extends ItemBlock > ) get( "security_station" );
    }

    default IItemDefinition<? extends ItemBlock> blockQuantumRing()
    {
        return ( IItemDefinition< ? extends ItemBlock > ) get( "quantum_ring" );
    }

    default IItemDefinition<? extends ItemBlock> blockQuantumLink()
    {
        return ( IItemDefinition< ? extends ItemBlock > ) get( "quantum_link" );
    }

    default IItemDefinition<? extends ItemBlock> blockController()
    {
        return ( IItemDefinition< ? extends ItemBlock > ) get( "controller" );
    }

    default IItemDefinition<? extends ItemBlock> blockDrive()
    {
        return ( IItemDefinition< ? extends ItemBlock > ) get( "drive" );
    }

    default IItemDefinition<? extends ItemBlock> blockChest()
    {
        return ( IItemDefinition< ? extends ItemBlock > ) get( "chest" );
    }

    default IItemDefinition<? extends ItemBlock> blockInterface()
    {
        return ( IItemDefinition< ? extends ItemBlock > ) get( "interface" );
    }

    default IItemDefinition<? extends ItemBlock> blockCellWorkbench()
    {
        return ( IItemDefinition< ? extends ItemBlock > ) get( "cell_workbench" );
    }

    default IItemDefinition<? extends ItemBlock> blockIOPort()
    {
        return ( IItemDefinition< ? extends ItemBlock > ) get( "ioport" );
    }

    default IItemDefinition<? extends ItemBlock> blockCondenser()
    {
        return ( IItemDefinition< ? extends ItemBlock > ) get( "condenser" );
    }

    default IItemDefinition<? extends ItemBlock> blockEnergyAcceptor()
    {
        return ( IItemDefinition< ? extends ItemBlock > ) get( "energy_acceptor" );
    }

    default IItemDefinition<? extends ItemBlock> blockEnergyCell()
    {
        return ( IItemDefinition< ? extends ItemBlock > ) get( "energy_cell" );
    }

    default IItemDefinition<? extends ItemBlock> blockEnergyCellDense()
    {
        return ( IItemDefinition< ? extends ItemBlock > ) get( "dense_energy_cell" );
    }

    default IItemDefinition<? extends ItemBlock> blockEnergyCellCreative()
    {
        return ( IItemDefinition< ? extends ItemBlock > ) get( "creative_energy_cell" );
    }
    
}
