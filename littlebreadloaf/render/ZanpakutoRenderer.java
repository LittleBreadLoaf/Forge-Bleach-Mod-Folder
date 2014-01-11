package littlebreadloaf.render;

import static org.lwjgl.opengl.GL11.*;
import littlebreadloaf.libraries.BleachModInfo;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import cpw.mods.fml.client.FMLClientHandler;

public class ZanpakutoRenderer implements IItemRenderer
{
	public IModelCustom zanpakuto1;
	private ResourceLocation TEXTURE_ZANPAKUTO_1;

	public ZanpakutoRenderer()
	{
		this.TEXTURE_ZANPAKUTO_1 = new ResourceLocation(BleachModInfo.ID.toLowerCase() + ":/models/Zanpakuto.png");

		this.zanpakuto1 = AdvancedModelLoader.loadModel("/assets/" + BleachModInfo.ID.toLowerCase() + "/models/Zanpakuto.obj");
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type)
	{
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
	{
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data)
	{
		glPushMatrix();
		
		glDisable(GL_LIGHTING);
		float scale;
		switch (type)
		{
			case ENTITY:
//				glTranslated(0, -0.5F, 0);
//				scale = 0.05F;
//				glScalef(scale, scale, scale);
			break;
			case EQUIPPED:
//				glTranslated(0, 0, 0);
//				scale = 0.2F;
//				glScalef(scale, scale, scale);
			break;
			case INVENTORY:
				glRotatef(-45, 0, 1, 0);
				glRotatef(20, 0, 0, 1);
				glRotatef(45, 1, 0, 0);
				
				scale = 0.14F;
				glScalef(scale, scale, scale);

				glTranslated(0, -7.4F, 0);

			break;
			case EQUIPPED_FIRST_PERSON:
//				glTranslated(0, -0.5F, 0);
//				scale = 0.2F;
//				glScalef(scale, scale, scale);
			break;
			default:
			break;
		}
		
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(getTextureForItem(item));

		getModelForItem(item).renderAll();
		

		glEnable(GL_LIGHTING);
		glPopMatrix();
	}

	private ResourceLocation getTextureForItem(ItemStack item)
	{
		return TEXTURE_ZANPAKUTO_1;
	}

	private IModelCustom getModelForItem(ItemStack item)
	{
		return this.zanpakuto1;
	}

}
