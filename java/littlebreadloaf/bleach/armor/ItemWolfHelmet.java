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
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemWolfHelmet extends ItemArmor 
{

	public ItemWolfHelmet(ArmorMaterial par2, int par3, int par4) 
	{
		super(par2, par3, par4);
		this.setUnlocalizedName(Names.WolfHelmet_UnlocalizedName);
		this.setTextureName(BleachModInfo.ID + ":" + Names.WolfHelmet_UnlocalizedName);
		this.setCreativeTab(BleachItems.tabBleach);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1RegisterIcon)
	{
		this.itemIcon = par1RegisterIcon.registerIcon(BleachModInfo.ID.toLowerCase() + ":" + Names.WolfHelmet_UnlocalizedName);
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String layer)
	{
		return BleachModInfo.ID.toLowerCase() + ":textures/models/armor/wolf_mask_1.png";
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, int armorSlot) 
	{
		ModelBiped armorModel = null;
		if(itemStack != null)
		{
				armorModel = BleachMod.proxy.getArmorModel(3);
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
					if(entityLiving instanceof EntityPlayer)
						{
							armorModel.aimedBow =((EntityPlayer)entityLiving).getItemInUseDuration() > 2;
						}
					return armorModel;
					}
			
		}
		return armorModel;
	}
	
	
	
	
	 

	
}
