package littlebreadloaf.bleach.events;

import littlebreadloaf.bleach.BleachMod;
import littlebreadloaf.bleach.armor.Armor;
import littlebreadloaf.bleach.items.BleachItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class BleachPlayerTickHandler 
{

	private int armorBonus = 3;
	
	private boolean countPoints = true;
	
	@SubscribeEvent
	public void onPlayerTick(PlayerTickEvent event)
	{
		EntityPlayer player = event.player;
		ExtendedPlayer props = (ExtendedPlayer) player.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);
		
		ItemStack chest = player.getCurrentArmor(3);
		ItemStack legs = player.getCurrentArmor(2);
		ItemStack shoes = player.getCurrentArmor(1);
		
		
			for(int j = -1; j<=1; ++j)
			{
				for(int k = -1; k <= 1; ++k)
				{
					if(player.worldObj.getBlock((int)(player.posX), (int)(player.posY + j), (int)(player.posZ + k)) != Blocks.air && !props.getValidFlash())
					{
						props.setValidFlash(true);
						props.setStickTimer(60);
						
					}
				}	
			}
		
		
		
		
		
		//Armor Sets
		
		
		//Prop Stuff
		
		if(props.getCurrentCap() < 50)
		{
			props.setCapMin();
		}
		if(props.getCurrentCap() > 1000)
		{
			props.setCapMax();
		}
		if(props.getCurrentSXP() >= 1.0)
     	{
     		props.addCap();
     	}
	
		props.balanceTotal();
		
		
		
		
		
		if(props.getPoints(1) < 0)
		{
    		props.setPoints(1, 0);
		}  

		else if(props.getPoints(2) < 0)
		{
    		props.setPoints(2, 0);
    		
		} 

		else if(props.getPoints(3) < 0)
		{
    		props.setPoints(3, 0);
		}  

		else if(props.getPoints(4) < 0)
		{
    		props.setPoints(4, 0);
    	
		}  

		else if(props.getPoints(5) < 0)
		{
    		props.setPoints(5, 0);
    		
		}  

		else if(props.getPoints(6) < 0)
		{
    		props.setPoints(6, 0);
    		
		}  

		else if(props.getPoints(7) < 0)
		{
    		props.setPoints(7, 0);
    	
		} 

		else if(props.getPoints(8) < 0)
		{
    		props.setPoints(8, 0);
    	
		} 		
	}
	}
		


