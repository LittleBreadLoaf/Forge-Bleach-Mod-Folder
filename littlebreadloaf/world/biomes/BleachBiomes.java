package littlebreadloaf.world.biomes;

import littlebreadloaf.libraries.BleachMod;
import littlebreadloaf.libraries.Ids;
import net.minecraft.world.biome.BiomeGenBase;

public class BleachBiomes
{
	public static BiomeGenBase HuecoMundo;

	public BleachBiomes()
	{
		HuecoMundo = new HuecoMundoBiome(Ids.biomeHuecoMundoID);

	}
}
