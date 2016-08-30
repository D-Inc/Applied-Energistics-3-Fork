
package appeng.core.lib.module;


import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInterModComms;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerAboutToStartEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppedEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppingEvent;


/**
 * Implement on AE module.
 * <br>
 * Must have no-args constructor.
 * 
 * @author elix_x
 *
 */
public interface Module
{

	void preInit( final FMLPreInitializationEvent event );

	void init( final FMLInitializationEvent event );

	void postInit( final FMLPostInitializationEvent event );

	void handleIMCEvent( final FMLInterModComms.IMCEvent event );

	void serverAboutToStart( final FMLServerAboutToStartEvent event );

	void serverStarting( final FMLServerStartingEvent event );

	void serverStopping( final FMLServerStoppingEvent event );

	void serverStopped( final FMLServerStoppedEvent event );
}
