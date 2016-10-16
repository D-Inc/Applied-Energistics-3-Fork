
package appeng.decorative;


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
import appeng.api.module.Module.ModuleEventHandler;
import appeng.core.AppEng;
import appeng.core.crafting.definitions.CraftingBlockDefinitions;
import appeng.core.crafting.definitions.CraftingItemDefinitions;
import appeng.core.crafting.definitions.CraftingTileDefinitions;
import appeng.core.lib.AEConfig;
import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.decorative.api.IDecorative;


@Module( IDecorative.NAME )
@Mod( modid = AppEngDecorative.MODID, name = IDecorative.NAME, version = AEConfig.VERSION, dependencies = "required-after:" + AppEng.MOD_ID, acceptedMinecraftVersions = ForgeVersion.mcVersion )
public class AppEngDecorative implements IDecorative
{

	public static final String MODID = AppEng.MOD_ID + "|" + IDecorative.NAME;

	public static final String MODNAME = AppEng.MOD_NAME + " | " + IDecorative.NAME;

	private CraftingItemDefinitions itemDefinitions;
	private CraftingBlockDefinitions blockDefinitions;
	private CraftingTileDefinitions tileDefinitions;

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
		this.itemDefinitions = new CraftingItemDefinitions( registry );
		this.blockDefinitions = new CraftingBlockDefinitions( registry );
		this.tileDefinitions = new CraftingTileDefinitions( registry );
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
