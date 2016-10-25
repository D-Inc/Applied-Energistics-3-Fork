
package appeng.api.definitions;


import net.minecraft.util.ResourceLocation;


public interface IDefinitions<T>
{

	IDefinition<T> get( ResourceLocation identifier );

}
