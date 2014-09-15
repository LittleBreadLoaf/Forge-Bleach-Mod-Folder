package littlebreadloaf.bleach.proxies;

import java.util.HashMap;

import littlebreadloaf.bleach.BleachMod;
import littlebreadloaf.bleach.events.BleachPlayerTickHandler;
import littlebreadloaf.bleach.network.ActivateMessage;
import littlebreadloaf.bleach.network.ClientSyncMessage;
import littlebreadloaf.bleach.network.DeactivateMessage;
import littlebreadloaf.bleach.network.FlashMessage;
import littlebreadloaf.bleach.network.ParticleMessage;
import littlebreadloaf.bleach.network.ServerSyncMessage;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;

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
		return extendedEntityData.remove(name);
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
	
	public ModelBiped getArmorModel(int id)
	{
		return null;
	}
	
	public void loadMessages()
	{

	}
	
	public EntityPlayer getPlayerFromMessage(MessageContext ctx)
	{
		return ctx.getServerHandler().playerEntity;
	}

}
