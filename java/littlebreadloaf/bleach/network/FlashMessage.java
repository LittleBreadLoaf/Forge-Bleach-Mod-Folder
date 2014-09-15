package littlebreadloaf.bleach.network;

import littlebreadloaf.bleach.events.ExtendedPlayer;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class FlashMessage implements IMessage
{
	private int id;

	public FlashMessage(){}
	
	
	public FlashMessage(int id)
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
	public static class Handler implements IMessageHandler<FlashMessage, IMessage>
	{

		@Override 
		public IMessage onMessage(FlashMessage message, MessageContext ctx)
		{
			ExtendedPlayer props = ExtendedPlayer.get(ctx.getServerHandler().playerEntity);
			 props.decideWhatToDo(message.id);
			 
			return null;
		}
	}

}
