
package appeng.core.api.material;


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

}
