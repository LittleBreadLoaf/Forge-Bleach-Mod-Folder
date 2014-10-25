package littlebreadloaf.bleach.render.entity;

import littlebreadloaf.bleach.BleachModInfo;
import littlebreadloaf.bleach.entities.EntityCero;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderCero extends Render
{
	private static final ResourceLocation arrowTextures = new ResourceLocation(BleachModInfo.ID.toLowerCase() + ":textures/items/energyarrows.png");
	private static final ResourceLocation ceroTexture = new ResourceLocation(BleachModInfo.ID.toLowerCase() + ":textures/blocks/cero.png");

	public void renderCero(EntityCero par1EntityCero, double par2, double par4, double par6, float par8, float par9)
	{
		 if(par1EntityCero.startingX != 0 && par1EntityCero.startingY != 0 && par1EntityCero.startingZ != 0)
         {
		
			 	float f2 =  par9 + 0.8F;
	            float f3 = MathHelper.sin(f2 * 0.2F) / 2.0F + 0.5F;
	            f3 = (f3 * f3 + f3) * 0.2F;
	            float f4 = (float)(par1EntityCero.startingX  - par1EntityCero.posX - (par1EntityCero.prevPosX - par1EntityCero.posX) * (double)(1.0F - par9));
	            float f5 = (float)((double)f3 + par1EntityCero.startingY - 1.2D - par1EntityCero.posY - (par1EntityCero.prevPosY - par1EntityCero.posY) * (double)(1.0F - par9));
	            float f6 = (float)(par1EntityCero.startingZ - par1EntityCero.posZ - (par1EntityCero.prevPosZ - par1EntityCero.posZ) * (double)(1.0F - par9));
	            float f7 = MathHelper.sqrt_float(f4 * f4 + f6 * f6);
	            float f8 = MathHelper.sqrt_float(f4 * f4 + f5 * f5 + f6 * f6);
	            GL11.glPushMatrix();
	            GL11.glTranslatef((float)par2, (float)par4 + 2.0F, (float)par6);
	            GL11.glRotatef((float)(-Math.atan2((double)f6, (double)f4)) * 180.0F / (float)Math.PI - 90.0F, 0.0F, 1.0F, 0.0F);
	            GL11.glRotatef((float)(-Math.atan2((double)f7, (double)f5)) * 180.0F / (float)Math.PI - 90.0F, 1.0F, 0.0F, 0.0F);
	            Tessellator tessellator = Tessellator.instance;
	            RenderHelper.disableStandardItemLighting();
	            GL11.glDisable(GL11.GL_CULL_FACE);
	            this.bindTexture(ceroTexture);
	            GL11.glShadeModel(GL11.GL_SMOOTH);
	            float f9 = 0.0F - ((float)par1EntityCero.ticksExisted + par9) * 0.01F;
	            float f10 = MathHelper.sqrt_float(f4 * f4 + f5 * f5 + f6 * f6) / 32.0F - ((float)par1EntityCero.ticksExisted + par9) * 0.01F;
	            tessellator.startDrawing(5);
	            byte b0 = 8;

	            for (int i = 0; i <= b0; ++i)
	            {
	                float f11 = MathHelper.sin((float)(i % b0) * (float)Math.PI * 2.0F / (float)b0) * 0.75F;
	                float f12 = MathHelper.cos((float)(i % b0) * (float)Math.PI * 2.0F / (float)b0) * 0.75F;
	                float f13 = (float)(i % b0) * 1.0F / (float)b0;
	                tessellator.setColorOpaque_I(10223616);
	                tessellator.addVertexWithUV((double)(f11 * 0.2F), (double)(f12 * 0.2F), 0.0D, (double)f13, (double)f10);
	                tessellator.setColorOpaque_I(16777215);
	                tessellator.addVertexWithUV((double)f11, (double)f12, (double)f8, (double)f13, (double)f9);
	            }

	            tessellator.draw();
	            GL11.glEnable(GL11.GL_CULL_FACE);
	            GL11.glShadeModel(GL11.GL_FLAT);
	            RenderHelper.enableStandardItemLighting();
	            GL11.glPopMatrix();
	        }
		
         }
		

	

	protected ResourceLocation getArrowTextures(EntityCero par1EntityCero)
	{
		return arrowTextures;
	}

	protected ResourceLocation getEntityTexture(Entity par1Entity)
	{
		return this.getArrowTextures((EntityCero) par1Entity);
	}

	/**
	 * Actually renders the given argument. This is a synthetic bridge method,
	 * always casting down its argument and then handing it off to a worker
	 * function which does the actual work. In all probabilty, the class Render
	 * is generic (Render<T extends Entity) and this method has signature public
	 * void doRender(T entity, double d, double d1, double d2, float f, float
	 * f1). But JAD is pre 1.5 so doesn't do that.
	 */
	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
	{
		this.renderCero((EntityCero) par1Entity, par2, par4, par6, par8, par9);
		this.renderLine((EntityCero)par1Entity, par2, par4, par6, par8, par9);
	}

	private void renderLine(EntityCero par1Entity, double par2, double par4, double par6, float par8, float par9) 
	{
		 
		
	}
	
	
	 private double func_110828_a(double par1, double par3, double par5)
	    {
	        return par1 + (par3 - par1) * par5;
	    }
}