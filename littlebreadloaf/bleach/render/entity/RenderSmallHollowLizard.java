package littlebreadloaf.bleach.render.entity;

import org.lwjgl.opengl.GL11;

import littlebreadloaf.bleach.BleachModInfo;
import littlebreadloaf.bleach.entities.EntitySmallHollowLizard;
import littlebreadloaf.bleach.render.models.ModelSmallHollowLizard;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class RenderSmallHollowLizard extends RenderLiving
{
	private static final ResourceLocation texture1 = new ResourceLocation(BleachModInfo.ID.toLowerCase() + ":textures/models/mobs/hollow_lizard_small.png");
	private static final ResourceLocation texture2 = new ResourceLocation(BleachModInfo.ID.toLowerCase() + ":textures/models/mobs/hollow_lizard_small2.png");
	private static final ResourceLocation texture3 = new ResourceLocation(BleachModInfo.ID.toLowerCase() + ":textures/models/mobs/hollow_lizard_small3.png");
	protected ModelSmallHollowLizard model;

	public RenderSmallHollowLizard(ModelBase par1ModelBase, float par2)
	{
		super(par1ModelBase, par2);
		model = ((ModelSmallHollowLizard) mainModel);
	}

	public void renderSmallHollowLizard(EntitySmallHollowLizard par1, double par2, double par3, double par4, float par5, float par6)
	{
		
		super.doRenderLiving(par1, par2, par3, par4, par5, par6);
	}

	@Override
	public void doRenderLiving(EntityLiving par1, double par2, double par3, double par4, float par5, float par6)
	{
		
		this.renderSmallHollowLizard((EntitySmallHollowLizard) par1, par2, par3, par4, par5, par6);
		
	}

	@Override
	public void doRender(Entity par1, double par2, double par3, double par4, float par5, float par6)
	{
		
		this.renderSmallHollowLizard((EntitySmallHollowLizard) par1, par2, par3, par4, par5, par6);
	}

	  /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
	@Override
    protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2)
    {
        this.scaleLizard((EntitySmallHollowLizard)par1EntityLivingBase, par2);
    }
    
    protected void scaleLizard(EntitySmallHollowLizard par1, float par2)
    {
        GL11.glScalef(0.4F, 0.4F, 0.4F);
    }
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		switch (((EntitySmallHollowLizard) entity).getTexture())
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
