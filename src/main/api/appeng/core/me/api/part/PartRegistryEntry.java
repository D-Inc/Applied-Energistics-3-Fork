
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
public final class PartRegistryEntry extends IForgeRegistryEntry.Impl<PartRegistryEntry>
{

	private final Class<? extends IPart> partClass;
	private final AConstructor<? extends IPart> constructor;

	/**
	 * Creates new part registry entry, wrapping given part class.
	 * 
	 * @param partClass The class of the part
	 */
	public PartRegistryEntry( Class<? extends IPart> partClass )
	{
		this.partClass = partClass;
		this.constructor = new AClass<>( this.partClass ).getDeclaredConstructor();
		try
		{
			createNewInstance();
		}
		catch( Exception e )
		{
			throw new IllegalArgumentException( String.format( "Supplied part class (%s) cannot be instantiated", partClass.getName() ), e );
		}
	}

	public <P extends IPart<P>> Class<P> getPartClass()
	{
		return (Class<P>) partClass;
	}

	public <P extends IPart<P>> P createNewInstance()
	{
		return (P) constructor.newInstance();
	}

}
