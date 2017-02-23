
package appeng.core.me;


import java.io.File;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerAboutToStartEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppedEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppingEvent;
import net.minecraftforge.fml.common.registry.FMLControlledNamespacedRegistry;
import net.minecraftforge.fml.common.registry.RegistryBuilder;

import appeng.api.definitions.IDefinition;
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
import appeng.core.me.api.part.PartRegistryEntry;
import appeng.core.me.definitions.MEBlockDefinitions;
import appeng.core.me.definitions.MEItemDefinitions;
import appeng.core.me.definitions.METileDefinitions;


@Module( IME.NAME )
public class AppEngME implements IME
{

	@Module.Instance( NAME )
	public static final AppEngME INSTANCE = null;

	private FMLControlledNamespacedRegistry<PartRegistryEntry<?>> partRegistry;

	private FeatureFactory registry;

	private MEItemDefinitions itemDefinitions;
	private MEBlockDefinitions blockDefinitions;
	private METileDefinitions tileDefinitions;

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

	public FMLControlledNamespacedRegistry<PartRegistryEntry<?>> getPartRegistry()
	{
		return partRegistry;
	}

	@ModuleEventHandler
	public void preInit( FMLPreInitializationEvent event )
	{
		partRegistry = (FMLControlledNamespacedRegistry<PartRegistryEntry<?>>) new RegistryBuilder().setName( new ResourceLocation( AppEng.MODID, "parts" ) ).setType( PartRegistryEntry.class ).create();

		registry = new FeatureFactory();
		this.blockDefinitions = new MEBlockDefinitions( registry );
		this.itemDefinitions = new MEItemDefinitions( registry );
		this.tileDefinitions = new METileDefinitions( registry );
		registry.preInit( event );

		FacadeConfig.instance = new FacadeConfig( new File( AppEng.instance().getConfigDirectory(), "Facades.cfg" ) );
		if( AEConfig.instance.isFeatureEnabled( AEFeature.Facades ) )
		{
			CreativeTabFacade.init();
		}
	}

	@ModuleEventHandler
	public void init( FMLInitializationEvent event )
	{
		registry.init( event );
	}

	@ModuleEventHandler
	public void postInit( FMLPostInitializationEvent event )
	{
		registry.postInit( event );
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
