package littlebreadloaf.entities.renders;

import littlebreadloaf.entities.classes.EntityShinigami;
import littlebreadloaf.libraries.BleachModInfo;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderShinigami extends RenderBiped
{
	private static final ResourceLocation texture1 = new ResourceLocation(BleachModInfo.ID.toLowerCase() + ":textures/models/mobs/shinigami.png");
	private static final ResourceLocation texture2 = new ResourceLocation(BleachModInfo.ID.toLowerCase() + ":textures/models/mobs/shinigami1.png");
	private static final ResourceLocation texture3 = new ResourceLocation(BleachModInfo.ID.toLowerCase() + ":textures/models/mobs/shinigami2.png");
	private static final ResourceLocation texture4 = new ResourceLocation(BleachModInfo.ID.toLowerCase() + ":textures/models/mobs/shinigami3.png");
	private static final ResourceLocation texture5 = new ResourceLocation(BleachModInfo.ID.toLowerCase() + ":textures/models/mobs/shinigami4.png");
	private static final ResourceLocation texture6 = new ResourceLocation(BleachModInfo.ID.toLowerCase() + ":textures/models/mobs/shinigami5.png");
	private static final ResourceLocation texture7 = new ResourceLocation(BleachModInfo.ID.toLowerCase() + ":textures/models/mobs/shinigami6.png");
	private static final ResourceLocation texture8 = new ResourceLocation(BleachModInfo.ID.toLowerCase() + ":textures/models/mobs/shinigami7.png");
	private static final ResourceLocation texture9 = new ResourceLocation(BleachModInfo.ID.toLowerCase() + ":textures/models/mobs/shinigami8.png");
	private static final ResourceLocation texture10 = new ResourceLocation(BleachModInfo.ID.toLowerCase() + ":textures/models/mobs/shinigami9.png");
	private static final ResourceLocation texture11 = new ResourceLocation(BleachModInfo.ID.toLowerCase() + ":textures/models/mobs/shinigami10.png");
	protected ModelBiped model;

	public RenderShinigami(ModelBiped par1ModelBiped, float par2)
	{
		super(par1ModelBiped, par2);
		model = ((ModelBiped) mainModel);
	}

	public void renderShinigami(EntityShinigami par1, double par2, double par3, double par4, float par5, float par6)
	{
		super.doRenderLiving(par1, par2, par3, par4, par5, par6);
	}

	public void doRenderLiving(EntityLiving par1, double par2, double par3, double par4, float par5, float par6)
	{
		this.renderShinigami((EntityShinigami) par1, par2, par3, par4, par5, par6);
	}

	@Override
	public void doRender(Entity par1, double par2, double par3, double par4, float par5, float par6)
	{
		this.renderShinigami((EntityShinigami) par1, par2, par3, par4, par5, par6);
	}

	protected ResourceLocation getEntityTexture(Entity entity)
	{
		switch (((EntityShinigami) entity).getTexture())
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
			case 9:
				return texture11;
			default:
				return texture1;

		}
	}

}
