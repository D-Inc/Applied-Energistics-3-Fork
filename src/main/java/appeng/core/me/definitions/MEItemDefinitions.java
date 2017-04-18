
package appeng.core.me.definitions;


import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

import appeng.api.definitions.IItemDefinition;
import appeng.core.AppEng;
import appeng.core.AppEngCore;
import appeng.core.api.material.Material;
import appeng.core.definitions.CoreMaterialDefinitions;
import appeng.core.lib.AppEngApi;
import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.definitions.Definitions;
import appeng.core.lib.features.AEFeature;
import appeng.core.me.AppEngME;
import appeng.core.me.api.definitions.IMEItemDefinitions;
import appeng.core.me.item.ItemBasicStorageCell;
import appeng.core.me.item.ItemCard;
import appeng.core.me.item.ItemCard.EnumCardType;
import appeng.core.me.item.ItemProcessor.ProcessorType;
import appeng.core.me.item.ItemCreativeStorageCell;
import appeng.core.me.item.ItemProcessor;
import appeng.core.me.item.ItemSingularity;
import appeng.core.me.item.ItemViewCell;
import appeng.core.me.item.ItemWirelessBooster;
import appeng.core.me.item.ToolBiometricCard;
import appeng.core.me.item.ToolMemoryCard;
import appeng.core.me.item.ToolNetworkTool;
import appeng.core.me.item.ToolPortableCell;
import appeng.core.me.item.ToolWirelessTerminal;
import appeng.tools.AppEngTools;


public class MEItemDefinitions extends Definitions<Item, IItemDefinition<Item>> implements IMEItemDefinitions
{

	private final IItemDefinition cellCreative;
	private final IItemDefinition viewCell;

	private final IItemDefinition cell1k;
	private final IItemDefinition cell4k;
	private final IItemDefinition cell16k;
	private final IItemDefinition cell64k;
	
	private final IItemDefinition wirelessTerminal;
	
	private final IItemDefinition memoryCard;
	private final IItemDefinition biometricCard;
	private final IItemDefinition networkTool;
	private final IItemDefinition portableCell;
	
	private final IItemDefinition basicCard;
	private final IItemDefinition capacityCard;
	private final IItemDefinition redstoneCard;
	
	private final IItemDefinition advancedCard;
	private final IItemDefinition fuzzyCard;
	private final IItemDefinition inverterCard;
	private final IItemDefinition accelerationCard;

	private final IItemDefinition singularity;

	private final IItemDefinition wirelessBooster;
	
	private final IItemDefinition logicProcessor;
	private final IItemDefinition calculationProcessor;
	private final IItemDefinition engineeringProcessor;

	public MEItemDefinitions( FeatureFactory registry )
	{
		this.cellCreative = registry.item( new ResourceLocation( AppEng.MODID, "creative_storage_cell" ), new ItemCreativeStorageCell() ).features( AEFeature.StorageCells, AEFeature.Creative ).build();
		this.viewCell = registry.item( new ResourceLocation( AppEng.MODID, "view_cell" ), new ItemViewCell() ).build();

		MEMaterialDefinitions materials = AppEngME.INSTANCE.definitions( Material.class );
		FeatureFactory storageCells = registry.features( AEFeature.StorageCells );
		this.cell1k = storageCells.item( new ResourceLocation( AppEng.MODID, "basic_storage_cell_1k" ), new ItemBasicStorageCell( materials.cell1kPart(), 8, 0.5, 1 ) ).build();
		this.cell4k = storageCells.item( new ResourceLocation( AppEng.MODID, "basic_storage_cell_4k" ), new ItemBasicStorageCell( materials.cell4kPart(), 32, 1, 4 ) ).build();
		this.cell16k = storageCells.item( new ResourceLocation( AppEng.MODID, "basic_storage_cell_16k" ), new ItemBasicStorageCell( materials.cell16kPart(), 128, 1.5, 16 ) ).build();
		this.cell64k = storageCells.item( new ResourceLocation( AppEng.MODID, "basic_storage_cell_64k" ), new ItemBasicStorageCell( materials.cell64kPart(), 512, 2, 64 ) ).build();

		this.wirelessTerminal = registry.item( new ResourceLocation( AppEngTools.MODID, "wireless_terminal" ), new ToolWirelessTerminal() ).addFeatures( AEFeature.WirelessAccessTerminal ).postInit( def -> AppEngApi.INSTANCE.registries().wireless().registerWirelessHandler( def.maybe().get() ) ).build();

		this.portableCell = registry.item( new ResourceLocation( AppEngTools.MODID, "portable_cell" ), new ToolPortableCell() ).addFeatures( AEFeature.PortableCell, AEFeature.StorageCells ).build();
		this.biometricCard = registry.item( new ResourceLocation( AppEngTools.MODID, "biometric_card" ), new ToolBiometricCard() ).features( AEFeature.Security ).build();
		this.memoryCard = registry.item( new ResourceLocation( AppEngTools.MODID, "memory_card" ), new ToolMemoryCard() ).build();
		this.networkTool = registry.item( new ResourceLocation( AppEngTools.MODID, "network_tool" ), new ToolNetworkTool() ).features( AEFeature.NetworkTool ).build();
		
		this.basicCard = registry.item( new ResourceLocation( AppEng.MODID, "basic_card" ), new ItemCard( EnumCardType.BASIC ) ).build();
		this.capacityCard = registry.item( new ResourceLocation( AppEng.MODID, "capacity_card" ), new ItemCard( AppEngME.INSTANCE.CAPACITY ) ).build();
		this.redstoneCard = registry.item( new ResourceLocation( AppEng.MODID, "redstone_card" ), new ItemCard( AppEngME.INSTANCE.REDSTONE ) ).build();
		
		this.advancedCard = registry.item( new ResourceLocation( AppEng.MODID, "advanced_card" ), new ItemCard( EnumCardType.ADVANCED ) ).build();
		this.fuzzyCard = registry.item( new ResourceLocation( AppEng.MODID, "fuzzy_card" ), new ItemCard( AppEngME.INSTANCE.FUZZY ) ).build();
		this.inverterCard = registry.item( new ResourceLocation( AppEng.MODID, "inverter_card" ), new ItemCard( AppEngME.INSTANCE.INVERTER ) ).build();
		this.accelerationCard = registry.item( new ResourceLocation( AppEng.MODID, "acceleration_card" ), new ItemCard( AppEngME.INSTANCE.ACCELERATION ) ).build();
		
		this.singularity = registry.item( new ResourceLocation( AppEng.MODID, "singularity" ), new ItemSingularity() ).build();
		
		this.wirelessBooster = registry.item( new ResourceLocation( AppEng.MODID, "wireless_booster" ), new ItemWirelessBooster() ).build();
		
		this.logicProcessor = registry.item( new ResourceLocation( AppEng.MODID, "logic_processor" ), new ItemProcessor( ProcessorType.LOGIC ) ).build();
		this.calculationProcessor = registry.item( new ResourceLocation( AppEng.MODID, "calculation_processor" ), new ItemProcessor( ProcessorType.CALCULATION ) ).build();
		this.engineeringProcessor = registry.item( new ResourceLocation( AppEng.MODID, "engineering_processor" ), new ItemProcessor( ProcessorType.ENGINEERING ) ).build();
		
		init( registry.buildDefaultItemBlocks() );
	}

}
