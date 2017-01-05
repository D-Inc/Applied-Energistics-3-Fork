
package appeng.core.item.material;


import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

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
		return new State<>( this ).withProperty( MaterialProperty.INSTANCE, Material.REGISTRY.getObjectById( itemstack.getMetadata() ) );
	}

	@Override
	public ItemStack getItemStack( State<ItemMaterial> state, int amount )
	{
		return new ItemStack( this, amount, Material.REGISTRY.getId( state.getValue( MaterialProperty.INSTANCE ) ) );
	}

	/**
	 * Helper method for {@linkplain ItemStack} to {@linkplain Material} conversion.
	 * 
	 * @param itemstack to convert
	 * @return {@linkplain Material} corresponding to given stack.
	 */
	public Material getMaterial( ItemStack itemstack )
	{
		return getState( itemstack ).getValue( MaterialProperty.INSTANCE );
	}

	/**
	 * Helper method for {@linkplain Material} to {@linkplain ItemStack} conversion.
	 * 
	 * @param material to convert
	 * @param amount of resulting items in stack
	 * @return {@linkplain ItemStack} corresponding to given material containing given amount of items.
	 */
	public ItemStack getItemStack( Material material, int amount )
	{
		return getItemStack( new State<ItemMaterial>( this ).withProperty( MaterialProperty.INSTANCE, material ), amount );
	}

	@Override
	public void getSubItems( Item itemIn, CreativeTabs tab, NonNullList<ItemStack> subItems )
	{
		for( Material material : Material.REGISTRY )
		{
			subItems.add( getItemStack( material, 1 ) );
		}
	}

}
