package littlebreadloaf.bleach.proxies;

import java.util.HashMap;

import littlebreadloaf.bleach.events.BleachPlayerTickHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.server.FMLServerHandler;

public class CommonProxy implements IGuiHandler
{

	private static HashMap<String, NBTTagCompound> extendedEntityData = new HashMap<String, NBTTagCompound>();

	public void initRenderers()
	{

	}


	public int addArmor(String string)
	{
		return 0;
	}

	@Override
	public Object getServerGuiElement(int guiId, EntityPlayer player, World world, int x, int y, int z)
	{
		return null;
	}

	@Override
	public Object getClientGuiElement(int guiId, EntityPlayer player, World world, int x, int y, int z)
	{
		return null;
	}

	public static void storeEntityData(String name, NBTTagCompound compound)
	{
		extendedEntityData.put(name, compound);
	}

	public static NBTTagCompound getEntityData(String name)
	{
		NBTTagCompound entityData = extendedEntityData.get(name);
		extendedEntityData.remove(name);
		return entityData;
	}

	public void loadParts()
	{
		FMLCommonHandler.instance().bus().register(new BleachPlayerTickHandler());
	}

	public void loadGUI()
	{

	}

	public void loadKeys()
	{

	}

	public void initZanpakutoRenderers()
	{

	}


	

}
