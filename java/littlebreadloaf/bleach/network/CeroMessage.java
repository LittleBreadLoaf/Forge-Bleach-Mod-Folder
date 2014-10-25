package littlebreadloaf.bleach.network;

import io.netty.buffer.ByteBuf;
import littlebreadloaf.bleach.BleachMod;
import littlebreadloaf.bleach.entities.EntityCero;
import littlebreadloaf.bleach.events.ExtendedPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class CeroMessage implements IMessage
{

	public CeroMessage(){}
	
	private int id;

	
	
	public CeroMessage(int id)
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
	public static class Handler implements IMessageHandler<CeroMessage, IMessage>
	{

		@Override 
		public IMessage onMessage(CeroMessage message, MessageContext ctx)
		{
			EntityPlayer player = (EntityPlayer)(BleachMod.proxy.getPlayerFromMessage(ctx));
			ExtendedPlayer props = ExtendedPlayer.get(player);
			
			if(props.getFaction() == 4)
			{
			 
			 if( (props.getCurrentEnergy() * props.getCurrentCap()) > 50)
			 {
				 
				 EntityCero entityCero = new EntityCero(player.worldObj, player, 2.0F);
					
						player.worldObj.spawnEntityInWorld(entityCero);
						
			 }
			 }
			
			
			
			 
			return null;
		}
	}

}
