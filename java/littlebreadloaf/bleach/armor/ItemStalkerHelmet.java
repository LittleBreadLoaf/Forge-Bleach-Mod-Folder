package littlebreadloaf.bleach.armor;

import littlebreadloaf.bleach.BleachMod;
import littlebreadloaf.bleach.BleachModInfo;
import littlebreadloaf.bleach.Names;
import littlebreadloaf.bleach.events.ExtendedPlayer;
import littlebreadloaf.bleach.items.BleachItems;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemStalkerHelmet extends ItemArmor 
{

	public ItemStalkerHelmet(ArmorMaterial par2, int par3, int par4) 
	{
		super(par2, par3, par4);
		this.setUnlocalizedName(Names.StalkerHelmet_UnlocalizedName);
		this.setTextureName(BleachModInfo.ID + ":" + Names.StalkerHelmet_UnlocalizedName);
		this.setCreativeTab(BleachItems.tabBleach);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1RegisterIcon)
	{
		this.itemIcon = par1RegisterIcon.registerIcon(BleachModInfo.ID.toLowerCase() + ":" + Names.StalkerHelmet_UnlocalizedName);
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String layer)
	{
		return BleachModInfo.ID.toLowerCase() + ":textures/models/armor/stalker_mask_1.png";
	}
	
	
	
	int depleteTimer = 40;
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
    {
		--depleteTimer;
		ExtendedPlayer props = (ExtendedPlayer) player.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);
		if(props.getCurrentEnergy() > 0)
		{
			player.addPotionEffect(new PotionEffect(Potion.damageBoost.getId(), 40, 0));
			if(depleteTimer <= 0)
			{
				depleteTimer = 40;
				if(!world.isRemote)
				props.consumeEnergy(1);
			}
		}
		
	}
	@Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, int armorSlot) 
	{
		ModelBiped armorModel = null;
		if(itemStack != null)
		{
				armorModel = BleachMod.proxy.getArmorModel(4);
				if(armorModel != null){

					armorModel.bipedHead.showModel = armorSlot == 0;
					armorModel.bipedHeadwear.showModel = false;
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
