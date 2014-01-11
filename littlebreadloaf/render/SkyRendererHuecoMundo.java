package littlebreadloaf.render;

import littlebreadloaf.libraries.BleachModInfo;
import littlebreadloaf.libraries.Ids;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraftforge.client.IRenderHandler;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SkyRendererHuecoMundo extends IRenderHandler
{
	private static final ResourceLocation TEXTURE_SKY = new ResourceLocation(BleachModInfo.ID + ":textures/misc/space.png");
	private static final ResourceLocation TEXTURE_MOON = new ResourceLocation("textures/environment/moon.png");

	@Override
	@SideOnly(Side.CLIENT)
	public void render(float partialTicks, WorldClient world, Minecraft mc)
	{
		if (world.provider.dimensionId == Ids.worldHuecoMundoID)
		{
			GL11.glDisable(GL11.GL_TEXTURE_2D);
			Vec3 vec3 = world.getSkyColor(mc.renderViewEntity, 13000/* partialTicks */);

			float f1 = 0.0F;
			float f2 = 0.0F;
			float f3 = 0.0F;
			float f4;

			if (mc.gameSettings.anaglyph)
			{// with 3d glasses
				float f5 = (f1 * 30.0F + f2 * 59.0F + f3 * 11.0F) / 100.0F;
				float f6 = (f1 * 30.0F + f2 * 70.0F) / 100.0F;
				f4 = (f1 * 30.0F + f3 * 70.0F) / 100.0F;
				f1 = f5;
				f2 = f6;
				f3 = f4;
			}

			GL11.glColor3f(f1, f2, f3);
			Tessellator tessellator1 = Tessellator.instance;
			GL11.glDepthMask(false);
			// GL11.glEnable(GL11.GL_FOG);
			// GL11.glColor3f(f1, f2, f3);
			// GL11.glCallList(this.glSkyList);
			// GL11.glDisable(GL11.GL_FOG);
			GL11.glDisable(GL11.GL_ALPHA_TEST);
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			RenderHelper.disableStandardItemLighting();
			float f7;
			float f8;
			float f9;
			float f10;

			GL11.glEnable(GL11.GL_TEXTURE_2D);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE);
			GL11.glPushMatrix();
			f7 = 0.0F;
			f8 = 0.0F;
			f9 = 0.0F;
			GL11.glColor3f(1.0F, 1.0F, 1.0F);
			GL11.glTranslatef(f7, f8, f9);
			GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(130F, 1.0F, 0.0F, 0.0F);
			f10 = 20.0F;
			FMLClientHandler.instance().getClient().renderEngine.bindTexture(TEXTURE_MOON);
			// int k = 0;
			// int l = k % 4;
			// int i1 = k / 4 % 2;
			// float f14 = (float)(0) / 4.0F;
			// float f15 = (float)(0) / 2.0F;
			// float f16 = (float)(1) / 4.0F;
			// float f17 = (float)(1) / 2.0F;
			tessellator1.startDrawingQuads();
			tessellator1.addVertexWithUV((double) (-f10), -100.0D, (double) f10, (double) 0, (double) 1);
			tessellator1.addVertexWithUV((double) f10, -100.0D, (double) f10, (double) 1, (double) 1);
			tessellator1.addVertexWithUV((double) f10, -100.0D, (double) (-f10), (double) 1, (double) 0);
			tessellator1.addVertexWithUV((double) (-f10), -100.0D, (double) (-f10), (double) 0, (double) 0);
			tessellator1.draw();
			GL11.glDisable(GL11.GL_TEXTURE_2D);

			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			GL11.glDisable(GL11.GL_BLEND);
			GL11.glEnable(GL11.GL_ALPHA_TEST);
			// GL11.glEnable(GL11.GL_FOG);
			GL11.glPopMatrix();
			// GL11.glDisable(GL11.GL_TEXTURE_2D);
			// GL11.glColor3f(0.0F, 0.0F, 0.0F);
			// double d0 = mc.thePlayer.getPosition(partialTicks).yCoord -
			// world.getHorizon();

			// if(d0 < 0.0D)
			// {
			// f8 = 1.0F;
			// f9 = -((float)(d0 + 65.0D));
			// f10 = -f8;
			// tessellator1.startDrawingQuads();
			// tessellator1.setColorRGBA(256, 10, 10, 255);
			// tessellator1.addVertex((double)(-f8), (double)f9, (double)f8);
			// tessellator1.addVertex((double)f8, (double)f9, (double)f8);
			// tessellator1.addVertex((double)f8, (double)f10, (double)f8);
			// tessellator1.addVertex((double)(-f8), (double)f10, (double)f8);
			// tessellator1.addVertex((double)(-f8), (double)f10,
			// (double)(-f8));
			// tessellator1.addVertex((double)f8, (double)f10, (double)(-f8));
			// tessellator1.addVertex((double)f8, (double)f9, (double)(-f8));
			// tessellator1.addVertex((double)(-f8), (double)f9, (double)(-f8));
			// tessellator1.addVertex((double)f8, (double)f10, (double)(-f8));
			// tessellator1.addVertex((double)f8, (double)f10, (double)f8);
			// tessellator1.addVertex((double)f8, (double)f9, (double)f8);
			// tessellator1.addVertex((double)f8, (double)f9, (double)(-f8));
			// tessellator1.addVertex((double)(-f8), (double)f9, (double)(-f8));
			// tessellator1.addVertex((double)(-f8), (double)f9, (double)f8);
			// tessellator1.addVertex((double)(-f8), (double)f10, (double)f8);
			// tessellator1.addVertex((double)(-f8), (double)f10,
			// (double)(-f8));
			// tessellator1.addVertex((double)(-f8), (double)f10,
			// (double)(-f8));
			// tessellator1.addVertex((double)(-f8), (double)f10, (double)f8);
			// tessellator1.addVertex((double)f8, (double)f10, (double)f8);
			// tessellator1.addVertex((double)f8, (double)f10, (double)(-f8));
			// tessellator1.draw();
			// }

			// if(world.provider.isSkyColored())
			// {
			// GL11.glColor3f(f1 * 0.2F + 0.04F, f2 * 0.2F + 0.04F, f3 * 0.6F +
			// 0.1F);
			// }
			// else
			// {
			GL11.glColor3f(f1, f2, f3);
			// }
			//
			GL11.glEnable(GL11.GL_TEXTURE_2D);
			GL11.glDepthMask(true);
		}
	}

	private void renderNightSky(float partialTicks)
	{
		// night
		GL11.glDisable(GL11.GL_FOG);
		GL11.glDisable(GL11.GL_ALPHA_TEST);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		RenderHelper.disableStandardItemLighting();
		GL11.glDepthMask(false);
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(TEXTURE_SKY);
		Tessellator tessellator = Tessellator.instance;

		// asd GL11.glColor4f(1.0F, 1.0F, 1.0F,
		// (Elysium.proxy.getClientWorld().getStarBrightness(partialTicks)) *
		// (1.0F -
		// Elysium.proxy.getClientWorld().getRainStrength(partialTicks)));
		// GL11.glColor4f(1.0F, 1.0F, 1.0F, 0F);

		for (int i = 0; i < 6; ++i)
		{
			GL11.glPushMatrix();

			if (i == 1)
			{
				GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
			}

			if (i == 2)
			{
				GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
			}

			if (i == 3)
			{
				GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
			}

			if (i == 4)
			{
				GL11.glRotatef(90.0F, 0.0F, 0.0F, 1.0F);
			}

			if (i == 5)
			{
				GL11.glRotatef(-90.0F, 0.0F, 0.0F, 1.0F);
			}

			tessellator.startDrawingQuads();
			// tessellator.setColorOpaque_I(2631720);
			tessellator.addVertexWithUV(-100.0D, -100.0D, -100.0D, 0.0D, 0.0D);
			tessellator.addVertexWithUV(-100.0D, -100.0D, 100.0D, 0.0D, 2.0D);
			tessellator.addVertexWithUV(100.0D, -100.0D, 100.0D, 2.0D, 2.0D);
			tessellator.addVertexWithUV(100.0D, -100.0D, -100.0D, 2.0D, 0.0D);
			tessellator.draw();
			GL11.glPopMatrix();
		}

		GL11.glDepthMask(true);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_ALPHA_TEST);
	}
}