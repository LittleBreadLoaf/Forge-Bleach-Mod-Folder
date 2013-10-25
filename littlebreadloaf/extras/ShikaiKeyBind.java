package littlebreadloaf.extras;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.EnumSet;

import littlebreadloaf.events.ExtendedPlayer;
import littlebreadloaf.items.Items;
import littlebreadloaf.libraries.BleachModInfo;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.client.registry.KeyBindingRegistry.KeyHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ShikaiKeyBind extends KeyHandler
{
		public static boolean keyPressed = false;
		private Minecraft mc = Minecraft.getMinecraft();
         private EnumSet tickTypes = EnumSet.of(TickType.CLIENT);
        
         public ShikaiKeyBind(KeyBinding[] keyBindings, boolean[] repeatings)
         {
                 super(keyBindings, repeatings);
         }
         @Override
         public String getLabel()
         {
                 return "Deactivate";
         }
         @Override
         public void keyDown(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd, boolean isRepeat)
         {
                this.keyPressed = true;
                EntityPlayer player = mc.thePlayer;
                ExtendedPlayer props = (ExtendedPlayer) player.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);
           		ItemStack heldItem = player.getCurrentEquippedItem();
                
            
                if(heldItem != null )
                {
             	   if(heldItem.itemID == Items.shikaifire.itemID || heldItem.itemID == Items.shikaiice.itemID
             		|| heldItem.itemID == Items.shikaipoison.itemID || heldItem.itemID == Items.shikaiheal.itemID
             		|| heldItem.itemID == Items.shikaiearth.itemID || heldItem.itemID == Items.shikaiwind.itemID 
             		|| heldItem.itemID == Items.shikailight.itemID || heldItem.itemID == Items.shikaidark.itemID 
             		|| heldItem.itemID == Items.shikailightning.itemID || heldItem.itemID == Items.shikailunar.itemID 
             		|| heldItem.itemID == Items.shikaiwater.itemID || heldItem.itemID == Items.shikainormal.itemID  )
             	   {
             		  props.syncSwords();
             		  heldItem.itemID = Items.zanpakuto.itemID;
                     
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