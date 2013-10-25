package littlebreadloaf.items;

import littlebreadloaf.armor.Armor;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;

public class TabBleach extends CreativeTabs 
{

	public TabBleach(int par1, String par2Str) 
	{
		super(par1, par2Str);
	}
	
	@SideOnly(Side.CLIENT)
	public int getTabIconItemIndex()
	{
		return Armor.HollowHelmet.itemID;	
	}
	
	public String getTranslatedTabLabel()
	{
		return "Bleach Mod";
	}

}
