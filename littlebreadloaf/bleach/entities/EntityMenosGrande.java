package littlebreadloaf.bleach.entities;

import littlebreadloaf.bleach.api.Tools;
import littlebreadloaf.bleach.armor.Armor;
import littlebreadloaf.bleach.blocks.BleachBlocks;
import littlebreadloaf.bleach.events.ExtendedPlayer;
import littlebreadloaf.bleach.items.BleachItems;
import net.minecraft.block.Block;
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
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityMenosGrande extends EntityMob
{
	public int deathTicks = 0;

	private int ceroCooldown = 60*20;// a minute
	private int ceroCharging = 10*20;// 10 secs

	private EntityPlayer target = null;
	
	public EntityMenosGrande(World par1World)
	{
		super(par1World);
		this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityPlayer.class, 0.4D, false));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityWhole.class, 0.4D, false));
		this.tasks.addTask(3, new EntityAIAttackOnCollide(this, EntityShinigami.class, 0.4D, false));
		this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 0.4D));
		this.tasks.addTask(6, new EntityAIWander(this, 0.4D));
		this.tasks.addTask(7, new EntityAILookIdle(this));
		this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(9, new EntityAIWatchClosest(this, EntityWhole.class, 8.0F));
		this.targetTasks.addTask(0, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityWhole.class, 0, false));
		this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityShinigami.class, 0, false));
		this.isImmuneToFire = true;
		this.setSize(4F, 20.9F);
	}

	public float getEyeHeight()
	{
		return this.height - 1F;
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
			this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(170.0D);

			this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setAttribute(8.0D);
		} else
		{
			this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(150.0D);

			this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setAttribute(6.0D);
		}
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setAttribute(50);
		this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setAttribute(10);

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

		if (rand.nextInt(2) == 0)
		{
			return "lblbm.hollowscream";
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
			return "lblbm:hollowscream";
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
		return "lblbm:hollowscream";
	}

	/**
	 * Gets the pitch of living sounds in living entities.
	 */
	protected float getSoundPitch()
	{
		return super.getSoundPitch() * 0.8F;
	}

	/**
	 * Returns the volume for the sounds this mob makes.
	 */
	protected float getSoundVolume()
	{
		return 3.0F;
	}

	protected void dropFewItems(boolean par1, int par2)
	{
		super.dropFewItems(par1, par2);
		this.entityDropItem(new ItemStack(BleachItems.reiatsu, 5 + rand.nextInt(3) + par2), 0.0F);

		if (this.rand.nextInt(20 - par2) == 0)
		{
			this.dropItem(BleachItems.menosmask.itemID, 1);
		}

	}

	public void onLivingUpdate()
	{
		super.onLivingUpdate();
	}

	public int getMaxSpawnedInChunk()
	{
		return 16;
	}

	protected void fall(float var1)
	{
	}

	protected void updateAITasks()
	{
		super.updateAITasks();
		
//		if(this.ceroCooldown > 0)
//			this.ceroCooldown--;
//		else
//		{
//			if(this.target != null)
//			{
				if(this.ceroCharging > 0)
					this.ceroCharging--;
				else
				{
					//fire
					
					
					
					
//					this.ceroCooldown = 60 * 20;
					this.ceroCharging = 10 * 20;
				}
//			}
//		}
		
		
		
		int var1 = MathHelper.floor_double(this.posY);
		int var2 = MathHelper.floor_double(this.posX);
		int var3 = MathHelper.floor_double(this.posZ);
		boolean var18 = false;
		if(this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing"))
		{
		for (int var5 = -3; var5 <= 3; ++var5)
		{
			for (int var6 = -3; var6 <= 3; ++var6)
			{
				for (int var7 = 0; var7 <= 20; ++var7)
				{
					int var8 = var2 + var5;
					int var9 = var1 + var7;
					int var10 = var3 + var6;
					int var11 = this.worldObj.getBlockId(var8, var9, var10);
					int var12;

					if (var11 > 0 && var11 != Block.brick.blockID && var11 != Block.cobblestone.blockID && var11 != Block.bedrock.blockID
							&& var11 != Block.cobblestoneMossy.blockID && var11 != Block.netherrack.blockID && var11 != Block.netherBrick.blockID
							&& var11 != Block.obsidian.blockID && var11 != Block.sand.blockID && var11 != Block.stone.blockID && var11 != Block.stoneBrick.blockID
							&& var11 != Block.waterMoving.blockID && var11 != Block.waterStill.blockID && var11 != Block.dirt.blockID && var11 != BleachBlocks.reiatsuBlock.blockID
							&& var11 != BleachBlocks.soulQuartzBlock.blockID&& var11 != Block.lavaMoving.blockID && var11 != Block.lavaStill.blockID)// &&
																										// var11
																										// !=
																										// mod_Reiatsu.Seeles.blockID)
					{
						var12 = this.worldObj.getBlockMetadata(var8, var9, var10);
						this.worldObj.playAuxSFX(2001, var8, var9, var10, var11 + (var12 << 12));
						this.worldObj.setBlockToAir(var8, var9, var10);

					}

					if (var11 > 0 && var11 != Block.brick.blockID && var11 != Block.cobblestone.blockID && var11 != Block.bedrock.blockID
							&& var11 != Block.cobblestoneMossy.blockID && var11 != Block.netherBrick.blockID && var11 != Block.obsidian.blockID && var11 != Block.sand.blockID
							&& var11 != Block.stone.blockID && var11 != Block.stoneBrick.blockID && var11 != Block.waterMoving.blockID && var11 != Block.waterStill.blockID
							&& var11 != Block.dirt.blockID && var11 != BleachBlocks.reiatsuBlock.blockID && var11 != Block.lavaMoving.blockID && var11 != Block.lavaStill.blockID
							&& var11 != BleachBlocks.soulQuartzBlock.blockID&& this.rand.nextInt(250) == 0)
					{
						var12 = this.worldObj.getBlockMetadata(var8, var9, var10);
						this.worldObj.playAuxSFX(2001, var8, var9, var10, var11 + (var12 << 12));
						this.worldObj.setBlockToAir(var8, var9, var10);

					}

					if (var11 > 0 && var11 != Block.bedrock.blockID && var11 != Block.obsidian.blockID && var11 != Block.waterMoving.blockID && var11 != Block.waterStill.blockID
							&& var11 != BleachBlocks.reiatsuBlock.blockID && var11 != Block.lavaMoving.blockID && var11 != Block.lavaStill.blockID && var11 != BleachBlocks.soulQuartzBlock.blockID)
					{
						if (this.rand.nextInt(2000) == 0)
						{
							var12 = this.worldObj.getBlockMetadata(var8, var9, var10);
							this.worldObj.playAuxSFX(2001, var8, var9, var10, var11 + (var12 << 12));
							this.worldObj.setBlockToAir(var8, var9, var10);

						}

						if (var11 > 0 && var11 != Block.bedrock.blockID && var11 != Block.waterMoving.blockID && var11 != Block.waterStill.blockID
								&& var11 != Block.lavaMoving.blockID && var11 != Block.lavaStill.blockID && this.rand.nextInt(7000) == 0)
						{
							var12 = this.worldObj.getBlockMetadata(var8, var9, var10);
							this.worldObj.playAuxSFX(2001, var8, var9, var10, var11 + (var12 << 12));
							this.worldObj.setBlockToAir(var8, var9, var10);

						}
					}
				}
			}
		}
		}

	}

	/**
	 * handles entity death timer, experience orb and particle creation
	 */
	protected void onDeathUpdate()
	{
		++this.deathTicks;
		int var1 = MathHelper.floor_double(this.posY);
		int var2 = MathHelper.floor_double(this.posX);
		int var3 = MathHelper.floor_double(this.posZ);
		int var4;
		int var5;

		if (this.deathTicks <= 200)
		{
			for (var4 = -3; var4 <= 3; ++var4)
			{
				for (var5 = -3; var5 <= 3; ++var5)
				{
					for (int var6 = -1; var6 <= 20; ++var6)
					{
						if (this.rand.nextInt(1500) == 0)
						{
							int var7 = var2 + var4;
							int var8 = var1 + var6;
							int var9 = var3 + var5;
							this.worldObj.spawnParticle("largeexplode", (double) var7, (double) var8, (double) var9, 0.0D, 0.0D, 0.0D);
						}
					}
				}
			}
		}

		if (!this.worldObj.isRemote)
		{
			if (this.deathTicks > 150 && this.deathTicks % 5 == 0)
			{
				var4 = 10;

				while (var4 > 0)
				{
					var5 = EntityXPOrb.getXPSplit(var4);
					var4 -= var5;
					this.worldObj.spawnEntityInWorld(new EntityXPOrb(this.worldObj, this.posX, this.posY, this.posZ, var5));
				}
			}

			if (this.deathTicks == 1)
			{
				this.worldObj.func_82739_e(1018, (int) this.posX, (int) this.posY, (int) this.posZ, 0);
			}
		}

		if (this.deathTicks == 200 && !this.worldObj.isRemote)
		{
			var4 = 10;

			while (var4 > 0)
			{
				var5 = EntityXPOrb.getXPSplit(var4);
				var4 -= var5;
				this.worldObj.spawnEntityInWorld(new EntityXPOrb(this.worldObj, this.posX, this.posY, this.posZ, var5));
			}

			this.setDead();
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
					&& this.attackingPlayer.inventory.getCurrentItem().itemID == BleachItems.zanpakuto.itemID && props.getZTotal() < 376)
			{
				for (int i = 0; i < 25; i++)
				{
					props.addPoints(rand.nextInt(8) + 1, 1);
				}
			}
			
				  	if(rand.nextInt(50) == 0) 
				  	{ 
				  		int var2 = BleachItems.recordNumberOne.itemID; 
				  		this.dropItem(var2, 1); 
				  }
		  
			  

		}
	}
	

	public int getChargingProgress()
	{
		return this.ceroCharging;
	}
	
	
	 /**
     * Checks if the entity's current position is a valid location to spawn this entity.
     */
    public boolean getCanSpawnHere()
    {
        return this.posY < 50 && this.worldObj.difficultySetting > 0 && this.isValidLightLevel() && 
        		this.worldObj.checkNoEntityCollision(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox);
    }

}
