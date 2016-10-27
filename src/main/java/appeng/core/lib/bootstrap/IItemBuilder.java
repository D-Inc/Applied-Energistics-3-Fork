
package appeng.core.lib.bootstrap;


import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import appeng.api.definitions.IItemDefinition;
import appeng.core.lib.features.SubDefinitionsProvider;


/**
 * Allows an item to be defined and registered with the game.
 * The item is only registered once build is called.
 */
public interface IItemBuilder<I extends Item, S extends SubDefinitionsProvider<I, ?, ?, ?>, II extends IItemBuilder<I, S, II>> extends IDefinitionBuilder<I, IItemDefinition<I>, S, II>
{

	II creativeTab( CreativeTabs tab );

	II rendering( ItemRenderingCustomizer callback );

}
