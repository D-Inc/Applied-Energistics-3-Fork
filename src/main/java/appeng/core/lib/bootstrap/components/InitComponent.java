package appeng.core.lib.bootstrap.components;


import net.minecraftforge.fml.relauncher.Side;

import appeng.core.lib.bootstrap.IBootstrapComponent;


@FunctionalInterface
public interface InitComponent extends IBootstrapComponent
{

	@Override
	void initialize( Side side );

}
