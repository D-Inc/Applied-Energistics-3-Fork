
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

import appeng.api.definitions.IDefinitions;
import appeng.api.module.Module;
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
	public <T, D extends IDefinitions<T>> D definitions( Class<T> clas )
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

	@EventHandler
	public void preInit( FMLPreInitializationEvent event )
	{
		FeatureFactory registry = new FeatureFactory();
		this.itemDefinitions = new ToolsItemDefinitions( registry );
		this.blockDefinitions = new ToolsBlockDefinitions( registry );
		this.tileDefinitions = new ToolsTileDefinitions( registry );
	}

	@EventHandler
	public void init( final FMLInitializationEvent event )
	{

	}

	@EventHandler
	public void postInit( final FMLPostInitializationEvent event )
	{

	}

	@EventHandler
	public void handleIMCEvent( IMCEvent event )
	{

	}

	@EventHandler
	public void serverAboutToStart( FMLServerAboutToStartEvent event )
	{

	}

	@EventHandler
	public void serverStarting( FMLServerStartingEvent event )
	{

	}

	@EventHandler
	public void serverStopping( FMLServerStoppingEvent event )
	{

	}

	@EventHandler
	public void serverStopped( FMLServerStoppedEvent event )
	{

	}

}
