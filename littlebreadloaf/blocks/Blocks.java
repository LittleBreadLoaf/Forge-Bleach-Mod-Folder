package littlebreadloaf.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;
import littlebreadloaf.libraries.Ids;
import littlebreadloaf.libraries.Names;

public class Blocks 
{
	public static Block reiatsuBlock;
	public static Block hollowBait;
	public static Block maskOre;
	public static Block purpleGoo;
	public static Block reiatsuOre;
	public static Block sekkiseki;
	public static Block soulQuartzOre;
	public static Block soulQuartzBlock;
	public static Block soulQuartzLamp;
	public static Block whitesand;
	public static Block paperwall;
	public static Block paperdoor;
	public static Block hollowdiamond;
	public static Block hollowemerald;
	public static Block hollowgold;
	public static Block sphereLamp;

	public static void init() 
	{
		reiatsuBlock = new BlockReiatsu(Ids.reiatsuBlockID);
		GameRegistry.registerBlock(reiatsuBlock, Names.ReiatsuBlock_Name);
		
		hollowBait = new BlockHollowBait(Ids.hollowBaitID);
		GameRegistry.registerBlock(hollowBait, Names.HollowBait_Name);
		
		maskOre = new BlockMaskOre(Ids.maskOreID);
		GameRegistry.registerBlock(maskOre, Names.MaskOre_Name);
		
		purpleGoo = new BlockPurpleGoo(Ids.purpleGooID);
		GameRegistry.registerBlock(purpleGoo, Names.PurpleGoo_Name);
		
		reiatsuOre = new BlockReiatsuOre(Ids.reiatsuOreID);
		GameRegistry.registerBlock(reiatsuOre, Names.ReiatsuOre_Name);
		
		sekkiseki = new BlockSekkiseki(Ids.sekkisekiID);
		GameRegistry.registerBlock(sekkiseki, Names.Sekkiseki_Name);
		
		soulQuartzOre = new BlockSoulQuartzOre(Ids.soulQuartzOreID);
		GameRegistry.registerBlock(soulQuartzOre, Names.SoulQuartzOre_Name);
		
		soulQuartzBlock = new BlockSoulQuartzBlock(Ids.soulQuartzBlockID);
		GameRegistry.registerBlock(soulQuartzBlock, Names.SoulQuartzBlock_Name);
		
		soulQuartzLamp = new BlockSoulQuartzLamp(Ids.soulQuartzLampID);
		GameRegistry.registerBlock(soulQuartzLamp, Names.SoulQuartzLamp_Name);
		
		whitesand = new BlockWhiteSand(Ids.whitesandID);
		GameRegistry.registerBlock(whitesand, Names.WhiteSand_Name);
		
		paperwall = (new BlockPaperWall(Ids.paperwallID, Names.PaperWall_UnlocalizedName, Names.PaperWall_UnlocalizedName, Material.wood, true)).setHardness(5.0F).setResistance(10.0F).setUnlocalizedName(Names.PaperWall_UnlocalizedName);
		GameRegistry.registerBlock(paperwall, Names.PaperWall_Name);
		
		hollowdiamond = new BlockHollowDiamond(Ids.hollowdiamondID);
		GameRegistry.registerBlock(hollowdiamond, Names.HollowDiamond_Name);
		
		hollowemerald = new BlockHollowEmerald(Ids.hollowemeraldID);
		GameRegistry.registerBlock(hollowemerald, Names.HollowEmerald_Name);

		hollowgold = new BlockHollowGold(Ids.hollowgoldID);
		GameRegistry.registerBlock(hollowgold, Names.HollowGold_Name);
		
		//paperdoor = new BlockPaperDoor(Ids.paperdoorID);
		//GameRegistry.registerBlock(paperdoor, Names.PaperDoor_Name);
		

		sphereLamp = new BlockLampSphere(Ids.sphereLampID, Material.glass);
		GameRegistry.registerBlock(sphereLamp, Names.SphereLamp_Name);
		
	}

	public static void addNames() 
	{
		LanguageRegistry.addName(reiatsuBlock, Names.ReiatsuBlock_Name);
		LanguageRegistry.addName(hollowBait, Names.HollowBait_Name);
		LanguageRegistry.addName(maskOre, Names.MaskOre_Name);
		LanguageRegistry.addName(purpleGoo, Names.PurpleGoo_Name);
		LanguageRegistry.addName(reiatsuOre, Names.ReiatsuOre_Name);
		LanguageRegistry.addName(sekkiseki, Names.Sekkiseki_Name);
		LanguageRegistry.addName(soulQuartzOre, Names.SoulQuartzOre_Name);
		LanguageRegistry.addName(soulQuartzBlock, Names.SoulQuartzBlock_Name);
		LanguageRegistry.addName(soulQuartzLamp, Names.SoulQuartzLamp_Name);
		LanguageRegistry.addName(whitesand, Names.WhiteSand_Name);
		LanguageRegistry.addName(paperwall, Names.PaperWall_Name);
		LanguageRegistry.addName(hollowdiamond, Names.HollowDiamond_Name);
		LanguageRegistry.addName(hollowemerald, Names.HollowEmerald_Name);
		LanguageRegistry.addName(hollowgold, Names.HollowGold_Name);
		LanguageRegistry.addName(sphereLamp, Names.SphereLamp_Name);
	}
}