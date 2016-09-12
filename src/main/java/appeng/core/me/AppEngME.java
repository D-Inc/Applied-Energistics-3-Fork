
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
import appeng.core.lib.module.Module;


@AEModule( "me" )
public class AppEngME implements Module
{

	@Override
	public void preInit( FMLPreInitializationEvent event )
	{
		FacadeConfig.instance = new FacadeConfig( new File( AppEng.instance().getConfigDirectory(), "Facades.cfg" ) );
		if( AEConfig.instance.isFeatureEnabled( AEFeature.Facades ) )
		{
			CreativeTabFacade.init();
		}
	}

	@Override
	public void init( FMLInitializationEvent event )
	{

	}

	@Override
	public void postInit( FMLPostInitializationEvent event )
	{

	}

	@Override
	public void handleIMCEvent( IMCEvent event )
	{

	}

	@Override
	public void serverAboutToStart( FMLServerAboutToStartEvent event )
	{

	}

	@Override
	public void serverStarting( FMLServerStartingEvent event )
	{

	}

	@Override
	public void serverStopping( FMLServerStoppingEvent event )
	{

	}

	@Override
	public void serverStopped( FMLServerStoppedEvent event )
	{

	}

}
