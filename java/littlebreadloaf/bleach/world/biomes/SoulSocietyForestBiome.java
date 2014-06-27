package littlebreadloaf.bleach.world.biomes;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SoulSocietyForestBiome extends BiomeGenBase
{

	public SoulSocietyForestBiome(int id)
	{
		super(id);
        this.theBiomeDecorator = new SoulSocietyBiomeDecorator();
		this.setBiomeName("Soul Society");
		this.setDisableRain();
		this.setTemperatureRainfall(0.5F, 0.0F);
		this.setHeight(height_Default);
		
		this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
        
        
        this.topBlock =  Blocks.grass;
        this.fillerBlock = Blocks.stone;
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
