
package appeng.core.crafting;


import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerAboutToStartEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppedEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppingEvent;
import net.minecraftforge.fml.relauncher.Side;

import code.elix_x.excore.utils.net.packets.SmartNetworkWrapper;

import appeng.api.definitions.IDefinition;
import appeng.api.definitions.IDefinitions;
import appeng.api.module.Module;
import appeng.api.module.Module.ModuleEventHandler;
import appeng.api.module.ModuleIMCMessageEvent;
import appeng.core.AppEng;
import appeng.core.crafting.api.ICrafting;
import appeng.core.crafting.definitions.CraftingBlockDefinitions;
import appeng.core.crafting.definitions.CraftingItemDefinitions;
import appeng.core.crafting.definitions.CraftingPartDefinitions;
import appeng.core.crafting.definitions.CraftingTileDefinitions;
import appeng.core.crafting.net.AssemblerAnimationMessage;
import appeng.core.lib.CommonHelper;
import appeng.core.lib.client.EffectType;
import appeng.core.me.AppEngME;
import appeng.core.me.api.part.PartRegistryEntry;
import appeng.core.me.bootstrap.MEFeatureFactory;
import appeng.core.me.item.ItemCard;


@Module( value = ICrafting.NAME, dependencies = "after:module-" + AppEngME.NAME )
public class AppEngCrafting implements ICrafting
{

	public static final String FULLMODID = AppEng.MODID + "|" + NAME;

	@Module.Instance( NAME )
	public static final AppEngCrafting INSTANCE = null;

	public final ItemCard.EnumCardType CRAFTING = ItemCard.EnumCardType.addCardType( "CRAFTING" );

	private MEFeatureFactory registry;

	private CraftingItemDefinitions itemDefinitions;
	private CraftingBlockDefinitions blockDefinitions;
	private CraftingTileDefinitions tileDefinitions;
	private CraftingPartDefinitions partDefinitions;

	public SmartNetworkWrapper net;

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
		if( clas == PartRegistryEntry.class )
		{
			return (D) partDefinitions;
		}
		return null;
	}

	@ModuleEventHandler
	public void preInit( FMLPreInitializationEvent event )
	{
		registry = new MEFeatureFactory();
		this.blockDefinitions = new CraftingBlockDefinitions( registry );
		this.itemDefinitions = new CraftingItemDefinitions( registry );
		this.tileDefinitions = new CraftingTileDefinitions( registry );
		this.partDefinitions = new CraftingPartDefinitions<>( registry );
		registry.preInit( event );

		net = new SmartNetworkWrapper( FULLMODID );
		// Particles & proxies in general require modification, but i'm not here for it. This should be anough for now.
		net.registerMessage3( message -> () -> CommonHelper.proxy.spawnEffect( EffectType.Assembler, Minecraft.getMinecraft().world, message.x, message.y, message.z, message.rate ), AssemblerAnimationMessage.class, Side.CLIENT );
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
