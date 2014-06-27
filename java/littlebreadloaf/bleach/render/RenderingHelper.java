package littlebreadloaf.bleach.render;

import static org.lwjgl.opengl.GL11.*;

import java.awt.Color;

import littlebreadloaf.bleach.BleachModInfo;
import littlebreadloaf.bleach.events.ExtendedPlayer;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.util.glu.Sphere;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLLog;

public class RenderingHelper
{
	public static void drawCeroSphere(double x, double y, double z, float r, int slices, int stacks, EntityMob entity)
	{
		glPushMatrix();
		glTranslated(x, y, z);
		// glRotatef(entity.rotationYaw, 0,0, 1);
		glTranslated(2, 0, 0);

		// FMLLog.info("menos yaw"+entity.rotationYaw);
		glDisable(GL_CULL_FACE);
		glDisable(GL_LIGHTING);
		glColor3f(1, 0, 0);

		new Sphere().draw(r, 10, 10);
		glColor3f(1, 1, 1);

		glEnable(GL_CULL_FACE);
		glEnable(GL_LIGHTING);

		glPopMatrix();
	}

	public static Color getColorFromPlayer(EntityPlayer entity)
	{
		Color color = new Color(0x000000);

		if (entity == null)
			return color;

		ExtendedPlayer props = (ExtendedPlayer) entity.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);

		switch (props.getZType())
		{
			case 0:
				color = Color.RED;
			break;
			case 1:
				color = Color.GREEN;
			break;
			case 2:
				color = Color.BLUE;
			break;

		}
		// FMLLog.info("type: " + props.getZType());
		return color;
	}

	public static void renderBeam(float x, float y, float z, float i, float j, float k)
	{
		float height = 0.1F;

		float dist = (float) Math.sqrt((x - i) * (x - i) + (y - j) * (y - j) + (z - k) * (z - k));
		float repeat = dist;

		glTexCoord2f(0, 0);
		glVertex3f(x, y - height, z);
		glTexCoord2f(0, 1);
		glVertex3f(x, y + height, z);
		glTexCoord2f(1 * repeat, 1);
		glVertex3d(i, j + 0.3F + height, k);
		glTexCoord2f(1 * repeat, 0);
		glVertex3d(i, j + 0.3F - height, k);

	}

	public static void renderBeam(float x, float y, float z, double i, double j, double k)
	{
		renderBeam(x, y, z, (float) i, (float) j, (float) k);
	}

	public static void renderFacingQuad(double x, double y, double z, float scale)
	{
		glPushMatrix();
		glTranslated(x, y, z);
		applyFloatingRotations();
		glScaled(0.1F * scale, 0.1F * scale, 1F);

		int h = 1;
		int w = 1;
//		glDisable(GL_LIGHTING);
//		glEnable(GL_BLEND);
//		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
//		glColor4f(c.getRed() / 256F, c.getGreen() / 256F, c.getBlue() / 256F, c.getAlpha());

//		RenderManager.instance.renderEngine.bindTexture(texture);

		glBegin(GL_QUADS);
		glTexCoord2f(0F, 1F);
		glVertex3f(-w, -h, 0.001F);
		glTexCoord2f(0F, 0F);
		glVertex3f(-w, h, 0.001F);
		glTexCoord2f(1F, 0F);
		glVertex3f(w, h, 0.001F);
		glTexCoord2f(1F, 1F);
		glVertex3f(w, -h, 0.001F);
		glEnd();
//		glDisable(GL_BLEND);
//		glEnable(GL_LIGHTING);
		glPopMatrix();
	}

	private static void applyFloatingRotations()
	{
		glRotatef(-RenderManager.instance.playerViewY, 0.0F, 1.0F, 0.0F);
		glRotatef(RenderManager.instance.playerViewX, 1.0F, 0.0F, 0.0F);
	}
}
