package littlebreadloaf.bleach;

import java.io.File;

import net.minecraftforge.common.Configuration;

public class ConfigHandler 
{
	public static void init(File configFile)
	{
		Configuration config = new Configuration(configFile);
		
		config.load();
		
		BleachIds.reiatsuBlockID = config.get(config.CATEGORY_BLOCK, "Reiatsu Block ID", BleachIds.reiatsuBlockID_Default).getInt();
		
		BleachIds.hollowBaitID = config.get(config.CATEGORY_BLOCK, "Hollow Bait ID", BleachIds.hollowBaitID_Default).getInt();
		
		BleachIds.maskOreID = config.get(config.CATEGORY_BLOCK, "Mask Ore ID", BleachIds.maskOreID_Default).getInt();
		
		BleachIds.purpleGooID = config.get(config.CATEGORY_BLOCK, "Purple Goo ID", BleachIds.purpleGooID_Default).getInt();
		
		BleachIds.reiatsuOreID = config.get(config.CATEGORY_BLOCK, "Reiatsu Ore ID", BleachIds.reiatsuOreID_Default).getInt();
		
		BleachIds.sekkisekiID = config.get(config.CATEGORY_BLOCK, "Sekkiseki ID", BleachIds.sekkisekiID_Default).getInt();
		
		BleachIds.soulQuartzOreID = config.get(config.CATEGORY_BLOCK, "Soul Quartz Ore ID", BleachIds.soulQuartzOreID_Default).getInt();
		
		BleachIds.soulQuartzBlockID = config.get(config.CATEGORY_BLOCK, "Soul Quartz Block ID", BleachIds.soulQuartzBlockID_Default).getInt();
		
		BleachIds.soulQuartzLampID = config.get(config.CATEGORY_BLOCK, "Soul Quartz Lamp ID", BleachIds.soulQuartzLampID_Default).getInt();
		
		BleachIds.whitesandID = config.getTerrainBlock("World Gen Blocks", "White Sand ID", BleachIds.whitesandID_Default, "").getInt();
		
		BleachIds.paperwallID = config.get(config.CATEGORY_BLOCK, "Paper Wall ID", BleachIds.paperwallID_Default).getInt();
		
		BleachIds.paperdoorID = config.get(config.CATEGORY_BLOCK, "Paper Door ID", BleachIds.paperdoorID_Default).getInt();
		
		BleachIds.hollowdiamondID = config.get(config.CATEGORY_BLOCK, "Diamond Hollow Block ID", BleachIds.hollowdiamondID_Default).getInt();
		
		BleachIds.hollowemeraldID = config.get(config.CATEGORY_BLOCK, "Emerald Hollow Block  ID", BleachIds.hollowemeraldID_Default).getInt();

		BleachIds.hollowgoldID = config.get(config.CATEGORY_BLOCK, "Gold Hollow Block ID", BleachIds.hollowgoldID_Default).getInt();
		
		BleachIds.sphereLampID = config.get(config.CATEGORY_BLOCK, "Reiatsu Sphere Lamp ID", BleachIds.sphereLampID_Default).getInt();
		
		BleachIds.lanternID = config.get(config.CATEGORY_BLOCK, "Paper Lantern ID", BleachIds.lanternID_Default).getInt();
//		BleachIds.seeleschneiderID = config.get(config.CATEGORY_BLOCK, "Seele Schneider ID", BleachIds.seeleschneiderID_Default).getInt();
		
		
		
		
		
		
		BleachIds.reiatsuID = config.get(config.CATEGORY_ITEM, "Reiatsu ID", BleachIds.reiatsuID_Default).getInt();
		
		BleachIds.zanpakutoID = config.get(config.CATEGORY_ITEM, "Zanpakuto ID", BleachIds.zanpakutoID_Default).getInt();

		BleachIds.maskShardID = config.get(config.CATEGORY_ITEM, "Mask Shard ID", BleachIds.maskShardID_Default).getInt();
		
		BleachIds.soulClothID = config.get(config.CATEGORY_ITEM, "Soul Cloth ID", BleachIds.soulClothID_Default).getInt();
		
		BleachIds.soulQuartzID = config.get(config.CATEGORY_ITEM, "Soul Quartz ID", BleachIds.soulQuartzID_Default).getInt();

		BleachIds.soulsteelID = config.get(config.CATEGORY_ITEM, "Soul Steel ID", BleachIds.soulsteelID_Default).getInt();

		BleachIds.quincypendantID = config.get(config.CATEGORY_ITEM, "Quincy Pendant ID", BleachIds.quincypendantID_Default).getInt();

		BleachIds.seeleschneiderID = config.get(config.CATEGORY_ITEM, "Seeleschneider ID", BleachIds.seeleschneiderID_Default).getInt();
		
		BleachIds.hollowBookID = config.get(config.CATEGORY_ITEM, "Hollow Tome ID", BleachIds.hollowBookID_Default).getInt();
		
		
		
		

		BleachIds.batHelmetID = config.get(config.CATEGORY_ITEM, "Bat Mask ID", BleachIds.batHelmetID_Default).getInt();

		BleachIds.blazeHelmetID = config.get(config.CATEGORY_ITEM, "Blaze Mask ID", BleachIds.blazeHelmetID_Default).getInt();
		
		BleachIds.spiderHelmetID = config.get(config.CATEGORY_ITEM, "Spider Mask ID", BleachIds.spiderHelmetID_Default).getInt();

		BleachIds.golemHelmetID = config.get(config.CATEGORY_ITEM, "Golem Mask ID", BleachIds.golemHelmetID_Default).getInt();

		BleachIds.snakeHelmetID = config.get(config.CATEGORY_ITEM, "Snake Mask ID", BleachIds.snakeHelmetID_Default).getInt();
		
		BleachIds.waspHelmetID = config.get(config.CATEGORY_ITEM, "Wasp Mask ID", BleachIds.waspHelmetID_Default).getInt();
		
		BleachIds.stalkerHelmetID = config.get(config.CATEGORY_ITEM, "Stalker Mask ID", BleachIds.stalkerHelmetID_Default).getInt();
		
		BleachIds.oreHelmetID = config.get(config.CATEGORY_ITEM, "Ore Mask ID", BleachIds.oreHelmetID_Default).getInt();
		
		BleachIds.wolfHelmetID = config.get(config.CATEGORY_ITEM, "Wolf Mask ID", BleachIds.wolfHelmetID_Default).getInt();
		
		BleachIds.menosHelmetID = config.get(config.CATEGORY_ITEM, "Menos Mask ID", BleachIds.menosHelmetID_Default).getInt();
		
		BleachIds.fisherHelmetID = config.get(config.CATEGORY_ITEM, "Fisher Mask ID", BleachIds.fisherHelmetID_Default).getInt();

		BleachIds.hollowHelmetID = config.get(config.CATEGORY_ITEM, "Hollow Mask ID", BleachIds.hollowHelmetID_Default).getInt();
		
		
		
		
		
		
		
		BleachIds.shinirobeID = config.get(config.CATEGORY_ITEM, "Shinigami Chest ID", BleachIds.shinirobeID_Default).getInt();
		
		BleachIds.shinipantsID = config.get(config.CATEGORY_ITEM, "Shinigami Pants ID", BleachIds.shinipantsID_Default).getInt();
		
		BleachIds.sandalsID = config.get(config.CATEGORY_ITEM, "Shinigami Sandals ID", BleachIds.sandalsID_Default).getInt();
		
		BleachIds.quincyrobeID = config.get(config.CATEGORY_ITEM, "Quincy Robe ID", BleachIds.quincyrobeID_Default).getInt();
		
		BleachIds.quincypantsID = config.get(config.CATEGORY_ITEM, "Quincy Pants ID", BleachIds.quincypantsID_Default).getInt();
		
		BleachIds.quincyshoesID = config.get(config.CATEGORY_ITEM, "Quincy Shoes ID", BleachIds.quincyshoesID_Default).getInt();
		
		
		BleachIds.playerMask10ID = config.get(config.CATEGORY_ITEM, "Player Mask 1-1 ID", BleachIds.playerMask10ID_Default).getInt();
		BleachIds.playerMask11ID = config.get(config.CATEGORY_ITEM, "Player Mask 1-2 ID", BleachIds.playerMask11ID_Default).getInt();
		BleachIds.playerMask12ID = config.get(config.CATEGORY_ITEM, "Player Mask 1-3 ID", BleachIds.playerMask12ID_Default).getInt();
		BleachIds.playerMask20ID = config.get(config.CATEGORY_ITEM, "Player Mask 2-1 ID", BleachIds.playerMask20ID_Default).getInt();
		BleachIds.playerMask21ID = config.get(config.CATEGORY_ITEM, "Player Mask 2-2 ID", BleachIds.playerMask21ID_Default).getInt();
		BleachIds.playerMask22ID = config.get(config.CATEGORY_ITEM, "Player Mask 2-3 ID", BleachIds.playerMask22ID_Default).getInt();
		BleachIds.playerMask30ID = config.get(config.CATEGORY_ITEM, "Player Mask 3-1 ID", BleachIds.playerMask30ID_Default).getInt();
		BleachIds.playerMask31ID = config.get(config.CATEGORY_ITEM, "Player Mask 3-2 ID", BleachIds.playerMask31ID_Default).getInt();
		BleachIds.playerMask32ID = config.get(config.CATEGORY_ITEM, "Player Mask 3-3 ID", BleachIds.playerMask32ID_Default).getInt();
		BleachIds.playerMask40ID = config.get(config.CATEGORY_ITEM, "Player Mask 4-1 ID", BleachIds.playerMask40ID_Default).getInt();
		BleachIds.playerMask41ID = config.get(config.CATEGORY_ITEM, "Player Mask 4-2 ID", BleachIds.playerMask41ID_Default).getInt();
		BleachIds.playerMask42ID = config.get(config.CATEGORY_ITEM, "Player Mask 4-3 ID", BleachIds.playerMask42ID_Default).getInt();
		

		BleachIds.quincyBowID = config.get(config.CATEGORY_ITEM, "Quincy Bow ID", BleachIds.quincyBowID_Default).getInt();
		
		
		BleachIds.quincywebID = config.get(config.CATEGORY_ITEM, "Quincy Web Bow ID", BleachIds.quincywebID_Default).getInt();
		
		BleachIds.recordAsteriskID = config.get(config.CATEGORY_ITEM, "Asterisk ID", BleachIds.recordAsteriskID_Default).getInt();
		BleachIds.recordNumberOneID = config.get(config.CATEGORY_ITEM, "Number One ID", BleachIds.recordNumberOneID_Default).getInt();
		BleachIds.recordEscalonID = config.get(config.CATEGORY_ITEM, "Escalon ID", BleachIds.recordEscalonID_Default).getInt();
		
		
		
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
		BleachIds.worldHuecoMundoID = config.get("Dimensions", "HuecoMundo world ID", BleachIds.worldHuecoMundoID_Default).getInt();
		
		BleachIds.biomeHuecoMundoID = config.get("Biomes", "HuecoMundo biome ID", BleachIds.biomeHuecoMundoID_Default).getInt();

		BleachIds.debugItemID = config.get(config.CATEGORY_ITEM, "Debug item", BleachIds.debugItemID_Default).getInt();

		
		config.save();
		
		
	}

}
