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
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BleachItems 
{
	public static Item reiatsu;
	public static Item shinai;
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
	public static Item heart;
	
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
		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem()
		{
			return Armor.HollowHelmet;
		}
		
	

		
	};
	
	public static void init()
	{
		shinai = new ItemShinai(Tools.SHINAI).setTextureName(BleachModInfo.ID.toLowerCase() + Names.Shinai_UnlocalizedName);
		reiatsu = new ItemReiatsu().setTextureName(BleachModInfo.ID.toLowerCase() + Names.Reiatsu_UnlocalizedName);;
		quincybow = new ItemQuincyBow().setTextureName(BleachModInfo.ID.toLowerCase() + Names.QuincyBow_UnlocalizedName);;
		zanpakuto = new ItemZanpakuto(Tools.SOUL).setTextureName(BleachModInfo.ID.toLowerCase() + Names.Zanpakuto_UnlocalizedName);;
		maskshard = new ItemMaskShard().setTextureName(BleachModInfo.ID.toLowerCase() + Names.MaskShard_UnlocalizedName);;
		soulcloth = new ItemSoulCloth().setTextureName(BleachModInfo.ID.toLowerCase() + Names.SoulCloth_UnlocalizedName);;
		oremask = new ItemOreMask().setTextureName(BleachModInfo.ID.toLowerCase() + Names.OreHelmet_UnlocalizedName);;
		menosmask = new ItemMenosMask().setTextureName(BleachModInfo.ID.toLowerCase() + Names.MenosHelmet_UnlocalizedName);;
		fishermask = new ItemFisherMask().setTextureName(BleachModInfo.ID.toLowerCase() + Names.FisherHelmet_UnlocalizedName);;
		seele = new ItemSeeleschneider(Tools.SOUL).setTextureName(BleachModInfo.ID.toLowerCase() + Names.SeeleSchneider_Name);;
		soulquartz = new ItemSoulQuartz().setTextureName(BleachModInfo.ID.toLowerCase() + Names.SoulQuartz_UnlocalizedName);;
		quincypendant = new ItemPendant().setTextureName(BleachModInfo.ID.toLowerCase() + Names.QuincyPendant_UnlocalizedName);;
		quincyweb = new ItemQuincyWebBow().setTextureName(BleachModInfo.ID.toLowerCase() + Names.QuincyWeb_UnlocalizedName);;
		soulsteel = new ItemSoulSteel().setTextureName(BleachModInfo.ID.toLowerCase() + Names.SoulSteel_UnlocalizedName);;
		hollowbook = new ItemHollowBook().setTextureName(BleachModInfo.ID.toLowerCase() + Names.HollowBook_UnlocalizedName);;
		factionSelect = new ItemFactionSelector().setTextureName(BleachModInfo.ID.toLowerCase() + Names.FactionSelect_UnlocalizedName);;
		heart = new ItemHeart().setTextureName(BleachModInfo.ID.toLowerCase() + Names.Heart_UnlocalizedName);;
		
		recordAsterisk = new ItemBleachRecord(BleachModInfo.ID.toLowerCase() + ":asterisk").setUnlocalizedName("asterisk").setTextureName(BleachModInfo.ID.toLowerCase() + ":record_asterisk");
		recordNumberOne = new ItemBleachRecord(BleachModInfo.ID.toLowerCase() + ":NumberOne").setUnlocalizedName("numberone").setTextureName(BleachModInfo.ID.toLowerCase() + ":record_NumberOne");
		recordEscalon = new ItemBleachRecord(BleachModInfo.ID.toLowerCase() + ":Escalon").setUnlocalizedName("escalon").setTextureName(BleachModInfo.ID.toLowerCase() + ":record_Escalon");

		
		shikaifire = new ShikaiFire(Tools.SHIKAI).setTextureName(BleachModInfo.ID.toLowerCase() + Names.ShikaiFire_UnlocalizedName);;
		shikaiice = new ShikaiIce( Tools.SHIKAI).setTextureName(BleachModInfo.ID.toLowerCase() + Names.ShikaiIce_UnlocalizedName);;
		shikaiheal = new ShikaiHeal(Tools.SHIKAI).setTextureName(BleachModInfo.ID.toLowerCase() + Names.ShikaiHeal_UnlocalizedName);;
		shikaipoison = new ShikaiPoison(Tools.SHIKAI).setTextureName(BleachModInfo.ID.toLowerCase() + Names.ShikaiPoison_UnlocalizedName);;
		shikaiearth = new ShikaiEarth(Tools.SHIKAI).setTextureName(BleachModInfo.ID.toLowerCase() + Names.ShikaiEarth_UnlocalizedName);;
		shikaiwind = new ShikaiWind(Tools.SHIKAI).setTextureName(BleachModInfo.ID.toLowerCase() + Names.ShikaiWind_UnlocalizedName);;
		shikailight = new ShikaiLight(Tools.SHIKAI).setTextureName(BleachModInfo.ID.toLowerCase() + Names.ShikaiLight_UnlocalizedName);;
		shikaidark = new ShikaiDark(Tools.SHIKAI).setTextureName(BleachModInfo.ID.toLowerCase() + Names.ShikaiDark_UnlocalizedName);;
		shikailightning = new ShikaiLightning(Tools.SHIKAI).setTextureName(BleachModInfo.ID.toLowerCase() + Names.ShikaiLightning_UnlocalizedName);;
		shikailunar = new ShikaiLunar(Tools.SHIKAI).setTextureName(BleachModInfo.ID.toLowerCase() + Names.ShikaiNormal_UnlocalizedName);;
		shikaiwater = new ShikaiWater(Tools.SHIKAI).setTextureName(BleachModInfo.ID.toLowerCase() + Names.ShikaiWater_UnlocalizedName);;
		shikainormal = new ShikaiNormal(Tools.SHIKAI).setTextureName(BleachModInfo.ID.toLowerCase() + Names.ShikaiNormal_UnlocalizedName);;
		
		debugItem = new DebugItem().setUnlocalizedName("debug").setCreativeTab(tabBleach).setTextureName(BleachModInfo.ID.toLowerCase() + "test_garganta");;
		

	}
	
	
	public static void registerItems()
	{
		GameRegistry.registerItem(shinai, Names.Shinai_Name);
		GameRegistry.registerItem(reiatsu, Names.Reiatsu_Name);
		GameRegistry.registerItem(quincybow, Names.QuincyBow_Name);
		GameRegistry.registerItem(zanpakuto, Names.Zanpakuto_Name);
		GameRegistry.registerItem(maskshard, Names.MaskShard_Name);
		GameRegistry.registerItem(soulcloth, Names.SoulCloth_Name);
		GameRegistry.registerItem(oremask, Names.OreHelmet_Name);
		GameRegistry.registerItem(menosmask, Names.MenosHelmet_Name);
		GameRegistry.registerItem(fishermask, Names.FisherHelmet_Name);
		GameRegistry.registerItem(seele, Names.SeeleSchneider_Name);
		GameRegistry.registerItem(soulquartz, Names.SoulQuartz_Name);
		GameRegistry.registerItem(quincypendant, Names.QuincyPendant);
		GameRegistry.registerItem(quincyweb, Names.QuincyWeb_Name);
		GameRegistry.registerItem(soulsteel, Names.SoulSteel_Name);
		GameRegistry.registerItem(hollowbook, Names.HollowBook_Name);
		GameRegistry.registerItem(factionSelect, Names.FactionSelect_Name);
		GameRegistry.registerItem(heart, Names.Heart_Name);

		GameRegistry.registerItem(recordAsterisk, "ASTERISK");
		GameRegistry.registerItem(recordNumberOne, "NUMBER ONE");
		GameRegistry.registerItem(recordEscalon, "ESCALON");

		GameRegistry.registerItem(shikaifire, "Fire Shikai");
		GameRegistry.registerItem(shikaiice, "Ice Shikai");
		GameRegistry.registerItem(shikaiheal, "Heal Shikai");
		GameRegistry.registerItem(shikaipoison, "Poison Shikai");
		GameRegistry.registerItem(shikaiearth, "Earth Shikai");
		GameRegistry.registerItem(shikaiwind, "Wind Shikai");
		GameRegistry.registerItem(shikailight, "Light Shikai");
		GameRegistry.registerItem(shikaidark, "Dark Shikai");
		GameRegistry.registerItem(shikailightning, "Lightning Shikai");
		GameRegistry.registerItem(shikailunar, "Lunar Shikai");
		GameRegistry.registerItem(shikaiwater, "Water Shikai");
		GameRegistry.registerItem(shikainormal, "Normal Shikai");
		GameRegistry.registerItem(debugItem, "Test Garganta");
	}
	
	

}
