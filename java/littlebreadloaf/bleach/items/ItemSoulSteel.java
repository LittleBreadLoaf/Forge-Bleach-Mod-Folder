package littlebreadloaf.bleach.items;

import littlebreadloaf.bleach.BleachModInfo;
import littlebreadloaf.bleach.Names;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemSoulSteel extends Item
{
	 public final int itemUseDuration;
	public ItemSoulSteel()
	{
		super();
		this.setCreativeTab(BleachItems.tabBleach);
		this.setUnlocalizedName(Names.SoulSteel_UnlocalizedName);
		this.itemUseDuration = 32;
		
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister icon)
	{
		itemIcon = icon.registerIcon(BleachModInfo.ID.toLowerCase() + ":" + Names.SoulSteel_UnlocalizedName);
	}

	@Override
	public int getMaxItemUseDuration(ItemStack par1ItemStack)
    {
        return 32;
    }

	@Override
	public EnumAction getItemUseAction(ItemStack par1ItemStack)
	{
		return null;
	}

	
	

}
