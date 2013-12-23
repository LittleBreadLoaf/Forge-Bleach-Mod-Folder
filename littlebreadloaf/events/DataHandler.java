package littlebreadloaf.events;

import littlebreadloaf.armor.Armor;
import littlebreadloaf.blocks.Blocks;
import littlebreadloaf.entities.classes.EntityEnergyArrow;
import littlebreadloaf.entities.classes.EntityHollowOre;
import littlebreadloaf.entities.classes.EntityHollowWolf;
import littlebreadloaf.entities.classes.EntityWhole;
import littlebreadloaf.items.Items;
import littlebreadloaf.libraries.BleachMod;
import littlebreadloaf.proxies.CommonProxy;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityLivingData;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.EntityInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;

public class DataHandler 
{
	
	public static CommonProxy proxy = new CommonProxy();
	
	@ForgeSubscribe
	public void onEntityConstructing(EntityConstructing event)
	{
		if (event.entity instanceof EntityPlayer &&
				event.entity.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME) == null)
				{
					event.entity.registerExtendedProperties(ExtendedPlayer.EXT_PROP_NAME, new ExtendedPlayer((EntityPlayer) event.entity));
				}
	}
	
	
	
	
	
	@ForgeSubscribe
	public void onEntityJoinWorld(EntityJoinWorldEvent event)
	{
		if (!event.entity.worldObj.isRemote && event.entity instanceof EntityPlayer) 
		{
			NBTTagCompound playerData = proxy.getEntityData(((EntityPlayer)event.entity).username);
			if(playerData != null)
			{
				((ExtendedPlayer)(event.entity.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME))).loadNBTData(playerData);
			}
			((ExtendedPlayer)(event.entity.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME))).syncExtendedProperties();
			if(((ExtendedPlayer)(event.entity.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME))).getZTex() == 5)
			{
				((ExtendedPlayer)(event.entity.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME))).randomTexture();
			}
		}
		
	
		
		
	}
	
	
	//On Death
	
	@ForgeSubscribe
	public void onLivingDeathEvent(LivingDeathEvent event)
	{
		if(!event.entity.worldObj.isRemote && event.entity instanceof EntityPlayer)
		{
			NBTTagCompound playerData = new NBTTagCompound();
			((ExtendedPlayer)(event.entity.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME))).saveNBTData(playerData);
			proxy.storeEntityData(((EntityPlayer)event.entity).username, playerData);
		}
	}
	
	@ForgeSubscribe
	public void onLivingUpdateEvent(LivingUpdateEvent event)
	{
		if(event.entityLiving instanceof EntityPlayer)
		{
			EntityPlayer player = ((EntityPlayer)event.entityLiving);
			ExtendedPlayer props = (ExtendedPlayer) player.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);
			
			
			player.capabilities.setPlayerWalkSpeed(0.1F + (float)((float)props.getCurrentCap() *(0.00007* (float)props.getCurrentEnergy())));
		
			//if(props.getStickTimer() > 0)
			//{
			//	player.motionY = 0;
			//	player.motionX = 0;
			//	player.motionZ = 0;
			//}
			
			if(player.worldObj.getBlockId((int)(player.posX - 1), (int)(player.posY), (int)(player.posZ)) != 0 || player.worldObj.getBlockId((int)(player.posX - 2), (int)(player.posY), (int)(player.posZ)) != 0)
			{
				props.setStickTimer(0);
			}
		}
	}
	
	
	//Jumping and Falling
	
	
	@ForgeSubscribe
	public void onLivingJumpEvent(LivingJumpEvent event)
	{
		if(event.entityLiving instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer)event.entityLiving;
			ExtendedPlayer props = (ExtendedPlayer) player.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);
			event.entityLiving.motionY += (float)props.getCurrentCap() *(0.0005 * (float)props.getCurrentEnergy());
			
		}
		
	}
	@ForgeSubscribe
	public void onLivingFallEvent(LivingFallEvent event)
	{
		if(event.entityLiving instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer)event.entityLiving;
			ExtendedPlayer props = (ExtendedPlayer) player.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);
			
			event.distance -= (float)props.getCurrentCap() *(0.02* (float)props.getCurrentEnergy());
			
			
		}
	}
	
	
	
	//When Hurt
	
	
	@ForgeSubscribe
	public void onLivingHurtEvent(LivingHurtEvent event)
	{
		 
		if(event.entityLiving instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer)event.entityLiving;
			ExtendedPlayer props = (ExtendedPlayer) player.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);
			ItemStack heldItem = player.getCurrentEquippedItem();
			
			ItemStack var9 = player.inventory.armorInventory[0];
	        ItemStack var10 = player.inventory.armorInventory[1];
	        ItemStack var11 = player.inventory.armorInventory[2];
	        ItemStack var7 = player.inventory.armorInventory[3];
			//Holding Item True
	        
			
			if(heldItem != null)
			{
				
				
				
				if(heldItem.getItem() == Items.shikaipoison)
				{
					if(event.source.getEntity() instanceof EntityLivingBase)
					{
						EntityLivingBase var5 = (EntityLivingBase) event.source.getEntity();
						var5.addPotionEffect(new PotionEffect(Potion.poison.id, 80, 1));
					}
				}
				
				
				
				
				//On Blocking with Sword
				
				if(heldItem.getItem() == Items.zanpakuto || heldItem.getItem() ==  Items.shikaidark
						 || heldItem.getItem() ==  Items.shikailight || heldItem.getItem() ==  Items.shikaifire
						 || heldItem.getItem() ==  Items.shikaiice || heldItem.getItem() ==  Items.shikaiearth
						 || heldItem.getItem() ==  Items.shikaiwind || heldItem.getItem() ==  Items.shikaipoison
						 || heldItem.getItem() ==  Items.shikaiheal || heldItem.getItem() ==  Items.shikailightning
						 || heldItem.getItem() ==  Items.shikaiwater || heldItem.getItem() ==  Items.shikainormal
						 || heldItem.getItem() ==  Items.shikailunar)
				{
					if(var9 != null && var10 != null && var11 != null)
					{
					if((var9.getItem() == Armor.Sandals && var10.getItem() == Armor.ShiniPants && var11.getItem() == Armor.ShiniRobe) || 
							(var9.getItem() == Armor.QuincyShoes && var10.getItem() == Armor.QuincyPants && var11.getItem() == Armor.QuincyRobe))
					{
					
					//Blocking other Sword
					if(event.source.getEntity() instanceof EntityPlayer)
					{
						ItemStack hittingItem = ((EntityPlayer)event.source.getEntity()).getHeldItem();
						
						if(hittingItem.getItem() == Items.zanpakuto || hittingItem.getItem() ==  Items.shikaidark
								 || hittingItem.getItem() ==  Items.shikailight || hittingItem.getItem() ==  Items.shikaifire
								 || hittingItem.getItem() ==  Items.shikaiice || hittingItem.getItem() ==  Items.shikaiearth
								 || hittingItem.getItem() ==  Items.shikaiwind || hittingItem.getItem() ==  Items.shikaipoison
								 || hittingItem.getItem() ==  Items.shikaiheal || hittingItem.getItem() ==  Items.shikailightning
								 || hittingItem.getItem() ==  Items.shikaiwater || hittingItem.getItem() ==  Items.shikainormal
								 || hittingItem.getItem() ==  Items.shikailunar)
						{
							if(props.getCurrentEnergy() > 0)
							{
								props.consumeEnergy((int)(event.ammount * 4));
								event.setCanceled(true);
							}
							else if(props.getCurrentEnergy() > 0&& player.isBlocking() )
							{

								props.consumeEnergy((int)(event.ammount * 2));
								event.setCanceled(true);
							}
						}

					
						//End Blocking Other Sword
					}

					//Blocking Arrow
					else if(event.source.getEntity() instanceof EntityEnergyArrow)
					{
						if(props.getCurrentEnergy() > 0)
						{
							props.consumeEnergy((int)(event.ammount * 4));
							event.setCanceled(true);
						}
						else if(props.getCurrentEnergy() > 0&& player.isBlocking() )
						{

							props.consumeEnergy((int)(event.ammount * 2));
							event.setCanceled(true);
						}
						//End Blocking Arrow
					}
					else
					{
						if(props.getCurrentEnergy() > 0 && player.isBlocking())
						{
							props.consumeEnergy((int)event.ammount * 6);
							event.setCanceled(true);
						}
					}
					
					}
					}
					//End Blocking With Sword
				}
				
				//End Held Item True
			}
			
			
			//End Instance Of Player
		}
		
		
		
		
		
		
		
		
		if(event.entityLiving instanceof EntityHollowOre)
		{
			if(event.source.equals(DamageSource.inWall))
			{
				event.setCanceled(true);
			}
		}
	}
		
	
	
	
	@ForgeSubscribe
	public void onItemTossEvent(ItemTossEvent event)
	{
		if(event.entityItem.getEntityItem().getItem() == Armor.PlayerMask10
				 || event.entityItem.getEntityItem().getItem() == Armor.PlayerMask11
				 || event.entityItem.getEntityItem().getItem() == Armor.PlayerMask12
				 || event.entityItem.getEntityItem().getItem() == Armor.PlayerMask20
				 || event.entityItem.getEntityItem().getItem() == Armor.PlayerMask21
				 || event.entityItem.getEntityItem().getItem() == Armor.PlayerMask22
				 || event.entityItem.getEntityItem().getItem() == Armor.PlayerMask30
				 || event.entityItem.getEntityItem().getItem() == Armor.PlayerMask31
				 || event.entityItem.getEntityItem().getItem() == Armor.PlayerMask32
				 || event.entityItem.getEntityItem().getItem() == Armor.PlayerMask40
				 || event.entityItem.getEntityItem().getItem() == Armor.PlayerMask41
				 || event.entityItem.getEntityItem().getItem() == Armor.PlayerMask42)
		{
			event.setCanceled(true);
		}
	}
	
	
	
	@ForgeSubscribe
	public void onEntityInteractEvent(EntityInteractEvent event)
	{
		if(event.entityPlayer.getHeldItem().itemID == Items.shikaiheal.itemID)
		{
			if(event.target instanceof EntityZombie)
			{
				EntityZombie zombie = (EntityZombie)event.target;
				if(zombie.isVillager())
				{
					if(!event.entityPlayer.worldObj.isRemote)
					{
					 EntityVillager entityvillager = new EntityVillager(event.entityPlayer.worldObj);
				        entityvillager.copyLocationAndAnglesFrom(zombie);
				        entityvillager.onSpawnWithEgg((EntityLivingData)null);
				        entityvillager.func_82187_q();

				        if (zombie.isChild())
				        {
				            entityvillager.setGrowingAge(-24000);
				        }

				        event.entityPlayer.worldObj.removeEntity(zombie);
				        event.entityPlayer.worldObj.spawnEntityInWorld(entityvillager);
				        entityvillager.addPotionEffect(new PotionEffect(Potion.confusion.id, 200, 0));
				        event.entityPlayer.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1017, (int)zombie.posX, (int)zombie.posY, (int)zombie.posZ, 0);
				}

					EntityPlayer player = event.entityPlayer;
					ExtendedPlayer props = (ExtendedPlayer) player.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);
					props.consumeEnergy(15);
				
				}
			}
		}
		
	}
	
	@ForgeSubscribe
	public void onPlayerInteractEvent(PlayerInteractEvent event)
	{
		if(event.entityPlayer.worldObj.getBlockId(event.x, event.y, event.z) == Blocks.hollowdiamond.blockID)
		{
			if(event.action.equals(Action.LEFT_CLICK_BLOCK))
			{
				
	            EntityHollowOre var18 = new EntityHollowOre(event.entityPlayer.worldObj, 2);
	            
	            int var10 = event.x;
	            int var11 = event.y;
	            int var12 = event.z;
	            
	            var18.setLocationAndAngles((double)var10, (double)var11, (double)var12, 0.0F, 0.0F);
	            
	            
	            event.entityPlayer.worldObj.createExplosion(null, event.x, event.y, event.z, 1, true);
	            for(int i = -2;i<=2;++i)
	            {
	            	for(int j = -2;j<=2;++j)
		            {
	            		for(int k = -2;k<=2;++k)
	    	            {
	        	            event.entityPlayer.worldObj.setBlockToAir(event.x+i, event.y+k, event.z+j);
	    	            }
		            }
	            }
				event.entityPlayer.worldObj.spawnEntityInWorld(var18);
				event.entityPlayer.worldObj.playSoundAtEntity(var18, "lblbm:ore_hollow", 1.4F, 1.0F);
			}
		}
		
		if(event.entityPlayer.worldObj.getBlockId(event.x, event.y, event.z) == Blocks.hollowemerald.blockID)
		{
			if(event.action.equals(Action.LEFT_CLICK_BLOCK))
			{
				
	            EntityHollowOre var18 = new EntityHollowOre(event.entityPlayer.worldObj, 1);
	            
	            int var10 = event.x;
	            int var11 = event.y;
	            int var12 = event.z;
	            
	            var18.setLocationAndAngles((double)var10, (double)var11, (double)var12, 0.0F, 0.0F);
	            
	            
	            event.entityPlayer.worldObj.createExplosion(null, event.x, event.y, event.z, 1, true);
	            for(int i = -2;i<=2;++i)
	            {
	            	for(int j = -2;j<=2;++j)
		            {
	            		for(int k = -2;k<=2;++k)
	    	            {
	        	            event.entityPlayer.worldObj.setBlockToAir(event.x+i, event.y+k, event.z+j);
	    	            }
		            }
	            }
				event.entityPlayer.worldObj.spawnEntityInWorld(var18);
				event.entityPlayer.worldObj.playSoundAtEntity(var18, "lblbm:ore_hollow", 1.4F, 1.0F);
			}
		}
		if(event.entityPlayer.worldObj.getBlockId(event.x, event.y, event.z) == Blocks.hollowgold.blockID)
		{
			if(event.action.equals(Action.LEFT_CLICK_BLOCK))
			{
				
	            EntityHollowOre var18 = new EntityHollowOre(event.entityPlayer.worldObj, 0);
	            
	            int var10 = event.x;
	            int var11 = event.y;
	            int var12 = event.z;
	            
	            var18.setLocationAndAngles((double)var10, (double)var11, (double)var12, 0.0F, 0.0F);
	            
	            
	            event.entityPlayer.worldObj.createExplosion(null, event.x, event.y, event.z, 1, true);
	            for(int i = -2;i<=2;++i)
	            {
	            	for(int j = -2;j<=2;++j)
		            {
	            		for(int k = -2;k<=2;++k)
	    	            {
	        	            event.entityPlayer.worldObj.setBlockToAir(event.x+i, event.y+k, event.z+j);
	    	            }
		            }
	            }
				event.entityPlayer.worldObj.spawnEntityInWorld(var18);
				event.entityPlayer.worldObj.playSoundAtEntity(var18, "lblbm:ore_hollow", 1.4F, 1.0F);
			}
		}
	}

	
}
