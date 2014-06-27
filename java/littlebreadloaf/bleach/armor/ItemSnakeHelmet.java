package littlebreadloaf.bleach.armor;

import littlebreadloaf.bleach.BleachModInfo;
import littlebreadloaf.bleach.Names;
import littlebreadloaf.bleach.items.BleachItems;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemSnakeHelmet extends ItemArmor 
{

	public ItemSnakeHelmet(ArmorMaterial par2, int par3, int par4) 
	{
		super(par2, par3, par4);
		this.setUnlocalizedName(Names.SnakeHelmet_UnlocalizedName);
		this.setTextureName(BleachModInfo.ID + ":" + Names.SnakeHelmet_UnlocalizedName);
		this.setCreativeTab(BleachItems.tabBleach);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1RegisterIcon)
	{
		this.itemIcon = par1RegisterIcon.registerIcon(BleachModInfo.ID.toLowerCase() + ":" + Names.SnakeHelmet_UnlocalizedName);
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String layer)
	{
		return BleachModInfo.ID.toLowerCase() + ":textures/models/armor/snake_mask_1.png";
	}
	
	
	
	 

	
}
