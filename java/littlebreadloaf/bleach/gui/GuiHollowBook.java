package littlebreadloaf.bleach.gui;

import littlebreadloaf.bleach.BleachModInfo;
import littlebreadloaf.bleach.gui.buttons.GuiTexturedButton;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class GuiHollowBook extends GuiScreen {

	ResourceLocation texture = new ResourceLocation(BleachModInfo.ID.toLowerCase(), "textures/guis/hollowbook_gui.png");
	public final int xSizeOfTexture = 256;
	public final int ySizeOfTexture = 256;
	
	private int id = -1;
	
	public GuiHollowBook(EntityPlayer player) {
		
	}
	
	@Override
	public void drawScreen(int x, int y, float f) {
		drawDefaultBackground();
		
		GL11.glColor4f(1F, 1F, 1F, 1F);
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);

		int posX = (this.width - xSizeOfTexture) / 2;
		int posY = (this.height - ySizeOfTexture) / 2;
		drawTexturedModalRect(posX, posY, 0, 0, xSizeOfTexture, ySizeOfTexture);
		
		super.drawScreen(x, y, f);
	}
	
	public void initGui() {
		int posX = (this.width - xSizeOfTexture) / 2;
		int posY = (this.height - ySizeOfTexture) / 2;
	}
	
	public void actionPerformed(GuiButton button) {
		switch(button.id) {
		case 0: System.out.println("pressed");
			break;
		default:
		}
	}
	
	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
}
