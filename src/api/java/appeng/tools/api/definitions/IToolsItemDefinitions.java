
package appeng.tools.api.definitions;


import net.minecraft.item.Item;

import appeng.api.definitions.IDefinitions;
import appeng.api.definitions.IItemDefinition;


public interface IToolsItemDefinitions extends IDefinitions<Item, IItemDefinition<Item>>
{
    default IItemDefinition<? extends Item> certusQuartzAxe()
    {
        return get( "certus_quartz_axe" );
    }

    default IItemDefinition<? extends Item> certusQuartzHoe()
    {
        return get( "certus_quartz_hoe" );
    }

    default IItemDefinition<? extends Item> certusQuartzShovel()
    {
        return get( "certus_quartz_spade" );
    }

    default IItemDefinition<? extends Item> certusQuartzPick()
    {
        return get( "certus_quartz_pickaxe" );
    }

    default IItemDefinition<? extends Item> certusQuartzSword()
    {
        return get( "certus_quartz_sword" );
    }

    default IItemDefinition<? extends Item> certusQuartzWrench()
    {
        return get( "certus_quartz_wrench" );
    }

    default IItemDefinition<? extends Item> certusQuartzKnife()
    {
        return get( "certus_quartz_cutting_knife" );
    }


    default IItemDefinition<? extends Item> netherQuartzAxe()
    {
        return get( "nether_quartz_axe" );
    }

    default IItemDefinition<? extends Item> netherQuartzHoe()
    {
        return get( "nether_quartz_hoe" );
    }

    default IItemDefinition<? extends Item> netherQuartzShovel()
    {
        return get( "nether_quartz_spade" );
    }

    default IItemDefinition<? extends Item> netherQuartzPick()
    {
        return get( "nether_quartz_pickaxe" );
    }

    default IItemDefinition<? extends Item> netherQuartzSword()
    {
        return get( "nether_quartz_sword" );
    }

    default IItemDefinition<? extends Item> netherQuartzWrench()
    {
        return get( "nether_quartz_wrench" );
    }

    default IItemDefinition<? extends Item> netherQuartzKnife()
    {
        return get( "nether_quartz_cutting_knife" );
    }


    default IItemDefinition<? extends Item> entropyManipulator()
    {
        return get( "entropy_manipulator" );
    }

    default IItemDefinition<? extends Item> wirelessTerminal()
    {
        return get( "wireless_terminal" );
    }

    default IItemDefinition<? extends Item> biometricCard()
    {
        return get( "charged_staff" );
    }

    default IItemDefinition<? extends Item> chargedStaff()
    {
        return get( "mass_cannon" );
    }

    default IItemDefinition<? extends Item> massCannon()
    {
        return get( "portable_cell" );
    }

    default IItemDefinition<? extends Item> memoryCard()
    {
        return get( "biometric_card" );
    }

    default IItemDefinition<? extends Item> networkTool()
    {
        return get( "memory_card" );
    }

    default IItemDefinition<? extends Item> portableCell()
    {
        return get( "network_tool" );
    }


    default IItemDefinition<? extends Item> colorApplicator()
    {
        return get( "color_applicator" );
    }

}
