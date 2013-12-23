package littlebreadloaf.entities.classes;

import java.util.Random;

import littlebreadloaf.armor.Armor;
import littlebreadloaf.events.ExtendedPlayer;
import littlebreadloaf.items.Items;
import littlebreadloaf.libraries.Tools;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityShinigami extends EntityMob
{

	private static Random rand = new Random();
	private boolean angry;
	public EntityShinigami(World par1)
	{
		this(par1, rand.nextInt(11));
	}
	public EntityShinigami(World par1World, int par2) 
	{
		super(par1World);
		this.setTexture(par2);
		   this.tasks.addTask(0, new EntityAISwimming(this));
		   	this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityHollowBat.class, 0.5D, false));
	        this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityHollowBlaze.class, 0.5D, true));
	        this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityHollowGolem.class, 0.5D, true));
	        this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityHollowSnake.class, 0.5D, false));
	        this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityHollowSpider.class, 0.5D, true));
	        this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityHollowOre.class, 0.5D, false));
	        this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityHollowWolf.class, 0.5D, true));
	        this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityFisher.class, 0.5D, true));
	        this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityMenosGrande.class, 0.5D, true));
	        this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityHollowWasp.class, 0.5D, true));
	        this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityHollowStalker.class, 0.5D, true));
	        this.tasks.addTask(11, new EntityAIMoveTowardsRestriction(this, 0.5D));
	        this.tasks.addTask(12, new EntityAIWander(this, 0.5D));
	        this.tasks.addTask(13, new EntityAILookIdle(this));
	        this.tasks.addTask(14, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
	        this.targetTasks.addTask(0, new EntityAIHurtByTarget(this, false));
	        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, false));
	        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityHollowBat.class, 0, false));
	        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityHollowBlaze.class, 0, false));
	        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityHollowGolem.class, 0, false));
	        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityHollowSnake.class, 0, false));
	        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityHollowSpider.class, 0, false));
	        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityHollowWolf.class, 0, false));
	        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityHollowOre.class, 0, false));
	        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityFisher.class, 0, false));
	        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityMenosGrande.class, 0, false));
	        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityHollowWasp.class, 0, false));
	        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityHollowStalker.class, 0, false));
	        this.experienceValue = 15;
		
		
	}
	
	protected boolean isAIEnabled()
	{
		return true;
		
	}
	
	public int getTotalArmorValue()
	{
		return 6;
	}
	

@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		if(this.worldObj.difficultySetting >= 1)
		{
			this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(150.0D);
			
			this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setAttribute(6.0D);
		}
		else
		{
			this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(120.0D);
			
			this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setAttribute(4.0D);
		}
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setAttribute(50);
	
	}
	
	public static final ItemStack heldItem = new ItemStack(Items.zanpakuto, 1);
	@Override
	public ItemStack getHeldItem()
	{
		return heldItem;
	}
	@Override
	/**
     * Makes entity wear random armor based on difficulty
     */
	
    protected void addRandomArmor()
    {
        this.setCurrentItemOrArmor(0, new ItemStack(Item.swordGold));
    }
	
	public EnumCreatureAttribute getCreatureAttribute()
	{
		return Tools.SPIRIT;
	}

	@Override
    public boolean attackEntityFrom(DamageSource par1DamageSource, float par2)
    {
    	if(par1DamageSource.getEntity() instanceof EntityPlayer)
    	{
            this.tasks.addTask(4, new EntityAIAttackOnCollide(this, EntityPlayer.class, 0.5D, true));
    	}
    	this.angry = true;
    	return super.attackEntityFrom(par1DamageSource, par2);
        
    }
	
	   /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {

    	if(rand.nextInt(100) >= 50)
    	{
            return null;
    	}
    	else
    	{
    		return null;
    	}
    	
    }
    
    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
    	if(rand.nextInt(100) >= 25)
    	{
            return null;
    	}
    	else
    	{
    		return null;
    	}

    }


    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return null;
    }


	protected void dropFewItems(boolean par1, int par2)
	{
			 super.dropFewItems(par1, par2);
		        this.entityDropItem(new ItemStack(Items.reiatsu, 2 + rand.nextInt(3) + par2), 0.0F);

		        if (this.rand.nextInt(50 - par2) == 0)
		        {
		            this.dropItem(Items.zanpakuto.itemID, 1);
		        }
		        if (this.rand.nextInt(150 - par2) == 0)
		        {
		            this.dropItem(Armor.ShiniRobe.itemID, 1);
		        }
		        if (this.rand.nextInt(150 - par2) == 0)
		        {
		            this.dropItem(Armor.ShiniPants.itemID, 1);
		        }
		        if (this.rand.nextInt(150 - par2) == 0)
		        {
		            this.dropItem(Armor.Sandals.itemID, 1);
		        }
		
	}
	
	public void onLivingUpdate()
	{
		super.onLivingUpdate();
	}
	
	public int getMaxSpawnedInChunk()
	{
		return 1;
	}
	
	protected void fall(float var1) {}
	
	/**
     * Finds the closest player within 16 blocks to attack, or null if this Entity isn't interested in attacking
     * (Animals, Spiders at day, peaceful PigZombies).
     */
    protected Entity findPlayerToAttack()
    {
        return this.angry ? null : super.findPlayerToAttack();
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
	   /**
     * Called when the mob's health reaches 0.
     
    public void onDeath(DamageSource par1DamageSource)
    {
        super.onDeath(par1DamageSource);

        if (par1DamageSource.getEntity() instanceof EntityPlayer)
        {
        	EntityPlayer var7 = (EntityPlayer)par1DamageSource.getEntity();
            ItemStack var9 = var7.inventory.armorInventory[3];
            if(var9.itemID == mod_Reiatsu.HollowHelmet.itemID && rand.nextInt(20) == 0)
            {
            	int var2 = mod_Reiatsu.Escalon.itemID;
                this.dropItem(var2, 1);
            }
            
        }
        
    }
	*/

  
	
}
