package littlebreadloaf.bleach.api;

import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class Tools 
{
	public static ToolMaterial SOUL = EnumHelper.addToolMaterial("Soul", 1, -1, 6.0F, 1, 14);
	public static ToolMaterial SHIKAI = EnumHelper.addToolMaterial("Shikai", 1, -1, 7.0F, 2, 14);
	public static ToolMaterial SHINAI = EnumHelper.addToolMaterial("Shinai", 1, -1, 2.0F, 1, 14);
	
	public static ArmorMaterial MASK = EnumHelper.addArmorMaterial("Mask", -1, new int[] {0, 0, 0, 0}, 0);
	public static ArmorMaterial SOULS = EnumHelper.addArmorMaterial("Souls", -1, new int[] {0, 4, 2, 1}, 0);
	public static ArmorMaterial QUINCY = EnumHelper.addArmorMaterial("Quincy", -1, new int[] {0, 3, 1, 1}, 0);
	
	public static EnumCreatureAttribute SPIRIT = EnumHelper.addCreatureAttribute("Spirit");
	
	
	

}
