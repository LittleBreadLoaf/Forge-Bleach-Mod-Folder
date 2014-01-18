package littlebreadloaf.bleach.render;

import static org.lwjgl.opengl.GL11.*;
import cpw.mods.fml.client.FMLClientHandler;
import littlebreadloaf.bleach.BleachModInfo;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

public class SeeleSchneiderBlockRenderer extends TileEntitySpecialRenderer
{

	private ResourceLocation TEXTURE_SEELESCHNEIDER;
	private IModelCustom model;
	private IModelCustom blade;

	public SeeleSchneiderBlockRenderer()
	{
		this.TEXTURE_SEELESCHNEIDER = new ResourceLocation(BleachModInfo.ID.toLowerCase() + ":/models/SeeleSchneider_Bottom.png");

		this.model = AdvancedModelLoader.loadModel("/assets/" + BleachModInfo.ID.toLowerCase() + "/models/SeeleSchneider.obj");
		this.blade = AdvancedModelLoader.loadModel("/assets/" + BleachModInfo.ID.toLowerCase() + "/models/SeeleSchneider_Blade.obj");

	}

	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f)
	{
		glPushMatrix();
		glDisable(GL_LIGHTING);

		glTranslated(x + 0.5F, y + 1.5F, z + 0.5F);
		glRotatef(180, 1, 0, 0);
		float scale = 0.01F;
		
		glScalef(scale, scale, scale);
		
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(TEXTURE_SEELESCHNEIDER);

		this.blade.renderAll();
		this.model.renderAll();
		
		glEnable(GL_LIGHTING);
		glPopMatrix();
	}

}
