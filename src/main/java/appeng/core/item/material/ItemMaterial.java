
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

	@Override
	public void getSubItems( Item itemIn, CreativeTabs tab, NonNullList<ItemStack> subItems )
	{
		for( Material material : Material.REGISTRY )
		{
			subItems.add( getItemStack( new State<ItemMaterial>( this ).withProperty( MaterialProperty.INSTANCE, material ), 0 ) );
		}
	}

}
