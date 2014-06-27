package littlebreadloaf.bleach.items.shikai;

import java.util.List;
import java.util.Random;

import littlebreadloaf.bleach.BleachMod;
import littlebreadloaf.bleach.BleachModInfo;
import littlebreadloaf.bleach.Names;
import littlebreadloaf.bleach.api.Tools;
import littlebreadloaf.bleach.armor.Armor;
import littlebreadloaf.bleach.events.ExtendedPlayer;
import littlebreadloaf.bleach.events.PacketParticle;
import littlebreadloaf.bleach.extras.ParticleEffects;
import littlebreadloaf.bleach.items.BleachItems;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.EnumAction;
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

public class ShikaiWind extends ItemSword
{
	public static IIcon[] icons;
	private static final String[] ICON = Names.ShikaiWind_UnlocalizedName;

	private float weaponDamage;
	private final ToolMaterial toolMaterial;
	public float damageBoost = 0;
	public float robeboost = 0;
	public float pantboost = 0;
	public float sandalboost = 0;
	
	Random rand = new Random();
	
	public ShikaiWind(ToolMaterial material) 
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
		if(itemStack.getItemDamage() == 2)
		{
			data.add("BrandonKgp13");
		}
	
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemstack)
	{
		return Names.ShikaiWind_UnlocalizedName[itemstack.getItemDamage()];
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
        if(!player.worldObj.isRemote)
    	{
        	par2EntityLivingBase.motionY += 0.4000000060607645D;
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
        float damage = this.damageBoost + this.sandalboost + this.pantboost + this.robeboost;
        if(damage > 0 && props.getFaction() == 1 && damage <= par2EntityLivingBase.getHealth())
        {
            par2EntityLivingBase.attackEntityFrom(DamageSource.generic, damage);
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
	int var6 = this.getMaxItemUseDuration(var1) - var4;
    float var7 = (float)var6 / 20.0F;
    var7 = (var7 * var7 + var7 * 2.0F) / 3.0F;

    var3.swingItem();
    if ((double)var7 < 0.1D)
    {
        return;
    }

    
        if(var7 > 2.0F)
        {
        	var7 = 2.0F;
        }

    	//var3.motionY += var7;
        if(!var2.isRemote)
        {
        	props.consumeEnergy((int)(5 * var7));
        	
        }
        

    
}
    
@Override
public void onUsingTick(ItemStack stack, EntityPlayer player, int count)
{
	Vec3 normalizer = Vec3.createVectorHelper(0.008, 0.008, 0.008).normalize();
	List list = player.worldObj.getEntitiesWithinAABBExcludingEntity(player, player.boundingBox.copy().expand(Math.abs(normalizer.xCoord * 3.0D) + 3, Math.abs(normalizer.yCoord * 3.0D) + 3, Math.abs(normalizer.zCoord * 3.0D) + 3));
	for (int l = 0; l < list.size(); ++l)
	{
		Entity entity1 = (Entity) list.get(l);
		
			if(entity1 instanceof EntityLivingBase)
			{
				double xDist = entity1.posX - player.posX;
				double zDist = entity1.posZ - player.posZ;
				
				if(rand.nextInt(10) == 0)
				entity1.addVelocity(1.5/(double)(Math.signum(xDist)+xDist), 0.4, 1.5/(double)(Math.signum(zDist)+zDist));
				
			}
		
	}
	if(!player.worldObj.isRemote)
	{
        ParticleEffects.spawnParticle("wind", player.posX - 0.9, player.posY + 1, player.posZ + 0.5, 1.0D, 0.0D, 1.0D);
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
        		player.fallDistance = 0;
	        	player.addPotionEffect(new PotionEffect(Potion.jump.id, 20, 3));
	        	if(heldItem.getItemDamage() == 6)
	        	{
	        		player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 20, 0));
	        	}
    		

    			if(props.getZType() != 6)
    				props.deactivate(par1ItemStack.getItem());
    		}
    	}
    }

}
