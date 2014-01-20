





package littlebreadloaf.bleach.render.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelSmallHollowLizard  extends ModelBase
{
  //fields
    ModelRenderer body_1;
    ModelRenderer body2;
    ModelRenderer jawL;
    ModelRenderer head_neck;
    ModelRenderer headBack;
    ModelRenderer head2R;
    ModelRenderer eyeL;
    ModelRenderer head4;
    ModelRenderer eyeR;
    ModelRenderer head3;
    ModelRenderer jaw;
    ModelRenderer head2L;
    ModelRenderer jawR;
    ModelRenderer head1;
    ModelRenderer tail4;
    ModelRenderer tail1;
    ModelRenderer tail2;
    ModelRenderer tail3;
    ModelRenderer finger1L;
    ModelRenderer finger3L;
    ModelRenderer finger2L;
    ModelRenderer shoulderL;
    ModelRenderer upperarmL;
    ModelRenderer lowerarmL;
    ModelRenderer lowerlegL;
    ModelRenderer upperlegL;
    ModelRenderer midlegL;
    ModelRenderer toe1L;
    ModelRenderer toe2L;
    ModelRenderer toe3L;
    ModelRenderer finger1R;
    ModelRenderer finger3R;
    ModelRenderer finger2R;
    ModelRenderer shoulderR;
    ModelRenderer upperarmR;
    ModelRenderer lowerarmR;
    ModelRenderer lowerlegR;
    ModelRenderer upperlegR;
    ModelRenderer midlegR;
    ModelRenderer toe1R;
    ModelRenderer toe2R;
    ModelRenderer toe3R;
  
  public ModelSmallHollowLizard()
  {
    textureWidth = 128;
    textureHeight = 128;
    
      body_1 = new ModelRenderer(this, 70, 0);
      body_1.addBox(-4F, -4F, -10F, 8, 8, 9);
      body_1.setRotationPoint(0F, 18F, 0F);
      body_1.setTextureSize(128, 128);
      body_1.mirror = true;
      setRotation(body_1, 0F, 0F, 0F);
      body2 = new ModelRenderer(this, 70, 17);
      body2.addBox(-3.5F, -3.5F, -1F, 7, 7, 9);
      body2.setRotationPoint(0F, 18F, 0F);
      body2.setTextureSize(128, 128);
      body2.mirror = true;
      setRotation(body2, 0F, 0F, 0F);
      jawL = new ModelRenderer(this, 15, 15);
      jawL.addBox(5F, 0.4F, -12.5F, 1, 1, 6);
      jawL.setRotationPoint(0F, 19F, -8F);
      jawL.setTextureSize(128, 128);
      jawL.mirror = true;
      setRotation(jawL, 0F, 0.3490659F, 0F);
      head_neck = new ModelRenderer(this, 0, 0);
      head_neck.addBox(-3F, -4F, -8F, 6, 6, 8);
      head_neck.setRotationPoint(0F, 19F, -8F);
      head_neck.setTextureSize(128, 128);
      head_neck.mirror = true;
      setRotation(head_neck, 0F, 0F, 0F);
      headBack = new ModelRenderer(this, 0, 26);
      headBack.addBox(-3.5F, -6F, -6F, 7, 4, 3);
      headBack.setRotationPoint(0F, 19F, -8F);
      headBack.setTextureSize(128, 128);
      headBack.mirror = true;
      setRotation(headBack, 0.2617994F, 0F, 0F);
      head2R = new ModelRenderer(this, 33, 12);
      head2R.addBox(-7F, -2F, -13F, 2, 2, 8);
      head2R.setRotationPoint(0F, 19F, -8F);
      head2R.setTextureSize(128, 128);
      head2R.mirror = true;
      setRotation(head2R, 0F, -0.4014257F, 0F);
      eyeL = new ModelRenderer(this, 44, 0);
      eyeL.addBox(2.6F, -6.5F, -11F, 3, 3, 7);
      eyeL.setRotationPoint(0F, 19F, -8F);
      eyeL.setTextureSize(128, 128);
      eyeL.mirror = true;
      setRotation(eyeL, 0.3316126F, 0.3141593F, 0F);
      head4 = new ModelRenderer(this, 28, 4);
      head4.addBox(-2F, -8F, -10F, 4, 3, 4);
      head4.setRotationPoint(0F, 19F, -8F);
      head4.setTextureSize(128, 128);
      head4.mirror = true;
      setRotation(head4, 0.4363323F, 0F, 0F);
      eyeR = new ModelRenderer(this, 44, 0);
      eyeR.addBox(-5.6F, -6.5F, -11F, 3, 3, 7);
      eyeR.setRotationPoint(0F, 19F, -8F);
      eyeR.setTextureSize(128, 128);
      eyeR.mirror = true;
      setRotation(eyeR, 0.3316126F, -0.3141593F, 0F);
      head3 = new ModelRenderer(this, 36, 0);
      head3.addBox(-1.5F, -6F, -13.5F, 3, 1, 3);
      head3.setRotationPoint(0F, 19F, -8F);
      head3.setTextureSize(128, 128);
      head3.mirror = true;
      setRotation(head3, 0.2617994F, 0F, 0F);
      jaw = new ModelRenderer(this, 0, 15);
      jaw.addBox(-1.5F, 0.5F, -14.5F, 3, 1, 8);
      jaw.setRotationPoint(0F, 19F, -8F);
      jaw.setTextureSize(128, 128);
      jaw.mirror = true;
      setRotation(jaw, 0F, 0F, 0F);
      head2L = new ModelRenderer(this, 33, 12);
      head2L.addBox(5F, -2F, -13F, 2, 2, 8);
      head2L.setRotationPoint(0F, 19F, -8F);
      head2L.setTextureSize(128, 128);
      head2L.mirror = true;
      setRotation(head2L, 0F, 0.4014257F, 0F);
      jawR = new ModelRenderer(this, 15, 15);
      jawR.addBox(-6F, 0.4F, -12.5F, 1, 1, 6);
      jawR.setRotationPoint(0F, 19F, -8F);
      jawR.setTextureSize(128, 128);
      jawR.mirror = true;
      setRotation(jawR, 0F, -0.3490659F, 0F);
      head1 = new ModelRenderer(this, 27, 0);
      head1.addBox(-1.5F, -2F, -14.8F, 3, 2, 1);
      head1.setRotationPoint(0F, 19F, -8F);
      head1.setTextureSize(128, 128);
      head1.mirror = true;
      setRotation(head1, 0F, 0F, 0F);
      tail4 = new ModelRenderer(this, 70, 69);
      tail4.addBox(-1.5F, -1.5F, 21F, 3, 3, 6);
      tail4.setRotationPoint(0F, 0F, 0F);
      tail4.setTextureSize(128, 128);
      tail4.mirror = true;
      setRotation(tail4, 0F, 0F, 0F);
      tail1 = new ModelRenderer(this, 70, 33);
      tail1.addBox(-3F, -3F, 0F, 6, 6, 8);
      tail1.setRotationPoint(0F, 18F, 8F);
      tail1.setTextureSize(128, 128);
      tail1.mirror = true;
      setRotation(tail1, 0F, 0F, 0F);
      tail2 = new ModelRenderer(this, 70, 47);
      tail2.addBox(-2.5F, -2.5F, 8F, 5, 5, 7);
      tail2.setRotationPoint(0F, 0F, 0F);
      tail2.setTextureSize(128, 128);
      tail2.mirror = true;
      setRotation(tail2, 0F, 0F, 0F);
      tail3 = new ModelRenderer(this, 70, 59);
      tail3.addBox(-2F, -2F, 15F, 4, 4, 6);
      tail3.setRotationPoint(0F, 0F, 0F);
      tail3.setTextureSize(128, 128);
      tail3.mirror = true;
      setRotation(tail3, 0F, 0F, 0F);
      finger1L = new ModelRenderer(this, 0, 55);
      finger1L.addBox(3F, 5F, -3F, 1, 1, 4);
      finger1L.setRotationPoint(0F, 0F, 0F);
      finger1L.setTextureSize(128, 128);
      finger1L.mirror = true;
      setRotation(finger1L, 0F, 0.5235988F, 0.5235988F);
      finger3L = new ModelRenderer(this, 0, 55);
      finger3L.addBox(2.3F, 5F, -6.5F, 1, 1, 4);
      finger3L.setRotationPoint(0F, 0F, 0F);
      finger3L.setTextureSize(128, 128);
      finger3L.mirror = true;
      setRotation(finger3L, 0F, -0.5235988F, 0.5235988F);
      finger2L = new ModelRenderer(this, 0, 55);
      finger2L.addBox(3F, 5F, -5F, 1, 1, 4);
      finger2L.setRotationPoint(0F, 0F, 0F);
      finger2L.setTextureSize(128, 128);
      finger2L.mirror = true;
      setRotation(finger2L, 0F, 0F, 0.5235988F);
      shoulderL = new ModelRenderer(this, 0, 42);
      shoulderL.addBox(-1F, -1.5F, -1.5F, 3, 3, 3);
      shoulderL.setRotationPoint(4F, 0F, -9F);
      shoulderL.setTextureSize(128, 128);
      shoulderL.mirror = true;
      setRotation(shoulderL, 0F, 0F, -0.5235988F);
      upperarmL = new ModelRenderer(this, 0, 48);
      upperarmL.addBox(-0.5F, 1.5F, -1F, 2, 2, 2);
      upperarmL.setRotationPoint(0F, 0F, 0F);
      upperarmL.setTextureSize(128, 128);
      upperarmL.mirror = true;
      setRotation(upperarmL, 0F, 0F, 0F);
      lowerarmL = new ModelRenderer(this, 0, 53);
      lowerarmL.addBox(0F, 3F, 1F, 1, 4, 1);
      lowerarmL.setRotationPoint(0F, 0F, 0F);
      lowerarmL.setTextureSize(128, 128);
      lowerarmL.mirror = true;
      setRotation(lowerarmL, -0.4537856F, 0F, 0F);
      lowerlegL = new ModelRenderer(this, 0, 74);
      lowerlegL.addBox(0F, 5F, -3.5F, 1, 1, 4);
      lowerlegL.setRotationPoint(0F, 0F, 0F);
      lowerlegL.setTextureSize(128, 128);
      lowerlegL.mirror = true;
      setRotation(lowerlegL, 0.8552113F, 0F, 0F);
      upperlegL = new ModelRenderer(this, 0, 61);
      upperlegL.addBox(-1F, -1.5F, -1.5F, 3, 5, 3);
      upperlegL.setRotationPoint(4F, 0F, 5F);
      upperlegL.setTextureSize(128, 128);
      upperlegL.mirror = true;
      setRotation(upperlegL, -0.2617994F, 0F, -0.5235988F);
      midlegL = new ModelRenderer(this, 0, 69);
      midlegL.addBox(-0.5F, 1.5F, 1.5F, 2, 2, 3);
      midlegL.setRotationPoint(0F, 0F, 0F);
      midlegL.setTextureSize(128, 128);
      midlegL.mirror = true;
      setRotation(midlegL, 0F, 0F, 0F);
      toe1L = new ModelRenderer(this, 0, 55);
      toe1L.addBox(2F, 5F, -2F, 1, 1, 4);
      toe1L.setRotationPoint(0F, 0F, 0F);
      toe1L.setTextureSize(128, 128);
      toe1L.mirror = true;
      setRotation(toe1L, 0F, 0.5235988F, 0F);
      toe2L = new ModelRenderer(this, 0, 55);
      toe2L.addBox(3F, 5F, -4F, 1, 1, 4);
      toe2L.setRotationPoint(0F, 0F, 0F);
      toe2L.setTextureSize(128, 128);
      toe2L.mirror = true;
      setRotation(toe2L, -0.5934119F, 0F, 0.5235988F);
      toe3L = new ModelRenderer(this, 0, 55);
      toe3L.addBox(3.3F, 5F, -5.5F, 1, 1, 4);
      toe3L.setRotationPoint(0F, 0F, 0F);
      toe3L.setTextureSize(128, 128);
      toe3L.mirror = true;
      setRotation(toe3L, 0F, -0.5235988F, 0F);
      finger1R = new ModelRenderer(this, 0, 55);
      finger1R.addBox(-4F, 5F, -3F, 1, 1, 4);
      finger1R.setRotationPoint(0F, 0F, 0F);
      finger1R.setTextureSize(128, 128);
      finger1R.mirror = true;
      setRotation(finger1R, 0F, -0.5235988F, -0.5235988F);
      finger3R = new ModelRenderer(this, 0, 55);
      finger3R.addBox(-3.3F, 5F, -6.5F, 1, 1, 4);
      finger3R.setRotationPoint(0F, 0F, 0F);
      finger3R.setTextureSize(128, 128);
      finger3R.mirror = true;
      setRotation(finger3R, 0F, 0.5235988F, -0.5235988F);
      finger2R = new ModelRenderer(this, 0, 55);
      finger2R.addBox(-4F, 5F, -5F, 1, 1, 4);
      finger2R.setRotationPoint(0F, 0F, 0F);
      finger2R.setTextureSize(128, 128);
      finger2R.mirror = true;
      setRotation(finger2R, 0F, 0F, -0.5235988F);
      shoulderR = new ModelRenderer(this, 0, 42);
      shoulderR.addBox(-2F, -1.5F, -1.5F, 3, 3, 3);
      shoulderR.setRotationPoint(-4F, 0F, -9F);
      shoulderR.setTextureSize(128, 128);
      shoulderR.mirror = true;
      setRotation(shoulderR, 0F, 0F, 0.5235988F);
      upperarmR = new ModelRenderer(this, 0, 48);
      upperarmR.addBox(-1.5F, 1.5F, -1F, 2, 2, 2);
      upperarmR.setRotationPoint(0F, 0F, 0F);
      upperarmR.setTextureSize(128, 128);
      upperarmR.mirror = true;
      setRotation(upperarmR, 0F, 0F, 0F);
      lowerarmR = new ModelRenderer(this, 0, 53);
      lowerarmR.addBox(-1F, 3F, 1F, 1, 4, 1);
      lowerarmR.setRotationPoint(0F, 0F, 0F);
      lowerarmR.setTextureSize(128, 128);
      lowerarmR.mirror = true;
      setRotation(lowerarmR, -0.4537856F, 0F, 0F);
      lowerlegR = new ModelRenderer(this, 0, 74);
      lowerlegR.addBox(-1F, 5F, -3.5F, 1, 1, 4);
      lowerlegR.setRotationPoint(0F, 0F, 0F);
      lowerlegR.setTextureSize(128, 128);
      lowerlegR.mirror = true;
      setRotation(lowerlegR, 0.8552113F, 0F, 0F);
      upperlegR = new ModelRenderer(this, 0, 61);
      upperlegR.addBox(-2F, -1.5F, -1.5F, 3, 5, 3);
      upperlegR.setRotationPoint(-4F, 0F, 5F);
      upperlegR.setTextureSize(128, 128);
      upperlegR.mirror = true;
      setRotation(upperlegR, -0.2617994F, 0F, 0.5235988F);
      midlegR = new ModelRenderer(this, 0, 69);
      midlegR.addBox(-1.5F, 1.5F, 1.5F, 2, 2, 3);
      midlegR.setRotationPoint(0F, 0F, 0F);
      midlegR.setTextureSize(128, 128);
      midlegR.mirror = true;
      setRotation(midlegR, 0F, 0F, 0F);
      toe1R = new ModelRenderer(this, 0, 55);
      toe1R.addBox(-3F, 5F, -2F, 1, 1, 4);
      toe1R.setRotationPoint(0F, 0F, 0F);
      toe1R.setTextureSize(128, 128);
      toe1R.mirror = true;
      setRotation(toe1R, 0F, -0.5235988F, 0F);
      toe2R = new ModelRenderer(this, 0, 55);
      toe2R.addBox(-4F, 5F, -4F, 1, 1, 4);
      toe2R.setRotationPoint(0F, 0F, 0F);
      toe2R.setTextureSize(128, 128);
      toe2R.mirror = true;
      setRotation(toe2R, -0.5934119F, 0F, -0.5235988F);
      toe3R = new ModelRenderer(this, 0, 55);
      toe3R.addBox(-4.3F, 5F, -5.5F, 1, 1, 4);
      toe3R.setRotationPoint(0F, 0F, 0F);
      toe3R.setTextureSize(128, 128);
      toe3R.mirror = true;
      setRotation(toe3R, 0F, 0.5235988F, 0F);
      
      body_1.addChild(shoulderL);
      shoulderL.addChild(upperarmL);
      upperarmL.addChild(lowerarmL);
      body_1.addChild(shoulderR);
      shoulderR.addChild(upperarmR);
      upperarmR.addChild(lowerarmR);
      
      upperarmL.addChild(finger1L);
      upperarmL.addChild(finger2L);
      upperarmL.addChild(finger3L);
      upperarmR.addChild(finger1R);
      upperarmR.addChild(finger2R);
      upperarmR.addChild(finger3R);
      
      
      body2.addChild(upperlegL);
      upperlegL.addChild(midlegL);
      midlegL.addChild(lowerlegL);
      body2.addChild(upperlegR);
      upperlegR.addChild(midlegR);
      midlegR.addChild(lowerlegR);
      
      lowerlegL.addChild(toe2L);
      toe2L.addChild(toe1L);
      toe2L.addChild(toe3L);
      
      lowerlegR.addChild(toe2R);
      toe2R.addChild(toe1R);
      toe2R.addChild(toe3R);
      
      

      tail1.addChild(tail2);
      tail2.addChild(tail3);
      tail3.addChild(tail4);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    body_1.render(f5);
    body2.render(f5);
    jawL.render(f5);
    head_neck.render(f5);
    headBack.render(f5);
    head2R.render(f5);
    eyeL.render(f5);
    head4.render(f5);
    eyeR.render(f5);
    head3.render(f5);
    jaw.render(f5);
    head2L.render(f5);
    jawR.render(f5);
    head1.render(f5);
    //tail4.render(f5);
    tail1.render(f5);
    //tail2.render(f5);
    //tail3.render(f5);
    //finger1L.render(f5);
    //finger3L.render(f5);
    //finger2L.render(f5);
    //shoulderL.render(f5);
    //upperarmL.render(f5);
    //lowerarmL.render(f5);
    //lowerlegL.render(f5);
    //upperlegL.render(f5);
    //midlegL.render(f5);
    //toe1L.render(f5);
    //toe2L.render(f5);
    //toe3L.render(f5);
    //finger1R.render(f5);
    //finger3R.render(f5);
    //finger2R.render(f5);
    //shoulderR.render(f5);
    //upperarmR.render(f5);
    //lowerarmR.render(f5);
    //lowerlegR.render(f5);
    //upperlegR.render(f5);
    //midlegR.render(f5);
    //toe1R.render(f5);
    //toe2R.render(f5);
    //toe3R.render(f5);
    
    
    
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

    
    //Idle
   
    if(f1 < 0.00001)
    {
    	this.tail1.rotateAngleY = 0.05F*(MathHelper.cos(f2 * 0.06662F) );
    	this.tail2.rotateAngleY = 0.05F*(MathHelper.cos(f2 * 0.06662F) ) ;
    	this.tail3.rotateAngleY = 0.05F*(MathHelper.cos(f2 * 0.06662F) ) ;
    	this.tail4.rotateAngleY = 0.05F*(MathHelper.cos(f2 * 0.06662F) ) ;
    	

    	this.tail1.rotateAngleX = -0.1F;
    	this.tail2.rotateAngleX = -0.075F;
    	this.tail3.rotateAngleX = -0.01F;
    	this.tail4.rotateAngleX = 0F;
    	

    	this.body_1.rotateAngleZ = 0F;
    	this.body2.rotateAngleZ = 0F;
    }
    
    //ELSE
    else
    {
    	

    	this.tail1.rotateAngleX = 0F;
    	this.tail2.rotateAngleX = 0F;
    	this.tail3.rotateAngleX = 0F;
    	this.tail4.rotateAngleX = 0F;
    	
    	this.body_1.rotateAngleZ = MathHelper.sin(f * 0.3662F) * 0.2F * f1;
    	this.body2.rotateAngleZ = MathHelper.cos(f * 0.3662F) * 0.2F * f1;
    
    	this.tail1.rotateAngleY = MathHelper.sin(f * 0.3662F) * 0.1F * f1;
    	this.tail2.rotateAngleY = MathHelper.sin(f * 0.3662F) * 0.1F * f1;
    	this.tail3.rotateAngleY = MathHelper.sin(f * 0.3662F) * 0.1F * f1;
    	this.tail4.rotateAngleY = MathHelper.sin(f * 0.3662F) * 0.1F * f1;
    

    	this.shoulderL.rotateAngleX = MathHelper.sin(f * 0.3662F) * 0.3F * f1;
    	this.upperarmL.rotateAngleX = MathHelper.sin(f * 0.3662F) * 0.2F * f1;
    	this.lowerarmL.rotateAngleX = MathHelper.sin(f * 0.3662F) * 0.1F * f1 - 0.4537856F;
    	this.shoulderR.rotateAngleX = -MathHelper.sin(f * 0.3662F) * 0.3F * f1;
    	this.upperarmR.rotateAngleX = -MathHelper.sin(f * 0.3662F) * 0.2F * f1;
    	this.lowerarmR.rotateAngleX = -MathHelper.sin(f * 0.3662F) * 0.1F * f1 - 0.4537856F;
    
    	
    	this.upperlegL.rotateAngleX = MathHelper.cos(f * 0.3662F) * 0.3F * f1 - 0.2617994F;
    	this.midlegL.rotateAngleX = MathHelper.cos(f * 0.3662F) * 0.2F * f1;
    	this.lowerlegL.rotateAngleX = MathHelper.cos(f * 0.3662F) * 0.1F * f1 + 0.8552113F;
    	this.upperlegR.rotateAngleX = -MathHelper.cos(f * 0.3662F) * 0.3F * f1 - 0.2617994F;
    	this.midlegR.rotateAngleX = -MathHelper.cos(f * 0.3662F) * 0.2F * f1;
    	this.lowerlegR.rotateAngleX = -MathHelper.cos(f * 0.3662F) * 0.1F * f1 + 0.8552113F;
    }
    
  }

}
