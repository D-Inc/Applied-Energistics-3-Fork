
package appeng.core.lib.bootstrap;


import net.minecraft.tileentity.TileEntity;

import appeng.api.definitions.ITileDefinition;
import appeng.core.lib.features.SubDefinitionsProvider;


public interface ITileBuilder<T extends TileEntity, S extends SubDefinitionsProvider<Class<T>, ?, ?, ?>, TT extends ITileBuilder<T, S, TT>> extends IDefinitionBuilder<Class<T>, ITileDefinition<T, Class<T>>, S, TT>
{

}
