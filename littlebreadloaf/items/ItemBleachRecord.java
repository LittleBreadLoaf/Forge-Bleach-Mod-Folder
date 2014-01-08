package littlebreadloaf.items;

import littlebreadloaf.libraries.BleachModInfo;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemBleachRecord extends ItemRecord
{

	public ItemBleachRecord(int id, String discName) 
	{
		super(id, discName);
		this.setCreativeTab(Items.tabBleach);
		this.maxStackSize = 1;
	}

	
	@Override 
	public boolean onItemUse(ItemStack item, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10)
    {
        super.onItemUse(item, player, world, x, y, z, par7, par8, par9, par10);
        if (world.getBlockId(x, y, z) == Block.jukebox.blockID && world.getBlockMetadata(x, y, z) == 0)
        {
                return true;
        }
        else
        {
                return false;
        }
    }
	
	@Override
    public String getRecordTitle()
    {
            if(this.recordName == BleachModInfo.ID.toLowerCase() + ":asterisk") return "Asterisk";
            else if(this.recordName == BleachModInfo.ID.toLowerCase() + ":NumberOne") return "Number One";
            else if(this.recordName == BleachModInfo.ID.toLowerCase() + ":Escalon") return "Escalon";
            return this.recordName;
    }
}
