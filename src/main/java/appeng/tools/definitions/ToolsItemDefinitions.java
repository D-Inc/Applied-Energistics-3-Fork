
package appeng.tools.definitions;


import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

import appeng.api.definitions.IItemDefinition;
import appeng.core.item.ToolQuartzCuttingKnife;
import appeng.core.item.ToolQuartzWrench;
import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.definitions.Definitions;
import appeng.core.lib.features.AEFeature;
import appeng.core.me.item.ToolWirelessTerminal;
import appeng.tools.AppEngTools;
import appeng.tools.api.definitions.IToolsItemDefinitions;
import appeng.tools.item.ToolBiometricCard;
import appeng.tools.item.ToolChargedStaff;
import appeng.tools.item.ToolColorApplicator;
import appeng.tools.item.ToolEntropyManipulator;
import appeng.tools.item.ToolMassCannon;
import appeng.tools.item.ToolMemoryCard;
import appeng.tools.item.ToolNetworkTool;
import appeng.tools.item.ToolPortableCell;
import appeng.tools.item.ToolQuartzAxe;
import appeng.tools.item.ToolQuartzHoe;
import appeng.tools.item.ToolQuartzPickaxe;
import appeng.tools.item.ToolQuartzSpade;
import appeng.tools.item.ToolQuartzSword;


public class ToolsItemDefinitions extends Definitions<Item, IItemDefinition<Item>> implements IToolsItemDefinitions
{

	private final IItemDefinition certusQuartzAxe;
	private final IItemDefinition certusQuartzHoe;
	private final IItemDefinition certusQuartzShovel;
	private final IItemDefinition certusQuartzPick;
	private final IItemDefinition certusQuartzSword;
	private final IItemDefinition certusQuartzWrench;
	private final IItemDefinition certusQuartzKnife;

	private final IItemDefinition netherQuartzAxe;
	private final IItemDefinition netherQuartzHoe;
	private final IItemDefinition netherQuartzShovel;
	private final IItemDefinition netherQuartzPick;
	private final IItemDefinition netherQuartzSword;
	private final IItemDefinition netherQuartzWrench;
	private final IItemDefinition netherQuartzKnife;
	
	private final IItemDefinition entropyManipulator;
	private final IItemDefinition wirelessTerminal;
	private final IItemDefinition biometricCard;
	private final IItemDefinition chargedStaff;
	private final IItemDefinition massCannon;
	private final IItemDefinition memoryCard;
	private final IItemDefinition networkTool;
	private final IItemDefinition portableCell;
	
	private final IItemDefinition colorApplicator;

	public ToolsItemDefinitions( FeatureFactory registry )
	{
		FeatureFactory certusTools = registry.features( AEFeature.CertusQuartzTools );
		this.certusQuartzAxe = certusTools.item( new ResourceLocation( AppEngTools.MODID, "certus_quartz_axe" ), new ToolQuartzAxe( AEFeature.CertusQuartzTools ) ).addFeatures( AEFeature.QuartzAxe ).build();
		this.certusQuartzHoe = certusTools.item( new ResourceLocation( AppEngTools.MODID, "certus_quartz_hoe" ), new ToolQuartzHoe( AEFeature.CertusQuartzTools ) ).addFeatures( AEFeature.QuartzHoe ).build();
		this.certusQuartzShovel = certusTools.item( new ResourceLocation( AppEngTools.MODID, "certus_quartz_spade" ), new ToolQuartzSpade( AEFeature.CertusQuartzTools ) ).addFeatures( AEFeature.QuartzSpade ).build();
		this.certusQuartzPick = certusTools.item( new ResourceLocation( AppEngTools.MODID, "certus_quartz_pickaxe" ), new ToolQuartzPickaxe( AEFeature.CertusQuartzTools ) ).addFeatures( AEFeature.QuartzPickaxe ).build();
		this.certusQuartzSword = certusTools.item( new ResourceLocation( AppEngTools.MODID, "certus_quartz_sword" ), new ToolQuartzSword( AEFeature.CertusQuartzTools ) ).addFeatures( AEFeature.QuartzSword ).build();
		this.certusQuartzWrench = certusTools.item( new ResourceLocation( AppEngTools.MODID, "certus_quartz_wrench" ), new ToolQuartzWrench() ).addFeatures( AEFeature.QuartzWrench ).build();
		this.certusQuartzKnife = certusTools.item( new ResourceLocation( AppEngTools.MODID, "certus_quartz_cutting_knife" ), new ToolQuartzCuttingKnife( AEFeature.CertusQuartzTools ) ).addFeatures( AEFeature.QuartzKnife ).build();

		FeatureFactory netherTools = registry.features( AEFeature.NetherQuartzTools );
		this.netherQuartzAxe = netherTools.item( new ResourceLocation( AppEngTools.MODID, "nether_quartz_axe" ), new ToolQuartzAxe( AEFeature.NetherQuartzTools ) ).addFeatures( AEFeature.QuartzAxe ).build();
		this.netherQuartzHoe = netherTools.item( new ResourceLocation( AppEngTools.MODID, "nether_quartz_hoe" ), new ToolQuartzHoe( AEFeature.NetherQuartzTools ) ).addFeatures( AEFeature.QuartzHoe ).build();
		this.netherQuartzShovel = netherTools.item( new ResourceLocation( AppEngTools.MODID, "nether_quartz_spade" ), new ToolQuartzSpade( AEFeature.NetherQuartzTools ) ).addFeatures( AEFeature.QuartzSpade ).build();
		this.netherQuartzPick = netherTools.item( new ResourceLocation( AppEngTools.MODID, "nether_quartz_pickaxe" ), new ToolQuartzPickaxe( AEFeature.NetherQuartzTools ) ).addFeatures( AEFeature.QuartzPickaxe ).build();
		this.netherQuartzSword = netherTools.item( new ResourceLocation( AppEngTools.MODID, "nether_quartz_sword" ), new ToolQuartzSword( AEFeature.NetherQuartzTools ) ).addFeatures( AEFeature.QuartzSword ).build();
		this.netherQuartzWrench = netherTools.item( new ResourceLocation( AppEngTools.MODID, "nether_quartz_wrench" ), new ToolQuartzWrench() ).addFeatures( AEFeature.QuartzWrench ).build();
		this.netherQuartzKnife = netherTools.item( new ResourceLocation( AppEngTools.MODID, "nether_quartz_cutting_knife" ), new ToolQuartzCuttingKnife( AEFeature.NetherQuartzTools ) ).addFeatures( AEFeature.QuartzKnife ).build();
		
		FeatureFactory powerTools = registry.features( AEFeature.PoweredTools );
		this.entropyManipulator = powerTools.item( new ResourceLocation( AppEngTools.MODID, "entropy_manipulator" ), new ToolEntropyManipulator() ).addFeatures( AEFeature.EntropyManipulator ).build();
		this.wirelessTerminal = powerTools.item( new ResourceLocation( AppEngTools.MODID, "wireless_terminal" ), new ToolWirelessTerminal() ).addFeatures( AEFeature.WirelessAccessTerminal ).build();
		this.chargedStaff = powerTools.item( new ResourceLocation( AppEngTools.MODID, "charged_staff" ), new ToolChargedStaff() ).addFeatures( AEFeature.ChargedStaff ).build();
		this.massCannon = powerTools.item( new ResourceLocation( AppEngTools.MODID, "mass_cannon" ), new ToolMassCannon() ).addFeatures( AEFeature.MatterCannon ).build();
		this.portableCell = powerTools.item( new ResourceLocation( AppEngTools.MODID, "portable_cell" ), new ToolPortableCell() ).addFeatures( AEFeature.PortableCell, AEFeature.StorageCells ).build();

		this.biometricCard = registry.item( new ResourceLocation( AppEngTools.MODID, "biometric_card" ), new ToolBiometricCard() ).features( AEFeature.Security ).build();
		this.memoryCard = registry.item( new ResourceLocation( AppEngTools.MODID, "memory_card" ), new ToolMemoryCard() ).build();
		this.networkTool = registry.item( new ResourceLocation( AppEngTools.MODID, "network_tool" ), new ToolNetworkTool() ).features( AEFeature.NetworkTool ).build();
		
		this.colorApplicator = powerTools.item( new ResourceLocation( AppEngTools.MODID, "color_applicator" ), new ToolColorApplicator() ).addFeatures( AEFeature.ColorApplicator ).build();

		init( registry.buildDefaultItemBlocks() ); //Just in case
	}

}
