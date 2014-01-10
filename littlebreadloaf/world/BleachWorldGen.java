package littlebreadloaf.world;

import java.util.Random;

import littlebreadloaf.libraries.Ids;
import littlebreadloaf.world.gen.BleachGenHole;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.MapGenScatteredFeature;
import cpw.mods.fml.common.IWorldGenerator;

public class BleachWorldGen implements IWorldGenerator
{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		if (world.provider.dimensionId ==  Ids.worldHuecoMundoID)
		{
			genHuecoMundo(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
		}
	}

	private void genHuecoMundo(Random rand, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		int k = chunkX * 16;
		int l = chunkZ * 16;
		
		int x = k + rand.nextInt(16) + 8;
		int z = l + rand.nextInt(16) + 8;
		if(rand.nextInt(10) == 0)
			new BleachGenHole(59).generate(world, rand, x, 0, z);
	}

}
