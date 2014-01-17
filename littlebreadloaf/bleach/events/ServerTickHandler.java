package littlebreadloaf.bleach.events;

import java.util.EnumSet;

import org.lwjgl.input.Keyboard;

import littlebreadloaf.bleach.armor.Armor;
import littlebreadloaf.bleach.extras.ShikaiKeyBind;
import littlebreadloaf.bleach.items.BleachItems;
import net.minecraft.block.material.Material;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class ServerTickHandler implements ITickHandler 
{
	private int depleteTimer = 40;
	private int replenishTimer = 200;
	private int shikaiTimer = 20;
	private int bowTimer = 40;
	private int armorBonus = 0;
	
	public void resetReplenish()
	{
		this.replenishTimer = 1200;
	}

	private void onPlayerTick(EntityPlayer player)
	{
		ExtendedPlayer props = (ExtendedPlayer) player.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);
		--depleteTimer;
		--replenishTimer;
		ItemStack chest = player.getCurrentItemOrArmor(3);
		ItemStack legs = player.getCurrentItemOrArmor(2);
		ItemStack shoes = player.getCurrentItemOrArmor(1);
		
		
			for(int j = -1; j<=1; ++j)
			{
				for(int k = -1; k <= 1; ++k)
				{
					if(player.worldObj.getBlockId((int)(player.posX), (int)(player.posY + j), (int)(player.posZ + k)) != 0 && !props.getValidFlash())
					{
						props.setValidFlash(true);
						props.setStickTimer(60);
						
					}
				}	
			}
		
		
		if(props.getStickTimer() > 0)
		{
			props.setStickTimer(props.getStickTimer() - 1);
		}
		else
		{
			props.setStickTimer(0);
		}
		
		
		//Masks
		if(player.getCurrentItemOrArmor(4) != null)
		{
			ItemStack helmet = player.getCurrentItemOrArmor(4);
			
			
			if(helmet.getItem() == Armor.BatHelmet && props.getCurrentEnergy() > 0)
			{
				player.addPotionEffect(new PotionEffect(Potion.nightVision.getId(), 220, 0));
				if(depleteTimer <= 0)
				{
					depleteTimer = 40;
					props.consumeEnergy(1);
				}
			}
			
			if(helmet.getItem() == Armor.SpiderHelmet && props.getCurrentEnergy() > 0)
			{
				player.addPotionEffect(new PotionEffect(Potion.jump.getId(), 40, 2));
				if(depleteTimer <= 0)
				{
					depleteTimer = 40;
					props.consumeEnergy(1);
				}
			}
			
			if(helmet.getItem() == Armor.BlazeHelmet && props.getCurrentEnergy() > 0)
			{
				player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 40, 2));
				if(depleteTimer <= 0)
				{
					depleteTimer = 40;
					props.consumeEnergy(1);
				}
			}
			if(helmet.getItem() == Armor.StalkerHelmet && props.getCurrentEnergy() > 0)
			{
				player.addPotionEffect(new PotionEffect(Potion.damageBoost.getId(), 40, 0));
				if(depleteTimer <= 0)
				{
					depleteTimer = 40;
					props.consumeEnergy(1);
				}
			}
			if(helmet.getItem() == Armor.HollowHelmet && props.getCurrentEnergy() > 0)
			{
				player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 40, 1));
				player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 40, 1));
				player.addPotionEffect(new PotionEffect(Potion.resistance.id, 40, 1));
				player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 40, 0));
				
				if(depleteTimer <= 0)
				{
					depleteTimer = 40;
					props.consumeEnergy(4);
				}
			}
			
			
		}
		
		//Armor Sets
		if(replenishTimer == 0)
		{
			if(player.getCurrentItemOrArmor(3) != null)
			{
				if(chest.getItem() == Armor.ShiniRobe || chest.getItem() == Armor.QuincyRobe)
				{
					armorBonus += 2;
				}
			}
			if(player.getCurrentItemOrArmor(2) != null)
			{
				if(legs.getItem() == Armor.ShiniPants || legs.getItem() == Armor.QuincyPants)
				{
					armorBonus += 1;
				}
			}
			if(player.getCurrentItemOrArmor(1) != null)
			{
				if(shoes.getItem() == Armor.Sandals || shoes.getItem() == Armor.QuincyShoes)
				{
					armorBonus += 1;
				}
			}
			if(props.getIsShinigami())
			{
				armorBonus = (int)(armorBonus * 1.5);
			}
			props.replenishEnergy((int)(armorBonus * (1 + (0.001 * props.getCurrentCap()))));
			this.armorBonus = 3;
			this.replenishTimer = 200;
			
		}
		
		//Prop Stuff
		if(props.getMaskLevel() < 1)
		{
			props.setMaskLevel(1);
		}
		if(props.getMaskLevel() > 50)
		{
			props.setMaskLevel(50);
		}
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
		if(props.getMaskXP() >= 1.0)
     	{
     		props.addMaskLevel();
     	}
		props.balanceTotal();
		if(props.getPoints(1) > 200)
		{
    		props.setZType(1);
		}  

		else if(props.getPoints(2) > 200)
		{
    		props.setZType(2);
    		
		} 

		else if(props.getPoints(3) > 200)
		{
    		props.setZType(3);
		}  

		else if(props.getPoints(4) > 200)
		{
    		props.setZType(4);
    	
		}  

		else if(props.getPoints(5) > 200)
		{
    		props.setZType(5);
    		
		}  

		else if(props.getPoints(6) > 200)
		{
    		props.setZType(6);
    		
		}  

		else if(props.getPoints(7) > 200)
		{
    		props.setZType(7);
    	
		} 

		else if(props.getPoints(8) > 200)
		{
    		props.setZType(8);
    	
		} 
        
		else if(props.getPoints(6) > 150 && props.getPoints(7) > 150)
		{
			props.setZType(9);

		}
        
		else if(props.getPoints(8) > 150 && props.getPoints(7) > 150)
		{
			props.setZType(10);

		}
        
		else if(props.getPoints(1) > 150 && props.getPoints(2) > 150)
		{
			props.setZType(11);

		}

		else
		{
			props.setZType(12);

		}
		
		
		
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
		
		
		
		
		
		
		
		
		
		//Shikais
		ItemStack heldItem = player.getCurrentEquippedItem();
		ItemStack var13 = new ItemStack(BleachItems.zanpakuto, 1);
		if(heldItem != null)
		{
			if(heldItem.getItem() == BleachItems.shikaifire)
			{
				heldItem.setItemDamage(props.getZTex());
				player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 40, 0));
				--shikaiTimer;
				if(shikaiTimer <= 0 && !player.worldObj.isRemote)
				{
					shikaiTimer = 20;
					props.consumeEnergy(1);
				}
				if(props.getCurrentEnergy() <= 0 && !player.worldObj.isRemote)
				{
					heldItem.itemID = var13.itemID;
				}
				 
			}
			
			if(heldItem.getItem() == BleachItems.shikaiice)
			{
				heldItem.setItemDamage(props.getZTex());
				--shikaiTimer;
				if(shikaiTimer <= 0 && !player.worldObj.isRemote)
				{
					shikaiTimer = 20;
					props.consumeEnergy(1);
				}
				if(props.getCurrentEnergy() <= 0 && !player.worldObj.isRemote)
				{
					heldItem.itemID = var13.itemID;
				}
				 
			}
			
			if(heldItem.getItem() == BleachItems.shikaiheal)
			{
				heldItem.setItemDamage(props.getZTex());
				--shikaiTimer;
				if(shikaiTimer <= 0 && !player.worldObj.isRemote)
				{
					shikaiTimer = 20;
					props.consumeEnergy(1);
				}
				if(props.getCurrentEnergy() <= 0 && !player.worldObj.isRemote)
				{
					heldItem.itemID = var13.itemID;
				}
				 
			}
			
			if(heldItem.getItem() == BleachItems.shikaipoison)
			{
				heldItem.setItemDamage(props.getZTex());
				--shikaiTimer;
				if(shikaiTimer <= 0 && !player.worldObj.isRemote)
				{
					shikaiTimer = 20;
					props.consumeEnergy(1);
				}
				if(props.getCurrentEnergy() <= 0 && !player.worldObj.isRemote)
				{
					heldItem.itemID = var13.itemID;
				}
				 
			}
			
			if(heldItem.getItem() == BleachItems.shikaiearth)
			{
				heldItem.setItemDamage(props.getZTex());
				--shikaiTimer;
				if(shikaiTimer <= 0 && !player.worldObj.isRemote)
				{
					shikaiTimer = 20;
					props.consumeEnergy(1);
				}
				if(props.getCurrentEnergy() <= 0 && !player.worldObj.isRemote)
				{
					heldItem.itemID = var13.itemID;
				}
				 
			}
			
			if(heldItem.getItem() == BleachItems.shikaiwind)
			{
				heldItem.setItemDamage(props.getZTex());
				--shikaiTimer;
				if(shikaiTimer <= 0 && !player.worldObj.isRemote)
				{
					shikaiTimer = 20;
					props.consumeEnergy(1);
				}
				if(props.getCurrentEnergy() <= 0 && !player.worldObj.isRemote)
				{
					heldItem.itemID = var13.itemID;
				}
				 
				player.fallDistance = 0;
	        	player.addPotionEffect(new PotionEffect(Potion.jump.id, 20, 3));
	        	if(heldItem.getItemDamage() == 6)
	        	{
	        		player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 20, 0));
	        	}
			}
			
			if(heldItem.getItem() == BleachItems.shikailight)
			{
				heldItem.setItemDamage(props.getZTex());
				--shikaiTimer;
				if(shikaiTimer <= 0 && !player.worldObj.isRemote)
				{
					shikaiTimer = 20;
					props.consumeEnergy(1);
				}
				if(props.getCurrentEnergy() <= 0 && !player.worldObj.isRemote)
				{
					heldItem.itemID = var13.itemID;
				}
				 
			}
			
			if(heldItem.getItem() == BleachItems.shikaidark)
			{
				heldItem.setItemDamage(props.getZTex());
				player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 200, 0));
				--shikaiTimer;
				if(shikaiTimer <= 0 && !player.worldObj.isRemote)
				{
					shikaiTimer = 20;
					props.consumeEnergy(1);
				}
				if(props.getCurrentEnergy() <= 0 && !player.worldObj.isRemote)
				{
					heldItem.itemID = var13.itemID;
				}
				 
				
			}
			
			if(heldItem.getItem() == BleachItems.shikailightning)
			{
				heldItem.setItemDamage(props.getZTex());
				--shikaiTimer;
				if(shikaiTimer <= 0 && !player.worldObj.isRemote)
				{
					shikaiTimer = 20;
					props.consumeEnergy(1);
				}
				if(props.getCurrentEnergy() <= 0 && !player.worldObj.isRemote)
				{
					heldItem.itemID = var13.itemID;
				}
				 
				
			}
			
			if(heldItem.getItem() == BleachItems.shikailunar)
			{
				heldItem.setItemDamage(props.getZTex());
				--shikaiTimer;
				if(shikaiTimer <= 0 && !player.worldObj.isRemote)
				{
					shikaiTimer = 20;
					props.consumeEnergy(1);
				}
				if(props.getCurrentEnergy() <= 0 && !player.worldObj.isRemote)
				{
					heldItem.itemID = var13.itemID;
				}
				 
				player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 40, 0));
				player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 40, 0));
				
			}
			
			if(heldItem.getItem() == BleachItems.shikaiwater)
			{
				heldItem.setItemDamage(props.getZTex());
				--shikaiTimer;
				if(shikaiTimer <= 0 && !player.worldObj.isRemote)
				{
					shikaiTimer = 20;
					props.consumeEnergy(1);
				}
				if(props.getCurrentEnergy() <= 0 && !player.worldObj.isRemote)
				{
					heldItem.itemID = var13.itemID;
				}
				 
				
	    		

	    		
				player.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, 40, 0));
				
			}
			if(heldItem.getItem() == BleachItems.shikainormal)
			{
				heldItem.setItemDamage(props.getZTex());
				--shikaiTimer;
				if(shikaiTimer <= 0 && !player.worldObj.isRemote)
				{
					shikaiTimer = 20;
					props.consumeEnergy(1);
				}
				if(props.getCurrentEnergy() <= 0 && !player.worldObj.isRemote)
				{
					heldItem.itemID = var13.itemID;
				}
				
	    		
				player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 40, 1));
				player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 40, 1));
				
			}
			if(heldItem.getItem() == BleachItems.quincybow)
			{
				--bowTimer;
				if(bowTimer <= 0 && !player.worldObj.isRemote)
				{
					bowTimer = 40;
					props.consumeEnergy(1);
				}
				if(props.getCurrentEnergy() <= 0 && !player.worldObj.isRemote)
				{
					props.deactivate(BleachItems.quincybow.itemID);
				}
				
			}
			if(heldItem.getItem() == BleachItems.quincyweb)
			{
				--bowTimer;
				if(bowTimer <= 0 && !player.worldObj.isRemote)
				{
					bowTimer = 40;
					props.consumeEnergy(2);
				}
				if(props.getCurrentEnergy() <= 0 && !player.worldObj.isRemote)
				{
					props.deactivate(BleachItems.quincyweb.itemID);
				}
				
			}
			
			
			
			
			
			
			
		}
		
		
		
		
		
		
		
		
		
	}
	
	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) 
	{
		if(type.equals(EnumSet.of(TickType.PLAYER)))
		{
			onPlayerTick((EntityPlayer) tickData[0]);
		}
	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) 
	{
		// TODO Auto-generated method stub

	}

	@Override
	public EnumSet<TickType> ticks() 
	{
		return EnumSet.of(TickType.PLAYER, TickType.SERVER);
	}

	@Override
	public String getLabel() 
	{
		// TODO Auto-generated method stub
		return null;
	}

}
