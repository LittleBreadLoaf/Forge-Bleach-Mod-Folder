package littlebreadloaf.items;

import littlebreadloaf.libraries.Ids;
import littlebreadloaf.world.HuecoMundoTeleporter;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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
			if (playermp.dimension == Ids.worldHuecoMundoID)
			{
				playermp.mcServer.getConfigurationManager().transferPlayerToDimension(playermp, 0, new HuecoMundoTeleporter(playermp.mcServer.worldServerForDimension(0)));
			} else
			{
				playermp.mcServer.getConfigurationManager().transferPlayerToDimension(playermp, Ids.worldHuecoMundoID,
						new HuecoMundoTeleporter(playermp.mcServer.worldServerForDimension(Ids.worldHuecoMundoID)));
			}
		}
		return stack;
	}
}
