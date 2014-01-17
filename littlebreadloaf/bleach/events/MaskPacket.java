package littlebreadloaf.bleach.events;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import littlebreadloaf.bleach.BleachModInfo;
import littlebreadloaf.bleach.PacketHandler;
import net.minecraft.network.packet.Packet250CustomPayload;

public class MaskPacket
{
	public static Packet250CustomPayload getPacket(int mask, int line)
	{
		ByteArrayOutputStream bos = new ByteArrayOutputStream(2);
		DataOutputStream outputStream = new DataOutputStream(bos);

		try {
			outputStream.writeInt(mask);
			outputStream.writeInt(line);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return new Packet250CustomPayload("Mask", bos.toByteArray());
	}
}