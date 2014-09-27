package littlebreadloaf.bleach.proxies;

import littlebreadloaf.bleach.BleachIds;
import littlebreadloaf.bleach.BleachMod;
import littlebreadloaf.bleach.entities.EntityBlock;
import littlebreadloaf.bleach.entities.EntityEnergyArrow;
import littlebreadloaf.bleach.entities.EntityGetsuga;
import littlebreadloaf.bleach.entities.EntitySeeleArrow;
import littlebreadloaf.bleach.events.BleachPlayerTickHandler;
import littlebreadloaf.bleach.events.BleachSounds;
import littlebreadloaf.bleach.extras.BleachKeyHandler;
import littlebreadloaf.bleach.gui.GuiSoulBar;
import littlebreadloaf.bleach.items.BleachItems;
import littlebreadloaf.bleach.network.ClientSyncMessage;
import littlebreadloaf.bleach.network.ParticleMessage;
import littlebreadloaf.bleach.player.HollowRenderer;
import littlebreadloaf.bleach.render.RenderLantern;
import littlebreadloaf.bleach.render.RenderSphereLamp;
import littlebreadloaf.bleach.render.SeeleSchneiderBlockRenderer;
import littlebreadloaf.bleach.render.SeeleSchneiderRenderer;
import littlebreadloaf.bleach.render.ZanpakutoRenderer;
import littlebreadloaf.bleach.render.entity.RenderBlock;
import littlebreadloaf.bleach.render.entity.RenderEnergyArrow;
import littlebreadloaf.bleach.render.entity.RenderGetsuga;
import littlebreadloaf.bleach.render.entity.RenderSeeleArrow;
import littlebreadloaf.bleach.render.entity.Renders;
import littlebreadloaf.bleach.render.models.armor.ModelGolemMask;
import littlebreadloaf.bleach.render.models.armor.ModelSkirt;
import littlebreadloaf.bleach.render.models.armor.ModelSnakeMask;
import littlebreadloaf.bleach.render.models.armor.ModelSoulChain;
import littlebreadloaf.bleach.render.models.armor.ModelStalkerMask;
import littlebreadloaf.bleach.render.models.armor.ModelWolfMask;
import littlebreadloaf.bleach.tiles.TileLantern;
import littlebreadloaf.bleach.tiles.TileSeeleSchneider;
import littlebreadloaf.bleach.tiles.TileSphereLamp;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;

public class ClientProxy extends CommonProxy
{
	@Override
	public void initRenderers()
	{
		BleachIds.sphereLampRenderID = RenderingRegistry.getNextAvailableRenderId();
		BleachIds.lanternRenderingID = RenderingRegistry.getNextAvailableRenderId();
		BleachIds.seeleSchneiderRenderingID = RenderingRegistry.getNextAvailableRenderId();

		//RenderingRegistry.registerEntityRenderingHandler(EntityPlayer.class, new HollowRenderer());
		RenderingRegistry.registerEntityRenderingHandler(EntityEnergyArrow.class, new RenderEnergyArrow());
		RenderingRegistry.registerEntityRenderingHandler(EntitySeeleArrow.class, new RenderSeeleArrow());
		RenderingRegistry.registerEntityRenderingHandler(EntityGetsuga.class, new RenderGetsuga());
		RenderingRegistry.registerEntityRenderingHandler(EntityBlock.class, new RenderBlock());
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

	private static final ModelSoulChain chain = new ModelSoulChain(1.0F);
	private static final ModelBiped robes = new ModelBiped(0.05F);
	private static final ModelGolemMask golem  = new ModelGolemMask(1.0F);
	private static final ModelSnakeMask snake = new ModelSnakeMask(1.0F);
	private static final ModelWolfMask wolf = new ModelWolfMask(1.0F);
	private static final ModelStalkerMask stalker = new ModelStalkerMask(0.0F);
	private static final ModelSkirt skirt = new ModelSkirt(1.0F);
	@Override
	public ModelBiped getArmorModel(int id)
	{
		switch (id){
		case 0:
			return robes;
		case 1:
			return golem;
		case 2:
			return snake;
		case 3:
			return wolf;
		case 4:
			return stalker;
		case 5:
			return skirt;
		case 21:
			return chain;
			default:
				break;
		}
		return chain;
		
	}
	
	@Override
	public EntityPlayer getPlayerFromMessage(MessageContext ctx)
	{
		return Minecraft.getMinecraft().thePlayer;
	}

	
}
