package littlebreadloaf.bleach.entities;

import java.util.Random;

import littlebreadloaf.bleach.api.Tools;
import littlebreadloaf.bleach.armor.Armor;
import littlebreadloaf.bleach.events.ExtendedPlayer;
import littlebreadloaf.bleach.items.BleachItems;
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
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityHollowWasp extends EntityMob
{
	private static Random rand = new Random();

	public EntityHollowWasp(World par1)
	{
		this(par1, rand.nextInt(4));
	}

	public EntityHollowWasp(World par1World, int par2)
	{
		super(par1World);
		this.setTexture(par2);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityPlayer.class, 0.4D, false));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityWhole.class, 0.4D, false));
		this.tasks.addTask(3, new EntityAIAttackOnCollide(this, EntityShinigami.class, 0.4D, false));
		this.tasks.addTask(4, new EntityAIAvoidEntity(this, EntityIronGolem.class, 6.0F, 0.3F, 0.3F));
		this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 0.4D));
		this.tasks.addTask(6, new EntityAIWander(this, 0.4D));
		this.tasks.addTask(7, new EntityAILookIdle(this));
		this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(9, new EntityAIWatchClosest(this, EntityWhole.class, 8.0F));
		this.targetTasks.addTask(0, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityWhole.class, 0, false));
		this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityShinigami.class, 0, false));
		this.experienceValue = 15;
		this.setSize(1.4F, 1.7F);

	}

	protected boolean isAIEnabled()
	{
		return true;

	}

	public int getTotalArmorValue()
	{
		return 4;
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		if (this.worldObj.difficultySetting >= 1)
		{
			this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(70.0D);

			this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setAttribute(6.0D);
		} else
		{
			this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(50.0D);

			this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setAttribute(4.0D);
		}
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setAttribute(50);

	}

	public EnumCreatureAttribute getCreatureAttribute()
	{
		return Tools.SPIRIT;
	}

	/**
	 * Returns the sound this mob makes when it is hurt.
	 */
	protected String getHurtSound()
	{

		if (rand.nextInt(100) >= 50)
		{
			return "bleach.hollowscream";
		} else
		{
			return null;
		}

	}

	/**
	 * Returns the sound this mob makes while it's alive.
	 */
	protected String getLivingSound()
	{
		if (rand.nextInt(100) >= 25)
		{
			return "bleach:hollowscream";
		} else
		{
			return null;
		}

	}

	/**
	 * Returns the sound this mob makes on death.
	 */
	protected String getDeathSound()
	{
		return "bleach:hollowscream";
	}

	protected void dropFewItems(boolean par1, int par2)
	{
		super.dropFewItems(par1, par2);
		this.entityDropItem(new ItemStack(BleachItems.reiatsu, 2 + rand.nextInt(3) + par2), 0.0F);

		if (this.rand.nextInt(20 - par2) == 0)
		{
			this.dropItem(Armor.WaspHelmet.itemID, 1);
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

	protected void fall(float var1)
	{
	}

	
	/**
	 * Basic mob attack. Default to touch of death in EntityCreature. Overridden
	 * by each mob to define their attack.
	 */
	@Override
	protected void attackEntity(Entity target, float distace)
	{
		if (this.attackTime <= 0 && distace < 2.0F && target.boundingBox.maxY > this.boundingBox.minY && target.boundingBox.minY < this.boundingBox.maxY)
		{
			this.attackTime = 20;
			this.attackEntityAsMob(target);
		}
	}
	
	public boolean attackEntityAsMob(Entity par1Entity)
	{
		if (super.attackEntityAsMob(par1Entity))
		{
			if (par1Entity instanceof EntityPlayer)
			{
				ExtendedPlayer props = ((ExtendedPlayer) ((EntityPlayer) par1Entity).getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME));
				byte b0 = 0;

				if (this.worldObj.difficultySetting > 1)
				{
					if (this.worldObj.difficultySetting == 2)
					{
						b0 = 30;
					} else if (this.worldObj.difficultySetting == 3)
					{
						b0 = 50;
					}
				}
				props.consumeEnergy(b0);

			}

			return true;
		} else
		{
			return false;
		}
	}

	
	/**
	 * randomly selected ChunkCoordinates in a 7x6x7 box around the bat (y
	 * offset -2 to 4) towards which it will fly. upon getting close a new
	 * target will be selected
	 */
	private ChunkCoordinates currentFlightTarget;

	/**
	 * Returns true if this entity should push and be pushed by other entities
	 * when colliding.
	 */
	@Override
	public boolean canBePushed()
	{
		return false;
	}

	@Override
	protected void collideWithEntity(Entity par1Entity)
	{
		this.attackEntityAsMob(par1Entity);
	}

	@Override
	protected void collideWithNearbyEntities()
	{
	}

	/**
	 * Called to update the entity's position/logic.
	 */
	@Override
	public void onUpdate()
	{
		super.onUpdate();
		// fall
		this.motionY *= 0.6000000238418579D;

		if (this.entityToAttack != null && this.entityToAttack != this.attackingPlayer)
		{
			this.entityToAttack = this.attackingPlayer;
		}

		// get target
		if (this.entityToAttack == null)
		{
			this.entityToAttack = this.worldObj.getClosestVulnerablePlayerToEntity(this, 16);
		}

		if (this.currentFlightTarget != null
				&& (!this.worldObj.isAirBlock(this.currentFlightTarget.posX, this.currentFlightTarget.posY, this.currentFlightTarget.posZ) || this.currentFlightTarget.posY < 1))
		{
			this.currentFlightTarget = null;
		}
		if (this.entityToAttack != null)
		{
			this.currentFlightTarget = new ChunkCoordinates((int) this.entityToAttack.posX, (int) this.entityToAttack.posY, (int) this.entityToAttack.posZ);
		} else
		{
			if (this.currentFlightTarget == null || this.rand.nextInt(30) == 0
					|| this.currentFlightTarget.getDistanceSquared((int) this.posX, (int) this.posY, (int) this.posZ) < 4.0F)
			{
				this.currentFlightTarget =
						new ChunkCoordinates((int) this.posX + this.rand.nextInt(10) - this.rand.nextInt(10), (int) this.posY + this.rand.nextInt(9) - 2, (int) this.posZ
								+ this.rand.nextInt(10) - this.rand.nextInt(10));
			}
		}

		// approach target
		double d0 = (double) this.currentFlightTarget.posX + 0.5D - this.posX;
		double d1 = (double) this.currentFlightTarget.posY + 0.1D - this.posY;
		double d2 = (double) this.currentFlightTarget.posZ + 0.5D - this.posZ;
		this.motionX += (Math.signum(d0) * 0.5D - this.motionX) * 0.10000000149011612D;
		this.motionY += (Math.signum(d1) * 0.699999988079071D - this.motionY) * 0.10000000149011612D;
		this.motionZ += (Math.signum(d2) * 0.5D - this.motionZ) * 0.10000000149011612D;
		float f = (float) (Math.atan2(this.motionZ, this.motionX) * 180.0D / Math.PI) - 90.0F;
		float f1 = MathHelper.wrapAngleTo180_float(f - this.rotationYaw);
		this.moveForward = 0.5F;
		this.rotationYaw += f1;

		// attack target
		if (this.entityToAttack != null && this.entityToAttack.getDistanceSqToEntity(this) < 3.0F)
		{
			this.attackEntity(this.entityToAttack, this.getDistanceToEntity(this.entityToAttack));
		}

	}

	/**
	 * returns if this entity triggers Block.onEntityWalking on the blocks they
	 * walk on. used for spiders and wolves to prevent them from trampling crops
	 */
	@Override
	protected boolean canTriggerWalking()
	{
		return false;
	}
	
	
	
	/**
	 * Takes in the distance the entity has fallen this tick and whether its on
	 * the ground to update the fall distance and deal fall damage if landing on
	 * the ground. Args: distanceFallenThisTick, onGround
	 */
	@Override
	protected void updateFallState(double par1, boolean par3)
	{
	}

	/**
	 * Return whether this entity should NOT trigger a pressure plate or a
	 * tripwire.
	 */
	@Override
	public boolean doesEntityNotTriggerPressurePlate()
	{
		return true;
	}

	
	
	
	/**
	 * Called when the mob's health reaches 0.
	 */
	public void onDeath(DamageSource par1DamageSource)
	{
		super.onDeath(par1DamageSource);

		if (par1DamageSource.getEntity() instanceof EntityPlayer)
		{
			ExtendedPlayer props = (ExtendedPlayer) this.attackingPlayer.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);
			if (props.getFaction() == 1 && this.attackingPlayer.inventory.getCurrentItem() != null
					&& this.attackingPlayer.inventory.getCurrentItem().itemID == BleachItems.zanpakuto.itemID && props.getZTotal() < 400)
			{
				props.addPoints(6, 2);
				props.addPoints(3, 2);
				props.addPoints(1, 1);
			}

		}
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
