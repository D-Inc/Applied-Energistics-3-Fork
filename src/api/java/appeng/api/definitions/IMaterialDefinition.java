
package appeng.api.definitions;


import java.util.Optional;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import appeng.api.definitions.sub.ISubDefinition;
import appeng.api.definitions.sub.ISubDefinitionProperty;
import appeng.core.api.items.IItemMaterial;
import appeng.core.api.material.Material;
import appeng.core.lib.item.IStateItem;


public interface IMaterialDefinition<M extends Material> extends IDefinition<M>
{

	<I extends Item & IItemMaterial<I>, D, P extends ISubDefinitionProperty<I, D, ?>, S extends ISubDefinition<I, D, P, ? extends S>> Optional<S> maybeAsSubDefinition();

	default Optional<ItemStack> maybeStack( int amount )
	{
		return maybeAsSubDefinition().map( subDefinition -> ( (IStateItem.State<?>) subDefinition.maybe().get() ).toItemStack( amount ) );
	}

}
