package littlebreadloaf.events;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import littlebreadloaf.libraries.BleachModInfo;
import littlebreadloaf.libraries.PacketHandler;
import net.minecraft.network.packet.Packet250CustomPayload;

public class FlashPacket
{
	public static Packet250CustomPayload getPacket(byte key)
	{
		ByteArrayOutputStream bos = new ByteArrayOutputStream(2);
		DataOutputStream outputStream = new DataOutputStream(bos);

		try {
			outputStream.writeByte(key);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return new Packet250CustomPayload("Flash", bos.toByteArray());
	}
}