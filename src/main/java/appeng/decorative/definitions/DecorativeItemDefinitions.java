
package appeng.decorative.definitions;


import appeng.decorative.AppEngDecorative;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

import appeng.api.definitions.IItemDefinition;
import appeng.core.AppEng;
import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.definitions.Definitions;
import appeng.core.lib.features.AEFeature;
import appeng.core.me.CreativeTabFacade;
import appeng.decorative.api.definitions.IDecorativeItemDefinitions;
import appeng.decorative.item.ItemFacade;
import appeng.decorative.item.ItemPaintBall;
import appeng.decorative.item.ItemPaintBallRendering;


public class DecorativeItemDefinitions extends Definitions<Item, IItemDefinition<Item>> implements IDecorativeItemDefinitions
{

	private final IItemDefinition paintBall;
	private final IItemDefinition facade;

	public DecorativeItemDefinitions( FeatureFactory registry )
	{
		this.paintBall = registry.item( new ResourceLocation( AppEng.MOD_ID, "paint_ball" ), new ItemPaintBall() ).features( AEFeature.PaintBalls ).rendering( new ItemPaintBallRendering() ).build();
		
		this.facade = registry.item( new ResourceLocation( AppEngDecorative.MODID, "facade" ), new ItemFacade() ).features( AEFeature.Facades ).creativeTab( CreativeTabFacade.instance ).build();
		
		init( registry.buildDefaultItemBlocks() );
	}

}
