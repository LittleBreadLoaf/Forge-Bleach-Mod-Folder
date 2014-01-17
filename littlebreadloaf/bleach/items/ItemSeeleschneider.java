package littlebreadloaf.bleach.items;

import com.google.common.collect.Multimap;

import littlebreadloaf.bleach.BleachModInfo;
import littlebreadloaf.bleach.Names;
import littlebreadloaf.bleach.api.Tools;
import littlebreadloaf.bleach.armor.Armor;
import littlebreadloaf.bleach.events.ExtendedPlayer;
import net.minecraft.client.renderer.texture.IconRegister;
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
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemSeeleschneider extends Item
{
	@SideOnly(Side.CLIENT)
	public static Icon[] icons;
    private float weaponDamage;
    private final EnumToolMaterial toolMaterial;
    public float damageBoost = 0;
    public float robeboost = 0;
    public float pantboost = 0;
    public float sandalboost = 0;
    
	private static final String[] ICON = {"seele", "seele2"};
	public ItemSeeleschneider(int id, EnumToolMaterial material)
	{
		super(id);
		this.toolMaterial = material;
        this.maxStackSize = 1;
        this.setMaxDamage(material.getMaxUses());
		this.setCreativeTab(BleachItems.tabBleach);
		this.setHasSubtypes(true);
		this.weaponDamage = 2.0F + material.getDamageVsEntity() ;
		    
	}
	
	public float func_82803_g()
    {
        return this.toolMaterial.getDamageVsEntity();
    }
	
	
	public float getDamage()
	{
		
		return this.weaponDamage;	
		
		
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemstack)
	{
		return Names.Seeleschneider_UnlocalizedName[itemstack.getItemDamage()];
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
	
	
	
	
	
	
	   /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
	@Override
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {

		ExtendedPlayer props = (ExtendedPlayer) par3EntityPlayer.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);
		if( par1ItemStack.getItemDamage() == 0 && !par3EntityPlayer.worldObj.isRemote && props.getCurrentEnergy() >= (float)70 / (float)props.getCurrentCap())
		{
			props.consumeEnergy(70);
	    	par1ItemStack.setItemDamage(1);
		}
        return par1ItemStack;
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
        ItemStack var33 = player.inventory.getCurrentItem();
        
        if(var33 != null && var33.itemID == BleachItems.seele.itemID && var33.getItemDamage() == 1)
        {
        	
        
        if(var9 != null && var9.itemID == Armor.QuincyShoes.itemID)
        {
        	sandalboost = 1;
        }
        else
        {
        	sandalboost = 0;
        }
       
        
        if(var10 != null && var10.itemID == Armor.QuincyPants.itemID)
        {
        	pantboost = 1;
        }
        else 
        {
        	pantboost = 0;
        }
        
       
        if(var11 != null && var11.itemID == Armor.QuincyRobe.itemID)
        {
        	robeboost = 1;
        }
        else 
        {
        	robeboost = 0;
        }
        
       
  
    	
        
        if(par2EntityLivingBase.getCreatureAttribute() == Tools.SPIRIT)
        {
        	if(!player.worldObj.isRemote)
        	{
        		props.addSXP(3);
        	}
        	damageBoost = 4;
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
        if(damage > 0 && !props.getIsShinigami() && var33.getItemDamage() == 1)
        {
            par2EntityLivingBase.setHealth(par2EntityLivingBase.getHealth() - damage);
        }
        
       }
        
        return true;
    }
    
    public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
        return EnumAction.block;
    }
    

@Override
    public Multimap getItemAttributeModifiers()
    {
    	float damage = this.getDamage();
        Multimap multimap = super.getItemAttributeModifiers();
        multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Weapon modifier", (double)damage, 0));
        return multimap;
    }
    


}
