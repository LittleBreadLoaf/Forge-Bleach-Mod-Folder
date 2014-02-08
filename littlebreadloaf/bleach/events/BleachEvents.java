package littlebreadloaf.bleach.events;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.network.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import littlebreadloaf.bleach.BleachMod;
import littlebreadloaf.bleach.armor.Armor;
import littlebreadloaf.bleach.blocks.BleachBlocks;
import littlebreadloaf.bleach.entities.EntityEnergyArrow;
import littlebreadloaf.bleach.entities.EntityHollowOre;
import littlebreadloaf.bleach.entities.EntityHollowWolf;
import littlebreadloaf.bleach.entities.EntityWhole;
import littlebreadloaf.bleach.items.BleachItems;
import littlebreadloaf.bleach.proxies.CommonProxy;
import littlebreadloaf.bleach.tiles.TileSeeleSchneider;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
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

public class BleachEvents 
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
		if(event.entity instanceof EntityPlayer)
		{
			if (!event.entity.worldObj.isRemote) 
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
			
			
				((ExtendedPlayer)(event.entity.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME))).setCurrentEnergy(1);
			
			
			}
		
			EntityPlayer Player = (EntityPlayer)event.entity;
			if(((ExtendedPlayer)(event.entity.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME))).getFaction() == 0 && !Player.inventory.hasItem(BleachItems.factionSelect.itemID))
			{
				EntityPlayer player = (EntityPlayer)event.entity;
				player.inventory.addItemStackToInventory(new ItemStack(BleachItems.factionSelect, 1));
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
	
	
	@SideOnly(Side.CLIENT)
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
			
			
		}
		
		if (!event.entity.worldObj.isRemote)
		{
			if (isEntityInCube(event.entity))
			{
				FMLLog.info("[Bleach mod] event");
				event.entity.motionX = 0F;
				event.entity.motionZ = 0F;
				if(event.entity.motionY > 0F) event.entity.motionY = 0F;
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
	        
	        
	      //Poison Shikai
			if(heldItem != null)
			{
	
				if(heldItem.getItem() == BleachItems.shikaipoison)
				{
					if(event.source.getEntity() instanceof EntityLivingBase)
					{
						EntityLivingBase var5 = (EntityLivingBase) event.source.getEntity();
						var5.addPotionEffect(new PotionEffect(Potion.poison.id, 80, 1));
					}
				}
			}
	        
	        
	      //On Wearing Armor
			if(var9 != null && var10 != null && var11 != null)
				{
				
				if((var9.getItem() == Armor.Sandals && var10.getItem() == Armor.ShiniPants && var11.getItem() == Armor.ShiniRobe) || 
						(var9.getItem() == Armor.QuincyShoes && var10.getItem() == Armor.QuincyPants && var11.getItem() == Armor.QuincyRobe)||
						(var9.getItem() == Armor.ArrancarShoes && var10.getItem() == Armor.ArrancarPants && var11.getItem() == Armor.ArrancarJacket))
					{
					
					
					
					
					
					//PvP with Zanpakuto
					if(event.source.getEntity() instanceof EntityPlayer)
					{
						ItemStack hittingItem = ((EntityPlayer)event.source.getEntity()).getHeldItem();
						
						if(hittingItem.getItem() == BleachItems.zanpakuto || hittingItem.getItem() ==  BleachItems.shikaidark
								 || hittingItem.getItem() ==  BleachItems.shikailight || hittingItem.getItem() ==  BleachItems.shikaifire
								 || hittingItem.getItem() ==  BleachItems.shikaiice || hittingItem.getItem() ==  BleachItems.shikaiearth
								 || hittingItem.getItem() ==  BleachItems.shikaiwind || hittingItem.getItem() ==  BleachItems.shikaipoison
								 || hittingItem.getItem() ==  BleachItems.shikaiheal || hittingItem.getItem() ==  BleachItems.shikailightning
								 || hittingItem.getItem() ==  BleachItems.shikaiwater || hittingItem.getItem() ==  BleachItems.shikainormal
								 || hittingItem.getItem() ==  BleachItems.shikailunar)
						{
					
					
				
				
				
				
				
					
						//On Blocking with Sword
						if(heldItem.getItem() != null)
						{
							if(heldItem.getItem() == BleachItems.zanpakuto || heldItem.getItem() ==  BleachItems.shikaidark
								 || heldItem.getItem() ==  BleachItems.shikailight || heldItem.getItem() ==  BleachItems.shikaifire
								 || heldItem.getItem() ==  BleachItems.shikaiice || heldItem.getItem() ==  BleachItems.shikaiearth
								 || heldItem.getItem() ==  BleachItems.shikaiwind || heldItem.getItem() ==  BleachItems.shikaipoison
								 || heldItem.getItem() ==  BleachItems.shikaiheal || heldItem.getItem() ==  BleachItems.shikailightning
								 || heldItem.getItem() ==  BleachItems.shikaiwater || heldItem.getItem() ==  BleachItems.shikainormal
								 || heldItem.getItem() ==  BleachItems.shikailunar)
								{
					
									if(props.getCurrentEnergy() > 0 && player.isBlocking() )
									{

										props.consumeEnergy((int)(event.ammount * 2));
										event.setCanceled(true);
									}
								}
							
							else if(props.getCurrentEnergy() > 0)
							{

								props.consumeEnergy((int)(event.ammount * 4));
								event.setCanceled(true);
							}
					
				
						}
						else if(props.getCurrentEnergy() > 0)
						{

							props.consumeEnergy((int)(event.ammount * 4));
							event.setCanceled(true);
						}

							
					
						
						
						//END PVP ZANPAKUTO
						}
						
						//END PVP
					}
					
					
					
					
					//Blocking Arrow
					else if(event.source.getEntity() instanceof EntityEnergyArrow)
					{
						//On Blocking with Sword
						if(heldItem.getItem() != null)
						{
							if(heldItem.getItem() == BleachItems.zanpakuto || heldItem.getItem() ==  BleachItems.shikaidark
								 || heldItem.getItem() ==  BleachItems.shikailight || heldItem.getItem() ==  BleachItems.shikaifire
								 || heldItem.getItem() ==  BleachItems.shikaiice || heldItem.getItem() ==  BleachItems.shikaiearth
								 || heldItem.getItem() ==  BleachItems.shikaiwind || heldItem.getItem() ==  BleachItems.shikaipoison
								 || heldItem.getItem() ==  BleachItems.shikaiheal || heldItem.getItem() ==  BleachItems.shikailightning
								 || heldItem.getItem() ==  BleachItems.shikaiwater || heldItem.getItem() ==  BleachItems.shikainormal
								 || heldItem.getItem() ==  BleachItems.shikailunar)
								{
								if(props.getCurrentEnergy() > 0 && player.isBlocking() )
								{
									props.consumeEnergy((int)(event.ammount * 3));
									event.setCanceled(true);
								}
								else if(props.getCurrentEnergy() > 0)
								{

									props.consumeEnergy((int)(event.ammount * 5));
									event.setCanceled(true);
								}
					}
							else if(props.getCurrentEnergy() > 0)
							{

								props.consumeEnergy((int)(event.ammount * 5));
								event.setCanceled(true);
							}
				}
						else if(props.getCurrentEnergy() > 0)
						{

							props.consumeEnergy((int)(event.ammount * 5));
							event.setCanceled(true);
						}
						//END BLOCKING ARROW
					}
					
					else if(props.getCurrentEnergy() > 0)
					{

						props.consumeEnergy((int)(event.ammount * 5));
						event.setCanceled(true);
					}
					
				
					
					//END WEARING FULL ARMOR
				}
				
				
			}
			
			
			//END PLAYER HIT
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
		if(event.entityPlayer.getHeldItem() != null && event.entityPlayer.getHeldItem().itemID == BleachItems.shikaiheal.itemID)
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
		if(event.entityPlayer.worldObj.getBlockId(event.x, event.y, event.z) == BleachBlocks.hollowdiamond.blockID)
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
	            			if(event.entityPlayer.worldObj.getBlockId(event.x+i, event.y+k, event.z+j) != Block.bedrock.blockID)
	            			{
	            				event.entityPlayer.worldObj.setBlockToAir(event.x+i, event.y+k, event.z+j);
	            			}
	    	            }
		            }
	            }
				event.entityPlayer.worldObj.spawnEntityInWorld(var18);
				event.entityPlayer.worldObj.playSoundAtEntity(var18, "bleach:ore_hollow", 1.4F, 1.0F);
			}
		}
		
		if(event.entityPlayer.worldObj.getBlockId(event.x, event.y, event.z) == BleachBlocks.hollowemerald.blockID)
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
				event.entityPlayer.worldObj.playSoundAtEntity(var18, "bleach:ore_hollow", 1.4F, 1.0F);
			}
		}
		if(event.entityPlayer.worldObj.getBlockId(event.x, event.y, event.z) == BleachBlocks.hollowgold.blockID)
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
				event.entityPlayer.worldObj.playSoundAtEntity(var18, "bleach:ore_hollow", 1.4F, 1.0F);
			}
		}
	}

	private boolean isEntityInCube(Entity entity)
	{
		int x, y, z, side;

		TileSeeleSchneider tile;
		
		for (int i = 0; i < TileSeeleSchneider.magicSquare.size(); i++)
		{
			x = TileSeeleSchneider.magicSquare.get(i).posX;
			y = TileSeeleSchneider.magicSquare.get(i).posY;
			z = TileSeeleSchneider.magicSquare.get(i).posZ;
			
			tile = (TileSeeleSchneider) entity.worldObj.getBlockTileEntity(x, y, z);
			if(tile == null)
			{
				TileSeeleSchneider.magicSquare.remove(i);
				return false;
			}
			side = tile.side;
			
			if(entity.posX > x + 0.5F && entity.posX < x + side - 0.5F &&
			entity.posZ > z + 0.5F && entity.posZ < z + side - 0.5F &&
			entity.posY >= y)
			{
				return true;
				
			}
		}
		return false;
	}
}
