
package appeng.core.lib.definitions;


import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

import appeng.api.definitions.IBlockDefinition;
import appeng.api.definitions.IDefinitions;
import appeng.api.definitions.IItemDefinition;
import appeng.api.definitions.sub.IItemSubDefinition;
import appeng.api.item.IStateItem;
import appeng.core.AppEngCore;
import appeng.core.api.definitions.ICoreBlockDefinitions;
import appeng.core.me.AppEngME;
import appeng.core.me.api.definitions.IMEItemDefinitions;
import appeng.core.me.item.ItemSingularity;


/**
 * This class tests complie-ability of definitions type parameters to ensure ease of use internally and through API.
 * 
 * @author Elix_x
 *
 */
public class CompileableTypesDefinitionsTest
{

	public CompileableTypesDefinitionsTest()
	{
		IItemDefinition<Item> quartz = AppEngCore.INSTANCE.<Item, IDefinitions<Item, IItemDefinition<Item>>>definitions( Item.class ).get( "quartz" );
		Class<? extends TileEntity> tile = AppEngCore.INSTANCE.definitions( TileEntity.class.getClass() ).get( "grinder" ).maybe().get();
		IDefinitions<Block, IBlockDefinition<Block>> bdefs = AppEngCore.INSTANCE.definitions( Block.class );
		IBlockDefinition<Block> chargerDef = bdefs.get( "charger" );
		chargerDef = AppEngCore.INSTANCE.<Block, ICoreBlockDefinitions>definitions( Block.class ).charger();
		ItemStack entangledSingularity = AppEngME.INSTANCE.<Item, IMEItemDefinitions>definitions( Item.class ).singularity().<IStateItem.State<ItemSingularity>, ItemSingularity, IItemSubDefinition<IStateItem.State<ItemSingularity>, ItemSingularity>>maybeSubDefinition().get().withProperty( "entangled", true ).maybe().get().toItemStack( 1 );
	}

}
