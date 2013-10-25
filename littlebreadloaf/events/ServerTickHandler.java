package littlebreadloaf.events;

import java.util.EnumSet;

import org.lwjgl.input.Keyboard;

import littlebreadloaf.armor.Armor;
import littlebreadloaf.extras.ShikaiKeyBind;
import littlebreadloaf.items.Items;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class ServerTickHandler implements ITickHandler 
{
	private int depleteTimer = 40;
	private int replenishTimer = 400;
	private int shikaiTimer = 20;
	private int armorBonus = 0;

	private void onPlayerTick(EntityPlayer player)
	{
		ExtendedPlayer props = (ExtendedPlayer) player.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);
		--depleteTimer;
		--replenishTimer;
		ItemStack chest = player.getCurrentItemOrArmor(3);
		ItemStack legs = player.getCurrentItemOrArmor(2);
		ItemStack shoes = player.getCurrentItemOrArmor(1);
		
		
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
					armorBonus++;
				}
			}
			if(player.getCurrentItemOrArmor(1) != null)
			{
				if(shoes.getItem() == Armor.Sandals || chest.getItem() == Armor.QuincyShoes)
				{
					armorBonus++;
				}
			}
			props.replenishEnergy(armorBonus);
			this.armorBonus = 1;
			this.replenishTimer = 400;
			
		}
		
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
		if(props.getPoints(1) > 40)
		{
    		props.setZType(1);
		}  

		else if(props.getPoints(2) > 40)
		{
    		props.setZType(2);
    		
		} 

		else if(props.getPoints(3) > 40)
		{
    		props.setZType(3);
		}  

		else if(props.getPoints(4) > 40)
		{
    		props.setZType(4);
    	
		}  

		else if(props.getPoints(5) > 40)
		{
    		props.setZType(5);
    		
		}  

		else if(props.getPoints(6) > 40)
		{
    		props.setZType(6);
    		
		}  

		else if(props.getPoints(7) > 40)
		{
    		props.setZType(7);
    	
		} 

		else if(props.getPoints(8) > 40)
		{
    		props.setZType(8);
    	
		} 
        
		else if(props.getPoints(6) > 30 && props.getPoints(7) > 30)
		{
			props.setZType(9);

		}
        
		else if(props.getPoints(8) > 30 && props.getPoints(7) > 30)
		{
			props.setZType(10);

		}
        
		else if(props.getPoints(1) > 30 && props.getPoints(2) > 30)
		{
			props.setZType(11);

		}

		else
		{
			props.setZType(0);

		}
		
		
		
		
		
		
		//Shikais
		ItemStack heldItem = player.getCurrentEquippedItem();
		ItemStack var13 = new ItemStack(Items.zanpakuto, 1);
		if(heldItem != null)
		{
			if(heldItem.getItem() == Items.shikaifire)
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
				//if(ShikaiKeyBind.keyPressed && !player.worldObj.isRemote)
				//{
				//	heldItem.itemID = var13.itemID;
				//}
			}
			
			if(heldItem.getItem() == Items.shikaiice)
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
				//if(ShikaiKeyBind.keyPressed && !player.worldObj.isRemote)
				//{
				//	heldItem.itemID = var13.itemID;
				//}
			}
			
			if(heldItem.getItem() == Items.shikaiheal)
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
				//if(ShikaiKeyBind.keyPressed && !player.worldObj.isRemote)
				//{
				//	heldItem.itemID = var13.itemID;
				//}
			}
			
			if(heldItem.getItem() == Items.shikaipoison)
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
				//if(ShikaiKeyBind.keyPressed && !player.worldObj.isRemote)
				//{
				//	heldItem.itemID = var13.itemID;
				//}
			}
			
			if(heldItem.getItem() == Items.shikaiearth)
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
				//if(ShikaiKeyBind.keyPressed && !player.worldObj.isRemote)
				//{
				//	heldItem.itemID = var13.itemID;
				//}
			}
			
			if(heldItem.getItem() == Items.shikaiwind)
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
				//if(ShikaiKeyBind.keyPressed && !player.worldObj.isRemote)
				//{
				//	heldItem.itemID = var13.itemID;
				//}
				player.fallDistance = 0;
	        	player.addPotionEffect(new PotionEffect(Potion.jump.id, 20, 3));
	        	if(heldItem.getItemDamage() == 6)
	        	{
	        		player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 20, 0));
	        	}
			}
			
			if(heldItem.getItem() == Items.shikailight)
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
				//if(ShikaiKeyBind.keyPressed && !player.worldObj.isRemote)
				//{
				//	heldItem.itemID = var13.itemID;
				//}
			}
			
			if(heldItem.getItem() == Items.shikaidark)
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
				//if(ShikaiKeyBind.keyPressed && !player.worldObj.isRemote)
				//{
				//	heldItem.itemID = var13.itemID;
				//}
				
			}
			
			if(heldItem.getItem() == Items.shikailightning)
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
				//if(ShikaiKeyBind.keyPressed && !player.worldObj.isRemote)
				//{
				//	heldItem.itemID = var13.itemID;
				//}
				
			}
			
			if(heldItem.getItem() == Items.shikailunar)
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
				//if(ShikaiKeyBind.keyPressed && !player.worldObj.isRemote)
				//{
				//	heldItem.itemID = var13.itemID;
				//}
				player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 40, 0));
				player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 40, 0));
				
			}
			
			if(heldItem.getItem() == Items.shikaiwater)
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
				//if(ShikaiKeyBind.keyPressed && !player.worldObj.isRemote)
				//{
				//	heldItem.itemID = var13.itemID;
				//}
				
	    		

	    		
				player.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, 40, 0));
				
			}
			if(heldItem.getItem() == Items.shikainormal)
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
				//if(ShikaiKeyBind.keyPressed && !player.worldObj.isRemote)
			//	{
				//	heldItem.itemID = var13.itemID;
				//}
	    		
				player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 40, 1));
				player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 40, 1));
				
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
