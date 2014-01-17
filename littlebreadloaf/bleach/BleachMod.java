package littlebreadloaf.bleach;

import littlebreadloaf.bleach.armor.Armor;
import littlebreadloaf.bleach.blocks.BleachBlocks;
import littlebreadloaf.bleach.commands.CommandResetSpirit;
import littlebreadloaf.bleach.commands.CommandResetType;
import littlebreadloaf.bleach.commands.CommandSetFaction;
import littlebreadloaf.bleach.commands.CommandSetSpirit;
import littlebreadloaf.bleach.commands.CommandSetType;
import littlebreadloaf.bleach.commands.CommandSpirit;
import littlebreadloaf.bleach.entities.Entities;
import littlebreadloaf.bleach.events.DataHandler;
import littlebreadloaf.bleach.extras.OreGenerator;
import littlebreadloaf.bleach.gui.GuiHandler;
import littlebreadloaf.bleach.items.BleachItems;
import littlebreadloaf.bleach.proxies.CommonProxy;
import littlebreadloaf.bleach.tiles.TileSphereLamp;
import littlebreadloaf.bleach.world.BleachWorldGen;
import littlebreadloaf.bleach.world.HuecoMundoWorldProvider;
import littlebreadloaf.bleach.world.biomes.BleachBiomes;
import net.minecraft.command.ICommandManager;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = BleachModInfo.ID, name = BleachModInfo.NAME, version = BleachModInfo.VERSION)
@NetworkMod(channels =
{ BleachModInfo.CHANNEL, "Deactivate", "Mask", "Flash" }, clientSideRequired = true, serverSideRequired = true, packetHandler = PacketHandler.class)
public class BleachMod
{
	@SidedProxy(clientSide = BleachModInfo.PROXY_LOCATION + ".ClientProxy", serverSide = BleachModInfo.PROXY_LOCATION + ".CommonProxy")
	public static CommonProxy proxy;

	@Instance(BleachModInfo.ID)
	public static BleachMod instance;

	// public static Item customSpawner;

	@EventHandler
	public static void preInit(FMLPreInitializationEvent event)
	{
		proxy.initRenderers();
		proxy.registerServerTickHandler();
		ConfigHandler.init(event.getSuggestedConfigurationFile());

		GameRegistry.registerWorldGenerator(new BleachWorldGen());
		new BleachBiomes();

		DimensionManager.registerProviderType(BleachIds.worldHuecoMundoID, HuecoMundoWorldProvider.class, false);
		DimensionManager.registerDimension(BleachIds.worldHuecoMundoID, BleachIds.worldHuecoMundoID);

	}

	@EventHandler
	public static void init(FMLInitializationEvent event)
	{

//		proxy.loadParts();
		BleachItems.init();
		BleachItems.addNames();

		BleachBlocks.init();
		BleachBlocks.addNames();

		Entities.addNames();
		Entities.init();

		Armor.init();
		Armor.addNames();

		proxy.initZanpakutoRenderers();

		new GuiHandler();

		Recipes.init();

		proxy.loadKeys();

		GameRegistry.registerWorldGenerator(new OreGenerator());

		MinecraftForge.EVENT_BUS.register(new DataHandler());

		GameRegistry.registerTileEntity(TileSphereLamp.class, "TileSphereLamp");

	}

	@EventHandler
	public static void postInit(FMLPostInitializationEvent event)
	{

		proxy.loadGUI();
	}

	@EventHandler
	public void serverStart(FMLServerStartingEvent event)
	{
		MinecraftServer server = MinecraftServer.getServer();
		ICommandManager command = server.getCommandManager();
		ServerCommandManager serverCommand = ((ServerCommandManager) command);

		serverCommand.registerCommand(new CommandResetSpirit());
		serverCommand.registerCommand(new CommandResetType());
		serverCommand.registerCommand(new CommandSetSpirit());
		serverCommand.registerCommand(new CommandSetType());
		serverCommand.registerCommand(new CommandSpirit());
		serverCommand.registerCommand(new CommandSetFaction());
	}
}
