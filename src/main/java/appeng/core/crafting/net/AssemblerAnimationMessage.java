
package appeng.core.crafting.net;


import io.netty.buffer.ByteBuf;

import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;


public class AssemblerAnimationMessage implements IMessage
{

	public int x;
	public int y;
	public int z;
	public int rate;

	public AssemblerAnimationMessage()
	{

	}

	public AssemblerAnimationMessage( BlockPos pos, int rate )
	{
		this.x = pos.getX();
		this.y = pos.getY();
		this.z = pos.getZ();
		this.rate = rate;
	}

	@Override
	public void fromBytes( ByteBuf buf )
	{
		x = buf.readInt();
		y = buf.readInt();
		z = buf.readInt();
		rate = buf.readInt();
	}

	@Override
	public void toBytes( ByteBuf buf )
	{
		buf.writeInt( x ).writeInt( y ).writeInt( z ).writeInt( rate );
	}

}
