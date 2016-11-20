
package appeng.tools;


import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeVersion;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInterModComms.IMCEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerAboutToStartEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppedEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppingEvent;

import appeng.api.definitions.IDefinition;
import appeng.api.definitions.IDefinitions;
import appeng.api.module.Module;
import appeng.api.module.Module.ModuleEventHandler;
import appeng.api.module.ModuleIMCMessageEvent;
import appeng.core.AppEng;
import appeng.core.lib.AEConfig;
import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.tools.api.ITools;
import appeng.tools.definitions.ToolsBlockDefinitions;
import appeng.tools.definitions.ToolsItemDefinitions;
import appeng.tools.definitions.ToolsTileDefinitions;


@Module( ITools.NAME )
@Mod( modid = AppEngTools.MODID, name = AppEngTools.MODNAME, version = AEConfig.VERSION, dependencies = "required-after:" + AppEng.MOD_ID, acceptedMinecraftVersions = ForgeVersion.mcVersion )
public class AppEngTools implements ITools
{

	public static final String MODID = AppEng.MOD_ID + "|" + ITools.NAME;

	public static final String MODNAME = AppEng.MOD_NAME + " | " + ITools.NAME;

	private ToolsItemDefinitions itemDefinitions;
	private ToolsBlockDefinitions blockDefinitions;
	private ToolsTileDefinitions tileDefinitions;

	@Override
	public <T, D extends IDefinitions<T, ? extends IDefinition<T>>> D definitions( Class<T> clas )
	{
		if( clas == Item.class )
		{
			return (D) itemDefinitions;
		}
		if( clas == Block.class )
		{
			return (D) blockDefinitions;
		}
		if( clas == TileEntity.class )
		{
			return (D) tileDefinitions;
		}
		return null;
	}

	@ModuleEventHandler
	public void preInitAE( FMLPreInitializationEvent event )
	{
		FeatureFactory registry = new FeatureFactory();
		this.blockDefinitions = new ToolsBlockDefinitions( registry );
		this.itemDefinitions = new ToolsItemDefinitions( registry );
		this.tileDefinitions = new ToolsTileDefinitions( registry );
	}

	@EventHandler
	public void preInitForge( FMLPreInitializationEvent event )
	{

	}

	@ModuleEventHandler
	public void initAE( final FMLInitializationEvent event )
	{

	}

	@EventHandler
	public void initForge( final FMLInitializationEvent event )
	{

	}

	@ModuleEventHandler
	public void postInitAE( final FMLPostInitializationEvent event )
	{

	}

	@EventHandler
	public void postInitForge( final FMLPostInitializationEvent event )
	{

	}

	@ModuleEventHandler
	public void handleIMCEventAE( ModuleIMCMessageEvent event )
	{

	}

	@EventHandler
	public void handleIMCEventForge( IMCEvent event )
	{

	}

	@ModuleEventHandler
	public void serverAboutToStartAE( FMLServerAboutToStartEvent event )
	{

	}

	@EventHandler
	public void serverAboutToStartForge( FMLServerAboutToStartEvent event )
	{

	}

	@ModuleEventHandler
	public void serverStartingAE( FMLServerStartingEvent event )
	{

	}

	@EventHandler
	public void serverStartingForge( FMLServerStartingEvent event )
	{

	}

	@ModuleEventHandler
	public void serverStoppingAE( FMLServerStoppingEvent event )
	{

	}

	@EventHandler
	public void serverStoppingForge( FMLServerStoppingEvent event )
	{

	}

	@ModuleEventHandler
	public void serverStoppedAE( FMLServerStoppedEvent event )
	{

	}

	@EventHandler
	public void serverStoppedForge( FMLServerStoppedEvent event )
	{

	}

}
