package littlebreadloaf.tiles;

import littlebreadloaf.events.ExtendedPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

public class TileSphereLamp extends TileBleach
{
	private String owner;

	byte tick = 0;
	
	public ExtendedPlayer props = null;
			
	@Override
	public void updateEntity()
	{

		tick++;
		if(tick>20) tick -= 20;
		
		if(this.getOwnerEntity() != null)
			this.props = (ExtendedPlayer) this.getOwnerEntity().getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);
		
		if(!this.worldObj.isRemote && tick == 20)
		{
			if(props != null)
			{
				props.consumeEnergy(1);
			}
		}
		
		
		super.updateEntity();
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt)
	{
		super.readFromNBT(nbt);

		this.owner = nbt.getString("owner");
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt)
	{
		super.writeToNBT(nbt);
		nbt.setString("owner", this.owner);
	}

	public void setOwner(String owner)
	{
		this.owner = owner;
	}

	public void setOwnerEntity(EntityPlayer owner)
	{
		this.owner = owner.username;
	}

	public String getOwner()
	{
		return this.owner;
	}

	public EntityPlayer getOwnerEntity()
	{
		return this.worldObj.getPlayerEntityByName(this.owner);
	}
}
