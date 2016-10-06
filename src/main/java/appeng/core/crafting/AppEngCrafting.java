
package appeng.core.crafting;


import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInterModComms.IMCEvent;

import appeng.api.module.Module;
import appeng.api.module.Module.ModuleEventHandler;

import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerAboutToStartEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppedEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppingEvent;


@Module( AppEngCrafting.NAME )
public class AppEngCrafting
{

	public static final String NAME = "crafting";

	@ModuleEventHandler
	public void preInit( FMLPreInitializationEvent event )
	{

	}

	@ModuleEventHandler
	public void init( FMLInitializationEvent event )
	{

	}

	@ModuleEventHandler
	public void postInit( FMLPostInitializationEvent event )
	{

	}

	@ModuleEventHandler
	public void handleIMCEvent( IMCEvent event )
	{

	}

	@ModuleEventHandler
	public void serverAboutToStart( FMLServerAboutToStartEvent event )
	{

	}

	@ModuleEventHandler
	public void serverStarting( FMLServerStartingEvent event )
	{

	}

	@ModuleEventHandler
	public void serverStopping( FMLServerStoppingEvent event )
	{

	}

	@ModuleEventHandler
	public void serverStopped( FMLServerStoppedEvent event )
	{

	}

}
