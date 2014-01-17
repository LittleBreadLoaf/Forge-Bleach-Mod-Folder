package littlebreadloaf.bleach.gui;

import littlebreadloaf.bleach.BleachMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;

public class GuiHandler implements IGuiHandler
{
	public GuiHandler()
	{
		NetworkRegistry.instance().registerGuiHandler(BleachMod.instance, this);
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		switch(ID) {
			default: return null;
		}
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		switch(ID) {
			default: return null;
			case 0: return new GuiZanpakuto();
			case 1: return new GuiHollowBook(player);
		}
	}
}
