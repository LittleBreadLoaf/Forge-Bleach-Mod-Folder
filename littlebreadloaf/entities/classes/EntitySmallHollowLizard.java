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

public class EntitySmallHollowLizard extends EntityMob
{
	private static Random rand = new Random();

	public EntitySmallHollowLizard(World par1)
	{
		this(par1, rand.nextInt(3));
	}

	public EntitySmallHollowLizard(World par1World, int par2)
	{
		super(par1World);
		this.setTexture(par2);
		float var3 = 0.48F;
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityPlayer.class, 6.0F, 0.45F, 0.45F));
		this.tasks.addTask(2, new EntityAIPanic(this, 0.5F));
		this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
		this.tasks.addTask(5, new EntityAILookIdle(this));
		this.tasks.addTask(7, new EntityAIWander(this, var3));
	}

	/**
	 * Returns true if the newer Entity AI code should be run
	 */
	protected boolean isAIEnabled()
	{
		return true;
	}

	/**
	 * Called frequently so the entity can update its state every tick as
	 * required. For example, zombies and skeletons use this to react to
	 * sunlight and start to burn.
	 */
	public void onLivingUpdate()
	{
		super.onLivingUpdate();

	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();

		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(10.0D);

		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setAttribute(1.0D);

	}

	/**
	 * Drop 0-2 items of this living's type
	 */
	protected void dropFewItems(boolean var1, int var2)
	{
		this.entityDropItem(new ItemStack(Items.reiatsu, 1), 0.0F);

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
	 * Returns the sound this mob makes while it's alive.
	 */
	protected String getLivingSound()
	{
		return null;
	}

	/**
	 * Returns the sound this mob makes when it is hurt.
	 */
	protected String getHurtSound()
	{
		return null;
	}

	/**
	 * Returns the sound this mob makes on death.
	 */
	protected String getDeathSound()
	{
		return null;
	}

	/**
	 * Called when the mob is falling. Calculates and applies fall damage.
	 */
	protected void fall(float var1)
	{
	}

	

	/**
	 * Initialize this creature.
	 */
	public void initCreature()
	{
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
     * Checks if the entity's current position is a valid location to spawn this entity.
     */
    public boolean getCanSpawnHere()
    {
        return this.posY > 65 && super.getCanSpawnHere();
    }
}
