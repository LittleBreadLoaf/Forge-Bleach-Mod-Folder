package littlebreadloaf.bleach.events;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.play.client.C17PacketCustomPayload;

public class PacketDeactivate extends BleachAbstractPacket
{
	private int id;
	
	public PacketDeactivate(){}
	
	public PacketDeactivate(int id)
	{
		this.id = id;
	}

	@Override
	public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer) 
	{
		buffer.writeInt(id);
		
	}

	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer) 
	{
		id = buffer.readInt();
		
	}

	@Override
	public void handleClientSide(EntityPlayer player) 
	{
		
		
	}

	@Override
	public void handleServerSide(EntityPlayer player) 
	{
		ExtendedPlayer props = ExtendedPlayer.get(player);
		if(player.getHeldItem() != null)
		 props.deactivate(player.getHeldItem().getItem());
	}
}