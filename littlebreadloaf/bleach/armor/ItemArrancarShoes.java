package littlebreadloaf.bleach.armor;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import littlebreadloaf.bleach.BleachModInfo;
import littlebreadloaf.bleach.Names;
import littlebreadloaf.bleach.items.BleachItems;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemArrancarShoes extends ItemArmor 
{

	public ItemArrancarShoes(int par1, EnumArmorMaterial par2, int par3, int par4) 
	{
		super(par1, par2, par3, par4);
		this.setUnlocalizedName(Names.ArrancarShoes_UnlocalizedName);
		this.setCreativeTab(BleachItems.tabBleach);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1RegisterIcon)
	{
		this.itemIcon = par1RegisterIcon.registerIcon(BleachModInfo.ID.toLowerCase() + ":" + Names.ArrancarShoes_UnlocalizedName);
	}
	
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer)
	{
		return BleachModInfo.ID.toLowerCase() + ":textures/models/armor/arrancar_armor_1.png";
	}
	
	
	
	 

	
}