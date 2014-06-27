package littlebreadloaf.bleach;

import littlebreadloaf.bleach.armor.Armor;
import littlebreadloaf.bleach.blocks.BleachBlocks;
import littlebreadloaf.bleach.commands.CommandResetSpirit;
import littlebreadloaf.bleach.commands.CommandResetType;
import littlebreadloaf.bleach.commands.CommandSetFaction;
import littlebreadloaf.bleach.commands.CommandSetSpirit;
import littlebreadloaf.bleach.commands.CommandSetType;
import littlebreadloaf.bleach.commands.CommandSpirit;
import littlebreadloaf.bleach.commands.CommandToggle3D;
import littlebreadloaf.bleach.entities.Entities;
import littlebreadloaf.bleach.events.BleachEvents;
import littlebreadloaf.bleach.events.BleachPipeline;
import littlebreadloaf.bleach.events.BleachPlayerTickHandler;
import littlebreadloaf.bleach.events.PacketActivate;
import littlebreadloaf.bleach.events.PacketDeactivate;
import littlebreadloaf.bleach.events.PacketFlash;
import littlebreadloaf.bleach.events.PacketParticle;
import littlebreadloaf.bleach.events.PacketSync;
import littlebreadloaf.bleach.extras.OreGenerator;
import littlebreadloaf.bleach.gui.GuiHandler;
import littlebreadloaf.bleach.items.BleachItems;
import littlebreadloaf.bleach.proxies.CommonProxy;
import littlebreadloaf.bleach.tiles.TileLantern;
import littlebreadloaf.bleach.tiles.TileSeeleSchneider;
import littlebreadloaf.bleach.tiles.TileSphereLamp;
import littlebreadloaf.bleach.world.BleachWorldGen;
import littlebreadloaf.bleach.world.HuecoMundoWorldProvider;
import littlebreadloaf.bleach.world.SoulSocietyWorldProvider;
import littlebreadloaf.bleach.world.biomes.BleachBiomes;
import net.minecraft.command.ICommandManager;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;

@Mod(modid = BleachModInfo.ID, name = BleachModInfo.NAME, version = BleachModInfo.VERSION)
public class BleachMod
{
	@SidedProxy(clientSide = BleachModInfo.PROXY_LOCATION + ".ClientProxy", serverSide = BleachModInfo.PROXY_LOCATION + ".CommonProxy")
	public static CommonProxy proxy;

	@Instance(BleachModInfo.ID)
	public static BleachMod instance;


	@EventHandler
	public static void preInit(FMLPreInitializationEvent event)
	{

			
		BleachItems.init();
		BleachItems.registerItems();

		BleachBlocks.init();
		BleachBlocks.registerBlocks();
		proxy.initRenderers();
		ConfigHandler.init(event.getSuggestedConfigurationFile());
	
		GameRegistry.registerWorldGenerator(new BleachWorldGen(), 0);
		new BleachBiomes();

		DimensionManager.registerProviderType(BleachIds.worldHuecoMundoID, HuecoMundoWorldProvider.class, false);
		DimensionManager.registerDimension(BleachIds.worldHuecoMundoID, BleachIds.worldHuecoMundoID);

		DimensionManager.registerProviderType(BleachIds.worldSoulSocietyID, SoulSocietyWorldProvider.class, false);
		DimensionManager.registerDimension(BleachIds.worldSoulSocietyID, BleachIds.worldSoulSocietyID);
		

	}

	public static final BleachPipeline packetPipeline = new BleachPipeline();
	@EventHandler
	public static void init(FMLInitializationEvent event)
	{

		packetPipeline.initialise();
		
		
		Entities.init();

		Armor.init();
		Armor.registerItems();

		new GuiHandler();
		FMLCommonHandler.instance().bus().register(new BleachPlayerTickHandler());
		Recipes.init();

		GameRegistry.registerWorldGenerator(new OreGenerator(), 0);

		MinecraftForge.EVENT_BUS.register(new BleachEvents());
		proxy.loadKeys();

		GameRegistry.registerTileEntity(TileSphereLamp.class, "TileSphereLamp");
		GameRegistry.registerTileEntity(TileLantern.class, "TileLantern");
		GameRegistry.registerTileEntity(TileSeeleSchneider.class, "TileSeeleschneider");

		
		proxy.initZanpakutoRenderers();
	}

	@EventHandler
	public static void postInit(FMLPostInitializationEvent event)
	{
		packetPipeline.postInitialise();
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
		serverCommand.registerCommand(new CommandToggle3D());
	}
	

}
