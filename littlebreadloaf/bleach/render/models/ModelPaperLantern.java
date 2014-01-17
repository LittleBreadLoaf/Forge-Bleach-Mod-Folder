
package littlebreadloaf.bleach.render.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelPaperLantern extends ModelBase
{
  //fields
    ModelRenderer b5;
    ModelRenderer b4;
    ModelRenderer b3;
    ModelRenderer b2;
    ModelRenderer b1;
    ModelRenderer b6;
    ModelRenderer b7;
    ModelRenderer b8;
    ModelRenderer b9;
  
  public ModelPaperLantern()
  {
    textureWidth = 64;
    textureHeight = 128;
    
      b5 = new ModelRenderer(this, 0, 41);
      b5.addBox(-7F, 0F, -7F, 14, 6, 14);
      b5.setRotationPoint(0F, 0F, 0F);
      b5.setTextureSize(64, 128);
      b5.mirror = true;
      setRotation(b5, 0F, 0F, 0F);
      b4 = new ModelRenderer(this, 0, 27);
      b4.addBox(-6F, -2F, -6F, 12, 2, 12);
      b4.setRotationPoint(0F, 0F, 0F);
      b4.setTextureSize(64, 128);
      b4.mirror = true;
      setRotation(b4, 0F, 0F, 0F);
      b3 = new ModelRenderer(this, 0, 16);
      b3.addBox(-5F, -3F, -5F, 10, 1, 10);
      b3.setRotationPoint(0F, 0F, 0F);
      b3.setTextureSize(64, 128);
      b3.mirror = true;
      setRotation(b3, 0F, 0F, 0F);
      b2 = new ModelRenderer(this, 0, 7);
      b2.addBox(-4F, -4F, -4F, 8, 1, 8);
      b2.setRotationPoint(0F, 0F, 0F);
      b2.setTextureSize(64, 128);
      b2.mirror = true;
      setRotation(b2, 0F, 0F, 0F);
      b1 = new ModelRenderer(this, 0, 0);
      b1.addBox(-3F, -5F, -3F, 6, 1, 6);
      b1.setRotationPoint(0F, 0F, 0F);
      b1.setTextureSize(64, 128);
      b1.mirror = true;
      setRotation(b1, 0F, 0F, 0F);
      b6 = new ModelRenderer(this, 0, 61);
      b6.addBox(-6F, 6F, -6F, 12, 2, 12);
      b6.setRotationPoint(0F, 0F, 0F);
      b6.setTextureSize(64, 128);
      b6.mirror = true;
      setRotation(b6, 0F, 0F, 0F);
      b7 = new ModelRenderer(this, 0, 75);
      b7.addBox(-5F, 8F, -5F, 10, 1, 10);
      b7.setRotationPoint(0F, 0F, 0F);
      b7.setTextureSize(64, 128);
      b7.mirror = true;
      setRotation(b7, 0F, 0F, 0F);
      b8 = new ModelRenderer(this, 0, 86);
      b8.addBox(-4F, 9F, -4F, 8, 1, 8);
      b8.setRotationPoint(0F, 0F, 0F);
      b8.setTextureSize(64, 128);
      b8.mirror = true;
      setRotation(b8, 0F, 0F, 0F);
      b9 = new ModelRenderer(this, 0, 95);
      b9.addBox(-3F, 10F, -3F, 6, 1, 6);
      b9.setRotationPoint(0F, 0F, 0F);
      b9.setTextureSize(64, 128);
      b9.mirror = true;
      setRotation(b9, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    b5.render(f5);
    b4.render(f5);
    b3.render(f5);
    b2.render(f5);
    b1.render(f5);
    b6.render(f5);
    b7.render(f5);
    b8.render(f5);
    b9.render(f5);
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
  }

}
