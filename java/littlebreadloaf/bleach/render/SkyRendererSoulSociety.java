package littlebreadloaf.bleach.render;

import littlebreadloaf.bleach.BleachModInfo;
import littlebreadloaf.bleach.BleachIds;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraftforge.client.IRenderHandler;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SkyRendererSoulSociety extends IRenderHandler
{
	private static final ResourceLocation TEXTURE_SKY = new ResourceLocation(BleachModInfo.ID + ":textures/environment/hueco_mundo_sky.png");
	private static final ResourceLocation TEXTURE_MOON = new ResourceLocation(BleachModInfo.ID + ":textures/environment/moon.png");

	@Override
	@SideOnly(Side.CLIENT)
	public void render(float partialTicks, WorldClient world, Minecraft mc)
	{
		if (world.provider.dimensionId == BleachIds.worldSoulSocietyID)
		{
//			GL11.glDisable(GL11.GL_FOG);
			
			float f18 = world.getStarBrightness(partialTicks) * (1.0F - world.getRainStrength(partialTicks));

//            if(f18 > 0.0F)
//            {
                    renderNightSky(partialTicks);

//                    GL11.glCallList(this.starGLCallList);
//            }
            GL11.glDisable(GL11.GL_TEXTURE_2D);
            Vec3 vec3 = world.getSkyColor(mc.renderViewEntity, partialTicks);
            float f1 = (float)vec3.xCoord;
            float f2 = (float)vec3.yCoord;
            float f3 = (float)vec3.zCoord;
            float f4;

            if(mc.gameSettings.anaglyph)
            {
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
//            GL11.glEnable(GL11.GL_FOG);
//            GL11.glColor3f(f1, f2, f3);
//              GL11.glCallList(this.glSkyList);
//            GL11.glDisable(GL11.GL_FOG);
            GL11.glDisable(GL11.GL_ALPHA_TEST);
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
            RenderHelper.disableStandardItemLighting();
            float[] afloat = world.provider.calcSunriseSunsetColors(world.getCelestialAngle(partialTicks), partialTicks);
            float f7;
            float f8;
            float f9;
            float f10;

            if(afloat != null)
            {
                    GL11.glDisable(GL11.GL_TEXTURE_2D);
                    GL11.glShadeModel(GL11.GL_SMOOTH);
                    GL11.glPushMatrix();
                    GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
                    GL11.glRotatef(135F, 0.0F, 0.0F, 1.0F);
                    GL11.glRotatef(90.0F, 0.0F, 0.0F, 1.0F);
                    f4 = afloat[0];
                    f7 = afloat[1];
                    f8 = afloat[2];
                    float f11;

                    if(mc.gameSettings.anaglyph)
                    {
                            f9 = (f4 * 30.0F + f7 * 59.0F + f8 * 11.0F) / 100.0F;
                            f10 = (f4 * 30.0F + f7 * 70.0F) / 100.0F;
                            f11 = (f4 * 30.0F + f8 * 70.0F) / 100.0F;
                            f4 = f9;
                            f7 = f10;
                            f8 = f11;
                    }

                    tessellator1.startDrawing(6);
                    tessellator1.setColorRGBA_F(f4, f7, f8, afloat[3]);
                    tessellator1.addVertex(0.0D, 100.0D, 0.0D);
                    byte b0 = 16;
                    tessellator1.setColorRGBA_F(afloat[0], afloat[1], afloat[2], 0.0F);

                    for(int j = 0; j <= b0; ++j)
                    {
                            f11 = (float)j * (float)Math.PI * 2.0F / (float)b0;
                            float f12 = MathHelper.sin(f11);
                            float f13 = MathHelper.cos(f11);
                            tessellator1.addVertex((double)(f12 * 120.0F), (double)(f13 * 120.0F), (double)(-f13 * 40.0F * afloat[3]));
                    }

                    tessellator1.draw();
                    GL11.glPopMatrix();
                    GL11.glShadeModel(GL11.GL_FLAT);
            }

            GL11.glEnable(GL11.GL_TEXTURE_2D);
            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE);
            GL11.glPushMatrix();
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glTranslatef(0.0F, 0.0F, 0.0F);
            GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(135F, 1.0F, 0.0F, 0.0F);
            f10 = 20.0F;
            FMLClientHandler.instance().getClient().renderEngine.bindTexture(TEXTURE_MOON);
            tessellator1.startDrawingQuads();
            tessellator1.addVertexWithUV((double)(-f10), -100.0D, (double)f10, 0, 1);
            tessellator1.addVertexWithUV((double)f10, -100.0D, (double)f10, 1, 1);
            tessellator1.addVertexWithUV((double)f10, -100.0D, (double)(-f10), 1, 0);
            tessellator1.addVertexWithUV((double)(-f10), -100.0D, (double)(-f10), 0, 0);
            tessellator1.draw();
            GL11.glDisable(GL11.GL_TEXTURE_2D);


            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glDisable(GL11.GL_BLEND);
            GL11.glEnable(GL11.GL_ALPHA_TEST);
            GL11.glEnable(GL11.GL_FOG);
            GL11.glPopMatrix();
            GL11.glDisable(GL11.GL_TEXTURE_2D);
            GL11.glColor3f(0.0F, 0.0F, 0.0F);
            double d0 = mc.thePlayer.getPosition(partialTicks).yCoord - world.getHorizon();

            if(d0 < 0.0D)
            {
                    f8 = 1.0F;
                    f9 = -((float)(d0 + 65.0D));
                    f10 = -f8;
                    tessellator1.startDrawingQuads();
                    tessellator1.setColorRGBA_I(0, 255);
                    tessellator1.addVertex((double)(-f8), (double)f9, (double)f8);
                    tessellator1.addVertex((double)f8, (double)f9, (double)f8);
                    tessellator1.addVertex((double)f8, (double)f10, (double)f8);
                    tessellator1.addVertex((double)(-f8), (double)f10, (double)f8);
                    tessellator1.addVertex((double)(-f8), (double)f10, (double)(-f8));
                    tessellator1.addVertex((double)f8, (double)f10, (double)(-f8));
                    tessellator1.addVertex((double)f8, (double)f9, (double)(-f8));
                    tessellator1.addVertex((double)(-f8), (double)f9, (double)(-f8));
                    tessellator1.addVertex((double)f8, (double)f10, (double)(-f8));
                    tessellator1.addVertex((double)f8, (double)f10, (double)f8);
                    tessellator1.addVertex((double)f8, (double)f9, (double)f8);
                    tessellator1.addVertex((double)f8, (double)f9, (double)(-f8));
                    tessellator1.addVertex((double)(-f8), (double)f9, (double)(-f8));
                    tessellator1.addVertex((double)(-f8), (double)f9, (double)f8);
                    tessellator1.addVertex((double)(-f8), (double)f10, (double)f8);
                    tessellator1.addVertex((double)(-f8), (double)f10, (double)(-f8));
                    tessellator1.addVertex((double)(-f8), (double)f10, (double)(-f8));
                    tessellator1.addVertex((double)(-f8), (double)f10, (double)f8);
                    tessellator1.addVertex((double)f8, (double)f10, (double)f8);
                    tessellator1.addVertex((double)f8, (double)f10, (double)(-f8));
                    tessellator1.draw();
            }
//
//            if(world.provider.isSkyColored())
//            {
//                    GL11.glColor3f(f1 * 0.2F + 0.04F, f2 * 0.2F + 0.04F, f3 * 0.6F + 0.1F);
//            }
//            else
//            {
//                    GL11.glColor3f(f1, f2, f3);
//            }

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

		GL11.glColor4f(0.4F, 0.4F, 0.4F, 1.0F);
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