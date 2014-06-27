package littlebreadloaf.bleach.render.entity;

import littlebreadloaf.bleach.BleachModInfo;
import littlebreadloaf.bleach.entities.EntityHollowStalker;
import littlebreadloaf.bleach.render.models.ModelHollowStalker;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderHollowStalker extends RenderLiving
{
	private static final ResourceLocation texture1 = new ResourceLocation(BleachModInfo.ID.toLowerCase() + ":textures/models/mobs/hollow_stalker.png");
	private static final ResourceLocation texture2 = new ResourceLocation(BleachModInfo.ID.toLowerCase() + ":textures/models/mobs/hollow_stalker2.png");
	private static final ResourceLocation texture3 = new ResourceLocation(BleachModInfo.ID.toLowerCase() + ":textures/models/mobs/hollow_stalker3.png");
	protected ModelHollowStalker model;

	public RenderHollowStalker(ModelBase par1ModelBase, float par2)
	{
		super(par1ModelBase, par2);
		model = ((ModelHollowStalker) mainModel);
	}

	public void renderHollowStalker(EntityHollowStalker par1, double par2, double par3, double par4, float par5, float par6)
	{
		super.doRender((EntityLiving)par1, par2, par3, par4, par5, par6);
	}



	@Override
	public void doRender(Entity par1, double par2, double par3, double par4, float par5, float par6)
	{
		this.renderHollowStalker((EntityHollowStalker) par1, par2, par3, par4, par5, par6);
	}

	protected ResourceLocation getEntityTexture(Entity entity)
	{
		switch (((EntityHollowStalker) entity).getTexture())
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
