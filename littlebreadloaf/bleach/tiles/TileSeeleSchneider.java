package littlebreadloaf.bleach.tiles;

import java.util.ArrayList;

import littlebreadloaf.bleach.blocks.BleachBlocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChunkCoordinates;

public class TileSeeleSchneider extends TileBleach
{

	boolean init = false;

	public boolean isMain = false;

	@Override
	public void updateEntity()
	{
		if (!init)
			init();

		// while perform check if still not broken
	}

	ArrayList<ChunkCoordinates> blocks = new ArrayList<ChunkCoordinates>();

	int xS = 0;
	int zS = 0;

	int side = 0;

	private void init()
	{
		init = true;

		if (!worldObj.isRemote)
		{
			for (int i = 1; i < 16; i++)
			{
				side = i;
				if (worldObj.getBlockId(xCoord + i, yCoord, zCoord) == BleachBlocks.seeleSchneiderBlock.blockID
						&& worldObj.getBlockId(xCoord, yCoord, zCoord + i) == BleachBlocks.seeleSchneiderBlock.blockID
						&& worldObj.getBlockId(xCoord + i, yCoord, zCoord + i) == BleachBlocks.seeleSchneiderBlock.blockID)
				{
					xS = 1;
					zS = 1;
					this.isMain = true;
					break;
				} else if (worldObj.getBlockId(xCoord - i, yCoord, zCoord) == BleachBlocks.seeleSchneiderBlock.blockID
						&& worldObj.getBlockId(xCoord, yCoord, zCoord + i) == BleachBlocks.seeleSchneiderBlock.blockID
						&& worldObj.getBlockId(xCoord - i, yCoord, zCoord + i) == BleachBlocks.seeleSchneiderBlock.blockID)
				{
					xS = -1;
					zS = 1;
					this.isMain = true;
					break;
				} else if (worldObj.getBlockId(xCoord + i, yCoord, zCoord) == BleachBlocks.seeleSchneiderBlock.blockID
						&& worldObj.getBlockId(xCoord, yCoord, zCoord - i) == BleachBlocks.seeleSchneiderBlock.blockID
						&& worldObj.getBlockId(xCoord + i, yCoord, zCoord - i) == BleachBlocks.seeleSchneiderBlock.blockID)
				{
					xS = 1;
					zS = -1;
					this.isMain = true;
					break;
				} else if (worldObj.getBlockId(xCoord - i, yCoord, zCoord) == BleachBlocks.seeleSchneiderBlock.blockID
						&& worldObj.getBlockId(xCoord, yCoord, zCoord - i) == BleachBlocks.seeleSchneiderBlock.blockID
						&& worldObj.getBlockId(xCoord - i, yCoord, zCoord - i) == BleachBlocks.seeleSchneiderBlock.blockID)
				{
					xS = -1;
					zS = -1;
					this.isMain = true;
					break;
				}
			}
		}
	}

	/**
	 * Reads a tile entity from NBT.
	 */
	public void readFromNBT(NBTTagCompound nbt)
	{
		super.readFromNBT(nbt);
		this.isMain = nbt.getBoolean("isMain");
	}

	/**
	 * Writes a tile entity to NBT.
	 */
	public void writeToNBT(NBTTagCompound nbt)
	{
		super.writeToNBT(nbt);

		nbt.setBoolean("isMain", this.isMain);
	}
}
