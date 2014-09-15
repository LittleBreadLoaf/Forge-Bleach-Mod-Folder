package littlebreadloaf.bleach.entities;

import java.util.List;

import littlebreadloaf.bleach.api.Tools;
import littlebreadloaf.bleach.armor.Armor;
import littlebreadloaf.bleach.events.ExtendedPlayer;
import littlebreadloaf.bleach.items.BleachItems;
import littlebreadloaf.bleach.items.shikai.ShikaiEarth;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.S2BPacketChangeGameState;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityBlock extends Entity
{
	private int xTile = -1;
	private int yTile = -1;
	private int zTile = -1;
	private Block inTile;
	private int inData = 0;
	private boolean inGround = false;
	public int canBePickedUp = 0;
	public int arrowShake = 0;
	public Entity shootingEntity;
	private int ticksInGround;
	private int ticksInAir = 0;
	private double damage = 2.0;
	private int knockbackStrength;
	public int blockID;
	public EntityBlock(World par1World) 
	{
		super(par1World);
		this.setSize(1.0F, 1.0F);
	}

	public EntityBlock(World var1, EntityLivingBase var2, float var3, int id)
	{
		super(var1);
		this.renderDistanceWeight = 10.0D;
		this.shootingEntity = var2;
		this.ignoreFrustumCheck = true;
		this.blockID = id;
		this.setSize(1.0F, 1.0F);
		this.setLocationAndAngles(var2.posX, var2.posY + (double) var2.getEyeHeight(), var2.posZ, var2.rotationYaw, var2.rotationPitch);
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
		if(this.shootingEntity != null && this.shootingEntity instanceof EntityPlayer)
		{
			EntityPlayer player = ((EntityPlayer)this.shootingEntity);

			ExtendedPlayer props = ExtendedPlayer.get(player);
			if(player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() == BleachItems.shikaiearth)
			{
				if(props.getHasBlock())
				{

					Vec3 look = player.getLook(1.0F);
					this.posX = shootingEntity.posX + look.xCoord;
					this.posY = shootingEntity.posY + look.yCoord;
					this.posZ = shootingEntity.posZ + look.zCoord;
				}
				else
				{
					this.setDead();
				}
			}
			else
			{
				props.setHasBlock(false);
				this.setDead();
			}
		}
		else
		{
			this.setDead();
		}
	}
	
	@Override
	protected void entityInit() {}

	@Override
	protected void readEntityFromNBT(NBTTagCompound var1) 
	{
		this.blockID = var1.getInteger("BlockID");
		
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound var1) 
	{
		var1.setInteger("BlockID", this.blockID);
		
	}

}
