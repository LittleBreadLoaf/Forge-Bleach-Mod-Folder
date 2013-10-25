package littlebreadloaf.entities.classes;

import java.util.Random;

import littlebreadloaf.items.Items;
import littlebreadloaf.libraries.Tools;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityDecoy extends EntityMob
{
	private static Random rand = new Random();
	public EntityDecoy(World par1)
	{
		this(par1, rand.nextInt(10));
	}
	public EntityDecoy(World par1World, int par2) 
	{
		super(par1World);
		this.setTexture(par2);
        float var3 = 0.43F;
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 0.38F));
        this.tasks.addTask(2, new EntityAITempt(this, 0.25F, Items.zanpakuto.itemID, false));
        this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(4, new EntityAILookIdle(this));
        this.tasks.addTask(12, new EntityAILookIdle(this));
        this.tasks.addTask(13, new EntityAIWander(this, var3));
    }

    /**
     * Returns true if the newer Entity AI code should be run
     */
    protected boolean isAIEnabled()
    {
        return true;
    }

    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    public void onLivingUpdate()
    {
        super.onLivingUpdate();
        
    }

    protected void func_110147_ax()
	{
		super.func_110147_ax();
		
			this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(1.0D);
			
			this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(2.0D);
		
	
	}
    
   
    

    /**
     * Drop 0-2 items of this living's type
     */
    protected void dropFewItems(boolean var1, int var2)
    {
            return;
     
    }

    /**
     * Returns the item ID for the item the mob drops on death.
     */
    protected int getDropItemId()
    {
        return 0;
    }

    /**
     * Get this Entity's EnumCreatureAttribute
     */
    public EnumCreatureAttribute getCreatureAttribute()
    {
        return Tools.SPIRIT;
    }

    /**
     * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
     */
    public boolean interact(EntityPlayer var1)
    {
    	
        ItemStack var2 = var1.inventory.getCurrentItem();

        if (var2 != null && var2.itemID == Items.zanpakuto.itemID)
        {
        	worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 3, true);
        	EntityFisher par1 = new EntityFisher(worldObj);
        	par1.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0F, 0.0F);
        	if(!worldObj.isRemote)
        	{
        	worldObj.spawnEntityInWorld(par1);
        	}
            this.setDead();
        }

        return super.interact(var1);
    }

  

    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
        return "mob.endermen.idle";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "mob.endermen.idle";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "mob.endermen.portal";
    }

   

    

    /**
     * Called when the mob is falling. Calculates and applies fall damage.
     */
    protected void fall(float var1) {}

    
    public int getBrightnessForRender(float par1)
    {
        return 15728880;
    }

    /**
     * Gets how bright this entity is.
     */
    public float getBrightness(float par1)
    {
        return 1.0F;
    }

    /**
     * Initialize this creature.
     */
    public void initCreature() {}
    
    public void onDeath(DamageSource par1DamageSource)
    {
    	
    	

    	worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 3, true);
    	EntityFisher par1 = new EntityFisher(worldObj);
    	par1.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0F, 0.0F);
    	worldObj.spawnEntityInWorld(par1);
    		
    		
    		
        
    	
    	this.setDead();
    	
    	
    }
    public void setTexture(int par1)
    {
    	this.dataWatcher.updateObject(19, Integer.valueOf(par1));
    }
    public int getTexture()
    {
        return this.dataWatcher.getWatchableObjectInt(19);
    }

    protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(19, Integer.valueOf(0));
    }
    
    
    
    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeEntityToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setInteger("Texture", this.getTexture());
    }
    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readEntityFromNBT(par1NBTTagCompound);
        this.setTexture(par1NBTTagCompound.getInteger("Texture"));
    }
}

