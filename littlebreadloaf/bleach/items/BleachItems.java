package littlebreadloaf.bleach.items;

import littlebreadloaf.bleach.BleachModInfo;
import littlebreadloaf.bleach.BleachIds;
import littlebreadloaf.bleach.Names;
import littlebreadloaf.bleach.api.Tools;
import littlebreadloaf.bleach.armor.Armor;
import littlebreadloaf.bleach.events.ExtendedPlayer;
import littlebreadloaf.bleach.items.shikai.ShikaiDark;
import littlebreadloaf.bleach.items.shikai.ShikaiEarth;
import littlebreadloaf.bleach.items.shikai.ShikaiFire;
import littlebreadloaf.bleach.items.shikai.ShikaiHeal;
import littlebreadloaf.bleach.items.shikai.ShikaiIce;
import littlebreadloaf.bleach.items.shikai.ShikaiLight;
import littlebreadloaf.bleach.items.shikai.ShikaiLightning;
import littlebreadloaf.bleach.items.shikai.ShikaiLunar;
import littlebreadloaf.bleach.items.shikai.ShikaiNormal;
import littlebreadloaf.bleach.items.shikai.ShikaiPoison;
import littlebreadloaf.bleach.items.shikai.ShikaiWater;
import littlebreadloaf.bleach.items.shikai.ShikaiWind;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BleachItems 
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
	public static Item factionSelect;
	
	public static Item recordAsterisk;
	public static Item recordNumberOne;
	public static Item recordEscalon;
	
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
		reiatsu = new ItemReiatsu(BleachIds.reiatsuID);
		quincybow = new ItemQuincyBow(BleachIds.quincyBowID);
		zanpakuto = new ItemZanpakuto(BleachIds.zanpakutoID, Tools.SOUL);
		maskshard = new ItemMaskShard(BleachIds.maskShardID);
		soulcloth = new ItemSoulCloth(BleachIds.soulClothID);
		oremask = new ItemOreMask(BleachIds.oreHelmetID);
		menosmask = new ItemMenosMask(BleachIds.menosHelmetID);
		fishermask = new ItemFisherMask(BleachIds.fisherHelmetID);
		seele = new ItemSeeleschneider(BleachIds.seeleschneiderID, Tools.SOUL);
		soulquartz = new ItemSoulQuartz(BleachIds.soulQuartzID);
		quincypendant = new ItemPendant(BleachIds.quincypendantID);
		quincyweb = new ItemQuincyWebBow(BleachIds.quincywebID);
		soulsteel = new ItemSoulSteel(BleachIds.soulsteelID);
		hollowbook = new ItemHollowBook(BleachIds.hollowBookID);
		factionSelect = new ItemFactionSelector(BleachIds.factionSelectID);
		
		recordAsterisk = new ItemBleachRecord(BleachIds.recordAsteriskID, BleachModInfo.ID.toLowerCase() + ":asterisk").setUnlocalizedName("record").setTextureName(BleachModInfo.ID.toLowerCase() + ":record_asterisk");
		recordNumberOne = new ItemBleachRecord(BleachIds.recordNumberOneID, BleachModInfo.ID.toLowerCase() + ":NumberOne").setUnlocalizedName("record").setTextureName(BleachModInfo.ID.toLowerCase() + ":record_NumberOne");
		recordEscalon = new ItemBleachRecord(BleachIds.recordEscalonID, BleachModInfo.ID.toLowerCase() + ":Escalon").setUnlocalizedName("record").setTextureName(BleachModInfo.ID.toLowerCase() + ":record_Escalon");

		LanguageRegistry.instance().addStringLocalization(BleachModInfo.ID.toLowerCase() + ":asterisk", "Bleach - Asterisk");
		LanguageRegistry.instance().addStringLocalization(BleachModInfo.ID.toLowerCase() + ":NumberOne", "Bleach - Number One");
		LanguageRegistry.instance().addStringLocalization(BleachModInfo.ID.toLowerCase() + ":Escalon", "Bleach - Escalon");
		
		shikaifire = new ShikaiFire(BleachIds.shikaifireID, Tools.SHIKAI);
		shikaiice = new ShikaiIce(BleachIds.shikaiiceID, Tools.SHIKAI);
		shikaiheal = new ShikaiHeal(BleachIds.shikaihealID, Tools.SHIKAI);
		shikaipoison = new ShikaiPoison(BleachIds.shikaipoisonID, Tools.SHIKAI);
		shikaiearth = new ShikaiEarth(BleachIds.shikaiearthID, Tools.SHIKAI);
		shikaiwind = new ShikaiWind(BleachIds.shikaiwindID, Tools.SHIKAI);
		shikailight = new ShikaiLight(BleachIds.shikailightID, Tools.SHIKAI);
		shikaidark = new ShikaiDark(BleachIds.shikaidarkID, Tools.SHIKAI);
		shikailightning = new ShikaiLightning(BleachIds.shikailightningID, Tools.SHIKAI);
		shikailunar = new ShikaiLunar(BleachIds.shikailunarID, Tools.SHIKAI);
		shikaiwater = new ShikaiWater(BleachIds.shikaiwaterID, Tools.SHIKAI);
		shikainormal = new ShikaiNormal(BleachIds.shikainormalID, Tools.SHIKAI);
		
		debugItem = new DebugItem(BleachIds.debugItemID).setUnlocalizedName("debug").setCreativeTab(tabBleach);
		

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
		LanguageRegistry.addName(factionSelect, Names.FactionSelect_Name);
		LanguageRegistry.addName(debugItem, "Debug Item");
		LanguageRegistry.instance().addStringLocalization(BleachModInfo.ID.toLowerCase() + ":asterisk", "Bleach - Asterisk");
		LanguageRegistry.instance().addStringLocalization(BleachModInfo.ID.toLowerCase() + ":NumberOne", "Bleach - Number One");
		LanguageRegistry.instance().addStringLocalization(BleachModInfo.ID.toLowerCase() + ":Escalon", "Bleach - Escalon");
		
		
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
