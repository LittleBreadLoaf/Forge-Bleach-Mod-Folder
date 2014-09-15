package littlebreadloaf.bleach.render.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelBlock extends ModelBase
{

    ModelRenderer block;
    
    public ModelBlock()
    {
      textureWidth = 16;
      textureHeight = 16;
      
        block = new ModelRenderer(this, 0, 0);
        block.addBox(-4F, -8F, -4F, 8, 8, 8);
        block.setRotationPoint(0F, 0F, 0F);
        block.setTextureSize(16, 16);
        block.mirror = true;
        setRotation(block, 0F, 0F, 0F);
    }

    
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
      super.render(entity, f, f1, f2, f3, f4, f5);
      setRotationAngles(f, f1, f2, f3, f4, f5, entity);
      block.render(f5);
    }
    
    
    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
      model.rotateAngleX = x;
      model.rotateAngleY = y;
      model.rotateAngleZ = z;
    }
    
    
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
    {
      super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
      block.rotateAngleX = -0.25F*(MathHelper.cos(f2 * 0.06662F * 1.5F) );
      block.rotateAngleZ = -0.35F*(MathHelper.sin(f2 * 0.16662F * 1.5F) );
    }
}
