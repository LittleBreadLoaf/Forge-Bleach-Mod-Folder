package littlebreadloaf.bleach.items;

import java.util.Random;

import littlebreadloaf.bleach.BleachMod;
import littlebreadloaf.bleach.BleachModInfo;
import littlebreadloaf.bleach.Names;
import littlebreadloaf.bleach.api.Tools;
import littlebreadloaf.bleach.armor.Armor;
import littlebreadloaf.bleach.events.ExtendedPlayer;
import littlebreadloaf.bleach.extras.ParticleEffects;
import littlebreadloaf.bleach.network.ServerSyncMessage;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
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
        if(var7 != null && var7.getItem() == Armor.GolemHelmet && props.getFaction() == 1)
    	{
        	if(!player.worldObj.isRemote && props.consumeEnergy(3))
        	{
        		par2EntityLivingBase.setFire(6);
        	}
    	}
    	if(var7 != null && var7.getItem() == Armor.SnakeHelmet  && props.getFaction() == 1)
    	{
    		if(!player.worldObj.isRemote && props.consumeEnergy(3))
        	{
    			par2EntityLivingBase.addPotionEffect(new PotionEffect(Potion.poison.id, 200, 1));
        	}
    	}
    	
    	if(var7 != null && var7.getItem() == Armor.WaspHelmet  && props.getFaction() == 1)
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
        if(props.getFaction() == 2)
        {
        	player.dropPlayerItemWithRandomChoice(par1ItemStack, false);
        	player.destroyCurrentEquippedItem();
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
        		if(props.getZTex() == 5)
        			props.randomTexture();
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

//	        if(!player.worldObj.isRemote)
//	        {
//	            ParticleEffects.spawnParticle("spirit", var2 - 0.9, var3 + 1, var4 + 0.5, 0.0D, 0.0D, 0.0D);
//	            ParticleEffects.spawnParticle("spirit", var2 - 0.9, var3 + 1, var4 + 0.5, 0.0D, 0.0D, 0.0D);
//	        }
	        
	   
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
    
    
//int replenishTimer = 200;
//@Override
///**
// * Called each tick as long the item is on a player inventory. Uses by maps to check if is on a player hand and
// * update it's contents.
// */
//public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5) 
//{
//	if(par3Entity instanceof EntityPlayer)
//	{
//		EntityPlayer player = (EntityPlayer)par3Entity;
//	--replenishTimer;
//	
//	ExtendedPlayer props = (ExtendedPlayer) player.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);
//	
//		if(replenishTimer <= 0 && props.getFaction() == 1)
//		{
//			if(!par2World.isRemote)
//			props.replenishEnergy(2);
//			if(player instanceof EntityPlayerMP)
//			BleachMod.network.sendTo(new ServerSyncMessage(player), (EntityPlayerMP)player);			
//			replenishTimer = 200;
//		}
//	
//	}
//	
//}
    
    
    

}
