
package appeng.tools.definitions;


import net.minecraft.item.Item;

import appeng.api.definitions.IItemDefinition;
import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.definitions.Definitions;
import appeng.core.lib.features.AEFeature;
import appeng.core.me.item.ItemCreativeStorageCell;
import appeng.core.me.item.ItemViewCell;
import appeng.core.me.item.ToolWirelessTerminal;
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
import appeng.tools.item.ToolQuartzCuttingKnife;
import appeng.tools.item.ToolQuartzHoe;
import appeng.tools.item.ToolQuartzPickaxe;
import appeng.tools.item.ToolQuartzSpade;
import appeng.tools.item.ToolQuartzSword;
import appeng.tools.item.ToolQuartzWrench;


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
		this.certusQuartzAxe = certusTools.item( "certus_quartz_axe", new ToolQuartzAxe( AEFeature.CertusQuartzTools ) ).addFeatures( AEFeature.QuartzAxe ).build();
		this.certusQuartzHoe = certusTools.item( "certus_quartz_hoe", new ToolQuartzHoe( AEFeature.CertusQuartzTools ) ).addFeatures( AEFeature.QuartzHoe ).build();
		this.certusQuartzShovel = certusTools.item( "certus_quartz_spade", new ToolQuartzSpade( AEFeature.CertusQuartzTools ) ).addFeatures( AEFeature.QuartzSpade ).build();
		this.certusQuartzPick = certusTools.item( "certus_quartz_pickaxe", new ToolQuartzPickaxe( AEFeature.CertusQuartzTools ) ).addFeatures( AEFeature.QuartzPickaxe ).build();
		this.certusQuartzSword = certusTools.item( "certus_quartz_sword", new ToolQuartzSword( AEFeature.CertusQuartzTools ) ).addFeatures( AEFeature.QuartzSword ).build();
		this.certusQuartzWrench = certusTools.item( "certus_quartz_wrench", new ToolQuartzWrench() ).addFeatures( AEFeature.QuartzWrench ).build();
		this.certusQuartzKnife = certusTools.item( "certus_quartz_cutting_knife", new ToolQuartzCuttingKnife( AEFeature.CertusQuartzTools ) ).addFeatures( AEFeature.QuartzKnife ).build();

		FeatureFactory netherTools = registry.features( AEFeature.NetherQuartzTools );
		this.netherQuartzAxe = netherTools.item( "nether_quartz_axe", new ToolQuartzAxe( AEFeature.NetherQuartzTools ) ).addFeatures( AEFeature.QuartzAxe ).build();
		this.netherQuartzHoe = netherTools.item( "nether_quartz_hoe", new ToolQuartzHoe( AEFeature.NetherQuartzTools ) ).addFeatures( AEFeature.QuartzHoe ).build();
		this.netherQuartzShovel = netherTools.item( "nether_quartz_spade", new ToolQuartzSpade( AEFeature.NetherQuartzTools ) ).addFeatures( AEFeature.QuartzSpade ).build();
		this.netherQuartzPick = netherTools.item( "nether_quartz_pickaxe", new ToolQuartzPickaxe( AEFeature.NetherQuartzTools ) ).addFeatures( AEFeature.QuartzPickaxe ).build();
		this.netherQuartzSword = netherTools.item( "nether_quartz_sword", new ToolQuartzSword( AEFeature.NetherQuartzTools ) ).addFeatures( AEFeature.QuartzSword ).build();
		this.netherQuartzWrench = netherTools.item( "nether_quartz_wrench", new ToolQuartzWrench() ).addFeatures( AEFeature.QuartzWrench ).build();
		this.netherQuartzKnife = netherTools.item( "nether_quartz_cutting_knife", new ToolQuartzCuttingKnife( AEFeature.NetherQuartzTools ) ).addFeatures( AEFeature.QuartzKnife ).build();
		
		FeatureFactory powerTools = registry.features( AEFeature.PoweredTools );
		this.entropyManipulator = powerTools.item( "entropy_manipulator", new ToolEntropyManipulator() ).addFeatures( AEFeature.EntropyManipulator ).build();
		this.wirelessTerminal = powerTools.item( "wireless_terminal", new ToolWirelessTerminal() ).addFeatures( AEFeature.WirelessAccessTerminal ).build();
		this.chargedStaff = powerTools.item( "charged_staff", new ToolChargedStaff() ).addFeatures( AEFeature.ChargedStaff ).build();
		this.massCannon = powerTools.item( "mass_cannon", new ToolMassCannon() ).addFeatures( AEFeature.MatterCannon ).build();
		this.portableCell = powerTools.item( "portable_cell", new ToolPortableCell() ).addFeatures( AEFeature.PortableCell, AEFeature.StorageCells ).build();

		this.biometricCard = registry.item( "biometric_card", new ToolBiometricCard() ).features( AEFeature.Security ).build();
		this.memoryCard = registry.item( "memory_card", new ToolMemoryCard() ).build();
		this.networkTool = registry.item( "network_tool", new ToolNetworkTool() ).features( AEFeature.NetworkTool ).build();
		
		this.colorApplicator = powerTools.item( "color_applicator", new ToolColorApplicator() ).addFeatures( AEFeature.ColorApplicator ).build();

		init();
	}

}
