package littlebreadloaf.bleach.render.entity;

import littlebreadloaf.bleach.BleachModInfo;
import littlebreadloaf.bleach.entities.EntityHollowWasp;
import littlebreadloaf.bleach.render.models.ModelHollowWasp;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderHollowWasp extends RenderLiving
{
	private static final ResourceLocation texture1 = new ResourceLocation(BleachModInfo.ID.toLowerCase() + ":textures/models/mobs/hollow_wasp.png");
	private static final ResourceLocation texture2 = new ResourceLocation(BleachModInfo.ID.toLowerCase() + ":textures/models/mobs/hollow_wasp2.png");
	private static final ResourceLocation texture3 = new ResourceLocation(BleachModInfo.ID.toLowerCase() + ":textures/models/mobs/hollow_wasp3.png");
	private static final ResourceLocation texture4 = new ResourceLocation(BleachModInfo.ID.toLowerCase() + ":textures/models/mobs/hollow_wasp4.png");
	protected ModelHollowWasp model;

	public RenderHollowWasp(ModelBase par1ModelBase, float par2)
	{
		super(par1ModelBase, par2);
		model = ((ModelHollowWasp) mainModel);
	}

	public void renderHollowWasp(EntityHollowWasp par1, double par2, double par3, double par4, float par5, float par6)
	{
		super.doRender((EntityLiving)par1, par2, par3, par4, par5, par6);
	}



	@Override
	public void doRender(Entity par1, double par2, double par3, double par4, float par5, float par6)
	{
		this.renderHollowWasp((EntityHollowWasp) par1, par2, par3, par4, par5, par6);
	}

	protected ResourceLocation getEntityTexture(Entity entity)
	{
		switch (((EntityHollowWasp) entity).getTexture())
		{
			case 0:
				return texture2;
			case 1:
				return texture3;
			case 2:
				return texture4;
			default:
				return texture1;

		}
	}

}
