package littlebreadloaf.bleach;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

import littlebreadloaf.bleach.armor.Armor;
import littlebreadloaf.bleach.events.ExtendedPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

public class PacketHandler implements IPacketHandler
{
	public PacketHandler(){}

	@Override
	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player) 
	{
		if(packet.channel.equals(BleachModInfo.CHANNEL))
		{
			handleExtendedProperties(packet, player);
		}
		
		else if(packet.channel.equals("Deactivate"))
		{
			handleDeactivating(packet, player);
		}
		else if(packet.channel.equals("Mask"))
		{
			handleMask(packet, player);
		}
		
		else if(packet.channel.equals("Flash"))
		{
			handleFlashPacket(packet, player);
		}
		
		
		
		
	}
	





	private void handleFlashPacket(Packet250CustomPayload packet, Player player) 
	{
		DataInputStream inputStream = new DataInputStream(new ByteArrayInputStream(packet.data));

		ExtendedPlayer props = ((ExtendedPlayer)((EntityPlayer) player).getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME));
		
		try
		{
			props.decideWhatToDo(inputStream.readByte());
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
	}

	private void handleMask(Packet250CustomPayload packet, Player player) 
	{
		DataInputStream inputStream = new DataInputStream(new ByteArrayInputStream(packet.data));

		EntityPlayer thePlayer = (EntityPlayer)player;
        ExtendedPlayer props = (ExtendedPlayer) thePlayer.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);
		try 
		{
			
			props.putOnMask(inputStream.readInt(), inputStream.readInt());
			
		} catch (IOException e){
			e.printStackTrace();
		}
		
	}

	private void handleDeactivating(Packet250CustomPayload packet, Player player) 
	{
		DataInputStream inputStream = new DataInputStream(new ByteArrayInputStream(packet.data));

		ExtendedPlayer props = ((ExtendedPlayer)((EntityPlayer) player).getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME));

		try 
		{
			props.deactivate(inputStream.readInt());
			
		} catch (IOException e){
			e.printStackTrace();
		}
		
	}

	private void handleExtendedProperties(Packet250CustomPayload packet, Player player)
	{
		DataInputStream inputStream = new DataInputStream(new ByteArrayInputStream(packet.data));

		ExtendedPlayer props = ((ExtendedPlayer)((EntityPlayer) player).getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME));
		
		try
		{
			props.setMaxCap(inputStream.readInt());
			props.setCurrentEnergy(inputStream.readFloat());
			props.setPoints(1, inputStream.readInt());
			props.setPoints(2, inputStream.readInt());
			props.setPoints(3, inputStream.readInt());
			props.setPoints(4, inputStream.readInt());
			props.setPoints(5, inputStream.readInt());
			props.setPoints(6, inputStream.readInt());
			props.setPoints(7, inputStream.readInt());
			props.setPoints(8, inputStream.readInt());
			props.setPoints(9, inputStream.readInt());
			props.setName(inputStream.readUTF());
			props.setMask(inputStream.readInt());
			props.setLines(inputStream.readInt());
			props.setMaskTimeCap(inputStream.readInt());
			props.setMaskTime(inputStream.readFloat());
			props.setMaskLevel(inputStream.readInt());
			props.setMaskColor(inputStream.readInt());
			props.setIsShinigami(inputStream.readBoolean());
			props.setValidFlash(inputStream.readBoolean());
			props.setStickTimer(inputStream.readInt());
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
	}

	

}
