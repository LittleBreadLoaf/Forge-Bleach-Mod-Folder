package littlebreadloaf.world;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import littlebreadloaf.libraries.BleachMod;
import littlebreadloaf.libraries.Ids;
import littlebreadloaf.render.SkyRendererHuecoMundo;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
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
	@SideOnly(Side.CLIENT)
	@Override
	public float[] calcSunriseSunsetColors(float par1, float par2)
	{
		return null;
	}

	/**
	 * Returns 'true' if in the "main surface world", but 'false' if in the
	 * Nether or End dimensions.
	 */
	@SideOnly(Side.CLIENT)
	@Override
	public boolean isSurfaceWorld()
	{
		return false;
	}

	/**
	 * Calculates the angle of sun and moon in the sky relative to a specified
	 * time (usually worldTime)
	 */
	@Override
	public float calculateCelestialAngle(long par1, float par3)
	{
		int j = (int) (par1 % 24000L);
		float f1 = ((float) j + par3) / 24000.0F - 0.25F;

		if (f1 < 0.0F)
		{
			++f1;
		}

		if (f1 > 1.0F)
		{
			--f1;
		}

		float f2 = f1;
		f1 = 1.0F - (float) ((Math.cos((double) f1 * Math.PI) + 1.0D) / 2.0D);
		f1 = f2 + (f1 - f2) / 3.0F;
		return f1;
	}

	/**
	 * Return Vec3D with biome specific fog color
	 */
	@SideOnly(Side.CLIENT)
	@Override
	public Vec3 getFogColor(float par1, float par2)
	{
		float f2 = MathHelper.cos(par1 * (float) Math.PI * 2.0F) * 2.0F + 0.5F;

		if (f2 < 0.0F)
		{
			f2 = 0.0F;
		}

		if (f2 > 1.0F)
		{
			f2 = 1.0F;
		}

		float f3 = 0.7529412F;
		float f4 = 0.84705883F;
		float f5 = 1.0F;
		f3 *= f2 * 0.94F + 0.06F;
		f4 *= f2 * 0.94F + 0.06F;
		f5 *= f2 * 0.91F + 0.09F;
		return this.worldObj.getWorldVec3Pool().getVecFromPool((double) f3, (double) f4, (double) f5);
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