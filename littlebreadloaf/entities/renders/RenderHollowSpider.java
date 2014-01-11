package littlebreadloaf.entities.renders;

import littlebreadloaf.entities.classes.EntityHollowSpider;
import littlebreadloaf.entities.models.ModelHollowSpider;
import littlebreadloaf.libraries.BleachModInfo;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
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
		super.doRenderLiving(par1, par2, par3, par4, par5, par6);
	}

	public void doRenderLiving(EntityLiving par1, double par2, double par3, double par4, float par5, float par6)
	{
		this.renderHollowSpider((EntityHollowSpider) par1, par2, par3, par4, par5, par6);
	}

	@Override
	public void doRender(Entity par1, double par2, double par3, double par4, float par5, float par6)
	{
		this.renderHollowSpider((EntityHollowSpider) par1, par2, par3, par4, par5, par6);
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
