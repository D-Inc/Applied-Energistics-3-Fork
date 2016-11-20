
package appeng.core.me.definitions;


import appeng.core.AppEng;
import net.minecraft.item.Item;

import appeng.api.definitions.IItemDefinition;
import appeng.core.item.MaterialType;
import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.definitions.Definitions;
import appeng.core.lib.features.AEFeature;
import appeng.core.me.api.definitions.IMEItemDefinitions;
import appeng.core.me.item.ItemBasicStorageCell;
import appeng.core.me.item.ItemCreativeStorageCell;
import appeng.core.me.item.ItemViewCell;
import net.minecraft.util.ResourceLocation;


public class MEItemDefinitions extends Definitions<Item, IItemDefinition<Item>> implements IMEItemDefinitions
{
	
	private final IItemDefinition cellCreative;
	private final IItemDefinition viewCell;

	private final IItemDefinition cell1k;
	private final IItemDefinition cell4k;
	private final IItemDefinition cell16k;
	private final IItemDefinition cell64k;



	public MEItemDefinitions( FeatureFactory registry )
	{
		this.cellCreative = registry.item( new ResourceLocation( AppEng.MODID, "creative_storage_cell" ), new ItemCreativeStorageCell() ).features( AEFeature.StorageCells, AEFeature.Creative ).build();
		this.viewCell = registry.item( new ResourceLocation( AppEng.MODID, "view_cell" ), new ItemViewCell() ).build();
		
		FeatureFactory storageCells = registry.features( AEFeature.StorageCells );
		this.cell1k = storageCells.item( new ResourceLocation( AppEng.MODID, "basic_storage_cell_1k" ), new ItemBasicStorageCell( MaterialType.Cell1kPart, 1 ) ).build();
		this.cell4k = storageCells.item( new ResourceLocation( AppEng.MODID, "basic_storage_cell_4k" ), new ItemBasicStorageCell( MaterialType.Cell4kPart, 4 ) ).build();
		this.cell16k = storageCells.item( new ResourceLocation( AppEng.MODID, "basic_storage_cell_16k" ), new ItemBasicStorageCell( MaterialType.Cell16kPart, 16 ) ).build();
		this.cell64k = storageCells.item( new ResourceLocation( AppEng.MODID, "basic_storage_cell_64k" ), new ItemBasicStorageCell( MaterialType.Cell64kPart, 64 ) ).build();
		
		init( registry.buildDefaultItemBlocks() );
	}

}
