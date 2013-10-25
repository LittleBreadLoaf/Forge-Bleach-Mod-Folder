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

public class ItemReiatsu extends Item
{
	 public final int itemUseDuration;
	public ItemReiatsu(int id)
	{
		super(id);
		this.setCreativeTab(Items.tabBleach);
		this.setUnlocalizedName(Names.Reiatsu_UnlocalizedName);
		this.itemUseDuration = 32;
		
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon)
	{
		itemIcon = icon.registerIcon(BleachModInfo.ID.toLowerCase() + ":" + Names.Reiatsu_UnlocalizedName);
	}
	
	public int getMaxItemUseDuration(ItemStack par1ItemStack)
    {
        return 32;
    }
	
	public EnumAction getItemUseAction(ItemStack par1ItemStack)
	{
		return EnumAction.eat;
	}
	   /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
	@Override
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {

		
		par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
		
        return par1ItemStack;
    }
	
	
    
	public ItemStack onEaten(ItemStack itemstack, World world, EntityPlayer player)
	{
		if (!world.isRemote)
		{
			ExtendedPlayer props = (ExtendedPlayer) player.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);
			--itemstack.stackSize;
			props.replenishEnergy(10);
			world.playSoundAtEntity(player, "random.burp", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F); 
			
		}
		return itemstack;
	}

}
