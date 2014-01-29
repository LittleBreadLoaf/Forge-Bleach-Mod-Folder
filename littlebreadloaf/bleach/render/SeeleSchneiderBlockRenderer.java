package littlebreadloaf.bleach.render;

import static org.lwjgl.opengl.GL11.*;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLLog;
import littlebreadloaf.bleach.BleachModInfo;
import littlebreadloaf.bleach.tiles.TileSeeleSchneider;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
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

		TileSeeleSchneider tile = (TileSeeleSchneider) tileentity;

		if (tile.isMain)
		{
			glPushMatrix();
			glDisable(GL_LIGHTING);
			glDisable(GL_CULL_FACE);

			glTranslated(x, y, z);
			// glRotatef(180, 1, 0, 0);
			//
			// glScalef(scale, scale, scale);

			FMLClientHandler.instance().getClient().renderEngine.bindTexture(TEXTURE_SEELESCHNEIDER);

			glBegin(GL_QUADS);

			Entity entity = null;
			for (int i = 0; i < tile.worldObj.getLoadedEntityList().size(); i++)
			{
				entity = (Entity) tile.worldObj.getLoadedEntityList().get(i);
				if (entity != null && entity instanceof EntityLiving)
				{
					if (isEntityInCube(entity))
					{
//						FMLLog.info("Entity in cube");
						RenderingHelper.renderBeam(0.5F, 1.5F, 0.5F, entity.posX - tile.xCoord, entity.posY - tile.yCoord, entity.posZ - tile.zCoord);
						RenderingHelper.renderBeam(tile.side + 0.5F, 1.5F, 0.5F, entity.posX - tile.xCoord, entity.posY - tile.yCoord, entity.posZ - tile.zCoord);
						RenderingHelper.renderBeam(0.5F, 1.5F, tile.side + 0.5F, entity.posX - tile.xCoord, entity.posY - tile.yCoord, entity.posZ - tile.zCoord);
						RenderingHelper.renderBeam(tile.side + 0.5F, 1.5F, tile.side + 0.5F, entity.posX - tile.xCoord, entity.posY - tile.yCoord, entity.posZ - tile.zCoord);
					}
				}
			}

			glEnd();

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
