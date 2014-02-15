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

public class ItemArrancarArmor extends ItemArmor 
{

	public ItemArrancarArmor(int par1, EnumArmorMaterial par2, int par3, int par4) 
	{
		super(par1, par2, par3, par4);
		this.setCreativeTab(BleachItems.tabBleach);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1RegisterIcon)
	{
		if 
		(itemID == Armor.ArrancarJacket.itemID) 
		{
			this.itemIcon = par1RegisterIcon.registerIcon(BleachModInfo.ID.toLowerCase() + ":" + Names.ArrancarTop_UnlocalizedName); // You can also replace blockID and blockIcon with itemID and itemIcon
			}

			if (itemID == Armor.ArrancarPants.itemID) 
			{
			this.itemIcon = par1RegisterIcon.registerIcon(BleachModInfo.ID.toLowerCase() + ":" + Names.ArrancarPants_UnlocalizedName); // You can also replace blockID and blockIcon with itemID and itemIcon
			}

			if (itemID == Armor.ArrancarShoes.itemID) 
			{
			this.itemIcon = par1RegisterIcon.registerIcon(BleachModInfo.ID.toLowerCase() + ":" + Names.ArrancarShoes_UnlocalizedName); // You can also replace blockID and blockIcon with itemID and itemIcon
			}

			
	}
	
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer) 
	{
			if (
			 stack.itemID == Armor.ArrancarJacket.itemID
			|| stack.itemID == Armor.ArrancarShoes.itemID) {
				return BleachModInfo.ID.toLowerCase() + ":textures/models/armor/arrancar_armor_1.png";
			}
			if (stack.itemID == Armor.ArrancarPants.itemID) 
			{
				return BleachModInfo.ID.toLowerCase() + ":textures/models/armor/arrancar_armor_2.png";
			} 
			else 
			{
				return null;
			}

			}
	
	
	
	
	 

	
}