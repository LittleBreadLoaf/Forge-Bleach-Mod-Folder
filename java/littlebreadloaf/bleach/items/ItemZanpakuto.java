package littlebreadloaf.bleach.items;

import java.util.Random;

import littlebreadloaf.bleach.BleachMod;
import littlebreadloaf.bleach.BleachModInfo;
import littlebreadloaf.bleach.Names;
import littlebreadloaf.bleach.api.Tools;
import littlebreadloaf.bleach.armor.Armor;
import littlebreadloaf.bleach.events.ExtendedPlayer;
import littlebreadloaf.bleach.extras.ParticleEffects;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

import com.google.common.collect.Multimap;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemZanpakuto extends ItemSword
{
    private float weaponDamage;
    private final ToolMaterial toolMaterial;
    public float damageBoost = 0;
    public float robeboost = 0;
    public float pantboost = 0;
    public float sandalboost = 0;
    public float waspboost = 0;
    Random rand = new Random();
    
    public ItemZanpakuto(ToolMaterial par2EnumToolReiatsu)
    {
        super(par2EnumToolReiatsu);
        this.toolMaterial = par2EnumToolReiatsu;
        this.maxStackSize = 1;
        this.setMaxDamage(par2EnumToolReiatsu.getMaxUses());
        this.setUnlocalizedName(Names.Zanpakuto_UnlocalizedName);
        this.setCreativeTab(BleachItems.tabBleach);
        this.weaponDamage = 4.0F + par2EnumToolReiatsu.getDamageVsEntity();
    }
    
	@Override
	public float func_150931_i()
    {
        return this.toolMaterial.getDamageVsEntity();
    }

    @Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister icon)
	{
		itemIcon = icon.registerIcon(BleachModInfo.ID.toLowerCase() + ":" + Names.Zanpakuto_UnlocalizedName);
	}
    


    public float getDamage()
    {
		return this.weaponDamage;
    	
    }

    

	@Override
    /**
     * Current implementations of this method in child classes do not use the entry argument beside ev. They just raise
     * the damage on the stack.
     */
    public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
    {
    	EntityPlayer player = (EntityPlayer)par3EntityLivingBase;
		ExtendedPlayer props = (ExtendedPlayer) player.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);
		
		ItemStack var9 = player.inventory.armorInventory[0];
        ItemStack var10 = player.inventory.armorInventory[1];
        ItemStack var11 = player.inventory.armorInventory[2];
        ItemStack var7 = player.inventory.armorInventory[3];
        

        if(var9 != null && (var9.getItem() == Armor.Sandals || var9.getItem() == Armor.ArrancarShoes))
        {
        	sandalboost = 1;
        }
        else if(var9 != null && var9.getItem() == Armor.QuincyShoes)
        {
        	sandalboost = -1;
        }
        else
        {
        	sandalboost = 0;
        }
       
        
        if(var10 != null && (var10.getItem() == Armor.ShiniPants || var10.getItem() == Armor.ArrancarPants))
        {
        	pantboost = 2;
        }
        else if(var10 != null && var10.getItem() == Armor.QuincyPants)
        {
        	pantboost = -1;
        }
        else 
        {
        	pantboost = 0;
        }
        
        
        if(var11 != null && (var11.getItem() == Armor.ShiniRobe || var11.getItem() == Armor.ArrancarPants))
        {
        	robeboost = 3;
        }
        else if(var11 != null && var11.getItem() == Armor.QuincyRobe)
        {
        	robeboost = -2;
        }
        else 
        {
        	robeboost = 0;
        }
        if(var7 != null && var7.getItem() == Armor.GolemHelmet)
    	{
        	if(!player.worldObj.isRemote && props.consumeEnergy(3))
        	{
        		par2EntityLivingBase.setFire(6);
        	}
    	}
    	if(var7 != null && var7.getItem() == Armor.SnakeHelmet)
    	{
    		if(!player.worldObj.isRemote && props.consumeEnergy(3))
        	{
    			par2EntityLivingBase.addPotionEffect(new PotionEffect(Potion.poison.id, 200, 1));
        	}
    	}
    	
    	if(var7 != null && var7.getItem() == Armor.WaspHelmet)
    	{
    		if(!player.worldObj.isRemote)
    		{
    			props.replenishEnergy(1);
    		}
    		
    	}
    	
    	
        
        if(par2EntityLivingBase.getCreatureAttribute() == Tools.SPIRIT)
        {
        	if(!player.worldObj.isRemote && props.getFaction() == 1)
        	{
        		props.addSXP(3);
        	}
        	damageBoost = 2;
        }
        else
        {
        	if(!player.worldObj.isRemote && props.getFaction() == 1)
        	{
        		props.addSXP(1);
        	}
        	damageBoost = 0;
        }
        float damage = this.damageBoost + this.sandalboost + this.pantboost + this.robeboost;
        if(damage > 0 && props.getFaction() == 1 && damage <= par2EntityLivingBase.getHealth())
        {
            par2EntityLivingBase.setHealth(par2EntityLivingBase.getHealth() - damage);
        }
        return true;
    }

   
	@Override
    @SideOnly(Side.CLIENT)

    /**
     * Returns True is the item is renderer in full 3D when hold.
     */
    public boolean isFull3D()
    {
        return true;
    }


	@Override
    public void onCreated(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) 
    {
    	ExtendedPlayer props = (ExtendedPlayer) par3EntityPlayer.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);
    	if(props.getZTex() == 5)
    	{
    		props.randomTexture();
    	}
    }
	

	@Override
    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
        return EnumAction.block;
    }


	@Override
    /**
     * How long it takes to use or consume an item
     */
    public int getMaxItemUseDuration(ItemStack par1ItemStack)
    {
        return 72000;
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    @Override
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
		ExtendedPlayer props = (ExtendedPlayer) par3EntityPlayer.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);
		
		if(par3EntityPlayer.isSneaking())
        {    
        	if(props.getZName().length() <= 0 &&par1ItemStack.hasDisplayName())
        	{
        		props.setZName(par1ItemStack.getDisplayName());
        		
        	
        		
        	
        	}
        	if(props.getZName().length() >= 0)
        	{
        		FMLNetworkHandler.openGui(par3EntityPlayer, BleachMod.instance, 0, par2World, (int)par3EntityPlayer.posX, (int)par3EntityPlayer.posY, (int)par3EntityPlayer.posZ);
        	
        	}
        		
        	if(props.getPoints(9) >= 400)
    		{
    			int check = 1;
    			for(int i = 1; i < 9; i++)
    			{
    				if(props.getPoints(i) > props.getPoints(check))
    				{
    					check = i;
    				}	
    			}
    			if(props.getPoints(check) >= 100)
    			{
    				props.setZType(check);
    				
    				int secondType = 23;
    				for(int j = 1; j< 9; j++)
    				{
    					if(props.getPoints(j) >= props.getPoints(secondType) && j != check)
    					{
    						secondType = j;
    					}
    				}
    				
    				if(props.getPoints(secondType) >= 100)
    				{
    					if((check == 6 && secondType == 7) || (check == 7 && secondType == 6))
    					{
    						props.setZType(10);
    					}
    					else if((check == 7 && secondType == 8) || (check == 8 && secondType == 7))
    					{
    						props.setZType(9);
    					}
    					else if((check == 1 && secondType == 2) || (check == 2 && secondType == 1))
    					{
    						props.setZType(12);
    					}
    				}


        			
    			}
    			else
    			{
    				props.setZType(11);
    			}

    		}
        	
        }
    
        
        return par1ItemStack;
    }

	@Override
	@SideOnly(Side.CLIENT)
    public void onUsingTick(ItemStack stack, EntityPlayer player, int count)
    {
	ExtendedPlayer props = (ExtendedPlayer) player.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);
	  if (props.getCurrentCap() >= 200 &&  props.getPoints(9) >= 400 && stack.hasDisplayName() && stack.getDisplayName().equals(props.getZName()) && props.getFaction() == 1)
      {
		  double var2 = player.posX;
	    	double var3 = player.posY;
	    	double var4 = player.posZ;

	        if(!player.worldObj.isRemote)
	        {
	            ParticleEffects.spawnParticle("spirit", var2 - 0.9, var3 + 1, var4 + 0.5, 0.0D, 0.0D, 0.0D);
	            ParticleEffects.spawnParticle("spirit", var2 - 0.9, var3 + 1, var4 + 0.5, 0.0D, 0.0D, 0.0D);
	        }
	        
	   
      }
    	
        
    }

	@Override
    /**
     * Return the enchantability factor of the item, most of the time is based on material.
     */
    public int getItemEnchantability()
    {
        return this.toolMaterial.getEnchantability();
    }


	@Override
    /**
     * Return the name for this tool's material.
     */
    public String getToolMaterialName()
    {
        return this.toolMaterial.toString();
    }



@Override
    public Multimap getItemAttributeModifiers()
    {
    	float damage = this.getDamage();
        Multimap multimap = super.getItemAttributeModifiers();
        multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Weapon modifier", (double)damage, 0));
        return multimap;
    }
    
    
    
    
    
    

//@Override
//    /**
//     * called when the player releases the use item button. Args: itemstack, world, entityplayer, itemInUseCount
//     */
//    public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer, int par4)
//    {
//        int j = this.getMaxItemUseDuration(par1ItemStack) - par4;
//
//		ExtendedPlayer props = (ExtendedPlayer) par3EntityPlayer.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);
//		
//		 float f = (float)j / 20.0F;
//         f = (f * f + f * 2.0F) / 3.0F;
//
//         if ((double)f < 0.1D)
//         {
//             return;
//         }
//
//         if (f > 1.0F)
//         {
//             f = 1.0F;
//         }
//
//     
//        if (props.getCurrentCap() >= 200 && f == 1.0F && props.getPoints(9) >= 400 && par1ItemStack.hasDisplayName() && par1ItemStack.getDisplayName().equals(props.getZName()) && props.getFaction() == 1)
//        {
//           
//                if(!par2World.isRemote)
//                {	
//                	if(props.getZType() == 1 && props.getZName().equalsIgnoreCase("vox populi"))
//                	{
//                		props.setTexture(5);
//                	}
//                	else if(props.getZType() == 2 && props.getZName().equalsIgnoreCase("ice cream"))
//                	{
//                		props.setTexture(5);
//                	}
//                	else if(props.getZType() == 3 && props.getZName().equalsIgnoreCase("love"))
//                	{
//                		props.setTexture(5);
//                	}
//                	else if(props.getZType() == 4 && props.getZName().equalsIgnoreCase("ashisogi jizo"))
//                	{
//                		props.setTexture(5);
//                	}
//                	else if(props.getZType() == 5 && props.getZName().equalsIgnoreCase("piko piko"))
//                	{
//                		props.setTexture(5);
//                	}
//                	else if(props.getZType() == 6 && props.getZName().equalsIgnoreCase("fightin words"))
//                	{
//                		props.setTexture(5);
//                	}
//                	else if(props.getZType() == 7 && props.getZName().equalsIgnoreCase("master sword"))
//                	{
//                		props.setTexture(5);
//                	}
//                	else if(props.getZType() == 8 && props.getZName().equalsIgnoreCase("souledge"))
//                	{
//                		props.setTexture(5);
//                	}
//                	else if(props.getZType() == 9 && props.getZName().equalsIgnoreCase("zangetsu"))
//                	{
//                		props.setTexture(5);
//                	}
//                	else if(props.getZType() == 10 && props.getZName().equalsIgnoreCase("mjolnir"))
//                	{
//                		props.setTexture(5);
//                	}	
//                	else if(props.getZType() == 12 && props.getZName().equalsIgnoreCase("sakana"))
//                	{
//                		props.setTexture(5);
//                	}
//                	else if(props.getZType() == 11 && props.getZName().equalsIgnoreCase("ticonderoga"))
//                	{
//                		props.setTexture(5);
//                	}
//                	
//                	
//                	
//                	
//                	
//                
//                	
//                	
//                	 if(props.getZType() == 1)
// 	        		{
//                		ItemStack shikai = new ItemStack(BleachItems.shikaifire, 1);
//                		par1ItemStack = shikai;
// 	            		
// 	            		if(props.getZTex() == 0)
// 	            		{
// 	            			par3EntityPlayer.addChatMessage(new ChatComponentText("Bear your fangs," + " " + par1ItemStack.getDisplayName() + "!"));
// 	            		}
// 	            		if(props.getZTex() == 1)
// 	            		{
// 	            			par3EntityPlayer.addChatMessage(new ChatComponentText("Sear," + " " + par1ItemStack.getDisplayName() + "!"));
// 	            		}
// 	            		if(props.getZTex() == 2)
// 	            		{
// 	            			par3EntityPlayer.addChatMessage(new ChatComponentText("Incinerate," + " " + par1ItemStack.getDisplayName() + "!"));
// 	            		}
// 	            		if(props.getZTex() == 3)
// 	            		{
// 	            			par3EntityPlayer.addChatMessage(new ChatComponentText("Ignite," + " " + par1ItemStack.getDisplayName() + "!"));
// 	            		}
// 	            		if(props.getZTex() == 4)
// 	            		{
// 	            			par3EntityPlayer.addChatMessage(new ChatComponentText("Blaze," + " " + par1ItemStack.getDisplayName() + "!"));
// 	            		}
// 	            		if(props.getZTex() == 5)
// 	            		{
// 	            			par3EntityPlayer.addChatMessage(new ChatComponentText("Subscribe," + " " + par1ItemStack.getDisplayName() + "!"));
// 	            		}
// 	        		}
//                	 
//                	 else if(props.getZType() == 2)
// 	        		{
//
//                 		ItemStack shikai = new ItemStack(BleachItems.shikaiice, 1);
//                		par1ItemStack = shikai;
// 	            		
// 	            		if(props.getZTex()== 0)
// 	            		{
// 	            			par3EntityPlayer.addChatMessage(new ChatComponentText("Shiver," + " " + par1ItemStack.getDisplayName() + "!"));
// 	            		}
// 	            		if(props.getZTex() == 1)
// 	            		{
// 	            			par3EntityPlayer.addChatMessage(new ChatComponentText("Chill," + " " + par1ItemStack.getDisplayName() + "!"));
// 	            		}
// 	            		if(props.getZTex() == 2)
// 	            		{
// 	            			par3EntityPlayer.addChatMessage(new ChatComponentText("Cut to the bone," + " " + par1ItemStack.getDisplayName() + "!"));
// 	            		}
// 	            		if(props.getZTex() == 3)
// 	            		{
// 	            			par3EntityPlayer.addChatMessage(new ChatComponentText("Freeze," + " " + par1ItemStack.getDisplayName() + "!"));
// 	            		}
// 	            		if(props.getZTex() == 4)
// 	            		{
// 	            			par3EntityPlayer.addChatMessage(new ChatComponentText("Snow eternally," + " " + par1ItemStack.getDisplayName() + "!"));
// 	            		}
// 	            		if(props.getZTex() == 5)
// 	            		{
// 	            			par3EntityPlayer.addChatMessage(new ChatComponentText("Scream," + " " + par1ItemStack.getDisplayName() + "!"));
// 	            		}
// 	            		if(props.getZTex() == 6)
// 	            		{
// 	 	            		par3EntityPlayer.addChatMessage(new ChatComponentText("Even the odds and conquer," + " " + par1ItemStack.getDisplayName() + "!"));
// 	            		}
// 	            		if(props.getZTex() == 7)
// 	            		{
// 	 	            		par3EntityPlayer.addChatMessage(new ChatComponentText("Sleet," + " " + par1ItemStack.getDisplayName() + "!"));
// 	            		}
// 	            		
// 	        		}
//                	 else if(props.getZType() == 4)
//              		{
//                      	ItemStack shikai = new ItemStack(BleachItems.shikaipoison, 1);
//                   		par1ItemStack = shikai;
//                  		
//                  		if(props.getZTex() == 0)
//                  		{
//                  			par3EntityPlayer.addChatMessage(new ChatComponentText("Sever," + " " + par1ItemStack.getDisplayName() + "!"));
//                  		}
//                  		if(props.getZTex() == 1)
//                  		{
//                  			par3EntityPlayer.addChatMessage(new ChatComponentText("Slither," + " " + par1ItemStack.getDisplayName() + "!"));
//                  		}
//                  		if(props.getZTex() == 2)
//                  		{
//                  			par3EntityPlayer.addChatMessage(new ChatComponentText("Dissolve," + " " + par1ItemStack.getDisplayName() + "!"));
//                  		}
//                  		if(props.getZTex() == 3)
//                  		{
//                  			par3EntityPlayer.addChatMessage(new ChatComponentText("Contaminate," + " " + par1ItemStack.getDisplayName() + "!"));
//                  		}
//                  		if(props.getZTex() == 4)
//                  		{
//                  			par3EntityPlayer.addChatMessage(new ChatComponentText("Spread your toxins," + " " + par1ItemStack.getDisplayName() + "!"));
//                  		}
//                  		if(props.getZTex() == 5)
//                  		{
//                  			par3EntityPlayer.addChatMessage(new ChatComponentText("Rip," + " " + par1ItemStack.getDisplayName() + "!"));
//                  		}
//              		}
//                 	 else if(props.getZType() == 3)
//   	        		{
//                  		 ItemStack shikai = new ItemStack(BleachItems.shikaiheal, 1);
//                   		par1ItemStack = shikai;
//   	            		
//   	            		if(props.getZTex() == 0)
//   	            		{
//   	            			par3EntityPlayer.addChatMessage(new ChatComponentText("Wake up," + " " + par1ItemStack.getDisplayName() + "!"));
//   	            		}
//   	            		if(props.getZTex() == 1)
//   	            		{
//   	            			par3EntityPlayer.addChatMessage(new ChatComponentText("Protect," + " " + par1ItemStack.getDisplayName() + "!"));
//   	            		}
//   	            		if(props.getZTex() == 2)
//   	            		{
//   	            			par3EntityPlayer.addChatMessage(new ChatComponentText("Pierce their heart," + " " + par1ItemStack.getDisplayName() + "!"));
//   	            		}
//   	            		if(props.getZTex() == 3)
//   	            		{
//   	            			par3EntityPlayer.addChatMessage(new ChatComponentText("Restore," + " " + par1ItemStack.getDisplayName() + "!"));
//   	            		}
//   	            		if(props.getZTex() == 4)
//   	            		{
//   	            			par3EntityPlayer.addChatMessage(new ChatComponentText("Heal," + " " + par1ItemStack.getDisplayName() + "!"));
//   	            		}
//   	            		if(props.getZTex() == 5)
//   	            		{
//   	            			par3EntityPlayer.addChatMessage(new ChatComponentText("All you need is love!"));
//   	            		}
//   	        		}
//                  	 
//                 	 
//                	 else if(props.getZType() == 5)
//  	        		{
//                 		 ItemStack shikai = new ItemStack(BleachItems.shikaiearth, 1);
//                    		par1ItemStack = shikai;
//  	            		
//  	            		if(props.getZTex() == 0)
//  	            		{
//  	            			par3EntityPlayer.addChatMessage(new ChatComponentText("Grind to dust," + " " + par1ItemStack.getDisplayName() + "!"));
//  	            		}
//  	            		if(props.getZTex() == 1)
//  	            		{
//  	            			par3EntityPlayer.addChatMessage(new ChatComponentText("Smash," + " " + par1ItemStack.getDisplayName() + "!"));
//  	            		}
//  	            		if(props.getZTex() == 2)
//  	            		{
//  	            			par3EntityPlayer.addChatMessage(new ChatComponentText("Crush your foes," + " " + par1ItemStack.getDisplayName() + "!"));
//  	            		}
//  	            		if(props.getZTex() == 3)
//  	            		{
//  	            			par3EntityPlayer.addChatMessage(new ChatComponentText("Demolish," + " " + par1ItemStack.getDisplayName() + "!"));
//  	            		}
//  	            		if(props.getZTex() == 4)
//  	            		{
//  	            			par3EntityPlayer.addChatMessage(new ChatComponentText("Strike down," + " " + par1ItemStack.getDisplayName() + "!"));
//  	            		}
//  	            		if(props.getZTex() == 5)
//  	            		{
//  	            			par3EntityPlayer.addChatMessage(new ChatComponentText(par1ItemStack.getDisplayName() + "!"));
//  	            		}
//  	        		}
//                 	 
//                 	 else if(props.getZType() == 6)
//   	        		{
//                  		 ItemStack shikai = new ItemStack(BleachItems.shikaiwind, 1);
//                     		par1ItemStack = shikai;
//   	            		
//   	            		if(props.getZTex() == 0)
//   	            		{
//   	            			par3EntityPlayer.addChatMessage(new ChatComponentText("Gale," + " " + par1ItemStack.getDisplayName() + "!"));
//   	            		}
//   	            		if(props.getZTex() == 1)
//   	            		{
//   	            			par3EntityPlayer.addChatMessage(new ChatComponentText("Split," + " " + par1ItemStack.getDisplayName() + "!"));
//   	            		}
//   	            		if(props.getZTex() == 2)
//   	            		{
//   	            			par3EntityPlayer.addChatMessage(new ChatComponentText("Slice," + " " + par1ItemStack.getDisplayName() + "!"));
//   	            		}
//   	            		if(props.getZTex() == 3)
//   	            		{
//   	            			par3EntityPlayer.addChatMessage(new ChatComponentText("Sharpen your blade," + " " + par1ItemStack.getDisplayName() + "!"));
//   	            		}
//   	            		if(props.getZTex() == 4)
//   	            		{
//   	            			par3EntityPlayer.addChatMessage(new ChatComponentText("Reach to the heavens," + " " + par1ItemStack.getDisplayName() + "!"));
//   	            		}
//   	            		if(props.getZTex() == 5)
//   	            		{
//   	            			par3EntityPlayer.addChatMessage(new ChatComponentText("These be fightin' words!"));
//   	            		}
//   	            		if(props.getZTex() == 6)
//   	            		{
//   	            			par3EntityPlayer.addChatMessage(new ChatComponentText("Undulatis, blow everything away!"));
//   	            		}
//   	            		if(props.getZTex() == 7)
//   	            		{
//   	            			par3EntityPlayer.addChatMessage(new ChatComponentText("Split the sky, Halinfeil"));
//   	            		}
//   	            		if(props.getZTex() == 8)
//   	            		{
//   	            			par3EntityPlayer.addChatMessage(new ChatComponentText("Kros, Cry Havoc!"));
//   	            		}
//   	        		}
//                 	 
//                	
//                	
//                	 else if(props.getZType() == 7)
//   	        		{
//                  		 ItemStack shikai = new ItemStack(BleachItems.shikailight, 1);
//                     		par1ItemStack = shikai;
//   	            		
//   	            		if(props.getZTex() == 0)
//   	            		{
//   	            			par3EntityPlayer.addChatMessage(new ChatComponentText("Alight," + " " + par1ItemStack.getDisplayName() + "!"));
//   	            		}
//   	            		if(props.getZTex() == 1)
//   	            		{
//   	            			par3EntityPlayer.addChatMessage(new ChatComponentText("Shine," + " " + par1ItemStack.getDisplayName() + "!"));
//   	            		}
//   	            		if(props.getZTex() == 2)
//   	            		{
//   	            			par3EntityPlayer.addChatMessage(new ChatComponentText("Pierce the dark," + " " + par1ItemStack.getDisplayName() + "!"));
//   	            		}
//   	            		if(props.getZTex() == 3)
//   	            		{
//   	            			par3EntityPlayer.addChatMessage(new ChatComponentText("Intensify," + " " + par1ItemStack.getDisplayName() + "!"));
//   	            		}
//   	            		if(props.getZTex() == 4)
//  	            		{
//  	            			par3EntityPlayer.addChatMessage(new ChatComponentText("Divine," + " " + par1ItemStack.getDisplayName() + "!"));
//  	            		}
//   	            		if(props.getZTex() == 5)
//   	            		{
//   	            			par3EntityPlayer.addChatMessage(new ChatComponentText("Hey, listen!"));
//   	            		}
//   	        		}
//                	 
//                	 else if(props.getZType() == 8)
//    	        		{
//                   		 ItemStack shikai = new ItemStack(BleachItems.shikaidark, 1);
//                      		par1ItemStack = shikai;
//    	            		
//    	            		if(props.getZTex() == 0)
//    	            		{
//    	            			par3EntityPlayer.addChatMessage(new ChatComponentText("Darken the sky," + " " + par1ItemStack.getDisplayName() + "!"));
//    	            		}
//    	            		if(props.getZTex() == 1)
//    	            		{
//    	            			par3EntityPlayer.addChatMessage(new ChatComponentText("Scythe," + " " + par1ItemStack.getDisplayName() + "!"));
//    	            		}
//    	            		if(props.getZTex() == 2)
//    	            		{
//    	            			par3EntityPlayer.addChatMessage(new ChatComponentText("Cut to shreds," + " " + par1ItemStack.getDisplayName() + "!"));
//    	            		}
//    	            		if(props.getZTex() == 3)
//    	            		{
//    	            			par3EntityPlayer.addChatMessage(new ChatComponentText("Ensnare," + " " + par1ItemStack.getDisplayName() + "!"));
//    	            		}
//    	            		if(props.getZTex() == 4)
//      	            		{
//      	            			par3EntityPlayer.addChatMessage(new ChatComponentText("Veil in darkness," + " " + par1ItemStack.getDisplayName() + "!"));
//      	            		}
//    	            		if(props.getZTex() == 5)
//    	            		{
//    	            			par3EntityPlayer.addChatMessage(new ChatComponentText("I will show you the greatest nightmare!"));
//    	            		}
//    	            		if(props.getZTex() == 6)
//    	            		{
//    	            			par3EntityPlayer.addChatMessage(new ChatComponentText("Lurk in the shadows, Kage Kishi!"));
//    	            		}
//    	            		if(props.getZTex() == 7)
//    	            		{
//    	            			par3EntityPlayer.addChatMessage(new ChatComponentText("Bring Balance, Onmyo!"));
//    	            		}
//    	            		if(props.getZTex() == 8)
//    	            		{
//    	            			par3EntityPlayer.addChatMessage(new ChatComponentText("Scratch, Neko Senro!"));
//    	            		}
//    	            		if(props.getZTex() == 9)
//    	            		{
//    	            			par3EntityPlayer.addChatMessage(new ChatComponentText("Shred our enemies, Kumori Tora Tsume!"));
//    	            		}
//    	        		}
//                	 else if(props.getZType() == 9)
//  	        		{
//                 		 ItemStack shikai = new ItemStack(BleachItems.shikailunar, 1);
//                    		par1ItemStack = shikai;
//  	            		
//  	            		if(props.getZTex() == 0)
//  	            		{
//  	            			par3EntityPlayer.addChatMessage(new ChatComponentText("Cut deeply," + " " + par1ItemStack.getDisplayName() + "!"));
//  	            		}
//  	            		if(props.getZTex() == 1)
//  	            		{
//  	            			par3EntityPlayer.addChatMessage(new ChatComponentText("Awaken," + " " + par1ItemStack.getDisplayName() + "!"));
//  	            		}
//  	            		if(props.getZTex() == 2)
//  	            		{
//  	            			par3EntityPlayer.addChatMessage(new ChatComponentText("Disperse the clouds," + " " + par1ItemStack.getDisplayName() + "!"));
//  	            		}
//  	            		if(props.getZTex() == 3)
//  	            		{
//  	            			par3EntityPlayer.addChatMessage(new ChatComponentText("Embrace the twilight," + " " + par1ItemStack.getDisplayName() + "!"));
//  	            		}
//  	            		if(props.getZTex() == 4)
//  	            		{
//  	            			par3EntityPlayer.addChatMessage(new ChatComponentText("Shimmer," + " " + par1ItemStack.getDisplayName() + "!"));
//  	            		}
//  	            		if(props.getZTex() == 5)
//  	            		{
//  	            			par3EntityPlayer.addChatMessage(new ChatComponentText(par1ItemStack.getDisplayName()));
//  	            		}
//  	        		}
//                	 else if(props.getZType() == 10)
//  	        		{
//                 		 ItemStack shikai = new ItemStack(BleachItems.shikailightning, 1);
//                    		par1ItemStack = shikai;
//  	            		
//  	            		if(props.getZTex() == 0)
//  	            		{
//  	            			par3EntityPlayer.addChatMessage(new ChatComponentText("Gather a storm," + " " + par1ItemStack.getDisplayName() + "!"));
//  	            		}
//  	            		if(props.getZTex() == 1)
//  	            		{
//  	            			par3EntityPlayer.addChatMessage(new ChatComponentText("Electrocute," + " " + par1ItemStack.getDisplayName() + "!"));
//  	            		}
//  	            		if(props.getZTex() == 2)
//  	            		{
//  	            			par3EntityPlayer.addChatMessage(new ChatComponentText("Crackle," + " " + par1ItemStack.getDisplayName() + "!"));
//  	            		}
//  	            		if(props.getZTex() == 3)
//  	            		{
//  	            			par3EntityPlayer.addChatMessage(new ChatComponentText("Flash," + " " + par1ItemStack.getDisplayName() + "!"));
//  	            		}
//  	            		if(props.getZTex() == 4)
//   	            		{
//   	            			par3EntityPlayer.addChatMessage(new ChatComponentText("Flash across the sky," + " " + par1ItemStack.getDisplayName() + "!"));
//   	            		}
//  	            		if(props.getZTex() == 5)
//  	            		{
//  	            			par3EntityPlayer.addChatMessage(new ChatComponentText("Mjolnir!"));
//  	            		}
//  	        		}
//                	 else if(props.getZType() == 11)
//    	        		{
//                   		 ItemStack shikai = new ItemStack(BleachItems.shikainormal, 1);
//                      		par1ItemStack = shikai;
//    	            		
//    	            		if(props.getZTex() == 0)
//    	            		{
//    	            			par3EntityPlayer.addChatMessage(new ChatComponentText("Strike true," + " " + par1ItemStack.getDisplayName() + "!"));
//    	            		}
//    	            		if(props.getZTex() == 1)
//    	            		{
//    	            			par3EntityPlayer.addChatMessage(new ChatComponentText("Rip apart," + " " + par1ItemStack.getDisplayName() + "!"));
//    	            		}
//    	            		if(props.getZTex() == 2)
//    	            		{
//    	            			par3EntityPlayer.addChatMessage(new ChatComponentText("Go forth," + " " + par1ItemStack.getDisplayName() + "!"));
//    	            		}
//    	            		if(props.getZTex() == 3)
//    	            		{
//    	            			par3EntityPlayer.addChatMessage(new ChatComponentText("Devastate," + " " + par1ItemStack.getDisplayName() + "!"));
//    	            		}
//    	            		if(props.getZTex() == 4)
//      	            		{
//      	            			par3EntityPlayer.addChatMessage(new ChatComponentText("Shake the Earth," + " " + par1ItemStack.getDisplayName() + "!"));
//      	            		}
//    	            		if(props.getZTex() == 5)
//    	            		{
//    	            			par3EntityPlayer.addChatMessage(new ChatComponentText("Draw," + " " + par1ItemStack.getDisplayName() + "!"));
//    	            		}
//    	            		if(props.getZTex() == 6)
//       	            		{
//       	            			par3EntityPlayer.addChatMessage(new ChatComponentText("Setsuna!"));
//       	            		}
//    	        		}
//                	 else if(props.getZType() == 12)
//    	        		{
//                   		 ItemStack shikai = new ItemStack(BleachItems.shikaiwater, 1);
//                      		par1ItemStack = shikai;
//    	            		
//    	            		if(props.getZTex() == 0)
//    	            		{
//    	            			par3EntityPlayer.addChatMessage(new ChatComponentText("Impale," + " " + par1ItemStack.getDisplayName() + "!"));
//    	            		}
//    	            		if(props.getZTex() == 1)
//    	            		{
//    	            			par3EntityPlayer.addChatMessage(new ChatComponentText("Rage the seas," + " " + par1ItemStack.getDisplayName() + "!"));
//    	            		}
//    	            		if(props.getZTex() == 2)
//    	            		{
//    	            			par3EntityPlayer.addChatMessage(new ChatComponentText("Rain," + " " + par1ItemStack.getDisplayName() + "!"));
//    	            		}
//    	            		if(props.getZTex() == 3)
//    	            		{
//    	            			par3EntityPlayer.addChatMessage(new ChatComponentText("Anchor's away," + " " + par1ItemStack.getDisplayName() + "!"));
//    	            		}
//    	            		if(props.getZTex() == 4)
//    	            		{
//   	            			par3EntityPlayer.addChatMessage(new ChatComponentText("Swash and buckle," + " " + par1ItemStack.getDisplayName() + "!"));
//    	            		}
//    	            		if(props.getZTex() == 5)
//    	            		{
//    	            			par3EntityPlayer.addChatMessage(new ChatComponentText("Swim," + " " + par1ItemStack.getDisplayName() + "!"));
//    	            		}
//    	            		if(props.getZTex() == 6)
//    	            		{
//    	            			par3EntityPlayer.addChatMessage(new ChatComponentText("Hi-Yari!"));
//    	            		}
//    	        		}
//                 	 
//                }
//
//                
//            
//
//
//            
//        }
//        
//        
//    }
    
    
//    public void onUpdate(ItemStack var1, World var2, Entity var3, int var4, boolean var5)
//    {
//    	EntityPlayer player = (EntityPlayer)var3;
//    	ExtendedPlayer props = (ExtendedPlayer) player.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);
//    	
//        if(player.username.equalsIgnoreCase("_jad3n"))
//    	{
//        	if( props.getZName().equals("Undulatis") && props.getZTex() != 6)
//        	{
//        		props.setType(3);
//        		props.setTexture(6);
//        	}
//        	else if(!props.getZName().equals("Undulatis") && props.getZTex() == 6)
//        	{
//        		props.setTexture(rand.nextInt(5));
//        	}
//    	}
//    	else if(player.username.equalsIgnoreCase("Poofy96") )
//    		{    		if( props.getZName().equals("Mizore") && props.getZTex() != 6)
//    		{
//        		props.setType(1);
//        		props.setTexture(6);
//    		}
//    		else if(!props.getZName().equals("Mizore") && props.getZTex() == 6)
//        	{
//        		props.setTexture(rand.nextInt(5));
//        	}
//    	}
//    	else if(player.username.equalsIgnoreCase("JoeTheAntiPro"))
//    	{
//    		if( props.getZName().equals("Zenhansha") && props.getZTex() != 7)
//    		{
//        		props.setType(10);
//        		props.setTexture(7);	
//    		}
//    		else if(!props.getZName().equals("Zenhansha") && props.getZTex() == 7)
//        	{
//        		props.setTexture(rand.nextInt(5));
//        	}
//    	}
//    	else if(player.username.equalsIgnoreCase("theagirl") )
//    	{
//    		if( props.getZName().equals("Setsuna") && props.getZTex() != 6)
//    		{
//    		props.setType(10);
//    		props.setTexture(6);
//    		}
//    		else if(!props.getZName().equals("Setsuna") && props.getZTex() == 6)
//        	{
//        		props.setTexture(rand.nextInt(5));
//        	}
//    	}
//    	else if(player.username.equalsIgnoreCase("jrich144"))
//    	{
//    		if( props.getZName().equals("Kage Kishi") && props.getZTex() != 6)
//    		{
//    		props.setType(7);
//    		props.setTexture(6);
//    		}
//    		else if(!props.getZName().equals("Kage Kishi") && props.getZTex() == 6)
//        	{
//        		props.setTexture(rand.nextInt(5));
//        	}
//    	}
//    	else if(player.username.equalsIgnoreCase("blueberry22") )
//    	{
//    		if(props.getZName().equals("Halinfeil") && props.getZTex() != 7)
//    		{
//    		props.setType(3);
//    		props.setTexture(7);
//    		}
//    		else if(!props.getZName().equals("Halinfeil") && props.getZTex() == 7)
//        	{
//        		props.setTexture(rand.nextInt(5));
//        	}
//    	}  
//    	else if(player.username.equalsIgnoreCase("thecodymaverick") )
//    	{
//    		if( props.getZName().equals("Hi-Yari") && props.getZTex() != 6)
//    		{
//        		props.setType(11);
//        		props.setTexture(6);
//    		}
//    		else if(!props.getZName().equals("Hi-Yari") && props.getZTex() == 6)
//        	{
//       		props.setTexture(rand.nextInt(5));
//        	}
//    	
//    	}
//    	else if(player.username.equalsIgnoreCase("ahern14") )
//        {
//        	if( props.getZName().equals("Onmyo") && props.getZTex() != 7)
//        	{
//            	props.setType(7);
//            	props.setTexture(7);
//        	}
//        	else if(!props.getZName().equals("Onmyo") && props.getZTex() == 7)
//            {
//        		props.setTexture(rand.nextInt(5));
//            }
//        }
//    	else if(player.username.equalsIgnoreCase("Skykros") )
//        {
//        	if( props.getZName().equals("Kros") && props.getZTex() != 8)
//        	{
//            	props.setType(3);
//            	props.setTexture(8);
//        	}
//        	else if(!props.getZName().equals("Kros") && props.getZTex() == 8)
//            {
//        		props.setTexture(rand.nextInt(5));
//            }
//        }
//    	else if(player.username.equalsIgnoreCase("ChibiNekoHime") )
//        {
//        	if( props.getZName().equals("Neko Senro") && props.getZTex() != 8)
//        	{
//            	props.setType(7);
//            	props.setTexture(8);
//        	}
//        	else if(!props.getZName().equals("Neko Senro") && props.getZTex() == 8)
//            {
//        		props.setTexture(rand.nextInt(5));
//            }
//        }
//    	else if(player.username.equalsIgnoreCase("ChibiNekoHime") )
//        {
//        	if( props.getZName().equals("Kumori Tora Tsume") && props.getZTex() != 9)
//        	{
//            	props.setType(7);
//            	props.setTexture(9);
//        	}
//        	else if(!props.getZName().equals("Kumori Tora Tsume") && props.getZTex() == 9)
//            {
//        		props.setTexture(rand.nextInt(5));
//            }
//        }
//        
//   
//}
}
