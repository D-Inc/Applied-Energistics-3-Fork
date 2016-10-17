
package appeng.core.me;


import java.io.File;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerAboutToStartEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppedEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppingEvent;

import appeng.api.definitions.IDefinitions;
import appeng.api.module.Module;
import appeng.api.module.Module.ModuleEventHandler;
import appeng.api.module.ModuleIMCMessageEvent;
import appeng.core.AppEng;
import appeng.core.lib.AEConfig;
import appeng.core.lib.FacadeConfig;
import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.features.AEFeature;
import appeng.core.me.api.IME;
import appeng.core.me.definitions.MEBlockDefinitions;
import appeng.core.me.definitions.MEItemDefinitions;
import appeng.core.me.definitions.METileDefinitions;


@Module( IME.NAME )
public class AppEngME implements IME
{

	private MEItemDefinitions itemDefinitions;
	private MEBlockDefinitions blockDefinitions;
	private METileDefinitions tileDefinitions;

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

	@ModuleEventHandler
	public void preInit( FMLPreInitializationEvent event )
	{
		FeatureFactory registry = new FeatureFactory();
		this.itemDefinitions = new MEItemDefinitions( registry );
		this.blockDefinitions = new MEBlockDefinitions( registry );
		this.tileDefinitions = new METileDefinitions( registry );

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
	public void handleIMCEvent( ModuleIMCMessageEvent event )
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
