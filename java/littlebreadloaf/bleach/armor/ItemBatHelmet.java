package littlebreadloaf.bleach.armor;

import littlebreadloaf.bleach.BleachModInfo;
import littlebreadloaf.bleach.Names;
import littlebreadloaf.bleach.events.ExtendedPlayer;
import littlebreadloaf.bleach.items.BleachItems;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBatHelmet extends ItemArmor 
{

	public ItemBatHelmet(ArmorMaterial par2, int par3, int par4) 
	{
		super(par2, par3, par4);
		this.setUnlocalizedName(Names.BatHelmet_UnlocalizedName);
		this.setCreativeTab(BleachItems.tabBleach);
		this.setTextureName(BleachModInfo.ID + ":" + Names.BatHelmet_UnlocalizedName);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1RegisterIcon)
	{
		this.itemIcon = par1RegisterIcon.registerIcon(BleachModInfo.ID.toLowerCase() + ":" + Names.BatHelmet_UnlocalizedName);
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		return BleachModInfo.ID.toLowerCase() + ":textures/models/armor/bat_mask_1.png";
	}
	
	int depleteTimer = 40;
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
    {
		--depleteTimer;
		ExtendedPlayer props = (ExtendedPlayer) player.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);
		if(props.getCurrentEnergy() > 0)
		{
			player.addPotionEffect(new PotionEffect(Potion.nightVision.getId(), 220, 0));
			if(depleteTimer <= 0)
			{
				depleteTimer = 40;
				if(!world.isRemote)
				props.consumeEnergy(1);
			}
		}
		
	}
	
	 

	
}
