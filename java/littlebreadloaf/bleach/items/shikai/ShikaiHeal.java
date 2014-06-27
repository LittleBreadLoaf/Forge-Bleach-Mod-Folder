package littlebreadloaf.bleach.items.shikai;

import java.util.Random;

import littlebreadloaf.bleach.BleachModInfo;
import littlebreadloaf.bleach.Names;
import littlebreadloaf.bleach.api.Tools;
import littlebreadloaf.bleach.armor.Armor;
import littlebreadloaf.bleach.events.ExtendedPlayer;
import littlebreadloaf.bleach.items.BleachItems;
import littlebreadloaf.bleach.items.ItemHeart;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.google.common.collect.Multimap;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ShikaiHeal extends ItemSword
{
	public static IIcon[] icons;
	private static final String[] ICON = Names.ShikaiHeal_UnlocalizedName;

	private float weaponDamage;
	private final ToolMaterial toolMaterial;
	public float damageBoost = 0;
	public float robeboost = 0;
	public float pantboost = 0;
	public float sandalboost = 0;
	public float waspboost = 0;
	
	Random rand = new Random();
	
	public ShikaiHeal(ToolMaterial material) 
	{
		super(material);
		this.toolMaterial = material;
		this.maxStackSize = 1;
		this.setMaxDamage(material.getMaxUses());
		this.setCreativeTab(null);
		this.setHasSubtypes(true);
		this.weaponDamage = 5 + material.getDamageVsEntity();
		
	}
	
	
	@Override
	public String getUnlocalizedName(ItemStack itemstack)
	{
		return Names.ShikaiHeal_UnlocalizedName[itemstack.getItemDamage()];
	}
	
	public float getDamage()
    {
		return this.weaponDamage;
    	
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int damage)
	{
		return icons[damage];
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister icon)
	{
		icons = new IIcon[ICON.length];
		
		for(int i = 0; i < icons.length; i++)
		{
			icons[i] = icon.registerIcon(BleachModInfo.ID.toLowerCase() + ":" + ICON[i]);
		}
	}
	
	
	
	
	
	
	
	
	
	

	@Override
	public float func_150931_i()
    {
        return this.toolMaterial.getDamageVsEntity();
    }
	
    
	@Override
    /**
     * Current implementations of this method in child classes do not use the entry argument beside ev. They just raise
     * the damage on the stack.
     */
    public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2, EntityLivingBase par3EntityLivingBase)
    {
    	EntityPlayer player = (EntityPlayer)par3EntityLivingBase;
		ExtendedPlayer props = (ExtendedPlayer) player.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);
		
		ItemStack var9 = player.inventory.armorInventory[0];
        ItemStack var10 = player.inventory.armorInventory[1];
        ItemStack var11 = player.inventory.armorInventory[2];
        ItemStack var7 = player.inventory.armorInventory[3];
        

        if(rand.nextInt(5) == 0)
        {
        	player.heal(1.0F);
        	for(int i = 0; i< 5; i++)
            {
				double d0 = this.rand.nextGaussian() * 0.02D;
				double d1 = this.rand.nextGaussian() * 0.02D;
				double d2 = this.rand.nextGaussian() * 0.02D;
            
            	player.worldObj.spawnParticle("heart", par2.posX + (double)(this.rand.nextFloat()), par2.posY + 0.5D + (double)(this.rand.nextFloat()), par2.posZ + (double)(this.rand.nextFloat()), d0, d1, d2);	
				   	
            }
        }
        if(var9 != null && (var9.getItem()  == Armor.Sandals  || var9.getItem()  == Armor.ArrancarShoes ))
        {
        	sandalboost = 1;
        }
        else if(var9 != null && var9.getItem()  == Armor.QuincyShoes )
        {
        	sandalboost = -1;
        }
        else
        {
        	sandalboost = 0;
        }
       
        
        if(var10 != null && (var10.getItem()  == Armor.ShiniPants  || var10.getItem()  == Armor.ArrancarPants ))
        {
        	pantboost = 2;
        }
        else if(var10 != null && var10.getItem()  == Armor.QuincyPants )
        {
        	pantboost = -1;
        }
        else 
        {
        	pantboost = 0;
        }
        
        
        if(var11 != null && (var11.getItem()  == Armor.ShiniRobe  || var11.getItem()  == Armor.ArrancarPants ))
        {
        	robeboost = 3;
        }
        else if(var11 != null && var11.getItem()  == Armor.QuincyRobe )
        {
        	robeboost = -2;
        }
        else 
        {
        	robeboost = 0;
        }
        
        if(par2.getCreatureAttribute() == Tools.SPIRIT)
        {
        	if(!player.worldObj.isRemote && props.getFaction() == 1)
        	{
        		props.addSXP(5);
        	}
        	damageBoost = 2;
        }
        else
        {
        	if(!player.worldObj.isRemote && props.getFaction() == 1)
        	{
        		props.addSXP(2);
        	}
        	damageBoost = 0;
        }
        float damage = this.damageBoost + this.sandalboost + this.pantboost + this.robeboost;
        if(damage > 0 && props.getFaction() == 1 && damage <= par2.getHealth())
        {
            par2.attackEntityFrom(DamageSource.generic, damage);
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
        
        return par1ItemStack;
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
    
    


@Override
    /**
     * called when the player releases the use item button. Args: itemstack, world, entityplayer, itemInUseCount
     */
    public void onPlayerStoppedUsing(ItemStack var1, World var2, EntityPlayer var3, int var4)
    {

		ExtendedPlayer props = (ExtendedPlayer) var3.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);
        int var5 = this.getMaxItemUseDuration(var1) - var4;
        float var6 = (float)var5 / 20.0F;
        var6 = (var6 * var6 + var6 * 2.0F) / 3.0F;

        if ((double)var6 >= 0.1D)
        {
            if (var6 > 1.0F)
            {
                var6 = 1.0F;
            }
            if (var6 == 1.0F)
            {
            	if(!var2.isRemote)
            	{
            		var3.dropItem(BleachItems.heart, 1);
            		props.consumeEnergy(20);
            	}
            }
        }
    }
    
  
    
    @Override
    public boolean isBookEnchantable(ItemStack itemstack1, ItemStack itemstack2)
    {
        return false;
    }
    
    
    int shikaiTimer = 40;
    int healTimer = 100;
    @Override
    /**
     * Called each tick as long the item is on a player inventory. Uses by maps to check if is on a player hand and
     * update it's contets.
     */
    public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5) 
    {
    	if(par3Entity instanceof EntityPlayer)
    	{
    		EntityPlayer player = (EntityPlayer)par3Entity;
    		ExtendedPlayer props = (ExtendedPlayer) player.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);
    		ItemStack heldItem = player.getCurrentEquippedItem();
    		ItemStack var13 = new ItemStack(BleachItems.zanpakuto, 1);
    		--shikaiTimer;
    		if(shikaiTimer <= 0 && !par2World.isRemote)
			{
				shikaiTimer = 40;
				props.consumeEnergy(5);
			}
			if(props.getCurrentEnergy() <= 0)
			{
				props.deactivate(par1ItemStack.getItem());
			}	
    		if(heldItem != null && heldItem == par1ItemStack)
    		{

				player.curePotionEffects(new ItemStack(Items.milk_bucket));

            	player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 20, 0));
        		heldItem.setItemDamage(props.getZTex());
    			
    			--healTimer;
    			
    			if(healTimer <= 0 && !par2World.isRemote)
    			{
    				player.heal(1.0F);
    				healTimer = 100;
    			}
    		

    			if(props.getZType() != 3)
    				props.deactivate(par1ItemStack.getItem());
    		}
    	}
    }
    
    
   

}
