
package appeng.debug.definitions;


import appeng.core.AppEng;
import appeng.debug.*;
import net.minecraft.item.Item;

import appeng.api.definitions.IItemDefinition;
import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.definitions.Definitions;
import appeng.core.lib.features.AEFeature;
import net.minecraft.util.ResourceLocation;


public class DebugItemDefinitions extends Definitions<Item, IItemDefinition<Item>>
{

	private final IItemDefinition toolEraser;
	private final IItemDefinition toolMeteoritePlacer;
	private final IItemDefinition toolDebugCard;
	private final IItemDefinition toolReplicatorCard;
	
	public DebugItemDefinitions( FeatureFactory registry )
	{
		FeatureFactory debugTools = registry.features( AEFeature.UnsupportedDeveloperTools, AEFeature.Creative );
		this.toolEraser = debugTools.item( new ResourceLocation( AppEngDebug.MODID, "debug_eraser" ), new ToolEraser() ).build();
		this.toolMeteoritePlacer = debugTools.item( new ResourceLocation( AppEngDebug.MODID, "debug_meteorite_placer" ), new ToolMeteoritePlacer() ).build();
		this.toolDebugCard = debugTools.item( new ResourceLocation( AppEngDebug.MODID, "debug_card" ), new ToolDebugCard() ).build();
		this.toolReplicatorCard = debugTools.item( new ResourceLocation( AppEngDebug.MODID, "debug_replicator_card" ), new ToolReplicatorCard() ).build();
		
		init( registry.buildDefaultItemBlocks() );
	}

}
