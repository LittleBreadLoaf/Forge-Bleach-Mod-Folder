package littlebreadloaf.bleach.items;

import java.util.Random;

import littlebreadloaf.bleach.BleachMod;
import littlebreadloaf.bleach.BleachModInfo;
import littlebreadloaf.bleach.Names;
import littlebreadloaf.bleach.api.Tools;
import littlebreadloaf.bleach.armor.Armor;
import littlebreadloaf.bleach.entities.EntityEnergyArrow;
import littlebreadloaf.bleach.entities.EntitySeeleArrow;
import littlebreadloaf.bleach.events.ExtendedPlayer;
import littlebreadloaf.bleach.extras.ParticleEffects;
import littlebreadloaf.bleach.extras.ShikaiKeyBind;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;

import com.google.common.collect.Multimap;

import cpw.mods.fml.common.network.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemZanpakuto extends ItemSword
{
    private float weaponDamage;
    private final EnumToolMaterial toolMaterial;
    public float damageBoost = 0;
    public float robeboost = 0;
    public float pantboost = 0;
    public float sandalboost = 0;
    public float waspboost = 0;
    Random rand = new Random();
    
    public ItemZanpakuto(int par1, EnumToolMaterial par2EnumToolReiatsu)
    {
        super(par1, par2EnumToolReiatsu);
        this.toolMaterial = par2EnumToolReiatsu;
        this.maxStackSize = 1;
        this.setMaxDamage(par2EnumToolReiatsu.getMaxUses());
        this.setCreativeTab(BleachItems.tabBleach);
        this.weaponDamage = 4.0F + par2EnumToolReiatsu.getDamageVsEntity();
    }

    public float func_82803_g()
    {
        return this.toolMaterial.getDamageVsEntity();
    }

    @Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon)
	{
		itemIcon = icon.registerIcon(BleachModInfo.ID.toLowerCase() + ":" + Names.Zanpakuto_UnlocalizedName);
	}
    
    /**
     * Returns the strength of the stack against a given block. 1.0F base, (Quality+1)*2 if correct blocktype, 1.5F if
     * sword
     */
    public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block)
    {
        if (par2Block.blockID == Block.web.blockID)
        {
            return 15.0F;
        }
        else
        {
            Material material = par2Block.blockMaterial;
            return material != Material.plants && material != Material.vine && material != Material.coral && material != Material.leaves && material != Material.pumpkin ? 1.0F : 1.5F;
        }
    }
    
    public float getDamage()
    {
		return this.weaponDamage;
    	
    }

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
        

        if(var9 != null && (var9.itemID == Armor.Sandals.itemID || var9.itemID == Armor.ArrancarShoes.itemID))
        {
        	sandalboost = 1;
        }
        else if(var9 != null && var9.itemID == Armor.QuincyShoes.itemID)
        {
        	sandalboost = -1;
        }
        else
        {
        	sandalboost = 0;
        }
       
        
        if(var10 != null && (var10.itemID == Armor.ShiniPants.itemID || var10.itemID == Armor.ArrancarPants.itemID))
        {
        	pantboost = 2;
        }
        else if(var10 != null && var10.itemID == Armor.QuincyPants.itemID)
        {
        	pantboost = -1;
        }
        else 
        {
        	pantboost = 0;
        }
        
        
        if(var11 != null && (var11.itemID == Armor.ShiniRobe.itemID || var11.itemID == Armor.ArrancarPants.itemID))
        {
        	robeboost = 3;
        }
        else if(var11 != null && var11.itemID == Armor.QuincyRobe.itemID)
        {
        	robeboost = -2;
        }
        else 
        {
        	robeboost = 0;
        }
        if(var7 != null && var7.itemID == Armor.GolemHelmet.itemID)
    	{
        	if(!player.worldObj.isRemote && props.consumeEnergy(3))
        	{
        		par2EntityLivingBase.setFire(6);
        	}
    	}
    	if(var7 != null && var7.itemID == Armor.SnakeHelmet.itemID)
    	{
    		if(!player.worldObj.isRemote && props.consumeEnergy(3))
        	{
    			par2EntityLivingBase.addPotionEffect(new PotionEffect(Potion.poison.id, 200, 1));
        	}
    	}
    	
    	if(var7 != null && var7.itemID == Armor.WaspHelmet.itemID)
    	{
    		if(!player.worldObj.isRemote)
    		{
    			props.replenishEnergy(1);
    		}
    		
    	}
    	
    	
        
        if(par2EntityLivingBase.getCreatureAttribute() == Tools.SPIRIT)
        {
        	if(!player.worldObj.isRemote)
        	{
        		props.addSXP(3);
        	}
        	damageBoost = 2;
        }
        else
        {
        	if(!player.worldObj.isRemote)
        	{
        		props.addSXP(1);
        	}
        	damageBoost = 0;
        }
        float damage = this.damageBoost + this.sandalboost + this.pantboost + this.robeboost;
        if(damage > 0 && props.getFaction() == 1)
        {
            par2EntityLivingBase.setHealth(par2EntityLivingBase.getHealth() - damage);
        }
        return true;
    }

    public boolean onBlockDestroyed(ItemStack par1ItemStack, World par2World, int par3, int par4, int par5, int par6, EntityLivingBase par7EntityLivingBase)
    {
        if ((double)Block.blocksList[par3].getBlockHardness(par2World, par4, par5, par6) != 0.0D)
        {
            par1ItemStack.damageItem(2, par7EntityLivingBase);
        }

        return true;
    }

    @SideOnly(Side.CLIENT)

    /**
     * Returns True is the item is renderer in full 3D when hold.
     */
    public boolean isFull3D()
    {
        return true;
    }

    
    public void onCreated(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) 
    {
    	ExtendedPlayer props = (ExtendedPlayer) par3EntityPlayer.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);
    	if(props.getZTex() == 5)
    	{
    		props.randomTexture();
    	}
    }
    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
        return EnumAction.block;
    }

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
        		
        	
        }
    
        
        return par1ItemStack;
    }
    
@SideOnly(Side.CLIENT)
    public void onUsingItemTick(ItemStack stack, EntityPlayer player, int count)
    {
	ExtendedPlayer props = (ExtendedPlayer) player.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);
	  if (props.getCurrentCap() >= 200 &&  props.getPoints(9) >= 400 && stack.hasDisplayName() && stack.getDisplayName().equals(props.getZName()) && props.getFaction() == 1)
      {
		  double var2 = player.posX;
	    	double var3 = player.posY;
	    	double var4 = player.posZ;

	        double var6 = (double)((float)var2 + 0.5F );
	        double var10 = (double)((float)var4 + 0.5F);
	        if(!player.worldObj.isRemote)
	        {
	            ParticleEffects.spawnParticle("spirit", var2 - 0.9, var3 + 1, var4 + 0.5, 0.0D, 0.0D, 0.0D);
	            ParticleEffects.spawnParticle("spirit", var2 - 0.9, var3 + 1, var4 + 0.5, 0.0D, 0.0D, 0.0D);
	        }
	        
	   
      }
	  System.out.println(props.getZTotal());
    	
        
    }

    /**
     * Returns if the item (tool) can harvest results from the block type.
     */
    public boolean canHarvestBlock(Block par1Block)
    {
        return par1Block.blockID == Block.web.blockID;
    }

    /**
     * Return the enchantability factor of the item, most of the time is based on material.
     */
    public int getItemEnchantability()
    {
        return this.toolMaterial.getEnchantability();
    }

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
    
    
    
    
    
    

    /**
     * called when the player releases the use item button. Args: itemstack, world, entityplayer, itemInUseCount
     */
    public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer, int par4)
    {
        int j = this.getMaxItemUseDuration(par1ItemStack) - par4;

		ExtendedPlayer props = (ExtendedPlayer) par3EntityPlayer.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);
		
		 float f = (float)j / 20.0F;
         f = (f * f + f * 2.0F) / 3.0F;

         if ((double)f < 0.1D)
         {
             return;
         }

         if (f > 1.0F)
         {
             f = 1.0F;
         }

     
        if (props.getCurrentCap() >= 200 && f == 1.0F && props.getPoints(9) >= 400 && par1ItemStack.hasDisplayName() && par1ItemStack.getDisplayName().equals(props.getZName()) && props.getFaction() == 1)
        {
           
                if(!par2World.isRemote)
                {	
                	if(props.getZType() == 1 && props.getZName().equalsIgnoreCase("vox populi"))
                	{
                		props.setTexture(5);
                	}
                	else if(props.getZType() == 2 && props.getZName().equalsIgnoreCase("ice cream"))
                	{
                		props.setTexture(5);
                	}
                	else if(props.getZType() == 3 && props.getZName().equalsIgnoreCase("love"))
                	{
                		props.setTexture(5);
                	}
                	else if(props.getZType() == 4 && props.getZName().equalsIgnoreCase("ashisogi jizo"))
                	{
                		props.setTexture(5);
                	}
                	else if(props.getZType() == 5 && props.getZName().equalsIgnoreCase("piko piko"))
                	{
                		props.setTexture(5);
                	}
                	else if(props.getZType() == 6 && props.getZName().equalsIgnoreCase("fightin words"))
                	{
                		props.setTexture(5);
                	}
                	else if(props.getZType() == 7 && props.getZName().equalsIgnoreCase("master sword"))
                	{
                		props.setTexture(5);
                	}
                	else if(props.getZType() == 8 && props.getZName().equalsIgnoreCase("souledge"))
                	{
                		props.setTexture(5);
                	}
                	else if(props.getZType() == 10 && props.getZName().equalsIgnoreCase("zangetsu"))
                	{
                		props.setTexture(5);
                	}
                	else if(props.getZType() == 9 && props.getZName().equalsIgnoreCase("mjolnir"))
                	{
                		props.setTexture(5);
                	}	
                	else if(props.getZType() == 11 && props.getZName().equalsIgnoreCase("sakana"))
                	{
                		props.setTexture(5);
                	}
                	else if(props.getZType() == 12 && props.getZName().equalsIgnoreCase("ticonderoga"))
                	{
                		props.setTexture(5);
                	}
                	
                	
                	
                	
                	
                
                	
                	
                	 if(props.getZType() == 1)
 	        		{
                		ItemStack shikai = new ItemStack(BleachItems.shikaifire, 1);
                		par1ItemStack.itemID = shikai.itemID;
 	            		
 	            		if(props.getZTex() == 0)
 	            		{
 	            			par3EntityPlayer.addChatMessage("Bear your fangs," + " " + par1ItemStack.getDisplayName() + "!");
 	            		}
 	            		if(props.getZTex() == 1)
 	            		{
 	            			par3EntityPlayer.addChatMessage("Sear," + " " + par1ItemStack.getDisplayName() + "!");
 	            		}
 	            		if(props.getZTex() == 2)
 	            		{
 	            			par3EntityPlayer.addChatMessage("Incinerate," + " " + par1ItemStack.getDisplayName() + "!");
 	            		}
 	            		if(props.getZTex() == 3)
 	            		{
 	            			par3EntityPlayer.addChatMessage("Ignite," + " " + par1ItemStack.getDisplayName() + "!");
 	            		}
 	            		if(props.getZTex() == 4)
 	            		{
 	            			par3EntityPlayer.addChatMessage("Blaze," + " " + par1ItemStack.getDisplayName() + "!");
 	            		}
 	            		if(props.getZTex() == 5)
 	            		{
 	            			par3EntityPlayer.addChatMessage("Subscribe," + " " + par1ItemStack.getDisplayName() + "!");
 	            		}
 	        		}
                	 
                	 else if(props.getZType() == 2)
 	        		{

                 		ItemStack shikai = new ItemStack(BleachItems.shikaiice, 1);
                		par1ItemStack.itemID = shikai.itemID;
 	            		
 	            		if(props.getZTex()== 0)
 	            		{
 	            			par3EntityPlayer.addChatMessage("Shiver," + " " + par1ItemStack.getDisplayName() + "!");
 	            		}
 	            		if(props.getZTex() == 1)
 	            		{
 	            			par3EntityPlayer.addChatMessage("Chill," + " " + par1ItemStack.getDisplayName() + "!");
 	            		}
 	            		if(props.getZTex() == 2)
 	            		{
 	            			par3EntityPlayer.addChatMessage("Cut to the bone," + " " + par1ItemStack.getDisplayName() + "!");
 	            		}
 	            		if(props.getZTex() == 3)
 	            		{
 	            			par3EntityPlayer.addChatMessage("Freeze," + " " + par1ItemStack.getDisplayName() + "!");
 	            		}
 	            		if(props.getZTex() == 4)
 	            		{
 	            			par3EntityPlayer.addChatMessage("Snow eternally," + " " + par1ItemStack.getDisplayName() + "!");
 	            		}
 	            		if(props.getZTex() == 5)
 	            		{
 	            			par3EntityPlayer.addChatMessage("Scream," + " " + par1ItemStack.getDisplayName() + "!");
 	            		}
 	            		if(props.getZTex() == 6)
 	            		{
 	 	            		par3EntityPlayer.addChatMessage("Even the odds and conquer," + " " + par1ItemStack.getDisplayName() + "!");
 	            		}
 	            		if(props.getZTex() == 7)
 	            		{
 	 	            		par3EntityPlayer.addChatMessage("Sleet," + " " + par1ItemStack.getDisplayName() + "!");
 	            		}
 	            		
 	        		}
                	 
                	 else if(props.getZType() == 3)
 	        		{
                		 ItemStack shikai = new ItemStack(BleachItems.shikaiheal, 1);
                 		par1ItemStack.itemID = shikai.itemID;
 	            		
 	            		if(props.getZTex() == 0)
 	            		{
 	            			par3EntityPlayer.addChatMessage("Wake up," + " " + par1ItemStack.getDisplayName() + "!");
 	            		}
 	            		if(props.getZTex() == 1)
 	            		{
 	            			par3EntityPlayer.addChatMessage("Protect," + " " + par1ItemStack.getDisplayName() + "!");
 	            		}
 	            		if(props.getZTex() == 2)
 	            		{
 	            			par3EntityPlayer.addChatMessage("Pierce their heart," + " " + par1ItemStack.getDisplayName() + "!");
 	            		}
 	            		if(props.getZTex() == 3)
 	            		{
 	            			par3EntityPlayer.addChatMessage("Restore," + " " + par1ItemStack.getDisplayName() + "!");
 	            		}
 	            		if(props.getZTex() == 4)
 	            		{
 	            			par3EntityPlayer.addChatMessage("Heal," + " " + par1ItemStack.getDisplayName() + "!");
 	            		}
 	            		if(props.getZTex() == 5)
 	            		{
 	            			par3EntityPlayer.addChatMessage("All you need is love!");
 	            		}
 	        		}
                	 
                	 else if(props.getZType() == 4)
             		{
                     	ItemStack shikai = new ItemStack(BleachItems.shikaipoison, 1);
                  		par1ItemStack.itemID = shikai.itemID;
                 		
                 		if(props.getZTex() == 0)
                 		{
                 			par3EntityPlayer.addChatMessage("Sever," + " " + par1ItemStack.getDisplayName() + "!");
                 		}
                 		if(props.getZTex() == 1)
                 		{
                 			par3EntityPlayer.addChatMessage("Slither," + " " + par1ItemStack.getDisplayName() + "!");
                 		}
                 		if(props.getZTex() == 2)
                 		{
                 			par3EntityPlayer.addChatMessage("Dissolve," + " " + par1ItemStack.getDisplayName() + "!");
                 		}
                 		if(props.getZTex() == 3)
                 		{
                 			par3EntityPlayer.addChatMessage("Contaminate," + " " + par1ItemStack.getDisplayName() + "!");
                 		}
                 		if(props.getZTex() == 4)
                 		{
                 			par3EntityPlayer.addChatMessage("Spread your toxins," + " " + par1ItemStack.getDisplayName() + "!");
                 		}
                 		if(props.getZTex() == 5)
                 		{
                 			par3EntityPlayer.addChatMessage("Rip," + " " + par1ItemStack.getDisplayName() + "!");
                 		}
             		}
                	 
                	 else if(props.getZType() == 5)
 	        		{
                		 ItemStack shikai = new ItemStack(BleachItems.shikaiearth, 1);
                   		par1ItemStack.itemID = shikai.itemID;
 	            		
 	            		if(props.getZTex() == 0)
 	            		{
 	            			par3EntityPlayer.addChatMessage("Grind to dust," + " " + par1ItemStack.getDisplayName() + "!");
 	            		}
 	            		if(props.getZTex() == 1)
 	            		{
 	            			par3EntityPlayer.addChatMessage("Smash," + " " + par1ItemStack.getDisplayName() + "!");
 	            		}
 	            		if(props.getZTex() == 2)
 	            		{
 	            			par3EntityPlayer.addChatMessage("Crush your foes," + " " + par1ItemStack.getDisplayName() + "!");
 	            		}
 	            		if(props.getZTex() == 3)
 	            		{
 	            			par3EntityPlayer.addChatMessage("Demolish," + " " + par1ItemStack.getDisplayName() + "!");
 	            		}
 	            		if(props.getZTex() == 4)
 	            		{
 	            			par3EntityPlayer.addChatMessage("Strike down," + " " + par1ItemStack.getDisplayName() + "!");
 	            		}
 	            		if(props.getZTex() == 5)
 	            		{
 	            			par3EntityPlayer.addChatMessage(par1ItemStack.getDisplayName() + "!");
 	            		}
 	        		}
                	 
                	 else if(props.getZType() == 6)
  	        		{
                 		 ItemStack shikai = new ItemStack(BleachItems.shikaiwind, 1);
                    		par1ItemStack.itemID = shikai.itemID;
  	            		
  	            		if(props.getZTex() == 0)
  	            		{
  	            			par3EntityPlayer.addChatMessage("Gale," + " " + par1ItemStack.getDisplayName() + "!");
  	            		}
  	            		if(props.getZTex() == 1)
  	            		{
  	            			par3EntityPlayer.addChatMessage("Split," + " " + par1ItemStack.getDisplayName() + "!");
  	            		}
  	            		if(props.getZTex() == 2)
  	            		{
  	            			par3EntityPlayer.addChatMessage("Slice," + " " + par1ItemStack.getDisplayName() + "!");
  	            		}
  	            		if(props.getZTex() == 3)
  	            		{
  	            			par3EntityPlayer.addChatMessage("Sharpen your blade," + " " + par1ItemStack.getDisplayName() + "!");
  	            		}
  	            		if(props.getZTex() == 4)
  	            		{
  	            			par3EntityPlayer.addChatMessage("Reach to the heavens," + " " + par1ItemStack.getDisplayName() + "!");
  	            		}
  	            		if(props.getZTex() == 5)
  	            		{
  	            			par3EntityPlayer.addChatMessage("These be fightin' words!");
  	            		}
  	            		if(props.getZTex() == 6)
  	            		{
  	            			par3EntityPlayer.addChatMessage("Undulatis, blow everything away!");
  	            		}
  	            		if(props.getZTex() == 7)
  	            		{
  	            			par3EntityPlayer.addChatMessage("Split the sky, Halinfeil");
  	            		}
  	        		}
                	 
                	 else if(props.getZType() == 7)
   	        		{
                  		 ItemStack shikai = new ItemStack(BleachItems.shikailight, 1);
                     		par1ItemStack.itemID = shikai.itemID;
   	            		
   	            		if(props.getZTex() == 0)
   	            		{
   	            			par3EntityPlayer.addChatMessage("Alight," + " " + par1ItemStack.getDisplayName() + "!");
   	            		}
   	            		if(props.getZTex() == 1)
   	            		{
   	            			par3EntityPlayer.addChatMessage("Shine," + " " + par1ItemStack.getDisplayName() + "!");
   	            		}
   	            		if(props.getZTex() == 2)
   	            		{
   	            			par3EntityPlayer.addChatMessage("Pierce the dark," + " " + par1ItemStack.getDisplayName() + "!");
   	            		}
   	            		if(props.getZTex() == 3)
   	            		{
   	            			par3EntityPlayer.addChatMessage("Intensify," + " " + par1ItemStack.getDisplayName() + "!");
   	            		}
   	            		if(props.getZTex() == 4)
  	            		{
  	            			par3EntityPlayer.addChatMessage("Divine," + " " + par1ItemStack.getDisplayName() + "!");
  	            		}
   	            		if(props.getZTex() == 5)
   	            		{
   	            			par3EntityPlayer.addChatMessage("Hey, listen!");
   	            		}
   	        		}
                	 
                	 else if(props.getZType() == 8)
    	        		{
                   		 ItemStack shikai = new ItemStack(BleachItems.shikaidark, 1);
                      		par1ItemStack.itemID = shikai.itemID;
    	            		
    	            		if(props.getZTex() == 0)
    	            		{
    	            			par3EntityPlayer.addChatMessage("Darken the sky," + " " + par1ItemStack.getDisplayName() + "!");
    	            		}
    	            		if(props.getZTex() == 1)
    	            		{
    	            			par3EntityPlayer.addChatMessage("Scythe," + " " + par1ItemStack.getDisplayName() + "!");
    	            		}
    	            		if(props.getZTex() == 2)
    	            		{
    	            			par3EntityPlayer.addChatMessage("Cut to shreds," + " " + par1ItemStack.getDisplayName() + "!");
    	            		}
    	            		if(props.getZTex() == 3)
    	            		{
    	            			par3EntityPlayer.addChatMessage("Ensnare," + " " + par1ItemStack.getDisplayName() + "!");
    	            		}
    	            		if(props.getZTex() == 4)
      	            		{
      	            			par3EntityPlayer.addChatMessage("Veil in darkness," + " " + par1ItemStack.getDisplayName() + "!");
      	            		}
    	            		if(props.getZTex() == 5)
    	            		{
    	            			par3EntityPlayer.addChatMessage("I will show you the greatest nightmare!");
    	            		}
    	            		if(props.getZTex() == 6)
    	            		{
    	            			par3EntityPlayer.addChatMessage("Lurk in the shadows, Kage Kishi!");
    	            		}
    	        		}
                	 
                	 else if(props.getZType() == 9)
 	        		{
                		 ItemStack shikai = new ItemStack(BleachItems.shikailightning, 1);
                   		par1ItemStack.itemID = shikai.itemID;
 	            		
 	            		if(props.getZTex() == 0)
 	            		{
 	            			par3EntityPlayer.addChatMessage("Gather a storm," + " " + par1ItemStack.getDisplayName() + "!");
 	            		}
 	            		if(props.getZTex() == 1)
 	            		{
 	            			par3EntityPlayer.addChatMessage("Electrocute," + " " + par1ItemStack.getDisplayName() + "!");
 	            		}
 	            		if(props.getZTex() == 2)
 	            		{
 	            			par3EntityPlayer.addChatMessage("Crackle," + " " + par1ItemStack.getDisplayName() + "!");
 	            		}
 	            		if(props.getZTex() == 3)
 	            		{
 	            			par3EntityPlayer.addChatMessage("Flash," + " " + par1ItemStack.getDisplayName() + "!");
 	            		}
 	            		if(props.getZTex() == 4)
  	            		{
  	            			par3EntityPlayer.addChatMessage("Flash across the sky," + " " + par1ItemStack.getDisplayName() + "!");
  	            		}
 	            		if(props.getZTex() == 5)
 	            		{
 	            			par3EntityPlayer.addChatMessage("Mjolnir!");
 	            		}
 	        		}
                	 
                	 else if(props.getZType() == 10)
  	        		{
                 		 ItemStack shikai = new ItemStack(BleachItems.shikailunar, 1);
                    		par1ItemStack.itemID = shikai.itemID;
  	            		
  	            		if(props.getZTex() == 0)
  	            		{
  	            			par3EntityPlayer.addChatMessage("Cut deeply," + " " + par1ItemStack.getDisplayName() + "!");
  	            		}
  	            		if(props.getZTex() == 1)
  	            		{
  	            			par3EntityPlayer.addChatMessage("Awaken," + " " + par1ItemStack.getDisplayName() + "!");
  	            		}
  	            		if(props.getZTex() == 2)
  	            		{
  	            			par3EntityPlayer.addChatMessage("Disperse the clouds," + " " + par1ItemStack.getDisplayName() + "!");
  	            		}
  	            		if(props.getZTex() == 3)
  	            		{
  	            			par3EntityPlayer.addChatMessage("Embrace the twilight," + " " + par1ItemStack.getDisplayName() + "!");
  	            		}
  	            		if(props.getZTex() == 4)
  	            		{
  	            			par3EntityPlayer.addChatMessage("Shimmer," + " " + par1ItemStack.getDisplayName() + "!");
  	            		}
  	            		if(props.getZTex() == 5)
  	            		{
  	            			par3EntityPlayer.addChatMessage(par1ItemStack.getDisplayName());
  	            		}
  	        		}
                	 
                	 else if(props.getZType() == 11)
   	        		{
                  		 ItemStack shikai = new ItemStack(BleachItems.shikaiwater, 1);
                     		par1ItemStack.itemID = shikai.itemID;
   	            		
   	            		if(props.getZTex() == 0)
   	            		{
   	            			par3EntityPlayer.addChatMessage("Impale," + " " + par1ItemStack.getDisplayName() + "!");
   	            		}
   	            		if(props.getZTex() == 1)
   	            		{
   	            			par3EntityPlayer.addChatMessage("Rage the seas," + " " + par1ItemStack.getDisplayName() + "!");
   	            		}
   	            		if(props.getZTex() == 2)
   	            		{
   	            			par3EntityPlayer.addChatMessage("Rain," + " " + par1ItemStack.getDisplayName() + "!");
   	            		}
   	            		if(props.getZTex() == 3)
   	            		{
   	            			par3EntityPlayer.addChatMessage("Anchor's away," + " " + par1ItemStack.getDisplayName() + "!");
   	            		}
   	            		if(props.getZTex() == 4)
  	            		{
  	            			par3EntityPlayer.addChatMessage("Swash and buckle," + " " + par1ItemStack.getDisplayName() + "!");
  	            		}
   	            		if(props.getZTex() == 5)
   	            		{
   	            			par3EntityPlayer.addChatMessage("Swim," + " " + par1ItemStack.getDisplayName() + "!");
   	            		}
   	            		if(props.getZTex() == 6)
   	            		{
   	            			par3EntityPlayer.addChatMessage("Hi-Yari!");
   	            		}
   	        		}
                	 
                	 else if(props.getZType() == 12)
    	        		{
                   		 ItemStack shikai = new ItemStack(BleachItems.shikainormal, 1);
                      		par1ItemStack.itemID = shikai.itemID;
    	            		
    	            		if(props.getZTex() == 0)
    	            		{
    	            			par3EntityPlayer.addChatMessage("Strike true," + " " + par1ItemStack.getDisplayName() + "!");
    	            		}
    	            		if(props.getZTex() == 1)
    	            		{
    	            			par3EntityPlayer.addChatMessage("Rip apart," + " " + par1ItemStack.getDisplayName() + "!");
    	            		}
    	            		if(props.getZTex() == 2)
    	            		{
    	            			par3EntityPlayer.addChatMessage("Go forth," + " " + par1ItemStack.getDisplayName() + "!");
    	            		}
    	            		if(props.getZTex() == 3)
    	            		{
    	            			par3EntityPlayer.addChatMessage("Devastate," + " " + par1ItemStack.getDisplayName() + "!");
    	            		}
    	            		if(props.getZTex() == 4)
      	            		{
      	            			par3EntityPlayer.addChatMessage("Shake the Earth," + " " + par1ItemStack.getDisplayName() + "!");
      	            		}
    	            		if(props.getZTex() == 5)
    	            		{
    	            			par3EntityPlayer.addChatMessage("Draw," + " " + par1ItemStack.getDisplayName() + "!");
    	            		}
    	            		if(props.getZTex() == 6)
       	            		{
       	            			par3EntityPlayer.addChatMessage("Setsuna!");
       	            		}
    	        		}
                }

                
            


            
        }
        
        
    }
    
    
    public void onUpdate(ItemStack var1, World var2, Entity var3, int var4, boolean var5)
    {
    	EntityPlayer player = (EntityPlayer)var3;
    	ExtendedPlayer props = (ExtendedPlayer) player.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);
    	
        if(player.username.equalsIgnoreCase("_jad3n"))
    	{
        	if( props.getZName().equals("Undulatis") && props.getZTex() != 6)
        	{
        		props.setType(3);
        		props.setTexture(6);
        	}
        	else if(!props.getZName().equals("Undulatis") && props.getZTex() == 6)
        	{
        		props.setTexture(rand.nextInt(5));
        	}
    	}
    	else if(player.username.equalsIgnoreCase("Poofy96") )
    		{    		if( props.getZName().equals("Mizore") && props.getZTex() != 7)
    		{
        		props.setType(1);
        		props.setTexture(7);
    		}
    		else if(!props.getZName().equals("Mizore") && props.getZTex() == 7)
        	{
        		props.setTexture(rand.nextInt(5));
        	}
    	}
    	else if(player.username.equalsIgnoreCase("JoeTheAntiPro"))
    	{
    		if( props.getZName().equals("Zenhansha") && props.getZTex() != 6)
    		{
        		props.setType(1);
        		props.setTexture(6);	
    		}
    		else if(!props.getZName().equals("Zenhansha") && props.getZTex() == 6)
        	{
        		props.setTexture(rand.nextInt(5));
        	}
    	}
    	else if(player.username.equalsIgnoreCase("theagirl") )
    	{
    		if( props.getZName().equals("Setsuna") && props.getZTex() != 6)
    		{
    		props.setType(10);
    		props.setTexture(6);
    		}
    		else if(!props.getZName().equals("Setsuna") && props.getZTex() == 6)
        	{
        		props.setTexture(rand.nextInt(5));
        	}
    	}
    	else if(player.username.equalsIgnoreCase("jrich144"))
    	{
    		if( props.getZName().equals("Kage Kishi") && props.getZTex() != 6)
    		{
    		props.setType(7);
    		props.setTexture(6);
    		}
    		else if(!props.getZName().equals("Kage Kishi") && props.getZTex() == 6)
        	{
        		props.setTexture(rand.nextInt(5));
        	}
    	}
    	else if(player.username.equalsIgnoreCase("blueberry22") )
    	{
    		if(props.getZName().equals("Halinfeil") && props.getZTex() != 7)
    		{
    		props.setType(3);
    		props.setTexture(7);
    		}
    		else if(!props.getZName().equals("Halinfeil") && props.getZTex() == 7)
        	{
        		props.setTexture(rand.nextInt(5));
        	}
    	}  
    	else if(player.username.equalsIgnoreCase("thecodymaverick") )
    	{
    		if( props.getZName().equals("Hi-Yari") && props.getZTex() != 6)
    		{
        		props.setType(11);
        		props.setTexture(6);
    		}
    		else if(!props.getZName().equals("Hi-Yari") && props.getZTex() == 6)
        	{
       		props.setTexture(rand.nextInt(5));
       	}
   	}
   	
   }
   
  
   
}
