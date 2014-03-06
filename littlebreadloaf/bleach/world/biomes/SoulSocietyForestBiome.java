package littlebreadloaf.bleach.world.biomes;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;

public class SoulSocietyForestBiome extends BiomeGenBase
{

	public SoulSocietyForestBiome(int id)
	{
		super(id);
        this.theBiomeDecorator = new SoulSocietyBiomeDecorator(this);
		this.setBiomeName("Soul Society");
		this.setDisableRain();
		this.setTemperatureRainfall(0.5F, 0.0F);
		this.setMinMaxHeight(0.5F, 0.6F);
		
		this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
        
        
        this.topBlock = (byte) Block.grass.blockID;
        this.fillerBlock = (byte) Block.stone.blockID;
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
