 package littlebreadloaf.bleach.extras;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.EnumSet;

import littlebreadloaf.bleach.BleachModInfo;
import littlebreadloaf.bleach.armor.Armor;
import littlebreadloaf.bleach.events.ExtendedPlayer;
import littlebreadloaf.bleach.events.FlashPacket;
import littlebreadloaf.bleach.items.BleachItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.KeyBindingRegistry.KeyHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class MaskKeyBind extends KeyHandler
{
		public static boolean keyPressed = false;
		private Minecraft mc = Minecraft.getMinecraft();
         private EnumSet tickTypes = EnumSet.of(TickType.CLIENT);
        
         public MaskKeyBind(KeyBinding[] keyBindings, boolean[] repeatings)
         {
                 super(keyBindings, repeatings);
         }
         @Override
         public String getLabel()
         {
                 return "HollowMask";
         }
         @Override
         public void keyDown(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd, boolean isRepeat)
         {
                this.keyPressed = true;
                if(tickEnd && FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT && FMLClientHandler.instance().getClient().inGameHasFocus)
                {
                	EntityClientPlayerMP player = FMLClientHandler.instance().getClient().thePlayer;
                	if(player.getCurrentArmor(3) == null)
                	{
                     	player.sendQueue.addToSendQueue(FlashPacket.getPacket((byte)0));
                	}
                }
               
         }
         @Override
         public void keyUp(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd)
         {
                 this.keyPressed = false;
         }
         @Override
         public EnumSet<TickType> ticks()
         {
                 return tickTypes;
         }
}