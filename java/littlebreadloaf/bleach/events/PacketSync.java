package littlebreadloaf.bleach.events;

import cpw.mods.fml.common.network.ByteBufUtils;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

public class PacketSync extends BleachAbstractPacket
{
	private NBTTagCompound data;
	
	public PacketSync(){}
	public PacketSync(EntityPlayer player)
	{
		data = new NBTTagCompound();
		ExtendedPlayer.get(player).saveNBTData(data);
	}
	
	@Override
	public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer)
	{
		ByteBufUtils.writeTag(buffer, data);
	}
	
	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer)
	{
		data = ByteBufUtils.readTag(buffer);
	}
	
	@Override 
	public void handleClientSide(EntityPlayer player)
	{
		ExtendedPlayer.get(player).loadNBTData(data);
	}
	@Override
	public void handleServerSide(EntityPlayer player)
	{
		ExtendedPlayer.get(player).loadNBTData(data);
	}

}
