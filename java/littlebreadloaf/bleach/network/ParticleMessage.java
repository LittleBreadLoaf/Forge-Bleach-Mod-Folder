package littlebreadloaf.bleach.network;

import java.util.Random;

import littlebreadloaf.bleach.BleachMod;
import littlebreadloaf.bleach.events.ExtendedPlayer;
import littlebreadloaf.bleach.extras.ParticleEffects;
import io.netty.buffer.ByteBuf;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;

public class ParticleMessage implements IMessage
{
	private int id;
	private double posx, posy, posz;
	Random rand = new Random();
	
	
	public ParticleMessage(){}
	
	
	public ParticleMessage(int id, double x, double y, double z)
	{
		this.id = id;
		this.posx = x;
		this.posy = y;
		this.posz = z;
	}
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{


		id = buf.readInt();
		posx = buf.readDouble();
		posy = buf.readDouble();
		posz = buf.readDouble();
		
		
	}

	
	@Override
	public void toBytes(ByteBuf buf) 
	{

		buf.writeInt(id);
		buf.writeDouble(posx);
		buf.writeDouble(posy);
		buf.writeDouble(posz);
		
	}
	public static class Handler implements IMessageHandler<ParticleMessage, IMessage>
	{
		Random rand = new Random();
		@Override 
		public IMessage onMessage(ParticleMessage message, MessageContext ctx)
		{
		    EntityPlayer player = BleachMod.proxy.getPlayerFromMessage(ctx);
		    
			if(message.id == 0)
			{
				ParticleEffects.spawnParticle("tensho",  message.posx + rand.nextDouble(), message.posy + rand.nextDouble(), message.posz + rand.nextDouble(), 0.0, 0.0, 0.0);
			}
			if(message.id == 1)
			{
				ParticleEffects.spawnParticle("poison",  message.posx + rand.nextDouble() - rand.nextDouble(), message.posy + rand.nextDouble() - rand.nextDouble(), message.posz + rand.nextDouble() - rand.nextDouble(), 0.0, 0.0, 0.0);
			}
			if(message.id == 2)
			{
				Block block = player.worldObj.getBlock((int)player.posX, (int)player.posY-2, (int)player.posZ);
				if(block != Blocks.air)
				{
					player.worldObj.spawnParticle("blockcrack_" + Block.getIdFromBlock(block) + "_0", message.posx + rand.nextDouble(), message.posy + rand.nextDouble(), message.posz + rand.nextDouble(), 0.0, 0.002, 0.0);
					player.worldObj.spawnParticle("blockcrack_" + Block.getIdFromBlock(block) + "_0", message.posx + rand.nextDouble(), message.posy + rand.nextDouble(), message.posz + rand.nextDouble(), 0.0, 0.002, 0.0);
					player.worldObj.spawnParticle("blockcrack_" + Block.getIdFromBlock(block) + "_0", message.posx + rand.nextDouble(), message.posy + rand.nextDouble(), message.posz + rand.nextDouble(), 0.0, 0.002, 0.0);
				}
				else
				{
					player.worldObj.spawnParticle("blockcrack_" + Block.getIdFromBlock(Blocks.stone) + "_0", message.posx + rand.nextDouble(), message.posy + rand.nextDouble(), message.posz + rand.nextDouble(), 0.0, 0.002, 0.0);
					player.worldObj.spawnParticle("blockcrack_" + Block.getIdFromBlock(Blocks.stone) + "_0", message.posx + rand.nextDouble(), message.posy + rand.nextDouble(), message.posz + rand.nextDouble(), 0.0, 0.002, 0.0);
					player.worldObj.spawnParticle("blockcrack_" + Block.getIdFromBlock(Blocks.stone) + "_0", message.posx + rand.nextDouble(), message.posy + rand.nextDouble(), message.posz + rand.nextDouble(), 0.0, 0.002, 0.0);
			
				}
			
			}
			if(message.id == 3)
			{
				ParticleEffects.spawnParticle("wind",  message.posx, message.posy, message.posz, 0.0, 0.0, 0.0);
			}
			if(message.id == 4)
			{
				double d0 = this.rand.nextGaussian() * 0.02D;
				double d1 = this.rand.nextGaussian() * 0.02D;
				double d2 = this.rand.nextGaussian() * 0.02D;
				player.worldObj.spawnParticle("heart", message.posx + (double)(this.rand.nextFloat()  * 2.0F), message.posy + 0.5D + (double)(this.rand.nextFloat()), message.posz + (double)(this.rand.nextFloat() * 2.0F), d0, d1, d2);	
				
			}
			if(message.id == 5)
			{
				ParticleEffects.spawnParticle("spirit",  message.posx + rand.nextDouble(), message.posy + rand.nextDouble(), message.posz + rand.nextDouble(), 0.0, 0.0, 0.0);
				ParticleEffects.spawnParticle("spirit",  message.posx + rand.nextDouble(), message.posy + rand.nextDouble(), message.posz + rand.nextDouble(), 0.0, 0.0, 0.0);
				ParticleEffects.spawnParticle("spirit",  message.posx + rand.nextDouble(), message.posy + rand.nextDouble(), message.posz + rand.nextDouble(), 0.0, 0.0, 0.0);
			}
		
				return null;
		}
	}

}
