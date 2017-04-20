
package appeng.core.me.api.part;


import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.IForgeRegistryEntry;

import code.elix_x.excomms.reflection.ReflectionHelper.AClass;
import code.elix_x.excomms.reflection.ReflectionHelper.AConstructor;

import appeng.core.me.api.parts.IPart;


/**
 * {@linkplain IPart} class wrapper to support forge registries. This is what you use to register parts (with {@link GameRegistry#register(IForgeRegistryEntry)}.
 * <br>
 * <br>
 * Your {@linkplain IPart} implementation <b>must</b> have no-args public constructor or otherwise and exception will be thrown <b>whenever you will try to instantiate {@linkplain PartRegistryEntry}</b>.
 * 
 * @author Elix_x
 *
 * @param <P> Part type
 */
public final class PartRegistryEntry<P extends IPart<P>> extends IForgeRegistryEntry.Impl<PartRegistryEntry<P>>
{

	private final Class<P> partClass;
	private final AConstructor<P> constructor;

	/**
	 * Creates new part registry entry, wrapping given part class.
	 * 
	 * @param partClass The class of the part
	 */
	public PartRegistryEntry( Class<P> partClass )
	{
		this.partClass = partClass;
		this.constructor = new AClass<P>( this.partClass ).getDeclaredConstructor();
		try
		{
			createNewInstance();
		}
		catch( Exception e )
		{
			throw new IllegalArgumentException( String.format( "Supplied part class (%s) cannot be instantiated", partClass.getName() ), e );
		}
	}

	public Class<P> getPartClass()
	{
		return partClass;
	}

	public P createNewInstance()
	{
		return constructor.newInstance();
	}

}
