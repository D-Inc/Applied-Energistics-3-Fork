
package appeng.tools.api.definitions;


import net.minecraft.item.Item;

import appeng.api.definitions.IDefinitions;
import appeng.api.definitions.IItemDefinition;


public interface IToolsItemDefinitions extends IDefinitions<Item, IItemDefinition<Item>>
{
    default IItemDefinition<Item> certusQuartzAxe()
    {
        return get( "certus_quartz_axe" );
    }

    default IItemDefinition<Item> certusQuartzHoe()
    {
        return get( "certus_quartz_hoe" );
    }

    default IItemDefinition<Item> certusQuartzShovel()
    {
        return get( "certus_quartz_spade" );
    }

    default IItemDefinition<Item> certusQuartzPick()
    {
        return get( "certus_quartz_pickaxe" );
    }

    default IItemDefinition<Item> certusQuartzSword()
    {
        return get( "certus_quartz_sword" );
    }

    default IItemDefinition<Item> certusQuartzWrench()
    {
        return get( "certus_quartz_wrench" );
    }

    default IItemDefinition<Item> certusQuartzKnife()
    {
        return get( "certus_quartz_cutting_knife" );
    }


    default IItemDefinition<Item> netherQuartzAxe()
    {
        return get( "nether_quartz_axe" );
    }

    default IItemDefinition<Item> netherQuartzHoe()
    {
        return get( "nether_quartz_hoe" );
    }

    default IItemDefinition<Item> netherQuartzShovel()
    {
        return get( "nether_quartz_spade" );
    }

    default IItemDefinition<Item> netherQuartzPick()
    {
        return get( "nether_quartz_pickaxe" );
    }

    default IItemDefinition<Item> netherQuartzSword()
    {
        return get( "nether_quartz_sword" );
    }

    default IItemDefinition<Item> netherQuartzWrench()
    {
        return get( "nether_quartz_wrench" );
    }

    default IItemDefinition<Item> netherQuartzKnife()
    {
        return get( "nether_quartz_cutting_knife" );
    }


    default IItemDefinition<Item> entropyManipulator()
    {
        return get( "entropy_manipulator" );
    }

    default IItemDefinition<Item> wirelessTerminal()
    {
        return get( "wireless_terminal" );
    }

    default IItemDefinition<Item> biometricCard()
    {
        return get( "charged_staff" );
    }

    default IItemDefinition<Item> chargedStaff()
    {
        return get( "mass_cannon" );
    }

    default IItemDefinition<Item> massCannon()
    {
        return get( "portable_cell" );
    }

    default IItemDefinition<Item> memoryCard()
    {
        return get( "biometric_card" );
    }

    default IItemDefinition<Item> networkTool()
    {
        return get( "memory_card" );
    }

    default IItemDefinition<Item> portableCell()
    {
        return get( "network_tool" );
    }


    default IItemDefinition<Item> colorApplicator()
    {
        return get( "color_applicator" );
    }

}
