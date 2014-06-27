package littlebreadloaf.bleach.events;

import net.minecraft.entity.player.EntityPlayer;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

public abstract class BleachAbstractPacket 
{
	
	
	public abstract void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer);
	
	public abstract void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer);
	
	public abstract void handleClientSide(EntityPlayer player);
	
	public abstract void handleServerSide(EntityPlayer player);

}
