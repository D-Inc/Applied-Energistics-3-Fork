
package appeng.core.item.material;


import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.common.registry.FMLControlledNamespacedRegistry;

import appeng.core.AppEng;
import appeng.core.AppEngCore;
import appeng.core.api.items.IItemMaterial;
import appeng.core.api.material.Material;
import appeng.core.lib.item.AEBaseItem;
import appeng.core.lib.item.IStateItem;
import appeng.core.lib.item.IStateItem.State.Property;


public class ItemMaterial extends AEBaseItem implements IItemMaterial<ItemMaterial>, IStateItem<ItemMaterial>
{

	public static final FMLControlledNamespacedRegistry<Material> REGISTRY = AppEng.instance().getModule( AppEngCore.class ).getMaterialRegistry();

	public static enum MaterialProperty implements IStateItem.State.Property<Material, ItemMaterial>
	{

		INSTANCE;

		@Override
		public String getName()
		{
			return "material";
		}

		@Override
		public boolean isValid( Material value )
		{
			return REGISTRY.containsValue( value );
		}

	}

	public ItemMaterial()
	{
		setHasSubtypes( true );
	}

	@Override
	public boolean isValid( Property property )
	{
		return property == ItemMaterial.MaterialProperty.INSTANCE;
	}

	@Override
	public Property getProperty( String name )
	{
		return name.equals( ItemMaterial.MaterialProperty.INSTANCE.getName() ) ? ItemMaterial.MaterialProperty.INSTANCE : null;
	}

	@Override
	public State<ItemMaterial> getState( ItemStack itemstack )
	{
		return new State<>( this ).withProperty( ItemMaterial.MaterialProperty.INSTANCE, REGISTRY.getObjectById( itemstack.getMetadata() ) );
	}

	@Override
	public ItemStack getItemStack( State<ItemMaterial> state, int amount )
	{
		return new ItemStack( this, amount, REGISTRY.getId( state.getValue( ItemMaterial.MaterialProperty.INSTANCE ) ) );
	}

	/**
	 * Helper method for {@linkplain ItemStack} to {@linkplain Material} conversion.
	 * 
	 * @param itemstack to convert
	 * @return {@linkplain Material} corresponding to given stack.
	 */
	public Material getMaterial( ItemStack itemstack )
	{
		return getState( itemstack ).getValue( ItemMaterial.MaterialProperty.INSTANCE );
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
		return getItemStack( new State<ItemMaterial>( this ).withProperty( ItemMaterial.MaterialProperty.INSTANCE, material ), amount );
	}

	/*
	 * OVERRIDES START
	 */

	@Override
	public void getSubItems( Item itemIn, CreativeTabs tab, NonNullList<ItemStack> subItems )
	{
		for( Material material : REGISTRY )
		{
			subItems.add( getItemStack( material, 1 ) );
		}
	}

	@Override
	public String getUnlocalizedName()
	{
		return getUnlocalizedName( ItemStack.EMPTY );
	}

	@Override
	public String getUnlocalizedName( ItemStack itemstack )
	{
		return "material." + getMaterial( itemstack ).getUnlocalizedName( itemstack );
	}

	@Override
	public String getItemStackDisplayName( ItemStack itemstack )
	{
		String display = getMaterial( itemstack ).getDisplayName( itemstack );
		return display != null ? display : super.getItemStackDisplayName( itemstack );
	}

}
