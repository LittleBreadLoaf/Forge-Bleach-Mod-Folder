package littlebreadloaf.bleach.extras;

import littlebreadloaf.bleach.BleachMod;
import littlebreadloaf.bleach.armor.Armor;
import littlebreadloaf.bleach.events.ExtendedPlayer;
import littlebreadloaf.bleach.network.ActivateMessage;
import littlebreadloaf.bleach.network.DeactivateMessage;
import littlebreadloaf.bleach.network.FlashMessage;
import littlebreadloaf.bleach.network.GuiMessage;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent.KeyInputEvent;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
public class BleachKeyHandler
{
	/** Key index for easy handling */
	public static final int FLASH = 0;
	public static final int ACTIVATE = 1;
	public static final int DEACTIVATE = 2;
	public static final int HOLLOW = 3;
	Minecraft mc = Minecraft.getMinecraft();
	EntityPlayer Player = mc.thePlayer;

	
	/** Key descriptions; use a language file to localize the description later */
	private static final String[] desc = {"key.flash.desc", "key.activate.desc", "key.deactivate.desc", "key.hollow.desc"};
	
	/** Default key values */
	private static final int[] keyValues = {Keyboard.KEY_C, Keyboard.KEY_X, Keyboard.KEY_Z, Keyboard.KEY_V};
	private final KeyBinding[] keys;
	
	public BleachKeyHandler() {
		keys = new KeyBinding[desc.length];
		for(int i = 0; i < desc.length; ++i) {
			keys[i] = new KeyBinding(desc[i], keyValues[i], "key.bleach.category");
			ClientRegistry.registerKeyBinding(keys[i]);
		}
	}
	/**
	 * KeyInputEvent is in the FML package, so we must register to the FML event bus
	 */	
	@SubscribeEvent
	public void onKeyInput(KeyInputEvent event) {

		if (FMLClientHandler.instance().getClient().inGameHasFocus);
		{
			if (keys[FLASH].isPressed()) 
			{
				BleachMod.network.sendToServer(new FlashMessage(1)); 	    	
			}
			if (keys[ACTIVATE].isPressed()) 
			{
				BleachMod.network.sendToServer(new ActivateMessage());
			}
			if (keys[DEACTIVATE].isPressed()) 
			{
				BleachMod.network.sendToServer(new DeactivateMessage());
			}
			if(keys[HOLLOW].isPressed())
			{
				BleachMod.network.sendToServer(new FlashMessage(4)); 
			}
			
		}
	}
}