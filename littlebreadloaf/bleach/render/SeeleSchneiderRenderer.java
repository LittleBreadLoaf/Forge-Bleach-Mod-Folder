package littlebreadloaf.bleach.render;

import static org.lwjgl.opengl.GL11.*;
import littlebreadloaf.bleach.BleachModInfo;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import cpw.mods.fml.client.FMLClientHandler;

public class SeeleSchneiderRenderer implements IItemRenderer
{
	public IModelCustom model;
	public IModelCustom blade;
	private ResourceLocation TEXTURE_SEELESCHNEIDER;

	public SeeleSchneiderRenderer()
	{
		this.TEXTURE_SEELESCHNEIDER = new ResourceLocation(BleachModInfo.ID.toLowerCase() + ":models/SeeleSchneider_Bottom.png");

		this.model = AdvancedModelLoader.loadModel("/assets/" + BleachModInfo.ID.toLowerCase() + "/models/SeeleSchneider.obj");
		this.blade = AdvancedModelLoader.loadModel("/assets/" + BleachModInfo.ID.toLowerCase() + "/models/SeeleSchneider_Blade.obj");
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
				scale = 0.01F;
				glScalef(scale, scale, scale);
			break;
			case EQUIPPED:
				glRotatef(135, 0, 1, 0);
				glRotatef(110, 0, 0, 1);
				glRotatef(180, 1, 0, 0);
				
				glTranslated(1, -2.2F, 0);

				scale = 0.025F;
				
				glScalef(scale, scale, scale);

			break;
			case INVENTORY:
				glTranslated(1.5F, 0, 0.5F);
				glRotatef(45, 1, 0, 1);
				glRotatef(45, 0, 1, 0);
				glRotatef(-20, 1, 0, 0);
				if(item.getItemDamage() == 0)
					scale = 0.022F;
				else
					scale = 0.008F;
				
				glScalef(scale, scale, scale);


			break;
			case EQUIPPED_FIRST_PERSON:
				glTranslated(-0.5F, -0.4F, 0.6F);

				glRotatef(50, 0, 1, 0);
//				glRotatef(20, 1, 0, 0);
//				glRotatef(45, 1, 0, 0);
				glTranslated(0.3F, .8F, -0.1F);

				glRotatef(186, 0, 1, 0);
				scale = 0.01F;
				glScalef(scale, scale, scale);

			break;
			default:
			break;
		}
		
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(getTextureForItem(item));

		if(item.getItemDamage() == 1)
		{
			this.blade.renderAll();
		}
		getModelForItem(item).renderAll();
		

		glEnable(GL_LIGHTING);
		glPopMatrix();
	}

	private ResourceLocation getTextureForItem(ItemStack item)
	{
		return TEXTURE_SEELESCHNEIDER;
	}

	private IModelCustom getModelForItem(ItemStack item)
	{
		return this.model;
	}

}
