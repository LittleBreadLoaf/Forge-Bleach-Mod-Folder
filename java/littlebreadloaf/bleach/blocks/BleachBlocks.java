package littlebreadloaf.bleach.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockIce;
import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;
import littlebreadloaf.bleach.BleachIds;
import littlebreadloaf.bleach.BleachModInfo;
import littlebreadloaf.bleach.Names;

public class BleachBlocks 
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
	//public static Block ssportal;
	public static Block paperdoor;
	public static Block hollowdiamond;
	public static Block hollowemerald;
	public static Block hollowgold;
	//public static Block sphereLamp;
	public static Block paperLamp;
	public static Block seeleSchneiderBlock;
	public static Block shikaiIceBlock;
	public static Block poisonShroom;

	public static void init() 
	{
		reiatsuBlock = new BlockReiatsu().setBlockTextureName(BleachModInfo.ID + Names.ReiatsuBlock_UnlocalizedName);
		
		hollowBait = new BlockHollowBait().setBlockTextureName(BleachModInfo.ID + Names.HollowBait_UnlocalizedName);
		
		maskOre = new BlockMaskOre().setBlockTextureName(BleachModInfo.ID + Names.MaskOre_UnlocalizedName);
		
		purpleGoo = new BlockPurpleGoo().setBlockTextureName(BleachModInfo.ID + Names.PurpleGoo_UnlocalizedName);
		
		reiatsuOre = new BlockReiatsuOre().setBlockTextureName(BleachModInfo.ID + Names.ReiatsuOre_UnlocalizedName);
		
		sekkiseki = new BlockSekkiseki(BleachIds.sekkisekiID).setBlockTextureName(BleachModInfo.ID + Names.Sekkiseki_UnlocalizedName);
		
		soulQuartzOre = new BlockSoulQuartzOre().setBlockTextureName(BleachModInfo.ID + Names.SoulQuartzOre_UnlocalizedName);
		
		soulQuartzBlock = new BlockSoulQuartzBlock().setBlockTextureName(BleachModInfo.ID + Names.SoulQuartzBlock_UnlocalizedName);
		
		soulQuartzLamp = new BlockSoulQuartzLamp().setBlockTextureName(BleachModInfo.ID + Names.SoulQuartzLamp_UnlocalizedName);
		
		whitesand = new BlockWhiteSand().setBlockTextureName(BleachModInfo.ID + Names.WhiteSand_UnlocalizedName);
		
		paperwall = (new BlockPaperWall(Names.PaperWall_UnlocalizedName, Names.PaperWall_UnlocalizedName, Material.wood, true)).setHardness(5.0F).setResistance(10.0F).setBlockName(Names.PaperWall_UnlocalizedName).setBlockTextureName(BleachModInfo.ID + Names.PaperWall_UnlocalizedName);
		
		//ssportal = (new BlockSSPortal(BleachIds.ssportalID, Names.SSPortal_UnlocalizedName, Names.SSPortal_UnlocalizedName, Material.portal, true)).setHardness(-1).setResistance(30.0F).setUnlocalizedName(Names.SSPortal_UnlocalizedName);
		//GameRegistry.registerBlock(ssportal, Names.SSPortal_Name);
		
		hollowdiamond = new BlockHollowDiamond().setBlockTextureName(BleachModInfo.ID + Names.HollowDiamond_UnlocalizedName);
		
		hollowemerald = new BlockHollowEmerald().setBlockTextureName(BleachModInfo.ID + Names.HollowEmerald_UnlocalizedName);

		hollowgold = new BlockHollowGold().setBlockTextureName(BleachModInfo.ID + Names.HollowGold_UnlocalizedName);
		
		//sphereLamp = new BlockLampSphere(BleachIds.sphereLampID, Material.glass);
		//GameRegistry.registerBlock(sphereLamp, Names.SphereLamp_Name);

		paperLamp = new BlockLantern(Material.glass).setBlockTextureName(BleachModInfo.ID + Names.Lantern_UnlocalizedName);

		seeleSchneiderBlock = new BlockSeeleSchneider(Material.iron);
		
		
		shikaiIceBlock = new BlockShikaiIce();
		
		poisonShroom = new BlockPoisonShroom();
	}

	public static void registerBlocks()
	{
		GameRegistry.registerBlock(reiatsuBlock, Names.ReiatsuBlock_Name);
		GameRegistry.registerBlock(hollowBait, Names.HollowBait_Name);
		GameRegistry.registerBlock(maskOre, Names.MaskOre_Name);
		GameRegistry.registerBlock(purpleGoo, Names.PurpleGoo_Name);
		GameRegistry.registerBlock(reiatsuOre, Names.ReiatsuOre_Name);
		GameRegistry.registerBlock(sekkiseki, Names.Sekkiseki_Name);
		GameRegistry.registerBlock(soulQuartzOre, Names.SoulQuartzOre_Name);
		GameRegistry.registerBlock(soulQuartzBlock, Names.SoulQuartzBlock_Name);
		GameRegistry.registerBlock(soulQuartzLamp, Names.SoulQuartzLamp_Name);
		GameRegistry.registerBlock(whitesand, Names.WhiteSand_Name);
		GameRegistry.registerBlock(paperwall, Names.PaperWall_Name);
		GameRegistry.registerBlock(hollowdiamond, Names.HollowDiamond_Name);
		GameRegistry.registerBlock(hollowemerald, Names.HollowEmerald_Name);
		GameRegistry.registerBlock(hollowgold, Names.HollowGold_Name);
		GameRegistry.registerBlock(paperLamp, Names.Lantern_Name);
		GameRegistry.registerBlock(seeleSchneiderBlock, "Seeleschneider Block");
		GameRegistry.registerBlock(shikaiIceBlock, Names.ShikaiIceBlock_Name);
		GameRegistry.registerBlock(poisonShroom, "Poison Mushroom");
	}
	
}