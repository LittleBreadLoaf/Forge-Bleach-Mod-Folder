package littlebreadloaf.bleach.network;

import littlebreadloaf.bleach.events.ExtendedPlayer;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class HollowPieceMessage implements IMessage
{
	private int part;
	private int choice;

	public HollowPieceMessage(){}
	
	
	public HollowPieceMessage(int part, int choice)
	{
		this.part = part;
		this.choice = choice;
		
	}
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{

		part = buf.readInt();
		choice = buf.readInt();
		
	}

	
	@Override
	public void toBytes(ByteBuf buf) 
	{

		buf.writeInt(part);
		buf.writeInt(choice);
		
	}
	public static class Handler implements IMessageHandler<HollowPieceMessage, IMessage>
	{

		@Override 
		public IMessage onMessage(HollowPieceMessage message, MessageContext ctx)
		{
			System.out.println(message.part);
			ExtendedPlayer props = ExtendedPlayer.get(ctx.getServerHandler().playerEntity);
			 if(message.part == 0)
			 	props.setHead(message.choice);
			 if(message.part == 1)
				 	props.setBack(message.choice);
			 if(message.part == 2)
				 	props.setArms(message.choice);
			 if(message.part == 3)
				 	props.setTail(message.choice);
			 if(message.part == 4)
				 	props.setLegs(message.choice);
			 
			
			 
			return null;
		}
	}

}
