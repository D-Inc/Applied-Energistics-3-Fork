
package appeng.core.api.definitions;


import net.minecraft.item.Item;

import appeng.api.definitions.IDefinition;
import appeng.api.definitions.IDefinitions;


public interface ICoreItemDefinitions extends IDefinitions<Item>
{

	default IDefinition<Item> crystalSeed()
	{
		return get( "crystal_seed" );
	}

	default IDefinition<Item> multiItem()
	{
		return get( "multiItem" );
	}

}
