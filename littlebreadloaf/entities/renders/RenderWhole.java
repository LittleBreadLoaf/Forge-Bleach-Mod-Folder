package littlebreadloaf.entities.renders;

import littlebreadloaf.entities.classes.EntityDecoy;
import littlebreadloaf.entities.classes.EntityWhole;
import littlebreadloaf.entities.models.ModelWhole;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderWhole extends RenderLiving
{
	private static final ResourceLocation texture1 = new ResourceLocation("lblbm:textures/models/mobs/whole.png");
	private static final ResourceLocation texture2 = new ResourceLocation("lblbm:textures/models/mobs/whole1.png");
	private static final ResourceLocation texture3 = new ResourceLocation("lblbm:textures/models/mobs/whole2.png");
	private static final ResourceLocation texture4 = new ResourceLocation("lblbm:textures/models/mobs/whole3.png");
	private static final ResourceLocation texture5 = new ResourceLocation("lblbm:textures/models/mobs/whole4.png");
	private static final ResourceLocation texture6 = new ResourceLocation("lblbm:textures/models/mobs/whole5.png");
	private static final ResourceLocation texture7 = new ResourceLocation("lblbm:textures/models/mobs/whole6.png");
	private static final ResourceLocation texture8 = new ResourceLocation("lblbm:textures/models/mobs/whole7.png");
	private static final ResourceLocation texture9 = new ResourceLocation("lblbm:textures/models/mobs/whole8.png");
	private static final ResourceLocation texture10 = new ResourceLocation("lblbm:textures/models/mobs/whole9.png");
	protected ModelWhole model;

	public RenderWhole(ModelBase par1ModelBase, float par2) 
	{
		super(par1ModelBase, par2);
		model = ((ModelWhole)mainModel);
	}
	
	public void renderWhole(EntityWhole par1, double par2, double par3, double par4, float par5, float par6)
	{
		super.doRenderLiving(par1, par2, par3, par4, par5, par6);
	}
	
	public void doRenderLiving(EntityLiving par1, double par2, double par3, double par4, float par5, float par6)
	{
		this.renderWhole((EntityWhole)par1, par2, par3, par4, par5, par6);
	}
	
	@Override
	public void doRender(Entity par1, double par2, double par3, double par4, float par5, float par6)
	{
		this.renderWhole((EntityWhole)par1, par2, par3, par4, par5, par6);
	}

	
	protected ResourceLocation getEntityTexture(Entity entity) 
	{
		switch (((EntityWhole) entity).getTexture())
        {
		case 0:
			return texture2;
		case 1:
			return texture3;
		case 2:
			return texture4;
		case 3:
			return texture5;
		case 4:
			return texture6;
		case 5:
			return texture7;
		case 6:
			return texture8;
		case 7:
			return texture9;
		case 8:
			return texture10;
			default:
				return texture1;
		
        }
	}



}
