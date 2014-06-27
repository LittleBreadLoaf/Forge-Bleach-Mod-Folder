package littlebreadloaf.bleach.items;

import java.util.Random;

import littlebreadloaf.bleach.BleachModInfo;
import littlebreadloaf.bleach.Names;
import littlebreadloaf.bleach.api.Tools;
import littlebreadloaf.bleach.events.ExtendedPlayer;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;

import com.google.common.collect.Multimap;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemShinai extends ItemSword
{
    private float weaponDamage;
    private final ToolMaterial toolMaterial;
    Random rand = new Random();
    
    public ItemShinai(ToolMaterial par2EnumToolReiatsu)
    {
        super(par2EnumToolReiatsu);
        this.toolMaterial = par2EnumToolReiatsu;
        this.maxStackSize = 1;
        this.setMaxDamage(par2EnumToolReiatsu.getMaxUses());
        this.setCreativeTab(BleachItems.tabBleach);
        this.setUnlocalizedName(Names.Shinai_UnlocalizedName);
        this.weaponDamage = 1.0F;
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
		itemIcon = icon.registerIcon(BleachModInfo.ID.toLowerCase() + ":" + Names.Shinai_UnlocalizedName);
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
        

      
    	
        
        if(par2EntityLivingBase.getCreatureAttribute() == Tools.SPIRIT)
        {
        	if(!player.worldObj.isRemote && props.getFaction() == 1)
        	{
        		props.addSXP(2);
        	}
        }
        else
        {
        	if(!player.worldObj.isRemote && props.getFaction() == 1)
        	{
        		props.addSXP(1);
        	}
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
    

    /**
     * Returns if the item (tool) can harvest results from the block type.
     */
    public boolean canHarvestBlock(Block par1Block)
    {
        return par1Block == Blocks.web;
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
    
    
    
    
  
        
   

}
