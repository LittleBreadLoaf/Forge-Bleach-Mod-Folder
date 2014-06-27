package littlebreadloaf.bleach.render;

import static org.lwjgl.opengl.GL11.*;
import littlebreadloaf.bleach.BleachIds;
import littlebreadloaf.bleach.BleachModInfo;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RenderLantern extends TileEntitySpecialRenderer implements ISimpleBlockRenderingHandler
{
	private final ResourceLocation TEXTURE_LANTERN = new ResourceLocation(BleachModInfo.ID + ":textures/models/paper_lantern.png");

	public static ModelBase model = new ModelBase()
	{

	};

	private ModelRenderer b5;
	private ModelRenderer b4;
	private ModelRenderer b3;
	private ModelRenderer b2;
	private ModelRenderer b1;
	private ModelRenderer b6;
	private ModelRenderer b7;
	private ModelRenderer b8;
	private ModelRenderer b9;

	public RenderLantern()
	{
		model.textureWidth = 64;
		model.textureHeight = 128;

		b5 = new ModelRenderer(model, 0, 41);
		b5.addBox(-7F, 0F, -7F, 14, 6, 14);
		b5.setRotationPoint(0F, 0F, 0F);
		b5.setTextureSize(64, 128);
		b5.mirror = true;
		setRotation(b5, 0F, 0F, 0F);
		b4 = new ModelRenderer(model, 0, 27);
		b4.addBox(-6F, -2F, -6F, 12, 2, 12);
		b4.setRotationPoint(0F, 0F, 0F);
		b4.setTextureSize(64, 128);
		b4.mirror = true;
		setRotation(b4, 0F, 0F, 0F);
		b3 = new ModelRenderer(model, 0, 16);
		b3.addBox(-5F, -3F, -5F, 10, 1, 10);
		b3.setRotationPoint(0F, 0F, 0F);
		b3.setTextureSize(64, 128);
		b3.mirror = true;
		setRotation(b3, 0F, 0F, 0F);
		b2 = new ModelRenderer(model, 0, 7);
		b2.addBox(-4F, -4F, -4F, 8, 1, 8);
		b2.setRotationPoint(0F, 0F, 0F);
		b2.setTextureSize(64, 128);
		b2.mirror = true;
		setRotation(b2, 0F, 0F, 0F);
		b1 = new ModelRenderer(model, 0, 0);
		b1.addBox(-3F, -5F, -3F, 6, 1, 6);
		b1.setRotationPoint(0F, 0F, 0F);
		b1.setTextureSize(64, 128);
		b1.mirror = true;
		setRotation(b1, 0F, 0F, 0F);
		b6 = new ModelRenderer(model, 0, 61);
		b6.addBox(-6F, 6F, -6F, 12, 2, 12);
		b6.setRotationPoint(0F, 0F, 0F);
		b6.setTextureSize(64, 128);
		b6.mirror = true;
		setRotation(b6, 0F, 0F, 0F);
		b7 = new ModelRenderer(model, 0, 75);
		b7.addBox(-5F, 8F, -5F, 10, 1, 10);
		b7.setRotationPoint(0F, 0F, 0F);
		b7.setTextureSize(64, 128);
		b7.mirror = true;
		setRotation(b7, 0F, 0F, 0F);
		b8 = new ModelRenderer(model, 0, 86);
		b8.addBox(-4F, 9F, -4F, 8, 1, 8);
		b8.setRotationPoint(0F, 0F, 0F);
		b8.setTextureSize(64, 128);
		b8.mirror = true;
		setRotation(b8, 0F, 0F, 0F);
		b9 = new ModelRenderer(model, 0, 95);
		b9.addBox(-3F, 10F, -3F, 6, 1, 6);
		b9.setRotationPoint(0F, 0F, 0F);
		b9.setTextureSize(64, 128);
		b9.mirror = true;
		setRotation(b9, 0F, 0F, 0F);

	}

	public void render(float f5)
	{
		glDisable(GL_CULL_FACE);
		b5.render(f5);
		b4.render(f5);
		b3.render(f5);
		b2.render(f5);
		b1.render(f5);
		b6.render(f5);
		b7.render(f5);
		b8.render(f5);
		b9.render(f5);
		glEnable(GL_CULL_FACE);

	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float f)
	{
		glPushMatrix();
		glTranslated(x + 0.5D, y + 0.68D, z + 0.5D);
		glRotatef(180F, 1F, 0F, 0F);

		Minecraft.getMinecraft().renderEngine.bindTexture(this.TEXTURE_LANTERN);
		this.render(0.0625F);
		glPopMatrix();
	}

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer)
	{
		glPushMatrix();
		glPushAttrib(GL_ENABLE_BIT);
		glEnable(GL_DEPTH_TEST);
		glTranslated(0, 0.3F, 0);
		glRotatef(180F, 1F, 0F, 0F);
		glRotatef(90F, 0F, 1F, 0F);
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(this.TEXTURE_LANTERN);
		this.render(0.0625F);
		glPopAttrib();
		glPopMatrix();
	}

	@Override
	// messed up with model rendering
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer)
	{

		return false;
	}

	@Override
	public boolean shouldRender3DInInventory(int modelId)
	{
		return true;
	}

	@Override
	public int getRenderId()
	{
		return BleachIds.lanternRenderingID;
	}
}
