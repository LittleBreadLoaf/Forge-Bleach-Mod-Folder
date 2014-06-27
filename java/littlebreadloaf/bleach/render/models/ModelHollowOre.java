
package littlebreadloaf.bleach.render.models;

import littlebreadloaf.bleach.entities.EntityHollowOre;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelHollowOre extends ModelBase
{
  //fields
    ModelRenderer body2;
    ModelRenderer tail3;
    ModelRenderer tail1;
    ModelRenderer tail2;
    ModelRenderer body1;
    ModelRenderer body4;
    ModelRenderer body3;
    ModelRenderer armL;
    ModelRenderer finger1L;
    ModelRenderer finger2L;
    ModelRenderer finger3L;
    ModelRenderer upperlegL;
    ModelRenderer lower_legL;
    ModelRenderer toe1L;
    ModelRenderer toe2L;
    ModelRenderer toe3L;
    ModelRenderer armR;
    ModelRenderer finger1R;
    ModelRenderer finger2R;
    ModelRenderer finger3R;
    ModelRenderer upperlegR;
    ModelRenderer lower_legR;
    ModelRenderer toe1R;
    ModelRenderer toe2R;
    ModelRenderer toe3R;
    ModelRenderer head;
    ModelRenderer jaw;
    ModelRenderer mask;
    ModelRenderer fake_ore;
    ModelRenderer lure2;
    ModelRenderer lure1;
  
  public ModelHollowOre()
  {
    textureWidth = 128;
    textureHeight = 256;
    
      body2 = new ModelRenderer(this, 69, 172);
      body2.addBox(-8F, -15F, 1F, 16, 16, 13);
      body2.setRotationPoint(0F, 0F, 0F);
      body2.setTextureSize(128, 256);
      body2.mirror = true;
      setRotation(body2, -0.4363323F, 0F, 0F);
      tail3 = new ModelRenderer(this, 122, 234);
      tail3.addBox(10F, 14F, -22F, 1, 9, 1);
      tail3.setRotationPoint(0F, 0F, 0F);
      tail3.setTextureSize(128, 256);
      tail3.mirror = true;
      setRotation(tail3, 2.1816615F, -0.5235988F, 0F);
      tail1 = new ModelRenderer(this, 122, 234);
      tail1.addBox(-11F, 14F, -22F, 1, 9, 1);
      tail1.setRotationPoint(0F, 0F, 0F);
      tail1.setTextureSize(128, 256);
      tail1.mirror = true;
      setRotation(tail1, 2.1816615F, 0.5235988F, 0F);
      tail2 = new ModelRenderer(this, 122, 234);
      tail2.addBox(-0.5F, 17F, -23F, 1, 9, 1);
      tail2.setRotationPoint(0F, 0F, 0F);
      tail2.setTextureSize(128, 256);
      tail2.mirror = true;
      setRotation(tail2, 2.1816615F, 0F, 0F);
      body1 = new ModelRenderer(this, 47, 132);
      body1.addBox(-10F, -15F, -12F, 20, 20, 20);
      body1.setRotationPoint(0F, 0F, 0F);
      body1.setTextureSize(128, 256);
      body1.mirror = true;
      setRotation(body1, -0.5235988F, 0F, 0F);
      body4 = new ModelRenderer(this, 103, 221);
      body4.addBox(-3F, 6F, 21F, 6, 6, 6);
      body4.setRotationPoint(0F, 0F, 0F);
      body4.setTextureSize(128, 256);
      body4.mirror = true;
      setRotation(body4, 0.5585053F, 0F, 0F);
      body3 = new ModelRenderer(this, 87, 201);
      body3.addBox(-5F, -9F, 14F, 10, 10, 10);
      body3.setRotationPoint(0F, 0F, 0F);
      body3.setTextureSize(128, 256);
      body3.mirror = true;
      setRotation(body3, 0.3141593F, 0F, 0F);
      armL = new ModelRenderer(this, 0, 132);
      armL.addBox(-1F, -2F, -2F, 3, 8, 4);
      armL.setRotationPoint(11F, 0F, 0F);
      armL.setTextureSize(128, 256);
      armL.mirror = true;
      setRotation(armL, 0F, 0F, -0.7853982F);
      finger1L = new ModelRenderer(this, 14, 132);
      finger1L.addBox(0F, 4F, 3F, 1, 5, 1);
      finger1L.setRotationPoint(0F, 0F, 0F);
      finger1L.setTextureSize(128, 256);
      finger1L.mirror = true;
      setRotation(finger1L, -0.7853982F, 0F, 0F);//   -0.7853982
      finger2L = new ModelRenderer(this, 14, 132);
      finger2L.addBox(0.5F, 6F, -0.5F, 1, 5, 1);
      finger2L.setRotationPoint(0F, 0F, 0F);
      finger2L.setTextureSize(128, 256);
      finger2L.mirror = true;
      setRotation(finger2L, 0F, 0F, 0F);//     -0.7853982
      finger3L = new ModelRenderer(this, 14, 132);
      finger3L.addBox(0F, 4F, -4F, 1, 5, 1);
      finger3L.setRotationPoint(0F, 0F, 0F);
      finger3L.setTextureSize(128, 256);
      finger3L.mirror = true;
      setRotation(finger3L, 0.7853982F, 0F, 0F);//   -0.7853982  
      upperlegL = new ModelRenderer(this, 0, 145);
      upperlegL.addBox(-2F, -2F, -2F, 4, 10, 4);
      upperlegL.setRotationPoint(11F, 7F, 3F);
      upperlegL.setTextureSize(128, 256);
      upperlegL.mirror = true;
      setRotation(upperlegL, -0.2617994F, 0F, 0F);
      lower_legL = new ModelRenderer(this, 16, 145);
      lower_legL.addBox(-3.5F, 7F, -6F, 7, 10, 7);
      lower_legL.setRotationPoint(0F, 0F, 0F);
      lower_legL.setTextureSize(128, 256);
      lower_legL.mirror = true;
      setRotation(lower_legL, 0.2617994F, 0F, 0F);
      toe1L = new ModelRenderer(this, 0, 160);
      toe1L.addBox(1F, 16F, -9F, 2, 1, 4);
      toe1L.setRotationPoint(0F, 0F, 0F);
      toe1L.setTextureSize(128, 256);
      toe1L.mirror = true;
      setRotation(toe1L, 0F, 0.7853982F, 0F);
      toe2L = new ModelRenderer(this, 0, 160);
      toe2L.addBox(-1F, 16F, -10F, 2, 1, 4);
      toe2L.setRotationPoint(0F, 0F, 0F);
      toe2L.setTextureSize(128, 256);
      toe2L.mirror = true;
      setRotation(toe2L, 0F, 0F, 0F);
      toe3L = new ModelRenderer(this, 0, 160);
      toe3L.addBox(-3F, 16F, -9F, 2, 1, 4);
      toe3L.setRotationPoint(0F, 0F, 0F);
      toe3L.setTextureSize(128, 256);
      toe3L.mirror = true;
      setRotation(toe3L, 0F, -0.7853982F, 0F);
      armR = new ModelRenderer(this, 0, 132);
      armR.addBox(-2F, -2F, -2F, 3, 8, 4);
      armR.setRotationPoint(-11F, 0F, 0F);
      armR.setTextureSize(128, 256);
      armR.mirror = true;
      setRotation(armR, 0F, 0F, 0.7853982F);
      finger1R = new ModelRenderer(this, 14, 132);
      finger1R.addBox(-1F, 4F, 3F, 1, 5, 1);
      finger1R.setRotationPoint(-0F, 0F, 0F);
      finger1R.setTextureSize(128, 256);
      finger1R.mirror = true;
      setRotation(finger1R, -0.7853982F, 0F, 0F);//     0.7853982
      finger2R = new ModelRenderer(this, 14, 132);
      finger2R.addBox(-1.5F, 6F, -0.5F, 1, 5, 1);
      finger2R.setRotationPoint(-0F, 0F, 0F);
      finger2R.setTextureSize(128, 256);
      finger2R.mirror = true;
      setRotation(finger2R, 0F, 0F, 0F);//     0.7853982
      finger3R = new ModelRenderer(this, 14, 132);
      finger3R.addBox(-1F, 4F, -4F, 1, 5, 1);
      finger3R.setRotationPoint(-0F, 0F, 0F);
      finger3R.setTextureSize(128, 256);
      finger3R.mirror = true;
      setRotation(finger3R, 0.7853982F, 0F, 0F);//     0.7853982
      upperlegR = new ModelRenderer(this, 0, 145);
      upperlegR.addBox(-2F, -2F, -2F, 4, 10, 4);
      upperlegR.setRotationPoint(-11F, 7F, 3F);
      upperlegR.setTextureSize(128, 256);
      upperlegR.mirror = true;
      setRotation(upperlegR, -0.2617994F, 0F, 0F);
      lower_legR = new ModelRenderer(this, 16, 145);
      lower_legR.addBox(-3.5F, 7F, -6F, 7, 10, 7);
      lower_legR.setRotationPoint(-0F, 0F, 0F);
      lower_legR.setTextureSize(128, 256);
      lower_legR.mirror = true;
      setRotation(lower_legR, 0.2617994F, 0F, 0F);
      toe1R = new ModelRenderer(this, 0, 160);
      toe1R.addBox(-3F, 16F, -9F, 2, 1, 4);
      toe1R.setRotationPoint(0F, 0F, 0F);
      toe1R.setTextureSize(128, 256);
      toe1R.mirror = true;
      setRotation(toe1R, 0F, -0.7853982F, 0F);
      toe2R = new ModelRenderer(this, 0, 160);
      toe2R.addBox(-1F, 16F, -10F, 2, 1, 4);
      toe2R.setRotationPoint(0F, 0F, 0F);
      toe2R.setTextureSize(128, 256);
      toe2R.mirror = true;
      setRotation(toe2R, 0F, 0F, 0F);
      toe3R = new ModelRenderer(this, 0, 160);
      toe3R.addBox(1F, 16F, -9F, 2, 1, 4);
      toe3R.setRotationPoint(0F, 0F, 0F);
      toe3R.setTextureSize(128, 256);
      toe3R.mirror = true;
      setRotation(toe3R, 0F, 0.7853982F, 0F);
      head = new ModelRenderer(this, 0, 0);
      head.addBox(-13F, -20F, -13F, 26, 26, 26);
      head.setRotationPoint(0F, 0F, -15F);
      head.setTextureSize(128, 256);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      jaw = new ModelRenderer(this, 0, 95);
      jaw.addBox(-13.5F, -8F, -15F, 27, 17, 19);
      jaw.setRotationPoint(0F, 0F, 0F);
      jaw.setTextureSize(128, 256);
      jaw.mirror = true;
      setRotation(jaw, 0F, 0F, 0F);
      mask = new ModelRenderer(this, 0, 52);
      mask.addBox(-14F, -21F, -16F, 28, 21, 22);
      mask.setRotationPoint(0F, 0F, 0F);
      mask.setTextureSize(128, 256);
      mask.mirror = true;
      setRotation(mask, 0F, 0F, 0F);
      fake_ore = new ModelRenderer(this, 0, 224);
      fake_ore.addBox(-8F, -37F, -48F, 16, 16, 16);
      fake_ore.setRotationPoint(0F, 0F, 0F);
      fake_ore.setTextureSize(128, 256);
      fake_ore.mirror = true;
      setRotation(fake_ore, 0.2617994F, 0F, 0F);
      lure2 = new ModelRenderer(this, 91, 54);
      lure2.addBox(-2F, -26F, -40F, 4, 4, 14);
      lure2.setRotationPoint(0F, 0F, 0F);
      lure2.setTextureSize(128, 256);
      lure2.mirror = true;
      setRotation(lure2, 0.418879F, 0F, 0F);
      lure1 = new ModelRenderer(this, 79, 0);
      lure1.addBox(-3F, -14F, -34F, 6, 6, 18);
      lure1.setRotationPoint(0F, 0F, 0F);
      lure1.setTextureSize(128, 256);
      lure1.mirror = true;
      setRotation(lure1, -0.6806784F, 0F, 0F);
      
      
      
      
      armL.addChild(this.finger1L);
      armL.addChild(this.finger2L);
      armL.addChild(this.finger3L);
      
      armR.addChild(this.finger1R);
      armR.addChild(this.finger2R);
      armR.addChild(this.finger3R);
      
      upperlegL.addChild(this.lower_legL);
      upperlegR.addChild(this.lower_legR);
      
      lower_legL.addChild(this.toe1L);
      lower_legL.addChild(this.toe2L);
      lower_legL.addChild(this.toe3L);
      lower_legR.addChild(this.toe1R);
      lower_legR.addChild(this.toe2R);
      lower_legR.addChild(this.toe3R);
      
      body1.addChild(this.body2);
      body2.addChild(this.body3);
      body3.addChild(this.body4);
      body4.addChild(this.tail1);
      body4.addChild(this.tail2);
      body4.addChild(this.tail3);
      
      head.addChild(this.mask);
      head.addChild(this.jaw);
      head.addChild(this.lure1);
      lure1.addChild(this.lure2);
      lure2.addChild(this.fake_ore);
      
      
      
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    //body2.render(f5);
    //tail3.render(f5);
    //tail1.render(f5);
    //tail2.render(f5);
    body1.render(f5);
    //body4.render(f5);
    //body3.render(f5);
    armL.render(f5);
    //finger1L.render(f5);
    //finger2L.render(f5);
    //finger3L.render(f5);
    upperlegL.render(f5);
    //lower_legL.render(f5);
    //toe1L.render(f5);
    //toe2L.render(f5);
    //toe3L.render(f5);
    armR.render(f5);
    //finger1R.render(f5);
    //finger2R.render(f5);
    //finger3R.render(f5);
    upperlegR.render(f5);
    //lower_legR.render(f5);
    //toe1R.render(f5);
    //toe2R.render(f5);
    //toe3R.render(f5);
    head.render(f5);
    //jaw.render(f5);
    //mask.render(f5);
    //fake_ore.render(f5);
    //lure2.render(f5);
    //lure1.render(f5);
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
    
    //Running
    EntityHollowOre Hollow = (EntityHollowOre)entity;
    
    
    	this.armR.rotateAngleX = MathHelper.cos(f * 0.3662F + (float)Math.PI) * 2.0F * f1 * 0.5F;
    	this.armL.rotateAngleX = MathHelper.cos(f * 0.3662F) * 2.0F * f1 * 0.5F;
    	this.armR.rotateAngleY = MathHelper.cos(f * 0.3662F + (float)Math.PI) * f1 * 0.5F;
    	this.armL.rotateAngleY = MathHelper.cos(f * 0.3662F) * f1 * 0.5F;
    	
    	this.upperlegR.rotateAngleX = (float) (MathHelper.cos(f * 0.4662F) * 0.6F * f1)-0.2617994F;
    	this.upperlegL.rotateAngleX = (float) (MathHelper.cos(f * 0.4662F + (float)Math.PI) * 0.6F * f1)-0.2617994F;
    
    	this.lower_legR.rotateAngleX = -(float) (MathHelper.cos(f * 0.4662F) * 0.2F * f1)+0.2617994F;
    	this.lower_legL.rotateAngleX = -(float) (MathHelper.cos(f * 0.4662F + (float)Math.PI) * 0.2F * f1)+0.2617994F;
    
    
    
    

        //Idling
    	 if(entity.motionX == 0 && entity.motionZ == 0)
    	    {
        this.armR.rotateAngleZ = -0.25F*(MathHelper.cos(f2 * 0.06662F * 1.5F) ) + 0.7853982F;
        this.armL.rotateAngleZ = 0.25F*(MathHelper.cos(f2 * 0.06662F * 1.5F) ) -0.7853982F;
    	    }

        
        this.head.rotateAngleX = -0.025F*(MathHelper.cos(f2 * 0.06662F) );    
       // this.lure2.rotateAngleX = -0.035F*(MathHelper.cos(f2 * 0.06662F) - 0.418879F );
        
        this.body1.rotateAngleX = 0.07F*(MathHelper.cos(f2 * 0.06662F) ) - 0.5235988F;
        this.body2.rotateAngleX = 0.07F*(MathHelper.cos(f2 * 0.06662F) ) - 0.4363323F;
        this.body3.rotateAngleX = 0.07F*(MathHelper.cos(f2 * 0.06662F) ) + 0.3141593F;
        this.body4.rotateAngleX = 0.08F*(MathHelper.cos(f2 * 0.06662F) ) + 0.5585053F;
        
        this.jaw.rotateAngleY = 0.02F*(MathHelper.cos(f2 * 0.06662F) );
        this.jaw.rotateAngleZ = 0.02F*(MathHelper.cos(f2 * 0.06662F * 2F) );
        
        this.mask.rotateAngleX = 0.07F*(MathHelper.cos(f2 * 0.06662F));
        		
    
    
    
   
  }

}
