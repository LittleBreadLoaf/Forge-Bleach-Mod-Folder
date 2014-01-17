package littlebreadloaf.bleach.tiles;

import littlebreadloaf.bleach.BleachMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;

public class TileBleach extends TileEntity
{
	public boolean isUseableByPlayer(EntityPlayer player)
	{
		return this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord) == this
				&& player.getDistanceSq(this.xCoord + 0.5D, this.yCoord + 0.5D, this.zCoord + 0.5D) < 6;
	}

	@Override
	public void onDataPacket(INetworkManager net, Packet132TileEntityData pkt)
	{
		NBTTagCompound nbt = pkt.data;
		this.readFromNBT(nbt);
	}

	@Override
	public Packet getDescriptionPacket()
	{
		NBTTagCompound nbt = new NBTTagCompound();
		this.writeToNBT(nbt);
		return new Packet132TileEntityData(this.xCoord, this.yCoord, this.zCoord, 0, nbt);
	}

	@Override
	public void onInventoryChanged()
	{
		super.onInventoryChanged();

		if (!this.worldObj.isRemote)
		{
			BleachMod.proxy.sendToPlayers(this.getDescriptionPacket(), this.worldObj, this.xCoord, this.yCoord, this.zCoord, 64);
		}
	}
}
