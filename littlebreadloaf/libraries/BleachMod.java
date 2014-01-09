package littlebreadloaf.libraries;

import littlebreadloaf.commands.CommandResetSpirit;
import littlebreadloaf.commands.CommandResetType;
import littlebreadloaf.commands.CommandSetFaction;
import littlebreadloaf.commands.CommandSetSpirit;
import littlebreadloaf.commands.CommandSetType;
import littlebreadloaf.commands.CommandSpirit;
import littlebreadloaf.entities.classes.CustomSpawner;
import littlebreadloaf.events.DataHandler;
import littlebreadloaf.extras.OreGenerator;
import littlebreadloaf.gui.GuiHandler;
import littlebreadloaf.items.Items;
import littlebreadloaf.proxies.CommonProxy;
import littlebreadloaf.world.HuecoMundoWorldProvider;
import littlebreadloaf.world.biomes.BleachBiomes;
import net.minecraft.command.ICommandManager;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.item.Item;
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
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = BleachModInfo.ID, name = BleachModInfo.NAME, version = BleachModInfo.VERSION)
@NetworkMod(channels = { BleachModInfo.CHANNEL, "Deactivate", "Mask", "Flash" }, clientSideRequired = true, serverSideRequired = true, packetHandler = PacketHandler.class)
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
		
        new BleachBiomes();
		
        DimensionManager.registerProviderType(Ids.worldHuecoMundoID, HuecoMundoWorldProvider.class, false);
        DimensionManager.registerDimension(Ids.worldHuecoMundoID, Ids.worldHuecoMundoID);
       
	}

	@EventHandler
	public static void init(FMLInitializationEvent event)
	{

		proxy.loadParts();
		// Items.init();
		// Items.addNames();

		// Blocks.init();
		// Blocks.addNames();

		// Armor.init();
		// Armor.addNames();

		new GuiHandler();

		Recipes.init();

		// Entities.init();
		// Entities.addNames();

		proxy.loadKeys();

		GameRegistry.registerWorldGenerator(new OreGenerator());

		MinecraftForge.EVENT_BUS.register(new DataHandler());

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
