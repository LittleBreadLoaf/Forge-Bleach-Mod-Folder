package littlebreadloaf.entities.renders;

import littlebreadloaf.entities.classes.EntityHollowBat;
import littlebreadloaf.entities.classes.EntityHollowBlaze;
import littlebreadloaf.entities.models.ModelHollowBat;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderHollowBat extends RenderLiving
{
	private static final ResourceLocation texture1 = new ResourceLocation("lblbm:textures/models/mobs/hollow_bat.png");
	private static final ResourceLocation texture2 = new ResourceLocation("lblbm:textures/models/mobs/hollow_bat2.png");
	private static final ResourceLocation texture3 = new ResourceLocation("lblbm:textures/models/mobs/hollow_bat3.png");
	protected ModelHollowBat model;

	public RenderHollowBat(ModelBase par1ModelBase, float par2) 
	{
		super(par1ModelBase, par2);
		model = ((ModelHollowBat)mainModel);
	}
	
	public void renderHollowBat(EntityHollowBat par1, double par2, double par3, double par4, float par5, float par6)
	{
		super.doRenderLiving(par1, par2, par3, par4, par5, par6);
	}
	
	public void doRenderLiving(EntityLiving par1, double par2, double par3, double par4, float par5, float par6)
	{
		this.renderHollowBat((EntityHollowBat)par1, par2, par3, par4, par5, par6);
	}
	
	@Override
	public void doRender(Entity par1, double par2, double par3, double par4, float par5, float par6)
	{
		this.renderHollowBat((EntityHollowBat)par1, par2, par3, par4, par5, par6);
	}

	

	protected ResourceLocation getEntityTexture(Entity entity) 
	{
		switch (((EntityHollowBat) entity).getTexture())
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
