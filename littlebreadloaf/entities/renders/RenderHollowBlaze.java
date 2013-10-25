package littlebreadloaf.entities.renders;

import littlebreadloaf.entities.classes.EntityHollowBlaze;
import littlebreadloaf.entities.models.ModelHollowBlaze;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderHollowBlaze extends RenderLiving
{
	private static final ResourceLocation texture1 = new ResourceLocation("lblbm:textures/models/mobs/hollow_blaze.png");
	private static final ResourceLocation texture2 = new ResourceLocation("lblbm:textures/models/mobs/hollow_blaze2.png");
	private static final ResourceLocation texture3 = new ResourceLocation("lblbm:textures/models/mobs/hollow_blaze3.png");
	protected ModelHollowBlaze model;

	public RenderHollowBlaze(ModelBase par1ModelBase, float par2) 
	{
		super(par1ModelBase, par2);
		model = ((ModelHollowBlaze)mainModel);
	}
	
	public void renderHollowBlaze(EntityHollowBlaze par1, double par2, double par3, double par4, float par5, float par6)
	{
		super.doRenderLiving(par1, par2, par3, par4, par5, par6);
	}
	
	public void doRenderLiving(EntityLiving par1, double par2, double par3, double par4, float par5, float par6)
	{
		this.renderHollowBlaze((EntityHollowBlaze)par1, par2, par3, par4, par5, par6);
	}
	
	@Override
	public void doRender(Entity par1, double par2, double par3, double par4, float par5, float par6)
	{
		this.renderHollowBlaze((EntityHollowBlaze)par1, par2, par3, par4, par5, par6);
	}

	

	protected ResourceLocation func_110775_a(Entity entity) 
	{
		switch (((EntityHollowBlaze) entity).getTexture())
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
