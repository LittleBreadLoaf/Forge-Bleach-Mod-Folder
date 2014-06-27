package littlebreadloaf.bleach.armor;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import littlebreadloaf.bleach.BleachMod;
import littlebreadloaf.bleach.BleachModInfo;
import littlebreadloaf.bleach.Names;
import littlebreadloaf.bleach.events.ExtendedPlayer;
import littlebreadloaf.bleach.events.PacketSync;
import littlebreadloaf.bleach.items.BleachItems;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemQuincyRobes extends ItemArmor 
{

	public ItemQuincyRobes(ArmorMaterial par2, int par3, int par4) 
	{
		super(par2, par3, par4);
		this.setCreativeTab(BleachItems.tabBleach);
		if (par4 == 1) 
		{
			this.setTextureName(BleachModInfo.ID + ":" + Names.QuincyChest_UnlocalizedName);
		}
		else if (par4 == 2) 
		{
			this.setTextureName(BleachModInfo.ID + ":" + Names.QuincyPants_UnlocalizedName);
		}
		else if (par4 == 3) 
		{
			this.setTextureName(BleachModInfo.ID + ":" + Names.QuincyShoes_UnlocalizedName);
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1RegisterIcon)
	{
		if 
		(this == Armor.QuincyRobe) 
		{
			this.itemIcon = par1RegisterIcon.registerIcon(BleachModInfo.ID.toLowerCase() + ":" + Names.QuincyChest_UnlocalizedName); // You can also replace blockID and blockIcon with this and itemIcon
			}

			if (this == Armor.QuincyPants) 
			{
			this.itemIcon = par1RegisterIcon.registerIcon(BleachModInfo.ID.toLowerCase() + ":" + Names.QuincyPants_UnlocalizedName); // You can also replace blockID and blockIcon with this and itemIcon
			}

			if (this == Armor.QuincyShoes) 
			{
			this.itemIcon = par1RegisterIcon.registerIcon(BleachModInfo.ID.toLowerCase() + ":" + Names.QuincyShoes_UnlocalizedName); // You can also replace blockID and blockIcon with this and itemIcon
			}

			
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String layer) 
	{
			if (
			 stack.getItem() == Armor.QuincyRobe
			|| stack.getItem() == Armor.QuincyShoes) {
				return BleachModInfo.ID.toLowerCase() + ":textures/models/armor/quincy_1.png";
			}
			if (stack.getItem() == Armor.QuincyPants) 
			{
				return BleachModInfo.ID.toLowerCase() + ":textures/models/armor/quincy_2.png";
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
		--replenishTimer;
		ExtendedPlayer props = (ExtendedPlayer) player.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);
		
			if(replenishTimer <= 0)
			{
				replenishTimer = 200;

				props.replenishEnergy(2);
				BleachMod.packetPipeline.sendToServer(new PacketSync(player));
			}
		
		
	}
	
	
	 

	
}