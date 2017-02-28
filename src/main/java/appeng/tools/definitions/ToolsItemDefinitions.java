
package appeng.tools.definitions;


import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

import appeng.api.definitions.IItemDefinition;
import appeng.core.item.ToolQuartzCuttingKnife;
import appeng.core.item.ToolQuartzWrench;
import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.definitions.Definitions;
import appeng.core.lib.features.AEFeature;
import appeng.core.me.item.ToolBiometricCard;
import appeng.core.me.item.ToolMemoryCard;
import appeng.core.me.item.ToolNetworkTool;
import appeng.core.me.item.ToolPortableCell;
import appeng.core.me.item.ToolWirelessTerminal;
import appeng.decorative.item.ToolColorApplicator;
import appeng.tools.AppEngTools;
import appeng.tools.api.definitions.IToolsItemDefinitions;
import appeng.tools.item.ToolChargedStaff;
import appeng.tools.item.ToolEntropyManipulator;
import appeng.tools.item.ToolMatterCannon;
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

	private final IItemDefinition netherQuartzAxe;
	private final IItemDefinition netherQuartzHoe;
	private final IItemDefinition netherQuartzShovel;
	private final IItemDefinition netherQuartzPick;
	private final IItemDefinition netherQuartzSword;
	
	private final IItemDefinition entropyManipulator;
	private final IItemDefinition chargedStaff;
	private final IItemDefinition massCannon;

	public ToolsItemDefinitions( FeatureFactory registry )
	{
		FeatureFactory certusTools = registry.features( AEFeature.CertusQuartzTools );
		this.certusQuartzAxe = certusTools.item( new ResourceLocation( AppEngTools.MODID, "certus_quartz_axe" ), new ToolQuartzAxe( AEFeature.CertusQuartzTools ) ).addFeatures( AEFeature.QuartzAxe ).build();
		this.certusQuartzHoe = certusTools.item( new ResourceLocation( AppEngTools.MODID, "certus_quartz_hoe" ), new ToolQuartzHoe( AEFeature.CertusQuartzTools ) ).addFeatures( AEFeature.QuartzHoe ).build();
		this.certusQuartzShovel = certusTools.item( new ResourceLocation( AppEngTools.MODID, "certus_quartz_spade" ), new ToolQuartzSpade( AEFeature.CertusQuartzTools ) ).addFeatures( AEFeature.QuartzSpade ).build();
		this.certusQuartzPick = certusTools.item( new ResourceLocation( AppEngTools.MODID, "certus_quartz_pickaxe" ), new ToolQuartzPickaxe( AEFeature.CertusQuartzTools ) ).addFeatures( AEFeature.QuartzPickaxe ).build();
		this.certusQuartzSword = certusTools.item( new ResourceLocation( AppEngTools.MODID, "certus_quartz_sword" ), new ToolQuartzSword( AEFeature.CertusQuartzTools ) ).addFeatures( AEFeature.QuartzSword ).build();

		FeatureFactory netherTools = registry.features( AEFeature.NetherQuartzTools );
		this.netherQuartzAxe = netherTools.item( new ResourceLocation( AppEngTools.MODID, "nether_quartz_axe" ), new ToolQuartzAxe( AEFeature.NetherQuartzTools ) ).addFeatures( AEFeature.QuartzAxe ).build();
		this.netherQuartzHoe = netherTools.item( new ResourceLocation( AppEngTools.MODID, "nether_quartz_hoe" ), new ToolQuartzHoe( AEFeature.NetherQuartzTools ) ).addFeatures( AEFeature.QuartzHoe ).build();
		this.netherQuartzShovel = netherTools.item( new ResourceLocation( AppEngTools.MODID, "nether_quartz_spade" ), new ToolQuartzSpade( AEFeature.NetherQuartzTools ) ).addFeatures( AEFeature.QuartzSpade ).build();
		this.netherQuartzPick = netherTools.item( new ResourceLocation( AppEngTools.MODID, "nether_quartz_pickaxe" ), new ToolQuartzPickaxe( AEFeature.NetherQuartzTools ) ).addFeatures( AEFeature.QuartzPickaxe ).build();
		this.netherQuartzSword = netherTools.item( new ResourceLocation( AppEngTools.MODID, "nether_quartz_sword" ), new ToolQuartzSword( AEFeature.NetherQuartzTools ) ).addFeatures( AEFeature.QuartzSword ).build();
		
		FeatureFactory powerTools = registry.features( AEFeature.PoweredTools );
		this.entropyManipulator = powerTools.item( new ResourceLocation( AppEngTools.MODID, "entropy_manipulator" ), new ToolEntropyManipulator() ).addFeatures( AEFeature.EntropyManipulator ).build();
		this.chargedStaff = powerTools.item( new ResourceLocation( AppEngTools.MODID, "charged_staff" ), new ToolChargedStaff() ).addFeatures( AEFeature.ChargedStaff ).build();
		this.massCannon = powerTools.item( new ResourceLocation( AppEngTools.MODID, "mass_cannon" ), new ToolMatterCannon() ).addFeatures( AEFeature.MatterCannon ).build();

		init( registry.buildDefaultItemBlocks() ); //Just in case
	}

}
