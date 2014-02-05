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
import littlebreadloaf.bleach.events.BleachEvents;
import littlebreadloaf.bleach.events.BleachEvents;
import littlebreadloaf.bleach.extras.OreGenerator;
import littlebreadloaf.bleach.gui.GuiHandler;
import littlebreadloaf.bleach.items.BleachItems;
import littlebreadloaf.bleach.proxies.CommonProxy;
import littlebreadloaf.bleach.tiles.TileLantern;
import littlebreadloaf.bleach.tiles.TileSeeleSchneider;
import littlebreadloaf.bleach.tiles.TileSphereLamp;
import littlebreadloaf.bleach.world.BleachWorldGen;
import littlebreadloaf.bleach.world.HuecoMundoWorldProvider;
import littlebreadloaf.bleach.world.biomes.BleachBiomes;
import me.dawars.CraftingPillars.api.CraftingPillarAPI;
import net.minecraft.command.ICommandManager;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Loader;
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


		new GuiHandler();

		Recipes.init();

		proxy.loadKeys();

		GameRegistry.registerWorldGenerator(new OreGenerator());

		MinecraftForge.EVENT_BUS.register(new BleachEvents());

		GameRegistry.registerTileEntity(TileSphereLamp.class, "TileSphereLamp");
		GameRegistry.registerTileEntity(TileLantern.class, "TileLantern");
		GameRegistry.registerTileEntity(TileSeeleSchneider.class, "TileSeeleschneider");

		proxy.initZanpakutoRenderers();
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
	
	@EventHandler
	public void modsLoaded(FMLPostInitializationEvent evt)
	{
		if(Loader.isModLoaded("craftingpillars"))
		{
			CraftingPillarAPI.addDiskTexture(BleachItems.recordAsterisk.itemID, BleachModInfo.ID + ":textures/models/disk_astrisk.png");
			CraftingPillarAPI.addDiskTexture(BleachItems.recordEscalon.itemID, BleachModInfo.ID + ":textures/models/disk_Escalon.png");
			CraftingPillarAPI.addDiskTexture(BleachItems.recordNumberOne.itemID, BleachModInfo.ID + ":textures/models/disk_number_one.png");
		}
	}
}
