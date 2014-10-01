package littlebreadloaf.bleach.gui.hollow;

import java.util.Random;

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

public class GuiColorSelect extends GuiScreen {

	Random rand = new Random();
	ResourceLocation texture = new ResourceLocation(BleachModInfo.ID.toLowerCase(), "textures/guis/color_select_gui.png");
	public final int xSizeOfTexture = 256;
	public final int ySizeOfTexture = 171;
	
	EntityPlayer thePlayer;
	
	ExtendedPlayer props;
	
	
	private int id = -1;
	private int choice = rand.nextInt(16);
	
	String line1;
	String line2;
	String line3;
	
	public GuiColorSelect(EntityPlayer player) 
	{
		this.thePlayer = player;
		props = ExtendedPlayer.get(player);
	}
	 public static final float[][] colorTable = new float[][] {{1.0F, 1.0F, 1.0F}, {0.85F, 0.5F, 0.2F}, {0.7F, 0.3F, 0.85F}, {0.4F, 0.6F, 0.85F}, {0.9F, 0.9F, 0.2F}, {0.5F, 0.8F, 0.1F}, {0.95F, 0.5F, 0.65F}, {0.3F, 0.3F, 0.3F}, {0.6F, 0.6F, 0.6F}, {0.3F, 0.5F, 0.6F}, {0.5F, 0.25F, 0.7F}, {0.2F, 0.3F, 0.7F}, {0.4F, 0.3F, 0.2F}, {0.4F, 0.5F, 0.2F}, {0.6F, 0.2F, 0.2F}, {0.1F, 0.1F, 0.1F}};
		
	@Override
	public void drawScreen(int x, int y, float f) {
		drawDefaultBackground();
		
		
		 GL11.glColor3f(colorTable[choice][0], colorTable[choice][1], colorTable[choice][2]);

		ScaledResolution var5 = new ScaledResolution(this.mc.gameSettings, this.mc.displayWidth, this.mc.displayHeight);
        int var6 = var5.getScaledWidth();
        int var7 = var5.getScaledHeight();
        FontRenderer var8 = this.mc.fontRenderer;
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);

		int posX = (this.width - xSizeOfTexture) / 2;
		int posY = (this.height - ySizeOfTexture) / 2;
		drawTexturedModalRect(posX, posY, 0, 0, xSizeOfTexture, ySizeOfTexture);
		drawTexturedModalRect(posX + 140, posY + 10, 86*(choice - 1) + 1, 172, 83, 83);
		
		
		
		super.drawScreen(x, y, f);
	}
	
	public void initGui() 
	{
		int posX = (this.width - xSizeOfTexture) / 2;
		int posY = (this.height - ySizeOfTexture) / 2;
		
		
			this.buttonList.add(new GuiButton(0, posX + 5, posY + 60, 80, 20, "Randomize"));
			
			this.buttonList.add(new GuiButton(1, posX + 110, posY + 145, 50, 20, "Accept"));
			this.buttonList.add(new GuiButton(2, posX + 200, posY + 145, 50, 20, "Cancel"));
			
			
		
	}

	EntityClientPlayerMP player = FMLClientHandler.instance().getClient().thePlayer;
	public void actionPerformed(GuiButton button) {
		switch(button.id) 
		{
		
		case 0:
				this.choice = rand.nextInt(16);
				
		break;
		case 1:
			BleachMod.network.sendToServer(new HollowPieceMessage(5, choice));
			((ExtendedPlayer)(thePlayer.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME))).setBack(choice);
			this.mc.displayGuiScreen((GuiScreen)null);
		break;
		case 2:
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
