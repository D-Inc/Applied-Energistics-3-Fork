
package appeng.core;


import java.io.File;

import javax.annotation.Nonnull;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInterModComms.IMCEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerAboutToStartEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppedEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

import appeng.api.module.Module;
import appeng.api.module.Module.ModuleEventHandler;
import appeng.core.hooks.TickHandler;
import appeng.core.integration.IntegrationRegistry;
import appeng.core.lib.AELog;
import appeng.core.lib.crash.IntegrationCrashEnhancement;
import appeng.core.lib.sync.GuiBridge;
import appeng.core.lib.sync.network.NetworkHandler;
import appeng.core.lib.worlddata.WorldData;
import appeng.core.recipes.CustomRecipeConfig;
import appeng.core.recipes.CustomRecipeForgeConfiguration;
import appeng.core.server.AECommand;
import appeng.core.services.VersionChecker;
import appeng.core.services.export.ExportConfig;
import appeng.core.services.export.ExportProcess;
import appeng.core.services.export.ForgeExportConfig;
import appeng.core.services.version.VersionCheckerConfig;


/*
 * TODO 1.10.2-MODUSEP - Dat giant mess though. Move all stuff that belongs to specific modules into these specific modules. Yes, you can boom the API.
 */
@Module( value = AppEngCore.NAME, dependencies = "hard-before:module-*")
public class AppEngCore
{

	public static final String NAME = "core";

	@SidedProxy( clientSide = "appeng.core.client.AppEngCoreClientProxy", serverSide = "appeng.core.server.AppEngCoreServerProxy" )
	private static AppEngCoreProxy proxy;

	private final Registration registration;

	private CustomRecipeConfig customRecipeConfig;

	/**
	 * Folder for recipes
	 *
	 * used for CSV item names and the recipes
	 */
	private File recipeDirectory;

	/**
	 * determined in pre-init but used in init
	 */
	private ExportConfig exportConfig;

	public AppEngCore()
	{
		this.registration = new Registration();
	}

	@Nonnull
	public final Registration getRegistration()
	{
		return this.registration;
	}

	@ModuleEventHandler
	public void preInit( FMLPreInitializationEvent event )
	{
		this.recipeDirectory = new File( AppEng.instance().getConfigDirectory(), "recipes" );

		final File versionFile = new File( AppEng.instance().getConfigDirectory(), "VersionChecker.cfg" );
		final File recipeFile = new File( AppEng.instance().getConfigDirectory(), "CustomRecipes.cfg" );
		final Configuration recipeConfiguration = new Configuration( recipeFile );

		final VersionCheckerConfig versionCheckerConfig = new VersionCheckerConfig( versionFile );
		this.customRecipeConfig = new CustomRecipeForgeConfiguration( recipeConfiguration );
		this.exportConfig = new ForgeExportConfig( recipeConfiguration );

		CreativeTab.init();

		this.registration.preInitialize( event );

		proxy.preInit( event );

		if( versionCheckerConfig.isVersionCheckingEnabled() )
		{
			final VersionChecker versionChecker = new VersionChecker( versionCheckerConfig );
			final Thread versionCheckerThread = new Thread( versionChecker );

			this.startService( "AE2 VersionChecker", versionCheckerThread );
		}
	}

	private void startService( final String serviceName, final Thread thread )
	{
		thread.setName( serviceName );
		thread.setPriority( Thread.MIN_PRIORITY );

		AELog.info( "Starting " + serviceName );
		thread.start();
	}

	@ModuleEventHandler
	public void init( FMLInitializationEvent event )
	{
		if( this.exportConfig.isExportingItemNamesEnabled() )
		{
			final ExportProcess process = new ExportProcess( this.recipeDirectory, this.exportConfig );
			final Thread exportProcessThread = new Thread( process );

			this.startService( "AE2 CSV Export", exportProcessThread );
		}

		this.registration.initialize( event, this.recipeDirectory, this.customRecipeConfig );

		proxy.init( event );

		IntegrationRegistry.INSTANCE.init();
	}

	@ModuleEventHandler
	public void postInit( FMLPostInitializationEvent event )
	{
		this.registration.postInit( event );
		IntegrationRegistry.INSTANCE.postInit();
		FMLCommonHandler.instance().registerCrashCallable( new IntegrationCrashEnhancement() );

		proxy.postInit( event );

		NetworkRegistry.INSTANCE.registerGuiHandler( this, GuiBridge.GUI_Handler );
		NetworkHandler.instance = new NetworkHandler( "AE2" );
	}

	@ModuleEventHandler
	public void handleIMCEvent( IMCEvent event )
	{
		final IMCHandler imcHandler = new IMCHandler();

		imcHandler.handleIMCEvent( event );
	}

	@ModuleEventHandler
	public void serverAboutToStart( FMLServerAboutToStartEvent event )
	{
		WorldData.onServerAboutToStart( event.getServer() );
	}

	@ModuleEventHandler
	public void serverStarting( FMLServerStartingEvent event )
	{
		event.registerServerCommand( new AECommand( event.getServer() ) );
	}

	@ModuleEventHandler
	public void serverStopping( FMLServerStoppingEvent event )
	{
		WorldData.instance().onServerStopping();
	}

	@ModuleEventHandler
	public void serverStopped( FMLServerStoppedEvent event )
	{
		WorldData.instance().onServerStoppped();
		TickHandler.INSTANCE.shutdown();
	}

}
