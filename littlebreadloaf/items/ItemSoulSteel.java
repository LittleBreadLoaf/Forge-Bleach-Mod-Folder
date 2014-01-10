package littlebreadloaf.items;

import littlebreadloaf.events.ExtendedPlayer;
import littlebreadloaf.libraries.BleachModInfo;
import littlebreadloaf.libraries.Names;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemSoulSteel extends Item
{
	 public final int itemUseDuration;
	public ItemSoulSteel(int id)
	{
		super(id);
		this.setCreativeTab(Items.tabBleach);
		this.setUnlocalizedName(Names.SoulSteel_UnlocalizedName);
		this.itemUseDuration = 32;
		
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon)
	{
		itemIcon = icon.registerIcon(BleachModInfo.ID.toLowerCase() + ":" + Names.SoulSteel_UnlocalizedName);
	}
	
	public int getMaxItemUseDuration(ItemStack par1ItemStack)
    {
        return 32;
    }
	
	public EnumAction getItemUseAction(ItemStack par1ItemStack)
	{
		return null;
	}

	
	

}
