package littlebreadloaf.bleach.items;

import littlebreadloaf.bleach.BleachModInfo;
import littlebreadloaf.bleach.Names;
import littlebreadloaf.bleach.entities.EntityEnergyArrow;
import littlebreadloaf.bleach.entities.EntitySeeleArrow;
import littlebreadloaf.bleach.events.ExtendedPlayer;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemQuincyBow extends ItemBow
{

	public static Icon[] iconArray;
	private static final String[] bowPullIconNameArray = {"quincy_bow_0", "quincy_bow_1", "quincy_bow_2","quincy_seele_0", "quincy_seele_1", "quincy_seele_2"};


    public ItemQuincyBow(int par1)
    {
        super(par1);
        this.maxStackSize = 1;
        this.setMaxDamage(-1);
        this.setUnlocalizedName(Names.QuincyBow_UnlocalizedName);
        this.setCreativeTab(null);
    }

    /**
     * called when the player releases the use item button. Args: itemstack, world, entityplayer, itemInUseCount
     */
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
                      par3EntityPlayer.inventory.consumeInventoryItem(BleachItems.seele.itemID);
                  }
                  if(!par2World.isRemote)
                  {
                      par2World.spawnEntityInWorld(entitySeeleArrow);
                      par2World.playSoundAtEntity(par3EntityPlayer, "bleach:bowfire", 0.4F, 1.0F); 
                  }
                  
              }

        			
        	}
        else if (props.getCurrentEnergy() > 0)
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

            EntityEnergyArrow entityEnergyArrow = new EntityEnergyArrow(par2World, par3EntityPlayer, 2.0F);

            
            entityEnergyArrow.setIsCritical(true);
            if (!par2World.isRemote)
            {
                par2World.spawnEntityInWorld(entityEnergyArrow);
            	par2World.playSoundAtEntity(par3EntityPlayer, "bleach:bowfire", 0.4F, 1.0F);
            }


            
        }
    }
    
  

    public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        return par1ItemStack;
    }

    /**
     * How long it takes to use or consume an item
     */
    public int getMaxItemUseDuration(ItemStack par1ItemStack)
    {
        return 72000;
    }

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
    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
    	ExtendedPlayer props = (ExtendedPlayer) par3EntityPlayer.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);
        
    	if(props.getFaction() == 2)
    	{
		
        if(par3EntityPlayer.inventory.hasItemStack(new ItemStack(BleachItems.seele, 1, 1)))
        {
        	par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
        	this.isSeele = true;
            par2World.playSoundAtEntity(par3EntityPlayer, "bleach:bowcharge", 0.4F, 1.0F);
            ArrowNockEvent event = new ArrowNockEvent(par3EntityPlayer, par1ItemStack);
            MinecraftForge.EVENT_BUS.post(event);
            if (event.isCanceled())
            {
                return event.result;
            }
        }
        else if (par3EntityPlayer.capabilities.isCreativeMode || props.getCurrentEnergy() >= ((float)1 / (float)props.getCurrentCap()))
        {
            par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
            this.isSeele = false;
            par2World.playSoundAtEntity(par3EntityPlayer, "bleach:bowcharge", 0.4F, 1.0F);
            ArrowNockEvent event = new ArrowNockEvent(par3EntityPlayer, par1ItemStack);
            MinecraftForge.EVENT_BUS.post(event);
            if (event.isCanceled())
            {
                return event.result;
            }
        }
    	}

        return par1ItemStack;
    }

    /**
     * Return the enchantability factor of the item, most of the time is based on material.
     */
    public int getItemEnchantability()
    {
        return 1;
    }

    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.itemIcon = par1IconRegister.registerIcon(BleachModInfo.ID.toLowerCase() + ":" + Names.QuincyBow_UnlocalizedName);
        this.iconArray = new Icon[bowPullIconNameArray.length];

        for (int i = 0; i < this.iconArray.length; ++i)
        {
            this.iconArray[i] = par1IconRegister.registerIcon(BleachModInfo.ID + ":" + bowPullIconNameArray[i]);
        }
    }

    @SideOnly(Side.CLIENT)

    /**
     * used to cycle through icons based on their used duration, i.e. for the bow
     */
    public Icon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining)
    {
    	if(player.getItemInUse() == null) return this.itemIcon;
        int Pulling = stack.getMaxItemUseDuration() - useRemaining;
        if (Pulling >= 18)
        	{
        		if(this.getIsSeele())
        		{
        			return iconArray[5];
        		}
        		else
        		{
                	return iconArray[2];
        		}
        	}
        else if (Pulling > 13)
           	{
        		if(this.getIsSeele())
        		{
        				return iconArray[4];
        		}
        		else
        		{
            		return iconArray[1];
        		}
           	}
        else if (Pulling > 0)
       		{
        	if(this.getIsSeele())
    		{
    				return iconArray[3];
    		}
    		else
    		{
        		return iconArray[0];
    		}    
       	}
    	return itemIcon;
 	}
}
    
    
    

   

