package littlebreadloaf.bleach.items.shikai;

import com.google.common.collect.Multimap;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import littlebreadloaf.bleach.BleachModInfo;
import littlebreadloaf.bleach.Names;
import littlebreadloaf.bleach.api.Tools;
import littlebreadloaf.bleach.armor.Armor;
import littlebreadloaf.bleach.events.ExtendedPlayer;
import littlebreadloaf.bleach.items.BleachItems;
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
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class ShikaiIce extends Item
{
	public static Icon[] icons;
	private static final String[] ICON = Names.ShikaiIce_UnlocalizedName;

	private float weaponDamage;
	private final EnumToolMaterial toolMaterial;
	public float damageBoost = 0;
	public float robeboost = 0;
	public float pantboost = 0;
	public float sandalboost = 0;
	public float coldboost = 0;
	
	
	public ShikaiIce(int id, EnumToolMaterial material) 
	{
		super(id);
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
		return Names.ShikaiIce_UnlocalizedName[itemstack.getItemDamage()];
	}
	public float getDamage()
    {
		return this.weaponDamage;
    	
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int damage)
	{
		return icons[damage];
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon)
	{
		icons = new Icon[ICON.length];
		
		for(int i = 0; i < icons.length; i++)
		{
			icons[i] = icon.registerIcon(BleachModInfo.ID.toLowerCase() + ":" + ICON[i]);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	public float func_82803_g()
    {
        return this.toolMaterial.getDamageVsEntity();
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
            return material != Material.plants && material != Material.vine && material != Material.coral && material != Material.leaves && material != Material.pumpkin ? 1.0F : 3.0F;
        }
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
        

        if(var9 != null && var9.itemID == Armor.Sandals.itemID)
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
       
        
        if(var10 != null && var10.itemID == Armor.ShiniPants.itemID)
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
        
        
        if(var11 != null && var11.itemID == Armor.ShiniRobe.itemID)
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
     
        
        if(par2EntityLivingBase.getCreatureAttribute() == Tools.SPIRIT)
        {
        	if(!player.worldObj.isRemote)
        	{
        		props.addSXP(5);
        	}
        	damageBoost = 2;
        }
        else
        {
        	if(!player.worldObj.isRemote)
        	{
        		props.addSXP(2);
        	}
        	damageBoost = 0;
        }
        if(player.worldObj.getBlockId((int)player.posX, (int)player.posY, (int)player.posZ) == Block.ice.blockID || player.worldObj.getBlockId((int)player.posX, (int)player.posY, (int)player.posZ) == Block.snow.blockID )
        {
        	this.coldboost = 2;
        }
        else
        {
        	this.coldboost = 0;
        }
        float damage = this.damageBoost + this.sandalboost + this.pantboost + this.robeboost + this.coldboost;
        if(damage > 0)
        {
            par2EntityLivingBase.setHealth(par2EntityLivingBase.getHealth() - damage);
        }
        par2EntityLivingBase.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 60, 1));
        
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
        
        return par1ItemStack;
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
    public void onPlayerStoppedUsing(ItemStack var1, World var2, EntityPlayer var3, int var4)
    {
    
    }
    
    
    
    @Override
    public boolean isBookEnchantable(ItemStack itemstack1, ItemStack itemstack2)
    {
        return false;
    }
    
    
   
    public void onUpdate(ItemStack var1, World var2, Entity var3, int var4, boolean var5)
    {
    	EntityPlayer var6 = (EntityPlayer)var3;
    	ItemStack var12 = new ItemStack(BleachItems.zanpakuto, 1);
    	if(var6.inventory.getCurrentItem() == var1)
    	{
    		
    	
    	
    	 if(!var2.isRemote)
    	 {
    		 for(int icex = -2; icex < 2; ++icex)
    	    	{
    	    		for(int icez = -2; icez < 2; ++icez)
    	    		{
    	    			
    	        			if(var2.getBlockId((int)(var6.posX + icex), (int)(var6.posY - 1), (int)(var6.posZ + icez)) == Block.waterStill.blockID)
    	        			{

    	                    	var2.setBlock((int)(var6.posX + icex), (int)(var6.posY - 1), (int)(var6.posZ + icez), Block.ice.blockID);
    	        			}
    	        		
    	    				
    	    			
    	    		}
    	    	}
    	 }
    }
    }

}