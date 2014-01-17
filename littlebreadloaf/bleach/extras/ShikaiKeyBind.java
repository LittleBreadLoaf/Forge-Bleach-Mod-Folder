package littlebreadloaf.bleach.extras;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.EnumSet;

import littlebreadloaf.bleach.BleachModInfo;
import littlebreadloaf.bleach.events.ExtendedPlayer;
import littlebreadloaf.bleach.items.BleachItems;
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
             	   if(heldItem.itemID == BleachItems.shikaifire.itemID || heldItem.itemID == BleachItems.shikaiice.itemID
             		|| heldItem.itemID == BleachItems.shikaipoison.itemID || heldItem.itemID == BleachItems.shikaiheal.itemID
             		|| heldItem.itemID == BleachItems.shikaiearth.itemID || heldItem.itemID == BleachItems.shikaiwind.itemID 
             		|| heldItem.itemID == BleachItems.shikailight.itemID || heldItem.itemID == BleachItems.shikaidark.itemID 
             		|| heldItem.itemID == BleachItems.shikailightning.itemID || heldItem.itemID == BleachItems.shikailunar.itemID 
             		|| heldItem.itemID == BleachItems.shikaiwater.itemID || heldItem.itemID == BleachItems.shikainormal.itemID  )
             	   {
             		  props.syncThings(BleachItems.zanpakuto.itemID);
             		  heldItem.itemID = BleachItems.zanpakuto.itemID;
                     
             	   }
             	   else if(heldItem.itemID == BleachItems.quincybow.itemID)
             	   {
             		   props.syncThings(BleachItems.quincybow.itemID);
             		   ItemStack Pendant = new ItemStack(BleachItems.quincypendant, 1, 1);
             		   heldItem.itemID = Pendant.itemID;
             		   heldItem.setItemDamage(0);
             	   }
             	   else if(heldItem.itemID == BleachItems.quincyweb.itemID)
             	   {
             		   props.syncThings(BleachItems.quincyweb.itemID);
             		   ItemStack Pendant = new ItemStack(BleachItems.quincypendant,1,2);
             		   heldItem.itemID = Pendant.itemID;
             		   heldItem.setItemDamage(1);
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