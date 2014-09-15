package littlebreadloaf.bleach.network;

import littlebreadloaf.bleach.BleachMod;
import littlebreadloaf.bleach.events.ExtendedPlayer;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class ServerSyncMessage implements IMessage
{
	private NBTTagCompound data;

	public ServerSyncMessage(){}
	
	
	public ServerSyncMessage(EntityPlayer player)
	{
		this.data = new NBTTagCompound();
		ExtendedPlayer.get(player).saveNBTData(data);
		
	}
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{

		data = ByteBufUtils.readTag(buf);
		
	}

	
	@Override
	public void toBytes(ByteBuf buf) 
	{

		ByteBufUtils.writeTag(buf, data);
		
	}
	public static class Handler implements IMessageHandler<ServerSyncMessage, IMessage>
	{

		@Override 
		public IMessage onMessage(ServerSyncMessage message, MessageContext ctx)
		{
			EntityPlayer player = BleachMod.proxy.getPlayerFromMessage(ctx);
			ExtendedPlayer props = ExtendedPlayer.get(BleachMod.proxy.getPlayerFromMessage(ctx));
			props.loadNBTData(message.data);
			
			return null;
		}
	}

}
