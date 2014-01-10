package littlebreadloaf.world.gen;

import java.util.Random;

import cpw.mods.fml.common.FMLLog;

import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BleachGenHole extends WorldGenerator
{

	int seeLevel;

	public BleachGenHole(int seeLevel)
	{
		this.seeLevel = seeLevel;
	}

	@Override
	public boolean generate(World world, Random random, int i, int j, int k)
	{
		if(world.getBlockId(i, seeLevel + 1, j) == 0)
			return false;
		
		int radius = random.nextInt(2) + 1;

		for (int x = -radius; x <= radius; x++)
		{
			for (int z = -radius; z <= radius; z++)
			{
				for(int y = this.seeLevel; y < 128; y++)
				{
					
					if(x * x + z * z <= radius * radius)
						world.setBlockToAir(x + i, y, z + k);
				}
			}
		}

		return true;
	}

}
