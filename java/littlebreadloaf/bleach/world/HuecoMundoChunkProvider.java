package littlebreadloaf.bleach.world;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.eventhandler.Event.Result;
import littlebreadloaf.bleach.api.Tools;
import littlebreadloaf.bleach.blocks.BleachBlocks;
import littlebreadloaf.bleach.world.gen.BleachGenHole;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.SpawnerAnimals;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.MapGenBase;
import net.minecraft.world.gen.MapGenCaves;
import net.minecraft.world.gen.MapGenRavine;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraft.world.gen.feature.WorldGenDungeons;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraft.world.gen.structure.MapGenMineshaft;
import net.minecraft.world.gen.structure.MapGenStronghold;
import net.minecraft.world.gen.structure.MapGenVillage;
import static net.minecraftforge.event.terraingen.InitMapGenEvent.EventType.*;
import static net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.*;
import net.minecraftforge.common.*;
import net.minecraftforge.event.terraingen.*;

public class HuecoMundoChunkProvider implements IChunkProvider
{
	/** RNG. */
	private Random rand;
	
	/** A NoiseGeneratorOctaves used in generating terrain */
	private NoiseGeneratorOctaves noiseGen1;
	
	/** A NoiseGeneratorOctaves used in generating terrain */
	private NoiseGeneratorOctaves noiseGen2;
	
	/** A NoiseGeneratorOctaves used in generating terrain */
	private NoiseGeneratorOctaves noiseGen3;
	
	/** A NoiseGeneratorOctaves used in generating terrain */
	private NoiseGeneratorOctaves noiseGen4;
	
	/** A NoiseGeneratorOctaves used in generating terrain */
	public NoiseGeneratorOctaves noiseGen5;
	
	/** A NoiseGeneratorOctaves used in generating terrain */
	public NoiseGeneratorOctaves noiseGen6;
	public NoiseGeneratorOctaves mobSpawnerNoise;
	
	/** Reference to the World object. */
	private World worldObj;
	
	
	/** Holds the overall noise array used in chunk generation */
	private double[] noiseArray;
	private double[] stoneNoise = new double[256];
	
	/** The biomes that are used to generate the chunk */
	private BiomeGenBase[] biomesForGeneration;
	
	/** A double array that hold terrain noise from noiseGen3 */
	double[] noise3;
	
	/** A double array that hold terrain noise */
	double[] noise1;
	
	/** A double array that hold terrain noise from noiseGen2 */
	double[] noise2;
	
	/** A double array that hold terrain noise from noiseGen5 */
	double[] noise5;
	
	/** A double array that holds terrain noise from noiseGen6 */
	double[] noise6;
	
	/**
	 * Used to store the 5x5 parabolic field that is used during terrain
	 * generation.
	 */
	float[] parabolicField;
	int[][] field_73219_j = new int[32][32];
	
	public HuecoMundoChunkProvider(World world, long seed, boolean features)
	{
		this.worldObj = world;
		this.rand = new Random(seed);
		this.noiseGen1 = new NoiseGeneratorOctaves(this.rand, 16);
		this.noiseGen2 = new NoiseGeneratorOctaves(this.rand, 16);
		this.noiseGen3 = new NoiseGeneratorOctaves(this.rand, 8);
		this.noiseGen4 = new NoiseGeneratorOctaves(this.rand, 4);
		this.noiseGen5 = new NoiseGeneratorOctaves(this.rand, 10);
		this.noiseGen6 = new NoiseGeneratorOctaves(this.rand, 16);
		this.mobSpawnerNoise = new NoiseGeneratorOctaves(this.rand, 8);
		
		NoiseGeneratorOctaves[] noiseGens = {noiseGen1, noiseGen2, noiseGen3, noiseGen4, noiseGen5, noiseGen6, mobSpawnerNoise};
		noiseGens = (NoiseGeneratorOctaves[]) TerrainGen.getModdedNoiseGenerators(world, this.rand, noiseGens);
		this.noiseGen1 = noiseGens[0];
		this.noiseGen2 = noiseGens[1];
		this.noiseGen3 = noiseGens[2];
		this.noiseGen4 = noiseGens[3];
		this.noiseGen5 = noiseGens[4];
		this.noiseGen6 = noiseGens[5];
		this.mobSpawnerNoise = noiseGens[6];
	}
	
	
	/**
	 * Generates the shape of the terrain for the chunk though its all stone
	 * though the water is frozen if the temperature is low enough
	 */
	public void generateTerrain(int par1, int par2, Block[] chunk)
	{
		byte miniChunk = 4;
		byte chunkSize = 16;
		byte seeLevel = 59;
		int k = miniChunk + 1;
		byte b3 = 17;
		int l = miniChunk + 1;
		this.biomesForGeneration = this.worldObj.getWorldChunkManager().getBiomesForGeneration(this.biomesForGeneration, par1 * 4 - 2, par2 * 4 - 2, k + 5, l + 5);
this.noiseArray = this.initializeNoiseField(this.noiseArray, par1 * miniChunk, 0, par2 * miniChunk, k, b3, l);
		
		for(int x = 0; x < miniChunk; ++x)
		{
			for(int z = 0; z < miniChunk; ++z)
			{
				for(int y = 0; y < chunkSize; ++y)
				{
					double d0 = 0.125D;
					double d1 = this.noiseArray[((x + 0) * l + z + 0) * b3 + y + 0];
					double d2 = this.noiseArray[((x + 0) * l + z + 1) * b3 + y + 0];
					double d3 = this.noiseArray[((x + 1) * l + z + 0) * b3 + y + 0];
					double d4 = this.noiseArray[((x + 1) * l + z + 1) * b3 + y + 0];
					double d5 = (this.noiseArray[((x + 0) * l + z + 0) * b3 + y + 1] - d1) * d0;
					double d6 = (this.noiseArray[((x + 0) * l + z + 1) * b3 + y + 1] - d2) * d0;
					double d7 = (this.noiseArray[((x + 1) * l + z + 0) * b3 + y + 1] - d3) * d0;
					double d8 = (this.noiseArray[((x + 1) * l + z + 1) * b3 + y + 1] - d4) * d0;
					
					for(int subY = 0; subY < 8; ++subY)
					{
						double d9 = 0.25D;
						double d10 = d1;
						double d11 = d2;
						double d12 = (d3 - d1) * d9;
						double d13 = (d4 - d2) * d9;
						
					
						for(int subX = 0; subX < 4; ++subX)
						{
							int j2 = subX + x * 4 << 11 | 0 + z * 4 << 7 | y * 8 + subY;
							short short1 = 128;
							j2 -= short1;
							double d14 = 0.25D;
							double d15 = (d11 - d10) * d14;
							double d16 = d10 - d15;
							
							for(int subZ = 0; subZ < 4; ++subZ)
							{
								if((d16 += d15) > 0.0D && y * 8 + subY >= seeLevel)
								{
									chunk[j2 += short1] = BleachBlocks.whitesand;
								}
//								else if(y * 8 + subY < 25 && (d16 + d15)  > -30.0D)
//								{
//									chunk[j2 += short1] = (byte)Block.dirt.blockID;
//								}
								else
								{
									chunk[j2 += short1] = Blocks.air;
								}
							}
							
							d10 += d12;
							d11 += d13;
						}
						
						d1 += d5;
						d2 += d6;
						d3 += d7;
						d4 += d8;
					}
				}
			}
		}
		
		
		//bottom
		this.noiseArray = this.initializeNoiseFieldBottom(this.noiseArray, par1 * miniChunk, 0, par2 * miniChunk, k, b3, l);
		
		for(int x = 0; x < miniChunk; ++x)
		{
			for(int z = 0; z < miniChunk; ++z)
			{
				for(int y = 0; y < chunkSize; ++y)
				{
					double d0 = 0.125D;
					double d1 = this.noiseArray[((x + 0) * l + z + 0) * b3 + y + 0];
					double d2 = this.noiseArray[((x + 0) * l + z + 1) * b3 + y + 0];
					double d3 = this.noiseArray[((x + 1) * l + z + 0) * b3 + y + 0];
					double d4 = this.noiseArray[((x + 1) * l + z + 1) * b3 + y + 0];
					double d5 = (this.noiseArray[((x + 0) * l + z + 0) * b3 + y + 1] - d1) * d0;
					double d6 = (this.noiseArray[((x + 0) * l + z + 1) * b3 + y + 1] - d2) * d0;
					double d7 = (this.noiseArray[((x + 1) * l + z + 0) * b3 + y + 1] - d3) * d0;
					double d8 = (this.noiseArray[((x + 1) * l + z + 1) * b3 + y + 1] - d4) * d0;
					
					for(int subY = 0; subY < 8; ++subY)
					{
						double d9 = 0.25D;
						double d10 = d1;
						double d11 = d2;
						double d12 = (d3 - d1) * d9;
						double d13 = (d4 - d2) * d9;
						
						for(int subX = 0; subX < 4; ++subX)
						{
							int j2 = subX + x * 4 << 11 | 0 + z * 4 << 7 | y * 8 + subY;
							short short1 = 128;
							j2 -= short1;
							double d14 = 0.25D;
							double d15 = (d11 - d10) * d14;
							double d16 = d10 - d15;
							
							for(int subZ = 0; subZ < 4; ++subZ)
							{
								if((d16 += d15) < -25.0D && y * 8 + subY <= 33)
								{
									chunk[j2 += short1] = Blocks.stone;
								}
							}
							
							d10 += d12;
							d11 += d13;
						}
						
						d1 += d5;
						d2 += d6;
						d3 += d7;
						d4 += d8;
					}
				}
			}
		}
	}
	
	
	/**
	 * Replaces the stone that was placed in with blocks that match the biome
	 */
	public void replaceBlocksForBiome(int par1, int par2, Block[] blocks, BiomeGenBase[] biomeArray)
	{
		ChunkProviderEvent.ReplaceBiomeBlocks event = new ChunkProviderEvent.ReplaceBiomeBlocks(this, par1, par2, blocks, biomeArray);
		MinecraftForge.EVENT_BUS.post(event);
		if(event.getResult() == Result.DENY)
			return;
		
		byte oceanLevel = 30;
		double d0 = 0.03125D;
		this.stoneNoise = this.noiseGen4.generateNoiseOctaves(this.stoneNoise, par1 * 16, par2 * 16, 0, 16, 16, 1, d0 * 2.0D, d0 * 2.0D, d0 * 2.0D);
		
		for(int x = 0; x < 16; x++)
		{
			for(int z = 0; z < 16; z++)
			{
				BiomeGenBase biomegenbase = biomeArray[z + x * 16];
				int i1 = (int)(this.stoneNoise[x + z * 16] / 3.0D + 3.0D + this.rand.nextDouble() * 0.25D);
				int j1 = -1;
				Block b1 = biomegenbase.topBlock;
				Block b2 = biomegenbase.fillerBlock;
				
				for(int y = 127; y >= 0; y--)
				{
					int index = (z * 16 + x) * 128 + y;
					
					if(y <= 0)
					{
						blocks[index] = Blocks.bedrock;
					}
					else
					{
						Block b3 = blocks[index];
						
						if(b3 == Blocks.air)
						{
							j1 = -1;
						}
						else
							if(b3 == Blocks.stone)
							{
								if(j1 == -1)
								{
									if(i1 <= 0)
									{
										b1 = Blocks.air;
										b2 = Blocks.stone;
									}
									else
										if(y >= oceanLevel - 4 && y <= oceanLevel + 1)
										{
											b1 = biomegenbase.topBlock;
											b2 = biomegenbase.fillerBlock;
										}
									
									
									j1 = i1;
									
									blocks[index] = b2;
								}
								else
									if(j1 > 0)
									{
										--j1;
										blocks[index] = b2;
									}
							}
					}
				}
			}
		}
	}
	
	/**
	 * loads or generates the chunk at the chunk location specified
	 */
	public Chunk loadChunk(int par1, int par2)
	{
		return this.provideChunk(par1, par2);
	}
	
	/**
	 * Will return back a chunk, if it doesn't exist and its not a MP client it
	 * will generates all the blocks for the specified chunk from the map seed
	 * and chunk seed
	 */
	public Chunk provideChunk(int par1, int par2)
	{
		this.rand.setSeed((long)par1 * 341873128712L + (long)par2 * 132897987541L);
		Block[] ablock = new Block[32768];
		this.generateTerrain(par1, par2, ablock);
		this.biomesForGeneration = this.worldObj.getWorldChunkManager().loadBlockGeneratorData(this.biomesForGeneration, par1 * 16, par2 * 16, 16, 16);
		this.replaceBlocksForBiome(par1, par2, ablock, this.biomesForGeneration);
		
		Chunk chunk = new Chunk(this.worldObj, ablock, par1, par2);
		byte[] abyte1 = chunk.getBiomeArray();
		
		for(int k = 0; k < abyte1.length; ++k)
		{
			abyte1[k] = (byte)this.biomesForGeneration[k].biomeID;
		}
		
		chunk.generateSkylightMap();
		return chunk;
	}
	
	/**
	 * generates a subset of the level's terrain data. Takes 7 arguments: the
	 * [empty] noise array, the position, and the size.
	 */
	private double[] initializeNoiseField(double[] par1ArrayOfDouble, int par2, int par3, int par4, int par5, int par6, int par7)
	{
		ChunkProviderEvent.InitNoiseField event = new ChunkProviderEvent.InitNoiseField(this, par1ArrayOfDouble, par2, par3, par4, par5, par6, par7);
		MinecraftForge.EVENT_BUS.post(event);
		if(event.getResult() == Result.DENY)
			return event.noisefield;
		
		if(par1ArrayOfDouble == null)
		{
			par1ArrayOfDouble = new double[par5 * par6 * par7];
		}
		
		if(this.parabolicField == null)
		{
			this.parabolicField = new float[25];
			
			for(int k1 = -2; k1 <= 2; ++k1)
			{
				for(int l1 = -2; l1 <= 2; ++l1)
				{
					float f = 10.0F / MathHelper.sqrt_float((float)(k1 * k1 + l1 * l1) + 0.2F);
					this.parabolicField[k1 + 2 + (l1 + 2) * 5] = f;
				}
			}
		}
		
		double d0 = 684.412D;
		double d1 = 684.412D;
		this.noise5 = this.noiseGen5.generateNoiseOctaves(this.noise5, par2, par4, par5, par7, 1.121D, 1.121D, 0.5D);
		this.noise6 = this.noiseGen6.generateNoiseOctaves(this.noise6, par2, par4, par5, par7, 200.0D, 200.0D, 0.5D);
		this.noise3 = this.noiseGen3.generateNoiseOctaves(this.noise3, par2, par3, par4, par5, par6, par7, d0 / 80.0D, d1 / 160.0D, d0 / 80.0D);
		this.noise1 = this.noiseGen1.generateNoiseOctaves(this.noise1, par2, par3, par4, par5, par6, par7, d0, d1, d0);
		this.noise2 = this.noiseGen2.generateNoiseOctaves(this.noise2, par2, par3, par4, par5, par6, par7, d0, d1, d0);
		boolean flag = false;
		boolean flag1 = false;
		int i2 = 0;
		int j2 = 0;
		
		for(int k2 = 0; k2 < par5; ++k2)
		{
			for(int l2 = 0; l2 < par7; ++l2)
			{
				float f1 = 0.0F;
				float f2 = 0.0F;
				float f3 = 0.0F;
				byte b0 = 2;
				BiomeGenBase biomegenbase = this.biomesForGeneration[k2 + 2 + (l2 + 2) * (par5 + 5)];
				
				for(int i3 = -b0; i3 <= b0; ++i3)
				{
					for(int j3 = -b0; j3 <= b0; ++j3)
					{
						BiomeGenBase biomegenbase1 = this.biomesForGeneration[k2 + i3 + 2 + (l2 + j3 + 2) * (par5 + 5)];
						float f4 = this.parabolicField[i3 + 2 + (j3 + 2) * 5] / (biomegenbase1.rootHeight + 2.0F);
						
						if(biomegenbase1.rootHeight > biomegenbase.rootHeight)
						{
							f4 /= 2.0F;
						}
						
						f1 += biomegenbase1.rootHeight * f4;
						f2 += biomegenbase1.rootHeight * f4;
						f3 += f4;
					}
				}
				
				f1 /= f3;
				f2 /= f3;
				f1 = f1 * 0.9F + 0.1F;
				f2 = (f2 * 4.0F - 1.0F) / 8.0F;
				double d2 = this.noise6[j2] / 8000.0D;
				
				if(d2 < 0.0D)
				{
					d2 = -d2 * 0.3D;
				}
				
				d2 = d2 * 3.0D - 2.0D;
				
				if(d2 < 0.0D)
				{
					d2 /= 2.0D;
					
					if(d2 < -1.0D)
					{
						d2 = -1.0D;
					}
					
					d2 /= 1.4D;
					d2 /= 2.0D;
				}
				else
				{
					if(d2 > 1.0D)
					{
						d2 = 1.0D;
					}
					
					d2 /= 8.0D;
				}
				
				++j2;
				
				for(int k3 = 0; k3 < par6; ++k3)
				{
					double d3 = (double)f2;
					double d4 = (double)f1;
					d3 += d2 * 0.2D;
					d3 = d3 * (double)par6 / 16.0D;
					double d5 = (double)par6 / 2.0D + d3 * 4.0D;
					double d6 = 0.0D;
					double d7 = ((double)k3 - d5) * 12.0D * 128.0D / 128.0D / d4;
					
					if(d7 < 0.0D)
					{
						d7 *= 4.0D;
					}
					
					double d8 = this.noise1[i2] / 512.0D;
					double d9 = this.noise2[i2] / 512.0D;
					double d10 = (this.noise3[i2] / 10.0D + 1.0D) / 2.0D;
					
					if(d10 < 0.0D)
					{
						d6 = d8;
					}
					else
						if(d10 > 1.0D)
						{
							d6 = d9;
						}
						else
						{
							d6 = d8 + (d9 - d8) * d10;
						}
					
					d6 -= d7;
					
					if(k3 > par6 - 4)
					{
						double d11 = (double)((float)(k3 - (par6 - 4)) / 3.0F);
						d6 = d6 * (1.0D - d11) + -10.0D * d11;
					}
					
					par1ArrayOfDouble[i2] = d6;
					++i2;
				}
			}
		}
		
		return par1ArrayOfDouble;
	}
	/**
	 * generates a subset of the level's terrain data. Takes 7 arguments: the
	 * [empty] noise array, the position, and the size.
	 */
	private double[] initializeNoiseFieldBottom(double[] noiseField, int par2, int par3, int par4, int par5, int par6, int par7)
	{
		ChunkProviderEvent.InitNoiseField event = new ChunkProviderEvent.InitNoiseField(this, noiseField, par2, par3, par4, par5, par6, par7);
		MinecraftForge.EVENT_BUS.post(event);
		if(event.getResult() == Result.DENY)
			return event.noisefield;
		
		if(noiseField == null)
		{
			noiseField = new double[par5 * par6 * par7];
		}
		
		if(this.parabolicField == null)
		{
			this.parabolicField = new float[25];
			
			for(int k1 = -2; k1 <= 2; ++k1)
			{
				for(int l1 = -2; l1 <= 2; ++l1)
				{
					float f = 10.0F / MathHelper.sqrt_float((float)(k1 * k1 + l1 * l1) + 0.2F);
					this.parabolicField[k1 + 2 + (l1 + 2) * 5] = f;
				}
			}
		}
		
		double d0 = 684.412D;
		double d1 = 684.412D;
		this.noise5 = this.noiseGen5.generateNoiseOctaves(this.noise5, par2, par4, par5, par7, 1.121D, 1.121D, 0.5D);
		this.noise6 = this.noiseGen6.generateNoiseOctaves(this.noise6, par2, par4, par5, par7, 200.0D, 200.0D, 0.5D);
		this.noise3 = this.noiseGen3.generateNoiseOctaves(this.noise3, par2, par3, par4, par5, par6, par7, d0 / 80.0D, d1 / 160.0D, d0 / 80.0D);
		this.noise1 = this.noiseGen1.generateNoiseOctaves(this.noise1, par2, par3, par4, par5, par6, par7, d0, d1, d0);
		this.noise2 = this.noiseGen2.generateNoiseOctaves(this.noise2, par2, par3, par4, par5, par6, par7, d0, d1, d0);
		boolean flag = false;
		boolean flag1 = false;
		int i2 = 0;
		int j2 = 0;
		
		float minHeight = -1.1F;
		float maxHeight = -1.0F;
		
		for(int k2 = 0; k2 < par5; ++k2)
		{
			for(int l2 = 0; l2 < par7; ++l2)
			{
				float f1 = 0.0F;
				float f2 = 0.0F;
				float f3 = 0.0F;
				byte b0 = 2;
				
				for(int i3 = -b0; i3 <= b0; ++i3)
				{
					for(int j3 = -b0; j3 <= b0; ++j3)
					{
						float f4 = this.parabolicField[i3 + 2 + (j3 + 2) * 5] / (minHeight + 2.0F);
						
						if(minHeight > minHeight)
						{
							f4 /= 2.0F;
						}
						
						f1 += maxHeight * f4;
						f2 += minHeight * f4;
						f3 += f4;
					}
				}
				
				f1 /= f3;
				f2 /= f3;
				f1 = f1 * 0.9F + 0.1F;
				f2 = (f2 * 4.0F - 1.0F) / 8.0F;
				double d2 = this.noise6[j2] / 8000.0D;
				
				if(d2 < 0.0D)
				{
					d2 = -d2 * 0.3D;
				}
				
				d2 = d2 * 3.0D - 2.0D;
				
				if(d2 < 0.0D)
				{
					d2 /= 2.0D;
					
					if(d2 < -1.0D)
					{
						d2 = -1.0D;
					}
					
					d2 /= 1.4D;
					d2 /= 2.0D;
				}
				else
				{
					if(d2 > 1.0D)
					{
						d2 = 1.0D;
					}
					
					d2 /= 8.0D;
				}
				
				++j2;
				
				for(int k3 = 0; k3 < par6; ++k3)
				{
					double d3 = (double)f2;
					double d4 = (double)f1;
					d3 += d2 * 0.2D;
					d3 = d3 * (double)par6 / 16.0D;
					double d5 = (double)par6 / 2.0D + d3 * 4.0D;
					double d6 = 0.0D;
					double d7 = ((double)k3 - d5) * 12.0D * 128.0D / 128.0D / d4;
					
					if(d7 < 0.0D)
					{
						d7 *= 4.0D;
					}
					
					double d8 = this.noise1[i2] / 512.0D;
					double d9 = this.noise2[i2] / 512.0D;
					double d10 = (this.noise3[i2] / 10.0D + 1.0D) / 2.0D;
					
					if(d10 < 0.0D)
					{
						d6 = d8;
					}
					else
						if(d10 > 1.0D)
						{
							d6 = d9;
						}
						else
						{
							d6 = d8 + (d9 - d8) * d10;
						}
					
					d6 -= d7;
					
					if(k3 > par6 - 4)
					{
						double d11 = (double)((float)(k3 - (par6 - 4)) / 3.0F);
						d6 = d6 * (1.0D - d11) + -10.0D * d11;
					}
					
					noiseField[i2] = d6;
					++i2;
				}
			}
		}
		
		return noiseField;
	}
	
	/**
	 * Checks to see if a chunk exists at x, y
	 */
	public boolean chunkExists(int par1, int par2)
	{
		return true;
	}
	
	/**
	 * Populates chunk with ores etc etc
	 */
	public void populate(IChunkProvider par1IChunkProvider, int chunkX, int chunkZ)
	{
		BlockSand.fallInstantly = true;
		int k = chunkX * 16;
		int l = chunkZ * 16;
		BiomeGenBase biomegenbase = this.worldObj.getBiomeGenForCoords(k + 16, l + 16);
		this.rand.setSeed(this.worldObj.getSeed());
		long i1 = this.rand.nextLong() / 2L * 2L + 1L;
		long j1 = this.rand.nextLong() / 2L * 2L + 1L;
		this.rand.setSeed((long)chunkX * i1 + (long)chunkZ * j1 ^ this.worldObj.getSeed());
		boolean flag = false;
		
		MinecraftForge.EVENT_BUS.post(new PopulateChunkEvent.Pre(par1IChunkProvider, worldObj, rand, chunkX, chunkZ, flag));
//		
//		if(this.mapFeaturesEnabled)
//		{
//			//this.mineshaftGenerator.generateStructuresInChunk(this.worldObj, this.rand, par2, par3);
//			//flag = this.villageGenerator.generateStructuresInChunk(this.worldObj, this.rand, par2, par3);
//			//this.strongholdGenerator.generateStructuresInChunk(this.worldObj, this.rand, par2, par3);
//			//this.scatteredFeatureGenerator.generateStructuresInChunk(this.worldObj, this.rand, par2, par3);
//		}
//		
//		int k1;
//		int l1;
//		int i2;
//		
//		/*if(biomegenbase != BiomeGenBase.desert && biomegenbase != BiomeGenBase.desertHills && !flag && this.rand.nextInt(4) == 0 && TerrainGen.populate(par1IChunkProvider, worldObj, rand, par2, par3, flag, LAKE))
//		{
//			k1 = k + this.rand.nextInt(16) + 8;
//			l1 = this.rand.nextInt(128);
//			i2 = l + this.rand.nextInt(16) + 8;
//			(new WorldGenLakes(Block.waterStill.blockID)).generate(this.worldObj, this.rand, k1, l1, i2);
//		}*/
//		
//		
//		boolean doGen = TerrainGen.populate(par1IChunkProvider, worldObj, rand, par2, par3, flag, DUNGEON);
//		for(k1 = 0; doGen && k1 < 8; ++k1)
//		{
//			l1 = k + this.rand.nextInt(16) + 8;
//			i2 = this.rand.nextInt(128);
//			int j2 = l + this.rand.nextInt(16) + 8;
//			//(new WorldGenDungeons()).generate(this.worldObj, this.rand, l1, i2, j2);
//		}
//		
		biomegenbase.decorate(this.worldObj, this.rand, k, l);
		SpawnerAnimals.performWorldGenSpawning(this.worldObj, biomegenbase, k + 8, l + 8, 16, 16, this.rand);

		
		MinecraftForge.EVENT_BUS.post(new PopulateChunkEvent.Post(par1IChunkProvider, worldObj, rand, chunkX, chunkZ, flag));
		
		BlockSand.fallInstantly = false;
	}
	
	/**
	 * Two modes of operation: if passed true, save all Chunks in one go. If
	 * passed false, save up to two chunks. Return true if all chunks have been
	 * saved.
	 */
	public boolean saveChunks(boolean par1, IProgressUpdate par2IProgressUpdate)
	{
		return true;
	}
	
	/**
	 * Save extra data not associated with any Chunk. Not saved during autosave,
	 * only during world unload. Currently unimplemented.
	 */
	public void saveExtraData()
	{
	}
	
	/**
	 * Unloads chunks that are marked to be unloaded. This is not guaranteed to
	 * unload every such chunk.
	 */
	public boolean unloadQueuedChunks()
	{
		return false;
	}
	
	/**
	 * Returns if the IChunkProvider supports saving.
	 */
	public boolean canSave()
	{
		return true;
	}

	@Override
	/**
	 * Converts the instance data to a readable string.
	 */
	public String makeString()
	{
		return "HuecoMundoChunkProvider";
	}

	@Override
	/**
	 * Returns a list of creatures of the specified type that can spawn at the
	 * given location.
	 */
	public List getPossibleCreatures(EnumCreatureType par1EnumCreatureType, int par2, int par3, int par4)
	{
		return null;
	}


	@Override
	public int getLoadedChunkCount()
	{
		return 0;
	}

	@Override
	public void recreateStructures(int par1, int par2)
	{
		
	}

	@Override
	public ChunkPosition func_147416_a(World var1, String var2, int var3,
			int var4, int var5) {
		// TODO Auto-generated method stub
		return null;
	}
}