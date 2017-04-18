
package appeng.core.me.api.definitions;


import net.minecraft.util.ResourceLocation;

import appeng.api.definitions.IDefinitions;
import appeng.core.AppEng;
import appeng.core.me.api.part.PartRegistryEntry;
import appeng.core.me.api.parts.IPart;


public interface IMEPartDefinitions<P extends IPart<P>> extends IDefinitions<PartRegistryEntry<P>, IPartDefinition<P>>
{

	default IPartDefinition<P> cableGlass()
	{
		return get( new ResourceLocation( AppEng.MODID, "cable_glass" ) );
	}

	default IPartDefinition<P> cableCovered()
	{
		return get( new ResourceLocation( AppEng.MODID, "cable_covered" ) );
	}

	default IPartDefinition<P> cableSmart()
	{
		return get( new ResourceLocation( AppEng.MODID, "cable_smart" ) );
	}

	default IPartDefinition<P> cableDense()
	{
		return get( new ResourceLocation( AppEng.MODID, "cable_dense" ) );
	}

	default IPartDefinition<P> toggleBus()
	{
		return get( new ResourceLocation( AppEng.MODID, "toggle_bus" ) );
	}

	default IPartDefinition<P> invertedToggleBus()
	{
		return get( new ResourceLocation( AppEng.MODID, "inverted_toggle_bus" ) );
	}

	default IPartDefinition<P> cableAnchor()
	{
		return get( new ResourceLocation( AppEng.MODID, "cable_anchor" ) );
	}

	default IPartDefinition<P> cableFacade()
	{
		return get( new ResourceLocation( AppEng.MODID, "cable_facade" ) );
	}

	default IPartDefinition<P> quartzFiber()
	{
		return get( new ResourceLocation( AppEng.MODID, "quartz_fiber" ) );
	}

	default IPartDefinition<P> monitor()
	{
		return get( new ResourceLocation( AppEng.MODID, "monitor" ) );
	}

	default IPartDefinition<P> semiDarkMonitor()
	{
		return get( new ResourceLocation( AppEng.MODID, "semi_dark_monitor" ) );
	}

	default IPartDefinition<P> darkMonitor()
	{
		return get( new ResourceLocation( AppEng.MODID, "dark_monitor" ) );
	}

	default IPartDefinition<P> storageBus()
	{
		return get( new ResourceLocation( AppEng.MODID, "storage_bus" ) );
	}

	default IPartDefinition<P> importBus()
	{
		return get( new ResourceLocation( AppEng.MODID, "import_bus" ) );
	}

	default IPartDefinition<P> exportBus()
	{
		return get( new ResourceLocation( AppEng.MODID, "export_bus" ) );
	}

	default IPartDefinition<P> levelEmitter()
	{
		return get( new ResourceLocation( AppEng.MODID, "level_emitter" ) );
	}

	default IPartDefinition<P> annihilationPlane()
	{
		return get( new ResourceLocation( AppEng.MODID, "annihilation_plane" ) );
	}

	default IPartDefinition<P> identityAnnihilationPlane()
	{
		return get( new ResourceLocation( AppEng.MODID, "identity_annihilation_plane" ) );
	}

	default IPartDefinition<P> formationPlane()
	{
		return get( new ResourceLocation( AppEng.MODID, "formation_plane" ) );
	}

	default IPartDefinition<P> craftingTerminal()
	{
		return get( new ResourceLocation( AppEng.MODID, "crafting_terminal" ) );
	}

	default IPartDefinition<P> terminal()
	{
		return get( new ResourceLocation( AppEng.MODID, "terminal" ) );
	}

	default IPartDefinition<P> storageMonitor()
	{
		return get( new ResourceLocation( AppEng.MODID, "storage_monitor" ) );
	}

	default IPartDefinition<P> conversionMonitor()
	{
		return get( new ResourceLocation( AppEng.MODID, "conversion_monitor" ) );
	}

	default IPartDefinition<P> iface()
	{
		return get( new ResourceLocation( AppEng.MODID, "interface" ) );
	}

	default IPartDefinition<P> interfaceTerminal()
	{
		return get( new ResourceLocation( AppEng.MODID, "interface_terminal" ) );
	}

}
