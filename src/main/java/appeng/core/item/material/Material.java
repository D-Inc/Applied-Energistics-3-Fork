
package appeng.core.item.material;


import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.FMLControlledNamespacedRegistry;
import net.minecraftforge.fml.common.registry.IForgeRegistryEntry;
import net.minecraftforge.fml.common.registry.RegistryBuilder;

import appeng.core.AppEng;
import appeng.core.lib.item.IStateItem;


public class Material extends IForgeRegistryEntry.Impl<Material>
{

	public static final FMLControlledNamespacedRegistry<Material> REGISTRY = (FMLControlledNamespacedRegistry<Material>) new RegistryBuilder().setName( new ResourceLocation( AppEng.MODID, "material" ) ).setType( Material.class ).setIDRange( 0, Short.MAX_VALUE ).create();
	
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

}
