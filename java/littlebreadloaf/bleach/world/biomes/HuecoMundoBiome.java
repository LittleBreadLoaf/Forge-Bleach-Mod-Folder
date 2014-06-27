package littlebreadloaf.bleach.world.biomes;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;

public class HuecoMundoBiome extends BiomeGenBase
{

	public HuecoMundoBiome(int id)
	{
		super(id);
        this.theBiomeDecorator = new HuecoMundoBiomeDecorator();
		this.setBiomeName("Hueco Mundo");
		this.setDisableRain();
		this.setTemperatureRainfall(0.5F, 0.0F);
		this.setHeight(height_Default);
		
		this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
        
        
        this.topBlock =  Blocks.grass;
        this.fillerBlock =  Blocks.clay;
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
