package littlebreadloaf.bleach.extras;

import java.util.Random;

import littlebreadloaf.bleach.blocks.BleachBlocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class OreGenerator implements IWorldGenerator
{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) 
	{
		switch(world.provider.dimensionId)
		{
		case -1:
		    generateNether(world, random, chunkX * 16, chunkZ * 16);
		    break;
		case 0:
		    generateSurface(world, random, chunkX * 16, chunkZ * 16);
		    break;
		case 1:
		    generateEnd(world, random, chunkX * 16, chunkZ * 16);
		    break;
		}
		
	}
		
		private void generateEnd(World world, Random random, int i, int j) 
		{
			
		}

		private void generateSurface(World world, Random random, int i, int j) 
		{
			for(int rarity1 = 0; rarity1 < 3; rarity1++)
			{
	        	int firstBlockXCoord = i + random.nextInt(16);
	        	int firstBlockYCoord = random.nextInt(64);
	        	int firstBlockZCoord = j + random.nextInt(16);
	        	
	        	(new WorldGenMinable(BleachBlocks.hollowdiamond, 1)).generate(world, random, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
	        }
			
			for(int rarity2 = 0; rarity2 < 3; rarity2++)
			{
	        	int firstBlockXCoord = i + random.nextInt(16);
	        	int firstBlockYCoord = random.nextInt(64);
	        	int firstBlockZCoord = j + random.nextInt(16);
	        	
	        	(new WorldGenMinable(BleachBlocks.hollowemerald, 1)).generate(world, random, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
	        }
			
			for(int rarity3 = 0; rarity3 < 3; rarity3++)
			{
	        	int firstBlockXCoord = i + random.nextInt(16);
	        	int firstBlockYCoord = random.nextInt(64);
	        	int firstBlockZCoord = j + random.nextInt(16);
	        	
	        	(new WorldGenMinable(BleachBlocks.hollowgold, 1)).generate(world, random, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
	        }
		}

		private void generateNether(World world, Random random, int i, int j) 
		{
			
		}

}
