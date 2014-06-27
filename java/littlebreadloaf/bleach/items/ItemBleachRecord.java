package littlebreadloaf.bleach.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import littlebreadloaf.bleach.BleachModInfo;
import littlebreadloaf.bleach.Names;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

public class ItemBleachRecord extends ItemRecord
{

	IIcon icons[];
	private static String[] ICON = {":asterisk", ":NumberOne", "Escalon"};
	public ItemBleachRecord(String discName) 
	{
		super(discName);
		this.setCreativeTab(null);    
		this.maxStackSize = 1;
	}
	@Override
    /**
     * Gets an icon index based on an item's damage value
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int par1)
    {
		return icons[par1];
    }
	
	@Override
	 @SideOnly(Side.CLIENT)
	    public String getRecordNameLocal()
	    {
	        return StatCollector.translateToLocal("item.record." + this.recordName + ".desc");
	    }
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister icon)
	{
		icons = new IIcon[ICON.length];
		
		for(int i = 0; i < icons.length; i++)
		{
			icons[i] = icon.registerIcon(BleachModInfo.ID.toLowerCase() + ICON[i]);
		}
	}
	
	@Override
    /**
     * Retrieves the resource location of the sound to play for this record.
     * 
     * @param name The name of the record to play
     * @return The resource location for the audio, null to use default.
     */
    public ResourceLocation getRecordResource(String name)
    {
        return new ResourceLocation(name);
    }
	
	
}
