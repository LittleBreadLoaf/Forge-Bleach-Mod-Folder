package littlebreadloaf.bleach.gui;

import littlebreadloaf.bleach.BleachMod;
import littlebreadloaf.bleach.BleachModInfo;
import littlebreadloaf.bleach.events.ExtendedPlayer;
import littlebreadloaf.bleach.network.FlashMessage;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;

public class GuiFaction extends GuiScreen {

	ResourceLocation texture = new ResourceLocation(BleachModInfo.ID.toLowerCase(), "textures/guis/faction_gui.png");
	public final int xSizeOfTexture = 256;
	public final int ySizeOfTexture = 256;
	
	EntityPlayer thePlayer;
	
	
	
	private int id = -1;
	
	public GuiFaction(EntityPlayer player) 
	{
		this.thePlayer = player;
	}
	
	@Override
	public void drawScreen(int x, int y, float f) {
		drawDefaultBackground();
		
		GL11.glColor4f(1F, 1F, 1F, 1F);
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);

		int posX = (this.width - xSizeOfTexture) / 2;
		int posY = (this.height - ySizeOfTexture) / 2;
		drawTexturedModalRect(posX, posY + 50, 0, 0, xSizeOfTexture, ySizeOfTexture);
		
		super.drawScreen(x, y, f);
	}
	
	public void initGui() 
	{
		int posX = (this.width - xSizeOfTexture) / 2;
		int posY = (this.height - ySizeOfTexture) / 2;
		
		
			this.buttonList.add(new GuiButton(0, posX + 130, posY + 100, 100, 20, "Shinigami"));
			this.buttonList.add(new GuiButton(1, posX + 10, posY + 100, 100, 20, "Quincy"));
			//this.buttonList.add(new GuiButton(2, posX + 130, posY + 180, 100, 20, "Hollow"));
			this.buttonList.add(new GuiButton(3, posX + 10, posY + 180, 100, 20, "Human"));
		
	}

	EntityClientPlayerMP player = FMLClientHandler.instance().getClient().thePlayer;
	public void actionPerformed(GuiButton button) {
		switch(button.id) 
		{
		
		case 0:
				BleachMod.network.sendToServer(new FlashMessage(11)); 
				((ExtendedPlayer)(thePlayer.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME))).setFaction(1);
				if(thePlayer.inventory.getCurrentItem() != null)
				thePlayer.inventory.getCurrentItem().stackSize--;
				this.mc.displayGuiScreen((GuiScreen)null);
		break;
		
		case 1: 
			BleachMod.network.sendToServer(new FlashMessage(12));
				((ExtendedPlayer)(thePlayer.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME))).setFaction(2);
				if(thePlayer.inventory.getCurrentItem() != null)
				thePlayer.inventory.getCurrentItem().stackSize--;
				this.mc.displayGuiScreen((GuiScreen)null);
		break;
		
		case 3:
				BleachMod.network.sendToServer(new FlashMessage(14));
				((ExtendedPlayer)(thePlayer.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME))).setFaction(3);
				if(thePlayer.inventory.getCurrentItem() != null)
				thePlayer.inventory.getCurrentItem().stackSize--;
				this.mc.displayGuiScreen((GuiScreen)null);
		break;
		default:
		}
	}
	
	
	
	@Override
	public boolean doesGuiPauseGame() 
	{
		return true;
	}
	
	
}
