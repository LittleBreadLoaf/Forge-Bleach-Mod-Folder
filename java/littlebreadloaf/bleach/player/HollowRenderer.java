package littlebreadloaf.bleach.player;

import littlebreadloaf.bleach.BleachModInfo;
import littlebreadloaf.bleach.events.ExtendedPlayer;
import littlebreadloaf.bleach.player.models.ModelPlayerHollow;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class HollowRenderer extends RenderPlayer
{
	private static final ResourceLocation texture1 = new ResourceLocation(BleachModInfo.ID.toLowerCase() + ":textures/models/mobs/player_hollow_1.png");
	private static final ResourceLocation texture1_overlay = new ResourceLocation(BleachModInfo.ID.toLowerCase() + ":textures/models/mobs/player_hollow_1_overlay.png");
	
	protected ModelPlayerHollow model;

	public HollowRenderer()
	{
		super();
		 this.mainModel = new ModelPlayerHollow();
		 this.modelBipedMain = (ModelBiped)this.mainModel;
		 this.modelArmorChestplate = new ModelPlayerHollow();
		 this.modelArmor = new ModelPlayerHollow();
		 this.renderManager = RenderManager.instance;
	}





	@Override
	public void doRender(Entity par1, double par2, double par3, double par4, float par5, float par6)
	{
		super.doRender((EntityLiving)par1, par2, par3, par4, par5, par6);
	}

	protected ResourceLocation getEntityTexture(Entity entity)
	{
		
			return texture1;

		
	}
	
	 public static final float[][] colorTable = new float[][] {{1.0F, 1.0F, 1.0F}, {0.85F, 0.5F, 0.2F}, {0.7F, 0.3F, 0.85F}, {0.4F, 0.6F, 0.85F}, {0.9F, 0.9F, 0.2F}, {0.5F, 0.8F, 0.1F}, {0.95F, 0.5F, 0.65F}, {0.3F, 0.3F, 0.3F}, {0.6F, 0.6F, 0.6F}, {0.3F, 0.5F, 0.6F}, {0.5F, 0.25F, 0.7F}, {0.2F, 0.3F, 0.7F}, {0.4F, 0.3F, 0.2F}, {0.4F, 0.5F, 0.2F}, {0.6F, 0.2F, 0.2F}, {0.1F, 0.1F, 0.1F}};
	  
		@Override
		protected int shouldRenderPass(EntityLivingBase entity, int par2, float par3)
		{
			if(entity instanceof EntityPlayer)
			{
				EntityPlayer player = (EntityPlayer)entity;
				ExtendedPlayer props = ExtendedPlayer.get(player);

			if(props.getFaction() == 3)
			{
				
				
					if (par2 != 0)
			        {
			            return -1;
			        }
			        else
			        {
			        	int blug = 3;
			            this.bindTexture(texture1_overlay);
			            GL11.glEnable(GL11.GL_BLEND);
			            GL11.glDisable(GL11.GL_ALPHA_TEST);
			            GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);
			            GL11.glColor3f(colorTable[blug][0], colorTable[blug][1], colorTable[blug][2]);

			            if (player.isInvisible())
			            {
			                GL11.glDepthMask(false);
			            }
			            else
			            {
			                GL11.glDepthMask(true);
			            }

			            char c0 = 61680;
			            int j = c0 % 65536;
			            int k = c0 / 65536;
			            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)j / 1.0F, (float)k / 1.0F);
			            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			            return 1;
			        }
					     
			    
			    
			}
		}
			return -1;
		}

}
