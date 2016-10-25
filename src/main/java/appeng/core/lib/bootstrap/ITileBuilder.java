
package appeng.core.lib.bootstrap;


import net.minecraft.tileentity.TileEntity;

import appeng.api.definitions.ITileDefinition;


public interface ITileBuilder extends IDefinitionBuilder<Class<? extends TileEntity>, ITileDefinition<Class<? extends TileEntity>>, ITileBuilder>
{

}
