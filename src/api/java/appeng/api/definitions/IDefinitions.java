
package appeng.api.definitions;


import net.minecraft.util.ResourceLocation;


public interface IDefinitions<T, D extends IDefinition<T>>
{

	D get( ResourceLocation identifier );

	default D get( String identifier )
	{
		return get( new ResourceLocation( "appliedenergistics2", identifier ) );
	}

}
