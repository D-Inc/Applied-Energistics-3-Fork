
package appeng.core.me.api.definitions;


import appeng.api.definitions.IItemDefinition;

import net.minecraft.block.Item;
import net.minecraft.item.Item;

import appeng.api.definitions.IItemDefinition;
import appeng.api.definitions.IDefinitions;
import appeng.api.definitions.IItemDefinition;
import net.minecraft.item.Item;


public interface IMEItemDefinitions extends IDefinitions<Item, IItemDefinition<Item>>
{

	default IItemDefinition<Item> cellCreative()
	{
		return get( "cell_creative" );
	}

	default IItemDefinition<Item> viewCell()
	{
		return get( "view_cell" );
	}

	default IItemDefinition<Item> cell1k()
	{
		return get( "cell1k" );
	}

	default IItemDefinition<Item> cell4k()
	{
		return get( "cell4k" );
	}

	default IItemDefinition<Item> cell16k()
	{
		return get( "cell16k" );
	}

	default IItemDefinition<Item> cell64k()
	{
		return get( "cell64k" );
	}

	default IItemDefinition<Item> wirelessTerminal()
	{
		return get( "wireless_terminal" );
	}

	default IItemDefinition<Item> memoryCard()
	{
		return get( "memory_card" );
	}

	default IItemDefinition<Item> biometricCard()
	{
		return get( "biometric_card" );
	}

	default IItemDefinition<Item> networkTool()
	{
		return get( "network_tool" );
	}

	default IItemDefinition<Item> portableCell()
	{
		return get( "portable_cell" );
	}

	default IItemDefinition<Item> basicCard()
	{
		return get( "basic_card" );
	}

	default IItemDefinition<Item> capacityCard()
	{
		return get( "capacity_card" );
	}

	default IItemDefinition<Item> redstoneCard()
	{
		return get( "redstone_card" );
	}

	default IItemDefinition<Item> advancedCard()
	{
		return get( "advanced_card" );
	}

	default IItemDefinition<Item> fuzzyCard()
	{
		return get( "fuzzy_card" );
	}

	default IItemDefinition<Item> inverterCard()
	{
		return get( "inverter_card" );
	}

	default IItemDefinition<Item> accelerationCard()
	{
		return get( "acceleration_card" );
	}

	default IItemDefinition<Item> singularity()
	{
		return get( "singularity" );
	}

	default IItemDefinition<Item> wirelessBooster()
	{
		return get( "wireless_booster" );
	}

	default IItemDefinition<Item> logicProcessor()
	{
		return get( "logic_processor" );
	}

	default IItemDefinition<Item> calculationProcessor()
	{
		return get( "calculation_processor" );
	}

	default IItemDefinition<Item> engineeringProcessor()
	{
		return get( "engineering_processor" );
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

	default IItemDefinition<Item> blockInscriber()
	{
		return get( "inscriber" );
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

	default IItemDefinition<Item> blockIface()
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

}
