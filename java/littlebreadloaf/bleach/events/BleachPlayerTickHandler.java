package littlebreadloaf.bleach.events;

import littlebreadloaf.bleach.items.BleachItems;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class BleachPlayerTickHandler 
{

	private int armorBonus = 3;
	
	private boolean countPoints = true;
	
	private int flapCountdown = 23;


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
						
					}
				}	
			}
		
			if(player.isAirBorne && player.isSneaking() && player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() == BleachItems.shikaiwind)
			{
				player.motionY = -0.3 + (float)((props.getCurrentEnergy()*props.getCurrentCap())/(float)10000);
				player.moveFlying(player.moveStrafing, player.moveForward, 0.12F + (float)((props.getCurrentEnergy()*props.getCurrentCap())/(float)10000));
        		
			}
			
			
			//props.setBack(3);
			
//			if(player instanceof EntityPlayerSP)
//			{
//				EntityPlayerSP SPPlayer = (EntityPlayerSP)player;
//				--flapCountdown;
//				
//				if(player.isAirBorne  && props.getFaction() == 3 && props.getBack() == 3)
//				{
//					if(SPPlayer.movementInput.jump && flapCountdown <=0)
//					{
//						flapCountdown = 23;
//						player.motionY = 0.8F;
//					}
//					if(player.motionY <= -0.6 && !player.isSneaking())
//					player.motionY = -0.6F;
//					
//						player.moveFlying(player.moveStrafing, player.moveForward, 0.02F);
//					
//					
//				}
//			}
		
			
				
			
			
		
		
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
		


