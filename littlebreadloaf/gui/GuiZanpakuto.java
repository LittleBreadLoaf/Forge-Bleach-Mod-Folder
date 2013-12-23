package littlebreadloaf.gui;

import littlebreadloaf.events.ExtendedPlayer;
import littlebreadloaf.libraries.BleachModInfo;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class GuiZanpakuto extends GuiScreen
{
	public final int guiWidth = 248;//the gui width
	public final int guiHeight = 166;//the gui height
	public static final ResourceLocation texture = new ResourceLocation(BleachModInfo.ID.toLowerCase(), "textures/guis/sword_gui.png");
	
	public void drawScreen(int x, int y, float f)//draws the gui
	{

			this.mc.getTextureManager().bindTexture(texture);
			ScaledResolution var5 = new ScaledResolution(this.mc.gameSettings, this.mc.displayWidth, this.mc.displayHeight);
			int var6 = var5.getScaledWidth();
			int var7 = var5.getScaledHeight();
	        FontRenderer var8 = this.mc.fontRenderer;

			drawDefaultBackground();
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

			ExtendedPlayer props = (ExtendedPlayer) mc.thePlayer.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);
			this.mc.mcProfiler.startSection("swordgui");
            int var233 = var7 / 2 - 90;
            int var181 = 0;
			this.drawTexturedModalRect(var181 + 10, var233 + 18, 0, 0, 41, 152);
			super.drawScreen(x, y, f);//super invoke

			this.mc.mcProfiler.endStartSection("Flame");
            boolean var11 = false;
            int var12 = var11 ? 16777215 : 15859712;
            String var34 = "" + (int)(props.getPoints(1));
            int var182 = 33;
            var8.drawString(var34, var182 - 4, var233 + 26, 0);
            var8.drawString(var34, var182 - 2, var233 + 26, 0);
            var8.drawString(var34, var182 - 3, var233 + 25, 0);
            var8.drawString(var34, var182 - 3, var233 + 27, 0);
            var8.drawString(var34, var182 - 3, var233 + 26, var12);
            
            this.mc.mcProfiler.endStartSection("Name");
            String var35 = props.getName();
            int var189 = (int) (var8.getStringWidth(var35) * 0.5);
            var8.drawString(var35, var181 + 33 - var189, var233 + 13, 0);
            var8.drawString(var35, var181 + 31 - var189, var233 + 13, 0);
            var8.drawString(var35, var181 + 32 - var189, var233 + 12, 0);
            var8.drawString(var35, var181 + 32 - var189, var233 + 14, 0);
            var8.drawString(var35, var181 + 32 - var189, var233 + 13, 16777215);
            
            
            this.mc.mcProfiler.endStartSection("Ice");
            var12 = var11 ? 16777215 : 4097012;
            var34 = "" + (int)(props.getPoints(2));
            var182 =  33;
            var8.drawString(var34, var182 - 4, var233 + 40, 0);
            var8.drawString(var34, var182 - 2, var233 + 40, 0);
            var8.drawString(var34, var182 - 3, var233 + 39, 0);
            var8.drawString(var34, var182 - 3, var233 + 41, 0);
            var8.drawString(var34, var182 - 3, var233 + 40, var12);
            
            
            this.mc.mcProfiler.endStartSection("Poison");
            var12 = var11 ? 16777215 : 946176;
            var34 = "" + (int)(props.getPoints(4));
            var182 = 33;
            var8.drawString(var34, var182 - 4, var233 + 54, 0);
            var8.drawString(var34, var182 - 2, var233 + 54, 0);
            var8.drawString(var34, var182 - 3, var233 + 53, 0);
            var8.drawString(var34, var182 - 3, var233 + 55, 0);
            var8.drawString(var34, var182 - 3, var233 + 54, var12);
            
            
            this.mc.mcProfiler.endStartSection("Heal");
            var12 = var11 ? 16777215 : 12320839;
            var34 = "" + (int)(props.getPoints(3));
            var182 = 33;
            var8.drawString(var34, var182 - 4, var233 + 68, 0);
            var8.drawString(var34, var182 - 2, var233 + 68, 0);
            var8.drawString(var34, var182 - 3, var233 + 67, 0);
            var8.drawString(var34, var182 - 3, var233 + 69, 0);
            var8.drawString(var34, var182 - 3, var233 + 68, var12);
            
            
            this.mc.mcProfiler.endStartSection("Earth");
            var12 = var11 ? 16777215 : 6697728;
            var34 = "" + (int)(props.getPoints(5));
            var182 = 33;
            var8.drawString(var34, var182 - 4, var233 + 82, 0);
            var8.drawString(var34, var182 - 2, var233 + 82, 0);
            var8.drawString(var34, var182 - 3, var233 + 81, 0);
            var8.drawString(var34, var182 - 3, var233 + 83, 0);
            var8.drawString(var34, var182 - 3, var233 + 82, var12);
            
            
            this.mc.mcProfiler.endStartSection("Wind");
            var12 = var11 ? 16777215 : 15656414;
            var34 = "" + (int)(props.getPoints(6));
            var182 = 33;
            var8.drawString(var34, var182 - 4, var233 + 96, 0);
            var8.drawString(var34, var182 - 2, var233 + 96, 0);
            var8.drawString(var34, var182 - 3, var233 + 95, 0);
            var8.drawString(var34, var182 - 3, var233 + 97, 0);
            var8.drawString(var34, var182 - 3, var233 + 96, var12);
            
            
            this.mc.mcProfiler.endStartSection("Light");
            var12 = var11 ? 16777215 : 16777062;
            var34 = "" + (int)(props.getPoints(7));
            var182 = 33;
            var8.drawString(var34, var182 - 4, var233 + 110, 0);
            var8.drawString(var34, var182 - 2, var233 + 110, 0);
            var8.drawString(var34, var182 - 3, var233 + 109, 0);
            var8.drawString(var34, var182 - 3, var233 + 111, 0);
            var8.drawString(var34, var182 - 3, var233 + 110, var12);
            
            
            this.mc.mcProfiler.endStartSection("Dark");
            var12 = var11 ? 16777215 : 3342438;
            var34 = "" + (int)(props.getPoints(8));
            var182 = 33;
            var8.drawString(var34, var182 - 4, var233 + 124, 0);
            var8.drawString(var34, var182 - 2, var233 + 124, 0);
            var8.drawString(var34, var182 - 3, var233 + 123, 0);
            var8.drawString(var34, var182 - 3, var233 + 125, 0);
            var8.drawString(var34, var182 - 3, var233 + 124, var12);
            
            
            this.mc.mcProfiler.endStartSection("Total");
            var12 = var11 ? 16777215 : 16777215;
            var34 = "" + (int)(props.getPoints(9));
            var182 = 33;
            var8.drawString(var34, var182 - 4, var233 + 137, 0);
            var8.drawString(var34, var182 - 2, var233 + 137, 0);
            var8.drawString(var34, var182 - 3, var233 + 136, 0);
            var8.drawString(var34, var182 - 3, var233 + 138, 0);
            var8.drawString(var34, var182 - 3, var233 + 137, var12);
	}

}