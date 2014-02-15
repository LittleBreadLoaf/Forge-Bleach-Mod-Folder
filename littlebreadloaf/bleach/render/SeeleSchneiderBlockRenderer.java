package littlebreadloaf.bleach.render;

import static org.lwjgl.opengl.GL11.*;

import java.awt.Color;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLLog;
import littlebreadloaf.bleach.BleachModInfo;
import littlebreadloaf.bleach.tiles.TileSeeleSchneider;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

public class SeeleSchneiderBlockRenderer extends TileEntitySpecialRenderer
{

	private ResourceLocation TEXTURE_SEELESCHNEIDER;
	private ResourceLocation TEXTURE_BEAM;
	private ResourceLocation TEXTURE_CIRCLE = new ResourceLocation(BleachModInfo.ID + ":models/circle_gray.png");

	private IModelCustom model;
	private IModelCustom blade;

	public SeeleSchneiderBlockRenderer()
	{
		this.TEXTURE_SEELESCHNEIDER = new ResourceLocation(BleachModInfo.ID + ":models/SeeleSchneider_Bottom.png");
		this.TEXTURE_BEAM = new ResourceLocation(BleachModInfo.ID + ":models/beam_gray.png");

		this.model = AdvancedModelLoader.loadModel("/assets/" + BleachModInfo.ID + "/models/SeeleSchneider.obj");
		this.blade = AdvancedModelLoader.loadModel("/assets/" + BleachModInfo.ID + "/models/SeeleSchneider_Blade.obj");

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

		TileSeeleSchneider tile = (TileSeeleSchneider) tileentity;

		if (tile.isMain)
		{
			glPushMatrix();

			glDisable(GL_LIGHTING);
			glDisable(GL_CULL_FACE);
			glEnable(GL_BLEND);
			glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);

			glColor4f(1F / (float) (tile.alpha * 50 + 120F), 1, 1, tile.alpha);

			glTranslated(x, y, z);
			// glRotatef(180, 1, 0, 0);
			//
			// glScalef(scale, scale, scale);

			FMLClientHandler.instance().getClient().renderEngine.bindTexture(TEXTURE_BEAM);

			glBegin(GL_QUADS);

			Entity entity = null;
			for (int i = 0; i < tile.worldObj.getLoadedEntityList().size(); i++)
			{
				entity = (Entity) tile.worldObj.getLoadedEntityList().get(i);
				if (entity != null && entity instanceof EntityLiving || entity instanceof EntityPlayer)
				{
					if (isEntityInCube(entity))
					{
						 FMLLog.info("Entity in cube");
						RenderingHelper.renderBeam(0.5F, 1.5F, 0.5F, entity.posX - tile.xCoord, entity.posY - tile.yCoord - entity.yOffset, entity.posZ - tile.zCoord);
						RenderingHelper.renderBeam(tile.side + 0.5F, 1.5F, 0.5F, entity.posX - tile.xCoord, entity.posY - tile.yCoord - entity.yOffset, entity.posZ - tile.zCoord);
						RenderingHelper.renderBeam(0.5F, 1.5F, tile.side + 0.5F, entity.posX - tile.xCoord, entity.posY - tile.yCoord - entity.yOffset, entity.posZ - tile.zCoord);
						RenderingHelper.renderBeam(tile.side + 0.5F, 1.5F, tile.side + 0.5F, entity.posX - tile.xCoord, entity.posY - tile.yCoord - entity.yOffset, entity.posZ - tile.zCoord);

						glEnd();
						FMLClientHandler.instance().getClient().renderEngine.bindTexture(TEXTURE_CIRCLE);

						RenderingHelper.renderFacingQuad(0.5F, 1.5F, 0.5F, 1.5F);
						RenderingHelper.renderFacingQuad(tile.side + 0.5F, 1.5F, 0.5F, 1.5F);
						RenderingHelper.renderFacingQuad(0.5F, 1.5F, tile.side + 0.5F, 1.5F);
						RenderingHelper.renderFacingQuad(tile.side + 0.5F, 1.5F, tile.side + 0.5F, 1.5F);

						
						RenderingHelper.renderFacingQuad(entity.posX - tile.xCoord, entity.posY - tile.yCoord + 0.3F - entity.yOffset, entity.posZ - tile.zCoord, 8F);

						
						FMLClientHandler.instance().getClient().renderEngine.bindTexture(TEXTURE_BEAM);

						glBegin(GL_QUADS);
					}
				}
			}

			glEnd();

			glDisable(GL_BLEND);
			glEnable(GL_CULL_FACE);
			glEnable(GL_LIGHTING);

			glPopMatrix();
		}
	}

	private boolean isEntityInCube(Entity entity)
	{
		int x, y, z, side;

		TileSeeleSchneider tile;

		for (int i = 0; i < TileSeeleSchneider.magicSquare.size(); i++)
		{
			x = TileSeeleSchneider.magicSquare.get(i).posX;
			y = TileSeeleSchneider.magicSquare.get(i).posY;
			z = TileSeeleSchneider.magicSquare.get(i).posZ;

			tile = (TileSeeleSchneider) entity.worldObj.getBlockTileEntity(x, y, z);
			if (tile == null)
			{
				TileSeeleSchneider.magicSquare.remove(i);
				return false;
			}
			side = tile.side;

			if (entity.posX > x + 0.5F && entity.posX < x + side - 0.5F && entity.posZ > z + 0.5F && entity.posZ < z + side - 0.5F && entity.posY >= y)
			{
				return true;
			}
		}
		return false;
	}

}
