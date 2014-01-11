package littlebreadloaf.proxies;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.src.ModLoader;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import littlebreadloaf.armor.Armor;
import littlebreadloaf.blocks.Blocks;
import littlebreadloaf.entities.classes.Entities;
import littlebreadloaf.entities.classes.EntityEnergyArrow;
import littlebreadloaf.entities.classes.EntityGetsuga;
import littlebreadloaf.entities.classes.EntitySeeleArrow;
import littlebreadloaf.entities.renders.RenderEnergyArrow;
import littlebreadloaf.entities.renders.RenderGetsuga;
import littlebreadloaf.entities.renders.RenderSeeleArrow;
import littlebreadloaf.entities.renders.Renders;
import littlebreadloaf.extras.FlashKeyBind;
import littlebreadloaf.extras.MaskKeyBind;
import littlebreadloaf.extras.ShikaiKeyBind;
import littlebreadloaf.gui.GuiSoulBar;
import littlebreadloaf.items.Items;
import littlebreadloaf.libraries.BleachSounds;
import littlebreadloaf.libraries.Recipes;
import littlebreadloaf.render.ZanpakutoRenderer;
import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;


public class ClientProxy extends CommonProxy
{
	@Override
	public void initRenderers()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityEnergyArrow.class, new RenderEnergyArrow());
		RenderingRegistry.registerEntityRenderingHandler(EntitySeeleArrow.class, new RenderSeeleArrow());
		RenderingRegistry.registerEntityRenderingHandler(EntityGetsuga.class, new RenderGetsuga());
		Renders.renderEntities();

		MinecraftForge.EVENT_BUS.register(new BleachSounds());
	}
	
	@Override
	public void initZanpakutoRenderers()
	{
		MinecraftForgeClient.registerItemRenderer(Items.zanpakuto.itemID, new ZanpakutoRenderer());
	}
	
	@Override
	public void loadParts()
	{
		Items.init();
		Items.addNames();
		
		Blocks.init();
		Blocks.addNames();
		
		Entities.addNames();
		Entities.init();
		
		Armor.init();
		Armor.addNames();
		
		
		
		
	}
	
	@Override
	public int addArmor(String string)
	{
		return ModLoader.addArmor(string);
	}
	
	@Override
	public void loadGUI()
	{
		MinecraftForge.EVENT_BUS.register(new GuiSoulBar(Minecraft.getMinecraft()));
	}
	
	@Override
	public void loadKeys()
	{
		KeyBinding[] shikaiKey = {new KeyBinding("Deactivate", Keyboard.KEY_Z)};
		boolean[] repeat = {false};
		KeyBindingRegistry.registerKeyBinding(new ShikaiKeyBind(shikaiKey, repeat));
		
		KeyBinding[] flashStepKey = {new KeyBinding("Flash Step", Keyboard.KEY_X)};
		KeyBindingRegistry.registerKeyBinding(new FlashKeyBind(flashStepKey, repeat));
		

		KeyBinding[] maskKey = {new KeyBinding("Hollow Mask", Keyboard.KEY_C)};
		KeyBindingRegistry.registerKeyBinding(new MaskKeyBind(maskKey, repeat));
	}
	
	

}
