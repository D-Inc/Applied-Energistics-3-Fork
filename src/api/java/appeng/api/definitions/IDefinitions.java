
package appeng.api.definitions;


import net.minecraft.util.ResourceLocation;


public interface IDefinitions<T, D extends IDefinition<T>>
{

	<H extends T> H get( ResourceLocation identifier );

	default <H extends T> H get( String identifier )
	{
		return get( new ResourceLocation( "appliedenergistics2", identifier ) );
	}

}
