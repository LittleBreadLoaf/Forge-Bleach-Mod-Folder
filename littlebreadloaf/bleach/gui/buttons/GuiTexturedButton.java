package littlebreadloaf.bleach.gui.buttons;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiTexturedButton extends GuiButton
{
    private static ResourceLocation buttonTextures = new ResourceLocation("textures/gui/widgets.png");

    protected int width;

    protected int height;

    public int xPosition;

    public int yPosition;

    public String displayString;

    public int id;

    public boolean enabled;

    public boolean drawButton;
    protected boolean field_82253_i;

    public GuiTexturedButton(int id, int xPosition, int yPosition, String text, ResourceLocation textureLocation)
    {
        this(id, xPosition, yPosition, 200, 20, text, textureLocation);
    }

    public GuiTexturedButton(int id, int xPosition, int yPosition, int width, int height, String text, ResourceLocation textureLocation)
    {
    	super(id, xPosition, yPosition, width, height, text);
        this.width = width;
        this.height = height;
        this.enabled = true;
        this.drawButton = true;
        this.id = id;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.width = width;
        this.height = height;
        this.displayString = text;
        this.buttonTextures = textureLocation;
    }

    protected int getHoverState(boolean par1)
    {
        return 1;
    }

    public void drawButton(Minecraft par1Minecraft, int par2, int par3)
    {
        if (this.drawButton)
        {
            FontRenderer fontrenderer = par1Minecraft.fontRenderer;
            par1Minecraft.getTextureManager().bindTexture(buttonTextures);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            this.field_82253_i = par2 >= this.xPosition && par3 >= this.yPosition && par2 < this.xPosition + this.width && par3 < this.yPosition + this.height;
            int k = this.getHoverState(this.field_82253_i);
            this.drawTexturedModalRect(this.xPosition, this.yPosition, 0, 46 + k * 20, this.width / 2, this.height);
            this.drawTexturedModalRect(this.xPosition + this.width / 2, this.yPosition, 200 - this.width / 2, 46 + k * 20, this.width / 2, this.height);
            this.mouseDragged(par1Minecraft, par2, par3);
            int l = 14737632;

            if (!this.enabled)
            {
                l = -6250336;
            }
            else if (this.field_82253_i)
            {
                l = 16777120;
            }

            this.drawCenteredString(fontrenderer, this.displayString, this.xPosition + this.width / 2, this.yPosition + (this.height - 8) / 2, l);
        }
    }

    protected void mouseDragged(Minecraft par1Minecraft, int par2, int par3) {}

    public void mouseReleased(int par1, int par2) {}

    public boolean mousePressed(Minecraft par1Minecraft, int par2, int par3)
    {
        return this.enabled && this.drawButton && par2 >= this.xPosition && par3 >= this.yPosition && par2 < this.xPosition + this.width && par3 < this.yPosition + this.height;
    }

    public boolean func_82252_a()
    {
        return this.field_82253_i;
    }

    public void func_82251_b(int par1, int par2) {}
}