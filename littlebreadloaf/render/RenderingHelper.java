package littlebreadloaf.render;

import net.minecraft.entity.monster.EntityMob;

import org.lwjgl.util.glu.Sphere;

import cpw.mods.fml.common.FMLLog;
import static org.lwjgl.opengl.GL11.*;

public class RenderingHelper
{
	public static void drawCeroSphere(double x, double y, double z, float r, int slices, int stacks, EntityMob entity)
	{
		glPushMatrix();
			glTranslated(x + 2, y, z);
			glRotatef(entity.rotationYaw, 1,0, 0);
//			FMLLog.info("menos yaw"+entity.rotationYaw);
			glDisable(GL_CULL_FACE);
			glDisable(GL_LIGHTING);
			glColor3f(1, 0, 0);
			
			new Sphere().draw(r, 10, 10);
			glColor3f(1, 1, 1);
			
			glEnable(GL_CULL_FACE);
			glEnable(GL_LIGHTING);
            
		glPopMatrix();
	}
}
