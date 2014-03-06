package littlebreadloaf.bleach.world.biomes;

import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;

public class SoulSocietyBiomeDecorator extends BiomeDecorator
{

	public SoulSocietyBiomeDecorator(BiomeGenBase biome)
	{
		super(biome);

        this.flowersPerChunk = 0;
        this.treesPerChunk = 8;
        this.grassPerChunk = 10;
        this.sandPerChunk = 0;
        this.sandPerChunk2 = 0;
        this.clayPerChunk = 0;
        this.generateLakes = false;
        this.biome = biome;
	}

}
