package littlebreadloaf.bleach.items;

import cpw.mods.fml.common.FMLLog;
import littlebreadloaf.bleach.BleachIds;
import littlebreadloaf.bleach.world.HuecoMundoTeleporter;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class DebugItem extends Item
{

	public DebugItem(int id)
	{
		super(id);
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
}
