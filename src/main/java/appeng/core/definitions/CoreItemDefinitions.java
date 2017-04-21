
package appeng.core.definitions;


import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

import appeng.api.definitions.IItemDefinition;
import appeng.core.AppEng;
import appeng.core.api.definitions.ICoreItemDefinitions;
import appeng.core.client.render.ItemCrystalSeedRendering;
import appeng.core.client.render.item.ItemMaterialRendering;
import appeng.core.item.ItemCrystalSeed;
import appeng.core.item.ItemMaterial;
import appeng.core.item.ToolQuartzCuttingKnife;
import appeng.core.item.ToolQuartzWrench;
import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.definitions.Definitions;
import appeng.core.lib.features.AEFeature;
import appeng.tools.AppEngTools;


public class CoreItemDefinitions extends Definitions<Item, IItemDefinition<Item>> implements ICoreItemDefinitions
{

	private final IItemDefinition material;
	
	private final IItemDefinition crystalSeed;

	private final IItemDefinition certusQuartzWrench;
	private final IItemDefinition netherQuartzWrench;

	private final IItemDefinition certusQuartzKnife;
	private final IItemDefinition netherQuartzKnife;
	
	public CoreItemDefinitions( FeatureFactory registry )
	{
		this.material = registry.item( new ResourceLocation( AppEng.MODID, "material" ), new ItemMaterial() ).rendering( new ItemMaterialRendering() ).build();
		
		this.crystalSeed = registry.item( new ResourceLocation( AppEng.MODID, "crystal_seed" ), new ItemCrystalSeed() ).rendering( new ItemCrystalSeedRendering() ).build();
		
		this.certusQuartzWrench = registry.item( new ResourceLocation( AppEngTools.MODID, "certus_quartz_wrench" ), new ToolQuartzWrench() ).addFeatures( AEFeature.QuartzWrench ).build();
		this.netherQuartzWrench = registry.item( new ResourceLocation( AppEngTools.MODID, "nether_quartz_wrench" ), new ToolQuartzWrench() ).addFeatures( AEFeature.QuartzWrench ).build();

		this.certusQuartzKnife = registry.item( new ResourceLocation( AppEngTools.MODID, "certus_quartz_cutting_knife" ), new ToolQuartzCuttingKnife( AEFeature.CertusQuartzTools ) ).addFeatures( AEFeature.QuartzKnife ).build();
		this.netherQuartzKnife = registry.item( new ResourceLocation( AppEngTools.MODID, "nether_quartz_cutting_knife" ), new ToolQuartzCuttingKnife( AEFeature.NetherQuartzTools ) ).addFeatures( AEFeature.QuartzKnife ).build();

		init( registry.buildDefaultItemBlocks() );
	}

}
