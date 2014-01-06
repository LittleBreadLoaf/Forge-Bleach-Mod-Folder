package littlebreadloaf.world;

import littlebreadloaf.libraries.BleachMod;
import littlebreadloaf.libraries.Ids;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.IChunkProvider;

public class HuecoMundoWorldProvider extends WorldProvider
{
	@Override
	public void registerWorldChunkManager()
	{
		this.dimensionId = Ids.worldHuecoMundoID;
		this.worldChunkMgr = new HuecoMundoChunkManager(this.worldObj);
	}

	@Override
	public IChunkProvider createChunkGenerator()
	{
		return new HuecoMundoChunkProvider(this.worldObj, this.worldObj.getSeed(), true);
	}

	@Override
	public String getDimensionName()
	{
		return "Hueco Mundo";//TODO: add localization
	}
}