
package appeng.core.worldgen.definitions;


import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import appeng.api.definitions.IBlockDefinition;
import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.definitions.Definitions;
import appeng.core.lib.features.AEFeature;
import appeng.core.worldgen.api.definitions.IWorldGenBlockDefinitions;
import appeng.core.worldgen.block.BlockChargedQuartzOre;
import appeng.core.worldgen.block.BlockQuartzOre;
import appeng.core.worldgen.block.BlockSkyChest;
import appeng.core.worldgen.block.BlockSkyChest.SkyChestType;
import appeng.core.worldgen.client.render.SkyChestRenderingCustomizer;


public class WorldGenBlockDefinitions extends Definitions<Block, IBlockDefinition<Block>> implements IWorldGenBlockDefinitions
{

	private final IBlockDefinition quartzOre;
	private final IBlockDefinition quartzOreCharged;
	private final IBlockDefinition skyStoneChest;
	private final IBlockDefinition smoothSkyStoneChest;
	
	public WorldGenBlockDefinitions( FeatureFactory registry )
	{
		this.quartzOre = registry.block( "quartz_ore", new BlockQuartzOre() ).createDefaultItemBlock().postInit( ( block ) -> {
			OreDictionary.registerOre( "oreCertusQuartz", new ItemStack( block.maybe().get() ) );
		} ).build();
		this.quartzOreCharged = registry.block( "charged_quartz_ore", new BlockChargedQuartzOre() ).createDefaultItemBlock().postInit( ( block ) -> {
			OreDictionary.registerOre( "oreCertusQuartz", new ItemStack( block.maybe().get() ) );
		} ).build();
		
		this.skyStoneChest = registry.block( "skystone_chest", new BlockSkyChest( SkyChestType.STONE ) ).features( AEFeature.SkyStoneChests ).rendering( new SkyChestRenderingCustomizer( SkyChestType.STONE ) ).createDefaultItemBlock().build();
		this.smoothSkyStoneChest = registry.block( "smooth_skystone_chest", new BlockSkyChest( SkyChestType.BLOCK ) ).features( AEFeature.SkyStoneChests ).rendering( new SkyChestRenderingCustomizer( SkyChestType.BLOCK ) ).createDefaultItemBlock().build();
		
		init();
	}

}
