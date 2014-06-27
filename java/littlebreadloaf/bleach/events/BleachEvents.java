package littlebreadloaf.bleach.events;

import java.util.Random;

import littlebreadloaf.bleach.BleachMod;
import littlebreadloaf.bleach.armor.Armor;
import littlebreadloaf.bleach.blocks.BleachBlocks;
import littlebreadloaf.bleach.entities.EntityHollowOre;
import littlebreadloaf.bleach.items.BleachItems;
import littlebreadloaf.bleach.proxies.CommonProxy;
import littlebreadloaf.bleach.tiles.TileSeeleSchneider;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.event.entity.player.EntityInteractEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BleachEvents 
{
	
	public static CommonProxy proxy = new CommonProxy();
	Random rand = new Random();
	
	@SubscribeEvent
	public void onEntityConstructing(EntityConstructing event)
	{
		if (event.entity instanceof EntityPlayer &&
				event.entity.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME) == null)
				{
					event.entity.registerExtendedProperties(ExtendedPlayer.EXT_PROP_NAME, new ExtendedPlayer((EntityPlayer) event.entity));
				}
	}
	
	
	
	
	
	@SubscribeEvent
	public void onEntityJoinWorld(EntityJoinWorldEvent event)
	{	
		if(event.entity instanceof EntityPlayerMP)
			ExtendedPlayer.loadProxyData((EntityPlayer) event.entity);
		if(event.entity instanceof EntityPlayerMP)
		{
			EntityPlayer player = ((EntityPlayer)event.entity);
			ExtendedPlayer props = (ExtendedPlayer) player.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);
			if(props.getFaction() == 0 && !player.inventory.hasItem(BleachItems.factionSelect))
			{
				player.inventory.addItemStackToInventory(new ItemStack(BleachItems.factionSelect, 1));
				if(!player.worldObj.isRemote)
					props.replenishEnergy(1);
			}
		}
		
	}
	
	
	//On Death
	
	@SubscribeEvent
	public void onLivingDeathEvent(LivingDeathEvent event)
	{
		if(event.entity instanceof EntityPlayerMP)
		{
			EntityPlayer player = ((EntityPlayer)event.entity);
			ExtendedPlayer.saveProxyData(player);
			
			if(player.inventory.hasItem(BleachItems.zanpakuto))
			{
				
			}
		}
	}
	

	@SubscribeEvent
	public void onLivingSpawnEvent(LivingSpawnEvent event)
	{
		if(event.entityLiving instanceof EntityPlayer)
		{

			EntityPlayer player = ((EntityPlayer)event.entityLiving);
			ExtendedPlayer props = (ExtendedPlayer) player.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);
			props.replenishEnergy(1);
		}
	}
	private int replenishTimer = 100;
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onLivingUpdateEvent(LivingUpdateEvent event)
	{
		if(event.entityLiving instanceof EntityPlayer)
		{
			--replenishTimer;
			
			EntityPlayer player = ((EntityPlayer)event.entityLiving);
			ExtendedPlayer props = (ExtendedPlayer) player.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);
			
			if(!event.entityLiving.worldObj.isRemote)
			{
				player.capabilities.setPlayerWalkSpeed(0.1F + (float)((float)props.getCurrentCap() *(0.00007* (float)props.getCurrentEnergy())));
				
			}
			if(player.isAirBorne && player.isSneaking() && player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() == BleachItems.shikaiwind)
			{
				player.motionY = -0.3 + (float)((props.getCurrentEnergy()*props.getCurrentCap())/(float)10000);
				player.moveFlying(player.moveStrafing, player.moveForward, 0.1F + (float)((props.getCurrentEnergy()*props.getCurrentCap())/(float)10000));
        		
			}
			
			//if(props.getStickTimer() > 0)
			//{
			//	player.motionY = 0;
			//	player.motionX = 0;
			//	player.motionZ = 0;
			//}
			if(replenishTimer <= 0)
			{
			
				
				props.replenishEnergy((int)(3 * (1 + (0.001 * props.getCurrentCap()))));
				BleachMod.packetPipeline.sendToServer(new PacketSync(player));
				this.replenishTimer = 100;	
				
			}
			
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
	
	
	@SubscribeEvent
	public void onLivingJumpEvent(LivingJumpEvent event)
	{
		if(event.entityLiving instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer)event.entityLiving;
			ExtendedPlayer props = (ExtendedPlayer) player.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);
			event.entityLiving.motionY += (float)props.getCurrentCap() *(0.0005 * (float)props.getCurrentEnergy());
			
		}
		
	}
	@SubscribeEvent
	public void onLivingFallEvent(LivingFallEvent event)
	{
		if(event.entityLiving instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer)event.entityLiving;
			ExtendedPlayer props = (ExtendedPlayer) player.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);
			
			event.distance -= (float)props.getCurrentCap() *(0.02* (float)props.getCurrentEnergy());
			
			
		}
	}
	
	@SubscribeEvent
	public void onItemPickup(EntityItemPickupEvent event)
	{

		if(event.item.getEntityItem().getItem().equals(BleachItems.heart))
		{
			if(event.entityPlayer != null)
			{
				event.entityPlayer.heal(8.0F);
				for(int i = 0; i< 5; i++)
                {
					
                
					if(event.entityPlayer instanceof EntityPlayerMP)
					BleachMod.packetPipeline.sendTo(new PacketParticle(4, (int)event.entityPlayer.posX, (int)event.entityPlayer.posY, (int)event.entityPlayer.posZ), (EntityPlayerMP)event.entityPlayer);
                	   	
                }
				event.item.setDead();
				event.setCanceled(true);
			}
		}
	}
	
	
	
	//When Hurt
	
	
	@SubscribeEvent
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
			
			if((var9 != null && var10 != null && var11 != null))
			{
				if((var9.getItem() == Armor.Sandals && var10.getItem() == Armor.ShiniPants && var11.getItem() == Armor.ShiniRobe) || 
						(var9.getItem() == Armor.QuincyShoes && var10.getItem() == Armor.QuincyPants && var11.getItem() == Armor.QuincyRobe)||
						(var9.getItem() == Armor.ArrancarShoes && var10.getItem() == Armor.ArrancarPants && var11.getItem() == Armor.ArrancarJacket))
					{
					
						if(heldItem != null)
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

										props.consumeEnergy((int)(event.ammount));
										event.setCanceled(true);
									}
									else if(props.getCurrentEnergy() > 0)
									{
										props.consumeEnergy((int)(event.ammount * 4));
										event.setCanceled(true);
									}
								}
							
							else if(props.getCurrentEnergy() > 0)
							{
								props.consumeEnergy((int)(event.ammount * 6));
								event.setCanceled(true);
							}
					
				
						}
						else 
						{
							
							if((props.getCurrentEnergy() > 0))
							{
								props.consumeEnergy((int)(event.ammount * 6));
								event.setCanceled(true);
							}
						}
					}
				}
			}
		
		
		
		
		
		
		
		
		
		
		if(event.entityLiving instanceof EntityHollowOre)
		{
			if(event.source.equals(DamageSource.inWall))
			{
				event.setCanceled(true);
			}
		}
	}
		
	
	
	

	
	
	@SubscribeEvent
	public void onEntityInteractEvent(EntityInteractEvent event)
	{
		if(event.entityPlayer != null)
		{
		ExtendedPlayer props = (ExtendedPlayer) event.entityPlayer.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);
		
		if(event.entityPlayer.getCurrentEquippedItem() != null && event.entityPlayer.getCurrentEquippedItem().getItem() == BleachItems.shikaiheal)
		{
			if(event.target instanceof EntityLiving)
			{
				EntityLiving theTarget = (EntityLiving)event.target;
				if(theTarget.getCreatureAttribute() == EnumCreatureAttribute.UNDEAD)
				{
					//Nuttin'
				}
				else if(theTarget.getHealth() < theTarget.getMaxHealth())
				{
					theTarget.heal(2.0F);
					for(int i = 0; i< 5; i++)
	                {
	                
						if(event.entityPlayer instanceof EntityPlayerMP)
							BleachMod.packetPipeline.sendTo(new PacketParticle(4, (int)theTarget.posX, (int)theTarget.posY, (int)theTarget.posZ), (EntityPlayerMP)event.entityPlayer);
		                	   	
	                }
					if(!event.entityPlayer.worldObj.isRemote)
						props.consumeEnergy(5);
	            }
			}
		}
		}
	}
	
	@SubscribeEvent
	public void onPlayerInteractEvent(PlayerInteractEvent event)
	{
		if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == BleachBlocks.hollowdiamond)
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
	            			if(event.entityPlayer.worldObj.getBlock(event.x+i, event.y+k, event.z+j) != Blocks.bedrock)
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
		
		if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == BleachBlocks.hollowemerald)
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
		if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == BleachBlocks.hollowgold)
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
			
			tile = (TileSeeleSchneider) entity.worldObj.getTileEntity(x, y, z);
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
