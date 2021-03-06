package littlebreadloaf.bleach.render.entity;

import org.lwjgl.opengl.GL11;

import littlebreadloaf.bleach.BleachModInfo;
import littlebreadloaf.bleach.entities.EntityHollowSpider;
import littlebreadloaf.bleach.entities.EntitySmallHollowLizard;
import littlebreadloaf.bleach.render.models.ModelHollowSpider;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class RenderHollowSpider extends RenderLiving
{
	private static final ResourceLocation texture1 = new ResourceLocation(BleachModInfo.ID.toLowerCase() + ":textures/models/mobs/hollow_spider.png");
	private static final ResourceLocation texture2 = new ResourceLocation(BleachModInfo.ID.toLowerCase() + ":textures/models/mobs/hollow_spider2.png");
	private static final ResourceLocation texture3 = new ResourceLocation(BleachModInfo.ID.toLowerCase() + ":textures/models/mobs/hollow_spider3.png");
	protected ModelHollowSpider model;

	public RenderHollowSpider(ModelBase par1ModelBase, float par2)
	{
		super(par1ModelBase, par2);
		model = ((ModelHollowSpider) mainModel);
	}

	public void renderHollowSpider(EntityHollowSpider par1, double par2, double par3, double par4, float par5, float par6)
	{
		super.doRender((EntityLiving)par1, par2, par3, par4, par5, par6);
	}

	

	@Override
	public void doRender(Entity par1, double par2, double par3, double par4, float par5, float par6)
	{
		this.renderHollowSpider((EntityHollowSpider) par1, par2, par3, par4, par5, par6);
	}

	
	  /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
	@Override
    protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2)
    {
        this.scaleSpider((EntityHollowSpider)par1EntityLivingBase, par2);
    }
    
    protected void scaleSpider(EntityHollowSpider par1, float par2)
    {
        GL11.glScalef(1.7F, 1.7F, 1.7F);
    }
    
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		switch (((EntityHollowSpider) entity).getTexture())
		{
			case 0:
				return texture2;
			case 1:
				return texture3;
			default:
				return texture1;

		}
	}

}
