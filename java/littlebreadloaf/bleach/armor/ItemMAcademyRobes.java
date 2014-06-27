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

public class ItemMAcademyRobes extends ItemArmor 
{

	public ItemMAcademyRobes(ArmorMaterial par2, int par3, int armorType) 
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
		
			if (this == Armor.MaleAcademyTop) 
			{
			this.itemIcon = par1RegisterIcon.registerIcon(BleachModInfo.ID.toLowerCase() + ":" + Names.MaleAcademyTop_UnlocalizedName); 
			}

			if (this == Armor.MaleAcademyBottom) 
			{
			this.itemIcon = par1RegisterIcon.registerIcon(BleachModInfo.ID.toLowerCase() + ":" + Names.MaleAcademyBottom_UnlocalizedName);
			}
			

			
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String layer) 
	{
			
			if (stack.getItem() == Armor.MaleAcademyTop) 
			{
				return BleachModInfo.ID.toLowerCase() + ":textures/models/armor/male_academy_1.png";
			}
			if (stack.getItem() == Armor.MaleAcademyTop) 
			{
				return BleachModInfo.ID.toLowerCase() + ":textures/models/armor/male_academy_2.png";
			}
			else 
			{
				return null;
			}

			}
	
	
	
	
	 

	
}