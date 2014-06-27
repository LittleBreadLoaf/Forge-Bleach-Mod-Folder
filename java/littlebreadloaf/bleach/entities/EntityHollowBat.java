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
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityHollowBat extends EntityMob
{
	private static Random rand = new Random();

	public int courseChangeCooldown;

	public EntityHollowBat(World par1)
	{
		this(par1, rand.nextInt(3));
	}

	public EntityHollowBat(World par1World, int par2)
	{
		super(par1World);
		this.setTexture(par2);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityPlayer.class, 0.6D, false));
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
		this.isImmuneToFire = true;
		this.setSize(0.7F, 1.8F);

	}
	
	@Override
	protected boolean isAIEnabled()
	{
		return true;

	}

	@Override
	public int getTotalArmorValue()
	{
		return 4;
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		if (this.worldObj.difficultySetting == EnumDifficulty.NORMAL || this.worldObj.difficultySetting == EnumDifficulty.HARD)
		{
			this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(70.0D);

			this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(6.0D);
		} else
		{
			this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(50.0D);

			this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(4.0D);
		}
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(50);

	}

	@Override
	public EnumCreatureAttribute getCreatureAttribute()
	{
		return Tools.SPIRIT;
	}

	/**
	 * Returns the sound this mob makes when it is hurt.
	 */
	@Override
	protected String getHurtSound()
	{
		if (rand.nextInt(100) >= 50)
		{
			return "bleach:hollowscream";
		} else
		{
			return null;
		}
	}

	/**
	 * Returns the sound this mob makes while it's alive.
	 */
	@Override
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
	@Override
	protected String getDeathSound()
	{
		return "bleach:hollowscream";
	}

	@Override
	protected void dropFewItems(boolean par1, int par2)
	{
		super.dropFewItems(par1, par2);
		this.entityDropItem(new ItemStack(BleachItems.reiatsu, 2 + rand.nextInt(3) + par2), 0.0F);

		if (this.rand.nextInt(20 - par2) == 0)
		{
			this.dropItem(Armor.BatHelmet, 1);
		}

	}

	@Override
	public void onLivingUpdate()
	{
		super.onLivingUpdate();
	}

	@Override
	public int getMaxSpawnedInChunk()
	{
		return 1;
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

	@Override
	public boolean attackEntityAsMob(Entity par1Entity)
	{
		if (super.attackEntityAsMob(par1Entity))
		{
			if (par1Entity instanceof EntityLivingBase)
			{
				byte b0 = 0;

				
					if (this.worldObj.difficultySetting == EnumDifficulty.NORMAL)
					{
						b0 = 7;
					} else if (this.worldObj.difficultySetting == EnumDifficulty.NORMAL)
					{
						b0 = 15;
					}
				

				if (b0 > 0)
				{
					((EntityLivingBase) par1Entity).addPotionEffect(new PotionEffect(Potion.blindness.id, b0 * 20, 0));
				}
			}

			return true;
		} else
		{
			return false;
		}
	}

	// /

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
			this.entityToAttack = this.worldObj.getClosestVulnerablePlayerToEntity(this, 32);
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
	 * Called when the mob is falling. Calculates and applies fall damage.
	 */
	@Override
	protected void fall(float par1)
	{
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
	@Override
	public void onDeath(DamageSource par1DamageSource)
	{
		super.onDeath(par1DamageSource);

		if (par1DamageSource.getEntity() instanceof EntityPlayer)
		{
			ExtendedPlayer props = (ExtendedPlayer) this.attackingPlayer.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);
			if (props.getFaction() == 1 && this.attackingPlayer.inventory.getCurrentItem() != null
					&& this.attackingPlayer.inventory.getCurrentItem().getItem() == BleachItems.zanpakuto && props.getZTotal() < 400)
			{
				props.addPoints(7, 4);
				props.addPoints(6, 3);
				props.addPoints(8, -2);
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

	@Override
	protected void entityInit()
	{
		super.entityInit();
		this.dataWatcher.addObject(19, Integer.valueOf(0));
	}

	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	@Override
	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.writeEntityToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setInteger("Texture", this.getTexture());
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	@Override
	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.readEntityFromNBT(par1NBTTagCompound);
		this.setTexture(par1NBTTagCompound.getInteger("Texture"));
	}

}
