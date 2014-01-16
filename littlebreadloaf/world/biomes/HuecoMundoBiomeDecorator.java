package littlebreadloaf.world.biomes;

import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;

public class HuecoMundoBiomeDecorator extends BiomeDecorator
{

	public HuecoMundoBiomeDecorator(BiomeGenBase biome)
	{
		super(biome);

        this.flowersPerChunk = 0;
        this.grassPerChunk = 0;
        this.sandPerChunk = 0;
        this.sandPerChunk2 = 0;
        this.clayPerChunk = 0;
        this.generateLakes = false;
        this.biome = biome;
	}

}
