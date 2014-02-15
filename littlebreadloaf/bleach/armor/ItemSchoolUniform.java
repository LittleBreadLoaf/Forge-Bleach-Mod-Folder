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

public class ItemSchoolUniform extends ItemArmor 
{

	public ItemSchoolUniform(int par1, EnumArmorMaterial par2, int par3, int par4) 
	{
		super(par1, par2, par3, par4);
		this.setCreativeTab(BleachItems.tabBleach);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1RegisterIcon)
	{
		if (itemID == Armor.MaleSchoolTop.itemID) 
			{
			this.itemIcon = par1RegisterIcon.registerIcon(BleachModInfo.ID.toLowerCase() + ":" + Names.MaleSchoolTop_UnlocalizedName); 
			}

			if (itemID == Armor.MaleSchoolBottom.itemID) 
			{
			this.itemIcon = par1RegisterIcon.registerIcon(BleachModInfo.ID.toLowerCase() + ":" + Names.MaleSchoolBottom_UnlocalizedName); 
			}
			if (itemID == Armor.FemaleSchoolTop.itemID) 
			{
			this.itemIcon = par1RegisterIcon.registerIcon(BleachModInfo.ID.toLowerCase() + ":" + Names.FemaleSchoolTop_UnlocalizedName); 
			}

			if (itemID == Armor.FemaleSchoolBottom.itemID) 
			{
			this.itemIcon = par1RegisterIcon.registerIcon(BleachModInfo.ID.toLowerCase() + ":" + Names.FemaleSchoolBottom_UnlocalizedName);
			}
			

			
	}
	
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer) 
	{
			if (stack.itemID == Armor.MaleSchoolTop.itemID) 
			{
				return BleachModInfo.ID.toLowerCase() + ":textures/models/armor/male_school_1.png";
			}
			if (stack.itemID == Armor.MaleSchoolBottom.itemID) 
			{
				return BleachModInfo.ID.toLowerCase() + ":textures/models/armor/male_school_2.png";
			} 
			if (stack.itemID == Armor.FemaleSchoolTop.itemID) 
			{
				return BleachModInfo.ID.toLowerCase() + ":textures/models/armor/female_school_1.png";
			}
			if (stack.itemID == Armor.FemaleSchoolBottom.itemID) 
			{
				return BleachModInfo.ID.toLowerCase() + ":textures/models/armor/female_school_2.png";
			}
			else 
			{
				return null;
			}

			}
	
	
	
	
	 

	
}