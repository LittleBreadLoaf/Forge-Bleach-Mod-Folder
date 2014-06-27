package littlebreadloaf.bleach.world.biomes;

import littlebreadloaf.bleach.BleachMod;
import littlebreadloaf.bleach.BleachIds;
import net.minecraft.world.biome.BiomeGenBase;

public class BleachBiomes
{
	public static BiomeGenBase HuecoMundo;
	public static BiomeGenBase SoulSocietyForest;

	public BleachBiomes()
	{
		HuecoMundo = new HuecoMundoBiome(BleachIds.biomeHuecoMundoID);
		
		SoulSocietyForest = new SoulSocietyForestBiome(BleachIds.biomeSoulSocietyForestID);

	}
}
