package littlebreadloaf.world;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

public class HuecoMundoTeleporter extends Teleporter
{
	private final WorldServer worldServer;

	public HuecoMundoTeleporter(WorldServer worldServer)
	{
		super(worldServer);
		this.worldServer = worldServer;
	}

	public boolean canPlacePortalAt(int x, int y, int z)
	{
		return true;
	}


	@Override
	public void placeInPortal(Entity entity, double px, double py, double pz, float pitch)
	{
		int x = (int) Math.floor(px);
		int z = (int) Math.floor(pz);
		int y = 128;

		double d = this.worldServer.rand.nextDouble() * Math.PI * 2;
		entity.posX = x + 0.5D + Math.cos(d) * 1.5;
		entity.posZ = z + 0.5D + Math.sin(d) * 1.5;
		entity.posY = this.worldServer.getFirstUncoveredBlock((int) entity.posX, (int) entity.posZ) + 2;
	}
}