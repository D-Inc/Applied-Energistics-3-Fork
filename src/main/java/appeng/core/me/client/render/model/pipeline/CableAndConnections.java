
package appeng.core.me.client.render.model.pipeline;


import java.util.List;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.property.IExtendedBlockState;

import appeng.api.client.BakingPipeline;
import appeng.api.client.BakingPipelineElement;
import appeng.core.api.implementations.parts.IPartCable;
import appeng.core.api.util.AEPartLocation;
import appeng.core.lib.client.render.model.pipeline.TintIndexModifier;
import appeng.core.me.api.parts.IPart;
import appeng.core.me.block.BlockCableBus;
import appeng.core.me.part.CableBusContainer;


public class CableAndConnections implements BakingPipelineElement<BakedQuad, BakedQuad>
{

	private final BakingPipeline rotatingPipeline;
	private final TintIndexModifier tintIndexModifier;
	private final BakingPipeline tintIndexFixPipeline;

	public CableAndConnections( BakingPipeline rotatingPipeline, TintIndexModifier tintIndexModifier, BakingPipeline tintIndexFixPipeline )
	{
		this.rotatingPipeline = rotatingPipeline;
		this.tintIndexModifier = tintIndexModifier;
		this.tintIndexFixPipeline = tintIndexFixPipeline;
	}

	@Override
	public List<BakedQuad> pipe( List<BakedQuad> elements, IBakedModel parent, IBlockState state, EnumFacing side, long rand )
	{
		if( state != null )
		{
			CableBusContainer cableBus = ( (IExtendedBlockState) state ).getValue( BlockCableBus.cableBus );
			IPart part = cableBus.getPart( AEPartLocation.INTERNAL );
			if( part instanceof IPartCable )
			{
				tintIndexModifier.setTintTransformer( tint -> ( AEPartLocation.INTERNAL.ordinal() << 2 ) | tint );
				elements.addAll( tintIndexFixPipeline.pipe( ( (IPartCable) part ).getOrBakeQuads( rotatingPipeline, state, side, rand ), parent, state, side, rand ) );
			}
		}
		return elements;
	}

}
