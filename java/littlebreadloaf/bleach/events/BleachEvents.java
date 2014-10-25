package littlebreadloaf.bleach.events;

import java.util.List;
import java.util.Random;

import littlebreadloaf.bleach.BleachMod;
import littlebreadloaf.bleach.armor.Armor;
import littlebreadloaf.bleach.blocks.BleachBlocks;
import littlebreadloaf.bleach.entities.EntityCero;
import littlebreadloaf.bleach.entities.EntityDecoy;
import littlebreadloaf.bleach.entities.EntityHollowOre;
import littlebreadloaf.bleach.entities.EntityWhole;
import littlebreadloaf.bleach.items.BleachItems;
import littlebreadloaf.bleach.items.shikai.ItemShikai;
import littlebreadloaf.bleach.network.CeroMessage;
import littlebreadloaf.bleach.network.GuiMessage;
import littlebreadloaf.bleach.network.ParticleMessage;
import littlebreadloaf.bleach.network.ServerSyncMessage;
import littlebreadloaf.bleach.proxies.CommonProxy;
import littlebreadloaf.bleach.tiles.TileSeeleSchneider;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Vec3;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
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
	EntityPlayer myPlayer = null;
	
	@SubscribeEvent
	public void onEntityConstructing(EntityConstructing event)
	{
		if (event.entity instanceof EntityPlayer &&
				event.entity.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME) == null)
				{
					myPlayer = (EntityPlayer)event.entity;
					ExtendedPlayer.register(((EntityPlayer) event.entity));
				
					
					
				}
		
		
		
	}
	
	
	
	@SubscribeEvent
	public void onEntityJoinWorld(EntityJoinWorldEvent event)
	{	
		
		
		
		if(event.entity instanceof EntityPlayer)
		{

			EntityPlayer player = ((EntityPlayer)event.entity);
			ExtendedPlayer props = ExtendedPlayer.get(player);
			if(!event.world.isRemote)
				ExtendedPlayer.loadProxyData(player);
			if(props.getFaction() == 0)
			{
				if(!player.worldObj.isRemote)
				{
					props.replenishEnergy(1);
					if(props.getZTex() == 5)
			    	{
			    		props.randomTexture();
			    	}
				}
			}
			
		}
		if(event.entity instanceof EntityPlayerMP)
		{
			EntityPlayerMP playah = (EntityPlayerMP)event.entity;
			ExtendedPlayer info = ExtendedPlayer.get(playah);
			if(info.getFaction() == 0)
			BleachMod.network.sendTo(new GuiMessage(2), playah);
		}
		
		
		if(event.entity instanceof EntityWhole || event.entity instanceof EntityDecoy)
		{
			event.entity.setCurrentItemOrArmor(2, new ItemStack(Armor.SoulChain, 1));

		}
		
	}
	
	
	//On Death
	
	@SubscribeEvent
	public void onLivingDeathEvent(LivingDeathEvent event)
	{
		if(event.entity instanceof EntityPlayer)
		{
			EntityPlayer player = ((EntityPlayer)event.entity);
			if(!event.entity.worldObj.isRemote)
			{
			
				ExtendedPlayer.saveProxyData(player);
			}
		}
	}
	

	
	
	private int replenishTimer = 100;
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onLivingUpdateEvent(LivingUpdateEvent event)
	{
		
		
		if (!event.entity.worldObj.isRemote)
		{
			if (isEntityInCube(event.entity))
			{
				FMLLog.info("[Bleach mod] event");
				event.entity.motionX = 0F;
				event.entity.motionZ = 0F;
				if(event.entity.motionY > 0F) event.entity.motionY = 0F;
			}
		
		
		if(event.entityLiving instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer)event.entityLiving;
			ExtendedPlayer props = ExtendedPlayer.get(player);
			
			--replenishTimer;

			if(props.getCeroCharge() > 0)
			{
				props.addCeroCharge(1);
				if(props.getCeroCharge() >= 40)
				{
					props.setCeroCharge(0);
					EntityCero entityCero = new EntityCero(player.worldObj, player, 2.0F);
					if(!player.worldObj.isRemote)
					{
					 player.worldObj.spawnEntityInWorld(entityCero);
						BleachMod.network.sendToServer(new CeroMessage(2));

					}
				}
				
				BleachMod.network.sendToAll(new ParticleMessage(5, (int)player.posX, (int)player.posY, (int)player.posZ));
            	
				
			}
			player.capabilities.setPlayerWalkSpeed(0.1F + (float)((float)props.getCurrentCap() *(0.00007* (float)props.getCurrentEnergy())));

			
			
			if(replenishTimer <= 0)
			{
			
				props.replenishEnergy((int)(2.5 * (1 + (0.001 * props.getCurrentCap()))));
				
				BleachMod.network.sendToAll(new ServerSyncMessage(player));
				this.replenishTimer = 100;	
				
			}
			
			if(props.getFaction() == 3 && props.getHead() == 2 && player.isSprinting())
			{
				Vec3 normalizer = Vec3.createVectorHelper(0.008, 0.008, 0.008).normalize();
	    		List list = player.worldObj.getEntitiesWithinAABBExcludingEntity(player, player.boundingBox.copy().expand(Math.abs(normalizer.xCoord * 0.5D), Math.abs(normalizer.yCoord * 0.5D), Math.abs(normalizer.zCoord * 0.5D)));
	    		for (int l = 0; l < list.size(); ++l)
	    		{
	    			Entity entity1 = (Entity) list.get(l);
	    			
	    				if(entity1 instanceof EntityLivingBase)
	    				{
	    					double moveX = (entity1.posX - player.posX);
	    					double moveY = (entity1.posY - player.posY);
	    					double moveZ = (entity1.posZ - player.posZ);
	    					double angle = Math.atan2(moveZ, moveX);
	    					
	    					moveX = 0.8 * (Math.cos(angle));
	    					moveZ = 0.8 * (Math.sin(angle));
	    					moveY = 0.5F;
	    					entity1.addVelocity(moveX, moveY, moveZ);
	    					
	    					((EntityLivingBase) entity1).attackEntityFrom(DamageSource.generic, 1.0F);
	    					
	    				}
	    			
	    		}
			}
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
			
			if(props.getFaction() == 3 && props.getBack() == 3)
			{
				event.setCanceled(true);
			}
			if(props.getFaction() == 3 && props.getLegs() == 3 && player.isCollidedHorizontally)
			{
				event.setCanceled(true);
			}
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
					
                
					BleachMod.network.sendToAll(new ParticleMessage(4, (int)event.entityPlayer.posX, (int)event.entityPlayer.posY, (int)event.entityPlayer.posZ));
                	   	
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
			ExtendedPlayer props = ExtendedPlayer.get(player);
			ItemStack heldItem = player.getCurrentEquippedItem();
			
			ItemStack var9 = player.getEquipmentInSlot(1);
	        ItemStack var10 = player.getEquipmentInSlot(2);
	        ItemStack var11 = player.getEquipmentInSlot(3);
	        
	      //Poison Shikai
			if(heldItem != null)
			{
				if(heldItem.getItem() == BleachItems.shikaipoison)
				{
					if(event.source.getEntity() instanceof EntityLivingBase)
					{
						EntityLivingBase var5 = (EntityLivingBase) event.source.getEntity();
						var5.addPotionEffect(new PotionEffect(Potion.poison.id, 80, 0));
					}
				}
			}
	        
			if(props.getFaction() == 3)
			{
				if(event.source.getEntity() instanceof EntityLivingBase)
				{
					EntityLivingBase hurter = (EntityLivingBase)event.source.getEntity();
					if(props.getBack() == 2)
					{
					
						hurter.attackEntityFrom(DamageSource.generic, 0.5F);
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
							if(heldItem.getItem() instanceof ItemShikai)
								{
					
									if((props.getCurrentEnergy() * props.getCurrentCap()) > event.ammount && player.isBlocking() )
									{

										props.consumeEnergy((int)(event.ammount));
										event.setCanceled(true);
									}
									else if((props.getCurrentEnergy() * props.getCurrentCap()) > event.ammount * 4)
									{
										props.consumeEnergy((int)(event.ammount * 4));
										event.setCanceled(true);
									}
								}
							
							else if((props.getCurrentEnergy() * props.getCurrentCap()) > event.ammount * 6)
							{
								props.consumeEnergy((int)(event.ammount * 6));
								event.setCanceled(true);
							}
					
				
						}
						else 
						{

							if(((props.getCurrentEnergy() * props.getCurrentCap()) > event.ammount * 6))
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
		
		if(event.entityLiving instanceof EntityLivingBase && event.source.getEntity() instanceof EntityPlayer)
		{
			ExtendedPlayer props = ExtendedPlayer.get((EntityPlayer)event.source.getEntity());
			if(props.getFaction() == 3 && ((EntityPlayer)event.source.getEntity()).getHeldItem() == null)
			{
				EntityLivingBase var5 = (EntityLivingBase) event.entityLiving;
				props.addSXP(2);
				
				
				int extraAmount = (int)((props.getCurrentEnergy() * props.getCurrentCap()) / (float)100);
				if(props.getArms() == 1)
					extraAmount += 2;
				var5.attackEntityFrom(DamageSource.generic, event.ammount + extraAmount/(float)2);
				event.setCanceled(true);
				
				if(props.getTail() == 3)
				{
					var5.addPotionEffect(new PotionEffect(Potion.poison.id, 80, 0));
				}
				if(props.getTail() == 3)
				{
					
				}
			}
			
		}
	}
	

//	@SideOnly(Side.CLIENT)
//	HollowRenderer HRenderer = new HollowRenderer();
//	@SideOnly(Side.CLIENT)
//	@SubscribeEvent
//	public void onRenderTick(RenderPlayerEvent.Specials.Pre event)
//	{
//		
//		ExtendedPlayer props = ExtendedPlayer.get(event.entityPlayer);
//		if(props.getFaction() == 3 )
//		{
//			if(!(event.renderer instanceof HollowRenderer))
//			{
//				event.setCanceled(true);
//				HRenderer.doRender((AbstractClientPlayer)event.entity, event.entity.posX, event.entity.posY, event.entity.posZ, 0, 0);
//				
//			}
//		}
//		else
//		{
//			event.setCanceled(false);
//		}
//		
//	}
//	

	
	

	
	
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
	                
							BleachMod.network.sendToAll(new ParticleMessage(4, (int)theTarget.posX, (int)theTarget.posY, (int)theTarget.posZ));
		                	   	
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
		ExtendedPlayer props = ExtendedPlayer.get(event.entityPlayer);
		Vec3 look = event.entityPlayer.getLook(1.0F);
//		if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == Blocks.grass && event.action.equals(Action.RIGHT_CLICK_BLOCK) && !props.getHasBlock())
//		{
//			EntityBlock block = new EntityBlock(event.entityPlayer.worldObj, event.entityPlayer, 1.0F, 0);
//			block.setLocationAndAngles(event.entityPlayer.posX + look.xCoord, event.entityPlayer.posY + look.yCoord, event.entityPlayer.posZ + look.zCoord, 0, 0);
//				event.entityPlayer.worldObj.spawnEntityInWorld(block);
//			props.setHasBlock(true);
//			event.entityPlayer.worldObj.setBlockToAir(event.x, event.y, event.z);
//		}
//		if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == Blocks.dirt && event.action.equals(Action.RIGHT_CLICK_BLOCK) && !props.getHasBlock())
//		{
//			EntityBlock block = new EntityBlock(event.entityPlayer.worldObj, event.entityPlayer, 1.0F, 1);
//			block.setLocationAndAngles(event.entityPlayer.posX + look.xCoord, event.entityPlayer.posY + look.yCoord, event.entityPlayer.posZ + look.zCoord, 0, 0);
//			if(!event.entityPlayer.worldObj.isRemote)
//				event.entityPlayer.worldObj.spawnEntityInWorld(block);
//			props.setHasBlock(true);
//			event.entityPlayer.worldObj.setBlockToAir(event.x, event.y, event.z);
//		}
//		if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == Blocks.stone && event.action.equals(Action.RIGHT_CLICK_BLOCK) && !props.getHasBlock())
//		{
//			EntityBlock block = new EntityBlock(event.entityPlayer.worldObj, event.entityPlayer, 1.0F, 2);
//			block.setLocationAndAngles(event.entityPlayer.posX + look.xCoord, event.entityPlayer.posY + look.yCoord, event.entityPlayer.posZ + look.zCoord, 0, 0);
//			if(!event.entityPlayer.worldObj.isRemote)
//				event.entityPlayer.worldObj.spawnEntityInWorld(block);
//			props.setHasBlock(true);
//			event.entityPlayer.worldObj.setBlockToAir(event.x, event.y, event.z);
//		}
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
