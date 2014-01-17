package littlebreadloaf.bleach.entities;

import java.util.Random;

import littlebreadloaf.bleach.api.Tools;
import littlebreadloaf.bleach.items.BleachItems;
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

public class EntityWhole extends EntityMob
{
	private static Random rand = new Random();

	public EntityWhole(World par1)
	{
		this(par1, rand.nextInt(10));
	}

	public EntityWhole(World par1World, int par2)
	{
		super(par1World);
		this.setTexture(par2);
		float var3 = 0.38F;
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityHollowBat.class, 6.0F, 0.45F, 0.45F));
		this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityHollowBlaze.class, 6.0F, 0.45F, 0.45F));
		this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityHollowSpider.class, 6.0F, 0.45F, 0.45F));
		this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityHollowGolem.class, 6.0F, 0.45F, 0.45F));
		this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityHollowSnake.class, 6.0F, 0.45F, 0.45F));
		this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityHollowWasp.class, 6.0F, 0.45F, 0.45F));
		this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityHollowStalker.class, 6.0F, 0.45F, 0.45F));
		this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityHollowWolf.class, 6.0F, 0.45F, 0.45F));
		this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityHollowOre.class, 6.0F, 0.45F, 0.45F));
		this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityFisher.class, 6.0F, 0.45F, 0.45F));
		this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityMenosGrande.class, 6.0F, 0.45F, 0.45F));
		this.tasks.addTask(2, new EntityAIPanic(this, 0.5F));
		this.tasks.addTask(3, new EntityAITempt(this, 0.4F, BleachItems.zanpakuto.itemID, false));
		this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
		this.tasks.addTask(5, new EntityAILookIdle(this));
		this.tasks.addTask(6, new EntityAILookIdle(this));
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

		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(40.0D);

		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setAttribute(2.0D);

	}

	/**
	 * Drop 0-2 items of this living's type
	 */
	protected void dropFewItems(boolean var1, int var2)
	{
		this.entityDropItem(new ItemStack(BleachItems.reiatsu, 1), 0.0F);

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
	 * Called when a player interacts with a mob. e.g. gets milk from a cow,
	 * gets into the saddle on a pig.
	 */
	public boolean interact(EntityPlayer var1)
	{

		ItemStack var2 = var1.inventory.getCurrentItem();

		if (var2 != null && var2.itemID == BleachItems.zanpakuto.itemID)
		{
			if (!this.worldObj.isRemote)
			{
				int var3 = 4 + this.rand.nextInt(3);

				this.entityDropItem(new ItemStack(BleachItems.reiatsu, var3), 0.0F);

			}

			this.playSound("mob.endermen.portal", 1.0F, 1.0F);
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
	protected void fall(float var1)
	{
	}

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
	public void initCreature()
	{
	}

	public void onDeath(DamageSource par1DamageSource)
	{
		int randomHollow = rand.nextInt(12);

		EntityHollowBat par3 = new EntityHollowBat(worldObj);
		EntityHollowBlaze par4 = new EntityHollowBlaze(worldObj);
		EntityHollowSpider par5 = new EntityHollowSpider(worldObj);
		EntityHollowGolem par6 = new EntityHollowGolem(worldObj);
		EntityHollowSnake par7 = new EntityHollowSnake(worldObj);
		EntityHollowWasp par8 = new EntityHollowWasp(worldObj);
		EntityHollowStalker par9 = new EntityHollowStalker(worldObj);
		EntityHollowOre par10 = new EntityHollowOre(worldObj);
		EntityHollowWolf par11 = new EntityHollowWolf(worldObj);

		par3.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0F, 0.0F);
		par4.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0F, 0.0F);
		par5.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0F, 0.0F);
		par6.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0F, 0.0F);
		par7.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0F, 0.0F);
		par8.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0F, 0.0F);
		par9.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0F, 0.0F);
		par10.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0F, 0.0F);
		par11.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0F, 0.0F);

		if (par1DamageSource.getEntity() instanceof EntityHollowBat)
		{

			if (randomHollow == 2)
			{
				worldObj.spawnEntityInWorld(par4);
			} else if (randomHollow == 3)
			{
				worldObj.spawnEntityInWorld(par5);
			} else if (randomHollow == 4)
			{
				worldObj.spawnEntityInWorld(par6);
			} else if (randomHollow == 5)
			{
				worldObj.spawnEntityInWorld(par7);
			} else if (randomHollow == 6)
			{
				worldObj.spawnEntityInWorld(par8);
			} else if (randomHollow == 7)
			{
				worldObj.spawnEntityInWorld(par9);
			} else if (randomHollow == 8)
			{
				worldObj.spawnEntityInWorld(par10);
			} else if (randomHollow == 9)
			{
				worldObj.spawnEntityInWorld(par11);
			}

		}

		if (par1DamageSource.getEntity() instanceof EntityHollowBlaze)
		{
			if (randomHollow == 1)
			{
				worldObj.spawnEntityInWorld(par3);
			}

			else if (randomHollow == 3)
			{
				worldObj.spawnEntityInWorld(par5);
			} else if (randomHollow == 4)
			{
				worldObj.spawnEntityInWorld(par6);
			} else if (randomHollow == 5)
			{
				worldObj.spawnEntityInWorld(par7);
			} else if (randomHollow == 6)
			{
				worldObj.spawnEntityInWorld(par8);
			} else if (randomHollow == 7)
			{
				worldObj.spawnEntityInWorld(par9);
			} else if (randomHollow == 8)
			{
				worldObj.spawnEntityInWorld(par10);
			} else if (randomHollow == 9)
			{
				worldObj.spawnEntityInWorld(par11);
			}

		}

		if (par1DamageSource.getEntity() instanceof EntityHollowSpider)
		{
			if (randomHollow == 1)
			{
				worldObj.spawnEntityInWorld(par3);
			} else if (randomHollow == 2)
			{
				worldObj.spawnEntityInWorld(par4);
			}

			else if (randomHollow == 4)
			{
				worldObj.spawnEntityInWorld(par6);
			} else if (randomHollow == 5)
			{
				worldObj.spawnEntityInWorld(par7);
			} else if (randomHollow == 6)
			{
				worldObj.spawnEntityInWorld(par8);
			} else if (randomHollow == 7)
			{
				worldObj.spawnEntityInWorld(par9);
			} else if (randomHollow == 8)
			{
				worldObj.spawnEntityInWorld(par10);
			} else if (randomHollow == 9)
			{
				worldObj.spawnEntityInWorld(par11);
			}

		}

		if (par1DamageSource.getEntity() instanceof EntityHollowGolem)
		{
			if (randomHollow == 1)
			{
				worldObj.spawnEntityInWorld(par3);
			} else if (randomHollow == 2)
			{
				worldObj.spawnEntityInWorld(par4);
			} else if (randomHollow == 3)
			{
				worldObj.spawnEntityInWorld(par5);
			}

			else if (randomHollow == 5)
			{
				worldObj.spawnEntityInWorld(par7);
			} else if (randomHollow == 6)
			{
				worldObj.spawnEntityInWorld(par8);
			} else if (randomHollow == 7)
			{
				worldObj.spawnEntityInWorld(par9);
			} else if (randomHollow == 8)
			{
				worldObj.spawnEntityInWorld(par10);
			} else if (randomHollow == 9)
			{
				worldObj.spawnEntityInWorld(par11);
			}

		}

		if (par1DamageSource.getEntity() instanceof EntityHollowSnake)
		{
			if (randomHollow == 1)
			{
				worldObj.spawnEntityInWorld(par3);
			} else if (randomHollow == 2)
			{
				worldObj.spawnEntityInWorld(par4);
			} else if (randomHollow == 3)
			{
				worldObj.spawnEntityInWorld(par5);
			} else if (randomHollow == 4)
			{
				worldObj.spawnEntityInWorld(par6);
			} else if (randomHollow == 6)
			{
				worldObj.spawnEntityInWorld(par8);
			} else if (randomHollow == 7)
			{
				worldObj.spawnEntityInWorld(par9);
			} else if (randomHollow == 8)
			{
				worldObj.spawnEntityInWorld(par10);
			} else if (randomHollow == 9)
			{
				worldObj.spawnEntityInWorld(par11);
			}

		}
		if (par1DamageSource.getEntity() instanceof EntityHollowWasp)
		{
			if (randomHollow == 1)
			{
				worldObj.spawnEntityInWorld(par3);
			} else if (randomHollow == 2)
			{
				worldObj.spawnEntityInWorld(par4);
			} else if (randomHollow == 3)
			{
				worldObj.spawnEntityInWorld(par5);
			} else if (randomHollow == 4)
			{
				worldObj.spawnEntityInWorld(par6);
			} else if (randomHollow == 6)
			{
				worldObj.spawnEntityInWorld(par7);
			} else if (randomHollow == 7)
			{
				worldObj.spawnEntityInWorld(par9);
			} else if (randomHollow == 8)
			{
				worldObj.spawnEntityInWorld(par10);
			} else if (randomHollow == 9)
			{
				worldObj.spawnEntityInWorld(par11);
			}

		}
		if (par1DamageSource.getEntity() instanceof EntityHollowStalker)
		{
			if (randomHollow == 1)
			{
				worldObj.spawnEntityInWorld(par3);
			} else if (randomHollow == 2)
			{
				worldObj.spawnEntityInWorld(par4);
			} else if (randomHollow == 3)
			{
				worldObj.spawnEntityInWorld(par5);
			} else if (randomHollow == 4)
			{
				worldObj.spawnEntityInWorld(par6);
			} else if (randomHollow == 6)
			{
				worldObj.spawnEntityInWorld(par7);
			} else if (randomHollow == 7)
			{
				worldObj.spawnEntityInWorld(par8);
			} else if (randomHollow == 8)
			{
				worldObj.spawnEntityInWorld(par10);
			} else if (randomHollow == 9)
			{
				worldObj.spawnEntityInWorld(par11);
			}

		}

		if (par1DamageSource.getEntity() instanceof EntityHollowOre)
		{
			if (randomHollow == 1)
			{
				worldObj.spawnEntityInWorld(par3);
			} else if (randomHollow == 2)
			{
				worldObj.spawnEntityInWorld(par4);
			} else if (randomHollow == 3)
			{
				worldObj.spawnEntityInWorld(par5);
			} else if (randomHollow == 4)
			{
				worldObj.spawnEntityInWorld(par6);
			} else if (randomHollow == 6)
			{
				worldObj.spawnEntityInWorld(par7);
			} else if (randomHollow == 7)
			{
				worldObj.spawnEntityInWorld(par8);
			} else if (randomHollow == 8)
			{
				worldObj.spawnEntityInWorld(par9);
			} else if (randomHollow == 9)
			{
				worldObj.spawnEntityInWorld(par11);
			}

		}

		if (par1DamageSource.getEntity() instanceof EntityHollowWolf)
		{
			if (randomHollow == 1)
			{
				worldObj.spawnEntityInWorld(par3);
			} else if (randomHollow == 2)
			{
				worldObj.spawnEntityInWorld(par4);
			} else if (randomHollow == 3)
			{
				worldObj.spawnEntityInWorld(par5);
			} else if (randomHollow == 4)
			{
				worldObj.spawnEntityInWorld(par6);
			} else if (randomHollow == 6)
			{
				worldObj.spawnEntityInWorld(par7);
			} else if (randomHollow == 7)
			{
				worldObj.spawnEntityInWorld(par8);
			} else if (randomHollow == 8)
			{
				worldObj.spawnEntityInWorld(par9);
			} else if (randomHollow == 9)
			{
				worldObj.spawnEntityInWorld(par10);
			}

		}

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
