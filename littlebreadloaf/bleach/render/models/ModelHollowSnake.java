package littlebreadloaf.bleach.render.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelHollowSnake extends ModelBase
{
  //fields
    ModelRenderer head_top;
    ModelRenderer mask;
    ModelRenderer bottom_jaw;
    ModelRenderer neck;
    ModelRenderer uppertorso;
    ModelRenderer lowertorso;
    ModelRenderer L_lower_arm;
    ModelRenderer L_upper_arm;
    ModelRenderer Lshoulder;
    ModelRenderer R_lower_arm;
    ModelRenderer R_upper_arm;
    ModelRenderer Rshoulder;
    ModelRenderer waist1;
    ModelRenderer waist2;
    ModelRenderer waist3;
    ModelRenderer waist4;
    ModelRenderer tail1;
    ModelRenderer tail2;
    ModelRenderer tail3;
    ModelRenderer tail4;
  
  public ModelHollowSnake()
  {
    textureWidth = 128;
    textureHeight = 128;
    
     head_top = new ModelRenderer(this, 0, 0);
    head_top.addBox(-13.3F, -44F, 5F, 8, 8, 8);
    head_top.setRotationPoint(-3F, 17F, -12F);
    head_top.setTextureSize(128, 128);
    head_top.mirror = true;
    setRotation(head_top, 0.2617994F, 0.7679449F, 0.2600541F);
    mask = new ModelRenderer(this, 0, 20);
    mask.addBox(-13.8F, -44.5F, 4.5F, 9, 9, 9);
    mask.setRotationPoint(-3F, 17F, -12F);
    mask.setTextureSize(128, 128);
    mask.mirror = true;
    setRotation(mask, 0.2617994F, 0.7679449F, 0.2600541F);
      bottom_jaw = new ModelRenderer(this, 0, 39);
      bottom_jaw.addBox(-2.5F, -39F, -7F, 5, 6, 9);
      bottom_jaw.setRotationPoint(0F, 17F, -5F);
      bottom_jaw.setTextureSize(128, 128);
      bottom_jaw.mirror = true;
      setRotation(bottom_jaw, 0F, 0F, 0F);
      neck = new ModelRenderer(this, 48, 0);
      neck.addBox(-3F, -32F, 25F, 6, 11, 8);
      neck.setRotationPoint(0F, 17F, -3F);
      neck.setTextureSize(128, 128);
      neck.mirror = true;
      setRotation(neck, 0.7853982F, 0F, 0F);
      uppertorso = new ModelRenderer(this, 80, 0);
      uppertorso.addBox(-6F, -30F, 13F, 12, 10, 12);
      uppertorso.setRotationPoint(0F, 17F, -3F);
      uppertorso.setTextureSize(128, 128);
      uppertorso.mirror = true;
      setRotation(uppertorso, 0.4712389F, 0F, 0F);
      lowertorso = new ModelRenderer(this, 43, 21);
      lowertorso.addBox(-4F, -30F, -4F, 8, 17, 8);
      lowertorso.setRotationPoint(0F, 17F, -3F);
      lowertorso.setTextureSize(128, 128);
      lowertorso.mirror = true;
      setRotation(lowertorso, -0.2617994F, 0F, 0F);
      L_lower_arm = new ModelRenderer(this, 1, 68);
      L_lower_arm.addBox(7.5F, -8F, 11F, 5, 5, 15);
      L_lower_arm.setRotationPoint(0F, 17F, -3F);
      L_lower_arm.setTextureSize(128, 128);
      L_lower_arm.mirror = true;
      setRotation(L_lower_arm, 1.047198F, 0F, 0F);
      L_upper_arm = new ModelRenderer(this, 0, 68);
      L_upper_arm.addBox(8F, -31F, 6F, 4, 8, 4);
      L_upper_arm.setRotationPoint(0F, 17F, -3F);
      L_upper_arm.setTextureSize(128, 128);
      L_upper_arm.mirror = true;
      setRotation(L_upper_arm, 0F, 0F, 0F);
      Lshoulder = new ModelRenderer(this, 0, 54);
      Lshoulder.addBox(6F, -38F, 5F, 7, 7, 7);
      Lshoulder.setRotationPoint(0F, 17F, -3F);
      Lshoulder.setTextureSize(128, 128);
      Lshoulder.mirror = true;
      setRotation(Lshoulder, 0F, 0F, 0F);
      R_lower_arm = new ModelRenderer(this, 1, 102);
      R_lower_arm.addBox(-12.5F, -8F, 11F, 5, 5, 15);
      R_lower_arm.setRotationPoint(0F, 17F, -3F);
      R_lower_arm.setTextureSize(128, 128);
      R_lower_arm.mirror = true;
      setRotation(R_lower_arm, 1.047198F, 0F, 0F);
      R_upper_arm = new ModelRenderer(this, 0, 102);
      R_upper_arm.addBox(-12F, -31F, 6F, 4, 8, 4);
      R_upper_arm.setRotationPoint(0F, 17F, -3F);
      R_upper_arm.setTextureSize(128, 128);
      R_upper_arm.mirror = true;
      setRotation(R_upper_arm, 0F, 0F, 0F);
      Rshoulder = new ModelRenderer(this, 0, 88);
      Rshoulder.addBox(-13F, -38F, 5F, 7, 7, 7);
      Rshoulder.setRotationPoint(0F, 17F, -3F);
      Rshoulder.setTextureSize(128, 128);
      Rshoulder.mirror = true;
      setRotation(Rshoulder, 0F, 0F, 0F);
      waist1 = new ModelRenderer(this, 77, 25);
      waist1.addBox(-5.5F, -11F, -13F, 11, 7, 11);
      waist1.setRotationPoint(0F, 17F, 3F);
      waist1.setTextureSize(128, 128);
      waist1.mirror = true;
      setRotation(waist1, -0.5235988F, 0F, 0F);
      waist2 = new ModelRenderer(this, 47, 46);
      waist2.addBox(-5F, -8.5F, -5.5F, 10, 8, 10);
      waist2.setRotationPoint(0F, 17F, -3F);
      waist2.setTextureSize(128, 128);
      waist2.mirror = true;
      setRotation(waist2, -0.2617994F, 0F, 0F);
      waist3 = new ModelRenderer(this, 87, 44);
      waist3.addBox(-4.5F, -2F, -5F, 9, 3, 10);
      waist3.setRotationPoint(0F, 17F, -3F);
      waist3.setTextureSize(128, 128);
      waist3.mirror = true;
      setRotation(waist3, 0F, 0F, 0F);
      waist4 = new ModelRenderer(this, 41, 65);
      waist4.addBox(-4F, -2.5F, -4F, 8, 8, 9);
      waist4.setRotationPoint(0F, 17F, -3F);
      waist4.setTextureSize(128, 128);
      waist4.mirror = true;
      setRotation(waist4, 0.7853982F, 0F, 0F);
      tail1 = new ModelRenderer(this, 77, 65);
      tail1.addBox(-3.5F, -5F, -2F, 7, 7, 10);
      tail1.setRotationPoint(0F, 22F, 0F);
      tail1.setTextureSize(128, 128);
      tail1.mirror = true;
      setRotation(tail1, 0F, 0F, 0F);
      tail2 = new ModelRenderer(this, 77, 65);
      tail2.addBox(-3.5F, -5F, 8F, 7, 7, 10);
      tail2.setRotationPoint(0F, 22F, 0F);
      tail2.setTextureSize(128, 128);
      tail2.mirror = true;
      setRotation(tail2, 0F, 0F, 0F);
      tail3 = new ModelRenderer(this, 45, 83);
      tail3.addBox(-3F, -4F, 18F, 6, 6, 10);
      tail3.setRotationPoint(0F, 22F, 0F);
      tail3.setTextureSize(128, 128);
      tail3.mirror = true;
      setRotation(tail3, 0F, 0F, 0F);
      tail4 = new ModelRenderer(this, 86, 82);
      tail4.addBox(-2F, -2F, 28F, 4, 4, 8);
      tail4.setRotationPoint(0F, 22F, 0F);
      tail4.setTextureSize(128, 128);
      tail4.mirror = true;
      setRotation(tail4, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    head_top.render(f5);
    mask.render(f5);
    bottom_jaw.render(f5);
    neck.render(f5);
    uppertorso.render(f5);
    lowertorso.render(f5);
    L_lower_arm.render(f5);
    L_upper_arm.render(f5);
    Lshoulder.render(f5);
    R_lower_arm.render(f5);
    R_upper_arm.render(f5);
    Rshoulder.render(f5);
    waist1.render(f5);
    waist2.render(f5);
    waist3.render(f5);
    waist4.render(f5);
    tail1.render(f5);
    tail2.render(f5);
    tail3.render(f5);
    tail4.render(f5);
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
    this.R_upper_arm.rotateAngleX = -MathHelper.cos(f * 0.6662F) * 1.0F * f1 * 0.23F;
    this.L_upper_arm.rotateAngleX = -MathHelper.cos(f * 0.6662F) * 1.0F * f1 * 0.23F;
    this.R_lower_arm.rotateAngleX = -MathHelper.cos(f * 0.6662F) * 1.0F * f1 * 0.23F + 1.0F;
    this.L_lower_arm.rotateAngleX = -MathHelper.cos(f * 0.6662F) * 1.0F * f1 * 0.23F + 1.0F;
    this.Lshoulder.rotateAngleX = -MathHelper.cos(f * 0.6662F) * 1.0F * f1 * 0.21F;
    this.Rshoulder.rotateAngleX = -MathHelper.cos(f * 0.6662F) * 1.0F * f1 * 0.21F;
    
    this.uppertorso.rotateAngleX = -MathHelper.cos(f * 0.6662F) * 1.0F * f1 * 0.17F + 0.4712389F;
    this.lowertorso.rotateAngleX = -MathHelper.cos(f * 0.6662F) * 1.0F * f1 * 0.2F - 0.2617994F;
    this.waist1.rotateAngleX = -MathHelper.cos(f * 0.6662F) * 1.0F * f1 * 0.2F - 0.5235988F;
    this.waist2.rotateAngleX = -MathHelper.cos(f * 0.6662F) * 1.0F * f1 * 0.2F - 0.2617994F;
    this.neck.rotateAngleX = -MathHelper.cos(f * 0.6662F) * 1.0F * f1 * 0.16F + 0.78F;
    this.bottom_jaw.rotateAngleX = -MathHelper.cos(f * 0.6662F) * 1.0F * f1 * 0.1F;
    
    this.head_top.rotateAngleX = -MathHelper.cos((float) (f * 0.6662F)) * f1 * 0.2F + 0.2617994F;
    this.mask.rotateAngleX = -MathHelper.cos((float) (f * 0.6662F)) * f1 * 0.2F + 0.2617994F;
    this.head_top.rotateAngleZ = -MathHelper.cos((float) (f * 0.6662F)) * f1 * 0.1F + 0.2617994F;
    this.mask.rotateAngleZ = -MathHelper.cos((float) (f * 0.6662F)) * f1 * 0.1F + 0.2617994F;

    


    

    
    this.tail1.rotateAngleY = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 0.1F * f1 * 0.5F;
    this.tail2.rotateAngleY = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 0.3F * f1 * 0.5F;
    this.tail3.rotateAngleY = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 0.5F * f1 * 0.5F;
    this.tail4.rotateAngleY = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 0.7F * f1 * 0.5F;
  }

}




