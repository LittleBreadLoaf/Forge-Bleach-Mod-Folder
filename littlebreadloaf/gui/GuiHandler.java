package littlebreadloaf.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import littlebreadloaf.BleachMod;
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
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		
	return new GuiZanpakuto();
			
		
			
		
	}
}
