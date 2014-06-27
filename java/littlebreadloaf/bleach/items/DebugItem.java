package littlebreadloaf.bleach.items;

import littlebreadloaf.bleach.BleachIds;
import littlebreadloaf.bleach.BleachModInfo;
import littlebreadloaf.bleach.world.HuecoMundoTeleporter;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class DebugItem extends Item
{

	public DebugItem()
	{
		super();
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		if (player.isSneaking() && (player instanceof EntityPlayerMP))
		{
			EntityPlayerMP playermp = (EntityPlayerMP) player;
			if (playermp.dimension == BleachIds.worldHuecoMundoID)
			{
				playermp.mcServer.getConfigurationManager().transferPlayerToDimension(playermp, 0, new HuecoMundoTeleporter(playermp.mcServer.worldServerForDimension(0)));
			} else
			{
				playermp.mcServer.getConfigurationManager().transferPlayerToDimension(playermp, BleachIds.worldHuecoMundoID,
						new HuecoMundoTeleporter(playermp.mcServer.worldServerForDimension(BleachIds.worldHuecoMundoID)));
			}
		}
		return stack;
	}
	

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister icon)
	{
		itemIcon = icon.registerIcon(BleachModInfo.ID.toLowerCase() + ":" + "garganta");
	}
	
	
	
}
