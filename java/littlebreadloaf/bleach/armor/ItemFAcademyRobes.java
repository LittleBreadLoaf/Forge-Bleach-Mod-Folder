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

public class ItemFAcademyRobes extends ItemArmor 
{

	public ItemFAcademyRobes(ArmorMaterial par2, int par3, int armorType) 
	{
		super(par2, par3, armorType);
		this.setCreativeTab(BleachItems.tabBleach);
		if (armorType == 1) 
		{
			this.setTextureName(BleachModInfo.ID + ":" + Names.FemaleAcademyTop_UnlocalizedName);
		}
		else if (armorType == 2) 
		{
			this.setTextureName(BleachModInfo.ID + ":" + Names.FemaleAcademyBottom_UnlocalizedName);
		} 
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1RegisterIcon)
	{
		
			if (this == Armor.FemaleAcademyTop) 
			{
			this.itemIcon = par1RegisterIcon.registerIcon(BleachModInfo.ID.toLowerCase() + ":" + Names.FemaleAcademyTop_UnlocalizedName); 
			}

			if (this == Armor.FemaleAcademyBottom) 
			{
			this.itemIcon = par1RegisterIcon.registerIcon(BleachModInfo.ID.toLowerCase() + ":" + Names.FemaleAcademyBottom_UnlocalizedName);
			}
			

			
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String layer) 
	{
			
			if (stack.getItem() == Armor.FemaleAcademyTop) 
			{
				return BleachModInfo.ID.toLowerCase() + ":textures/models/armor/female_academy_1.png";
			}
			if (stack.getItem() == Armor.FemaleAcademyTop) 
			{
				return BleachModInfo.ID.toLowerCase() + ":textures/models/armor/female_academy_2.png";
			}
			else 
			{
				return null;
			}

			}
	
	
	
	
	 

	
}