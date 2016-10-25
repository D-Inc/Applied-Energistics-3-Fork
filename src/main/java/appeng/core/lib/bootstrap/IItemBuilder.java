
package appeng.core.lib.bootstrap;


import net.minecraft.creativetab.CreativeTabs;

import appeng.api.definitions.IItemDefinition;


/**
 * Allows an item to be defined and registered with the game.
 * The item is only registered once build is called.
 */
public interface IItemBuilder extends IDefinitionBuilder<IItemDefinition, IItemBuilder>
{

	IItemBuilder creativeTab( CreativeTabs tab );

	IItemBuilder rendering( ItemRenderingCustomizer callback );

}
