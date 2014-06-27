package littlebreadloaf.bleach.items.shikai;

import java.util.List;

import littlebreadloaf.bleach.BleachModInfo;
import littlebreadloaf.bleach.Names;
import littlebreadloaf.bleach.api.Tools;
import littlebreadloaf.bleach.armor.Armor;
import littlebreadloaf.bleach.blocks.BleachBlocks;
import littlebreadloaf.bleach.events.ExtendedPlayer;
import littlebreadloaf.bleach.items.BleachItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import com.google.common.collect.Multimap;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ShikaiIce extends ItemSword
{
	public static IIcon[] icons;
	private static final String[] ICON = Names.ShikaiIce_UnlocalizedName;

	private float weaponDamage;
	private final ToolMaterial toolMaterial;
	public float damageBoost = 0;
	public float robeboost = 0;
	public float pantboost = 0;
	public float sandalboost = 0;
	public float coldboost = 0;
	
	
	public ShikaiIce(ToolMaterial material) 
	{
		super(material);
		this.toolMaterial = material;
		this.maxStackSize = 1;
		this.setMaxDamage(material.getMaxUses());
		this.setCreativeTab(null);
		this.setHasSubtypes(true);
		this.weaponDamage = 5 + material.getDamageVsEntity();
		
	}
	
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer player, List data, boolean b)
	{
		if(itemStack.getItemDamage() == 3)
		{
			data.add("BrutalMorV");
		}
		
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemstack)
	{
		return Names.ShikaiIce_UnlocalizedName[itemstack.getItemDamage()];
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
    public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
    {
    	EntityPlayer player = (EntityPlayer)par3EntityLivingBase;
		ExtendedPlayer props = (ExtendedPlayer) player.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);
		
		ItemStack var9 = player.inventory.armorInventory[0];
        ItemStack var10 = player.inventory.armorInventory[1];
        ItemStack var11 = player.inventory.armorInventory[2];
        ItemStack var7 = player.inventory.armorInventory[3];
        
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
        
        if(par2EntityLivingBase.getCreatureAttribute() == Tools.SPIRIT)
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
        if(player.worldObj.getBlock((int)player.posX, (int)player.posY, (int)player.posZ) == Blocks.ice || player.worldObj.getBlock((int)player.posX, (int)player.posY, (int)player.posZ) == Blocks.snow )
        {
        	this.coldboost = 2;
        }
        else
        {
        	this.coldboost = 0;
        }
        float damage = this.damageBoost + this.sandalboost + this.pantboost + this.robeboost + this.coldboost;
        if(damage > 0 && props.getFaction() == 1 && damage <= par2EntityLivingBase.getHealth())
        {
            par2EntityLivingBase.attackEntityFrom(DamageSource.generic, damage);
        }
        par2EntityLivingBase.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 60, 1));
        
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
	int var6 = this.getMaxItemUseDuration(var1) - var4;
    float var7 = (float)var6 / 20.0F;
    var7 = (var7 * var7 + var7 * 2.0F) / 3.0F;

   

    if (var7 > 2.0F)
    {
        var7 = 1.0F;
        
        if(!var2.isRemote)
        {
        	EntitySnowman Snowman = new EntitySnowman(var2);
        	Vec3 look = var3.getLook(1.0F);
        	Snowman.setLocationAndAngles(var3.posX + look.xCoord, var3.posY + 0.6F, var3.posZ + look.zCoord, 0F, 0F);
        	
        	
            var2.spawnEntityInWorld(Snowman);
        	props.consumeEnergy(25);
        	
        }
        var3.swingItem();
        

    }
    else
    {
    	if(!var2.isRemote)
        {
    		EntitySnowball Snowball = new EntitySnowball(var2, var3);
    		var2.spawnEntityInWorld(Snowball);
        	props.consumeEnergy(1);
        }
        var3.swingItem();
    }
}
    
    
    
    @Override
    public boolean isBookEnchantable(ItemStack itemstack1, ItemStack itemstack2)
    {
        return false;
    }
    
    
	
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
    		ItemStack var13 = new ItemStack(BleachItems.zanpakuto, 1);
    		
    		--shikaiTimer;
			if(shikaiTimer <= 0 && !player.worldObj.isRemote)
			{
				shikaiTimer = 40;
				props.consumeEnergy(3);
			}
			if(props.getCurrentEnergy() <= 0)
			{
				props.deactivate(par1ItemStack.getItem());
			}	
    		if(heldItem != null && heldItem == par1ItemStack)
    		{

        		heldItem.setItemDamage(props.getZTex());
    			
    			if(!par2World.isRemote)
    	    	 {
    	    		 for(int icex = -2; icex < 2; ++icex)
    	    	    	{
    	    	    		for(int icez = -2; icez < 2; ++icez)
    	    	    		{
    	    	    			
    	    	        			if(par2World.getBlock((int)(player.posX + icex), (int)(player.posY - 1), (int)(player.posZ + icez)) == Blocks.water)
    	    	        			{
    	    	        				if(par2World.getBlockMetadata((int)(player.posX + icex), (int)(player.posY - 1), (int)(player.posZ + icez)) == 0)
    	    	        				par2World.setBlock((int)(player.posX + icex), (int)(player.posY - 1), (int)(player.posZ + icez), BleachBlocks.shikaiIceBlock);
    	    	        			}
    	    	        		
    	    	    				
    	    	    			
    	    	    		}
    	    	    	}
    	    	 }
    			
    			if(props.getZType() != 2)
    				props.deactivate(par1ItemStack.getItem());
    		}
    	}
    }

}
