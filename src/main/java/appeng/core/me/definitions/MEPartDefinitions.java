
package appeng.core.me.definitions;


import net.minecraft.util.ResourceLocation;

import appeng.core.AppEng;
import appeng.core.lib.definitions.Definitions;
import appeng.core.lib.features.AEFeature;
import appeng.core.me.api.definitions.IMEPartDefinitions;
import appeng.core.me.api.definitions.IPartDefinition;
import appeng.core.me.api.part.PartRegistryEntry;
import appeng.core.me.api.parts.IPart;
import appeng.core.me.bootstrap.MEFeatureFactory;
import appeng.core.me.part.FacadePart;
import appeng.core.me.part.automation.PartAnnihilationPlane;
import appeng.core.me.part.automation.PartExportBus;
import appeng.core.me.part.automation.PartFormationPlane;
import appeng.core.me.part.automation.PartIdentityAnnihilationPlane;
import appeng.core.me.part.automation.PartImportBus;
import appeng.core.me.part.automation.PartLevelEmitter;
import appeng.core.me.part.misc.PartCableAnchor;
import appeng.core.me.part.misc.PartInterface;
import appeng.core.me.part.misc.PartInvertedToggleBus;
import appeng.core.me.part.misc.PartStorageBus;
import appeng.core.me.part.misc.PartToggleBus;
import appeng.core.me.part.networking.PartCableCovered;
import appeng.core.me.part.networking.PartCableGlass;
import appeng.core.me.part.networking.PartCableSmart;
import appeng.core.me.part.networking.PartDenseCable;
import appeng.core.me.part.networking.PartQuartzFiber;
import appeng.core.me.part.reporting.PartConversionMonitor;
import appeng.core.me.part.reporting.PartCraftingTerminal;
import appeng.core.me.part.reporting.PartDarkPanel;
import appeng.core.me.part.reporting.PartInterfaceTerminal;
import appeng.core.me.part.reporting.PartPanel;
import appeng.core.me.part.reporting.PartSemiDarkPanel;
import appeng.core.me.part.reporting.PartStorageMonitor;
import appeng.core.me.part.reporting.PartTerminal;


public class MEPartDefinitions<P extends IPart<P>> extends Definitions<PartRegistryEntry<P>, IPartDefinition<P>> implements IMEPartDefinitions<P>
{

	private final IPartDefinition cableGlass;
	private final IPartDefinition cableCovered;
	private final IPartDefinition cableSmart;
	private final IPartDefinition cableDense;

	private final IPartDefinition toggleBus;
	private final IPartDefinition invertedToggleBus;

	private final IPartDefinition cableAnchor;
	private final IPartDefinition cableFacade;

	private final IPartDefinition quartzFiber;

	private final IPartDefinition monitor;
	private final IPartDefinition semiDarkMonitor;
	private final IPartDefinition darkMonitor;

	private final IPartDefinition storageBus;
	private final IPartDefinition importBus;
	private final IPartDefinition exportBus;

	private final IPartDefinition levelEmitter;

	private final IPartDefinition annihilationPlane;
	private final IPartDefinition identityAnnihilationPlane;
	private final IPartDefinition formationPlane;

	private final IPartDefinition craftingTerminal;
	private final IPartDefinition terminal;

	private final IPartDefinition storageMonitor;
	private final IPartDefinition conversionMonitor;

	private final IPartDefinition iface;
	private final IPartDefinition interfaceTerminal;

	public MEPartDefinitions( MEFeatureFactory registry )
	{
		cableGlass = registry.part( new ResourceLocation( AppEng.MODID, "cable_glass" ), new PartRegistryEntry<P>( (Class<P>) PartCableGlass.class ) ).addFeatures( AEFeature.Core ).build();
		cableCovered = registry.part( new ResourceLocation( AppEng.MODID, "cable_covered" ), new PartRegistryEntry<P>( (Class<P>) PartCableCovered.class ) ).addFeatures( AEFeature.Core ).build();
		cableSmart = registry.part( new ResourceLocation( AppEng.MODID, "cable_smart" ), new PartRegistryEntry<P>( (Class<P>) PartCableSmart.class ) ).addFeatures( AEFeature.Channels ).build();
		cableDense = registry.part( new ResourceLocation( AppEng.MODID, "cable_dense" ), new PartRegistryEntry<P>( (Class<P>) PartDenseCable.class ) ).addFeatures( AEFeature.Channels ).build();

		toggleBus = registry.part( new ResourceLocation( AppEng.MODID, "toggle_bus" ), new PartRegistryEntry<P>( (Class<P>) PartToggleBus.class ) ).addFeatures( AEFeature.Core ).build();
		invertedToggleBus = registry.part( new ResourceLocation( AppEng.MODID, "inverted_toggle_bus" ), new PartRegistryEntry<P>( (Class<P>) PartInvertedToggleBus.class ) ).addFeatures( AEFeature.Core ).build();

		cableAnchor = registry.part( new ResourceLocation( AppEng.MODID, "cable_anchor" ), new PartRegistryEntry<P>( (Class<P>) PartCableAnchor.class ) ).addFeatures( AEFeature.Core ).build();
		cableFacade = registry.part( new ResourceLocation( AppEng.MODID, "cable_facade" ), new PartRegistryEntry<P>( (Class<P>) FacadePart.class ) ).addFeatures( AEFeature.Core ).build();

		quartzFiber = registry.part( new ResourceLocation( AppEng.MODID, "quartz_fiber" ), new PartRegistryEntry<P>( (Class<P>) PartQuartzFiber.class ) ).addFeatures( AEFeature.Core ).build();

		monitor = registry.part( new ResourceLocation( AppEng.MODID, "monitor" ), new PartRegistryEntry<P>( (Class<P>) PartPanel.class ) ).addFeatures( AEFeature.Core ).build();
		semiDarkMonitor = registry.part( new ResourceLocation( AppEng.MODID, "semi_dark_monitor" ), new PartRegistryEntry<P>( (Class<P>) PartSemiDarkPanel.class ) ).addFeatures( AEFeature.Core ).build();
		darkMonitor = registry.part( new ResourceLocation( AppEng.MODID, "dark_monitor" ), new PartRegistryEntry<P>( (Class<P>) PartDarkPanel.class ) ).addFeatures( AEFeature.Core ).build();

		storageBus = registry.part( new ResourceLocation( AppEng.MODID, "storage_bus" ), new PartRegistryEntry<P>( (Class<P>) PartStorageBus.class ) ).addFeatures( AEFeature.StorageBus ).build();
		importBus = registry.part( new ResourceLocation( AppEng.MODID, "import_bus" ), new PartRegistryEntry<P>( (Class<P>) PartImportBus.class ) ).addFeatures( AEFeature.ImportBus ).build();
		exportBus = registry.part( new ResourceLocation( AppEng.MODID, "export_bus" ), new PartRegistryEntry<P>( (Class<P>) PartExportBus.class ) ).addFeatures( AEFeature.ExportBus ).build();

		levelEmitter = registry.part( new ResourceLocation( AppEng.MODID, "level_emitter" ), new PartRegistryEntry<P>( (Class<P>) PartLevelEmitter.class ) ).addFeatures( AEFeature.LevelEmitter ).build();

		annihilationPlane = registry.part( new ResourceLocation( AppEng.MODID, "annihilation_plane" ), new PartRegistryEntry<P>( (Class<P>) PartAnnihilationPlane.class ) ).addFeatures( AEFeature.AnnihilationPlane ).build();
		identityAnnihilationPlane = registry.part( new ResourceLocation( AppEng.MODID, "identity_annihilation_plane" ), new PartRegistryEntry<P>( (Class<P>) PartIdentityAnnihilationPlane.class ) ).addFeatures( AEFeature.AnnihilationPlane, AEFeature.IdentityAnnihilationPlane ).build();
		formationPlane = registry.part( new ResourceLocation( AppEng.MODID, "formation_plane" ), new PartRegistryEntry<P>( (Class<P>) PartFormationPlane.class ) ).addFeatures( AEFeature.FormationPlane ).build();

		craftingTerminal = registry.part( new ResourceLocation( AppEng.MODID, "crafting_terminal" ), new PartRegistryEntry<P>( (Class<P>) PartCraftingTerminal.class ) ).addFeatures( AEFeature.CraftingTerminal ).build();
		terminal = registry.part( new ResourceLocation( AppEng.MODID, "terminal" ), new PartRegistryEntry<P>( (Class<P>) PartTerminal.class ) ).addFeatures( AEFeature.Core ).build();

		storageMonitor = registry.part( new ResourceLocation( AppEng.MODID, "storage_monitor" ), new PartRegistryEntry<P>( (Class<P>) PartStorageMonitor.class ) ).addFeatures( AEFeature.StorageMonitor ).build();
		conversionMonitor = registry.part( new ResourceLocation( AppEng.MODID, "conversion_monitor" ), new PartRegistryEntry<P>( (Class<P>) PartConversionMonitor.class ) ).addFeatures( AEFeature.PartConversionMonitor ).build();

		iface = registry.part( new ResourceLocation( AppEng.MODID, "interface" ), new PartRegistryEntry<P>( (Class<P>) PartInterface.class ) ).addFeatures( AEFeature.Core ).build();
		interfaceTerminal = registry.part( new ResourceLocation( AppEng.MODID, "interface_terminal" ), new PartRegistryEntry<P>( (Class<P>) PartInterfaceTerminal.class ) ).addFeatures( AEFeature.InterfaceTerminal ).build();

		init();
	}

}
