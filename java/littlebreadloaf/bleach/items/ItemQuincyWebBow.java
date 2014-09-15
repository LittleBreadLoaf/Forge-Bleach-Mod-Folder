package littlebreadloaf.bleach.items;

import littlebreadloaf.bleach.BleachModInfo;
import littlebreadloaf.bleach.Names;
import littlebreadloaf.bleach.entities.EntityEnergyArrow;
import littlebreadloaf.bleach.entities.EntitySeeleArrow;
import littlebreadloaf.bleach.events.ExtendedPlayer;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemQuincyWebBow extends Item
{

	//public static Icon[] iconArray;
	//private static final String[] bowPullIconNameArray = {"quincy_bow_0", "quincy_bow_1", "quincy_bow_2","quincy_seele_0", "quincy_seele_1", "quincy_seele_2"};
	@SideOnly(Side.CLIENT)
	public static IIcon[] iconArray;
	private static final String[] bowPullIconNameArray = {"web_seele1", "web_seele2", "web_seele3"};
    private static final String __OBFID = "CL_00001777";


    public ItemQuincyWebBow()
    {
        super();
        this.maxStackSize = 1;
        this.setMaxDamage(-1);
        this.setUnlocalizedName(Names.QuincyWeb_UnlocalizedName);
        this.setCreativeTab(null);
    }

    /**
     ** called when the player releases the use item button. Args: itemstack, world, entityplayer, itemInUseCount
     **/
    public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer, int par4)
    {
        int j = this.getMaxItemUseDuration(par1ItemStack) - par4;

		ExtendedPlayer props = (ExtendedPlayer) par3EntityPlayer.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);
		
        ArrowLooseEvent event = new ArrowLooseEvent(par3EntityPlayer, par1ItemStack, j);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.isCanceled())
        {
            return;
        }
        j = event.charge;

        boolean flag = par3EntityPlayer.capabilities.isCreativeMode;
        if(par3EntityPlayer.inventory.hasItemStack(new ItemStack(BleachItems.seele, 1, 1)))
        	{
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

              EntitySeeleArrow entitySeeleArrow = new EntitySeeleArrow(par2World, par3EntityPlayer,  2.0F);

              if (f == 1.0F)
              {
                  entitySeeleArrow.setIsCritical(true);
                  if(!par3EntityPlayer.capabilities.isCreativeMode)
                  {
                      par3EntityPlayer.inventory.consumeInventoryItem(BleachItems.seele);
                  }

                  par2World.spawnEntityInWorld(entitySeeleArrow);
                  if(!par2World.isRemote)
                  {
                      par2World.playSoundAtEntity(par3EntityPlayer, "bleach:bowfire", 0.4F, 1.0F); 
                  }
                  
              }

        			
        	}
        
    }
    
  
	@Override
    public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        return par1ItemStack;
    }

	@Override
    /**
     * How long it takes to use or consume an item
     */
    public int getMaxItemUseDuration(ItemStack par1ItemStack)
    {
        return 72000;
    }

	
	@Override
    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
        return EnumAction.bow;
    }
    
    private boolean isSeele;
    
    private boolean getIsSeele()
    {
    	return this.isSeele;
    }
    
	@Override
    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {

		ExtendedPlayer props = (ExtendedPlayer) par3EntityPlayer.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);
		if( props.getFaction() == 2)
		{
			ArrowNockEvent event = new ArrowNockEvent(par3EntityPlayer, par1ItemStack);
			MinecraftForge.EVENT_BUS.post(event);
        if (event.isCanceled())
        {
            return event.result;
        }
        if(par3EntityPlayer.inventory.hasItemStack(new ItemStack(BleachItems.seele, 1, 1)))
        {
        	par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
        	this.isSeele = true;
        	par2World.playSoundAtEntity(par3EntityPlayer, "bleach:bowcharge", 0.4F, 1.0F);
        }
        	if (par3EntityPlayer.capabilities.isCreativeMode || props.getCurrentEnergy() >= ((float)1 / (float)props.getCurrentCap()))
        	{
            	par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
            	this.isSeele = false;
        	}
		}

        return par1ItemStack;
    }

	
	@Override
    /**
     * Return the enchantability factor of the item, most of the time is based on material.
     */
    public int getItemEnchantability()
    {
        return 1;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1IconRegister)
    {
        itemIcon = par1IconRegister.registerIcon(BleachModInfo.ID.toLowerCase() + ":" + Names.QuincyWeb_UnlocalizedName);
        this.iconArray = new IIcon[bowPullIconNameArray.length];

        for (int i = 0; i < this.iconArray.length; ++i)
        {
            this.iconArray[i] = par1IconRegister.registerIcon(BleachModInfo.ID + ":" + bowPullIconNameArray[i]);
        }
    }
    private int bowCoolDown = 20;
    
    
    
   
    int shikaiTimer = 40;
    @Override
    /**
     * Called each tick as long the item is on a player inventory. Uses by maps to check if is on a player hand and
     * update it's contents.
     */
    public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5) 
    {
    	if(par3Entity instanceof EntityPlayer)
    	{
    		EntityPlayer player = (EntityPlayer)par3Entity;
    		ExtendedPlayer props = (ExtendedPlayer) player.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);
    		ItemStack heldItem = player.getCurrentEquippedItem();
    		ItemStack var13 = new ItemStack(BleachItems.quincypendant, 1, 1);
    		
 
    		if(heldItem != null && heldItem == par1ItemStack)
    		{

        		if(props.getCurrentEnergy() <= 0)
    			{
    				props.deactivate(par1ItemStack.getItem());
    			}
    		}
    		--shikaiTimer;
			if(shikaiTimer <= 0 && !player.worldObj.isRemote)
			{
				shikaiTimer = 40;
				props.consumeEnergy(3);
			}
			
    	}
    }
    @Override
    public void onUsingTick(ItemStack stack, EntityPlayer player, int count)
    {
    	
	ExtendedPlayer props = (ExtendedPlayer) player.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);
	  if (props.getCurrentEnergy() > 0 && props.getFaction() == 2 && !player.inventory.hasItemStack(new ItemStack(BleachItems.seele, 1, 1)))
      {
		  
  		
  		if(count%21 == 0)
  		{

  			EntityEnergyArrow entityEnergyArrow = new EntityEnergyArrow(player.worldObj, player, 2.0F);

      
  			entityEnergyArrow.setIsCritical(true);
  			//if(!player.worldObj.isRemote)
  			//{
  				player.worldObj.spawnEntityInWorld(entityEnergyArrow);
  				player.worldObj.playSoundAtEntity(player, "bleach:bowfire", 0.4F, 1.0F);

  			//}
  			
  		}
	        
      }
	  else if(props.getCurrentEnergy() > 0 && props.getFaction() == 2 && player.inventory.hasItem(BleachItems.seele))
	  {
		this.isSeele = true;  
	  }
    	
        
    }
    
	@Override
    @SideOnly(Side.CLIENT)

    /**
     * used to cycle through icons based on their used duration, i.e. for the bow
     */
    public IIcon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining)
    {
    	if(player.getItemInUse() == null) return this.itemIcon;
        int Pulling = stack.getMaxItemUseDuration() - useRemaining;
        if(this.getIsSeele())
		{
        if (Pulling >= 18)
        	{
        		
        			return iconArray[2];
        		
        	}
        else if (Pulling > 13)
           	{
        		
        				return iconArray[1];
        		
           	}
        else if (Pulling > 0)
       		{
        			return iconArray[0];
    		
    		   
       	}
		}
    	return itemIcon;
 	}
}
    
    
