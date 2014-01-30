package littlebreadloaf.bleach.tiles;

import java.util.ArrayList;

import cpw.mods.fml.common.FMLLog;
import littlebreadloaf.bleach.blocks.BleachBlocks;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;

public class TileSeeleSchneider extends TileBleach
{

	public static ArrayList<ChunkCoordinates> magicSquare = new ArrayList<ChunkCoordinates>();

	public boolean isMain = false;
	public int side = -1;
	
	public int tick = 0;

	public ChunkCoordinates mainBlock = new ChunkCoordinates(xCoord, yCoord, zCoord);

	private boolean init = false;

	public float rotation = 0;
	public float alpha = 0;

	@Override
	public void updateEntity()
	{
		tick++;
		rotation += 2.5F;
		if(rotation >= 360) rotation -= 360;
		
		double radius = Math.sin(Math.toRadians(rotation*2))/4 + 1;
		alpha = 0.8F + (float) Math.sin(Math.toRadians(rotation*3))/8;
		
		if (!worldObj.isRemote)
		{
			if (!this.init)
			{
				this.checkForShape();
				this.init = true;
			}

			// if (this.isMain)
			// {
			// FMLLog.info("[Bleach mod] Main Seeleschneider, side: " +
			// this.side);
			// }
		}
	}

	/**
	 * 
	 * @return - true if found main
	 */
	public void checkForShape()
	{
		// FMLLog.info("[Bleach mod] init: " + shouldCheckOther);

		for (int x = 3; x <= 16; x++)
		{
			if (worldObj.getBlockId(xCoord + x, yCoord, zCoord) == BleachBlocks.seeleSchneiderBlock.blockID
					&& worldObj.getBlockId(xCoord, yCoord, zCoord + x) == BleachBlocks.seeleSchneiderBlock.blockID
					&& worldObj.getBlockId(xCoord + x, yCoord, zCoord + x) == BleachBlocks.seeleSchneiderBlock.blockID)
			{
				setBlockMain(xCoord + x, yCoord, zCoord, xCoord, yCoord, zCoord);
				setBlockMain(xCoord, yCoord, zCoord + x, xCoord, yCoord, zCoord);
				setBlockMain(xCoord + x, yCoord, zCoord + x, xCoord, yCoord, zCoord);
				
				this.setMain(x);
				return;
			} else if (worldObj.getBlockId(xCoord - x, yCoord, zCoord) == BleachBlocks.seeleSchneiderBlock.blockID
					&& worldObj.getBlockId(xCoord, yCoord, zCoord - x) == BleachBlocks.seeleSchneiderBlock.blockID
					&& worldObj.getBlockId(xCoord - x, yCoord, zCoord - x) == BleachBlocks.seeleSchneiderBlock.blockID)
			{
				setBlockMain(xCoord - x, yCoord, zCoord, xCoord - x, yCoord, zCoord - x);
				setBlockMain(xCoord, yCoord, zCoord - x, xCoord - x, yCoord, zCoord - x);
				setBlockMain(xCoord, yCoord, zCoord - x, xCoord - x, yCoord, zCoord - x);

				TileSeeleSchneider tile = (TileSeeleSchneider) worldObj.getBlockTileEntity(xCoord - x, yCoord, zCoord - x);
				tile.setMain(x);
				return;

			} else if (worldObj.getBlockId(xCoord - x, yCoord, zCoord) == BleachBlocks.seeleSchneiderBlock.blockID
					&& worldObj.getBlockId(xCoord, yCoord, zCoord + x) == BleachBlocks.seeleSchneiderBlock.blockID
					&& worldObj.getBlockId(xCoord - x, yCoord, zCoord + x) == BleachBlocks.seeleSchneiderBlock.blockID)
			{

				setBlockMain(xCoord - x, yCoord, zCoord, xCoord - x, yCoord, zCoord);
				setBlockMain(xCoord, yCoord, zCoord, xCoord - x, yCoord, zCoord);
				setBlockMain(xCoord - x, yCoord, zCoord + x, xCoord - x, yCoord, zCoord);

				TileSeeleSchneider tile = (TileSeeleSchneider) worldObj.getBlockTileEntity(xCoord - x, yCoord, zCoord);
				tile.setMain(x);
				return;
			} else if (worldObj.getBlockId(xCoord + x, yCoord, zCoord) == BleachBlocks.seeleSchneiderBlock.blockID
					&& worldObj.getBlockId(xCoord, yCoord, zCoord - x) == BleachBlocks.seeleSchneiderBlock.blockID
					&& worldObj.getBlockId(xCoord + x, yCoord, zCoord - x) == BleachBlocks.seeleSchneiderBlock.blockID)
			{

				setBlockMain(xCoord + x, yCoord, zCoord, xCoord, yCoord, zCoord - x);
				setBlockMain(xCoord, yCoord, zCoord, xCoord, yCoord, zCoord - x);
				setBlockMain(xCoord + x, yCoord, zCoord - x, xCoord, yCoord, zCoord - x);

				TileSeeleSchneider tile = (TileSeeleSchneider) worldObj.getBlockTileEntity(xCoord, yCoord, zCoord - x);
				tile.setMain(x);
				return;
			}
		}
	}

	public void setMain(int side)
	{
		this.isMain = true;
		this.side = side;
		magicSquare.add(new ChunkCoordinates(xCoord, yCoord, zCoord));
		FMLLog.info("[Bleach mod] Main Seeleschneider, side: " + side);
	}

	/**
	 * 
	 * @param x, y, z - the block we set the main block of
	 * @param i, j, k - the coords of its mainblock
	 */
	private void setBlockMain(int x, int y, int z, int i, int j, int k)
	{
		TileSeeleSchneider tile = (TileSeeleSchneider) this.worldObj.getBlockTileEntity(x, y, z);
		tile.mainBlock = new ChunkCoordinates(i, j, k);
	}

	/**
	 * Reads a tile entity from NBT.
	 */
	public void readFromNBT(NBTTagCompound nbt)
	{
		super.readFromNBT(nbt);
		this.isMain = nbt.getBoolean("isMain");
		this.side = nbt.getInteger("side");
		
		int x, y, z;
		x = nbt.getInteger("xMain");
		y = nbt.getInteger("yMain");
		z = nbt.getInteger("zMain");
		if(x != 0 && y != 0 && z != 0)
			this.mainBlock = new ChunkCoordinates(x, y, z);
		
	}

	/**
	 * Writes a tile entity to NBT.
	 */
	public void writeToNBT(NBTTagCompound nbt)
	{
		super.writeToNBT(nbt);

		nbt.setBoolean("isMain", this.isMain);
		nbt.setInteger("side", this.side);

	
		nbt.setInteger("xMain", this.mainBlock.posX);
		nbt.setInteger("yMain", this.mainBlock.posY);
		nbt.setInteger("zMain", this.mainBlock.posZ);
}
	
	public TileSeeleSchneider getMainBlockTile()
	{
		return (TileSeeleSchneider) this.worldObj.getBlockTileEntity(this.mainBlock.posX, this.mainBlock.posY, this.mainBlock.posZ);
	}
}
