package littlebreadloaf.items;

import littlebreadloaf.libraries.BleachModInfo;
import littlebreadloaf.libraries.Names;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemSoulQuartz extends Item 
{
	public ItemSoulQuartz(int id)
	{
		super(id);
		this.setCreativeTab(Items.tabBleach);
		this.setUnlocalizedName(Names.SoulQuartz_UnlocalizedName);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon)
	{
		itemIcon = icon.registerIcon(BleachModInfo.ID.toLowerCase() + ":" + Names.SoulQuartz_UnlocalizedName);
	}
	

}
