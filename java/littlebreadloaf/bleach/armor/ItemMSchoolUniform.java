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

public class ItemMSchoolUniform extends ItemArmor 
{

	public ItemMSchoolUniform(ArmorMaterial par2, int par3, int armorType) 
	{
		super(par2, par3, armorType);
		this.setCreativeTab(BleachItems.tabBleach);
		if (armorType == 1) 
		{
			this.setTextureName(BleachModInfo.ID + ":" + Names.MaleAcademyTop_UnlocalizedName);
		}
		else if (armorType == 2) 
		{
			this.setTextureName(BleachModInfo.ID + ":" + Names.MaleAcademyBottom_UnlocalizedName);
		} 
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1RegisterIcon)
	{
		
			if (this == Armor.MaleSchoolTop) 
			{
			this.itemIcon = par1RegisterIcon.registerIcon(BleachModInfo.ID.toLowerCase() + ":" + Names.MaleSchoolTop_UnlocalizedName); 
			}

			if (this == Armor.MaleSchoolBottom) 
			{
			this.itemIcon = par1RegisterIcon.registerIcon(BleachModInfo.ID.toLowerCase() + ":" + Names.MaleSchoolBottom_UnlocalizedName);
			}
			

			
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String layer) 
	{
			
			if (stack.getItem() == Armor.MaleSchoolTop) 
			{
				return BleachModInfo.ID.toLowerCase() + ":textures/models/armor/male_school_1.png";
			}
			if (stack.getItem() == Armor.MaleSchoolBottom) 
			{
				return BleachModInfo.ID.toLowerCase() + ":textures/models/armor/male_school_2.png";
			}
			else 
			{
				return null;
			}

			}
	
	
	
	
	 

	
}