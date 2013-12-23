package littlebreadloaf.entities.classes;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import littlebreadloaf.entities.models.ModelDecoy;
import littlebreadloaf.entities.models.ModelFisher;
import littlebreadloaf.entities.models.ModelHollowBat;
import littlebreadloaf.entities.models.ModelHollowBlaze;
import littlebreadloaf.entities.models.ModelHollowGolem;
import littlebreadloaf.entities.models.ModelHollowSnake;
import littlebreadloaf.entities.models.ModelHollowSpider;
import littlebreadloaf.entities.models.ModelHollowStalker;
import littlebreadloaf.entities.models.ModelHollowWasp;
import littlebreadloaf.entities.models.ModelHollowOre;
import littlebreadloaf.entities.models.ModelHollowWolf;
import littlebreadloaf.entities.models.ModelMenosGrande;
import littlebreadloaf.entities.models.ModelWhole;
import littlebreadloaf.entities.renders.RenderDecoy;
import littlebreadloaf.entities.renders.RenderFisher;
import littlebreadloaf.entities.renders.RenderHollowBat;
import littlebreadloaf.entities.renders.RenderHollowBlaze;
import littlebreadloaf.entities.renders.RenderHollowGolem;
import littlebreadloaf.entities.renders.RenderHollowSnake;
import littlebreadloaf.entities.renders.RenderHollowSpider;
import littlebreadloaf.entities.renders.RenderHollowStalker;
import littlebreadloaf.entities.renders.RenderHollowWasp;
import littlebreadloaf.entities.renders.RenderHollowOre;
import littlebreadloaf.entities.renders.RenderHollowWolf;
import littlebreadloaf.entities.renders.RenderMenosGrande;
import littlebreadloaf.entities.renders.RenderShinigami;
import littlebreadloaf.entities.renders.RenderWhole;
import littlebreadloaf.libraries.BleachMod;
import littlebreadloaf.libraries.BleachModInfo;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Entities 

{
	
	public static void init()
	{
		//Whole
		EntityRegistry.registerGlobalEntityID(EntityWhole.class, "Whole", 1);
		EntityRegistry.addSpawn(EntityWhole.class, 1, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] {BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.plains, BiomeGenBase.beach, BiomeGenBase.desert, BiomeGenBase.desertHills, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.frozenRiver, BiomeGenBase.iceMountains, BiomeGenBase.jungle, BiomeGenBase.jungleHills, BiomeGenBase.swampland, BiomeGenBase.taiga, BiomeGenBase.taigaHills, BiomeGenBase.hell});
		EntityRegistry.findGlobalUniqueEntityId();
				
		//Hollow Bat
		EntityRegistry.registerGlobalEntityID(EntityHollowBat.class, "HollowBat", 2);
		EntityRegistry.addSpawn(EntityHollowBat.class, 1, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] {BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.plains, BiomeGenBase.beach, BiomeGenBase.desert, BiomeGenBase.desertHills, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.frozenRiver, BiomeGenBase.iceMountains, BiomeGenBase.jungle, BiomeGenBase.jungleHills, BiomeGenBase.swampland, BiomeGenBase.taiga, BiomeGenBase.taigaHills, BiomeGenBase.hell});
		EntityRegistry.findGlobalUniqueEntityId();
		
		
		//Hollow Blaze
		EntityRegistry.registerGlobalEntityID(EntityHollowBlaze.class, "HollowBlaze", 3);
		EntityRegistry.addSpawn(EntityHollowBlaze.class, 1, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] {BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.plains, BiomeGenBase.beach, BiomeGenBase.desert, BiomeGenBase.desertHills, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.frozenRiver, BiomeGenBase.iceMountains, BiomeGenBase.jungle, BiomeGenBase.jungleHills, BiomeGenBase.swampland, BiomeGenBase.taiga, BiomeGenBase.taigaHills, BiomeGenBase.hell});
		EntityRegistry.findGlobalUniqueEntityId();
		
		//Hollow Spider
		EntityRegistry.registerGlobalEntityID(EntityHollowSpider.class, "HollowSpider", 4);
		EntityRegistry.addSpawn(EntityHollowSpider.class, 1, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] {BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.plains, BiomeGenBase.beach, BiomeGenBase.desert, BiomeGenBase.desertHills, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.frozenRiver, BiomeGenBase.iceMountains, BiomeGenBase.jungle, BiomeGenBase.jungleHills, BiomeGenBase.swampland, BiomeGenBase.taiga, BiomeGenBase.taigaHills, BiomeGenBase.hell});
		EntityRegistry.findGlobalUniqueEntityId();
		
		//Hollow Golem
		EntityRegistry.registerGlobalEntityID(EntityHollowGolem.class, "HollowGolem", 5);
		EntityRegistry.addSpawn(EntityHollowGolem.class, 1, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] {BiomeGenBase.hell});
		EntityRegistry.findGlobalUniqueEntityId();
		
		//Hollow Snake
		EntityRegistry.registerGlobalEntityID(EntityHollowSnake.class, "HollowSnake", 6);
		EntityRegistry.addSpawn(EntityHollowSnake.class, 1, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] {BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.plains, BiomeGenBase.beach, BiomeGenBase.desert, BiomeGenBase.desertHills, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.frozenRiver, BiomeGenBase.iceMountains, BiomeGenBase.jungle, BiomeGenBase.jungleHills, BiomeGenBase.swampland, BiomeGenBase.taiga, BiomeGenBase.taigaHills, BiomeGenBase.hell});
		EntityRegistry.findGlobalUniqueEntityId();
					
		//Hollow Wasp
		EntityRegistry.registerGlobalEntityID(EntityHollowWasp.class, "HollowWasp", 7);
		EntityRegistry.addSpawn(EntityHollowWasp.class, 1, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] {BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.plains, BiomeGenBase.beach, BiomeGenBase.desert, BiomeGenBase.desertHills, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.frozenRiver, BiomeGenBase.iceMountains, BiomeGenBase.jungle, BiomeGenBase.jungleHills, BiomeGenBase.swampland, BiomeGenBase.taiga, BiomeGenBase.taigaHills, BiomeGenBase.hell});
		EntityRegistry.findGlobalUniqueEntityId();
		
		//Hollow Stalker
		EntityRegistry.registerGlobalEntityID(EntityHollowStalker.class, "HollowStalker", 8);
		EntityRegistry.addSpawn(EntityHollowStalker.class, 1, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] {BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.plains, BiomeGenBase.beach, BiomeGenBase.desert, BiomeGenBase.desertHills, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.frozenRiver, BiomeGenBase.iceMountains, BiomeGenBase.jungle, BiomeGenBase.jungleHills, BiomeGenBase.swampland, BiomeGenBase.taiga, BiomeGenBase.taigaHills, BiomeGenBase.hell});
		EntityRegistry.findGlobalUniqueEntityId();
		
		//Hollow Ore
		EntityRegistry.registerGlobalEntityID(EntityHollowOre.class, "HollowOre", 9);
		EntityRegistry.addSpawn(EntityHollowOre.class, 0, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] {BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.plains, BiomeGenBase.beach, BiomeGenBase.desert, BiomeGenBase.desertHills, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.frozenRiver, BiomeGenBase.iceMountains, BiomeGenBase.jungle, BiomeGenBase.jungleHills, BiomeGenBase.swampland, BiomeGenBase.taiga, BiomeGenBase.taigaHills, BiomeGenBase.hell});
		EntityRegistry.findGlobalUniqueEntityId();
				
		//Hollow Wolf
		EntityRegistry.registerGlobalEntityID(EntityHollowWolf.class, "HollowWolf", 10);
		EntityRegistry.addSpawn(EntityHollowWolf.class, 1, 2, 3, EnumCreatureType.monster, new BiomeGenBase[] {BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.plains, BiomeGenBase.beach, BiomeGenBase.desert, BiomeGenBase.desertHills, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.frozenRiver, BiomeGenBase.iceMountains, BiomeGenBase.jungle, BiomeGenBase.jungleHills, BiomeGenBase.swampland, BiomeGenBase.taiga, BiomeGenBase.taigaHills, BiomeGenBase.hell});
		EntityRegistry.findGlobalUniqueEntityId();
			
		//Menos Grande
		EntityRegistry.registerGlobalEntityID(EntityMenosGrande.class, "MenosGrande", 15);
		EntityRegistry.addSpawn(EntityMenosGrande.class, 1, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] {BiomeGenBase.hell});
		EntityRegistry.findGlobalUniqueEntityId();
		
		//Grand Fisher
		EntityRegistry.registerGlobalEntityID(EntityFisher.class, "Fisher", 16);
		EntityRegistry.addSpawn(EntityFisher.class, 1, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] {BiomeGenBase.hell});
		EntityRegistry.findGlobalUniqueEntityId();
		
		//Decoy
		EntityRegistry.registerGlobalEntityID(EntityDecoy.class, "Decoy", 17);
		EntityRegistry.addSpawn(EntityDecoy.class, 1, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] {BiomeGenBase.desert, BiomeGenBase.desertHills});
		EntityRegistry.findGlobalUniqueEntityId();
		
		
		
		//Shinigami
		EntityRegistry.registerGlobalEntityID(EntityShinigami.class, "Shinigami", 18);
		EntityRegistry.addSpawn(EntityShinigami.class, 1, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] {BiomeGenBase.desert, BiomeGenBase.desertHills});
		EntityRegistry.findGlobalUniqueEntityId();

				
		//Arrows
		EntityRegistry.registerGlobalEntityID(EntityEnergyArrow.class, "EnergyArrow", EntityRegistry.findGlobalUniqueEntityId());
		EntityRegistry.registerModEntity(EntityEnergyArrow.class, "EnergyArrow", 0, BleachMod.instance, 128, 1, true);
		
		EntityRegistry.registerGlobalEntityID(EntitySeeleArrow.class, "SeeleArrow", EntityRegistry.findGlobalUniqueEntityId());
		EntityRegistry.registerModEntity(EntitySeeleArrow.class, "SeeleArrow", 1, BleachMod.instance, 128, 1, true);
		
		EntityRegistry.registerGlobalEntityID(EntityGetsuga.class, "Getsuga", EntityRegistry.findGlobalUniqueEntityId());
		EntityRegistry.registerModEntity(EntityGetsuga.class, "Getsuga", 1, BleachMod.instance, 128, 1, true);
		
	}
	
	
	public static void addNames()
	{
		LanguageRegistry.instance().addStringLocalization("entity.Whole.name", "Whole");
		LanguageRegistry.instance().addStringLocalization("entity.HollowBat.name", "Bat Hollow");
		LanguageRegistry.instance().addStringLocalization("entity.HollowBlaze.name", "Blaze Hollow");
		LanguageRegistry.instance().addStringLocalization("entity.HollowSpider.name", "Spider Hollow");
		LanguageRegistry.instance().addStringLocalization("entity.HollowGolem.name", "Golem Hollow");
		LanguageRegistry.instance().addStringLocalization("entity.HollowSnake.name", "Snake Hollow");
		LanguageRegistry.instance().addStringLocalization("entity.HollowWasp.name", "Wasp Hollow");
		LanguageRegistry.instance().addStringLocalization("entity.HollowStalker.name", "Stalker Hollow");
		LanguageRegistry.instance().addStringLocalization("entity.HollowOre.name", "Ore Hollow");
		LanguageRegistry.instance().addStringLocalization("entity.HollowWolf.name", "Wolf Hollow");
		LanguageRegistry.instance().addStringLocalization("entity.MenosGrande.name", "Menos Grande");
		LanguageRegistry.instance().addStringLocalization("entity.Fisher.name", "Grand Fisher");
		LanguageRegistry.instance().addStringLocalization("entity.Decoy.name", "Decoy");
		LanguageRegistry.instance().addStringLocalization("entity.Shinigami.name", "Shinigami");
		
		LanguageRegistry.instance().addStringLocalization("entity.EnergyArrow.name", "Energy Arrow");
		LanguageRegistry.instance().addStringLocalization("entity.SeeleArrow.name", "Seeleschneider");
		LanguageRegistry.instance().addStringLocalization("entity.Getsuga.name", "Getsuga");
		
	}

}
