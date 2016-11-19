
package appeng.miscellaneous.definitions;


import net.minecraft.block.Block;
import net.minecraft.block.BlockDispenser;

import appeng.api.definitions.IBlockDefinition;
import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.definitions.Definitions;
import appeng.core.lib.features.AEFeature;
import appeng.miscellaneous.api.definitions.IMiscellaneousBlockDefinitions;
import appeng.miscellaneous.block.BlockSkyCompass;
import appeng.miscellaneous.block.BlockTinyTNT;
import appeng.tools.hooks.DispenserBehaviorTinyTNT;


public class MiscellaneousBlockDefinitions extends Definitions<Block, IBlockDefinition<Block>> implements IMiscellaneousBlockDefinitions
{
	
	private final IBlockDefinition skyCompass;

	private final IBlockDefinition tinyTNT;

	public MiscellaneousBlockDefinitions( FeatureFactory registry )
	{
		this.skyCompass = registry.block( "sky_compass", new BlockSkyCompass() ).features( AEFeature.MeteoriteCompass ).build();

		this.tinyTNT = registry.block( "tiny_tnt", new BlockTinyTNT() ).features( AEFeature.TinyTNT ).createDefaultItemBlock().postInit( ( block ) -> {
			BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject( block.maybeItem().get().maybe().get(), new DispenserBehaviorTinyTNT() );
		} ).build();
		
		init();
	}

}
