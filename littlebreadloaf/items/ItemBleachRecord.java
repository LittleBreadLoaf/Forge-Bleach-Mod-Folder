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
		if (this.recordName == BleachModInfo.ID.toLowerCase() + ":asteriks") return "Asterisk";
		else if (this.recordName == BleachModInfo.ID.toLowerCase() + ":NumberOne") return "Number One";
		else if (this.recordName == BleachModInfo.ID.toLowerCase() + ":Escalon") return "Escalon";
            return this.recordName;
    }
}
