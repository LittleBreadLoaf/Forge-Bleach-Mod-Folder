package littlebreadloaf.bleach.armor;

import littlebreadloaf.bleach.BleachMod;
import littlebreadloaf.bleach.BleachIds;
import littlebreadloaf.bleach.Names;
import littlebreadloaf.bleach.api.Tools;
import littlebreadloaf.bleach.proxies.CommonProxy;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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
	
	public static Item ShiniRobe;
	public static Item ShiniPants;
	public static Item Sandals;
	
	public static Item QuincyRobe;
	public static Item QuincyPants;
	public static Item QuincyShoes;
	
	public static Item ArrancarJacket;
	public static Item ArrancarPants;
	public static Item ArrancarShoes;
	
	public static Item MaleAcademyTop;
	public static Item MaleAcademyBottom;
	public static Item FemaleAcademyTop;
	public static Item FemaleAcademyBottom;
	
	public static Item MaleSchoolTop;
	public static Item MaleSchoolBottom;
	public static Item FemaleSchoolTop;
	public static Item FemaleSchoolBottom;
	
	public static Item SoulChain;
	

	public static void init()
	{
		HollowHelmet = new ItemHollowHelmet(Tools.MASK, BleachMod.proxy.addArmor("hollow_helmet"), 0);
		BatHelmet = new ItemBatHelmet(Tools.MASK, BleachMod.proxy.addArmor("bat_helmet"), 0);
		SpiderHelmet = new ItemSpiderHelmet(Tools.MASK, BleachMod.proxy.addArmor("spider_helmet"), 0);
		BlazeHelmet = new ItemBlazeHelmet(Tools.MASK, BleachMod.proxy.addArmor("blaze_helmet"), 0);
		SnakeHelmet = new ItemSnakeHelmet(Tools.MASK, BleachMod.proxy.addArmor("snake_helmet"), 0);
		GolemHelmet = new ItemGolemHelmet(Tools.MASK, BleachMod.proxy.addArmor("golem_helmet"), 0);
		WaspHelmet = new ItemWaspHelmet(Tools.MASK, BleachMod.proxy.addArmor("wasp_helmet"), 0);
		StalkerHelmet = new ItemStalkerHelmet(Tools.MASK, BleachMod.proxy.addArmor("stalker_helmet"), 0);
		WolfHelmet = new ItemWolfHelmet(Tools.MASK, BleachMod.proxy.addArmor("wolf_helmet"), 0);
			
		ShiniRobe = new ItemShinigamiRobes(Tools.SOULS, BleachMod.proxy.addArmor("shinigami"), 1).setUnlocalizedName(Names.ShinigamiChest_UnlocalizedName);
		ShiniPants = new ItemShinigamiRobes(Tools.SOULS, BleachMod.proxy.addArmor("shinigami"), 2).setUnlocalizedName(Names.ShinigamiPants_UnlocalizedName);
		Sandals = new ItemShinigamiRobes(Tools.SOULS, BleachMod.proxy.addArmor("shinigami"), 3).setUnlocalizedName(Names.Sandals_UnlocalizedName);
		
		QuincyRobe = new ItemQuincyRobes(Tools.SOULS, BleachMod.proxy.addArmor("quincy"), 1).setUnlocalizedName(Names.QuincyChest_UnlocalizedName);
		QuincyPants = new ItemQuincyRobes(Tools.SOULS, BleachMod.proxy.addArmor("quincy"), 2).setUnlocalizedName(Names.QuincyPants_UnlocalizedName);
		QuincyShoes = new ItemQuincyRobes(Tools.SOULS, BleachMod.proxy.addArmor("quincy"), 3).setUnlocalizedName(Names.QuincyShoes_UnlocalizedName);

		ArrancarJacket = new ItemArrancarArmor(Tools.SOULS, BleachMod.proxy.addArmor("arrancar"), 1).setUnlocalizedName(Names.ArrancarTop_UnlocalizedName);
		ArrancarPants = new ItemArrancarArmor(Tools.SOULS, BleachMod.proxy.addArmor("arrancar"), 2).setUnlocalizedName(Names.ArrancarPants_UnlocalizedName);
		ArrancarShoes = new ItemArrancarArmor(Tools.SOULS, BleachMod.proxy.addArmor("arrancar"), 3).setUnlocalizedName(Names.ArrancarShoes_UnlocalizedName);
	
		MaleAcademyTop = new ItemMAcademyRobes(Tools.MASK, BleachMod.proxy.addArmor("academy"), 1).setUnlocalizedName(Names.MaleAcademyTop_UnlocalizedName);
		MaleAcademyBottom = new ItemMAcademyRobes(Tools.MASK, BleachMod.proxy.addArmor("academy"), 2).setUnlocalizedName(Names.MaleAcademyBottom_UnlocalizedName);
		FemaleAcademyTop = new ItemFAcademyRobes(Tools.MASK, BleachMod.proxy.addArmor("academy2"), 1).setUnlocalizedName(Names.FemaleAcademyTop_UnlocalizedName);
		FemaleAcademyBottom = new ItemFAcademyRobes(Tools.MASK, BleachMod.proxy.addArmor("academy2"), 2).setUnlocalizedName(Names.FemaleAcademyBottom_UnlocalizedName);
		
		MaleSchoolTop = new ItemMSchoolUniform(Tools.MASK, BleachMod.proxy.addArmor("school"), 1).setUnlocalizedName(Names.MaleSchoolTop_UnlocalizedName);
		MaleSchoolBottom = new ItemMSchoolUniform(Tools.MASK, BleachMod.proxy.addArmor("school"), 2).setUnlocalizedName(Names.MaleSchoolBottom_UnlocalizedName);
		FemaleSchoolTop = new ItemFSchoolUniform(Tools.MASK, BleachMod.proxy.addArmor("school2"), 1).setUnlocalizedName(Names.FemaleSchoolTop_UnlocalizedName);
		FemaleSchoolBottom = new ItemFSchoolUniform(Tools.MASK, BleachMod.proxy.addArmor("school2"), 2).setUnlocalizedName(Names.FemaleSchoolBottom_UnlocalizedName);
		
		SoulChain = new ItemSoulChain(Tools.MASK, BleachMod.proxy.addArmor("chain"), 1).setUnlocalizedName("soul_chain");
	}
	
	public static void registerItems()
	{
		GameRegistry.registerItem(HollowHelmet, Names.HollowHelmet_Name);
		GameRegistry.registerItem(BatHelmet, Names.BatHelmet_Name);
		GameRegistry.registerItem(SpiderHelmet, Names.SpiderHelmet_Name);
		GameRegistry.registerItem(BlazeHelmet, Names.BlazeHelmet_Name);
		GameRegistry.registerItem(SnakeHelmet, Names.SnakeHelmet_Name);
		GameRegistry.registerItem(GolemHelmet, Names.GolemHelmet_Name);
		GameRegistry.registerItem(WaspHelmet, Names.WaspHelmet_Name);
		GameRegistry.registerItem(StalkerHelmet, Names.StalkerHelmet_Name);
		GameRegistry.registerItem(WolfHelmet, Names.WolfHelmet_Name);
		
		GameRegistry.registerItem(ShiniRobe, Names.ShinigamiChest_Name);
		GameRegistry.registerItem(ShiniPants, Names.ShinigamiPants_Name);
		GameRegistry.registerItem(Sandals, Names.Sandals_Name);
		
		GameRegistry.registerItem(QuincyRobe, Names.QuincyChest_Name);
		GameRegistry.registerItem(QuincyPants, Names.QuincyPants_Name);
		GameRegistry.registerItem(QuincyShoes, Names.QuincyShoes_Name);
		
		GameRegistry.registerItem(ArrancarJacket, Names.ArrancarTop_Name);
		GameRegistry.registerItem(ArrancarPants, Names.ArrancarPants_Name);
		GameRegistry.registerItem(ArrancarShoes, Names.ArrancarShoes_Name);
		
		GameRegistry.registerItem(MaleAcademyTop, Names.MaleAcademyTop_Name);
		GameRegistry.registerItem(MaleAcademyBottom, Names.MaleAcademyBottom_Name);
		GameRegistry.registerItem(FemaleAcademyTop, Names.FemaleAcademyTop_Name);
		GameRegistry.registerItem(FemaleAcademyBottom, Names.FemaleAcademyBottom_Name);
		GameRegistry.registerItem(MaleSchoolTop, Names.MaleSchoolTop_Name);
		GameRegistry.registerItem(MaleSchoolBottom, Names.MaleSchoolBottom_Name);
		GameRegistry.registerItem(FemaleSchoolTop, Names.FemaleSchoolTop_Name);
		GameRegistry.registerItem(FemaleSchoolBottom, Names.FemaleSchoolBottom_Name);
		
		GameRegistry.registerItem(SoulChain, "Soul Chain");
		
		
	}

	
}
