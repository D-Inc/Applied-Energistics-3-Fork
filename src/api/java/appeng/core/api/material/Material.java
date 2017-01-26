
package appeng.core.api.material;


import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.IForgeRegistryEntry;


/**
 * In most cases, a material is an item without other purposes than being converted into another item (another material or something actually useful), be it using crafting, processing or any other imaginable way.<br>
 * This class allows you to create new material items without clogging item ids - it will use a single AE item for all the materials.<br>
 * <br>
 * A material is registered just like you would register any other {@linkplain IForgeRegistryEntry} thing - {@link GameRegistry#register(IForgeRegistryEntry)}.
 * 
 * @author Elix_x
 *
 */
public class Material extends IForgeRegistryEntry.Impl<Material>
{

	private ModelResourceLocation model;
	private String unlocalizedName;

	/**
	 * Sets the default model location.
	 * 
	 * @param model - new default model location
	 */
	protected void setModel( ModelResourceLocation model )
	{
		this.model = model;
	}

	/**
	 * Retrieves model location based on the stack.
	 * 
	 * @param itemstack - stack to get model for
	 * @return model location for the given stack
	 */
	@Nonnull
	public ModelResourceLocation getModel( ItemStack itemstack )
	{
		return model;
	}

	/**
	 * Sets the default unlocalized name.
	 * 
	 * @param unlocalizedName - new default unlocalized name
	 */
	protected void setUnlocalizedName( String unlocalizedName )
	{
		this.unlocalizedName = unlocalizedName;
	}

	/**
	 * Retrieves unlocalized name based on the item stack.<br>
	 * <b>It will be localized by prefixing <tt>material.</tt></b> and not <tt>item.</tt>!
	 * 
	 * @param itemstack - stack to get unlocalized name for
	 * @return unlocalized name for the given stack
	 */
	@Nonnull
	public String getUnlocalizedName( ItemStack itemstack )
	{
		return unlocalizedName;
	}

	/**
	 * Retrieves display name for the item stack. Returning <tt>null</tt> will cause {@linkplain #getUnlocalizedName(ItemStack)} to be called and localized.
	 * 
	 * @param itemstack - stack to get display name for
	 * @return display name for the given stack, or null if {@linkplain #getUnlocalizedName(ItemStack)} should be used instead
	 */
	@Nullable
	public String getDisplayName( ItemStack itemstack )
	{
		return null;
	}

}
