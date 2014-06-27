package littlebreadloaf.bleach.extras;

import java.util.List;

import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityWindFX extends EntityFX
{
    float reddustParticleScale;
    float Radius;
    float motionXBegin, motionZBegin;

    public EntityWindFX(World var1, double var2, double var4, double var6, float var8, float var9, float var10)
    {
        this(var1, var2, var4, var6, 1.0F, var8, var9, var10);
    }

    public EntityWindFX(World var1, double var2, double var4, double var6, float var8, float var9, float var10, float var11)
    {
        super(var1, var2, var4, var6, 0.0D, 0.0D, 0.0D);
        this.motionXBegin = var9;
        this.motionZBegin = var11;

        if (var9 == 0.0F)
        {
            var9 = 1.0F;
        }

        float var12 = (float)Math.random() * 0.4F + 0.6F;
        this.particleRed = 2.0F;
        this.particleGreen = 2.0F;
        this.particleBlue = 2.0F;
        this.particleScale *= 0.75F;
        this.particleScale *= var8;
        this.Radius = 1 + rand.nextFloat() + rand.nextInt(5);
        this.reddustParticleScale = this.particleScale;
        this.particleMaxAge = (int)(10.0D / (Math.random() * 0.8D + 0.2D));
        this.particleMaxAge = (int)((float)this.particleMaxAge * var8);
        this.noClip = false;
    }

    public void renderParticle(Tessellator var1, float var2, float var3, float var4, float var5, float var6, float var7)
    {
        float var8 = ((float)this.particleAge + var2) / (float)this.particleMaxAge * 32.0F;

        if (var8 < 0.0F)
        {
            var8 = 0.0F;
        }

        if (var8 > 1.0F)
        {
            var8 = 1.0F;
        }

        this.particleScale = this.reddustParticleScale * var8 * 4;
        super.renderParticle(var1, var2, var3, var4, var5, var6, var7);
    }

    /**
     * Called to update the entity's position/logic.
     */
    int counter;
    public void onUpdate()
    {
    	 this.prevPosX = this.posX;
         this.prevPosY = this.posY;
         this.prevPosZ = this.posZ;
         ++counter;

        if (this.particleAge++ >= this.particleMaxAge)
        {
            this.setDead();
        }

        this.setParticleTextureIndex(7 - this.particleAge * 8 / this.particleMaxAge);
        this.motionY *= 0.5599999785423279D;
        this.motionX = Math.sin(this.counter) * this.motionXBegin;
        this.motionZ = Math.cos(this.counter) * this.motionZBegin;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);


        if (this.onGround)
        {
            this.motionX *= 0.699999988079071D;
            this.motionZ *= 0.699999988079071D;
        }
    }

  
}