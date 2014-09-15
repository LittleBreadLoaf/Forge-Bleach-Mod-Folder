package littlebreadloaf.bleach.render.models.armor;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
 
public class ModelStalkerMask extends ModelBiped
{
  //fields
    ModelRenderer jaw;
    ModelRenderer head;
    ModelRenderer hornLF;
    ModelRenderer hornLB;
    ModelRenderer hornRF;
    ModelRenderer hornRB;
   
  public ModelStalkerMask(float f)
  {
	  super(f, 0, 64, 64);
    textureWidth = 64;
    textureHeight = 64;
     
      jaw = new ModelRenderer(this, 0, 16);
      jaw.addBox(-3F, -3F, -6.5F, 6, 3, 4);
      jaw.setRotationPoint(0F, 0F, 0F);
      jaw.setTextureSize(64, 64);
      jaw.mirror = true;
      setRotation(jaw, 0.2443461F, 0F, 0F);
      head = new ModelRenderer(this, 0, 0);
      head.addBox(-4F, -8F, -7F, 8, 7, 8);
      head.setRotationPoint(0F, 0F, 0F);
      head.setTextureSize(64, 64);
      head.mirror = true;
      setRotation(head, -0.0349066F, 0F, 0F);
      hornLF = new ModelRenderer(this, 0, 0);
      hornLF.addBox(2F, -9F, -7F, 1, 2, 1);
      hornLF.setRotationPoint(0F, 0F, 0F);
      hornLF.setTextureSize(64, 64);
      hornLF.mirror = true;
      setRotation(hornLF, 0F, 0F, 0F);
      hornLB = new ModelRenderer(this, 16, 20);
      hornLB.addBox(3F, -8.5F, -1.5F, 3, 4, 5);
      hornLB.setRotationPoint(0F, 0F, 0F);
      hornLB.setTextureSize(64, 64);
      hornLB.mirror = true;
      setRotation(hornLB, 0.2617994F, 0.5235988F, 0F);
      hornRF = new ModelRenderer(this, 0, 0);
      hornRF.addBox(-3F, -9F, -7F, 1, 2, 1);
      hornRF.setRotationPoint(0F, 0F, 0F);
      hornRF.setTextureSize(64, 64);
      hornRF.mirror = true;
      setRotation(hornRF, 0F, 0F, 0F);
      hornRB = new ModelRenderer(this, 16, 20);
      hornRB.addBox(-6F, -8.5F, -1.5F, 3, 4, 5);
      hornRB.setRotationPoint(0F, 0F, 0F);
      hornRB.setTextureSize(64, 64);
      hornRB.mirror = true;
      setRotation(hornRB, 0.2617994F, -0.5235988F, 0F);
      
      this.bipedHead.addChild(jaw);
      this.bipedHead.addChild(head);
      this.bipedHead.addChild(hornLF);
      this.bipedHead.addChild(hornLB);
      this.bipedHead.addChild(hornRF);
      this.bipedHead.addChild(hornRB);
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