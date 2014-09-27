package littlebreadloaf.bleach.gui.hollow;

import littlebreadloaf.bleach.BleachMod;
import littlebreadloaf.bleach.BleachModInfo;
import littlebreadloaf.bleach.events.ExtendedPlayer;
import littlebreadloaf.bleach.network.HollowPieceMessage;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;

public class GuiHeadOptions extends GuiScreen {

	ResourceLocation texture = new ResourceLocation(BleachModInfo.ID.toLowerCase(), "textures/guis/head_select_gui.png");
	public final int xSizeOfTexture = 256;
	public final int ySizeOfTexture = 171;
	
	EntityPlayer thePlayer;
	
	ExtendedPlayer props;
	
	
	private int id = -1;
	private int choice = 1;
	
	String line1;
	String line2;
	String line3;
	
	public GuiHeadOptions(EntityPlayer player) 
	{
		this.thePlayer = player;
		props = ExtendedPlayer.get(player);
	}
	
	@Override
	public void drawScreen(int x, int y, float f) {
		drawDefaultBackground();
		
		GL11.glColor4f(1F, 1F, 1F, 1F);
		ScaledResolution var5 = new ScaledResolution(this.mc.gameSettings, this.mc.displayWidth, this.mc.displayHeight);
        int var6 = var5.getScaledWidth();
        int var7 = var5.getScaledHeight();
        FontRenderer var8 = this.mc.fontRenderer;
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);

		int posX = (this.width - xSizeOfTexture) / 2;
		int posY = (this.height - ySizeOfTexture) / 2;
		drawTexturedModalRect(posX, posY, 0, 0, xSizeOfTexture, ySizeOfTexture);
		drawTexturedModalRect(posX + 140, posY + 10, 86*(choice - 1) + 1, 172, 83, 83);
		
		if(choice == 1)
		{
			line1 = "Here is where some info";
			line2 = "about each piece goes, so";
			line3 = "they know what they're getting";
		}
		if(choice == 2)
		{
			line1 = "Sprint at enemies to";
			line2 = "do a little damage";
			line3 = "and send them flying.";
		}
		if(choice == 3)
		{
			line1 = "Notice how each tag is";
			line2 = "different. Not sure what";
			line3 = "this mask does yet...";
		}
		 String var34 = "Free Points: " + props.getCurrentHPoints();
	     var8.drawString(var34, (var6) / 2 - 117,  var7 / 2 + 70, 0);

		var8.drawString(line1, (var6) / 2 - 30,  var7 / 2 + 15, 0);
		var8.drawString(line2, (var6) / 2 - 30,  var7 / 2 + 25, 0);
		var8.drawString(line3, (var6) / 2 - 30,  var7 / 2 + 35, 0);

		
		super.drawScreen(x, y, f);
	}
	
	public void initGui() 
	{
		int posX = (this.width - xSizeOfTexture) / 2;
		int posY = (this.height - ySizeOfTexture) / 2;
		
		
			this.buttonList.add(new GuiButton(0, posX + 5, posY + 20, 80, 20, "Spitter Head"));
			this.buttonList.add(new GuiButton(1, posX + 5, posY + 70, 80, 20, "Horned Head"));
			this.buttonList.add(new GuiButton(2, posX + 5, posY + 120, 80, 20, "Hard Head"));
			this.buttonList.add(new GuiButton(3, posX + 110, posY + 145, 50, 20, "Accept"));
			this.buttonList.add(new GuiButton(4, posX + 200, posY + 145, 50, 20, "Cancel"));
			
			
		
	}

	EntityClientPlayerMP player = FMLClientHandler.instance().getClient().thePlayer;
	public void actionPerformed(GuiButton button) {
		switch(button.id) 
		{
		
		case 0:
				this.choice = 1;
		break;
		
		case 1: 
			this.choice = 2;
		break;
		
		case 2:
			this.choice = 3;
		break;
		case 3:
			BleachMod.network.sendToServer(new HollowPieceMessage(0, choice));
			((ExtendedPlayer)(thePlayer.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME))).setHead(choice);
			this.mc.displayGuiScreen((GuiScreen)null);
		break;
		case 4:
			this.mc.displayGuiScreen((GuiScreen)null);
    		FMLNetworkHandler.openGui(player, BleachMod.instance, 3, player.worldObj, (int)player.posX, (int)player.posY, (int)player.posZ);
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
