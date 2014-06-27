package littlebreadloaf.bleach.proxies;

import littlebreadloaf.bleach.BleachIds;
import littlebreadloaf.bleach.entities.EntityEnergyArrow;
import littlebreadloaf.bleach.entities.EntityGetsuga;
import littlebreadloaf.bleach.entities.EntitySeeleArrow;
import littlebreadloaf.bleach.events.BleachPlayerTickHandler;
import littlebreadloaf.bleach.events.BleachSounds;
import littlebreadloaf.bleach.extras.BleachKeyHandler;
import littlebreadloaf.bleach.gui.GuiSoulBar;
import littlebreadloaf.bleach.items.BleachItems;
import littlebreadloaf.bleach.render.RenderLantern;
import littlebreadloaf.bleach.render.RenderSphereLamp;
import littlebreadloaf.bleach.render.SeeleSchneiderBlockRenderer;
import littlebreadloaf.bleach.render.SeeleSchneiderRenderer;
import littlebreadloaf.bleach.render.ZanpakutoRenderer;
import littlebreadloaf.bleach.render.entity.RenderEnergyArrow;
import littlebreadloaf.bleach.render.entity.RenderGetsuga;
import littlebreadloaf.bleach.render.entity.RenderSeeleArrow;
import littlebreadloaf.bleach.render.entity.Renders;
import littlebreadloaf.bleach.tiles.TileLantern;
import littlebreadloaf.bleach.tiles.TileSeeleSchneider;
import littlebreadloaf.bleach.tiles.TileSphereLamp;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;

public class ClientProxy extends CommonProxy
{
	@Override
	public void initRenderers()
	{
		BleachIds.sphereLampRenderID = RenderingRegistry.getNextAvailableRenderId();
		BleachIds.lanternRenderingID = RenderingRegistry.getNextAvailableRenderId();
		BleachIds.seeleSchneiderRenderingID = RenderingRegistry.getNextAvailableRenderId();

		RenderingRegistry.registerEntityRenderingHandler(EntityEnergyArrow.class, new RenderEnergyArrow());
		RenderingRegistry.registerEntityRenderingHandler(EntitySeeleArrow.class, new RenderSeeleArrow());
		RenderingRegistry.registerEntityRenderingHandler(EntityGetsuga.class, new RenderGetsuga());
		Renders.renderEntities();

		MinecraftForge.EVENT_BUS.register(new BleachSounds());
	}

	@Override
	public void initZanpakutoRenderers()
	{
		
		MinecraftForgeClient.registerItemRenderer(BleachItems.zanpakuto, new ZanpakutoRenderer());
		MinecraftForgeClient.registerItemRenderer(BleachItems.seele, new SeeleSchneiderRenderer());
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileSphereLamp.class, new RenderSphereLamp());
		ClientRegistry.bindTileEntitySpecialRenderer(TileLantern.class, new RenderLantern());
		ClientRegistry.bindTileEntitySpecialRenderer(TileSeeleSchneider.class, new SeeleSchneiderBlockRenderer());
		
		RenderingRegistry.registerBlockHandler(new RenderSphereLamp());
		RenderingRegistry.registerBlockHandler(new RenderLantern());

	}

	@Override
	public void loadParts()
	{
		FMLCommonHandler.instance().bus().register(new BleachPlayerTickHandler());
	}

	@Override
	public int addArmor(String string)
	{
		return RenderingRegistry.addNewArmourRendererPrefix(string);
	}

	@Override
	public void loadGUI()
	{
		MinecraftForge.EVENT_BUS.register(new GuiSoulBar(Minecraft.getMinecraft()));
	}

	@Override
	public void loadKeys()
	{

		FMLCommonHandler.instance().bus().register(new BleachKeyHandler());
	}



}
