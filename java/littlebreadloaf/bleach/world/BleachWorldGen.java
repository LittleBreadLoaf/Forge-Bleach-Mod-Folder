package littlebreadloaf.bleach.world;

import java.io.File;
import java.util.Random;

import littlebreadloaf.bleach.BleachIds;
import littlebreadloaf.bleach.world.gen.BleachGenHole;
import littlebreadloaf.bleach.world.gen.BleachGenMenosTree;
import net.minecraft.client.Minecraft;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.storage.SaveFormatOld;
import net.minecraftforge.event.world.WorldEvent.Save;
import cpw.mods.fml.common.IWorldGenerator;

public class BleachWorldGen implements IWorldGenerator
{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		WorldServer worlds = (WorldServer)world;
		File theWorld = new File("./saves/" + worlds.getSaveHandler().getWorldDirectoryName() +"/DIM7");//WORKS!
		File soulSociety = new File("./assets/bleach/maps/DIM7");
		soulSociety.mkdirs();
//		if(soulSociety.exists())
//		{
//			System.out.println("GOt it");
//		}
//		else
//		{
//			System.out.println("HMMM");
//		}
//		if(theWorld.exists())
//			System.out.println("YAY");
		
		
	
		if (world.provider.dimensionId ==  BleachIds.worldHuecoMundoID)
		{
			genHuecoMundo(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
		}
		if (world.provider.dimensionId ==  BleachIds.worldSoulSocietyID)
		{
			genSoulSociety(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
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

		x = k + rand.nextInt(16) + 8;
		z = l + rand.nextInt(16) + 8;
		
		new BleachGenMenosTree(10).generate(world, rand, x, 0, z);
	}
	
	private void genSoulSociety(Random rand, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		int k = chunkX * 16;
		int l = chunkZ * 16;
		
		int x = k + rand.nextInt(16) + 8;
		int z = l + rand.nextInt(16) + 8;
	}

}
