package littlebreadloaf.bleach.armor;

import littlebreadloaf.bleach.BleachMod;
import littlebreadloaf.bleach.BleachModInfo;
import littlebreadloaf.bleach.Names;
import littlebreadloaf.bleach.items.BleachItems;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
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
	
	
	
	@Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, int armorSlot) 
	{
		ModelBiped armorModel = null;
		if(itemStack != null)
		{
				armorModel = BleachMod.proxy.getArmorModel(0);
				if(armorModel != null){

					armorModel.bipedHead.showModel = armorSlot == 0;
					armorModel.bipedHeadwear.showModel = armorSlot == 0;
					armorModel.bipedBody.showModel = armorSlot == 1 || armorSlot == 2;
					armorModel.bipedRightArm.showModel = armorSlot == 1;
					armorModel.bipedLeftArm.showModel = armorSlot == 1;
					armorModel.bipedRightLeg.showModel = armorSlot == 2 || armorSlot == 3;
					armorModel.bipedLeftLeg.showModel = armorSlot == 2 || armorSlot == 3;

					armorModel.isSneak = entityLiving.isSneaking();
					armorModel.isRiding = entityLiving.isRiding();
					armorModel.isChild = entityLiving.isChild();
					armorModel.heldItemRight = entityLiving.getEquipmentInSlot(0) != null ? 1 :0;
					if(entityLiving instanceof EntityPlayer && entityLiving.getHeldItem() != null)
					{
						
						if(entityLiving.getHeldItem().getItem() == Items.bow || entityLiving.getHeldItem().getItem() == BleachItems.quincybow || entityLiving.getHeldItem().getItem() == BleachItems.quincyweb)
						{
							armorModel.aimedBow =((EntityPlayer)entityLiving).getItemInUseDuration() > 2;	
						}
						else
						{
							if(((EntityPlayer)entityLiving).getItemInUseDuration() > 0)
							armorModel.heldItemRight = 3;
						}
							
					}
					return armorModel;
					}
			
		}
		return armorModel;
	}
	 

	
}