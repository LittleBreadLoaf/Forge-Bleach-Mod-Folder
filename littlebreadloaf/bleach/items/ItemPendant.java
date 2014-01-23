package littlebreadloaf.bleach.items;

import java.util.List;

import com.google.common.collect.Multimap;

import littlebreadloaf.bleach.BleachModInfo;
import littlebreadloaf.bleach.Names;
import littlebreadloaf.bleach.api.Tools;
import littlebreadloaf.bleach.armor.Armor;
import littlebreadloaf.bleach.events.ExtendedPlayer;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
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

public class ItemPendant extends Item
{
	@SideOnly(Side.CLIENT)
	public static Icon[] icons;
    private float weaponDamage;
    public float damageBoost = 0;
    public float robeboost = 0;
    public float pantboost = 0;
    public float sandalboost = 0;
    
	private static final String[] ICON = {"quincy_pendant", "quincy_pentacle"};
	public ItemPendant(int id)
	{
		super(id);
        this.maxStackSize = 1;
		this.setCreativeTab(BleachItems.tabBleach);
		this.setHasSubtypes(true);
		    
	}
	
	
	
	
	
	@Override
	public String getUnlocalizedName(ItemStack itemstack)
	{
		return Names.QuincyPendant_UnlocalizedName[itemstack.getItemDamage()];
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
		if( par1ItemStack.getItemDamage() == 0 && !par3EntityPlayer.worldObj.isRemote && props.getCurrentEnergy() >= (float)10 / (float)props.getCurrentCap() && props.getFaction() == 2)
		{
			props.consumeEnergy(10);
	    	par1ItemStack = new ItemStack(BleachItems.quincybow, 1);
		}
		
		else if( par1ItemStack.getItemDamage() == 1 && !par3EntityPlayer.worldObj.isRemote && props.getCurrentEnergy() >= (float)20 / (float)props.getCurrentCap() && props.getFaction() == 2)
		{
			props.consumeEnergy(20);
	    	par1ItemStack = new ItemStack(BleachItems.quincyweb, 1);
		}
        return par1ItemStack;
    }

	
	
    public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
        return null;
    }
    
    @Override
    public void getSubItems(int id, CreativeTabs tab, List list) 
    {
    	for(int i = 0; i < icons.length; i++) 
    	{
    		ItemStack itemstack = new ItemStack(id, 1, i);
    		list.add(itemstack);
    	}
    }


}
