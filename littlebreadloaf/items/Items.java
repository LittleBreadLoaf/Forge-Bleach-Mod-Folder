package littlebreadloaf.items;

import littlebreadloaf.armor.Armor;
import littlebreadloaf.events.ExtendedPlayer;
import littlebreadloaf.items.shikai.ShikaiDark;
import littlebreadloaf.items.shikai.ShikaiEarth;
import littlebreadloaf.items.shikai.ShikaiFire;
import littlebreadloaf.items.shikai.ShikaiHeal;
import littlebreadloaf.items.shikai.ShikaiIce;
import littlebreadloaf.items.shikai.ShikaiLight;
import littlebreadloaf.items.shikai.ShikaiLightning;
import littlebreadloaf.items.shikai.ShikaiLunar;
import littlebreadloaf.items.shikai.ShikaiNormal;
import littlebreadloaf.items.shikai.ShikaiPoison;
import littlebreadloaf.items.shikai.ShikaiWater;
import littlebreadloaf.items.shikai.ShikaiWind;
import littlebreadloaf.libraries.Ids;
import littlebreadloaf.libraries.Names;
import littlebreadloaf.libraries.Tools;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Items 
{
	public static Item reiatsu;
	public static Item zanpakuto;
	public static Item maskshard;
	public static Item quincybow;
	public static Item soulcloth;
	public static Item oremask;
	public static Item menosmask;
	public static Item fishermask;
	public static Item seele;
	public static Item soulquartz;
	public static Item quincypendant;
	public static Item quincyweb;
	public static Item soulsteel;
	public static Item hollowbook;
	
	public static Item shikaifire;
	public static Item shikaiice;
	public static Item shikaiheal;
	public static Item shikaipoison;
	public static Item shikaiearth;
	public static Item shikaiwind;
	public static Item shikailight;
	public static Item shikaidark;
	public static Item shikailightning;
	public static Item shikailunar;
	public static Item shikaiwater;
	public static Item shikainormal;

	public static Item debugItem;

	public static final CreativeTabs tabBleach = new CreativeTabs("Bleach Mod")
	{
		@SideOnly(Side.CLIENT)
		public int getTabIconItemIndex()
		{
			return Armor.HollowHelmet.itemID;
		}
		
		public String getTranslatedTabLabel()
		{
			return "Bleach Mod";
		}
	};
	
	public static void init()
	{
		reiatsu = new ItemReiatsu(Ids.reiatsuID);
		quincybow = new ItemQuincyBow(Ids.quincyBowID);
		zanpakuto = new ItemZanpakuto(Ids.zanpakutoID, Tools.SOUL);
		maskshard = new ItemMaskShard(Ids.maskShardID);
		soulcloth = new ItemSoulCloth(Ids.soulClothID);
		oremask = new ItemOreMask(Ids.oreHelmetID);
		menosmask = new ItemMenosMask(Ids.menosHelmetID);
		fishermask = new ItemFisherMask(Ids.fisherHelmetID);
		seele = new ItemSeeleschneider(Ids.seeleschneiderID, Tools.SOUL);
		soulquartz = new ItemSoulQuartz(Ids.soulQuartzID);
		quincypendant = new ItemPendant(Ids.quincypendantID);
		quincyweb = new ItemQuincyWebBow(Ids.quincywebID);
		soulsteel = new ItemSoulSteel(Ids.soulsteelID);
		hollowbook = new ItemHollowBook(Ids.hollowBookID);
		
		shikaifire = new ShikaiFire(Ids.shikaifireID, Tools.SHIKAI);
		shikaiice = new ShikaiIce(Ids.shikaiiceID, Tools.SHIKAI);
		shikaiheal = new ShikaiHeal(Ids.shikaihealID, Tools.SHIKAI);
		shikaipoison = new ShikaiPoison(Ids.shikaipoisonID, Tools.SHIKAI);
		shikaiearth = new ShikaiEarth(Ids.shikaiearthID, Tools.SHIKAI);
		shikaiwind = new ShikaiWind(Ids.shikaiwindID, Tools.SHIKAI);
		shikailight = new ShikaiLight(Ids.shikailightID, Tools.SHIKAI);
		shikaidark = new ShikaiDark(Ids.shikaidarkID, Tools.SHIKAI);
		shikailightning = new ShikaiLightning(Ids.shikailightningID, Tools.SHIKAI);
		shikailunar = new ShikaiLunar(Ids.shikailunarID, Tools.SHIKAI);
		shikaiwater = new ShikaiWater(Ids.shikaiwaterID, Tools.SHIKAI);
		shikainormal = new ShikaiNormal(Ids.shikainormalID, Tools.SHIKAI);
		
		debugItem = new DebugItem(Ids.debugItemID).setUnlocalizedName("debug").setCreativeTab(tabBleach);
		LanguageRegistry.addName(debugItem, "Debug Item");

	}
	
	public static void addNames()
	{
		LanguageRegistry.addName(reiatsu, Names.Reiatsu_Name);
		LanguageRegistry.addName(quincybow, Names.QuincyBow_Name);
		LanguageRegistry.addName(zanpakuto, Names.Zanpakuto_Name);
		LanguageRegistry.addName(maskshard, Names.MaskShard_Name);
		LanguageRegistry.addName(soulcloth, Names.SoulCloth_Name);
		LanguageRegistry.addName(oremask, Names.OreHelmet_Name);
		LanguageRegistry.addName(menosmask, Names.MenosHelmet_Name);
		LanguageRegistry.addName(fishermask, Names.FisherHelmet_Name);
		LanguageRegistry.addName(soulquartz, Names.SoulQuartz_Name);
		LanguageRegistry.addName(quincyweb, Names.QuincyWeb_Name);
		LanguageRegistry.addName(soulsteel, Names.SoulSteel_Name);
		LanguageRegistry.addName(hollowbook, Names.HollowBook_Name);
		for(int i = 0; i < Names.Seeleschneider_Name.length; i++)
		{
			LanguageRegistry.addName(new ItemStack(seele, 1, i), Names.Seeleschneider_Name[i]);
		}
		for(int i = 0; i < Names.QuincyPendant_Name.length; i++)
		{
			LanguageRegistry.addName(new ItemStack(quincypendant, 1, i), Names.QuincyPendant_Name[i]);
		}
		for(int i = 0; i < Names.ShikaiFire_Name.length; i++)
		{
			LanguageRegistry.addName(new ItemStack(shikaifire, 1, i), Names.ShikaiFire_Name[i]);
		}
		for(int i = 0; i < Names.ShikaiIce_Name.length; i++)
		{
			LanguageRegistry.addName(new ItemStack(shikaiice, 1, i), Names.ShikaiIce_Name[i]);
		}
		for(int i = 0; i < Names.ShikaiHeal_Name.length; i++)
		{
			LanguageRegistry.addName(new ItemStack(shikaiheal, 1, i), Names.ShikaiHeal_Name[i]);
		}
		for(int i = 0; i < Names.ShikaiPoison_Name.length; i++)
		{
			LanguageRegistry.addName(new ItemStack(shikaipoison, 1, i), Names.ShikaiPoison_Name[i]);
		}
		for(int i = 0; i < Names.ShikaiEarth_Name.length; i++)
		{
			LanguageRegistry.addName(new ItemStack(shikaiearth, 1, i), Names.ShikaiEarth_Name[i]);
		}
		for(int i = 0; i < Names.ShikaiWind_Name.length; i++)
		{
			LanguageRegistry.addName(new ItemStack(shikaiwind, 1, i), Names.ShikaiWind_Name[i]);
		}
		for(int i = 0; i < Names.ShikaiLight_Name.length; i++)
		{
			LanguageRegistry.addName(new ItemStack(shikailight, 1, i), Names.ShikaiLight_Name[i]);
		}
		for(int i = 0; i < Names.ShikaiDark_Name.length; i++)
		{
			LanguageRegistry.addName(new ItemStack(shikaidark, 1, i), Names.ShikaiDark_Name[i]);
		}
		for(int i = 0; i < Names.ShikaiLightning_Name.length; i++)
		{
			LanguageRegistry.addName(new ItemStack(shikailightning, 1, i), Names.ShikaiLightning_Name[i]);
		}
		for(int i = 0; i < Names.ShikaiLunar_Name.length; i++)
		{
			LanguageRegistry.addName(new ItemStack(shikailunar, 1, i), Names.ShikaiLunar_Name[i]);
		}
		for(int i = 0; i < Names.ShikaiWater_Name.length; i++)
		{
			LanguageRegistry.addName(new ItemStack(shikaiwater, 1, i), Names.ShikaiWater_Name[i]);
		}
		for(int i = 0; i < Names.ShikaiNormal_Name.length; i++)
		{
			LanguageRegistry.addName(new ItemStack(shikainormal, 1, i), Names.ShikaiNormal_Name[i]);
		}
	}

}
