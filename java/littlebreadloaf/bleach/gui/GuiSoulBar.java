package littlebreadloaf.bleach.gui;

import littlebreadloaf.bleach.BleachModInfo;
import littlebreadloaf.bleach.events.ExtendedPlayer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiSoulBar extends Gui
{
	private Minecraft mc;
	private static final ResourceLocation texture = new ResourceLocation(BleachModInfo.ID.toLowerCase(), "textures/guis/spirit_bar.png");
	
	public GuiSoulBar(Minecraft mc)
	{
		super();
		this.mc = mc;
	}
	
	@SubscribeEvent
	public void onRenderExperienceBar(RenderGameOverlayEvent event)
	{
		ScaledResolution var5 = new ScaledResolution(this.mc.gameSettings, this.mc.displayWidth, this.mc.displayHeight);
        int var6 = var5.getScaledWidth();
        int var7 = var5.getScaledHeight();
        int var233 = var7 / 2 - 63;
        int var181 = var6 - 12;
        
		if(event.isCancelable() || event.type != ElementType.EXPERIENCE)
		{
			return;
		}
		
		ExtendedPlayer props = (ExtendedPlayer)this.mc.thePlayer.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);
		
		if(props == null || props.getCurrentCap() == 0)
		{
			return;
		}
		
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glDisable(GL11.GL_LIGHTING);
		this.mc.getTextureManager().bindTexture(texture);
        FontRenderer var8 = this.mc.fontRenderer;
		
        if (props.getFaction() == 1 || props.getFaction() == 2)
        {
		int var111 = var7;
        short var21 = 91;
        int var22 = (int)(props.getCurrentEnergy() * (float)(var21 + 1));
        int var29 = 91 - var22;
        this.drawTexturedModalRect(var181, var233, 0, 84, 10, var21);
        this.drawTexturedModalRect(var181, var233 + var29, 10, 84 + var29, 10, 91);
        
        this.mc.mcProfiler.endStartSection("SoulLevel");
        int var12 =  1953999;
        String var34 = "" + (int)(props.getCurrentEnergy() * props.getCurrentCap());
        int var182 = (var6 - var8.getStringWidth(var34)) + 10;
        var8.drawString(var34, var182 - 10, var233 + 43, 0);
        var8.drawString(var34, var182 - 12, var233 + 43, 0);
        var8.drawString(var34, var182 - 11, var233 + 42, 0);
        var8.drawString(var34, var182 - 11, var233 + 44, 0);
        var8.drawString(var34, var182 - 11, var233 + 43, var12);
        }
        //this.mc.mcProfiler.endStartSection("MaskBar");
        //String MaskTime = "" + (int)(props.getMaskTime()) * props.getMaskTimeCap();
        //int var180 = (var6 - var8.getStringWidth(MaskTime)) - 10;
        //int Color = props.getMaskColor();
        //var8.drawString(MaskTime, var180 - 10, var233 + 43, 0);
        //var8.drawString(MaskTime, var180 - 12, var233 + 43, 0);
        //var8.drawString(MaskTime, var180 - 11, var233 + 42, 0);
        //var8.drawString(MaskTime, var180 - 11, var233 + 44, 0);
        //var8.drawString(MaskTime, var180 - 11, var233 + 43, Color);
        //this.mc.mcProfiler.endSection();

       
            this.mc.mcProfiler.startSection("isShinigami");
            boolean flag1 = false;
            int i2 =  1953999;
            String s;
            if (props.getFaction() == 1)
            {
            	s = "Shinigami";
            }
            else if (props.getFaction() == 2)
            {
            	s = "Quincy";
            }
            else
            {
            	s = "Human";
            }
            int l2 = (var6 - var8.getStringWidth(s)) / 2;
            int k2 = 5;
            boolean flag2 = false;
            var8.drawString(s, l2 + 1, k2, 0);
            var8.drawString(s, l2 - 1, k2, 0);
            var8.drawString(s, l2, k2 + 1, 0);
            var8.drawString(s, l2, k2 - 1, 0);
            var8.drawString(s, l2, k2, i2);
            this.mc.mcProfiler.endSection();
        
	}

}
