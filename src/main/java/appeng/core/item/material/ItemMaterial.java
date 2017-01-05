
package appeng.core.item.material;


import com.google.common.collect.Maps;

import net.minecraft.item.ItemStack;

import appeng.core.item.material.Material.MaterialProperty;
import appeng.core.lib.item.AEBaseItem;
import appeng.core.lib.item.IStateItem;
import appeng.core.lib.item.IStateItem.State.Property;


public class ItemMaterial extends AEBaseItem implements IStateItem<ItemMaterial>
{

	public ItemMaterial()
	{
		setHasSubtypes( true );
	}

	@Override
	public boolean isValid( Property property )
	{
		return property == MaterialProperty.INSTANCE;
	}

	@Override
	public Property getProperty( String name )
	{
		return name.equals( MaterialProperty.INSTANCE.getName() ) ? MaterialProperty.INSTANCE : null;
	}

	@Override
	public State<ItemMaterial> getState( ItemStack itemstack )
	{
		return new State<>( this, Maps.newHashMap() ).withProperty( MaterialProperty.INSTANCE, Material.REGISTRY.getObjectById( itemstack.getMetadata() ) );
	}

	@Override
	public ItemStack getItemStack( State<ItemMaterial> state, int amount )
	{
		return new ItemStack( this, amount, Material.REGISTRY.getId( state.getValue( MaterialProperty.INSTANCE ) ) );
	}

}
