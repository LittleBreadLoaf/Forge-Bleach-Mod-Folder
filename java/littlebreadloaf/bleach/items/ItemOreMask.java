package littlebreadloaf.bleach.items;

import littlebreadloaf.bleach.BleachModInfo;
import littlebreadloaf.bleach.Names;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemOreMask extends Item 
{
	public ItemOreMask()
	{
		super();
		this.setCreativeTab(BleachItems.tabBleach);
		this.setUnlocalizedName(Names.OreHelmet_UnlocalizedName);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister icon)
	{
		itemIcon = icon.registerIcon(BleachModInfo.ID.toLowerCase() + ":" + Names.OreHelmet_UnlocalizedName);
	}
	

}
