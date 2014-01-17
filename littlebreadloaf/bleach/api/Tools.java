package littlebreadloaf.bleach.api;

import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraftforge.common.EnumHelper;

public class Tools 
{
	public static EnumToolMaterial SOUL = EnumHelper.addToolMaterial("Soul", 1, -1, 6.0F, 1, 14);
	public static EnumToolMaterial SHIKAI = EnumHelper.addToolMaterial("Shikai", 1, -1, 7.0F, 2, 14);
	
	public static EnumArmorMaterial MASK = EnumHelper.addArmorMaterial("Mask", -1, new int[] {0, 0, 0, 0}, 0);
	public static EnumArmorMaterial SOULS = EnumHelper.addArmorMaterial("Souls", -1, new int[] {0, 4, 2, 1}, 0);
	public static EnumArmorMaterial QUINCY = EnumHelper.addArmorMaterial("Quincy", -1, new int[] {0, 3, 1, 1}, 0);
	
	public static EnumCreatureAttribute SPIRIT = EnumHelper.addCreatureAttribute("Spirit");

}
