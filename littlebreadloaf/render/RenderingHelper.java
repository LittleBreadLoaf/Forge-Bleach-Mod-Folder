package littlebreadloaf.render;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.Sphere;

import cpw.mods.fml.common.FMLLog;
import static org.lwjgl.opengl.GL11.*;

public class RenderingHelper
{
	public static void drawSphere(double x, double y, double z, float r, int slices, int stacks)
	{
		glPushMatrix();
		
			GL11.glTranslated(x, y, z);
			new Sphere().draw(r, 5, 5);
//			FMLLog.info("rendering sphere");
		glPopMatrix();
	}
}
