package littlebreadloaf.world;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import littlebreadloaf.libraries.BleachMod;
import littlebreadloaf.libraries.Ids;
import littlebreadloaf.render.SkyRendererHuecoMundo;
import net.minecraft.entity.Entity;
import net.minecraft.util.Vec3;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;

public class HuecoMundoWorldProvider extends WorldProvider
{
	@Override
	public void registerWorldChunkManager()
	{
		this.dimensionId = Ids.worldHuecoMundoID;
		this.worldChunkMgr = new HuecoMundoChunkManager(this.worldObj);
		this.hasNoSky = true;
		if (FMLClientHandler.instance().getSide() == Side.CLIENT)
		{
			this.setSkyRenderer(new SkyRendererHuecoMundo());
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Vec3 getSkyColor(Entity cameraEntity, float partialTicks)
	{
		return Vec3.createVectorHelper(0.1D, 0.1D, 0.1D);
	}

	/**
     * Returns array with sunrise/sunset colors
     */
	@Override
    public float[] calcSunriseSunsetColors(float par1, float par2)
    {
        return null;
    }
	
    /**
     * Returns true if the given X,Z coordinate should show environmental fog.
     */
	@SideOnly(Side.CLIENT)
	@Override
    public boolean doesXZShowFog(int par1, int par2)
    {
        return true;
    }
    
	@Override
	public IChunkProvider createChunkGenerator()
	{
		return new HuecoMundoChunkProvider(this.worldObj, this.worldObj.getSeed(), true);
	}

	@Override
	public boolean isDaytime()
	{
		return false;
	}

	@Override
	public int getActualHeight()
	{
		return 256;
	}

	@Override
	public boolean canDoLightning(Chunk chunk)
	{
		return false;
	}

	@Override
	public void generateLightBrightnessTable()
	{
		float f = 0.005F;
		for (int i = 0; i <= 15; i++)
		{
			float f1 = 1.0F - i / 15.0F;
			this.lightBrightnessTable[i] = ((1.0F - f1) / (f1 * 3.0F + 1.0F) * (1.0F - f) + f);
		}
	}

	@Override
	public boolean canDoRainSnowIce(Chunk chunk)
	{
		return false;
	}

	@Override
	public String getDimensionName()
	{
		return "Hueco Mundo";// TODO: add localization
	}
}