package littlebreadloaf.bleach.gui;

import littlebreadloaf.bleach.BleachMod;
import littlebreadloaf.bleach.gui.hollow.GuiArmOptions;
import littlebreadloaf.bleach.gui.hollow.GuiBackOptions;
import littlebreadloaf.bleach.gui.hollow.GuiColorSelect;
import littlebreadloaf.bleach.gui.hollow.GuiHeadOptions;
import littlebreadloaf.bleach.gui.hollow.GuiHollowSelect;
import littlebreadloaf.bleach.gui.hollow.GuiLegsOptions;
import littlebreadloaf.bleach.gui.hollow.GuiTailOptions;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;

public class GuiHandler implements IGuiHandler
{
	public GuiHandler()
	{
		NetworkRegistry.INSTANCE.registerGuiHandler(BleachMod.instance, this);
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
			case 2: return new GuiFaction(player);
			case 3: return new GuiHollowSelect(player);
			case 4: return new GuiHeadOptions(player);
			case 5: return new GuiBackOptions(player);
			case 7: return new GuiTailOptions(player);
			case 8: return new GuiLegsOptions(player);
			case 9: return new GuiColorSelect(player);
			case 10: return new GuiArmOptions(player);
		}
	}
}
