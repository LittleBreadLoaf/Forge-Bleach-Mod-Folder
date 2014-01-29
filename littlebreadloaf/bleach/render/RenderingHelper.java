package littlebreadloaf.bleach.render;

import static org.lwjgl.opengl.GL11.*;

import java.awt.Color;

import littlebreadloaf.bleach.events.ExtendedPlayer;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;

import org.lwjgl.util.glu.Sphere;

import cpw.mods.fml.common.FMLLog;

public class RenderingHelper
{
	public static void drawCeroSphere(double x, double y, double z, float r, int slices, int stacks, EntityMob entity)
	{
		glPushMatrix();
			glTranslated(x, y, z);
//			glRotatef(entity.rotationYaw, 0,0, 1);
			glTranslated(2, 0, 0);
			

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
	
	public static Color getColorFromPlayer(EntityPlayer entity)
	{		
		Color color = new Color(0x000000);

		if (entity == null) return color;
		
		ExtendedPlayer props = (ExtendedPlayer) entity.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);
		
		switch(props.getZType())
		{
			case 0: color = Color.RED; break;
			case 1: color = Color.GREEN; break;
			case 2: color = Color.BLUE; break;
				
		}
//		FMLLog.info("type: " + props.getZType());
		return color;
	}

	public static void renderBeam(float x, float y, float z, float i, float j, float k)
	{
		float height = 0.3F;
		
		float dist = (float) Math.sqrt((x-i)*(x-i)+(y-j)*(y-j)+(z-k)*(z-k));
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
}
