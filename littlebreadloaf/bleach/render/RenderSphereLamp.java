package littlebreadloaf.bleach.render;

import static org.lwjgl.opengl.GL11.*;

import java.awt.Color;

import org.lwjgl.util.glu.Sphere;

import littlebreadloaf.bleach.BleachModInfo;
import littlebreadloaf.bleach.BleachIds;
import littlebreadloaf.bleach.tiles.TileSphereLamp;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RenderSphereLamp extends TileEntitySpecialRenderer implements ISimpleBlockRenderingHandler
{
	private static ResourceLocation TEXTURE_SPHERE_LAMP = new ResourceLocation(BleachModInfo.ID.toLowerCase() + ":/models/sphereLamp.png");

	public static void render(TileEntity tile)
	{
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(TEXTURE_SPHERE_LAMP);
		glRotatef(90, 1, 0, 1);
		new Sphere().draw(1F, 20, 18);

	}
	
	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float f)
	{
		glPushMatrix();
		glTranslated(x + 0.5F, y + 0.5F, z + 0.5F);
		float scale = 0.5F;
		glScalef(scale, scale, scale);
		
		if(tile instanceof TileSphereLamp)
		{
			TileSphereLamp lampTile = (TileSphereLamp) tile;
			Color color = RenderingHelper.getColorFromPlayer(lampTile.getOwnerEntity());
			glColor3f(color.getRed(), color.getGreen(), color.getBlue());
		}
		
		this.render(tile);
		
		glPopMatrix();

	}
	
	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer)
	{
		glPushMatrix();
		glPushAttrib(GL_ENABLE_BIT);
		glEnable(GL_DEPTH_TEST);
		glTranslated(0, 0, 0);
		float scale = 0.7F;
		glScalef(scale, scale, scale);
		glRotatef(180F, 1F, 0F, 0F);
		
		Color color = RenderingHelper.getColorFromPlayer(FMLClientHandler.instance().getClient().thePlayer);
		glColor3f(color.getRed(), color.getGreen(), color.getBlue());
		
		this.render(null);
		glPopAttrib();
		glPopMatrix();
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer)
	{
		return false;
	}

	@Override
	public boolean shouldRender3DInInventory()
	{
		return true;
	}

	@Override
	public int getRenderId()
	{
		return BleachIds.sphereLampRenderID;
	}


}
