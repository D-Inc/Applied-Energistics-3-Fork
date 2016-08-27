package appeng.core.worldgen.client.render;


import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import appeng.core.lib.bootstrap.BlockRenderingCustomizer;
import appeng.core.lib.bootstrap.IBlockRendering;
import appeng.core.lib.bootstrap.IItemRendering;
import appeng.core.worldgen.block.BlockSkyChest;


public class SkyChestRenderingCustomizer extends BlockRenderingCustomizer
{

	private final BlockSkyChest.SkyChestType type;

	public SkyChestRenderingCustomizer( BlockSkyChest.SkyChestType type )
	{
		this.type = type;
	}

	@SideOnly( Side.CLIENT )
	@Override
	public void customize( IBlockRendering rendering, IItemRendering itemRendering )
	{
		rendering.tesr( new SkyChestTESR() );

		// Register a custom non-tesr item model
		String modelName = getModelFromType();
		itemRendering.model( new ModelResourceLocation( "appliedenergistics2:" + modelName, "inventory" ) );
	}

	private String getModelFromType()
	{
		final String modelName;
		switch( type )
		{
			default:
			case STONE:
				modelName = "sky_chest_stone";
				break;
			case BLOCK:
				modelName = "sky_chest_block";
				break;
		}
		return modelName;
	}
}
