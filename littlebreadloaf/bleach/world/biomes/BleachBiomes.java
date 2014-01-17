package littlebreadloaf.bleach.world.biomes;

import littlebreadloaf.bleach.BleachMod;
import littlebreadloaf.bleach.BleachIds;
import net.minecraft.world.biome.BiomeGenBase;

public class BleachBiomes
{
	public static BiomeGenBase HuecoMundo;

	public BleachBiomes()
	{
		HuecoMundo = new HuecoMundoBiome(BleachIds.biomeHuecoMundoID);

	}
}
