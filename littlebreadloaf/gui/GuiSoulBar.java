package littlebreadloaf.gui;

import littlebreadloaf.events.ExtendedPlayer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.event.EventPriority;
import net.minecraftforge.event.ForgeSubscribe;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiSoulBar extends Gui
{
	private Minecraft mc;
	private static final ResourceLocation texture = new ResourceLocation("lblbm", "textures/guis/spirit_bar.png");
	
	public GuiSoulBar(Minecraft mc)
	{
		super();
		this.mc = mc;
	}
	
	@ForgeSubscribe(priority = EventPriority.NORMAL)
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
		this.mc.func_110434_K().func_110577_a(texture);
        FontRenderer var8 = this.mc.fontRenderer;
		
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
        this.mc.mcProfiler.endSection();
	}

}
