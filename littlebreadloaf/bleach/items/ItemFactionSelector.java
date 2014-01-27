package littlebreadloaf.bleach.items;

import littlebreadloaf.bleach.BleachMod;
import littlebreadloaf.bleach.BleachModInfo;
import littlebreadloaf.bleach.Names;
import littlebreadloaf.bleach.events.ExtendedPlayer;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemFactionSelector extends Item
{
	 public final int itemUseDuration;
	public ItemFactionSelector(int id)
	{
		super(id);
		this.setCreativeTab(BleachItems.tabBleach);
		this.setUnlocalizedName(Names.FactionSelect_UnlocalizedName);
		this.itemUseDuration = 32;
		this.maxStackSize = 1;
		
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon)
	{
		itemIcon = icon.registerIcon(BleachModInfo.ID.toLowerCase() + ":" + Names.FactionSelect_UnlocalizedName);
	}
	
	
	
	
	   /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
	@Override
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
		
		if(((ExtendedPlayer)(par3EntityPlayer.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME))).getFaction() == 0)
		{
			FMLNetworkHandler.openGui(par3EntityPlayer, BleachMod.instance, 2, par2World, (int)par3EntityPlayer.posX, (int)par3EntityPlayer.posY, (int)par3EntityPlayer.posZ);
		}
		
        return par1ItemStack;
    }
	

}
