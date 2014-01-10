package littlebreadloaf.items;

import littlebreadloaf.libraries.BleachModInfo;
import net.minecraft.item.ItemRecord;

public class ItemBleachRecord extends ItemRecord
{

	public ItemBleachRecord(int id, String discName) 
	{
		super(id, discName);
		this.setCreativeTab(Items.tabBleach);
		this.maxStackSize = 1;
	}

	@Override
    public String getRecordTitle()
    {
<<<<<<< HEAD
		if (this.recordName == BleachModInfo.ID.toLowerCase() + ":asterisk") return "Asterisk";
=======
		if (this.recordName == BleachModInfo.ID.toLowerCase() + ":asteriks") return "Asterisk";
>>>>>>> aad03cfe38d86e5d8f23e595b6d9766bb997cfd4
		else if (this.recordName == BleachModInfo.ID.toLowerCase() + ":NumberOne") return "Number One";
		else if (this.recordName == BleachModInfo.ID.toLowerCase() + ":Escalon") return "Escalon";
            return this.recordName;
    }
}
