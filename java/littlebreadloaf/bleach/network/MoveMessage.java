package littlebreadloaf.bleach.network;

import littlebreadloaf.bleach.BleachMod;
import littlebreadloaf.bleach.events.ExtendedPlayer;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MoveMessage implements IMessage
{
	private int distance;

	public MoveMessage(){}
	
	
	public MoveMessage(int distance)
	{
		this.distance = distance;
		
	}
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{

		distance = buf.readInt();
		
	}

	
	@Override
	public void toBytes(ByteBuf buf) 
	{

		buf.writeInt(distance);
		
	}
	public static class Handler implements IMessageHandler<MoveMessage, IMessage>
	{

		@Override 
		public IMessage onMessage(MoveMessage message, MessageContext ctx)
		{
			EntityPlayer player = BleachMod.proxy.getPlayerFromMessage(ctx);
			
	        
				player.moveEntity(message.distance*Math.cos(-player.rotationPitch * (Math.PI / 180F))*Math.sin(-player.rotationYaw * (Math.PI / 180F)), message.distance*Math.sin(-player.rotationPitch * (Math.PI / 180F)), message.distance*Math.cos(-player.rotationPitch * (Math.PI / 180F))*Math.cos(-player.rotationYaw * (Math.PI / 180F)));
			
			
			return null;
		}
	}

}
