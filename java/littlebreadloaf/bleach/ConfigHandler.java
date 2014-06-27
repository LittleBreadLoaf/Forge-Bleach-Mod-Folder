package littlebreadloaf.bleach;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class ConfigHandler 
{
	public static void init(File configFile)
	{
		Configuration config = new Configuration(configFile);
		
		config.load();
		
		BleachIds.reiatsuBlockID = config.get(config.CATEGORY_GENERAL, "Reiatsu Block ID", BleachIds.reiatsuBlockID_Default).getInt();
		
		BleachIds.hollowBaitID = config.get(config.CATEGORY_GENERAL, "Hollow Bait ID", BleachIds.hollowBaitID_Default).getInt();
		
		BleachIds.maskOreID = config.get(config.CATEGORY_GENERAL, "Mask Ore ID", BleachIds.maskOreID_Default).getInt();
		
		BleachIds.purpleGooID = config.get(config.CATEGORY_GENERAL, "Purple Goo ID", BleachIds.purpleGooID_Default).getInt();
		
		BleachIds.reiatsuOreID = config.get(config.CATEGORY_GENERAL, "Reiatsu Ore ID", BleachIds.reiatsuOreID_Default).getInt();
		
		BleachIds.sekkisekiID = config.get(config.CATEGORY_GENERAL, "Sekkiseki ID", BleachIds.sekkisekiID_Default).getInt();
		
		BleachIds.soulQuartzOreID = config.get(config.CATEGORY_GENERAL, "Soul Quartz Ore ID", BleachIds.soulQuartzOreID_Default).getInt();
		
		BleachIds.soulQuartzBlockID = config.get(config.CATEGORY_GENERAL, "Soul Quartz Block ID", BleachIds.soulQuartzBlockID_Default).getInt();
		
		BleachIds.soulQuartzLampID = config.get(config.CATEGORY_GENERAL, "Soul Quartz Lamp ID", BleachIds.soulQuartzLampID_Default).getInt();
		
		BleachIds.whitesandID = config.get("World Gen Blocks", "White Sand ID", BleachIds.whitesandID_Default, "").getInt();
		
		BleachIds.paperwallID = config.get(config.CATEGORY_GENERAL, "Paper Wall ID", BleachIds.paperwallID_Default).getInt();
		
		BleachIds.paperdoorID = config.get(config.CATEGORY_GENERAL, "Paper Door ID", BleachIds.paperdoorID_Default).getInt();
		
		BleachIds.hollowdiamondID = config.get(config.CATEGORY_GENERAL, "Diamond Hollow Block ID", BleachIds.hollowdiamondID_Default).getInt();
		
		BleachIds.hollowemeraldID = config.get(config.CATEGORY_GENERAL, "Emerald Hollow Block  ID", BleachIds.hollowemeraldID_Default).getInt();

		BleachIds.hollowgoldID = config.get(config.CATEGORY_GENERAL, "Gold Hollow Block ID", BleachIds.hollowgoldID_Default).getInt();
		
		BleachIds.sphereLampID = config.get(config.CATEGORY_GENERAL, "Reiatsu Sphere Lamp ID", BleachIds.sphereLampID_Default).getInt();
		
		BleachIds.lanternID = config.get(config.CATEGORY_GENERAL, "Paper Lantern ID", BleachIds.lanternID_Default).getInt();
		
		BleachIds.seeleschneiderBlockID = config.get(config.CATEGORY_GENERAL, "Seeleschneider Block ID", BleachIds.seeleschneiderBlockID_Default).getInt();
		
		BleachIds.ssportalID = config.get(config.CATEGORY_GENERAL, "Soul Society Portal Block ID", BleachIds.ssportalID_Default).getInt();
		
		BleachIds.shikaiIceBlockID = config.get(config.CATEGORY_GENERAL, "Temporary Ice Block ID", BleachIds.shikaiIceBlockID_Default).getInt();
		
		
		

		BleachIds.shinaiID = config.get("Bleach Mod Items", "Shinai ID", BleachIds.shinaiID_Default).getInt();
		
		BleachIds.zanpakutoID = config.get("Bleach Mod Items", "Zanpakuto ID", BleachIds.zanpakutoID_Default).getInt();

		BleachIds.maskShardID = config.get("Bleach Mod Items", "Mask Shard ID", BleachIds.maskShardID_Default).getInt();
		
		BleachIds.soulClothID = config.get("Bleach Mod Items", "Soul Cloth ID", BleachIds.soulClothID_Default).getInt();
		
		BleachIds.soulQuartzID = config.get("Bleach Mod Items", "Soul Quartz ID", BleachIds.soulQuartzID_Default).getInt();

		BleachIds.soulsteelID = config.get("Bleach Mod Items", "Soul Steel ID", BleachIds.soulsteelID_Default).getInt();

		BleachIds.quincypendantID = config.get("Bleach Mod Items", "Quincy Pendant ID", BleachIds.quincypendantID_Default).getInt();

		BleachIds.seeleschneiderID = config.get("Bleach Mod Items", "Seeleschneider ID", BleachIds.seeleschneiderID_Default).getInt();
		
		BleachIds.hollowBookID = config.get("Bleach Mod Items", "Hollow Tome ID", BleachIds.hollowBookID_Default).getInt();
		
		BleachIds.factionSelectID = config.get("Bleach Mod Items", "Faction Selector ID", BleachIds.factionSelectID_Default).getInt();

		BleachIds.reiatsuID = config.get("Bleach Mod Items", "Reiatsu ID", BleachIds.reiatsuID_Default).getInt();

		
		BleachIds.batHelmetID = config.get("Bleach Mod Items", "Bat Mask ID", BleachIds.batHelmetID_Default).getInt();

		BleachIds.blazeHelmetID = config.get("Bleach Mod Items", "Blaze Mask ID", BleachIds.blazeHelmetID_Default).getInt();
		
		BleachIds.spiderHelmetID = config.get("Bleach Mod Items", "Spider Mask ID", BleachIds.spiderHelmetID_Default).getInt();

		BleachIds.golemHelmetID = config.get("Bleach Mod Items", "Golem Mask ID", BleachIds.golemHelmetID_Default).getInt();

		BleachIds.snakeHelmetID = config.get("Bleach Mod Items", "Snake Mask ID", BleachIds.snakeHelmetID_Default).getInt();
		
		BleachIds.waspHelmetID = config.get("Bleach Mod Items", "Wasp Mask ID", BleachIds.waspHelmetID_Default).getInt();
		
		BleachIds.stalkerHelmetID = config.get("Bleach Mod Items", "Stalker Mask ID", BleachIds.stalkerHelmetID_Default).getInt();
		
		BleachIds.oreHelmetID = config.get("Bleach Mod Items", "Ore Mask ID", BleachIds.oreHelmetID_Default).getInt();
		
		BleachIds.wolfHelmetID = config.get("Bleach Mod Items", "Wolf Mask ID", BleachIds.wolfHelmetID_Default).getInt();
		
		BleachIds.menosHelmetID = config.get("Bleach Mod Items", "Menos Mask ID", BleachIds.menosHelmetID_Default).getInt();
		
		BleachIds.fisherHelmetID = config.get("Bleach Mod Items", "Fisher Mask ID", BleachIds.fisherHelmetID_Default).getInt();

		BleachIds.hollowHelmetID = config.get("Bleach Mod Items", "Hollow Mask ID", BleachIds.hollowHelmetID_Default).getInt();
		
		
		
		
		
		
		
		BleachIds.shinirobeID = config.get("Bleach Mod Items", "Shinigami Chest ID", BleachIds.shinirobeID_Default).getInt();
		
		BleachIds.shinipantsID = config.get("Bleach Mod Items", "Shinigami Pants ID", BleachIds.shinipantsID_Default).getInt();
		
		BleachIds.sandalsID = config.get("Bleach Mod Items", "Shinigami Sandals ID", BleachIds.sandalsID_Default).getInt();
		
		BleachIds.quincyrobeID = config.get("Bleach Mod Items", "Quincy Robe ID", BleachIds.quincyrobeID_Default).getInt();
		
		BleachIds.quincypantsID = config.get("Bleach Mod Items", "Quincy Pants ID", BleachIds.quincypantsID_Default).getInt();
		
		BleachIds.quincyshoesID = config.get("Bleach Mod Items", "Quincy Shoes ID", BleachIds.quincyshoesID_Default).getInt();
		
		BleachIds.arrancartopID = config.get("Bleach Mod Items", "Arrancar Jacket ID", BleachIds.arrancartopID_Default).getInt();
		
		BleachIds.arrancarpantsID = config.get("Bleach Mod Items", "Arrancar Pants ID", BleachIds.arrancarpantsID_Default).getInt();
		
		BleachIds.arrancarshoesID = config.get("Bleach Mod Items", "Arrancar Shoes ID", BleachIds.arrancarshoesID_Default).getInt();
		
		
		
		BleachIds.playerMask10ID = config.get("Bleach Mod Items", "Player Mask 1-1 ID", BleachIds.playerMask10ID_Default).getInt();
		BleachIds.playerMask11ID = config.get("Bleach Mod Items", "Player Mask 1-2 ID", BleachIds.playerMask11ID_Default).getInt();
		BleachIds.playerMask12ID = config.get("Bleach Mod Items", "Player Mask 1-3 ID", BleachIds.playerMask12ID_Default).getInt();
		BleachIds.playerMask20ID = config.get("Bleach Mod Items", "Player Mask 2-1 ID", BleachIds.playerMask20ID_Default).getInt();
		BleachIds.playerMask21ID = config.get("Bleach Mod Items", "Player Mask 2-2 ID", BleachIds.playerMask21ID_Default).getInt();
		BleachIds.playerMask22ID = config.get("Bleach Mod Items", "Player Mask 2-3 ID", BleachIds.playerMask22ID_Default).getInt();
		BleachIds.playerMask30ID = config.get("Bleach Mod Items", "Player Mask 3-1 ID", BleachIds.playerMask30ID_Default).getInt();
		BleachIds.playerMask31ID = config.get("Bleach Mod Items", "Player Mask 3-2 ID", BleachIds.playerMask31ID_Default).getInt();
		BleachIds.playerMask32ID = config.get("Bleach Mod Items", "Player Mask 3-3 ID", BleachIds.playerMask32ID_Default).getInt();
		BleachIds.playerMask40ID = config.get("Bleach Mod Items", "Player Mask 4-1 ID", BleachIds.playerMask40ID_Default).getInt();
		BleachIds.playerMask41ID = config.get("Bleach Mod Items", "Player Mask 4-2 ID", BleachIds.playerMask41ID_Default).getInt();
		BleachIds.playerMask42ID = config.get("Bleach Mod Items", "Player Mask 4-3 ID", BleachIds.playerMask42ID_Default).getInt();
		
		BleachIds.maleacademytopID = config.get("Bleach Mod Items", "Male Academy Top ID", BleachIds.maleacademytopID_Default).getInt();
		BleachIds.maleacademybottomID = config.get("Bleach Mod Items", "Male Academy Bottom ID", BleachIds.maleacademybottomID_Default).getInt();
		BleachIds.femaleacademytopID = config.get("Bleach Mod Items", "Female Academy Top ID", BleachIds.femaleacademytopID_Default).getInt();
		BleachIds.femaleacademybottomID = config.get("Bleach Mod Items", "Female Academy Bottom ID", BleachIds.femaleacademybottomID_Default).getInt();

		BleachIds.maleschooltopID = config.get("Bleach Mod Items", "Male School Top ID", BleachIds.maleschooltopID_Default).getInt();
		BleachIds.maleschoolbottomID = config.get("Bleach Mod Items", "Male School Bottom ID", BleachIds.maleschoolbottomID_Default).getInt();
		BleachIds.femaleschooltopID = config.get("Bleach Mod Items", "Female School Top ID", BleachIds.femaleschooltopID_Default).getInt();
		BleachIds.femaleschoolbottomID = config.get("Bleach Mod Items", "Female School Bottom ID", BleachIds.femaleschoolbottomID_Default).getInt();
		

		BleachIds.quincyBowID = config.get("Bleach Mod Items", "Quincy Bow ID", BleachIds.quincyBowID_Default).getInt();
		
		
		BleachIds.quincywebID = config.get("Bleach Mod Items", "Quincy Web Bow ID", BleachIds.quincywebID_Default).getInt();
		
		BleachIds.recordAsteriskID = config.get("Bleach Mod Items", "Asterisk ID", BleachIds.recordAsteriskID_Default).getInt();
		BleachIds.recordNumberOneID = config.get("Bleach Mod Items", "Number One ID", BleachIds.recordNumberOneID_Default).getInt();
		BleachIds.recordEscalonID = config.get("Bleach Mod Items", "Escalon ID", BleachIds.recordEscalonID_Default).getInt();
		
		
		
		BleachIds.shikaifireID = config.get("Shikai", "Fire Shikai ID", BleachIds.shikaifireID_Default).getInt();
		
		BleachIds.shikaiiceID = config.get("Shikai", "Ice Shikai ID", BleachIds.shikaiiceID_Default).getInt();
		
		BleachIds.shikaihealID = config.get("Shikai", "Heal Shikai ID", BleachIds.shikaihealID_Default).getInt();
		
		BleachIds.shikaipoisonID = config.get("Shikai", "Poison Shikai ID", BleachIds.shikaipoisonID_Default).getInt();
		
		BleachIds.shikaiearthID = config.get("Shikai", "Earth Shikai ID", BleachIds.shikaiearthID_Default).getInt();
		
		BleachIds.shikaiwindID = config.get("Shikai", "Wind Shikai ID", BleachIds.shikaiwindID_Default).getInt();
		
		BleachIds.shikailightID = config.get("Shikai", "Light Shikai ID", BleachIds.shikailightID_Default).getInt();
		
		BleachIds.shikaidarkID = config.get("Shikai", "Dark Shikai ID", BleachIds.shikaidarkID_Default).getInt();
		
		BleachIds.shikailightningID = config.get("Shikai", "Lightning Shikai ID", BleachIds.shikailightningID_Default).getInt();
		
		BleachIds.shikailunarID = config.get("Shikai", "Lunar Shikai ID", BleachIds.shikailunarID_Default).getInt();
		
		BleachIds.shikaiwaterID = config.get("Shikai", "Water Shikai ID", BleachIds.shikaiwaterID_Default).getInt();
		
		BleachIds.shikainormalID = config.get("Shikai", "Normal Shikai ID", BleachIds.shikainormalID_Default).getInt();
		
		
		
		//World
		BleachIds.worldHuecoMundoID = config.get("Dimensions", "Hueco Mundo World ID", BleachIds.worldHuecoMundoID_Default).getInt();
		
		BleachIds.biomeHuecoMundoID = config.get("Biomes", "Hueco Mundo Biome ID", BleachIds.biomeHuecoMundoID_Default).getInt();
		
		BleachIds.worldSoulSocietyID = config.get("Dimensions", "Soul Society World ID", BleachIds.worldSoulSocietyID_Default).getInt();
		
		BleachIds.biomeSoulSocietyForestID = config.get("Biomes", "Soul Society Forest Biome ID", BleachIds.biomeSoulSocietyForestID_Default).getInt();

		BleachIds.debugItemID = config.get("Bleach Mod Items", "Debug item", BleachIds.debugItemID_Default).getInt();

		
		config.save();
		
		
	}

}
