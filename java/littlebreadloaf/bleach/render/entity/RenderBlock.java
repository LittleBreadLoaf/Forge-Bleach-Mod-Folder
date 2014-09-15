package littlebreadloaf.bleach.render.entity;

import org.lwjgl.opengl.GL11;

import littlebreadloaf.bleach.entities.EntityAshido;
import littlebreadloaf.bleach.entities.EntityBlock;
import littlebreadloaf.bleach.render.models.ModelBlock;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderBlock extends Render 
{
	
	private static final ResourceLocation blockDirt = new ResourceLocation("bleach:textures/blocks/dirt.png");
	private static final ResourceLocation blockStone = new ResourceLocation("bleach:textures/blocks/stone.png");
	protected ModelBlock model;
	
	
	
	public RenderBlock() 
	{
		model = new ModelBlock();
	}

	@Override
	public void doRender(Entity var1, double var2, double var4, double var6, float var8, float var9) 
	{
		this.renderBlock((EntityBlock)var1, var2, var4, var6, var8, var9);

	}

	private void renderBlock(EntityBlock var1, double var2, double var4, double var6, float var8, float var9) 
	{	
		GL11.glPushMatrix();
		GL11.glTranslated(var2, var4, var6);
		
		float f4 = 0.75F;
        GL11.glScalef(f4, f4, f4);
        GL11.glScalef(1.0F / f4, 1.0F / f4, 1.0F / f4);
        this.bindEntityTexture(var1);
        GL11.glScalef(-1.0F, -1.0F, 1.0F);
        this.model.render(var1, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        GL11.glPopMatrix();
		
	}

	protected ResourceLocation getBlockTextures(EntityBlock par1EntityBoat)
    {
        return blockDirt;
    }

	@Override
	protected ResourceLocation getEntityTexture(Entity var1) 
	{
		
		return this.getBlockTextures((EntityBlock)var1);
	}

}
