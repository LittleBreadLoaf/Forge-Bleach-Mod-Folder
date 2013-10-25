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
import net.minecraft.util.Icon;

public class ItemPlayerMask10 extends ItemArmor 
{

    @SideOnly(Side.CLIENT)
    private Icon theIcon;

	public ItemPlayerMask10(int par1, EnumArmorMaterial par2, int par3, int par4) 
	{
		super(par1, par2, par3, par4);
		this.setUnlocalizedName(Names.PlayerMask10_UnlocalizedName);
		this.setCreativeTab(Items.tabBleach);
		this.func_111206_d("LBLBM:playermask1");
        this.setHasSubtypes(true);
	}
	
	 @SideOnly(Side.CLIENT)
	    public void registerIcons(IconRegister par1IconRegister)
	    {
	        super.registerIcons(par1IconRegister);
	        this.theIcon = par1IconRegister.registerIcon(this.func_111208_A() + "line0");
	    }
	

	public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer)
	{
		return BleachModInfo.ID.toLowerCase() + ":textures/models/armor/player_mask1.png";
	}
	
	 @SideOnly(Side.CLIENT)
	    public int getColorFromItemStack(ItemStack par1ItemStack, int par2)
	    {
	        return par2 == 0 ? 16777215 : 000000;
	    }
	
	    @SideOnly(Side.CLIENT)
	    public boolean requiresMultipleRenderPasses()
	    {
	        return true;
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
