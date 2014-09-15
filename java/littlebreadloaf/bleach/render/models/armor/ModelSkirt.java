
package littlebreadloaf.bleach.render.models.armor;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelSkirt extends ModelBiped
{
  //fields
    ModelRenderer Shape13;
    ModelRenderer Shape12;
    ModelRenderer Shape11;
    ModelRenderer Shape10;
    ModelRenderer Shape9;
    ModelRenderer Shape8;
    ModelRenderer Shape7;
    ModelRenderer Shape6;
    ModelRenderer Shape5;
    ModelRenderer Shape4;
    ModelRenderer Shape3;
    ModelRenderer Shape2;
    ModelRenderer Shape1;
    ModelRenderer body;
  
  public ModelSkirt(float f)
  {
	  super(f, 0, 64, 64);
    textureWidth = 64;
    textureHeight = 64;
    
      Shape13 = new ModelRenderer(this, 4, 18);
      Shape13.addBox(-3F, 11F, 0.5F, 2, 5, 2);
      Shape13.setRotationPoint(0F, 0F, 0F);
      Shape13.setTextureSize(64, 64);
      Shape13.mirror = true;
      setRotation(Shape13, -0.2792527F, 3.141593F, 0F);
      Shape12 = new ModelRenderer(this, 4, 18);
      Shape12.addBox(-1F, 11.5F, -1F, 2, 5, 2);
      Shape12.setRotationPoint(0F, 0F, 0F);
      Shape12.setTextureSize(64, 64);
      Shape12.mirror = true;
      setRotation(Shape12, -0.2792527F, -1.570796F, 0F);
      Shape11 = new ModelRenderer(this, 4, 18);
      Shape11.addBox(-2.5F, 11.5F, -1F, 2, 5, 2);
      Shape11.setRotationPoint(0F, 0F, 0F);
      Shape11.setTextureSize(64, 64);
      Shape11.mirror = true;
      setRotation(Shape11, -0.2792527F, -2.356194F, 0F);
      Shape10 = new ModelRenderer(this, 4, 18);
      Shape10.addBox(0.5F, 11.5F, -1F, 2, 5, 2);
      Shape10.setRotationPoint(0F, 0F, 0F);
      Shape10.setTextureSize(64, 64);
      Shape10.mirror = true;
      setRotation(Shape10, -0.2792527F, -0.7853982F, 0F);
      Shape9 = new ModelRenderer(this, 4, 18);
      Shape9.addBox(1F, 11F, 0.5F, 2, 5, 2);
      Shape9.setRotationPoint(0F, 0F, 0F);
      Shape9.setTextureSize(64, 64);
      Shape9.mirror = true;
      setRotation(Shape9, -0.2792527F, 0F, 0F);
      Shape8 = new ModelRenderer(this, 4, 18);
      Shape8.addBox(-1F, 11.5F, -1F, 2, 5, 2);
      Shape8.setRotationPoint(0F, 0F, 0F);
      Shape8.setTextureSize(64, 64);
      Shape8.mirror = true;
      setRotation(Shape8, -0.2792527F, 1.570796F, 0F);
      Shape7 = new ModelRenderer(this, 4, 18);
      Shape7.addBox(1F, 11F, 0.5F, 2, 5, 2);
      Shape7.setRotationPoint(0F, 0F, 0F);
      Shape7.setTextureSize(64, 64);
      Shape7.mirror = true;
      setRotation(Shape7, -0.2792527F, 3.141593F, 0F);
      Shape6 = new ModelRenderer(this, 4, 18);
      Shape6.addBox(-3F, 11F, 0.5F, 2, 5, 2);
      Shape6.setRotationPoint(0F, 0F, 0F);
      Shape6.setTextureSize(64, 64);
      Shape6.mirror = true;
      setRotation(Shape6, -0.2792527F, 0F, 0F);
      Shape5 = new ModelRenderer(this, 4, 18);
      Shape5.addBox(-2.5F, 11.5F, -1F, 2, 5, 2);
      Shape5.setRotationPoint(0F, 0F, 0F);
      Shape5.setTextureSize(64, 64);
      Shape5.mirror = true;
      setRotation(Shape5, -0.2792527F, 0.7853982F, 0F);
      Shape4 = new ModelRenderer(this, 4, 18);
      Shape4.addBox(0.5F, 11.5F, -1F, 2, 5, 2);
      Shape4.setRotationPoint(0F, 0F, 0F);
      Shape4.setTextureSize(64, 64);
      Shape4.mirror = true;
      setRotation(Shape4, -0.2792527F, 2.356194F, 0F);
      Shape3 = new ModelRenderer(this, 4, 18);
      Shape3.addBox(-1F, 11F, 1F, 2, 5, 2);
      Shape3.setRotationPoint(0F, 0F, 0F);
      Shape3.setTextureSize(64, 64);
      Shape3.mirror = true;
      setRotation(Shape3, -0.2792527F, 3.141593F, 0F);
      Shape2 = new ModelRenderer(this, 4, 18);
      Shape2.addBox(-1F, 11F, 1F, 2, 5, 2);
      Shape2.setRotationPoint(0F, 0F, 0F);
      Shape2.setTextureSize(64, 64);
      Shape2.mirror = true;
      setRotation(Shape2, -0.2792527F, 0F, 0F);
      Shape1 = new ModelRenderer(this, 4, 18);
      Shape1.addBox(-1F, 11.5F, -1F, 2, 5, 2);
      Shape1.setRotationPoint(0F, 0F, 0F);
      Shape1.setTextureSize(64, 64);
      Shape1.mirror = true;
      setRotation(Shape1, -0.2792527F, 1.570796F, 0F);
      body = new ModelRenderer(this, 16, 16);
      body.addBox(-4F, 0F, -2F, 8, 12, 4);
      body.setRotationPoint(0F, 0F, 0F);
      body.setTextureSize(64, 64);
      body.mirror = true;
      setRotation(body, 0F, 0F, 0F);
      
      this.bipedBody.addChild(body);
      this.bipedBody.addChild(Shape1);
      this.bipedBody.addChild(Shape2);
      this.bipedBody.addChild(Shape3);
      this.bipedBody.addChild(Shape4);
      this.bipedBody.addChild(Shape5);
      this.bipedBody.addChild(Shape6);
      this.bipedBody.addChild(Shape7);
      this.bipedBody.addChild(Shape8);
      this.bipedBody.addChild(Shape9);
      this.bipedBody.addChild(Shape10);
      this.bipedBody.addChild(Shape11);
      this.bipedBody.addChild(Shape12);
      this.bipedBody.addChild(Shape13);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
//    Shape13.render(f5);
//    Shape12.render(f5);
//    Shape11.render(f5);
//    Shape10.render(f5);
//    Shape9.render(f5);
//    Shape8.render(f5);
//    Shape7.render(f5);
//    Shape6.render(f5);
//    Shape5.render(f5);
//    Shape4.render(f5);
//    Shape3.render(f5);
//    Shape2.render(f5);
//    Shape1.render(f5);
//    body.render(f5);
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
