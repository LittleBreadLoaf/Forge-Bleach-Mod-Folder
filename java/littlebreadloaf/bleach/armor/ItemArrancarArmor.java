package littlebreadloaf.bleach.armor;

import littlebreadloaf.bleach.BleachMod;
import littlebreadloaf.bleach.BleachModInfo;
import littlebreadloaf.bleach.Names;
import littlebreadloaf.bleach.events.ExtendedPlayer;
import littlebreadloaf.bleach.items.BleachItems;
import littlebreadloaf.bleach.network.ServerSyncMessage;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemArrancarArmor extends ItemArmor 
{

	public ItemArrancarArmor(ArmorMaterial par2, int par3, int par4) 
	{
		super(par2, par3, par4);
		this.setCreativeTab(BleachItems.tabBleach);
		if (par4 == 1) 
		{
			this.setTextureName(BleachModInfo.ID + ":" + Names.ArrancarTop_UnlocalizedName);
		}
		else if (par4 == 2) 
		{
			this.setTextureName(BleachModInfo.ID + ":" + Names.ArrancarPants_UnlocalizedName);
		}
		else if (par4 == 3) 
		{
			this.setTextureName(BleachModInfo.ID + ":" + Names.ArrancarShoes_UnlocalizedName);
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1RegisterIcon)
	{
		if 
		(this == Armor.ArrancarJacket) 
		{
			this.itemIcon = par1RegisterIcon.registerIcon(BleachModInfo.ID.toLowerCase() + ":" + Names.ArrancarTop_UnlocalizedName); // You can also replace blockID and blockIcon with this and itemIcon
			}

			if (this == Armor.ArrancarPants) 
			{
			this.itemIcon = par1RegisterIcon.registerIcon(BleachModInfo.ID.toLowerCase() + ":" + Names.ArrancarPants_UnlocalizedName); // You can also replace blockID and blockIcon with this and itemIcon
			}

			if (this == Armor.ArrancarShoes) 
			{
			this.itemIcon = par1RegisterIcon.registerIcon(BleachModInfo.ID.toLowerCase() + ":" + Names.ArrancarShoes_UnlocalizedName); // You can also replace blockID and blockIcon with this and itemIcon
			}

			
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String layer) 
	{
			if (
			 stack.getItem() == Armor.ArrancarJacket
			|| stack.getItem() == Armor.ArrancarShoes) {
				return BleachModInfo.ID.toLowerCase() + ":textures/models/armor/arrancar_armor_1.png";
			}
			if (stack.getItem() == Armor.ArrancarPants) 
			{
				return BleachModInfo.ID.toLowerCase() + ":textures/models/armor/arrancar_armor_2.png";
			} 
			else 
			{
				return null;
			}

			}
	
	
	

	int replenishTimer = 200;
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
    {
		if(!world.isRemote)
		{
		--replenishTimer;
		
		ExtendedPlayer props = (ExtendedPlayer) player.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);
		
			if(replenishTimer <= 0 && props.getFaction() == 1)
			{
				props.replenishEnergy(2);
				if(player instanceof EntityPlayerMP)
				BleachMod.network.sendTo(new ServerSyncMessage(player), (EntityPlayerMP)player);			
				replenishTimer = 200;
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