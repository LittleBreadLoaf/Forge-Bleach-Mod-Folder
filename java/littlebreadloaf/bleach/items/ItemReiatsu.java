package littlebreadloaf.bleach.items;

import littlebreadloaf.bleach.BleachModInfo;
import littlebreadloaf.bleach.Names;
import littlebreadloaf.bleach.events.ExtendedPlayer;
import net.minecraft.client.renderer.texture.IIconRegister;
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
	public ItemReiatsu()
	{
		super();
		this.setCreativeTab(BleachItems.tabBleach);
		this.setUnlocalizedName(Names.Reiatsu_UnlocalizedName);
		this.itemUseDuration = 32;
		
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister icon)
	{
		itemIcon = icon.registerIcon(BleachModInfo.ID.toLowerCase() + ":" + Names.Reiatsu_UnlocalizedName);
	}
	
	@Override
	public int getMaxItemUseDuration(ItemStack par1ItemStack)
    {
        return 32;
    }
	
	@Override
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
	
	
	@Override
	public ItemStack onEaten(ItemStack itemstack, World world, EntityPlayer player)
	{
		if (!world.isRemote)
		{
			ExtendedPlayer props = (ExtendedPlayer) player.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);
			--itemstack.stackSize;
			if(props.getFaction() == 2)
			{
				props.replenishEnergy(10);
			}
			else 
			{
				props.replenishEnergy(5);
			}
			
			world.playSoundAtEntity(player, "random.burp", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F); 
			
		}
		return itemstack;
	}

}
