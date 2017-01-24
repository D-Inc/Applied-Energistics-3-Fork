
package appeng.api.definitions;


import net.minecraft.item.Item;

import appeng.api.definitions.sub.ISubDefinition;
import appeng.api.definitions.sub.ISubDefinitionProperty;
import appeng.core.api.items.IItemMaterial;
import appeng.core.item.material.Material;


public interface IMaterialDefinition<M extends Material> extends IDefinition<M>
{

	public <I extends Item & IItemMaterial<I>, D, P extends ISubDefinitionProperty<I, D, ?>, S extends ISubDefinition<I, D, P, ? extends S>> S asSubDefinition();

}
