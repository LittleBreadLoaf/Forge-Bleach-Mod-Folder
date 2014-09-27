package littlebreadloaf.bleach.network;

import littlebreadloaf.bleach.BleachMod;
import littlebreadloaf.bleach.events.ExtendedPlayer;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class GuiMessage implements IMessage
{
	private int id;

	public GuiMessage(){}
	
	
	public GuiMessage(int id)
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
	public static class Handler implements IMessageHandler<GuiMessage, IMessage>
	{

		@Override 
		public IMessage onMessage(GuiMessage message, MessageContext ctx)
		{

			EntityPlayer player = BleachMod.proxy.getPlayerFromMessage(ctx);
			ExtendedPlayer props = ExtendedPlayer.get(player);
			
	    		FMLNetworkHandler.openGui(player, BleachMod.instance, message.id, player.worldObj, (int)player.posX, (int)player.posY, (int)player.posZ);

			
			
			return null;
		}
	}

}
