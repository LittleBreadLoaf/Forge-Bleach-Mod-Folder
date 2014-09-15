package littlebreadloaf.bleach.render.models.armor;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelWolfMask  extends ModelBiped
{
  //fields
    ModelRenderer WolfHead;
    ModelRenderer Nose;
   
  public ModelWolfMask(float f)
  {
	  super(f, 0, 128, 128);
    textureWidth = 128;
    textureHeight = 128;
     
      WolfHead = new ModelRenderer(this, 0, 0);
      WolfHead.addBox(-4F, -8F, -4F, 8, 8, 8);
      WolfHead.setRotationPoint(0F, 0F, 0F);
      WolfHead.setTextureSize(128, 128);
      WolfHead.mirror = true;
      setRotation(WolfHead, 0F, 0F, 0F);
      Nose = new ModelRenderer(this, 0, 20);
      Nose.addBox(-3F, -5F, -8F, 6, 4, 6);
      Nose.setRotationPoint(0F, 0F, 0F);
      Nose.setTextureSize(128, 128);
      Nose.mirror = true;
      setRotation(Nose, 0F, 0F, 0F);
      
      this.bipedHead.addChild(WolfHead);
      this.bipedHead.addChild(Nose);
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