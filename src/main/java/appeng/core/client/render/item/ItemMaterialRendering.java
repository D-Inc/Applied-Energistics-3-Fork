
package appeng.core.client.render.item;


import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import appeng.core.item.ItemMaterial;
import appeng.core.lib.bootstrap.IItemRendering;
import appeng.core.lib.bootstrap.ItemRenderingCustomizer;


public class ItemMaterialRendering extends ItemRenderingCustomizer
{

	@Override
	@SideOnly( Side.CLIENT )
	public void customize( IItemRendering rendering )
	{
		rendering.meshDefinition( itemstack -> ( (ItemMaterial) itemstack.getItem() ).getMaterial( itemstack ).getModel( itemstack ) );
	}

}
