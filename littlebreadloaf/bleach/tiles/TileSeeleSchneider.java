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

	public ChunkCoordinates mainBlock = null;

	private boolean init = false;

	@Override
	public void updateEntity()
	{
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
				this.setMain(x);
				return;
			} else if (worldObj.getBlockId(xCoord - x, yCoord, zCoord) == BleachBlocks.seeleSchneiderBlock.blockID
					&& worldObj.getBlockId(xCoord, yCoord, zCoord - x) == BleachBlocks.seeleSchneiderBlock.blockID
					&& worldObj.getBlockId(xCoord - x, yCoord, zCoord - x) == BleachBlocks.seeleSchneiderBlock.blockID)
			{
				setBlockMain(xCoord - x, yCoord, zCoord);
				setBlockMain(xCoord, yCoord, zCoord - x);
				setBlockMain(xCoord - x, yCoord, zCoord - x);

				TileSeeleSchneider tile = (TileSeeleSchneider) worldObj.getBlockTileEntity(xCoord - x, yCoord, zCoord - x);
				tile.setMain(x);
				return;

			} else if (worldObj.getBlockId(xCoord - x, yCoord, zCoord) == BleachBlocks.seeleSchneiderBlock.blockID
					&& worldObj.getBlockId(xCoord, yCoord, zCoord + x) == BleachBlocks.seeleSchneiderBlock.blockID
					&& worldObj.getBlockId(xCoord - x, yCoord, zCoord + x) == BleachBlocks.seeleSchneiderBlock.blockID)
			{

				setBlockMain(xCoord - x, yCoord, zCoord);
				setBlockMain(xCoord, yCoord, zCoord + x);
				setBlockMain(xCoord - x, yCoord, zCoord + x);

				TileSeeleSchneider tile = (TileSeeleSchneider) worldObj.getBlockTileEntity(xCoord, yCoord, zCoord + x);
				tile.setMain(x);
				return;
			} else if (worldObj.getBlockId(xCoord + x, yCoord, zCoord) == BleachBlocks.seeleSchneiderBlock.blockID
					&& worldObj.getBlockId(xCoord, yCoord, zCoord - x) == BleachBlocks.seeleSchneiderBlock.blockID
					&& worldObj.getBlockId(xCoord + x, yCoord, zCoord - x) == BleachBlocks.seeleSchneiderBlock.blockID)
			{

				setBlockMain(xCoord + x, yCoord, zCoord);
				setBlockMain(xCoord, yCoord, zCoord - x);
				setBlockMain(xCoord + x, yCoord, zCoord - x);

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

	private void setBlockMain(int x, int y, int z)
	{
		TileSeeleSchneider tile = (TileSeeleSchneider) this.worldObj.getBlockTileEntity(x, y, z);
		tile.mainBlock = new ChunkCoordinates(this.xCoord, this.yCoord, this.zCoord);
	}

	/**
	 * Reads a tile entity from NBT.
	 */
	public void readFromNBT(NBTTagCompound nbt)
	{
		super.readFromNBT(nbt);
		this.isMain = nbt.getBoolean("isMain");
		this.side = nbt.getInteger("side");
	}

	/**
	 * Writes a tile entity to NBT.
	 */
	public void writeToNBT(NBTTagCompound nbt)
	{
		super.writeToNBT(nbt);

		nbt.setBoolean("isMain", this.isMain);
		nbt.setInteger("side", this.side);
	}
	
	public TileSeeleSchneider getMainBlockTile()
	{
		return (TileSeeleSchneider) this.worldObj.getBlockTileEntity(this.mainBlock.posX, this.mainBlock.posY, this.mainBlock.posZ);
	}
}
