
package appeng.core.me;


import java.io.File;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInterModComms.IMCEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerAboutToStartEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppedEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppingEvent;

import appeng.core.AppEng;
import appeng.core.lib.AEConfig;
import appeng.core.lib.FacadeConfig;
import appeng.core.lib.features.AEFeature;
import appeng.core.lib.module.AEModule;
import appeng.core.lib.module.AEModule.ModuleEventHandler;


@AEModule( "me" )
public class AppEngME
{

	@ModuleEventHandler
	public void preInit( FMLPreInitializationEvent event )
	{
		FacadeConfig.instance = new FacadeConfig( new File( AppEng.instance().getConfigDirectory(), "Facades.cfg" ) );
		if( AEConfig.instance.isFeatureEnabled( AEFeature.Facades ) )
		{
			CreativeTabFacade.init();
		}
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
