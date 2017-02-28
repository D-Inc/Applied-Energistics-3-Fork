
package appeng.decorative.definitions;


import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import appeng.api.definitions.ITileDefinition;
import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.definitions.Definitions;
import appeng.core.lib.features.AEFeature;
import appeng.decorative.api.definitions.IDecorativeTileDefinitions;
import appeng.decorative.tile.TilePaint;
import appeng.miscellaneous.AppEngMiscellaneous;


public class DecorativeTileDefinitions extends Definitions<Class<TileEntity>, ITileDefinition<TileEntity>> implements IDecorativeTileDefinitions
{

	private final ITileDefinition paint;

	public DecorativeTileDefinitions( FeatureFactory registry )
	{
		this.paint = registry.tile( new ResourceLocation( AppEngMiscellaneous.MODID, "paint" ), TilePaint.class ).features( AEFeature.PaintBalls ).build();

		init();
	}

}
