package littlebreadloaf.bleach.render.entity;

import static net.minecraftforge.client.IItemRenderer.ItemRenderType.EQUIPPED;
import static net.minecraftforge.client.IItemRenderer.ItemRendererHelper.BLOCK_3D;

import org.lwjgl.opengl.GL11;

import littlebreadloaf.bleach.BleachModInfo;
import littlebreadloaf.bleach.entities.EntityShinigami;
import littlebreadloaf.bleach.events.ExtendedPlayer;
import littlebreadloaf.bleach.items.BleachItems;
import net.minecraft.block.Block;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.tileentity.TileEntitySkullRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;

public class RenderShinigami extends RenderBiped
{
	private static final ResourceLocation texture1 = new ResourceLocation(BleachModInfo.ID.toLowerCase() + ":textures/models/mobs/shinigami.png");
	private static final ResourceLocation texture2 = new ResourceLocation(BleachModInfo.ID.toLowerCase() + ":textures/models/mobs/shinigami1.png");
	private static final ResourceLocation texture3 = new ResourceLocation(BleachModInfo.ID.toLowerCase() + ":textures/models/mobs/shinigami2.png");
	private static final ResourceLocation texture4 = new ResourceLocation(BleachModInfo.ID.toLowerCase() + ":textures/models/mobs/shinigami3.png");
	private static final ResourceLocation texture5 = new ResourceLocation(BleachModInfo.ID.toLowerCase() + ":textures/models/mobs/shinigami4.png");
	private static final ResourceLocation texture6 = new ResourceLocation(BleachModInfo.ID.toLowerCase() + ":textures/models/mobs/shinigami5.png");
	private static final ResourceLocation texture7 = new ResourceLocation(BleachModInfo.ID.toLowerCase() + ":textures/models/mobs/shinigami6.png");
	private static final ResourceLocation texture8 = new ResourceLocation(BleachModInfo.ID.toLowerCase() + ":textures/models/mobs/shinigami7.png");
	private static final ResourceLocation texture9 = new ResourceLocation(BleachModInfo.ID.toLowerCase() + ":textures/models/mobs/shinigami8.png");
	private static final ResourceLocation texture10 = new ResourceLocation(BleachModInfo.ID.toLowerCase() + ":textures/models/mobs/shinigami9.png");
	private static final ResourceLocation texture11 = new ResourceLocation(BleachModInfo.ID.toLowerCase() + ":textures/models/mobs/shinigami10.png");
	protected ModelBiped model;

	public RenderShinigami(ModelBiped par1ModelBiped, float par2)
	{
		super(par1ModelBiped, par2);
		model = ((ModelBiped) mainModel);
	}
	
	@Override
	protected void renderEquippedItems(EntityLiving par1EntityLiving, float par2)
    {
        ItemStack itemstack = par1EntityLiving.getHeldItem();
		if(ExtendedPlayer.getIs3D())
		{
        float f1 = 1.0F;
        GL11.glColor3f(f1, f1, f1);
        float f2;

        if (itemstack != null)
        {
            GL11.glPushMatrix();

            if (this.mainModel.isChild)
            {
                f2 = 0.5F;
                GL11.glTranslatef(0.0F, 0.625F, 0.0F);
                GL11.glRotatef(-20.0F, -1.0F, 0.0F, 0.0F);
                GL11.glScalef(f2, f2, f2);
            }

            this.modelBipedMain.bipedRightArm.postRender(0.0625F);
//            GL11.glTranslatef(-0.0625F, 0.4375F, 0.0625F);

            IItemRenderer customRenderer = MinecraftForgeClient.getItemRenderer(itemstack, EQUIPPED);
            boolean is3D = (customRenderer != null && customRenderer.shouldUseRenderHelper(EQUIPPED, itemstack, BLOCK_3D));

            if (itemstack.getItem() == BleachItems.zanpakuto)
            {
                f2 = 0.4F;
                GL11.glScalef(f2, f2, f2);

                GL11.glTranslatef(0.13F, -0.15F, -0.75F);
                GL11.glRotatef(45.0F, 0.0F, 0.0F, 1.0F);
            	GL11.glRotatef(-45.0F, 0.0F, 1.0F, 0.0F);
                GL11.glRotatef(-55F, 1.0F, 0.0F, 0.0F);

                customRenderer.renderItem(EQUIPPED, itemstack);
            }

//            this.renderManager.itemRenderer.renderItem(par1EntityLiving, itemstack, 0);


            GL11.glPopMatrix();
        }
		}
		else
		{
			float f1 = 1.0F;
	        GL11.glColor3f(f1, f1, f1);
	        float f2;

	        if (itemstack != null)
	        {
	            GL11.glPushMatrix();

	            if (this.mainModel.isChild)
	            {
	                f2 = 1.0F;
	                GL11.glTranslatef(0.0F, 0.625F, 0.0F);
	                GL11.glRotatef(-20.0F, -1.0F, 0.0F, 0.0F);
	                GL11.glScalef(f2, f2, f2);
	            }

	            this.modelBipedMain.bipedRightArm.postRender(0.0625F);
//	            GL11.glTranslatef(-0.0625F, 0.4375F, 0.0625F);

	           
	            if (itemstack.getItem() == BleachItems.zanpakuto)
	            {
	                f2 = 0.725F;
	                GL11.glScalef(f2, f2, f2);

	                //GL11.glTranslatef(0.13F, -0.15F, -0.75F);
	                GL11.glTranslatef(-0.15F, 0.80F, 0.0F);

	                GL11.glRotatef(-129F, 14.2F, -9.0F, 9.0F);
	                GL11.glRotatef(-10F, 0.0F, 6.4F, -0.0F);
	                GL11.glRotated(33F, 0.0F, -178.0F, -9.0F);
	                GL11.glRotated(175F, 0.0F, -180.0F, -12.0F);
	                GL11.glRotatef(-26F, 0.0F,0.0F, -0.0F);

	            this.renderManager.itemRenderer.renderItem(par1EntityLiving, itemstack, 0);
	            }



	            GL11.glPopMatrix();
	        }
		}
    }
	
	public void renderShinigami(EntityShinigami par1, double par2, double par3, double par4, float par5, float par6)
	{
		super.doRender((EntityLiving)par1, par2, par3, par4, par5, par6);
	}


	@Override
	public void doRender(Entity par1, double par2, double par3, double par4, float par5, float par6)
	{
		this.renderShinigami((EntityShinigami) par1, par2, par3, par4, par5, par6);
	}

	protected ResourceLocation getEntityTexture(Entity entity)
	{
		switch (((EntityShinigami) entity).getTexture())
		{
			case 0:
				return texture2;
			case 1:
				return texture3;
			case 2:
				return texture4;
			case 3:
				return texture5;
			case 4:
				return texture6;
			case 5:
				return texture7;
			case 6:
				return texture8;
			case 7:
				return texture9;
			case 8:
				return texture10;
			case 9:
				return texture11;
			default:
				return texture1;

		}
	}

}
