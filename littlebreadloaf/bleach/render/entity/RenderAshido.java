package littlebreadloaf.bleach.render.entity;

import littlebreadloaf.bleach.BleachModInfo;
import littlebreadloaf.bleach.entities.EntityAshido;
import littlebreadloaf.bleach.render.models.ModelAshido;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderAshido extends RenderLiving
{
	private static final ResourceLocation texture1 = new ResourceLocation(BleachModInfo.ID.toLowerCase() + ":textures/models/mobs/ashido.png");
	protected ModelAshido model;
	

	public RenderAshido(ModelBase par1ModelBase, float par2)
	{
		super(par1ModelBase, par2);
		model = ((ModelAshido) mainModel);
	}

	public void renderAshido(EntityAshido par1, double par2, double par3, double par4, float par5, float par6)
	{
		super.doRenderLiving(par1, par2, par3, par4, par5, par6);
	}

	public void doRenderLiving(EntityLiving par1, double par2, double par3, double par4, float par5, float par6)
	{
		this.renderAshido((EntityAshido) par1, par2, par3, par4, par5, par6);
	}

	@Override
	public void doRender(Entity par1, double par2, double par3, double par4, float par5, float par6)
	{
		this.renderAshido((EntityAshido) par1, par2, par3, par4, par5, par6);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		
				return texture1;

		
	}

}
