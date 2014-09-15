
package littlebreadloaf.bleach.render.models.armor;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
 
public class ModelSnakeMask extends ModelBiped
{
  //fields
    ModelRenderer mask;
    ModelRenderer bottom_jaw;
   
  public ModelSnakeMask(float f)
  {
	  super(f, 0, 128, 128);
    textureWidth = 128;
    textureHeight = 128;
     
      mask = new ModelRenderer(this, 0, 20);
      mask.addBox(-3.3F, -8.5F, -6.3F, 9, 9, 9);
      mask.setRotationPoint(0F, 0F, 0F);
      mask.setTextureSize(128, 128);
      mask.mirror = true;
      setRotation(mask, 0F, 0.7853982F, 0F);
      bottom_jaw = new ModelRenderer(this, 0, 39);
      bottom_jaw.addBox(-2.5F, -3F, -8.5F, 5, 6, 9);
      bottom_jaw.setRotationPoint(0F, 0F, 0F);
      bottom_jaw.setTextureSize(128, 128);
      bottom_jaw.mirror = true;
      setRotation(bottom_jaw, 0F, 0F, 0F);
      
      this.bipedHead.addChild(mask);
      this.bipedHead.addChild(bottom_jaw);
  }
   
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);

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