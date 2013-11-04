package littlebreadloaf.entities.renders;

import littlebreadloaf.entities.classes.EntityMenosGrande;
import littlebreadloaf.entities.models.ModelMenosGrande;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderMenosGrande extends RenderLiving
{
	private static final ResourceLocation texture = new ResourceLocation("lblbm:textures/models/mobs/menos.png");
	protected ModelMenosGrande model;

	public RenderMenosGrande(ModelBase par1ModelBase, float par2) 
	{
		super(par1ModelBase, par2);
		model = ((ModelMenosGrande)mainModel);
	}
	
	public void renderMenosGrande(EntityMenosGrande par1, double par2, double par3, double par4, float par5, float par6)
	{
		super.doRenderLiving(par1, par2, par3, par4, par5, par6);
	}
	
	public void doRenderLiving(EntityLiving par1, double par2, double par3, double par4, float par5, float par6)
	{
		this.renderMenosGrande((EntityMenosGrande)par1, par2, par3, par4, par5, par6);
	}
	
	@Override
	public void doRender(Entity par1, double par2, double par3, double par4, float par5, float par6)
	{
		this.renderMenosGrande((EntityMenosGrande)par1, par2, par3, par4, par5, par6);
	}

	

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) 
	{
		return texture;
	}



}
