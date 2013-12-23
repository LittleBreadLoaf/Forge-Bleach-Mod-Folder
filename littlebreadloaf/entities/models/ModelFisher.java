package littlebreadloaf.entities.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelFisher extends ModelBase
{
  //fields
    ModelRenderer TailEnd1;
    ModelRenderer Tail1;
    ModelRenderer Tail2;
    ModelRenderer Tail3;
    ModelRenderer TailEnd2;
    ModelRenderer leftfoot;
    ModelRenderer leftleg1;
    ModelRenderer leftleg3;
    ModelRenderer leftleg2;
    ModelRenderer rightleg1;
    ModelRenderer rightleg2;
    ModelRenderer rightleg3;
    ModelRenderer rightfoot;
    ModelRenderer body4;
    ModelRenderer body3;
    ModelRenderer rightarm1;
    ModelRenderer rightarm2;
    ModelRenderer leftarm3;
    ModelRenderer leftarm1;
    ModelRenderer leftarm2;
    ModelRenderer rightarm3;
    ModelRenderer Mask;
    ModelRenderer body1;
    ModelRenderer body2;
    ModelRenderer Mask1;
    ModelRenderer Mask2;
    ModelRenderer Mask3;
    ModelRenderer body5;
    ModelRenderer body6;
    ModelRenderer Mask4;
    ModelRenderer Mask5;
  
  public ModelFisher()
  {
    textureWidth = 128;
    textureHeight = 256;
    
      TailEnd1 = new ModelRenderer(this, 85, 0);
      TailEnd1.addBox(-5F, -16F, -28F, 2, 13, 2);
      TailEnd1.setRotationPoint(-0.5F, -13F, -17F);
      TailEnd1.setTextureSize(128, 256);
      TailEnd1.mirror = true;
      setRotation(TailEnd1, -0.1396263F, 0F, 0.2094395F);
      Tail1 = new ModelRenderer(this, 59, 0);
      Tail1.addBox(-2F, -12F, -2F, 2, 13, 2);
      Tail1.setRotationPoint(1F, -38.3F, -13F);
      Tail1.setTextureSize(128, 256);
      Tail1.mirror = true;
      setRotation(Tail1, 0.8551081F, 0F, 0F);
      Tail2 = new ModelRenderer(this, 71, 0);
      Tail2.addBox(-1F, -18F, 8.5F, 2, 13, 2);
      Tail2.setRotationPoint(0F, -37F, -15F);
      Tail2.setTextureSize(128, 256);
      Tail2.mirror = true;
      setRotation(Tail2, 1.784573F, 0F, 0F);
      Tail3 = new ModelRenderer(this, 79, 0);
      Tail3.addBox(-0.5F, -19F, 18.5F, 1, 13, 1);
      Tail3.setRotationPoint(0F, -37F, -15F);
      Tail3.setTextureSize(128, 256);
      Tail3.mirror = true;
      setRotation(Tail3, 2.558508F, 0F, 0F);
      TailEnd2 = new ModelRenderer(this, 93, 0);
      TailEnd2.addBox(3.5F, -18F, -27.5F, 2, 13, 2);
      TailEnd2.setRotationPoint(-0.5F, -14F, -15F);
      TailEnd2.setTextureSize(128, 256);
      TailEnd2.mirror = true;
      setRotation(TailEnd2, 0F, 0F, -0.2094395F);
      leftfoot = new ModelRenderer(this, 0, 191);
      leftfoot.addBox(-3F, 29F, -14F, 7, 3, 12);
      leftfoot.setRotationPoint(9F, -8F, 6F);
      leftfoot.setTextureSize(128, 256);
      leftfoot.mirror = true;
      setRotation(leftfoot, 0F, -0.3549525F, 0F);
      leftleg1 = new ModelRenderer(this, 0, 132);
      leftleg1.addBox(-6F, 0F, -6F, 12, 21, 12);
      leftleg1.setRotationPoint(9F, -8F, 6F);
      leftleg1.setTextureSize(128, 256);
      leftleg1.mirror = true;
      setRotation(leftleg1, -0.3490659F, -0.3549525F, 0F);
      leftleg3 = new ModelRenderer(this, 68, 175);
      leftleg3.addBox(-2F, 13F, -19F, 4, 12, 4);
      leftleg3.setRotationPoint(9F, -8F, 6F);
      leftleg3.setTextureSize(128, 256);
      leftleg3.mirror = true;
      setRotation(leftleg3, 0.4712389F, -0.3549525F, 0F);
      leftleg2 = new ModelRenderer(this, 0, 165);
      leftleg2.addBox(-4F, 21F, -4F, 8, 2, 8);
      leftleg2.setRotationPoint(9F, -8F, 6F);
      leftleg2.setTextureSize(128, 256);
      leftleg2.mirror = true;
      setRotation(leftleg2, -0.3490659F, -0.3549525F, 0F);
      rightleg1 = new ModelRenderer(this, 0, 132);
      rightleg1.addBox(-6F, 0F, -6F, 12, 21, 12);
      rightleg1.setRotationPoint(-9F, -8F, 6F);
      rightleg1.setTextureSize(128, 256);
      rightleg1.mirror = true;
      setRotation(rightleg1, -0.3490659F, 0.3549476F, 0F);
      rightleg2 = new ModelRenderer(this, 0, 165);
      rightleg2.addBox(-4F, 21F, -4F, 8, 2, 8);
      rightleg2.setRotationPoint(-9F, -8F, 6F);
      rightleg2.setTextureSize(128, 256);
      rightleg2.mirror = true;
      setRotation(rightleg2, -0.3490659F, 0.3549476F, 0F);
      rightleg3 = new ModelRenderer(this, 68, 175);
      rightleg3.addBox(-2F, 13F, -19F, 4, 12, 4);
      rightleg3.setRotationPoint(-9F, -8F, 6F);
      rightleg3.setTextureSize(128, 256);
      rightleg3.mirror = true;
      setRotation(rightleg3, 0.4712389F, 0.3549476F, 0F);
      rightfoot = new ModelRenderer(this, 0, 191);
      rightfoot.addBox(-4F, 29F, -14F, 7, 3, 12);
      rightfoot.setRotationPoint(-9F, -8F, 6F);
      rightfoot.setTextureSize(128, 256);
      rightfoot.mirror = true;
      setRotation(rightfoot, 0F, 0.3549476F, 0F);
      body4 = new ModelRenderer(this, 0, 116);
      body4.addBox(-10F, 0F, 0F, 20, 3, 12);
      body4.setRotationPoint(0F, -5F, 2F);
      body4.setTextureSize(128, 256);
      body4.mirror = true;
      setRotation(body4, 0.3717861F, 0F, 0F);
      body3 = new ModelRenderer(this, 0, 71);
      body3.addBox(-14F, 0F, 0F, 28, 30, 15);
      body3.setRotationPoint(0F, -32F, -10F);
      body3.setTextureSize(128, 256);
      body3.mirror = true;
      setRotation(body3, 0.3717861F, 0F, 0F);
      rightarm1 = new ModelRenderer(this, 90, 30);
      rightarm1.addBox(-8F, -2F, -4F, 9, 20, 10);
      rightarm1.setRotationPoint(-12F, -31.81333F, -4F);
      rightarm1.setTextureSize(128, 256);
      rightarm1.mirror = true;
      setRotation(rightarm1, 0F, 0.0594858F, 0.4454204F);
      rightarm2 = new ModelRenderer(this, 98, 60);
      rightarm2.addBox(-6.5F, 2F, 11F, 7, 17, 8);
      rightarm2.setRotationPoint(-12F, -31.81333F, -4F);
      rightarm2.setTextureSize(128, 256);
      rightarm2.mirror = true;
      setRotation(rightarm2, -1.186824F, 0.0594858F, 0.4454204F);
      leftarm3 = new ModelRenderer(this, 116, 85);
      leftarm3.addBox(0.5F, 19F, 13F, 3, 8, 3);
      leftarm3.setRotationPoint(12F, -31.8F, -4F);
      leftarm3.setTextureSize(128, 256);
      leftarm3.mirror = true;
      setRotation(leftarm3, -1.189716F, -0.1499587F, -0.4977854F);
      leftarm1 = new ModelRenderer(this, 90, 30);
      leftarm1.addBox(-1F, -2F, -4F, 9, 20, 10);
      leftarm1.setRotationPoint(12F, -31.8F, -4F);
      leftarm1.setTextureSize(128, 256);
      leftarm1.mirror = true;
      setRotation(leftarm1, 0F, -0.1499587F, -0.4977854F);
      leftarm2 = new ModelRenderer(this, 98, 60);
      leftarm2.addBox(-0.5F, 2F, 11F, 7, 17, 8);
      leftarm2.setRotationPoint(12F, -31.8F, -4F);
      leftarm2.setTextureSize(128, 256);
      leftarm2.mirror = true;
      setRotation(leftarm2, -1.186824F, -0.1499587F, -0.4977854F);
      rightarm3 = new ModelRenderer(this, 116, 85);
      rightarm3.addBox(-4.5F, 19F, 13F, 3, 8, 3);
      rightarm3.setRotationPoint(-12F, -31.81333F, -4F);
      rightarm3.setTextureSize(128, 256);
      rightarm3.mirror = true;
      setRotation(rightarm3, -1.189716F, 0.0594858F, 0.4454204F);
      Mask = new ModelRenderer(this, 22, 16);
      Mask.addBox(0F, -10F, 0F, 10, 9, 1);
      Mask.setRotationPoint(0F, -15F, -8F);
      Mask.setTextureSize(128, 256);
      Mask.mirror = true;
      setRotation(Mask, 0.3839724F, -0.3316126F, -0.1396263F);
      body1 = new ModelRenderer(this, 0, 30);
      body1.addBox(-10F, 0F, 0F, 20, 5, 12);
      body1.setRotationPoint(0F, -41F, -14F);
      body1.setTextureSize(128, 256);
      body1.mirror = true;
      setRotation(body1, 0.5288657F, 0F, 0F);
      body2 = new ModelRenderer(this, 0, 46);
      body2.addBox(-12F, 0F, 0F, 24, 11, 14);
      body2.setRotationPoint(0F, -39F, -14F);
      body2.setTextureSize(128, 256);
      body2.mirror = true;
      setRotation(body2, 0.5288657F, 0F, 0F);
      Mask1 = new ModelRenderer(this, 0, 0);
      Mask1.addBox(-11.7F, -24F, -1F, 12, 15, 1);
      Mask1.setRotationPoint(0F, -15F, -8F);
      Mask1.setTextureSize(128, 256);
      Mask1.mirror = true;
      setRotation(Mask1, 0.3839724F, 0.3316126F, 0.1396263F);
      Mask2 = new ModelRenderer(this, 26, 0);
      Mask2.addBox(-0.3F, -24F, -1F, 12, 15, 1);
      Mask2.setRotationPoint(0F, -15F, -8F);
      Mask2.setTextureSize(128, 256);
      Mask2.mirror = true;
      setRotation(Mask2, 0.3839724F, -0.3316126F, -0.1396263F);
      Mask3 = new ModelRenderer(this, 0, 16);
      Mask3.addBox(-10F, -10F, 0F, 10, 9, 1);
      Mask3.setRotationPoint(0F, -15F, -8F);
      Mask3.setTextureSize(128, 256);
      Mask3.mirror = true;
      setRotation(Mask3, 0.3839724F, 0.3316126F, 0.1396263F);
      body5 = new ModelRenderer(this, 57, 149);
      body5.addBox(-1.4F, 3.5F, -7.5F, 7, 3, 11);
      body5.setRotationPoint(0F, -42F, -10F);
      body5.setTextureSize(128, 256);
      body5.mirror = true;
      setRotation(body5, 0.2387955F, 1.058731F, 0.7175527F);
      body6 = new ModelRenderer(this, 57, 149);
      body6.addBox(-5.4F, 3.5F, -7.5F, 7, 3, 11);
      body6.setRotationPoint(0F, -42F, -9.8F);
      body6.setTextureSize(128, 256);
      body6.mirror = true;
      setRotation(body6, 0.2387959F, -1.058734F, -0.7175572F);
      Mask4 = new ModelRenderer(this, 112, 132);
      Mask4.addBox(0F, -1F, 0F, 7, 5, 1);
      Mask4.setRotationPoint(0F, -15F, -8F);
      Mask4.setTextureSize(128, 256);
      Mask4.mirror = true;
      setRotation(Mask4, 0.3839724F, -0.3316126F, -0.1396263F);
      Mask5 = new ModelRenderer(this, 95, 132);
      Mask5.addBox(-7F, -1F, 0F, 7, 5, 1);
      Mask5.setRotationPoint(0F, -15F, -8F);
      Mask5.setTextureSize(128, 256);
      Mask5.mirror = true;
      setRotation(Mask5, 0.3839724F, 0.3316126F, 0.1396263F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    TailEnd1.render(f5);
    Tail1.render(f5);
    Tail2.render(f5);
    Tail3.render(f5);
    TailEnd2.render(f5);
    leftfoot.render(f5);
    leftleg1.render(f5);
    leftleg3.render(f5);
    leftleg2.render(f5);
    rightleg1.render(f5);
    rightleg2.render(f5);
    rightleg3.render(f5);
    rightfoot.render(f5);
    body4.render(f5);
    body3.render(f5);
    rightarm1.render(f5);
    rightarm2.render(f5);
    leftarm3.render(f5);
    leftarm1.render(f5);
    leftarm2.render(f5);
    rightarm3.render(f5);
    Mask.render(f5);
    body1.render(f5);
    body2.render(f5);
    Mask1.render(f5);
    Mask2.render(f5);
    Mask3.render(f5);
    body5.render(f5);
    body6.render(f5);
    Mask4.render(f5);
    Mask5.render(f5);
  }


    private void setRotation(ModelRenderer var1, float var2, float var3, float var4)
    {
        var1.rotateAngleX = var2;
        var1.rotateAngleY = var3;
        var1.rotateAngleZ = var4;
    }

    /**
     * Sets the model's various rotation angles. For bipeds, par1 and par2 are used for animating the movement of arms
     * and legs, where par1 represents the time(so that arms and legs swing back and forth) and par2 represents how
     * "far" arms and legs can swing at most.
     */
    public void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, Entity var7)
    {
        super.setRotationAngles(var1, var2, var3, var4, var5, var6, var7);
        this.rightleg1.rotateAngleX = (float)((double)(MathHelper.cos(var1 * 0.6662F) * 0.6F * var2) - 0.35D);
        this.rightleg1.rotateAngleY = 0.35F;
        this.leftleg1.rotateAngleX = (float)((double)(MathHelper.cos(var1 * 0.6662F + (float)Math.PI) * 0.6F * var2) - 0.35D);
        this.leftleg1.rotateAngleY = -0.35F;
        this.rightleg2.rotateAngleX = (float)((double)(MathHelper.cos(var1 * 0.6662F) * 0.6F * var2) - 0.35D);
        this.rightleg2.rotateAngleY = 0.35F;
        this.leftleg2.rotateAngleX = (float)((double)(MathHelper.cos(var1 * 0.6662F + (float)Math.PI) * 0.6F * var2) - 0.35D);
        this.leftleg2.rotateAngleY = -0.35F;
        this.rightleg3.rotateAngleX = (float)((double)(MathHelper.cos(var1 * 0.6662F) * 0.6F * var2) + 0.45D);
        this.rightleg3.rotateAngleY = 0.35F;
        this.rightfoot.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 0.6F * var2;
        this.rightfoot.rotateAngleY = 0.35F;
        this.leftleg3.rotateAngleX = (float)((double)(MathHelper.cos(var1 * 0.6662F + (float)Math.PI) * 0.6F * var2) + 0.45D);
        this.leftleg3.rotateAngleY = -0.35F;
        this.leftfoot.rotateAngleX = MathHelper.cos(var1 * 0.6662F + (float)Math.PI) * 0.6F * var2;
        this.leftfoot.rotateAngleY = -0.35F;
        
        this.Tail1.rotateAngleX = (float)((double)(MathHelper.cos(var1 * 0.5F) * 0.19F * var2) + 0.85D);
        this.Tail2.rotateAngleX = (float)((double)(MathHelper.cos(var1 * 0.5F) * 0.14F * var2) + 1.83D);
        this.Tail3.rotateAngleX = (float)((double)(MathHelper.cos(var1 * 0.5F) * 0.08F * var2) + 2.6D);
        this.TailEnd1.rotateAngleX = (float)((double)(MathHelper.cos(var1 * 0.5F) * 0.07F * var2) + 6.2D);
        this.TailEnd2.rotateAngleX = (float)((double)(MathHelper.cos(var1 * 0.5F) * 0.07F * var2) + 6.32D);
        
        this.rightarm1.rotateAngleX = MathHelper.cos(var1 * 0.6662F + (float)Math.PI) * 2.0F * var2 * 0.1F;
        this.leftarm1.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 2.0F * var2 * 0.1F;
        this.rightarm1.rotateAngleZ = 0.43F;
        this.leftarm1.rotateAngleZ = -0.46F;
        this.rightarm2.rotateAngleX = (float) (MathHelper.cos(var1 * 0.6662F + (float)Math.PI) * 2.0F * var2 * 0.2F - 1.2);
        this.leftarm2.rotateAngleX = (float) (MathHelper.cos(var1 * 0.6662F) * 2.0F * var2 * 0.2F - 1.2);
        this.rightarm2.rotateAngleZ = 0.43F;
        this.leftarm2.rotateAngleZ = -0.46F;
        this.rightarm3.rotateAngleX = (float) (MathHelper.cos(var1 * 0.6662F + (float)Math.PI) * 2.0F * var2 * 0.2F - 1.2);
        this.leftarm3.rotateAngleX = (float) (MathHelper.cos(var1 * 0.6662F) * 2.0F * var2 * 0.2F - 1.2);
        this.rightarm3.rotateAngleZ = 0.43F;
        this.leftarm3.rotateAngleZ = -0.46F;
       
        this.body5.rotateAngleX = 0.33F;
        this.body6.rotateAngleX = 0.32F;
        this.body5.rotateAngleY = 1.96F;
        this.body6.rotateAngleY = -2.06F;
        this.body5.rotateAngleZ = 0.5F;
        this.body6.rotateAngleZ = -0.5F;
    }
}

