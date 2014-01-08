package littlebreadloaf.libraries;

import java.io.File;

import net.minecraftforge.common.Configuration;

public class ConfigHandler 
{
	public static void init(File configFile)
	{
		Configuration config = new Configuration(configFile);
		
		config.load();
		
		Ids.reiatsuBlockID = config.get(config.CATEGORY_BLOCK, "Reiatsu Block ID", Ids.reiatsuBlockID_Default).getInt();
		
		Ids.hollowBaitID = config.get(config.CATEGORY_BLOCK, "Hollow Bait ID", Ids.hollowBaitID_Default).getInt();
		
		Ids.maskOreID = config.get(config.CATEGORY_BLOCK, "Mask Ore ID", Ids.maskOreID_Default).getInt();
		
		Ids.purpleGooID = config.get(config.CATEGORY_BLOCK, "Purple Goo ID", Ids.purpleGooID_Default).getInt();
		
		Ids.reiatsuOreID = config.get(config.CATEGORY_BLOCK, "Reiatsu Ore ID", Ids.reiatsuOreID_Default).getInt();
		
		Ids.sekkisekiID = config.get(config.CATEGORY_BLOCK, "Sekkiseki ID", Ids.sekkisekiID_Default).getInt();
		
		Ids.soulQuartzOreID = config.get(config.CATEGORY_BLOCK, "Soul Quartz Ore ID", Ids.soulQuartzOreID_Default).getInt();
		
		Ids.soulQuartzBlockID = config.get(config.CATEGORY_BLOCK, "Soul Quartz Block ID", Ids.soulQuartzBlockID_Default).getInt();
		
		Ids.soulQuartzLampID = config.get(config.CATEGORY_BLOCK, "Soul Quartz Lamp ID", Ids.soulQuartzLampID_Default).getInt();
		
		Ids.whitesandID = config.getTerrainBlock("World Gen Blocks", "White Sand ID", Ids.whitesandID_Default, "").getInt();
		
		Ids.paperwallID = config.get(config.CATEGORY_BLOCK, "Paper Wall ID", Ids.paperwallID_Default).getInt();
		
		Ids.paperdoorID = config.get(config.CATEGORY_BLOCK, "Paper Door ID", Ids.paperdoorID_Default).getInt();
		
		Ids.hollowdiamondID = config.get(config.CATEGORY_BLOCK, "Diamond Hollow Block ID", Ids.hollowdiamondID_Default).getInt();
		
		Ids.hollowemeraldID = config.get(config.CATEGORY_BLOCK, "Emerald Hollow Block  ID", Ids.hollowemeraldID_Default).getInt();
		
		Ids.hollowgoldID = config.get(config.CATEGORY_BLOCK, "Gold Hollow Block ID", Ids.hollowgoldID_Default).getInt();
		
		
		
		
		
		
		Ids.reiatsuID = config.get(config.CATEGORY_ITEM, "Reiatsu ID", Ids.reiatsuID_Default).getInt();
		
		Ids.zanpakutoID = config.get(config.CATEGORY_ITEM, "Zanpakuto ID", Ids.zanpakutoID_Default).getInt();

		Ids.maskShardID = config.get(config.CATEGORY_ITEM, "Mask Shard ID", Ids.maskShardID_Default).getInt();
		
		Ids.soulClothID = config.get(config.CATEGORY_ITEM, "Soul Cloth ID", Ids.soulClothID_Default).getInt();
		
		Ids.soulQuartzID = config.get(config.CATEGORY_ITEM, "Soul Quartz ID", Ids.soulQuartzID_Default).getInt();

		Ids.soulsteelID = config.get(config.CATEGORY_ITEM, "Soul Steel ID", Ids.soulsteelID_Default).getInt();

		Ids.quincypendantID = config.get(config.CATEGORY_ITEM, "Quincy Pendant ID", Ids.quincypendantID_Default).getInt();

		Ids.seeleschneiderID = config.get(config.CATEGORY_ITEM, "Seeleschneider ID", Ids.seeleschneiderID_Default).getInt();
		
		Ids.hollowBookID = config.get(config.CATEGORY_ITEM, "Hollow Tome ID", Ids.hollowBookID_Default).getInt();
		
		
		
		

		Ids.batHelmetID = config.get(config.CATEGORY_ITEM, "Bat Mask ID", Ids.batHelmetID_Default).getInt();

		Ids.blazeHelmetID = config.get(config.CATEGORY_ITEM, "Blaze Mask ID", Ids.blazeHelmetID_Default).getInt();
		
		Ids.spiderHelmetID = config.get(config.CATEGORY_ITEM, "Spider Mask ID", Ids.spiderHelmetID_Default).getInt();

		Ids.golemHelmetID = config.get(config.CATEGORY_ITEM, "Golem Mask ID", Ids.golemHelmetID_Default).getInt();

		Ids.snakeHelmetID = config.get(config.CATEGORY_ITEM, "Snake Mask ID", Ids.snakeHelmetID_Default).getInt();
		
		Ids.waspHelmetID = config.get(config.CATEGORY_ITEM, "Wasp Mask ID", Ids.waspHelmetID_Default).getInt();
		
		Ids.stalkerHelmetID = config.get(config.CATEGORY_ITEM, "Stalker Mask ID", Ids.stalkerHelmetID_Default).getInt();
		
		Ids.oreHelmetID = config.get(config.CATEGORY_ITEM, "Ore Mask ID", Ids.oreHelmetID_Default).getInt();
		
		Ids.wolfHelmetID = config.get(config.CATEGORY_ITEM, "Wolf Mask ID", Ids.wolfHelmetID_Default).getInt();
		
		Ids.menosHelmetID = config.get(config.CATEGORY_ITEM, "Menos Mask ID", Ids.menosHelmetID_Default).getInt();
		
		Ids.fisherHelmetID = config.get(config.CATEGORY_ITEM, "Fisher Mask ID", Ids.fisherHelmetID_Default).getInt();

		Ids.hollowHelmetID = config.get(config.CATEGORY_ITEM, "Hollow Mask ID", Ids.hollowHelmetID_Default).getInt();
		
		
		
		
		
		
		
		Ids.shinirobeID = config.get(config.CATEGORY_ITEM, "Shinigami Chest ID", Ids.shinirobeID_Default).getInt();
		
		Ids.shinipantsID = config.get(config.CATEGORY_ITEM, "Shinigami Pants ID", Ids.shinipantsID_Default).getInt();
		
		Ids.sandalsID = config.get(config.CATEGORY_ITEM, "Shinigami Sandals ID", Ids.sandalsID_Default).getInt();
		
		Ids.quincyrobeID = config.get(config.CATEGORY_ITEM, "Quincy Robe ID", Ids.quincyrobeID_Default).getInt();
		
		Ids.quincypantsID = config.get(config.CATEGORY_ITEM, "Quincy Pants ID", Ids.quincypantsID_Default).getInt();
		
		Ids.quincyshoesID = config.get(config.CATEGORY_ITEM, "Quincy Shoes ID", Ids.quincyshoesID_Default).getInt();
		
		
		Ids.playerMask10ID = config.get(config.CATEGORY_ITEM, "Player Mask 1-1 ID", Ids.playerMask10ID_Default).getInt();
		Ids.playerMask11ID = config.get(config.CATEGORY_ITEM, "Player Mask 1-2 ID", Ids.playerMask11ID_Default).getInt();
		Ids.playerMask12ID = config.get(config.CATEGORY_ITEM, "Player Mask 1-3 ID", Ids.playerMask12ID_Default).getInt();
		Ids.playerMask20ID = config.get(config.CATEGORY_ITEM, "Player Mask 2-1 ID", Ids.playerMask20ID_Default).getInt();
		Ids.playerMask21ID = config.get(config.CATEGORY_ITEM, "Player Mask 2-2 ID", Ids.playerMask21ID_Default).getInt();
		Ids.playerMask22ID = config.get(config.CATEGORY_ITEM, "Player Mask 2-3 ID", Ids.playerMask22ID_Default).getInt();
		Ids.playerMask30ID = config.get(config.CATEGORY_ITEM, "Player Mask 3-1 ID", Ids.playerMask30ID_Default).getInt();
		Ids.playerMask31ID = config.get(config.CATEGORY_ITEM, "Player Mask 3-2 ID", Ids.playerMask31ID_Default).getInt();
		Ids.playerMask32ID = config.get(config.CATEGORY_ITEM, "Player Mask 3-3 ID", Ids.playerMask32ID_Default).getInt();
		Ids.playerMask40ID = config.get(config.CATEGORY_ITEM, "Player Mask 4-1 ID", Ids.playerMask40ID_Default).getInt();
		Ids.playerMask41ID = config.get(config.CATEGORY_ITEM, "Player Mask 4-2 ID", Ids.playerMask41ID_Default).getInt();
		Ids.playerMask42ID = config.get(config.CATEGORY_ITEM, "Player Mask 4-3 ID", Ids.playerMask42ID_Default).getInt();
		

		Ids.quincyBowID = config.get(config.CATEGORY_ITEM, "Quincy Bow ID", Ids.quincyBowID_Default).getInt();
		
		
		Ids.quincywebID = config.get(config.CATEGORY_ITEM, "Quincy Web Bow ID", Ids.quincywebID_Default).getInt();
		
		Ids.recordAsteriskID = config.get(config.CATEGORY_ITEM, "Asterisk ID", Ids.recordAsteriskID_Default).getInt();
		Ids.recordNumberOneID = config.get(config.CATEGORY_ITEM, "Number One ID", Ids.recordNumberOneID_Default).getInt();
		Ids.recordEscalonID = config.get(config.CATEGORY_ITEM, "Escalon ID", Ids.recordEscalonID_Default).getInt();
		
		
		
		Ids.shikaifireID = config.get("Shikai", "Fire Shikai ID", Ids.shikaifireID_Default).getInt();
		
		Ids.shikaiiceID = config.get("Shikai", "Ice Shikai ID", Ids.shikaiiceID_Default).getInt();
		
		Ids.shikaihealID = config.get("Shikai", "Heal Shikai ID", Ids.shikaihealID_Default).getInt();
		
		Ids.shikaipoisonID = config.get("Shikai", "Poison Shikai ID", Ids.shikaipoisonID_Default).getInt();
		
		Ids.shikaiearthID = config.get("Shikai", "Earth Shikai ID", Ids.shikaiearthID_Default).getInt();
		
		Ids.shikaiwindID = config.get("Shikai", "Wind Shikai ID", Ids.shikaiwindID_Default).getInt();
		
		Ids.shikailightID = config.get("Shikai", "Light Shikai ID", Ids.shikailightID_Default).getInt();
		
		Ids.shikaidarkID = config.get("Shikai", "Dark Shikai ID", Ids.shikaidarkID_Default).getInt();
		
		Ids.shikailightningID = config.get("Shikai", "Lightning Shikai ID", Ids.shikailightningID_Default).getInt();
		
		Ids.shikailunarID = config.get("Shikai", "Lunar Shikai ID", Ids.shikailunarID_Default).getInt();
		
		Ids.shikaiwaterID = config.get("Shikai", "Water Shikai ID", Ids.shikaiwaterID_Default).getInt();
		
		Ids.shikainormalID = config.get("Shikai", "Normal Shikai ID", Ids.shikainormalID_Default).getInt();
		
		
		
		
		Ids.customSpawnerID = config.get(config.CATEGORY_GENERAL, "Hollow Spawner ID", Ids.customSpawnerID_Default).getInt();
				
		//World
		Ids.worldHuecoMundoID = config.get("Dimensions", "HuecoMundo world ID", Ids.worldHuecoMundoID_Default).getInt();
		
		Ids.biomeHuecoMundoID = config.get("Biomes", "HuecoMundo biome ID", Ids.biomeHuecoMundoID_Default).getInt();

		Ids.debugItemID = config.get(config.CATEGORY_ITEM, "Debug item", Ids.debugItemID_Default).getInt();

		
		config.save();
		
		
	}

}
