
package appeng.core.lib.definitions;


import java.util.Optional;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

import appeng.api.definitions.IItemDefinition;
import appeng.api.definitions.IMaterialDefinition;
import appeng.api.definitions.sub.ISubDefinition;
import appeng.api.definitions.sub.ISubDefinitionProperty;
import appeng.core.AppEngCore;
import appeng.core.api.items.IItemMaterial;
import appeng.core.api.material.Material;
import appeng.core.definitions.CoreItemDefinitions;
import appeng.core.item.material.ItemMaterial;


public class MaterialDefinition<M extends Material> extends Definition<M> implements IMaterialDefinition<M>
{

	private static IItemDefinition<ItemMaterial> itemMaterialDefinition = AppEngCore.INSTANCE.<Item, CoreItemDefinitions>definitions( Item.class ).getUncheked( "material" );

	public MaterialDefinition( ResourceLocation identifier, M material )
	{
		super( identifier, material );
	}

	@Override
	public <I extends Item & IItemMaterial<I>, D, P extends ISubDefinitionProperty<I, D, ?>, S extends ISubDefinition<I, D, P, ? extends S>> Optional<S> asSubDefinition()
	{
		return (Optional<S>) asSubDefinitionC();
	}

	public <I extends ItemMaterial, D, P extends ISubDefinitionProperty<I, D, M>, S extends ISubDefinition<I, D, P, S>> Optional<S> asSubDefinitionC()
	{
		return maybe().map( material -> itemMaterialDefinition.<I, D, P, S>maybeSubDefinition().get().withProperty( (P) ItemMaterial.MaterialProperty.INSTANCE, material ) );
	}

	@Override
	public boolean isSameAs( Object other )
	{
		// TODO 1.11.2-CD:A - Add checks
		return super.isSameAs( other );
	}

}
