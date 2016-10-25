
package appeng.core.lib.bootstrap;


import net.minecraft.tileentity.TileEntity;

import appeng.api.definitions.ITileDefinition;


public interface ITileBuilder<T extends TileEntity> extends IDefinitionBuilder<Class<T>, ITileDefinition<T, Class<T>>, ITileBuilder<T>>
{

}
