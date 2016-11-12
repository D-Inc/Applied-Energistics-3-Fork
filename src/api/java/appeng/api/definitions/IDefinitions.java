
package appeng.api.definitions;


import net.minecraft.util.ResourceLocation;


public interface IDefinitions<T extends IDefinition<?>>
{

	T get( ResourceLocation identifier );

	default T get( String identifier )
	{
		return get( new ResourceLocation( "appliedenergistics2", identifier ) );
	}

}
