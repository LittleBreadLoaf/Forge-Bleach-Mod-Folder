package littlebreadloaf.bleach.network;

import littlebreadloaf.bleach.events.ExtendedPlayer;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class ActivateMessage implements IMessage
{
	private int id;

	public ActivateMessage(){}
	
	
	public ActivateMessage(int id)
	{
		this.id = id;
		
	}
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{

		id = buf.readInt();
		
	}

	
	@Override
	public void toBytes(ByteBuf buf) 
	{

		buf.writeInt(id);
		
	}
	public static class Handler implements IMessageHandler<ActivateMessage, IMessage>
	{

		@Override 
		public IMessage onMessage(ActivateMessage message, MessageContext ctx)
		{
			ExtendedPlayer props = ExtendedPlayer.get(ctx.getServerHandler().playerEntity);
			if(ctx.getServerHandler().playerEntity.getHeldItem() != null)
			 props.activate(ctx.getServerHandler().playerEntity.getHeldItem());
			return null;
		}
	}

}
