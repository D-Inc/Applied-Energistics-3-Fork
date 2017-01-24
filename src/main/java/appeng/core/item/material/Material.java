
package appeng.core.item.material;


import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.FMLControlledNamespacedRegistry;
import net.minecraftforge.fml.common.registry.IForgeRegistryEntry;
import net.minecraftforge.fml.common.registry.RegistryBuilder;

import appeng.core.AppEng;


public class Material extends IForgeRegistryEntry.Impl<Material>
{

	public static final FMLControlledNamespacedRegistry<Material> REGISTRY = (FMLControlledNamespacedRegistry<Material>) new RegistryBuilder().setName( new ResourceLocation( AppEng.MODID, "material" ) ).setType( Material.class ).setIDRange( 0, Short.MAX_VALUE ).create();

}
