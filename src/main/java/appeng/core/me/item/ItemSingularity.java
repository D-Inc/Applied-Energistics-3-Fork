
package appeng.core.me.item;


import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import appeng.api.item.IStateItem;
import appeng.api.item.IStateItem.State.Property;
import appeng.core.lib.item.AEBaseItem;
import appeng.core.me.entity.EntitySingularity;


public class ItemSingularity extends AEBaseItem implements IStateItem<ItemSingularity>
{

	public static final IStateItem.State.Property<Boolean> ENTANGLED = new Property<Boolean>(){

		@Override
		public String getName()
		{
			return "entangled";
		}

		@Override
		public boolean isValid( Boolean value )
		{
			return value != null;
		}

	};

	@Override
	public boolean isValid( Property property )
	{
		return property == ENTANGLED;
	}

	@Override
	public Property getProperty( String name )
	{
		return name.equals( ENTANGLED.getName() ) ? ENTANGLED : null;
	}

	@Override
	public IStateItem.State<ItemSingularity> getState( ItemStack itemstack )
	{
		return new State<ItemSingularity>( this ).withProperty( ENTANGLED, itemstack.getItemDamage() == 1 );
	}

	@Override
	public State<ItemSingularity> getDefaultState()
	{
		return new State<ItemSingularity>( this ).withProperty( ENTANGLED, false );
	}

	@Override
	public ItemStack getItemStack( State<ItemSingularity> state, int amount )
	{
		return new ItemStack( this, amount, state.getValue( ENTANGLED ) ? 1 : 0 );
	}

	@Override
	public Entity createEntity( World world, Entity location, ItemStack itemstack )
	{
		return new EntitySingularity( world, location.posX, location.posY, location.posZ, itemstack );
	}

}
