
package appeng.core.me.api.definitions;


import net.minecraft.util.ResourceLocation;

import appeng.api.definitions.IDefinitions;
import appeng.core.AppEng;
import appeng.core.me.api.part.PartRegistryEntry;


public interface IMEPartDefinitions extends IDefinitions<PartRegistryEntry, IPartDefinition<PartRegistryEntry>>
{

	default IPartDefinition<PartRegistryEntry> cableGlass()
	{
		return get( new ResourceLocation( AppEng.MODID, "cable_glass" ) );
	}

	default IPartDefinition<PartRegistryEntry> cableCovered()
	{
		return get( new ResourceLocation( AppEng.MODID, "cable_covered" ) );
	}

	default IPartDefinition<PartRegistryEntry> cableSmart()
	{
		return get( new ResourceLocation( AppEng.MODID, "cable_smart" ) );
	}

	default IPartDefinition<PartRegistryEntry> cableDense()
	{
		return get( new ResourceLocation( AppEng.MODID, "cable_dense" ) );
	}

	default IPartDefinition<PartRegistryEntry> toggleBus()
	{
		return get( new ResourceLocation( AppEng.MODID, "toggle_bus" ) );
	}

	default IPartDefinition<PartRegistryEntry> invertedToggleBus()
	{
		return get( new ResourceLocation( AppEng.MODID, "inverted_toggle_bus" ) );
	}

	default IPartDefinition<PartRegistryEntry> cableAnchor()
	{
		return get( new ResourceLocation( AppEng.MODID, "cable_anchor" ) );
	}

	default IPartDefinition<PartRegistryEntry> cableFacade()
	{
		return get( new ResourceLocation( AppEng.MODID, "cable_facade" ) );
	}

	default IPartDefinition<PartRegistryEntry> quartzFiber()
	{
		return get( new ResourceLocation( AppEng.MODID, "quartz_fiber" ) );
	}

	default IPartDefinition<PartRegistryEntry> monitor()
	{
		return get( new ResourceLocation( AppEng.MODID, "monitor" ) );
	}

	default IPartDefinition<PartRegistryEntry> semiDarkMonitor()
	{
		return get( new ResourceLocation( AppEng.MODID, "semi_dark_monitor" ) );
	}

	default IPartDefinition<PartRegistryEntry> darkMonitor()
	{
		return get( new ResourceLocation( AppEng.MODID, "dark_monitor" ) );
	}

	default IPartDefinition<PartRegistryEntry> storageBus()
	{
		return get( new ResourceLocation( AppEng.MODID, "storage_bus" ) );
	}

	default IPartDefinition<PartRegistryEntry> importBus()
	{
		return get( new ResourceLocation( AppEng.MODID, "import_bus" ) );
	}

	default IPartDefinition<PartRegistryEntry> exportBus()
	{
		return get( new ResourceLocation( AppEng.MODID, "export_bus" ) );
	}

	default IPartDefinition<PartRegistryEntry> levelEmitter()
	{
		return get( new ResourceLocation( AppEng.MODID, "level_emitter" ) );
	}

	default IPartDefinition<PartRegistryEntry> annihilationPlane()
	{
		return get( new ResourceLocation( AppEng.MODID, "annihilation_plane" ) );
	}

	default IPartDefinition<PartRegistryEntry> identityAnnihilationPlane()
	{
		return get( new ResourceLocation( AppEng.MODID, "identity_annihilation_plane" ) );
	}

	default IPartDefinition<PartRegistryEntry> formationPlane()
	{
		return get( new ResourceLocation( AppEng.MODID, "formation_plane" ) );
	}

	default IPartDefinition<PartRegistryEntry> craftingTerminal()
	{
		return get( new ResourceLocation( AppEng.MODID, "crafting_terminal" ) );
	}

	default IPartDefinition<PartRegistryEntry> terminal()
	{
		return get( new ResourceLocation( AppEng.MODID, "terminal" ) );
	}

	default IPartDefinition<PartRegistryEntry> storageMonitor()
	{
		return get( new ResourceLocation( AppEng.MODID, "storage_monitor" ) );
	}

	default IPartDefinition<PartRegistryEntry> conversionMonitor()
	{
		return get( new ResourceLocation( AppEng.MODID, "conversion_monitor" ) );
	}

	default IPartDefinition<PartRegistryEntry> iface()
	{
		return get( new ResourceLocation( AppEng.MODID, "interface" ) );
	}

	default IPartDefinition<PartRegistryEntry> interfaceTerminal()
	{
		return get( new ResourceLocation( AppEng.MODID, "interface_terminal" ) );
	}

}
