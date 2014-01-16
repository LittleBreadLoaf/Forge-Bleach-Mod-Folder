package littlebreadloaf.world.biomes;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;

public class HuecoMundoBiome extends BiomeGenBase
{

	public HuecoMundoBiome(int id)
	{
		super(id, true);
		this.setBiomeName("Hueco Mundo");
		this.setDisableRain();
		this.setTemperatureRainfall(0.5F, 0.0F);
		this.setMinMaxHeight(0.5F, 0.6F);
		
		this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
        
        this.theBiomeDecorator.treesPerChunk = -999;
        this.theBiomeDecorator.flowersPerChunk = -999;
        this.theBiomeDecorator.grassPerChunk = -999;
        this.theBiomeDecorator.mushroomsPerChunk = 0;
        
        this.topBlock = (byte) Block.grass.blockID;
        this.fillerBlock = (byte) Block.blockClay.blockID;
	}

    /**
     * takes temperature, returns color
     */
	@SideOnly(Side.CLIENT)
	@Override
    public int getSkyColorByTemp(float par1)
    {
        return 0;
    }
}
