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

public class ItemAcademyRobes extends ItemArmor 
{

	public ItemAcademyRobes(int par1, EnumArmorMaterial par2, int par3, int par4) 
	{
		super(par1, par2, par3, par4);
		this.setCreativeTab(BleachItems.tabBleach);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1RegisterIcon)
	{
		if (itemID == Armor.MaleAcademyTop.itemID) 
			{
			this.itemIcon = par1RegisterIcon.registerIcon(BleachModInfo.ID.toLowerCase() + ":" + Names.MaleAcademyTop_UnlocalizedName); 
			}

			if (itemID == Armor.MaleAcademyBottom.itemID) 
			{
			this.itemIcon = par1RegisterIcon.registerIcon(BleachModInfo.ID.toLowerCase() + ":" + Names.MaleAcademyBottom_UnlocalizedName); 
			}
			if (itemID == Armor.FemaleAcademyTop.itemID) 
			{
			this.itemIcon = par1RegisterIcon.registerIcon(BleachModInfo.ID.toLowerCase() + ":" + Names.FemaleAcademyTop_UnlocalizedName); 
			}

			if (itemID == Armor.FemaleAcademyBottom.itemID) 
			{
			this.itemIcon = par1RegisterIcon.registerIcon(BleachModInfo.ID.toLowerCase() + ":" + Names.FemaleAcademyBottom_UnlocalizedName);
			}
			

			
	}
	
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer) 
	{
			if (stack.itemID == Armor.MaleAcademyTop.itemID) 
			{
				return BleachModInfo.ID.toLowerCase() + ":textures/models/armor/male_academy_1.png";
			}
			if (stack.itemID == Armor.MaleAcademyBottom.itemID) 
			{
				return BleachModInfo.ID.toLowerCase() + ":textures/models/armor/male_academy_2.png";
			} 
			if (stack.itemID == Armor.FemaleAcademyTop.itemID) 
			{
				return BleachModInfo.ID.toLowerCase() + ":textures/models/armor/female_academy_1.png";
			}
			if (stack.itemID == Armor.FemaleAcademyBottom.itemID) 
			{
				return BleachModInfo.ID.toLowerCase() + ":textures/models/armor/female_academy_2.png";
			}
			else 
			{
				return null;
			}

			}
	
	
	
	
	 

	
}