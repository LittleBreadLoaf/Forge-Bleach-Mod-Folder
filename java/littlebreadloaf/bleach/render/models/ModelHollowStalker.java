// Date: 8/25/2013 7:45:42 PM
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX






package littlebreadloaf.bleach.render.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelHollowStalker extends ModelBase
{
  //fields
    public ModelRenderer upperarmR;
    ModelRenderer lowerarmR;
    ModelRenderer thumb1R;
    ModelRenderer thumb2R;
    ModelRenderer finger32R;
    ModelRenderer finger31R;
    ModelRenderer finger11R;
    ModelRenderer finger22R;
    ModelRenderer finger12R;
    ModelRenderer finger21R;
    ModelRenderer leglowerR;
    ModelRenderer legmidR;
    ModelRenderer legupperR;
    ModelRenderer toe1R;
    ModelRenderer toe2R;
    ModelRenderer upperarmL;
    ModelRenderer lowerarmL;
    ModelRenderer thumb1L;
    ModelRenderer thumb2L;
    ModelRenderer finger32L;
    ModelRenderer finger31L;
    ModelRenderer finger11L;
    ModelRenderer finger22L;
    ModelRenderer finger12L;
    ModelRenderer finger21L;
    ModelRenderer lower_torso;
    ModelRenderer upper_torso;
    ModelRenderer tailbone;
    ModelRenderer hips;
    ModelRenderer neck;
    ModelRenderer leglowerL;
    ModelRenderer legmidL;
    ModelRenderer legupperL;
    ModelRenderer toe1L;
    ModelRenderer toe2L;
    ModelRenderer jaw;
    ModelRenderer head;
    ModelRenderer hornLF;
    ModelRenderer hornLB;
    ModelRenderer hornRF;
    ModelRenderer hornRB;
  
  public ModelHollowStalker()
  {
    textureWidth = 128;
    textureHeight = 128;
    
      upperarmR = new ModelRenderer(this, 0, 49);
      upperarmR.addBox(-16F, -1F, -1F, 16, 2, 2);
      upperarmR.setRotationPoint(-4F, -13F, 13F);
      upperarmR.setTextureSize(128, 128);
      upperarmR.mirror = true;
      setRotation(upperarmR, -0.5235988F, 0F, -0.7853982F);
      lowerarmR = new ModelRenderer(this, 3, 29);
      lowerarmR.addBox(-3F, -1.5F, -15F, 4, 3, 16);
      lowerarmR.setRotationPoint(-15F, 0F, 0F);
      lowerarmR.setTextureSize(128, 128);
      lowerarmR.mirror = true;
      setRotation(lowerarmR, 0.7853982F, 0.7853982F, 0F);
      
      thumb1R = new ModelRenderer(this, 0, 39);
      thumb1R.addBox(-0.5F, -0.5F, -4.5F, 1, 1, 5);
      thumb1R.setRotationPoint(0F, -0F, -0F);
      thumb1R.setTextureSize(128, 128);
      thumb1R.mirror = true;
      setRotation(thumb1R, 0.9075712F, 0.296706F, -1.029744F);
      thumb2R = new ModelRenderer(this, 8, 40);
      thumb2R.addBox(-4.5F, -0.5F, -4.5F, 4, 1, 1);
      thumb2R.setRotationPoint(0F, -0F, -0F);
      thumb2R.setTextureSize(128, 128);
      thumb2R.mirror = true;
      setRotation(thumb2R, 0.9075712F, 0.296706F, -1.029744F);

      finger11R = new ModelRenderer(this, 0, 33);
      finger11R.addBox(-0.5F, -0.5F, -5F, 1, 1, 5);
      finger11R.setRotationPoint(0.5F, -0.7F, -14F);
      finger11R.setTextureSize(128, 128);
      finger11R.mirror = true;
      setRotation(finger11R, 0F, 0.0F, -0.0F);
      finger12R = new ModelRenderer(this, 0, 33);
      finger12R.addBox(-0.5F, -0.5F, -6F, 1, 4, 1);
      finger12R.setRotationPoint(0.5F, -0.7F, -14F);
      finger12R.setTextureSize(128, 128);
      finger12R.mirror = true;
      setRotation(finger12R, 0.0F, 0.0F, -0.0F);
      finger21R = new ModelRenderer(this, 0, 33);
      finger21R.addBox(-0.5F, -0.5F, -5F, 1, 1, 5);
      finger21R.setRotationPoint(-1.0F, -0.7F, -14F);
      finger21R.setTextureSize(128, 128);
      finger21R.mirror = true;
      setRotation(finger21R, -0.07F, 0.0F, -0.0F);
      finger22R = new ModelRenderer(this, 0, 33);
      finger22R.addBox(-0.5F, -0.5F, -6F, 1, 4, 1);
      finger22R.setRotationPoint(-1.0F, -0.7F, -14F);
      finger22R.setTextureSize(128, 128);
      finger22R.mirror = true;
      setRotation(finger22R, -0.07F, 0.0F, -0.0F);
      finger31R = new ModelRenderer(this, 0, 33);
      finger31R.addBox(-0.5F, -0.5F, -5F, 1, 1, 5);
      finger31R.setRotationPoint(-2.5F, -0.7F, -14F);
      finger31R.setTextureSize(128, 128);
      finger31R.mirror = true;
      setRotation(finger31R, 0.01F, 0.0F, -0.0F);
      finger32R = new ModelRenderer(this, 0, 33);
      finger32R.addBox(-0.5F, -0.5F, -6F, 1, 4, 1);
      finger32R.setRotationPoint(-2.5F, -0.7F, -14F);
      finger32R.setTextureSize(128, 128);
      finger32R.mirror = true;
      setRotation(finger32R, 0.01F, 0.0F, -0.0F);

      leglowerR = new ModelRenderer(this, 104, 80);
      leglowerR.addBox(-4F, 10F, 0F, 4, 18, 5);
      leglowerR.setRotationPoint(0F, 0F, 0F);
      leglowerR.setTextureSize(128, 128);
      leglowerR.mirror = true;
      setRotation(leglowerR, 0.5235988F, 0F, 0F);
      legmidR = new ModelRenderer(this, 88, 82);
      legmidR.addBox(-3.5F, 8F, 2F, 3, 3, 5);
      legmidR.setRotationPoint(-0F, -0F, 0F);
      legmidR.setTextureSize(128, 128);
      legmidR.mirror = true;
      setRotation(legmidR, 0F, 0F, 0F);
      legupperR = new ModelRenderer(this, 72, 81);
      legupperR.addBox(-4F, -1F, -2F, 4, 12, 4);
      legupperR.setRotationPoint(-5F, -5F, 11F);
      legupperR.setTextureSize(128, 128);
      legupperR.mirror = true;
      setRotation(legupperR, -0.7853982F, 0F, 0F);
      toe1R = new ModelRenderer(this, 72, 99);
      toe1R.addBox(-3F, 24F, -15F, 2, 3, 5);
      toe1R.setRotationPoint(-0F, -0F, 0F);
      toe1R.setTextureSize(128, 128);
      toe1R.mirror = true;
      setRotation(toe1R, 0.4516126F, 0.296F,  0.05F);
      toe2R = new ModelRenderer(this, 72, 99);
      toe2R.addBox(-3F, 24F, -15F, 2, 3, 5);
      toe2R.setRotationPoint(-0F, -0F, 0F);
      toe2R.setTextureSize(128, 128);
      toe2R.mirror = true;
      setRotation(toe2R, 0.5016126F,  -0.396F, -0.07F);
      upperarmL = new ModelRenderer(this, 0, 49);
      upperarmL.addBox(0F, -1F, -1F, 16, 2, 2);
      upperarmL.setRotationPoint(4F, -13F, 13F);
      upperarmL.setTextureSize(128, 128);
      upperarmL.mirror = true;
      setRotation(upperarmL, -0.5235988F, 0F, 0.7853982F);
      lowerarmL = new ModelRenderer(this, 3, 29);
      lowerarmL.addBox(-1F, -1.5F, -15F, 4, 3, 16);
      lowerarmL.setRotationPoint(15F, 0F, 0F);
      lowerarmL.setTextureSize(128, 128);
      lowerarmL.mirror = true;
      setRotation(lowerarmL, 0.7853982F, -0.7853982F,  0F);
      
      thumb1L = new ModelRenderer(this, 0, 39);
      thumb1L.addBox(-0.5F, -0.5F, -4.5F, 1, 1, 5);
      thumb1L.setRotationPoint(0F, -0F, -0F);
      thumb1L.setTextureSize(128, 128);
      thumb1L.mirror = true;
      setRotation(thumb1L, 0.9075712F, 0.296706F, 1.029744F);
      thumb2L = new ModelRenderer(this, 8, 40);
      thumb2L.addBox(-4.5F, -0.5F, -4.5F, 4, 1, 1);
      thumb2L.setRotationPoint(0F, 0F, -0F);
      thumb2L.setTextureSize(128, 128);
      thumb2L.mirror = true;
      setRotation(thumb2L, 0.9075712F, 0.296706F , 1.029744F);

      finger11L = new ModelRenderer(this, 0, 33);
      finger11L.addBox(-0.5F, -0.5F, -5F, 1, 1, 5);
      finger11L.setRotationPoint(2.5F, -0.7F, -14F);
      finger11L.setTextureSize(128, 128);
      finger11L.mirror = true;
      setRotation(finger11L, -0.03F, 0.0F, -0.0F);
      finger12L = new ModelRenderer(this, 0, 33);
      finger12L.addBox(-0.5F, -0.5F, -6F, 1, 4, 1);
      finger12L.setRotationPoint(2.5F, -0.7F, -14F);
      finger12L.setTextureSize(128, 128);
      finger12L.mirror = true;
      setRotation(finger12L, -0.03F, 0.0F, -0.0F);
      finger21L = new ModelRenderer(this, 0, 33);
      finger21L.addBox(-0.5F, -0.5F, -5F, 1, 1, 5);
      finger21L.setRotationPoint(1.0F, -0.7F, -14F);
      finger21L.setTextureSize(128, 128);
      finger21L.mirror = true;
      setRotation(finger21L, 0.06F, 0.0F, -0.0F);
      finger22L = new ModelRenderer(this, 0, 33);
      finger22L.addBox(-0.5F, -0.5F, -6F, 1, 4, 1);
      finger22L.setRotationPoint(1.0F, -0.7F, -14F);
      finger22L.setTextureSize(128, 128);
      finger22L.mirror = true;
      setRotation(finger22L, 0.06F, 0.0F, -0.0F);
      finger31L = new ModelRenderer(this, 0, 33);
      finger31L.addBox(-0.5F, -0.5F, -5F, 1, 1, 5);
      finger31L.setRotationPoint(-0.5F, -0.7F, -14F);
      finger31L.setTextureSize(128, 128);
      finger31L.mirror = true;
      setRotation(finger31L, 0.0F, 0.0F, -0.0F);
      finger32L = new ModelRenderer(this, 0, 33);
      finger32L.addBox(-0.5F, -0.5F, -6F, 1, 4, 1);
      finger32L.setRotationPoint(-0.5F, -0.7F, -14F);
      finger32L.setTextureSize(128, 128);
      finger32L.mirror = true;
      setRotation(finger32L, 0.0F, 0.0F, -0.0F);

      lower_torso = new ModelRenderer(this, 90, 0);
      lower_torso.addBox(-4F, -8F, 8F, 8, 10, 6);
      lower_torso.setRotationPoint(0F, 0F, 0F);
      lower_torso.setTextureSize(128, 128);
      lower_torso.mirror = true;
      setRotation(lower_torso, 0.2617994F, 0F, 0F);
      upper_torso = new ModelRenderer(this, 54, 0);
      upper_torso.addBox(-5F, -14F, 9F, 10, 10, 8);
      upper_torso.setRotationPoint(0F, 0F, 0F);
      upper_torso.setTextureSize(128, 128);
      upper_torso.mirror = true;
      setRotation(upper_torso, 0.5235988F - 0.2617994F, 0F, 0F);
      tailbone = new ModelRenderer(this, 90, 18);
      tailbone.addBox(-1.5F, 2F, 9F, 3, 7, 4);
      tailbone.setRotationPoint(0F, -5F, 0F);
      tailbone.setTextureSize(128, 128);
      tailbone.mirror = true;
      setRotation(tailbone, 0.3141593F, 0F, 0F);
      hips = new ModelRenderer(this, 55, 19);
      hips.addBox(-5F, -1F, 8F, 10, 5, 5);
      hips.setRotationPoint(0F, -5F, 0F);
      hips.setTextureSize(128, 128);
      hips.mirror = true;
      setRotation(hips, 0F, 0F, 0F);
      neck = new ModelRenderer(this, 37, 0);
      neck.addBox(-2F, -17F, 14F, 4, 7, 4);
      neck.setRotationPoint(0F, -5F, 0F);
      neck.setTextureSize(128, 128);
      neck.mirror = true;
      setRotation(neck, 0.7853982F, 0F, 0F);
      leglowerL = new ModelRenderer(this, 104, 80);
      leglowerL.addBox(0F, 10F, 0F, 4, 18, 5);
      leglowerL.setRotationPoint(0F, -0F, 0F);
      leglowerL.setTextureSize(128, 128);
      leglowerL.mirror = true;
      setRotation(leglowerL, 0.5235988F, 0F, 0F);
      legmidL = new ModelRenderer(this, 88, 82);
      legmidL.addBox(0.5F, 8F, 2F, 3, 3, 5);
      legmidL.setRotationPoint(0F, -0F, 0F);
      legmidL.setTextureSize(128, 128);
      legmidL.mirror = true;
      setRotation(legmidL, 0F, 0F, 0F);
      legupperL = new ModelRenderer(this, 72, 81);
      legupperL.addBox(0F, -1F, -2F, 4, 12, 4);
      legupperL.setRotationPoint(5F, -5F, 11F);
      legupperL.setTextureSize(128, 128);
      legupperL.mirror = true;
      setRotation(legupperL, -0.7853982F, 0F, 0F);
      toe1L = new ModelRenderer(this, 72, 99);
      toe1L.addBox(1F, 24F, -15F, 2, 3, 5);
      toe1L.setRotationPoint(0F, 0F, 0F);
      toe1L.setTextureSize(128, 128);
      toe1L.mirror = true;
      setRotation(toe1L, 0.4516126F, 0.2961799F, 0.04F);
      toe2L = new ModelRenderer(this, 72, 99);
      toe2L.addBox(1F, 24F, -15F, 2, 3, 5);
      toe2L.setRotationPoint(0F, -0F, 0F);
      toe2L.setTextureSize(128, 128);
      toe2L.mirror = true;
      setRotation(toe2L, 0.4016126F, -0.2667994F, -0.05F);
      jaw = new ModelRenderer(this, 0, 16);
      jaw.addBox(-3F, -1F, -7F, 6, 3, 4);
      jaw.setRotationPoint(0F, -28F, 0F);
      jaw.setTextureSize(128, 128);
      jaw.mirror = true;
      setRotation(jaw, 0.2443461F, 0F, 0F);
      head = new ModelRenderer(this, 0, 0);
      head.addBox(-4F, -6F, -7F, 8, 7, 8);
      head.setRotationPoint(0F, -28F, 0F);
      head.setTextureSize(128, 128);
      head.mirror = true;
      setRotation(head, -0.0349066F, 0F, 0F);
      hornLF = new ModelRenderer(this, 0, 0);
      hornLF.addBox(2F, -7F, -7.5F, 1, 2, 1);
      hornLF.setRotationPoint(0F, -28F, 0F);
      hornLF.setTextureSize(128, 128);
      hornLF.mirror = true;
      setRotation(hornLF, 0F, 0F, 0F);
      hornLB = new ModelRenderer(this, 19, 18);
      hornLB.addBox(3F, -6.5F, -2F, 3, 4, 5);
      hornLB.setRotationPoint(0F, -28F, 0F);
      hornLB.setTextureSize(128, 128);
      hornLB.mirror = true;
      setRotation(hornLB, 0.2617994F, 0.5235988F, 0F);
      hornRF = new ModelRenderer(this, 0, 0);
      hornRF.addBox(-3F, -7F, -7.5F, 1, 2, 1);
      hornRF.setRotationPoint(0F, -28F, 0F);
      hornRF.setTextureSize(128, 128);
      hornRF.mirror = true;
      setRotation(hornRF, 0F, 0F, 0F);
      hornRB = new ModelRenderer(this, 19, 18);
      hornRB.addBox(-6F, -6.5F, -2F, 3, 4, 5);
      hornRB.setRotationPoint(0F, -28F, 0F);
      hornRB.setTextureSize(128, 128);
      hornRB.mirror = true;
      setRotation(hornRB, 0.2617994F, -0.5235988F, 0F);
      
      
      
      
      this.legupperL.addChild(this.legmidL);
      this.legupperR.addChild(this.legmidR);
      this.legmidL.addChild(this.leglowerL);
      this.legmidR.addChild(this.leglowerR);
      
      this.leglowerL.addChild(this.toe1L);
      this.leglowerL.addChild(this.toe2L);
      this.leglowerR.addChild(this.toe1R);
      this.leglowerR.addChild(this.toe2R);
      
      this.upperarmL.addChild(this.lowerarmL);
      this.upperarmR.addChild(this.lowerarmR);
      
      this.lowerarmR.addChild(this.finger11R);
      this.lowerarmR.addChild(this.finger12R);
      this.lowerarmR.addChild(this.finger21R);
      this.lowerarmR.addChild(this.finger22R);
      this.lowerarmR.addChild(this.finger31R);
      this.lowerarmR.addChild(this.finger32R);
      

      this.finger11R.addChild(this.thumb1R);
    //  this.finger11R.addChild(this.thumb2R);
      
      this.lowerarmL.addChild(this.finger11L);
      this.lowerarmL.addChild(this.finger12L);
      this.lowerarmL.addChild(this.finger21L);
      this.lowerarmL.addChild(this.finger22L);
      this.lowerarmL.addChild(this.finger31L);
      this.lowerarmL.addChild(this.finger32L);
      

      this.finger31L.addChild(this.thumb1L);
      //this.finger31L.addChild(this.thumb2L);
      
      hips.addChild(lower_torso);
      lower_torso.addChild(upper_torso);
      upper_torso.addChild(upperarmL);
      upper_torso.addChild(upperarmR);
      
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    //upperarmR.render(f5);
    //lowerarmR.render(f5);
    //thumb1R.render(f5);
    //thumb2R.render(f5);
    //finger32R.render(f5);
    //finger31R.render(f5);
    //finger11R.render(f5);
    //finger22R.render(f5);
    //finger12R.render(f5);
    //finger21R.render(f5);
    //leglowerR.render(f5);
   // legmidR.render(f5);
    legupperR.render(f5);
    //toe1R.render(f5);
    //toe2R.render(f5);
    //upperarmL.render(f5);
    //lowerarmL.render(f5);
    //thumb1L.render(f5);
    //thumb2L.render(f5);
    //finger32L.render(f5);
    //finger31L.render(f5);
    //finger11L.render(f5);
    //finger22L.render(f5);
    //finger12L.render(f5);
    //finger21L.render(f5);
    //lower_torso.render(f5);
    //upper_torso.render(f5);
    tailbone.render(f5);
    hips.render(f5);
    neck.render(f5);
   // leglowerL.render(f5);
    //legmidL.render(f5);
    legupperL.render(f5);
    //toe1L.render(f5);
    //toe2L.render(f5);
    jaw.render(f5);
    head.render(f5);
    hornLF.render(f5);
    hornLB.render(f5);
    hornRF.render(f5);
    hornRB.render(f5);
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
    if(MathHelper.cos(f*0.6662F) > 0)
    {  
    	this.legupperR.rotateAngleX = (float) (MathHelper.cos(f * 0.6662F) * 0.5F * f1 - 0.75);
    	this.legupperL.rotateAngleX = (float) (MathHelper.cos(f * 0.6662F + (float)Math.PI) * 0.2F * f1 - 0.75) ;	
    }
    else
    {
    	 this.legupperL.rotateAngleX = (float) (MathHelper.cos(f * 0.6662F + (float)Math.PI) * 0.5F * f1 - 0.75) ;	
    	 this.legupperR.rotateAngleX = (float) (MathHelper.cos(f * 0.6662F) * 0.2F * f1 - 0.75);  
    	 
    	 
    }
    
    this.upperarmR.rotateAngleY = MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F;
    this.upperarmL.rotateAngleY = MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F;
    this.upperarmR.rotateAngleZ = -0.7853982F;
    this.upperarmL.rotateAngleZ =  0.7853982F;
    
    
    //Idle
    
    if(entity.motionX == 0 && entity.motionZ == 0)
    {
    	this.upperarmR.rotateAngleZ = 0.05F*(MathHelper.cos(f2 * 0.06662F) ) - 0.7853982F;
    	this.upperarmL.rotateAngleZ = -0.05F*(MathHelper.cos(f2 * 0.06662F) ) + 0.7853982F;
    
    	this.lower_torso.rotateAngleX = -0.02F*(MathHelper.cos(f2 * 0.06662F) ) + 0.2617994F;
    	this.upper_torso.rotateAngleX = -0.02F*(MathHelper.cos(f2 * 0.06662F) ) + 0.5235988F - 0.2617994F;
    
    
    }
  //ELSE
    else
    {
        this.upperarmR.rotateAngleZ = -0.7853982F;
        this.upperarmL.rotateAngleZ =  0.7853982F;
    	
    }
    
    
    
   
  }

}
