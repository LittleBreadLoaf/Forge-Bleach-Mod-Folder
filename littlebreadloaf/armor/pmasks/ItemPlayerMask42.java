package littlebreadloaf.armor.pmasks;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import littlebreadloaf.entities.classes.CustomEntityList;
import littlebreadloaf.items.Items;
import littlebreadloaf.libraries.BleachModInfo;
import littlebreadloaf.libraries.Names;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.Icon;

public class ItemPlayerMask42 extends ItemArmor 
{

    @SideOnly(Side.CLIENT)
    private Icon theIcon;

	public ItemPlayerMask42(int par1, EnumArmorMaterial par2, int par3, int par4) 
	{
		super(par1, par2, par3, par4);
		this.setUnlocalizedName(Names.PlayerMask42_UnlocalizedName);
		this.setCreativeTab(Items.tabBleach);
		this.setTextureName("LBLBM:playermask4");
	}
	
	 @SideOnly(Side.CLIENT)
	    public void registerIcons(IconRegister par1IconRegister)
	    {
	        super.registerIcons(par1IconRegister);
	        this.theIcon = par1IconRegister.registerIcon(this.getIconString() + "line2");
	    }
	

	public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer)
	{
		return BleachModInfo.ID.toLowerCase() + ":textures/models/armor/player_mask4.png";
	}
	
	 @SideOnly(Side.CLIENT)
	    public int getColorFromItemStack(ItemStack par1ItemStack, int par2)
	    {
		 
	        return par2 == 0 ? 16777215 : this.getColor(par1ItemStack);
	    }
	 
	 public void setNBTColor(ItemStack par1ItemStack, int par2)
	 {
		 NBTTagCompound nbttagcompound = par1ItemStack.getTagCompound();

      if (nbttagcompound == null)
      {
          nbttagcompound = new NBTTagCompound();
          par1ItemStack.setTagCompound(nbttagcompound);
      }

      NBTTagCompound nbttagcompound1 = nbttagcompound.getCompoundTag("display");

      if (!nbttagcompound.hasKey("display"))
      {
          nbttagcompound.setCompoundTag("display", nbttagcompound1);
      }

      nbttagcompound1.setInteger("color", par2);
	 }
	
	    @SideOnly(Side.CLIENT)
	    public boolean requiresMultipleRenderPasses()
	    {
	        return true;
	    }

	    @SideOnly(Side.CLIENT)
	    public int getColor(ItemStack par1ItemStack)
	    {
	    	  NBTTagCompound nbttagcompound = par1ItemStack.getTagCompound();

	            if (nbttagcompound == null)
	            {
	                return 10511680;
	            }
	            else
	            {
	                NBTTagCompound nbttagcompound1 = nbttagcompound.getCompoundTag("display");
	                return nbttagcompound1 == null ? 10511680 : (nbttagcompound1.hasKey("color") ? nbttagcompound1.getInteger("color") : 10511680);
	            }
	    }

	    @SideOnly(Side.CLIENT)

	    /**
	     * Gets an icon index based on an item's damage value and the given render pass
	     */
	    public Icon getIconFromDamageForRenderPass(int par1, int par2)
	    {
	        return par2 > 0 ? this.theIcon : super.getIconFromDamageForRenderPass(par1, par2);
	    }

	
}
