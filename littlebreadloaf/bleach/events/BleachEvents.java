package littlebreadloaf.bleach.events;

import cpw.mods.fml.common.FMLLog;
import littlebreadloaf.bleach.tiles.TileSeeleSchneider;
import net.minecraft.entity.Entity;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;

public class BleachEvents
{
	@ForgeSubscribe
	public void LivingUpdateEvent(LivingUpdateEvent event)
	{
		if (!event.entity.worldObj.isRemote)
		{
			if (isEntityInCube(event.entity))
			{
				return;
			}
		}
	}

	private boolean isEntityInCube(Entity entity)
	{
		int x, y, z, side;

		TileSeeleSchneider tile;
		
		for (int i = 0; i < TileSeeleSchneider.magicSquare.size(); i++)
		{
			x = TileSeeleSchneider.magicSquare.get(i).posX;
			y = TileSeeleSchneider.magicSquare.get(i).posY;
			z = TileSeeleSchneider.magicSquare.get(i).posZ;
			
			tile = (TileSeeleSchneider) entity.worldObj.getBlockTileEntity(x, y, z);
			side = tile.side;
			
			if(entity.posX > x && entity.posX < x + side &&
			entity.posZ > z && entity.posZ < z + side &&
			entity.posY >= y)
			{
				FMLLog.info("[Bleach mod] event");
//				entity.motionX = 0F;
//				entity.motionY = 0F;
//				entity.motionZ = 0F;
				
				entity.motionX *= 0.000025;
                entity.motionY *= 0.000025;
                entity.motionZ *= 0.000025;
				
				
			}
		}
		return false;
	}
}
