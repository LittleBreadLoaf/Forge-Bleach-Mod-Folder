

package littlebreadloaf.entities.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelHollowWasp extends ModelBase
{

    ModelRenderer mainbody;
    ModelRenderer midsection;
    ModelRenderer stinger1;
    ModelRenderer neck;
    ModelRenderer legBL;
    ModelRenderer legML;
    ModelRenderer legFL;
    ModelRenderer legBR;
    ModelRenderer legMR;
    ModelRenderer legFR;
    ModelRenderer stinger;
    ModelRenderer stinger2;
    ModelRenderer stinger4;
    ModelRenderer Stinger3;
    ModelRenderer head;
    ModelRenderer mask;
    ModelRenderer mouth;
    ModelRenderer wingL;
    ModelRenderer wingR;
  private float rotatewings;
	private float rotatebody;
	private float rotatelegs;
  
  public ModelHollowWasp()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      mainbody = new ModelRenderer(this, 37, 0);
      mainbody.addBox(-3F, -3F, 0F, 6, 6, 6);
      mainbody.setRotationPoint(0F, 0F, 0F);
      mainbody.setTextureSize(128, 64);
      mainbody.mirror = true;
      setRotation(mainbody, 0F, 0F, 0F);
      midsection = new ModelRenderer(this, 61, 0);
      midsection.addBox(-1F, -5F, 3F, 2, 2, 8);
      midsection.setRotationPoint(0F, 0F, 0F);
      midsection.setTextureSize(128, 64);
      midsection.mirror = true;
      setRotation(midsection, -0.7853982F, 0F, 0F);
      stinger1 = new ModelRenderer(this, 76, 0);
      stinger1.addBox(-2F, 8F, 5F, 4, 2, 4);
      stinger1.setRotationPoint(0F, 0F, 0F);
      stinger1.setTextureSize(128, 64);
      stinger1.mirror = true;
      setRotation(stinger1, 0.4363323F, 0F, 0F);
      neck = new ModelRenderer(this, 24, 0);
      neck.addBox(-1F, -2F, -4F, 2, 2, 4);
      neck.setRotationPoint(0F, 0F, 0F);
      neck.setTextureSize(128, 64);
      neck.mirror = true;
      setRotation(neck, 0F, 0F, 0F);
      legBL = new ModelRenderer(this, 21, 28);
      legBL.addBox(3F, -1F, 4.5F, 5, 1, 1);
      legBL.setRotationPoint(0F, 0F, 0F);
      legBL.setTextureSize(128, 64);
      legBL.mirror = true;
      setRotation(legBL, 0F, -0.2268928F, 0.6853982F);
      legML = new ModelRenderer(this, 21, 28);
      legML.addBox(3F, -1F, 2.5F, 5, 1, 1);
      legML.setRotationPoint(0F, 0F, 0F);
      legML.setTextureSize(128, 64);
      legML.mirror = true;
      setRotation(legML, 0F, 0F, 0.7853982F);
      legFL = new ModelRenderer(this, 21, 28);
      legFL.addBox(3F, -1F, 0.5F, 5, 1, 1);
      legFL.setRotationPoint(0F, 0F, 0F);
      legFL.setTextureSize(128, 64);
      legFL.mirror = true;
      setRotation(legFL, 0F, 0.2268928F, 0.7853982F);
      legBR = new ModelRenderer(this, 21, 26);
      legBR.addBox(-8F, -1F, 4.5F, 5, 1, 1);
      legBR.setRotationPoint(0F, 0F, 0F);
      legBR.setTextureSize(128, 64);
      legBR.mirror = true;
      setRotation(legBR, 0F, 0.2268928F, -0.7853982F);
      legMR = new ModelRenderer(this, 21, 26);
      legMR.addBox(-8F, -1F, 2.5F, 5, 1, 1);
      legMR.setRotationPoint(0F, 0F, 0F);
      legMR.setTextureSize(128, 64);
      legMR.mirror = true;
      setRotation(legMR, 0F, 0F, -0.7853982F);
      legFR = new ModelRenderer(this, 21, 26);
      legFR.addBox(-8F, -1F, 0.5F, 5, 1, 1);
      legFR.setRotationPoint(0F, 0F, 0F);
      legFR.setTextureSize(128, 64);
      legFR.mirror = true;
      setRotation(legFR, 0F, -0.2268928F, -0.7853982F);
      stinger = new ModelRenderer(this, 68, 14);
      stinger.addBox(-0.5F, 10.5F, 4F, 1, 1, 2);
      stinger.setRotationPoint(0F, 0F, 0F);
      stinger.setTextureSize(128, 64);
      stinger.mirror = true;
      setRotation(stinger, 0F, 0F, 0F);
      stinger2 = new ModelRenderer(this, 92, 0);
      stinger2.addBox(-2.5F, 8F, 6.5F, 5, 4, 5);
      stinger2.setRotationPoint(0F, 0F, 0F);
      stinger2.setTextureSize(128, 64);
      stinger2.mirror = true;
      setRotation(stinger2, 0.2617994F, 0F, 0F);
      stinger4 = new ModelRenderer(this, 58, 14);
      stinger4.addBox(-1F, 11F, 4F, 2, 2, 2);
      stinger4.setRotationPoint(0F, 0F, 0F);
      stinger4.setTextureSize(128, 64);
      stinger4.mirror = true;
      setRotation(stinger4, 0.1745329F, 0F, 0F);
      Stinger3 = new ModelRenderer(this, 39, 12);
      Stinger3.addBox(-1.5F, 12F, -2.466667F, 3, 4, 6);
      Stinger3.setRotationPoint(0F, 0F, 0F);
      Stinger3.setTextureSize(128, 64);
      Stinger3.mirror = true;
      setRotation(Stinger3, 0.7853982F, 0F, 0F);
      head = new ModelRenderer(this, 0, 0);
      head.addBox(-2.5F, -2F, -2F, 5, 5, 4);
      head.setRotationPoint(0F, -1F, -5F);
      head.setTextureSize(128, 64);
      head.mirror = true;
      setRotation(head, -0.5235988F, 0F, 0F);
      mask = new ModelRenderer(this, 0, 9);
      mask.addBox(-3F, -3F, -1.5F, 6, 6, 5);
      mask.setRotationPoint(0F, -1F, -6F);
      mask.setTextureSize(128, 64);
      mask.mirror = true;
      setRotation(mask, -0.5235988F, 0F, 0F);
      mouth = new ModelRenderer(this, 0, 21);
      mouth.addBox(-2F, 1F, -4F, 4, 3, 4);
      mouth.setRotationPoint(0F, -1F, -5F);
      mouth.setTextureSize(128, 64);
      mouth.mirror = true;
      setRotation(mouth, 0.1919862F, 0F, 0F);
      wingL = new ModelRenderer(this, 21, 24);
      wingL.addBox(0F, -11F, -1F, 0, 12, 8);
      wingL.setRotationPoint(2F, -3F, 1F);
      wingL.setTextureSize(128, 64);
      wingL.mirror = true;
      setRotation(wingL, 0.2617994F, 0F, 1.5235988F);
      wingR = new ModelRenderer(this, 21, 36);
      wingR.addBox(0F, -11F, -1F, 0, 12, 8);
      wingR.setRotationPoint(-2F, -3F, 1F);
      wingR.setTextureSize(128, 64);
      wingR.mirror = true;
      setRotation(wingR, 0.2617994F, 0F, -1.5235988F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    mainbody.render(f5);
    midsection.render(f5);
    stinger1.render(f5);
    neck.render(f5);
    legBL.render(f5);
    legML.render(f5);
    legFL.render(f5);
    legBR.render(f5);
    legMR.render(f5);
    legFR.render(f5);
    stinger.render(f5);
    stinger2.render(f5);
    stinger4.render(f5);
    Stinger3.render(f5);
    head.render(f5);
    mask.render(f5);
    mouth.render(f5);
    wingL.render(f5);
    wingR.render(f5);
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
    
    if(this.wingR.rotateAngleZ > 0.1)
    {
        this.rotatewings = 0.17F * (MathHelper.cos(f1 * 1.3F) * (float)Math.PI * 0.25F);
    }
    else if(this.wingR.rotateAngleZ < -1.5)
    {
    	this.rotatewings = -(0.17F * (MathHelper.cos(f1 * 1.3F) * (float)Math.PI * 0.25F));
    }
    this.wingR.rotateAngleZ -= this.rotatewings;
    this.wingL.rotateAngleZ = -this.wingR.rotateAngleZ;
    
    
    if(this.midsection.rotateAngleX > -0.8)
    {
        this.rotatebody = 0.0007F * (MathHelper.cos(f1 * 1.3F) * (float)Math.PI * 0.25F);
    }
    else if(this.midsection.rotateAngleX < -1.1)
    {
    	this.rotatebody = -(0.0007F * (MathHelper.cos(f1 * 1.3F) * (float)Math.PI * 0.25F));
    }
    this.midsection.rotateAngleX -= 0.8F * this.rotatebody;
    this.stinger.rotateAngleX -= 0.6F * this.rotatebody;
    this.stinger1.rotateAngleX -= 0.6F * this.rotatebody;
    this.stinger2.rotateAngleX -= 0.6F * this.rotatebody;
    this.Stinger3.rotateAngleX -= 0.5F * this.rotatebody;
    this.stinger4.rotateAngleX -= 0.5F * this.rotatebody;
    this.mainbody.rotateAngleX -= 0.4F * this.rotatebody;
    
    
    if(this.legBL.rotateAngleX > -0.1)
    {
        this.rotatelegs = 0.0009F * (MathHelper.cos(f1 * 1.3F) * (float)Math.PI * 0.25F);
    }
    else if(this.legBL.rotateAngleX < -0.2)
    {
    	this.rotatelegs = -(0.0009F * (MathHelper.cos(f1 * 1.3F) * (float)Math.PI * 0.25F));
    }
    this.legBL.rotateAngleX -= 0.8F * this.rotatelegs;
    this.legBL.rotateAngleZ += 0.7F * this.rotatelegs;
    this.legBR.rotateAngleX += 0.8F * this.rotatelegs;
    this.legBR.rotateAngleZ -= 0.7F * this.rotatelegs;
    this.legML.rotateAngleX += 0.5F * this.rotatelegs;
    this.legML.rotateAngleZ -= 0.4F * this.rotatelegs;
    this.legMR.rotateAngleX -= 0.5F * this.rotatelegs;
    this.legMR.rotateAngleZ += 0.4F * this.rotatelegs;
    this.legFL.rotateAngleX -= 0.6F * this.rotatelegs;
    this.legFL.rotateAngleZ += 0.7F * this.rotatelegs;
    this.legFR.rotateAngleX += 0.6F * this.rotatelegs;
    this.legFR.rotateAngleZ -= 0.7F * this.rotatelegs;
  }

}










