package littlebreadloaf.bleach.gui.hollow;

import littlebreadloaf.bleach.BleachMod;
import littlebreadloaf.bleach.BleachModInfo;
import littlebreadloaf.bleach.events.ExtendedPlayer;
import littlebreadloaf.bleach.network.FlashMessage;
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

public class GuiHollowSelect extends GuiScreen {

	ResourceLocation texture = new ResourceLocation(BleachModInfo.ID.toLowerCase(), "textures/guis/hollow_select_gui.png");
	public final int xSizeOfTexture = 256;
	public final int ySizeOfTexture = 171;
	
	EntityPlayer thePlayer;
	
	ExtendedPlayer props;
	
	
	private int id = -1;
	
	public GuiHollowSelect(EntityPlayer player) 
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

        String var34 = "Free Points: " + props.getCurrentHPoints();
        String var35 = "Hollow Evolution";
        var8.drawString(var34, (var6 - var8.getStringWidth(var34)) / 2,  var7 / 2 + 70, 0);

        var8.drawString(var35, (var6 - var8.getStringWidth(var34)) / 2 + 1,  var7 / 2 - 70, 0);
        var8.drawString(var35, (var6 - var8.getStringWidth(var34)) / 2 - 1,  var7 / 2 - 70, 0);
        var8.drawString(var35, (var6 - var8.getStringWidth(var34)) / 2,  var7 / 2 - 69, 0);
        var8.drawString(var35, (var6 - var8.getStringWidth(var34)) / 2,  var7 / 2 - 71, 0);
        var8.drawString(var35, (var6 - var8.getStringWidth(var34)) / 2,  var7 / 2 - 70, 1953999);
		super.drawScreen(x, y, f);
	}
	
	public void initGui() 
	{
		int posX = (this.width - xSizeOfTexture) / 2;
		int posY = (this.height - ySizeOfTexture) / 2;
		
		
			this.buttonList.add(new GuiButton(0, posX + 190, posY + 5, 50, 20, "Head"));
			this.buttonList.add(new GuiButton(1, posX + 15, posY + 15, 50, 20, "Torso"));
			this.buttonList.add(new GuiButton(2, posX + 200, posY + 55, 50, 20, "Arms"));
			this.buttonList.add(new GuiButton(3, posX + 10, posY + 60, 50, 20, "Tail"));
			this.buttonList.add(new GuiButton(4, posX + 15, posY + 125, 50, 20, "Legs"));
			this.buttonList.add(new GuiButton(5, posX + 190, posY + 130, 50, 20, "Color"));
		
	}

	EntityClientPlayerMP player = FMLClientHandler.instance().getClient().thePlayer;
	public void actionPerformed(GuiButton button) {
		switch(button.id) 
		{
		
		case 0:
				
				this.mc.displayGuiScreen((GuiScreen)null);
	    		FMLNetworkHandler.openGui(player, BleachMod.instance, 4, player.worldObj, (int)player.posX, (int)player.posY, (int)player.posZ);
		break;
		
		case 1: 
			this.mc.displayGuiScreen((GuiScreen)null);
    		FMLNetworkHandler.openGui(player, BleachMod.instance, 5, player.worldObj, (int)player.posX, (int)player.posY, (int)player.posZ);
		break;
		
		case 2: 
			this.mc.displayGuiScreen((GuiScreen)null);
    		FMLNetworkHandler.openGui(player, BleachMod.instance, 10, player.worldObj, (int)player.posX, (int)player.posY, (int)player.posZ);
		break;
		
		case 3:
			this.mc.displayGuiScreen((GuiScreen)null);
    		FMLNetworkHandler.openGui(player, BleachMod.instance, 7, player.worldObj, (int)player.posX, (int)player.posY, (int)player.posZ);
		break;
		case 4:
			this.mc.displayGuiScreen((GuiScreen)null);
    		FMLNetworkHandler.openGui(player, BleachMod.instance, 8, player.worldObj, (int)player.posX, (int)player.posY, (int)player.posZ);
		break;
		case 5:
			this.mc.displayGuiScreen((GuiScreen)null);
    		FMLNetworkHandler.openGui(player, BleachMod.instance, 9, player.worldObj, (int)player.posX, (int)player.posY, (int)player.posZ);
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
