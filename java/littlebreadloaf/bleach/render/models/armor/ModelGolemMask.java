package littlebreadloaf.bleach.render.models.armor;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
 
public class ModelGolemMask extends ModelBiped
{
  //fields
    ModelRenderer mask;
   
  public ModelGolemMask(float f)
  {
	  super(f, 0, 64, 64);
     
      mask = new ModelRenderer(this, 0, 21);
      mask.addBox(-4.3F, -8.55F, -5.7F, 10, 10, 10);
      mask.setRotationPoint(0F, 0F, 0F);
      mask.setTextureSize(64, 64);
      mask.mirror = true;
      setRotation(mask, 0F, 0.7853982F, 0F);
      
      this.bipedHead.addChild(mask);
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