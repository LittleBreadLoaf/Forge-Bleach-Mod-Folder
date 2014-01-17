package littlebreadloaf.bleach.render.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelMenosGrande extends ModelBase
{
    ModelRenderer head;
    ModelRenderer nose1;
    ModelRenderer body1;
    ModelRenderer body2;
    ModelRenderer rightleg;
    ModelRenderer righttoe1;
    ModelRenderer righttoe2;
    ModelRenderer leftleg;
    ModelRenderer lefttoe1;
    ModelRenderer lefttoe2;
    ModelRenderer body3;
    ModelRenderer body4;
    ModelRenderer face1;
    ModelRenderer face2;
    ModelRenderer face3;
    ModelRenderer face4;
    ModelRenderer nose2;
    ModelRenderer body5;
    ModelRenderer spike1;
    ModelRenderer body6;
    ModelRenderer lefthand;
    ModelRenderer spike2;
    ModelRenderer spike3;
    ModelRenderer spike4;
    ModelRenderer spike5;
    ModelRenderer spike6;
    ModelRenderer spike7;
    ModelRenderer spike8;
    ModelRenderer spike9;
    ModelRenderer spike10;
    ModelRenderer spike11;
    ModelRenderer spike12;
    ModelRenderer spike13;
    ModelRenderer spike14;
    ModelRenderer body7;
    ModelRenderer leftarm1;
    ModelRenderer rightarm1;
    ModelRenderer leftarm2;
    ModelRenderer righthand;
    ModelRenderer rightarm2;
    ModelRenderer body8;

    public ModelMenosGrande()
    {
        this.textureWidth = 256;
        this.textureHeight = 512;
        this.head = new ModelRenderer(this, 159, 90);
        this.head.addBox(-12.0F, -26.0F, -10.0F, 24, 26, 24);
        this.head.setRotationPoint(0.0F, -265.0F, -7.0F);
        this.head.setTextureSize(256, 512);
        this.head.mirror = true;
        this.setRotation(this.head, 0.0F, 0.0F, 0.0F);
        this.nose1 = new ModelRenderer(this, 223, 68);
        this.nose1.addBox(-1.0F, -3.0F, -40.0F, 2, 2, 15);
        this.nose1.setRotationPoint(0.0F, -265.0F, -7.0F);
        this.nose1.setTextureSize(256, 512);
        this.nose1.mirror = true;
        this.setRotation(this.nose1, -0.0523599F, 0.0F, 0.0F);
        this.body1 = new ModelRenderer(this, 0, 44);
        this.body1.addBox(-13.0F, 0.0F, -1.0F, 26, 16, 22);
        this.body1.setRotationPoint(0.0F, -265.0F, -15.0F);
        this.body1.setTextureSize(256, 512);
        this.body1.mirror = true;
        this.setRotation(this.body1, 0.1396263F, 0.0F, 0.0F);
        this.body2 = new ModelRenderer(this, 0, 82);
        this.body2.addBox(-15.0F, 0.0F, 0.0F, 30, 32, 26);
        this.body2.setRotationPoint(0.0F, -250.0F, -16.0F);
        this.body2.setTextureSize(256, 512);
        this.body2.mirror = true;
        this.setRotation(this.body2, 0.1047198F, 0.0F, 0.0F);
        this.rightleg = new ModelRenderer(this, 191, 143);
        this.rightleg.addBox(-8.0F, 0.0F, -8.0F, 16, 36, 16);
        this.rightleg.setRotationPoint(-16.0F, -12.0F, 0.0F);
        this.rightleg.setTextureSize(256, 512);
        this.rightleg.mirror = true;
        this.setRotation(this.rightleg, 0.0F, 0.0F, 0.0F);
        this.righttoe1 = new ModelRenderer(this, 191, 197);
        this.righttoe1.addBox(-8.0F, 32.0F, -18.0F, 14, 10, 10);
        this.righttoe1.setRotationPoint(-15.0F, -18.0F, 0.0F);
        this.righttoe1.setTextureSize(256, 512);
        this.righttoe1.mirror = true;
        this.setRotation(this.righttoe1, 0.0F, 0.0F, 0.0F);
        this.righttoe2 = new ModelRenderer(this, 149, 143);
        this.righttoe2.addBox(-1.5F, 36.5F, -25.0F, 5, 5, 15);
        this.righttoe2.setRotationPoint(-17.0F, -18.0F, 0.0F);
        this.righttoe2.setTextureSize(256, 512);
        this.righttoe2.mirror = true;
        this.setRotation(this.righttoe2, -0.2443461F, 0.0F, 0.0F);
        this.leftleg = new ModelRenderer(this, 191, 143);
        this.leftleg.addBox(-8.0F, 0.0F, -2.0F, 16, 36, 16);
        this.leftleg.setRotationPoint(16.0F, -12.0F, -6.0F);
        this.leftleg.setTextureSize(256, 512);
        this.leftleg.mirror = true;
        this.setRotation(this.leftleg, 0.0F, 0.0F, 0.0F);
        this.lefttoe1 = new ModelRenderer(this, 191, 197);
        this.lefttoe1.addBox(-6.5F, 26.0F, -12.0F, 14, 10, 10);
        this.lefttoe1.setRotationPoint(16.0F, -12.0F, -6.0F);
        this.lefttoe1.setTextureSize(256, 512);
        this.lefttoe1.mirror = true;
        this.setRotation(this.lefttoe1, 0.0F, 0.0F, 0.0F);
        this.lefttoe2 = new ModelRenderer(this, 149, 143);
        this.lefttoe2.addBox(0.5F, 36.5F, -25.0F, 5, 5, 15);
        this.lefttoe2.setRotationPoint(13.0F, -18.0F, 0.0F);
        this.lefttoe2.setTextureSize(256, 512);
        this.lefttoe2.mirror = true;
        this.setRotation(this.lefttoe2, -0.2443461F, 0.0F, 0.0F);
        this.body3 = new ModelRenderer(this, 0, 363);
        this.body3.addBox(-27.0F, 0.0F, 0.0F, 54, 108, 41);
        this.body3.setRotationPoint(0.0F, -108.0F, -15.0F);
        this.body3.setTextureSize(256, 512);
        this.body3.mirror = true;
        this.setRotation(this.body3, 0.0F, 0.0F, 0.0F);
        this.body4 = new ModelRenderer(this, 79, 214);
        this.body4.addBox(9.0F, 42.0F, 0.0F, 9, 20, 30);
        this.body4.setRotationPoint(0.0F, -231.0F, -15.0F);
        this.body4.setTextureSize(256, 512);
        this.body4.mirror = true;
        this.setRotation(this.body4, 0.0523599F, 0.0F, 0.0F);
        this.face1 = new ModelRenderer(this, 134, 0);
        this.face1.addBox(-3.7F, -27.5F, -12.0F, 15, 26, 3);
        this.face1.setRotationPoint(0.0F, -264.0F, -9.0F);
        this.face1.setTextureSize(256, 512);
        this.face1.mirror = true;
        this.setRotation(this.face1, 0.0F, -0.2974216F, 0.0F);
        this.face2 = new ModelRenderer(this, 125, 30);
        this.face2.addBox(-8.3F, -0.5F, -12.0F, 12, 13, 3);
        this.face2.setRotationPoint(0.0F, -265.0F, -9.0F);
        this.face2.setTextureSize(256, 512);
        this.face2.mirror = true;
        this.setRotation(this.face2, -0.1784573F, 0.2974289F, -0.0610865F);
        this.face3 = new ModelRenderer(this, 119, 0);
        this.face3.addBox(-11.3F, -27.5F, -12.0F, 15, 26, 3);
        this.face3.setRotationPoint(0.0F, -264.0F, -9.0F);
        this.face3.setTextureSize(256, 512);
        this.face3.mirror = true;
        this.setRotation(this.face3, 0.0F, 0.2974289F, 0.0F);
        this.face4 = new ModelRenderer(this, 140, 30);
        this.face4.addBox(-3.7F, -0.5F, -12.0F, 12, 13, 3);
        this.face4.setRotationPoint(0.0F, -265.0F, -9.0F);
        this.face4.setTextureSize(256, 512);
        this.face4.mirror = true;
        this.setRotation(this.face4, -0.1784573F, -0.2974216F, 0.0610865F);
        this.nose2 = new ModelRenderer(this, 219, 48);
        this.nose2.addBox(-2.0F, -5.0F, -28.0F, 4, 4, 15);
        this.nose2.setRotationPoint(0.0F, -265.0F, -7.0F);
        this.nose2.setTextureSize(256, 512);
        this.nose2.mirror = true;
        this.setRotation(this.nose2, 0.0F, 0.0F, 0.0F);
        this.body5 = new ModelRenderer(this, 0, 214);
        this.body5.addBox(-18.0F, 42.0F, 0.0F, 9, 20, 30);
        this.body5.setRotationPoint(0.0F, -231.0F, -15.0F);
        this.body5.setTextureSize(256, 512);
        this.body5.mirror = true;
        this.setRotation(this.body5, 0.0523599F, 0.0F, 0.0F);
        this.spike1 = new ModelRenderer(this, 0, 0);
        this.spike1.addBox(0.0F, 13.0F, -29.0F, 2, 2, 15);
        this.spike1.setRotationPoint(0.0F, -231.0F, 0.0F);
        this.spike1.setTextureSize(256, 512);
        this.spike1.mirror = true;
        this.setRotation(this.spike1, -0.2936867F, -1.155811F, 0.0F);
        this.body6 = new ModelRenderer(this, 0, 264);
        this.body6.addBox(-21.0F, 0.0F, 0.0F, 42, 70, 36);
        this.body6.setRotationPoint(0.0F, -170.0F, -15.0F);
        this.body6.setTextureSize(256, 512);
        this.body6.mirror = true;
        this.setRotation(this.body6, 0.0349066F, 0.0F, 0.0F);
        this.lefthand = new ModelRenderer(this, 146, 169);
        this.lefthand.addBox(-3.0F, 92.0F, -6.0F, 6, 22, 14);
        this.lefthand.setRotationPoint(12.0F, -215.2133F, 25.49333F);
        this.lefthand.setTextureSize(256, 512);
        this.lefthand.mirror = true;
        this.setRotation(this.lefthand, -0.1828788F, 0.0297429F, -((float)Math.PI / 10F));
        this.spike2 = new ModelRenderer(this, 0, 0);
        this.spike2.addBox(0.0F, 13.0F, -26.0F, 2, 2, 15);
        this.spike2.setRotationPoint(0.0F, -231.0F, 0.0F);
        this.spike2.setTextureSize(256, 512);
        this.spike2.mirror = true;
        this.setRotation(this.spike2, -0.1745329F, -((float)Math.PI / 5F), 0.0F);
        this.spike3 = new ModelRenderer(this, 0, 0);
        this.spike3.addBox(-5.0F, 13.0F, -26.0F, 2, 2, 15);
        this.spike3.setRotationPoint(0.0F, -231.0F, 0.0F);
        this.spike3.setTextureSize(256, 512);
        this.spike3.mirror = true;
        this.setRotation(this.spike3, -0.1919862F, 0.1745329F, 0.0F);
        this.spike4 = new ModelRenderer(this, 0, 0);
        this.spike4.addBox(-5.0F, 13.0F, -29.0F, 2, 2, 15);
        this.spike4.setRotationPoint(0.0F, -231.0F, 0.0F);
        this.spike4.setTextureSize(256, 512);
        this.spike4.mirror = true;
        this.setRotation(this.spike4, -0.2094395F, 0.6108652F, 0.0F);
        this.spike5 = new ModelRenderer(this, 0, 0);
        this.spike5.addBox(0.0F, 13.0F, -29.0F, 2, 2, 15);
        this.spike5.setRotationPoint(0.0F, -231.0F, 0.0F);
        this.spike5.setTextureSize(256, 512);
        this.spike5.mirror = true;
        this.setRotation(this.spike5, -0.2268928F, ((float)Math.PI * 2F / 5F), 0.0F);
        this.spike6 = new ModelRenderer(this, 0, 0);
        this.spike6.addBox(0.0F, 13.0F, -29.0F, 2, 2, 15);
        this.spike6.setRotationPoint(0.0F, -231.0F, 0.0F);
        this.spike6.setTextureSize(256, 512);
        this.spike6.mirror = true;
        this.setRotation(this.spike6, -0.1919862F, 1.675516F, 0.0F);
        this.spike7 = new ModelRenderer(this, 0, 0);
        this.spike7.addBox(0.0F, 13.0F, -29.0F, 2, 2, 15);
        this.spike7.setRotationPoint(0.0F, -231.0F, 0.0F);
        this.spike7.setTextureSize(256, 512);
        this.spike7.mirror = true;
        this.setRotation(this.spike7, -0.2617994F, 2.129302F, 0.0F);
        this.spike8 = new ModelRenderer(this, 0, 0);
        this.spike8.addBox(0.0F, 13.0F, -29.0F, 2, 2, 15);
        this.spike8.setRotationPoint(0.0F, -231.0F, 0.0F);
        this.spike8.setTextureSize(256, 512);
        this.spike8.mirror = true;
        this.setRotation(this.spike8, -0.296706F, 2.548181F, 0.0F);
        this.spike9 = new ModelRenderer(this, 0, 0);
        this.spike9.addBox(0.0F, 13.0F, -29.0F, 2, 2, 15);
        this.spike9.setRotationPoint(0.0F, -231.0F, 0.0F);
        this.spike9.setTextureSize(256, 512);
        this.spike9.mirror = true;
        this.setRotation(this.spike9, -0.2617994F, 2.9147F, 0.0F);
        this.spike10 = new ModelRenderer(this, 0, 0);
        this.spike10.addBox(0.0F, 13.0F, -29.0F, 2, 2, 15);
        this.spike10.setRotationPoint(0.0F, -231.0F, 0.0F);
        this.spike10.setTextureSize(256, 512);
        this.spike10.mirror = true;
        this.setRotation(this.spike10, -0.296706F, -2.956793F, 0.0F);
        this.spike11 = new ModelRenderer(this, 0, 0);
        this.spike11.addBox(-2.0F, 13.0F, -29.0F, 2, 2, 15);
        this.spike11.setRotationPoint(0.0F, -231.0F, 0.0F);
        this.spike11.setTextureSize(256, 512);
        this.spike11.mirror = true;
        this.setRotation(this.spike11, -0.2792527F, -2.587194F, 0.0F);
        this.spike12 = new ModelRenderer(this, 0, 0);
        this.spike12.addBox(0.0F, 13.0F, -29.0F, 2, 2, 15);
        this.spike12.setRotationPoint(0.0F, -231.0F, 0.0F);
        this.spike12.setTextureSize(256, 512);
        this.spike12.mirror = true;
        this.setRotation(this.spike12, -0.2792527F, -2.032795F, 0.0F);
        this.spike13 = new ModelRenderer(this, 0, 0);
        this.spike13.addBox(0.0F, 13.0F, -29.0F, 2, 2, 15);
        this.spike13.setRotationPoint(0.0F, -231.0F, 0.0F);
        this.spike13.setTextureSize(256, 512);
        this.spike13.mirror = true;
        this.setRotation(this.spike13, -0.3531725F, -1.558011F, 0.0F);
        this.spike14 = new ModelRenderer(this, 0, 0);
        this.spike14.addBox(0.0F, 13.0F, -26.0F, 2, 2, 15);
        this.spike14.setRotationPoint(0.0F, -231.0F, 0.0F);
        this.spike14.setTextureSize(256, 512);
        this.spike14.mirror = true;
        this.setRotation(this.spike14, -0.2042758F, -0.0594858F, 0.0F);
        this.body7 = new ModelRenderer(this, 0, 141);
        this.body7.addBox(-18.0F, 0.0F, 0.0F, 36, 42, 30);
        this.body7.setRotationPoint(0.0F, -231.0F, -15.0F);
        this.body7.setTextureSize(256, 512);
        this.body7.mirror = true;
        this.setRotation(this.body7, 0.0523599F, 0.0F, 0.0F);
        this.leftarm1 = new ModelRenderer(this, 176, 228);
        this.leftarm1.addBox(-10.0F, 0.0F, -10.0F, 20, 50, 20);
        this.leftarm1.setRotationPoint(12.0F, -215.0F, 0.0F);
        this.leftarm1.setTextureSize(256, 512);
        this.leftarm1.mirror = true;
        this.setRotation(this.leftarm1, 0.1570796F, 0.0F, -0.296706F);
        this.rightarm1 = new ModelRenderer(this, 176, 228);
        this.rightarm1.addBox(-10.0F, 0.0F, -10.0F, 20, 50, 20);
        this.rightarm1.setRotationPoint(-12.0F, -215.0F, 0.0F);
        this.rightarm1.setTextureSize(256, 512);
        this.rightarm1.mirror = true;
        this.setRotation(this.rightarm1, 0.1570796F, 0.0F, 0.296706F);
        this.leftarm2 = new ModelRenderer(this, 160, 300);
        this.leftarm2.addBox(-18.0F, 48.0F, -6.0F, 24, 45, 24);
        this.leftarm2.setRotationPoint(12.0F, -215.0F, 0.0F);
        this.leftarm2.setTextureSize(256, 512);
        this.leftarm2.mirror = true;
        this.setRotation(this.leftarm2, 0.037611F, 0.0F, -0.4014257F);
        this.righthand = new ModelRenderer(this, 146, 169);
        this.righthand.addBox(-3.0F, 92.0F, -6.0F, 6, 22, 14);
        this.righthand.setRotationPoint(-12.0F, -215.2133F, 25.49333F);
        this.righthand.setTextureSize(256, 512);
        this.righthand.mirror = true;
        this.setRotation(this.righthand, -0.1828788F, 0.0297429F, ((float)Math.PI / 10F));
        this.rightarm2 = new ModelRenderer(this, 160, 300);
        this.rightarm2.addBox(-6.0F, 48.0F, -6.0F, 24, 45, 24);
        this.rightarm2.setRotationPoint(-12.0F, -215.0F, 0.0F);
        this.rightarm2.setTextureSize(256, 512);
        this.rightarm2.mirror = true;
        this.setRotation(this.rightarm2, 0.037611F, 0.0F, 0.4014257F);
        this.body8 = new ModelRenderer(this, 0, 398);
        this.body8.addBox(-27.0F, 0.0F, 0.0F, 64, 64, 50);
        this.body8.setRotationPoint(-5.0F, -64.0F, -20.0F);
        this.body8.setTextureSize(256, 512);
        this.body8.mirror = true;
        this.setRotation(this.body8, 0.0F, 0.0F, 0.0F);
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7)
    {
        super.render(var1, var2, var3, var4, var5, var6, var7);
        this.setRotationAngles(var2, var3, var4, var5, var6, var7, var1);
        this.head.render(var7);
        this.nose1.render(var7);
        this.body1.render(var7);
        this.body2.render(var7);
        this.rightleg.render(var7);
        this.righttoe1.render(var7);
        this.righttoe2.render(var7);
        this.leftleg.render(var7);
        this.lefttoe1.render(var7);
        this.lefttoe2.render(var7);
        this.body3.render(var7);
        this.body4.render(var7);
        this.face1.render(var7);
        this.face2.render(var7);
        this.face3.render(var7);
        this.face4.render(var7);
        this.nose2.render(var7);
        this.body5.render(var7);
        this.spike1.render(var7);
        this.body6.render(var7);
        this.lefthand.render(var7);
        this.spike2.render(var7);
        this.spike3.render(var7);
        this.spike4.render(var7);
        this.spike5.render(var7);
        this.spike6.render(var7);
        this.spike7.render(var7);
        this.spike8.render(var7);
        this.spike9.render(var7);
        this.spike10.render(var7);
        this.spike11.render(var7);
        this.spike12.render(var7);
        this.spike13.render(var7);
        this.spike14.render(var7);
        this.body7.render(var7);
        this.leftarm1.render(var7);
        this.rightarm1.render(var7);
        this.leftarm2.render(var7);
        this.righthand.render(var7);
        this.rightarm2.render(var7);
        this.body8.render(var7);
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
        this.face1.rotateAngleY = -0.3F;
        this.face2.rotateAngleY = 0.3F;
        this.face3.rotateAngleY = 0.3F;
        this.face4.rotateAngleY = -0.3F;
        this.rightleg.rotateAngleX = MathHelper.cos(var1 * 0.3662F) * 0.8F * var2;
        this.rightleg.rotateAngleY = 0.0F;
        this.leftleg.rotateAngleX = MathHelper.cos(var1 * 0.3662F + (float)Math.PI) * 0.8F * var2;
        this.leftleg.rotateAngleY = 0.0F;
        this.righttoe1.rotateAngleX = MathHelper.cos(var1 * 0.3662F) * 0.8F * var2;
        this.righttoe1.rotateAngleY = 0.0F;
        this.lefttoe1.rotateAngleX = MathHelper.cos(var1 * 0.3662F + (float)Math.PI) * 0.8F * var2;
        this.lefttoe1.rotateAngleY = 0.0F;
        this.righttoe2.rotateAngleX = MathHelper.cos(var1 * 0.3662F) * 0.8F * var2;
        this.righttoe2.rotateAngleY = 0.0F;
        this.lefttoe2.rotateAngleX = MathHelper.cos(var1 * 0.3662F + (float)Math.PI) * 0.8F * var2;
        this.lefttoe2.rotateAngleY = 0.0F;
    }
}













