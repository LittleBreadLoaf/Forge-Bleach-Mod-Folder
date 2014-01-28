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
	
	private boolean countPoints = true;
	

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
		if(replenishTimer <= 0)
		{
			if(player.getCurrentItemOrArmor(3) != null)
			{
				if(chest.getItem() == Armor.ShiniRobe || chest.getItem() == Armor.QuincyRobe || chest.getItem() == Armor.ArrancarJacket)
				{
					armorBonus += 2;
				}
			}
			if(player.getCurrentItemOrArmor(2) != null)
			{
				if(legs.getItem() == Armor.ShiniPants || legs.getItem() == Armor.QuincyPants || legs.getItem() == Armor.ArrancarPants)
				{
					armorBonus += 1;
				}
			}
			if(player.getCurrentItemOrArmor(1) != null)
			{
				if(shoes.getItem() == Armor.Sandals || shoes.getItem() == Armor.QuincyShoes || shoes.getItem() == Armor.ArrancarShoes)
				{
					armorBonus += 1;
				}
			}
			if(props.getFaction() == 1)
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
		
		
		if(props.getPoints(9) >= 400 && countPoints)
		{
			int check = 1;
			for(int i = 1; i < 8; i++)
			{
				if(props.getPoints(i) > props.getPoints(check))
				{
					check = i;
				}	
			}
			if(props.getPoints(check) >= 100)
			{
				props.setZType(check);
				
				int secondType = 1;
				for(int j = 1; j< 8; j++)
				{
					if(props.getPoints(j) > props.getPoints(secondType) && j != check)
					{
						secondType = j;
					}
				}
				
				if(props.getPoints(secondType) >= 100)
				{
					if((check == 6 && secondType == 7) || (check == 7 && secondType == 6))
					{
						props.setZType(9);
					}
					else if((check == 7 && secondType == 8) || (check == 8 && secondType == 7))
					{
						props.setType(11);
					}
					else if((check == 1 && secondType == 2) || (check == 2 && secondType == 1))
					{
						props.setType(9);
					}
				}
				
			}
			else
			{
				props.setZType(12);
			}

			countPoints = false;
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
