
package littlebreadloaf.blocks;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelGrave extends ModelBase
{
  //fields
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape6;
    ModelRenderer Shape7;
    ModelRenderer Shape8;
    ModelRenderer Shape9;
    ModelRenderer Shape10;
    ModelRenderer Shape11;
    ModelRenderer Shape12;
  
  public ModelGrave()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      Shape1 = new ModelRenderer(this, 0, 0);
      Shape1.addBox(-4F, 12F, -4F, 8, 12, 8);
      Shape1.setRotationPoint(0F, 0F, 0F);
      Shape1.setTextureSize(64, 64);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
      Shape2 = new ModelRenderer(this, 0, 0);
      Shape2.addBox(-3F, 10F, -3F, 6, 2, 6);
      Shape2.setRotationPoint(0F, 0F, 0F);
      Shape2.setTextureSize(64, 64);
      Shape2.mirror = true;
      setRotation(Shape2, 0F, 0F, 0F);
      Shape3 = new ModelRenderer(this, 0, 0);
      Shape3.addBox(-2F, 8F, -2F, 4, 2, 4);
      Shape3.setRotationPoint(0F, 0F, 0F);
      Shape3.setTextureSize(64, 64);
      Shape3.mirror = true;
      setRotation(Shape3, 0F, 0F, 0F);
      Shape4 = new ModelRenderer(this, 0, 0);
      Shape4.addBox(-6F, -1F, -3F, 3, 3, 3);
      Shape4.setRotationPoint(0F, 24F, 0F);
      Shape4.setTextureSize(64, 64);
      Shape4.mirror = true;
      setRotation(Shape4, 0.4886922F, 0.3316126F, 0.4886922F);
      Shape5 = new ModelRenderer(this, 0, 0);
      Shape5.addBox(0F, -3F, -6F, 2, 2, 2);
      Shape5.setRotationPoint(0F, 24F, 0F);
      Shape5.setTextureSize(64, 64);
      Shape5.mirror = true;
      setRotation(Shape5, 0.3141593F, -0.296706F, 0F);
      Shape6 = new ModelRenderer(this, 0, 0);
      Shape6.addBox(-1F, -4F, -5F, 4, 2, 2);
      Shape6.setRotationPoint(0F, 24F, 0F);
      Shape6.setTextureSize(64, 64);
      Shape6.mirror = true;
      setRotation(Shape6, 0.418879F, 0.3490659F, 0.0174533F);
      Shape7 = new ModelRenderer(this, 0, 0);
      Shape7.addBox(-5F, -1F, -5F, 1, 1, 1);
      Shape7.setRotationPoint(0F, 24F, 0F);
      Shape7.setTextureSize(64, 64);
      Shape7.mirror = true;
      setRotation(Shape7, 0F, 0F, 0F);
      Shape8 = new ModelRenderer(this, 0, 0);
      Shape8.addBox(0F, 3F, 3F, 2, 2, 2);
      Shape8.setRotationPoint(0F, 24F, 0F);
      Shape8.setTextureSize(64, 64);
      Shape8.mirror = true;
      setRotation(Shape8, 0.9599311F, -0.296706F, 0.2268928F);
      Shape9 = new ModelRenderer(this, 0, 0);
      Shape9.addBox(0F, 0F, 5F, 4, 3, 2);
      Shape9.setRotationPoint(0F, 24F, 0F);
      Shape9.setTextureSize(64, 64);
      Shape9.mirror = true;
      setRotation(Shape9, 0.2792527F, 0.5759587F, -0.3141593F);
      Shape10 = new ModelRenderer(this, 0, 0);
      Shape10.addBox(-1F, -1F, 5F, 1, 1, 1);
      Shape10.setRotationPoint(0F, 24F, 0F);
      Shape10.setTextureSize(64, 64);
      Shape10.mirror = true;
      setRotation(Shape10, -0.0174533F, -0.7679449F, 0.5934119F);
      Shape11 = new ModelRenderer(this, 0, 0);
      Shape11.addBox(2F, -4F, 0F, 3, 3, 3);
      Shape11.setRotationPoint(0F, 24F, 0F);
      Shape11.setTextureSize(64, 64);
      Shape11.mirror = true;
      setRotation(Shape11, 0.4886922F, 0.3316126F, 0.4886922F);
      Shape12 = new ModelRenderer(this, 0, 0);
      Shape12.addBox(0F, -1F, 7F, 1, 1, 1);
      Shape12.setRotationPoint(0F, 24F, 0F);
      Shape12.setTextureSize(64, 64);
      Shape12.mirror = true;
      setRotation(Shape12, -0.0174533F, 0.3665191F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Shape1.render(f5);
    Shape2.render(f5);
    Shape3.render(f5);
    Shape4.render(f5);
    Shape5.render(f5);
    Shape6.render(f5);
    Shape7.render(f5);
    Shape8.render(f5);
    Shape9.render(f5);
    Shape10.render(f5);
    Shape11.render(f5);
    Shape12.render(f5);
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
