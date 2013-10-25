package littlebreadloaf.entities.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelHollowGolem extends ModelBase
{
  //fields
    ModelRenderer uppertorso;
    ModelRenderer FR_spike;
    ModelRenderer FL_spike;
    ModelRenderer BL_spike;
    ModelRenderer BR_spike;
    ModelRenderer lower_torso;
    ModelRenderer head;
    ModelRenderer mask;
    ModelRenderer upper_arm_R;
    ModelRenderer lower_arm_R;
    ModelRenderer shoulderR;
    ModelRenderer lower_arm_armor_R;
    ModelRenderer armor_R_shoulder;
    ModelRenderer lower_leg_R;
    ModelRenderer upper_leg_R;
    ModelRenderer upper_arm_L;
    ModelRenderer lower_arm_L;
    ModelRenderer shoulderL;
    ModelRenderer lower_arm_armor_L;
    ModelRenderer armor_L_shoulder;
    ModelRenderer lower_leg_L;
    ModelRenderer upper_leg_L;
  
  public ModelHollowGolem()
  {
    textureWidth = 128;
    textureHeight = 128;
    
      uppertorso = new ModelRenderer(this, 64, 0);
      uppertorso.addBox(-8F, -7F, -7F, 16, 16, 16);
      uppertorso.setRotationPoint(0F, 0F, 0F);
      uppertorso.setTextureSize(128, 128);
      uppertorso.mirror = true;
      setRotation(uppertorso, 0F, 0F, 0F);
      FR_spike = new ModelRenderer(this, 71, 0);
      FR_spike.addBox(-5F, -14F, -5F, 2, 9, 2);
      FR_spike.setRotationPoint(0F, 0F, 0F);
      FR_spike.setTextureSize(128, 128);
      FR_spike.mirror = true;
      setRotation(FR_spike, -0.7853982F, -0.3490659F, 0F);
      FL_spike = new ModelRenderer(this, 71, 0);
      FL_spike.addBox(2F, -14F, -5F, 2, 9, 2);
      FL_spike.setRotationPoint(0F, 0F, 0F);
      FL_spike.setTextureSize(128, 128);
      FL_spike.mirror = true;
      setRotation(FL_spike, -0.7853982F, 0.3490659F, 0F);
      BL_spike = new ModelRenderer(this, 63, 0);
      BL_spike.addBox(1F, -19F, 2F, 2, 9, 2);
      BL_spike.setRotationPoint(0F, 0F, 0F);
      BL_spike.setTextureSize(128, 128);
      BL_spike.mirror = true;
      setRotation(BL_spike, -0.7853982F, 0.2617994F, 0F);
      BR_spike = new ModelRenderer(this, 63, 0);
      BR_spike.addBox(-4F, -19F, 2F, 2, 9, 2);
      BR_spike.setRotationPoint(0F, 0F, 0F);
      BR_spike.setTextureSize(128, 128);
      BR_spike.mirror = true;
      setRotation(BR_spike, -0.7853982F, -0.2617994F, 0F);
      lower_torso = new ModelRenderer(this, 81, 32);
      lower_torso.addBox(-3F, 9F, -4F, 6, 5, 10);
      lower_torso.setRotationPoint(0F, 0F, 0F);
      lower_torso.setTextureSize(128, 128);
      lower_torso.mirror = true;
      setRotation(lower_torso, 0F, 0F, 0F);
      head = new ModelRenderer(this, 0, 0);
      head.addBox(-5F, -7F, -5F, 10, 10, 10);
      head.setRotationPoint(0F, -5F, -6F);
      head.setTextureSize(128, 128);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      mask = new ModelRenderer(this, 0, 21);
      mask.addBox(-4F, -8.2F, -6F, 10, 10, 10);
      mask.setRotationPoint(0F, -5F, -6F);
      mask.setTextureSize(128, 128);
      mask.mirror = true;
      setRotation(mask, 0.2094395F, 0.7853982F, 0.2094395F);
      upper_arm_R = new ModelRenderer(this, 3, 65);
      upper_arm_R.addBox(-2F, 4F, 0F, 3, 9, 3);
      upper_arm_R.setRotationPoint(-10F, -6F, 0F);
      upper_arm_R.setTextureSize(128, 128);
      upper_arm_R.mirror = true;
      setRotation(upper_arm_R, 0F, 0F, 0.2617994F);
      lower_arm_R = new ModelRenderer(this, 0, 79);
      lower_arm_R.addBox(-4F, 9F, -16F, 6, 7, 13);
      lower_arm_R.setRotationPoint(-10F, -6F, 0F);
      lower_arm_R.setTextureSize(128, 128);
      lower_arm_R.mirror = true;
      setRotation(lower_arm_R, 0.5235988F, 0F, 0.2617994F);
      shoulderR = new ModelRenderer(this, 0, 49);
      shoulderR.addBox(-5F, -3F, -2F, 7, 7, 7);
      shoulderR.setRotationPoint(-10F, -6F, 0F);
      shoulderR.setTextureSize(128, 128);
      shoulderR.mirror = true;
      setRotation(shoulderR, 0F, 0F, 0F);
      lower_arm_armor_R = new ModelRenderer(this, 36, 99);
      lower_arm_armor_R.addBox(-4.5F, 8.5F, -16.5F, 7, 8, 14);
      lower_arm_armor_R.setRotationPoint(-10F, -6F, 0F);
      lower_arm_armor_R.setTextureSize(128, 128);
      lower_arm_armor_R.mirror = true;
      setRotation(lower_arm_armor_R, 0.5235988F, 0F, 0.2617994F);
      armor_R_shoulder = new ModelRenderer(this, 38, 81);
      armor_R_shoulder.addBox(-6F, -4F, -3F, 9, 7, 9);
      armor_R_shoulder.setRotationPoint(-10F, -6F, 0F);
      armor_R_shoulder.setTextureSize(128, 128);
      armor_R_shoulder.mirror = true;
      setRotation(armor_R_shoulder, 0F, 0F, 0F);
      lower_leg_R = new ModelRenderer(this, 87, 48);
      lower_leg_R.addBox(-4F, 4F, -7F, 6, 9, 8);
      lower_leg_R.setRotationPoint(-4F, 11F, 2F);
      lower_leg_R.setTextureSize(128, 128);
      lower_leg_R.mirror = true;
      setRotation(lower_leg_R, 0F, 0F, 0F);
      upper_leg_R = new ModelRenderer(this, 68, 48);
      upper_leg_R.addBox(-3F, -1F, -2F, 4, 9, 5);
      upper_leg_R.setRotationPoint(-4F, 11F, 2F);
      upper_leg_R.setTextureSize(128, 128);
      upper_leg_R.mirror = true;
      setRotation(upper_leg_R, -0.7853982F, 0F, 0F);
      upper_arm_L = new ModelRenderer(this, 3, 65);
      upper_arm_L.addBox(0F, 4F, 0F, 3, 9, 3);
      upper_arm_L.setRotationPoint(10F, -6F, 0F);
      upper_arm_L.setTextureSize(128, 128);
      upper_arm_L.mirror = true;
      setRotation(upper_arm_L, 0F, 0F, -0.2617994F);
      lower_arm_L = new ModelRenderer(this, 0, 79);
      lower_arm_L.addBox(-1F, 9F, -16F, 6, 7, 13);
      lower_arm_L.setRotationPoint(10F, -6F, 0F);
      lower_arm_L.setTextureSize(128, 128);
      lower_arm_L.mirror = true;
      setRotation(lower_arm_L, 0.5235988F, 0F, -0.2617994F);
      shoulderL = new ModelRenderer(this, 0, 49);
      shoulderL.addBox(-2F, -3F, -2F, 7, 7, 7);
      shoulderL.setRotationPoint(10F, -6F, 0F);
      shoulderL.setTextureSize(128, 128);
      shoulderL.mirror = true;
      setRotation(shoulderL, 0F, 0F, 0F);
      lower_arm_armor_L = new ModelRenderer(this, 78, 99);
      lower_arm_armor_L.addBox(-1.5F, 8.5F, -16.5F, 7, 8, 14);
      lower_arm_armor_L.setRotationPoint(10F, -6F, 0F);
      lower_arm_armor_L.setTextureSize(128, 128);
      lower_arm_armor_L.mirror = true;
      setRotation(lower_arm_armor_L, 0.5235988F, 0F, -0.2617994F);
      armor_L_shoulder = new ModelRenderer(this, 0, 99);
      armor_L_shoulder.addBox(-3F, -4F, -3F, 9, 7, 9);
      armor_L_shoulder.setRotationPoint(10F, -6F, 0F);
      armor_L_shoulder.setTextureSize(128, 128);
      armor_L_shoulder.mirror = true;
      setRotation(armor_L_shoulder, 0F, 0F, 0F);
      lower_leg_L = new ModelRenderer(this, 87, 48);
      lower_leg_L.addBox(-2F, 4F, -7F, 6, 9, 8);
      lower_leg_L.setRotationPoint(4F, 11F, 2F);
      lower_leg_L.setTextureSize(128, 128);
      lower_leg_L.mirror = true;
      setRotation(lower_leg_L, 0F, 0F, 0F);
      upper_leg_L = new ModelRenderer(this, 68, 48);
      upper_leg_L.addBox(-1F, -1F, -2F, 4, 9, 5);
      upper_leg_L.setRotationPoint(4F, 11F, 2F);
      upper_leg_L.setTextureSize(128, 128);
      upper_leg_L.mirror = true;
      setRotation(upper_leg_L, -0.7853982F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    uppertorso.render(f5);
    FR_spike.render(f5);
    FL_spike.render(f5);
    BL_spike.render(f5);
    BR_spike.render(f5);
    lower_torso.render(f5);
    head.render(f5);
    mask.render(f5);
    upper_arm_R.render(f5);
    lower_arm_R.render(f5);
    shoulderR.render(f5);
    lower_arm_armor_R.render(f5);
    armor_R_shoulder.render(f5);
    lower_leg_R.render(f5);
    upper_leg_R.render(f5);
    upper_arm_L.render(f5);
    lower_arm_L.render(f5);
    shoulderL.render(f5);
    lower_arm_armor_L.render(f5);
    armor_L_shoulder.render(f5);
    lower_leg_L.render(f5);
    upper_leg_L.render(f5);
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
    this.mask.rotateAngleZ = 0.165F;
    
    this.upper_arm_R.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 2.0F * f1 * 0.5F;
    this.upper_arm_L.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F;
    this.upper_arm_R.rotateAngleZ = 0.3F;
    this.upper_arm_L.rotateAngleZ = -0.3F;
    this.lower_arm_R.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 2.0F * f1 * 0.5F + 0.52F;
    this.lower_arm_L.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F + 0.52F;
    this.lower_arm_R.rotateAngleZ = 0.27F;
    this.lower_arm_L.rotateAngleZ = -0.27F;
    this.lower_arm_armor_R.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 2.0F * f1 * 0.5F + 0.52F;
    this.lower_arm_armor_L.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F + 0.52F;
    this.lower_arm_armor_R.rotateAngleZ = 0.27F;
    this.lower_arm_armor_L.rotateAngleZ = -0.27F;
    
    this.upper_leg_R.rotateAngleX = (float) (MathHelper.cos(f * 0.6662F) * 1.4F * f1 - 0.75);
    this.upper_leg_L.rotateAngleX = (float) (MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1 - 0.75);
    this.upper_leg_R.rotateAngleY = 0.0F;
    this.upper_leg_L.rotateAngleY = 0.0F;
    this.lower_leg_R.rotateAngleX = (float) (MathHelper.cos(f * 0.6662F) * 1.4F * f1);
    this.lower_leg_L.rotateAngleX = (float) (MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1);
    this.lower_leg_R.rotateAngleY = 0.0F;
    this.lower_leg_L.rotateAngleY = 0.0F;
  }

}


