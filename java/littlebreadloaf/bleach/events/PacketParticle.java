package littlebreadloaf.bleach.events;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

import java.util.Random;

import littlebreadloaf.bleach.extras.ParticleEffects;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;

public class PacketParticle extends BleachAbstractPacket
{
	private int id;
	private int posx, posy, posz;
	Random rand = new Random();
	
	public PacketParticle(){}
	
	public PacketParticle(int id, int x, int y, int z)
	{
		this.id = id;
		this.posx = x;
		this.posy = y;
		this.posz = z;
	}

	@Override
	public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer) 
	{
		buffer.writeInt(id);
		buffer.writeInt(posx);
		buffer.writeInt(posy);
		buffer.writeInt(posz);
		
		
	}

	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer) 
	{
		id = buffer.readInt();
		posx = buffer.readInt();
		posy = buffer.readInt();
		posz = buffer.readInt();
		
	}

	@Override
	public void handleClientSide(EntityPlayer player) 
	{
		if(id == 0)
		{
			ParticleEffects.spawnParticle("tensho",  posx + rand.nextDouble(), posy + rand.nextDouble(), posz + rand.nextDouble(), 0.0, 0.0, 0.0);
		}
		if(id == 1)
		{
			ParticleEffects.spawnParticle("poison",  posx + rand.nextDouble() - rand.nextDouble(), posy + rand.nextDouble() - rand.nextDouble(), posz + rand.nextDouble() - rand.nextDouble(), 0.0, 0.0, 0.0);
		}
		if(id == 2)
		{
			Block block = player.worldObj.getBlock((int)player.posX, (int)player.posY-2, (int)player.posZ);
			if(block != Blocks.air)
			{
				player.worldObj.spawnParticle("blockcrack_" + Block.getIdFromBlock(block) + "_0", posx + rand.nextDouble(), posy + rand.nextDouble(), posz + rand.nextDouble(), 0.0, 0.002, 0.0);
				player.worldObj.spawnParticle("blockcrack_" + Block.getIdFromBlock(block) + "_0", posx + rand.nextDouble(), posy + rand.nextDouble(), posz + rand.nextDouble(), 0.0, 0.002, 0.0);
				player.worldObj.spawnParticle("blockcrack_" + Block.getIdFromBlock(block) + "_0", posx + rand.nextDouble(), posy + rand.nextDouble(), posz + rand.nextDouble(), 0.0, 0.002, 0.0);
			}
			else
			{
				player.worldObj.spawnParticle("blockcrack_" + Block.getIdFromBlock(Blocks.stone) + "_0", posx + rand.nextDouble(), posy + rand.nextDouble(), posz + rand.nextDouble(), 0.0, 0.002, 0.0);
				player.worldObj.spawnParticle("blockcrack_" + Block.getIdFromBlock(Blocks.stone) + "_0", posx + rand.nextDouble(), posy + rand.nextDouble(), posz + rand.nextDouble(), 0.0, 0.002, 0.0);
				player.worldObj.spawnParticle("blockcrack_" + Block.getIdFromBlock(Blocks.stone) + "_0", posx + rand.nextDouble(), posy + rand.nextDouble(), posz + rand.nextDouble(), 0.0, 0.002, 0.0);
		
			}
		
		}
		if(id == 3)
		{
			ParticleEffects.spawnParticle("wind",  posx, posy, posz, 0.0, 0.0, 0.0);
		}
		if(id == 4)
		{
			double d0 = this.rand.nextGaussian() * 0.02D;
			double d1 = this.rand.nextGaussian() * 0.02D;
			double d2 = this.rand.nextGaussian() * 0.02D;
			player.worldObj.spawnParticle("heart", posx + (double)(this.rand.nextFloat()  * 2.0F), posy + 0.5D + (double)(this.rand.nextFloat()), posz + (double)(this.rand.nextFloat() * 2.0F), d0, d1, d2);	
			
		}
	}

	@Override
	public void handleServerSide(EntityPlayer player) 
	{
		
	}
}