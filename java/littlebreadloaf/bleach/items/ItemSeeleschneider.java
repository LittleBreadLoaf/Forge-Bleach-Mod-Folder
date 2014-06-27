package littlebreadloaf.bleach.items;

import javax.swing.Icon;

import littlebreadloaf.bleach.BleachModInfo;
import littlebreadloaf.bleach.Names;
import littlebreadloaf.bleach.api.Tools;
import littlebreadloaf.bleach.armor.Armor;
import littlebreadloaf.bleach.blocks.BleachBlocks;
import littlebreadloaf.bleach.events.ExtendedPlayer;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.google.common.collect.Multimap;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemSeeleschneider extends ItemSword
{
	@SideOnly(Side.CLIENT)
	public static IIcon[] icons;
	private float weaponDamage;
	private final ToolMaterial toolMaterial;
	public float damageBoost = 0;
	public float robeboost = 0;
	public float pantboost = 0;
	public float sandalboost = 0;

	private static final String[] ICON =
	{ "seele", "seele2" };

	public ItemSeeleschneider(ToolMaterial material)
	{
		super(material);
		this.toolMaterial = material;
		this.maxStackSize = 1;
		this.setMaxDamage(material.getMaxUses());
		this.setCreativeTab(BleachItems.tabBleach);
		this.setHasSubtypes(true);
		this.weaponDamage = 2.0F + material.getDamageVsEntity();

	}
	
	
	@Override
	public float func_150931_i()
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
	public IIcon getIconFromDamage(int damage)
	{
		return icons[damage];
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister icon)
	{
		icons = new IIcon[ICON.length];

		for (int i = 0; i < icons.length; i++)
		{
			icons[i] = icon.registerIcon(BleachModInfo.ID.toLowerCase() + ":" + ICON[i]);
		}
	}

	/**
	 * Called whenever this item is equipped and the right mouse button is
	 * pressed. Args: itemStack, world, entityPlayer
	 */
	@Override
	public ItemStack onItemRightClick(ItemStack item, World par2World, EntityPlayer player)
	{

		ExtendedPlayer props = (ExtendedPlayer) player.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);
		if (item.getItemDamage() == 0 && !player.worldObj.isRemote && props.getCurrentEnergy() >= (float) 70 / (float) props.getCurrentCap() && props.getFaction() == 2)
		{
			props.consumeEnergy(70);
			item.setItemDamage(1);
		}
		return item;
	}

	@Override
	public boolean onItemUse(ItemStack item, EntityPlayer player, World world, int x, int y, int z, int side, float par8, float par9, float f)
	{
		if (!world.isRemote)
		{
			if (item.getItemDamage() == 1 && side == 1 && world.doesBlockHaveSolidTopSurface(world, x, y, z))
			{
				world.setBlock(x, y + 1, z, BleachBlocks.seeleSchneiderBlock);
				if (!player.capabilities.isCreativeMode)
				{
					player.getCurrentEquippedItem().stackSize--;
				}
			}
		}
		return true;
	}

	/**
	 * Current implementations of this method in child classes do not use the
	 * entry argument beside ev. They just raise the damage on the stack.
	 */
	@Override
	public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
	{
		EntityPlayer player = (EntityPlayer) par3EntityLivingBase;
		ExtendedPlayer props = (ExtendedPlayer) player.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);

		ItemStack var9 = player.inventory.armorInventory[0];
		ItemStack var10 = player.inventory.armorInventory[1];
		ItemStack var11 = player.inventory.armorInventory[2];
		ItemStack var7 = player.inventory.armorInventory[3];
		ItemStack var33 = player.inventory.getCurrentItem();

		if (var33 != null && var33.getItem() == BleachItems.seele && var33.getItemDamage() == 1)
		{

			if (var9 != null && var9.getItem() == Armor.QuincyShoes)
			{
				sandalboost = 1;
			} else
			{
				sandalboost = 0;
			}

			if (var10 != null && var10.getItem() == Armor.QuincyPants)
			{
				pantboost = 1;
			} else
			{
				pantboost = 0;
			}

			if (var11 != null && var11.getItem() == Armor.QuincyRobe)
			{
				robeboost = 1;
			} else
			{
				robeboost = 0;
			}

			if (par2EntityLivingBase.getCreatureAttribute() == Tools.SPIRIT)
			{
				if (!player.worldObj.isRemote && props.getFaction() == 2)
				{
					props.addSXP(3);
				}
				damageBoost = 4;
			} else
			{
				if (!player.worldObj.isRemote && props.getFaction() == 2)
				{
					props.addSXP(1);
				}
				damageBoost = 0;
			}

			float damage = this.damageBoost + this.sandalboost + this.pantboost + this.robeboost;
			if (damage > 0 && props.getFaction() == 2 && var33.getItemDamage() == 1)
			{
				par2EntityLivingBase.setHealth(par2EntityLivingBase.getHealth() - damage);
			}

		}

		return true;
	}

	@Override
	public EnumAction getItemUseAction(ItemStack par1ItemStack)
	{
		return EnumAction.block;
	}

	@Override
	public Multimap getItemAttributeModifiers()
	{
		float damage = this.getDamage();
		Multimap multimap = super.getItemAttributeModifiers();
		multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Weapon modifier", (double) damage, 0));
		return multimap;
	}

}
