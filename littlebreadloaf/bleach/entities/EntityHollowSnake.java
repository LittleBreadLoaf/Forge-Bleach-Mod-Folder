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
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityHollowSnake extends EntityMob
{
	private static Random rand = new Random();

	public EntityHollowSnake(World par1)
	{
		this(par1, rand.nextInt(3));
	}

	public EntityHollowSnake(World par1World, int par2)
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
		this.setSize(1.5F, 3.1F);

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
			this.dropItem(Armor.SnakeHelmet.itemID, 1);
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

	public boolean attackEntityAsMob(Entity par1Entity)
	{
		if (super.attackEntityAsMob(par1Entity))
		{
			if (par1Entity instanceof EntityLivingBase)
			{
				byte b0 = 0;

				if (this.worldObj.difficultySetting > 1)
				{
					if (this.worldObj.difficultySetting == 2)
					{
						b0 = 7;
					} else if (this.worldObj.difficultySetting == 3)
					{
						b0 = 15;
					}
				}

				if (b0 > 0)
				{
					((EntityLivingBase) par1Entity).addPotionEffect(new PotionEffect(Potion.poison.id, b0 * 20, 0));
				}
			}

			return true;
		} else
		{
			return false;
		}
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
				props.addPoints(4, 4);
				props.addPoints(8, 3);
				props.addPoints(3, -2);
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
