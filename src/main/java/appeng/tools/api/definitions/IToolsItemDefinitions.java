
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



    default IItemDefinition<Item> entropyManipulator()
    {
        return get( "entropy_manipulator" );
    }

    default IItemDefinition<Item> biometricCard()
    {
        return get( "charged_staff" );
    }

    default IItemDefinition<Item> chargedStaff()
    {
        return get( "mass_cannon" );
    }

}
