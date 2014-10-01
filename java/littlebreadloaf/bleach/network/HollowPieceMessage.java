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
			switch(message.part)
			{
			case 0:
			 	props.setHead(message.choice);
			 	break;
			case 1:
				 	props.setBack(message.choice);
				 	break;
			case 2:
				 	props.setArms(message.choice);
				 	break;
			case 3:
				 	props.setTail(message.choice);
				 	break;
			case 4:
				 	props.setLegs(message.choice);
				 	break;
			case 5:
				 	props.setHColor(message.choice);
				 	break;
			 
			}
			
			 
			return null;
		}
	}

}
