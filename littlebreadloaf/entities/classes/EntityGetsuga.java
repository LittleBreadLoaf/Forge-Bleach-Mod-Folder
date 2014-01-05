package littlebreadloaf.entities.classes;

import java.util.List;

import littlebreadloaf.blocks.Blocks;
import littlebreadloaf.items.Items;
import littlebreadloaf.libraries.Tools;

import net.minecraft.block.Block;
import net.minecraft.enchantment.EnchantmentThorns;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet70GameEvent;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityGetsuga extends Entity implements IProjectile
{
	private int xTile = -1;
	private int yTile = -1;
	private int zTile = -1;
	private int inTile = 0;
	private int inData = 0;
	private boolean inGround = false;
	public int canBePickedUp = 0;
	public int arrowShake = 0;
	public Entity shootingEntity;
	private int ticksInGround;
	private int ticksInAir = 0;
	private double damage = 5;
	private int knockbackStrength;

	public EntityGetsuga(World var1)
	{
		super(var1);
		this.renderDistanceWeight = 10.0D;
		this.setSize(0.5F, 0.5F);
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

	public EntityGetsuga(World var1, double var2, double var4, double var6)
	{
		super(var1);
		this.renderDistanceWeight = 10.0D;
		this.setSize(0.5F, 0.5F);
		this.setPosition(var2, var4, var6);
		this.yOffset = 0.0F;
	}

	public EntityGetsuga(World var1, EntityLiving var2, EntityLiving var3, float var4, float var5)
	{
		super(var1);
		this.renderDistanceWeight = 10.0D;
		this.shootingEntity = var2;

		this.posY = var2.posY + (double) var2.getEyeHeight() - 0.10000000149011612D;
		double var6 = var3.posX - var2.posX;
		double var8 = var3.posY + (double) var3.getEyeHeight() - 0.699999988079071D - this.posY;
		double var10 = var3.posZ - var2.posZ;
		double var12 = (double) MathHelper.sqrt_double(var6 * var6 + var10 * var10);

		if (var12 >= 1.0E-7D)
		{
			float var14 = (float) (Math.atan2(var10, var6) * 180.0D / Math.PI) - 90.0F;
			float var15 = (float) (-(Math.atan2(var8, var12) * 180.0D / Math.PI));
			double var16 = var6 / var12;
			double var18 = var10 / var12;
			this.setLocationAndAngles(var2.posX + var16, this.posY, var2.posZ + var18, var14, var15);
			this.yOffset = 0.0F;
			float var20 = (float) var12 * 0.2F;
			this.setThrowableHeading(var6, var8 + (double) var20, var10, var4, var5);
		}
	}

	public EntityGetsuga(World var1, EntityLivingBase var32, float var3)
	{
		super(var1);
		this.renderDistanceWeight = 10.0D;
		this.shootingEntity = var32;

		this.setSize(0.5F, 0.5F);
		this.setLocationAndAngles(var32.posX, var32.posY + (double) var32.getEyeHeight(), var32.posZ, var32.rotationYaw, var32.rotationPitch);
		this.posX -= (double) (MathHelper.cos(this.rotationYaw / 180.0F * (float) Math.PI) * 0.16F);
		this.posY -= 0.10000000149011612D;
		this.posZ -= (double) (MathHelper.sin(this.rotationYaw / 180.0F * (float) Math.PI) * 0.16F);
		this.setPosition(this.posX, this.posY, this.posZ);
		this.yOffset = 0.0F;
		this.motionX = (double) (-MathHelper.sin(this.rotationYaw / 180.0F * (float) Math.PI) * MathHelper.cos(this.rotationPitch / 180.0F * (float) Math.PI));
		this.motionZ = (double) (MathHelper.cos(this.rotationYaw / 180.0F * (float) Math.PI) * MathHelper.cos(this.rotationPitch / 180.0F * (float) Math.PI));
		this.motionY = (double) (-MathHelper.sin(this.rotationPitch / 180.0F * (float) Math.PI));
		this.setThrowableHeading(this.motionX, this.motionY, this.motionZ, var3 * 1.5F, 1.0F);
	}

	protected void entityInit()
	{
		this.dataWatcher.addObject(16, Byte.valueOf((byte) 0));
	}

	/**
	 * Similar to setArrowHeading, it's point the throwable entity to a x, y, z
	 * direction.
	 */
	public void setThrowableHeading(double var1, double var3, double var5, float var7, float var8)
	{
		float var9 = MathHelper.sqrt_double(var1 * var1 + var3 * var3 + var5 * var5);
		var1 /= (double) var9;
		var3 /= (double) var9;
		var5 /= (double) var9;
		var1 += this.rand.nextGaussian() * 0.007499999832361937D * (double) var8;
		var3 += this.rand.nextGaussian() * 0.007499999832361937D * (double) var8;
		var5 += this.rand.nextGaussian() * 0.007499999832361937D * (double) var8;
		var1 *= (double) var7;
		var3 *= (double) var7;
		var5 *= (double) var7;
		this.motionX = var1;
		this.motionY = var3;
		this.motionZ = var5;
		float var10 = MathHelper.sqrt_double(var1 * var1 + var5 * var5);
		this.prevRotationYaw = this.rotationYaw = (float) (Math.atan2(var1, var5) * 180.0D / Math.PI);
		this.prevRotationPitch = this.rotationPitch = (float) (Math.atan2(var3, (double) var10) * 180.0D / Math.PI);
		this.ticksInGround = 0;
	}

	/**
	 * Sets the position and rotation. Only difference from the other one is no
	 * bounding on the rotation. Args: posX, posY, posZ, yaw, pitch
	 */
	public void setPositionAndRotation2(double var1, double var3, double var5, float var7, float var8, int var9)
	{
		this.setPosition(var1, var3, var5);
		this.setRotation(var7, var8);
	}

	/**
	 * Sets the velocity to the args. Args: x, y, z
	 */
	public void setVelocity(double var1, double var3, double var5)
	{
		this.motionX = var1;
		this.motionY = var3;
		this.motionZ = var5;

		if (this.prevRotationPitch == 0.0F && this.prevRotationYaw == 0.0F)
		{
			float var7 = MathHelper.sqrt_double(var1 * var1 + var5 * var5);
			this.prevRotationYaw = this.rotationYaw = (float) (Math.atan2(var1, var5) * 180.0D / Math.PI);
			this.prevRotationPitch = this.rotationPitch = (float) (Math.atan2(var3, (double) var7) * 180.0D / Math.PI);
			this.prevRotationPitch = this.rotationPitch;
			this.prevRotationYaw = this.rotationYaw;
			this.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
			this.ticksInGround = 0;
		}
	}

	/**
	 * Called to update the entity's position/logic.
	 */
	public void onUpdate()
	{
		super.onUpdate();
		int ar1 = MathHelper.floor_double(this.posY);
		int ar2 = MathHelper.floor_double(this.posX);
		int ar3 = MathHelper.floor_double(this.posZ);

		for (int ar5 = -1; ar5 <= 0; ++ar5)
		{
			for (int ar6 = -1; ar6 <= 0; ++ar6)
			{
				for (int ar7 = -2; ar7 <= 0; ++ar7)
				{
					int ar8 = ar2 + ar5;
					int ar9 = ar1 + ar7;
					int ar10 = ar3 + ar6;
					int ar11 = this.worldObj.getBlockId(ar8, ar9, ar10);
					int ar12;

					if (ar11 > 0 && ar11 != Block.bedrock.blockID && ar11 != Block.obsidian.blockID && ar11 != Block.portal.blockID && ar11 != Blocks.reiatsuBlock.blockID)
					{
						if (this.ticksInAir > 3)
						{
							ar12 = this.worldObj.getBlockMetadata(ar8, ar9, ar10);
							this.worldObj.setBlockToAir(ar8, ar9, ar10);
						}

					}

				}
			}
		}

		float velocityy = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);

		if (velocityy < 1.4)
		{
			this.setDead();
		}

		if (this.prevRotationPitch == 0.0F && this.prevRotationYaw == 0.0F)
		{
			float var1 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
			this.prevRotationYaw = this.rotationYaw = (float) (Math.atan2(this.motionX, this.motionZ) * 180.0D / Math.PI);
			this.prevRotationPitch = this.rotationPitch = (float) (Math.atan2(this.motionY, (double) var1) * 180.0D / Math.PI);
		}

		int var16 = this.worldObj.getBlockId(this.xTile, this.yTile, this.zTile);

		if (var16 > 0)
		{
			Block.blocksList[var16].setBlockBoundsBasedOnState(this.worldObj, this.xTile, this.yTile, this.zTile);
			AxisAlignedBB var2 = Block.blocksList[var16].getCollisionBoundingBoxFromPool(this.worldObj, this.xTile, this.yTile, this.zTile);

			if (var2 != null && var2.isVecInside(this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX, this.posY, this.posZ)))
			{
				this.inGround = true;
			}
		}

		if (this.arrowShake > 0)
		{
			--this.arrowShake;
		}

		if (this.inGround)
		{
			int var17 = this.worldObj.getBlockId(this.xTile, this.yTile, this.zTile);
			int var3 = this.worldObj.getBlockMetadata(this.xTile, this.yTile, this.zTile);

			if (var17 == this.inTile && var3 == this.inData)
			{
				++this.ticksInGround;

				if (this.ticksInGround == 2)
				{

					this.setDead();
				}
			} else
			{
				this.inGround = false;
				this.motionX *= (double) (this.rand.nextFloat() * 0.2F);
				this.motionY *= (double) (this.rand.nextFloat() * 0.2F);
				this.motionZ *= (double) (this.rand.nextFloat() * 0.2F);
				this.ticksInGround = 0;
				this.ticksInAir = 0;
			}
		} else
		{
			++this.ticksInAir;
			Vec3 var18 = this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX, this.posY, this.posZ);
			Vec3 var19 = this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
			MovingObjectPosition var4 = this.worldObj.rayTraceBlocks_do_do(var18, var19, false, true);
			var18 = this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX, this.posY, this.posZ);
			var19 = this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);

			if (var4 != null)
			{
				var19 = this.worldObj.getWorldVec3Pool().getVecFromPool(var4.hitVec.xCoord, var4.hitVec.yCoord, var4.hitVec.zCoord);
			}

			if (this.ticksInAir == 40)
			{
				this.setDead();
			}

			Entity var5 = null;
			List var6 = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.addCoord(this.motionX, this.motionY, this.motionZ).expand(1.0D, 1.0D, 1.0D));
			double var7 = 0.0D;
			int var9;
			float var10;

			for (var9 = 0; var9 < var6.size(); ++var9)
			{
				Entity var11 = (Entity) var6.get(var9);

				if (var11.canBeCollidedWith() && (var11 != this.shootingEntity || this.ticksInAir >= 5))
				{
					var10 = 0.3F;
					AxisAlignedBB var12 = var11.boundingBox.expand((double) var10, (double) var10, (double) var10);
					MovingObjectPosition var13 = var12.calculateIntercept(var18, var19);

					if (var13 != null)
					{
						double var14 = var18.distanceTo(var13.hitVec);

						if (var14 < var7 || var7 == 0.0D)
						{
							var5 = var11;
							var7 = var14;
						}
					}
				}
			}

			if (var5 != null)
			{
				var4 = new MovingObjectPosition(var5);
			}

			float var21;
			float var20;

			if (var4 != null)
			{

				worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 1, true);
				if (var4.entityHit != null)
				{
					if (var4.entityHit instanceof EntityLiving)
					{
						if (((EntityLiving) var4.entityHit).getCreatureAttribute() == Tools.SPIRIT)
						{
							damage = 12;
						}

					}

					this.ticksInAir = 195;

					var20 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
					int var22 = MathHelper.ceiling_double_int((double) var20 * this.damage);

					if (this.getIsCritical())
					{
						var22 += this.rand.nextInt(var22 / 2 + 2);
					}

					DamageSource var23 = null;

					if (this.shootingEntity == null)
					{
						var23 = DamageSource.causeThrownDamage(this, this);
					} else
					{
						var23 = DamageSource.causeThrownDamage(this, this.shootingEntity);
					}

					if (this.isBurning() && !(var4.entityHit instanceof EntityEnderman))
					{
						var4.entityHit.setFire(5);
					}

					if (var4.entityHit.attackEntityFrom(var23, var22))
					{
						if (var4.entityHit instanceof EntityLiving)
						{
							EntityLiving var15 = (EntityLiving) var4.entityHit;

							if (!this.worldObj.isRemote)
							{
								var15.setArrowCountInEntity(var15.getArrowCountInEntity() + 1);
							}

							if (this.knockbackStrength > 0)
							{
								var21 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);

								if (var21 > 0.0F)
								{
									var4.entityHit.addVelocity(this.motionX * (double) this.knockbackStrength * 0.6000000238418579D / (double) var21, 0.1D, this.motionZ
											* (double) this.knockbackStrength * 0.6000000238418579D / (double) var21);
								}
							}

							EnchantmentThorns.func_92096_a(this.shootingEntity, var15, this.rand);

							if (this.shootingEntity != null && var4.entityHit != this.shootingEntity && var4.entityHit instanceof EntityPlayer
									&& this.shootingEntity instanceof EntityPlayerMP)
							{
								((EntityPlayerMP) this.shootingEntity).playerNetServerHandler.sendPacketToPlayer(new Packet70GameEvent(6, 0));
							}
						}

						this.playSound("random.bowhit", 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));

						if (!(var4.entityHit instanceof EntityEnderman))
						{
							this.setDead();
						}
					} else
					{
						this.motionX *= -0.10000000149011612D;
						this.motionY *= -0.10000000149011612D;
						this.motionZ *= -0.10000000149011612D;
						this.rotationYaw += 180.0F;
						this.prevRotationYaw += 180.0F;
						this.ticksInAir = 0;
					}
					this.setDead();
				} else
				{
					this.xTile = var4.blockX;
					this.yTile = var4.blockY;
					this.zTile = var4.blockZ;
					this.inTile = this.worldObj.getBlockId(this.xTile, this.yTile, this.zTile);
					this.inData = this.worldObj.getBlockMetadata(this.xTile, this.yTile, this.zTile);
					this.motionX = (double) ((float) (var4.hitVec.xCoord - this.posX));
					this.motionY = (double) ((float) (var4.hitVec.yCoord - this.posY));
					this.motionZ = (double) ((float) (var4.hitVec.zCoord - this.posZ));
					var20 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
					this.posX -= this.motionX / (double) var20 * 0.05000000074505806D;
					this.posY -= this.motionY / (double) var20 * 0.05000000074505806D;
					this.posZ -= this.motionZ / (double) var20 * 0.05000000074505806D;
					this.playSound("random.bowhit", 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
					this.inGround = true;
					this.arrowShake = 7;
					this.setIsCritical(false);

					if (this.inTile != 0)
					{
						Block.blocksList[this.inTile].onEntityCollidedWithBlock(this.worldObj, this.xTile, this.yTile, this.zTile, this);
					}
				}
			}

			this.posX += this.motionX;
			this.posY += this.motionY;
			this.posZ += this.motionZ;
			var20 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
			this.rotationYaw = (float) (Math.atan2(this.motionX, this.motionZ) * 180.0D / Math.PI);

			for (this.rotationPitch = (float) (Math.atan2(this.motionY, (double) var20) * 180.0D / Math.PI); this.rotationPitch - this.prevRotationPitch < -180.0F; this.prevRotationPitch -=
					360.0F)
			{
				;
			}

			while (this.rotationPitch - this.prevRotationPitch >= 180.0F)
			{
				this.prevRotationPitch += 360.0F;
			}

			while (this.rotationYaw - this.prevRotationYaw < -180.0F)
			{
				this.prevRotationYaw -= 360.0F;
			}

			while (this.rotationYaw - this.prevRotationYaw >= 180.0F)
			{
				this.prevRotationYaw += 360.0F;
			}

			this.rotationPitch = this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * 0.2F;
			this.rotationYaw = this.prevRotationYaw + (this.rotationYaw - this.prevRotationYaw) * 0.2F;
			float var24 = 0.99F;
			var10 = 0.05F;

			if (this.isInWater())
			{
				for (int var25 = 0; var25 < 4; ++var25)
				{
					var21 = 0.25F;
				}

				var24 = 0.8F;
			}

			this.motionX *= (double) var24;
			this.motionZ *= (double) var24;
			this.setPosition(this.posX, this.posY, this.posZ);
			this.doBlockCollisions();
		}
	}

	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	public void writeEntityToNBT(NBTTagCompound var1)
	{
		var1.setShort("xTile", (short) this.xTile);
		var1.setShort("yTile", (short) this.yTile);
		var1.setShort("zTile", (short) this.zTile);
		var1.setByte("inTile", (byte) this.inTile);
		var1.setByte("inData", (byte) this.inData);
		var1.setByte("shake", (byte) this.arrowShake);
		var1.setByte("inGround", (byte) (this.inGround ? 1 : 0));
		var1.setByte("pickup", (byte) this.canBePickedUp);
		var1.setDouble("damage", this.damage);
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	public void readEntityFromNBT(NBTTagCompound var1)
	{
		this.xTile = var1.getShort("xTile");
		this.yTile = var1.getShort("yTile");
		this.zTile = var1.getShort("zTile");
		this.inTile = var1.getByte("inTile") & 255;
		this.inData = var1.getByte("inData") & 255;
		this.arrowShake = var1.getByte("shake") & 255;
		this.inGround = var1.getByte("inGround") == 1;

		if (var1.hasKey("damage"))
		{
			this.damage = var1.getDouble("damage");
		}

		if (var1.hasKey("pickup"))
		{
			this.canBePickedUp = var1.getByte("pickup");
		} else if (var1.hasKey("player"))
		{
			this.canBePickedUp = var1.getBoolean("player") ? 1 : 0;
		}
	}

	/**
	 * Called by a player entity when they collide with an entity
	 */
	public void onCollideWithPlayer(EntityPlayer var1)
	{
		if (!this.worldObj.isRemote && this.inGround && this.arrowShake <= 0)
		{
			boolean var2 = this.canBePickedUp == 1 || this.canBePickedUp == 2 && var1.capabilities.isCreativeMode;

			if (this.canBePickedUp == 1 && !var1.inventory.addItemStackToInventory(new ItemStack(Items.reiatsu, 1)))
			{
				var2 = false;
			}

			if (var2)
			{
				this.playSound("random.pop", 0.2F, ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.7F + 1.0F) * 2.0F);
				var1.onItemPickup(this, 1);
				this.setDead();
			}
		}
	}

	/**
	 * returns if this entity triggers Block.onEntityWalking on the blocks they
	 * walk on. used for spiders and wolves to prevent them from trampling crops
	 */
	protected boolean canTriggerWalking()
	{
		return false;
	}

	public float getShadowSize()
	{
		return 0.0F;
	}

	public void setDamage(double var1)
	{
		this.damage = var1;
	}

	public double getDamage()
	{
		return this.damage;
	}

	public void setKnockbackStrength(int var1)
	{
		this.knockbackStrength = var1;
	}

	/**
	 * If returns false, the item will not inflict any damage against entities.
	 */
	public boolean canAttackWithItem()
	{
		return false;
	}

	public void setIsCritical(boolean var1)
	{
		byte var2 = this.dataWatcher.getWatchableObjectByte(16);

		if (var1)
		{
			this.dataWatcher.updateObject(16, Byte.valueOf((byte) (var2 | 1)));
		} else
		{
			this.dataWatcher.updateObject(16, Byte.valueOf((byte) (var2 & -2)));
		}
	}

	public boolean getIsCritical()
	{
		byte var1 = this.dataWatcher.getWatchableObjectByte(16);
		return (var1 & 1) != 0;
	}
}
