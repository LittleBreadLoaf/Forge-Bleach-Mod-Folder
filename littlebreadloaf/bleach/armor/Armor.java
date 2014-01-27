package littlebreadloaf.bleach.armor;

import littlebreadloaf.bleach.BleachMod;
import littlebreadloaf.bleach.BleachIds;
import littlebreadloaf.bleach.Names;
import littlebreadloaf.bleach.api.Tools;
import littlebreadloaf.bleach.armor.pmasks.ItemPlayerMask10;
import littlebreadloaf.bleach.armor.pmasks.ItemPlayerMask11;
import littlebreadloaf.bleach.armor.pmasks.ItemPlayerMask12;
import littlebreadloaf.bleach.armor.pmasks.ItemPlayerMask20;
import littlebreadloaf.bleach.armor.pmasks.ItemPlayerMask21;
import littlebreadloaf.bleach.armor.pmasks.ItemPlayerMask22;
import littlebreadloaf.bleach.armor.pmasks.ItemPlayerMask30;
import littlebreadloaf.bleach.armor.pmasks.ItemPlayerMask31;
import littlebreadloaf.bleach.armor.pmasks.ItemPlayerMask32;
import littlebreadloaf.bleach.armor.pmasks.ItemPlayerMask40;
import littlebreadloaf.bleach.armor.pmasks.ItemPlayerMask41;
import littlebreadloaf.bleach.armor.pmasks.ItemPlayerMask42;
import littlebreadloaf.bleach.proxies.CommonProxy;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Armor 
{

	public static Item HollowHelmet;
	public static Item BatHelmet;
	public static Item SpiderHelmet;
	public static Item BlazeHelmet;
	public static Item SnakeHelmet;
	public static Item GolemHelmet;
	public static Item WaspHelmet;
	public static Item StalkerHelmet;
	public static Item WolfHelmet;
	
	public static Item PlayerMask10;
	public static Item PlayerMask11;
	public static Item PlayerMask12;
	public static Item PlayerMask20;
	public static Item PlayerMask21;
	public static Item PlayerMask22;
	public static Item PlayerMask30;
	public static Item PlayerMask31;
	public static Item PlayerMask32;
	public static Item PlayerMask40;
	public static Item PlayerMask41;
	public static Item PlayerMask42;
	
	public static Item ShiniRobe;
	public static Item ShiniPants;
	public static Item Sandals;
	
	public static Item QuincyRobe;
	public static Item QuincyPants;
	public static Item QuincyShoes;
	
	public static Item ArrancarJacket;
	public static Item ArrancarPants;
	public static Item ArrancarShoes;

	public static void init()
	{
		HollowHelmet = new ItemHollowHelmet(BleachIds.hollowHelmetID, Tools.MASK, BleachMod.proxy.addArmor("hollow_helmet"), 0);
		BatHelmet = new ItemBatHelmet(BleachIds.batHelmetID, Tools.MASK, BleachMod.proxy.addArmor("bat_helmet"), 0);
		SpiderHelmet = new ItemSpiderHelmet(BleachIds.spiderHelmetID, Tools.MASK, BleachMod.proxy.addArmor("spider_helmet"), 0);
		BlazeHelmet = new ItemBlazeHelmet(BleachIds.blazeHelmetID, Tools.MASK, BleachMod.proxy.addArmor("blaze_helmet"), 0);
		SnakeHelmet = new ItemSnakeHelmet(BleachIds.snakeHelmetID, Tools.MASK, BleachMod.proxy.addArmor("snake_helmet"), 0);
		GolemHelmet = new ItemGolemHelmet(BleachIds.golemHelmetID, Tools.MASK, BleachMod.proxy.addArmor("golem_helmet"), 0);
		WaspHelmet = new ItemWaspHelmet(BleachIds.waspHelmetID, Tools.MASK, BleachMod.proxy.addArmor("wasp_helmet"), 0);
		StalkerHelmet = new ItemStalkerHelmet(BleachIds.stalkerHelmetID, Tools.MASK, BleachMod.proxy.addArmor("stalker_helmet"), 0);
		WolfHelmet = new ItemWolfHelmet(BleachIds.wolfHelmetID, Tools.MASK, BleachMod.proxy.addArmor("wolf_helmet"), 0);
		
		PlayerMask10 = new ItemPlayerMask10(BleachIds.playerMask10ID, Tools.MASK, BleachMod.proxy.addArmor("player_mask10"), 0);
		PlayerMask11 = new ItemPlayerMask11(BleachIds.playerMask11ID, Tools.MASK, BleachMod.proxy.addArmor("player_mask11"), 0);
		PlayerMask12 = new ItemPlayerMask12(BleachIds.playerMask12ID, Tools.MASK, BleachMod.proxy.addArmor("player_mask12"), 0);
		PlayerMask20 = new ItemPlayerMask20(BleachIds.playerMask20ID, Tools.MASK, BleachMod.proxy.addArmor("player_mask20"), 0);
		PlayerMask21 = new ItemPlayerMask21(BleachIds.playerMask21ID, Tools.MASK, BleachMod.proxy.addArmor("player_mask21"), 0);
		PlayerMask22 = new ItemPlayerMask22(BleachIds.playerMask22ID, Tools.MASK, BleachMod.proxy.addArmor("player_mask22"), 0);
		PlayerMask30 = new ItemPlayerMask30(BleachIds.playerMask30ID, Tools.MASK, BleachMod.proxy.addArmor("player_mask30"), 0);
		PlayerMask31 = new ItemPlayerMask31(BleachIds.playerMask31ID, Tools.MASK, BleachMod.proxy.addArmor("player_mask31"), 0);
		PlayerMask32 = new ItemPlayerMask32(BleachIds.playerMask32ID, Tools.MASK, BleachMod.proxy.addArmor("player_mask32"), 0);
		PlayerMask40 = new ItemPlayerMask40(BleachIds.playerMask40ID, Tools.MASK, BleachMod.proxy.addArmor("player_mask40"), 0);
		PlayerMask41 = new ItemPlayerMask41(BleachIds.playerMask41ID, Tools.MASK, BleachMod.proxy.addArmor("player_mask41"), 0);
		PlayerMask42 = new ItemPlayerMask42(BleachIds.playerMask42ID, Tools.MASK, BleachMod.proxy.addArmor("player_mask42"), 0);
		
		ShiniRobe = new ItemShiniRobe(BleachIds.shinirobeID, Tools.SOULS, BleachMod.proxy.addArmor("shinigami"), 1);
		ShiniPants = new ItemShiniPants(BleachIds.shinipantsID, Tools.SOULS, BleachMod.proxy.addArmor("shinigami"), 2);
		Sandals = new ItemSandals(BleachIds.sandalsID, Tools.SOULS, BleachMod.proxy.addArmor("shinigami"), 3);
		
		QuincyRobe = new ItemQuincyRobe(BleachIds.quincyrobeID, Tools.SOULS, BleachMod.proxy.addArmor("quincy"), 1);
		QuincyPants = new ItemQuincyPants(BleachIds.quincypantsID, Tools.SOULS, BleachMod.proxy.addArmor("quincy"), 2);
		QuincyShoes = new ItemQuincyShoes(BleachIds.quincyshoesID, Tools.SOULS, BleachMod.proxy.addArmor("quincy"), 3);

		ArrancarJacket = new ItemArrancarTop(BleachIds.arrancartopID, Tools.SOULS, BleachMod.proxy.addArmor("arrancar"), 1);
		ArrancarPants = new ItemArrancarPants(BleachIds.arrancarpantsID, Tools.SOULS, BleachMod.proxy.addArmor("arrancar"), 2);
		ArrancarShoes = new ItemArrancarShoes(BleachIds.arrancarshoesID, Tools.SOULS, BleachMod.proxy.addArmor("arrancar"), 3);
	}
	
	public static void addNames()
	{
		LanguageRegistry.addName(HollowHelmet, Names.HollowHelmet_Name);
		LanguageRegistry.addName(BatHelmet, Names.BatHelmet_Name);
		LanguageRegistry.addName(SpiderHelmet, Names.SpiderHelmet_Name);
		LanguageRegistry.addName(BlazeHelmet, Names.BlazeHelmet_Name);
		LanguageRegistry.addName(SnakeHelmet, Names.SnakeHelmet_Name);
		LanguageRegistry.addName(GolemHelmet, Names.GolemHelmet_Name);
		LanguageRegistry.addName(WaspHelmet, Names.WaspHelmet_Name);
		LanguageRegistry.addName(StalkerHelmet, Names.StalkerHelmet_Name);
		LanguageRegistry.addName(WolfHelmet, Names.WolfHelmet_Name);
		
		LanguageRegistry.addName(ShiniRobe, Names.ShinigamiChest_Name);
		LanguageRegistry.addName(ShiniPants, Names.ShinigamiPants_Name);
		LanguageRegistry.addName(Sandals, Names.Sandals_Name);
		
		LanguageRegistry.addName(QuincyRobe, Names.QuincyChest_Name);
		LanguageRegistry.addName(QuincyPants, Names.QuincyPants_Name);
		LanguageRegistry.addName(QuincyShoes, Names.QuincyShoes_Name);
		
		LanguageRegistry.addName(ArrancarJacket, Names.ArrancarTop_Name);
		LanguageRegistry.addName(ArrancarPants, Names.ArrancarPants_Name);
		LanguageRegistry.addName(ArrancarShoes, Names.ArrancarShoes_Name);
		
		
		LanguageRegistry.addName(PlayerMask10, Names.PlayerMask10_Name);
		LanguageRegistry.addName(PlayerMask11, Names.PlayerMask11_Name);
		LanguageRegistry.addName(PlayerMask12, Names.PlayerMask12_Name);
		LanguageRegistry.addName(PlayerMask20, Names.PlayerMask20_Name);
		LanguageRegistry.addName(PlayerMask21, Names.PlayerMask21_Name);
		LanguageRegistry.addName(PlayerMask22, Names.PlayerMask22_Name);
		LanguageRegistry.addName(PlayerMask30, Names.PlayerMask30_Name);
		LanguageRegistry.addName(PlayerMask31, Names.PlayerMask31_Name);
		LanguageRegistry.addName(PlayerMask32, Names.PlayerMask32_Name);
		LanguageRegistry.addName(PlayerMask40, Names.PlayerMask40_Name);
		LanguageRegistry.addName(PlayerMask41, Names.PlayerMask41_Name);
		LanguageRegistry.addName(PlayerMask42, Names.PlayerMask42_Name);
		
		
	}

	
}
