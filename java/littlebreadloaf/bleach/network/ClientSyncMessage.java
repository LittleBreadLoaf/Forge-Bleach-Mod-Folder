package littlebreadloaf.bleach.network;

import io.netty.buffer.ByteBuf;
import littlebreadloaf.bleach.BleachMod;
import littlebreadloaf.bleach.events.ExtendedPlayer;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;

public class ClientSyncMessage implements IMessage
{
	private NBTTagCompound data;
	public ClientSyncMessage(){}
	
	
	public ClientSyncMessage(EntityPlayer player)
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
	public static class Handler implements IMessageHandler<ClientSyncMessage, IMessage>
	{

		@Override 
		public IMessage onMessage(ClientSyncMessage message, MessageContext ctx)
		{

		    EntityPlayer player = BleachMod.proxy.getPlayerFromMessage(ctx);
		            ExtendedPlayer props = ExtendedPlayer.get(player);
		            if(player != null)
		            {
		                if(props != null)
		                {

		        			ExtendedPlayer.get(player).loadNBTData(message.data);
		                }
		            }
		        
			return null;
		}
	}

}
