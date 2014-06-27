package littlebreadloaf.bleach.extras;

import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityTenshoFX extends EntityFX
{
    /** the scale of the flame FX */
    private float flameScale;

    public EntityTenshoFX(World par1World, double par2, double par4, double par6, double par8, double par10, double par12)
    {
        super(par1World, par2, par4, par6, par8, par10, par12);
        this.motionX = 1.0D;
        this.motionY = this.motionY * 0.009999999776482582D + par10;
        this.motionZ = 1.0D;
        double d6 = par2 + (double)((this.rand.nextFloat() - this.rand.nextFloat()) * 0.05F);
        d6 = par4 + (double)((this.rand.nextFloat() - this.rand.nextFloat()) * 0.05F);
        d6 = par6 + (double)((this.rand.nextFloat() - this.rand.nextFloat()) * 0.05F);
        this.flameScale = this.particleScale;
        this.particleRed = 1.0F;
        this.particleGreen = 1.0F;
        this.particleBlue = 1.0F;
        this.particleMaxAge = (int)(8.0D / (Math.random() * 0.8D + 0.2D)) + 4;
        this.noClip = true;
       
        this.setParticleTextureIndex(96);
       
    }

    public void renderParticle(Tessellator par1Tessellator, float par2, float par3, float par4, float par5, float par6, float par7)
    {
        float f6 = ((float)this.particleAge + par2) / (float)this.particleMaxAge;
        this.particleScale = this.flameScale * (2.0F - f6 * f6 * 0.5F);
        super.renderParticle(par1Tessellator, par2, par3, par4, par5, par6, par7);
    }

    public int getBrightnessForRender(float par1)
    {
       

        return  205;
    }

    /**
     * Gets how bright this entity is.
     */
    public float getBrightness(float par1)
    {
        float f1 = ((float)this.particleAge + par1) / (float)this.particleMaxAge;

        if (f1 < 0.0F)
        {
            f1 = 0.0F;
        }

        if (f1 > 1.0F)
        {
            f1 = 1.0F;
        }

        float f2 = super.getBrightness(par1);
        return f2 * f1 + (1.0F - f1);
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

       

        this.motionX = Math.sin(this.counter)*0.1;
        this.motionY *= 1.29599999785423279D;
        this.motionZ = Math.cos(this.counter)*0.1;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.flameScale += 0.02;
      

        if (this.onGround)
        {
            this.motionX *= 0.699999988079071D;
            this.motionZ *= 0.699999988079071D;
        }
    }
}
