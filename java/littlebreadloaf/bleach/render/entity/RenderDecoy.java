package littlebreadloaf.bleach.render.entity;

import littlebreadloaf.bleach.BleachModInfo;
import littlebreadloaf.bleach.entities.EntityDecoy;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderDecoy extends RenderBiped
{
	private static final ResourceLocation texture1 = new ResourceLocation(BleachModInfo.ID.toLowerCase() + ":textures/models/mobs/decoy.png");
	private static final ResourceLocation texture2 = new ResourceLocation(BleachModInfo.ID.toLowerCase() + ":textures/models/mobs/decoy1.png");
	private static final ResourceLocation texture3 = new ResourceLocation(BleachModInfo.ID.toLowerCase() + ":textures/models/mobs/decoy2.png");
	private static final ResourceLocation texture4 = new ResourceLocation(BleachModInfo.ID.toLowerCase() + ":textures/models/mobs/decoy3.png");
	private static final ResourceLocation texture5 = new ResourceLocation(BleachModInfo.ID.toLowerCase() + ":textures/models/mobs/decoy4.png");
	private static final ResourceLocation texture6 = new ResourceLocation(BleachModInfo.ID.toLowerCase() + ":textures/models/mobs/decoy5.png");
	private static final ResourceLocation texture7 = new ResourceLocation(BleachModInfo.ID.toLowerCase() + ":textures/models/mobs/decoy6.png");
	private static final ResourceLocation texture8 = new ResourceLocation(BleachModInfo.ID.toLowerCase() + ":textures/models/mobs/decoy7.png");
	private static final ResourceLocation texture9 = new ResourceLocation(BleachModInfo.ID.toLowerCase() + ":textures/models/mobs/decoy8.png");
	private static final ResourceLocation texture10 = new ResourceLocation(BleachModInfo.ID.toLowerCase() + ":textures/models/mobs/decoy9.png");
	protected ModelBiped model;

	public RenderDecoy(ModelBiped par1ModelBase, float par2)
	{
		super(par1ModelBase, par2);
		model = ((ModelBiped) mainModel);
	}

	public void renderDecoy(EntityDecoy par1, double par2, double par3, double par4, float par5, float par6)
	{
		super.doRender((EntityLiving)par1, par2, par3, par4, par5, par6);
	}

	

	@Override
	public void doRender(Entity par1, double par2, double par3, double par4, float par5, float par6)
	{
		this.renderDecoy((EntityDecoy) par1, par2, par3, par4, par5, par6);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		switch (((EntityDecoy) entity).getTexture())
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
