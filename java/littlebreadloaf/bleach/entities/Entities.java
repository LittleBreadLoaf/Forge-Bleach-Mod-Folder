package littlebreadloaf.bleach.entities;

import littlebreadloaf.bleach.BleachMod;
import littlebreadloaf.bleach.world.biomes.BleachBiomes;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import cpw.mods.fml.common.registry.EntityRegistry;

public class Entities 

{
	
	public static void init()
	{
		//Whole
		EntityRegistry.registerGlobalEntityID(EntityWhole.class, "Whole", EntityRegistry.findGlobalUniqueEntityId(), 0x3366CC, 0x3300CC);
		EntityRegistry.addSpawn(EntityWhole.class, 8, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] {BiomeGenBase.beach, BiomeGenBase.birchForest, BiomeGenBase.birchForestHills, BiomeGenBase.coldBeach, BiomeGenBase.coldTaiga, BiomeGenBase.coldTaigaHills, BiomeGenBase.desert, BiomeGenBase.desertHills, BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.extremeHillsPlus, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.frozenOcean, BiomeGenBase.frozenRiver, BiomeGenBase.iceMountains, BiomeGenBase.icePlains, BiomeGenBase.jungle, BiomeGenBase.jungleEdge, BiomeGenBase.jungleHills, BiomeGenBase.megaTaiga, BiomeGenBase.megaTaigaHills, BiomeGenBase.mesa, BiomeGenBase.mesaPlateau, BiomeGenBase.mesaPlateau_F, BiomeGenBase.plains, BiomeGenBase.river, BiomeGenBase.roofedForest, BiomeGenBase.savanna, BiomeGenBase.savannaPlateau, BiomeGenBase.stoneBeach, BiomeGenBase.swampland, BiomeGenBase.taiga, BiomeGenBase.taigaHills});
				
		//Hollow Bat
		EntityRegistry.registerGlobalEntityID(EntityHollowBat.class, "HollowBat", EntityRegistry.findGlobalUniqueEntityId(), 0x000000, 0xB31215);
		EntityRegistry.addSpawn(EntityHollowBat.class, 6, 2, 4, EnumCreatureType.monster, new BiomeGenBase[] {BleachBiomes.HuecoMundo, BiomeGenBase.beach, BiomeGenBase.birchForest, BiomeGenBase.birchForestHills, BiomeGenBase.coldBeach, BiomeGenBase.coldTaiga, BiomeGenBase.coldTaigaHills, BiomeGenBase.desert, BiomeGenBase.desertHills, BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.extremeHillsPlus, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.frozenOcean, BiomeGenBase.frozenRiver, BiomeGenBase.iceMountains, BiomeGenBase.icePlains, BiomeGenBase.jungle, BiomeGenBase.jungleEdge, BiomeGenBase.jungleHills, BiomeGenBase.megaTaiga, BiomeGenBase.megaTaigaHills, BiomeGenBase.mesa, BiomeGenBase.mesaPlateau, BiomeGenBase.mesaPlateau_F, BiomeGenBase.plains, BiomeGenBase.river, BiomeGenBase.roofedForest, BiomeGenBase.savanna, BiomeGenBase.savannaPlateau, BiomeGenBase.stoneBeach, BiomeGenBase.swampland, BiomeGenBase.taiga, BiomeGenBase.taigaHills});
		
		
		//Hollow Blaze
		EntityRegistry.registerGlobalEntityID(EntityHollowBlaze.class, "HollowBlaze", EntityRegistry.findGlobalUniqueEntityId(), 0x000000, 0x3CB371);
		EntityRegistry.addSpawn(EntityHollowBlaze.class, 6, 2, 4, EnumCreatureType.monster, new BiomeGenBase[] {BleachBiomes.HuecoMundo, BiomeGenBase.beach, BiomeGenBase.birchForest, BiomeGenBase.birchForestHills, BiomeGenBase.coldBeach, BiomeGenBase.coldTaiga, BiomeGenBase.coldTaigaHills, BiomeGenBase.desert, BiomeGenBase.desertHills, BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.extremeHillsPlus, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.frozenOcean, BiomeGenBase.frozenRiver, BiomeGenBase.iceMountains, BiomeGenBase.icePlains, BiomeGenBase.jungle, BiomeGenBase.jungleEdge, BiomeGenBase.jungleHills, BiomeGenBase.megaTaiga, BiomeGenBase.megaTaigaHills, BiomeGenBase.mesa, BiomeGenBase.mesaPlateau, BiomeGenBase.mesaPlateau_F, BiomeGenBase.plains, BiomeGenBase.river, BiomeGenBase.roofedForest, BiomeGenBase.savanna, BiomeGenBase.savannaPlateau, BiomeGenBase.stoneBeach, BiomeGenBase.swampland, BiomeGenBase.taiga, BiomeGenBase.taigaHills});
		
		//Hollow Spider
		EntityRegistry.registerGlobalEntityID(EntityHollowSpider.class, "HollowSpider", EntityRegistry.findGlobalUniqueEntityId(), 0x000000, 0x191970);
		EntityRegistry.addSpawn(EntityHollowSpider.class, 6, 2, 4, EnumCreatureType.monster, new BiomeGenBase[] {BleachBiomes.HuecoMundo, BiomeGenBase.beach, BiomeGenBase.birchForest, BiomeGenBase.birchForestHills, BiomeGenBase.coldBeach, BiomeGenBase.coldTaiga, BiomeGenBase.coldTaigaHills, BiomeGenBase.desert, BiomeGenBase.desertHills, BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.extremeHillsPlus, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.frozenOcean, BiomeGenBase.frozenRiver, BiomeGenBase.iceMountains, BiomeGenBase.icePlains, BiomeGenBase.jungle, BiomeGenBase.jungleEdge, BiomeGenBase.jungleHills, BiomeGenBase.megaTaiga, BiomeGenBase.megaTaigaHills, BiomeGenBase.mesa, BiomeGenBase.mesaPlateau, BiomeGenBase.mesaPlateau_F, BiomeGenBase.plains, BiomeGenBase.river, BiomeGenBase.roofedForest, BiomeGenBase.savanna, BiomeGenBase.savannaPlateau, BiomeGenBase.stoneBeach, BiomeGenBase.swampland, BiomeGenBase.taiga, BiomeGenBase.taigaHills});
		
		//Hollow Golem
		EntityRegistry.registerGlobalEntityID(EntityHollowGolem.class, "HollowGolem", EntityRegistry.findGlobalUniqueEntityId(), 0x8B0000, 0xFFFFF0);
		EntityRegistry.addSpawn(EntityHollowGolem.class, 6, 2, 4, EnumCreatureType.monster, new BiomeGenBase[] {BleachBiomes.HuecoMundo, BiomeGenBase.beach, BiomeGenBase.birchForest, BiomeGenBase.birchForestHills, BiomeGenBase.coldBeach, BiomeGenBase.coldTaiga, BiomeGenBase.coldTaigaHills, BiomeGenBase.desert, BiomeGenBase.desertHills, BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.extremeHillsPlus, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.frozenOcean, BiomeGenBase.frozenRiver, BiomeGenBase.iceMountains, BiomeGenBase.icePlains, BiomeGenBase.jungle, BiomeGenBase.jungleEdge, BiomeGenBase.jungleHills, BiomeGenBase.megaTaiga, BiomeGenBase.megaTaigaHills, BiomeGenBase.mesa, BiomeGenBase.mesaPlateau, BiomeGenBase.mesaPlateau_F, BiomeGenBase.plains, BiomeGenBase.river, BiomeGenBase.roofedForest, BiomeGenBase.savanna, BiomeGenBase.savannaPlateau, BiomeGenBase.stoneBeach, BiomeGenBase.swampland, BiomeGenBase.taiga, BiomeGenBase.taigaHills});
		
		//Hollow Snake
		EntityRegistry.registerGlobalEntityID(EntityHollowSnake.class, "HollowSnake", EntityRegistry.findGlobalUniqueEntityId(), 0x009933, 0xF0E68C);
		EntityRegistry.addSpawn(EntityHollowSnake.class, 6, 2, 4, EnumCreatureType.monster, new BiomeGenBase[] {BleachBiomes.HuecoMundo, BiomeGenBase.beach, BiomeGenBase.birchForest, BiomeGenBase.birchForestHills, BiomeGenBase.coldBeach, BiomeGenBase.coldTaiga, BiomeGenBase.coldTaigaHills, BiomeGenBase.desert, BiomeGenBase.desertHills, BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.extremeHillsPlus, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.frozenOcean, BiomeGenBase.frozenRiver, BiomeGenBase.iceMountains, BiomeGenBase.icePlains, BiomeGenBase.jungle, BiomeGenBase.jungleEdge, BiomeGenBase.jungleHills, BiomeGenBase.megaTaiga, BiomeGenBase.megaTaigaHills, BiomeGenBase.mesa, BiomeGenBase.mesaPlateau, BiomeGenBase.mesaPlateau_F, BiomeGenBase.plains, BiomeGenBase.river, BiomeGenBase.roofedForest, BiomeGenBase.savanna, BiomeGenBase.savannaPlateau, BiomeGenBase.stoneBeach, BiomeGenBase.swampland, BiomeGenBase.taiga, BiomeGenBase.taigaHills});
					
		//Hollow Wasp
		EntityRegistry.registerGlobalEntityID(EntityHollowWasp.class, "HollowWasp", EntityRegistry.findGlobalUniqueEntityId(), 0x000000, 0xFFCC33);
		EntityRegistry.addSpawn(EntityHollowWasp.class, 6, 2, 4, EnumCreatureType.monster, new BiomeGenBase[] {BleachBiomes.HuecoMundo, BiomeGenBase.beach, BiomeGenBase.birchForest, BiomeGenBase.birchForestHills, BiomeGenBase.coldBeach, BiomeGenBase.coldTaiga, BiomeGenBase.coldTaigaHills, BiomeGenBase.desert, BiomeGenBase.desertHills, BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.extremeHillsPlus, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.frozenOcean, BiomeGenBase.frozenRiver, BiomeGenBase.iceMountains, BiomeGenBase.icePlains, BiomeGenBase.jungle, BiomeGenBase.jungleEdge, BiomeGenBase.jungleHills, BiomeGenBase.megaTaiga, BiomeGenBase.megaTaigaHills, BiomeGenBase.mesa, BiomeGenBase.mesaPlateau, BiomeGenBase.mesaPlateau_F, BiomeGenBase.plains, BiomeGenBase.river, BiomeGenBase.roofedForest, BiomeGenBase.savanna, BiomeGenBase.savannaPlateau, BiomeGenBase.stoneBeach, BiomeGenBase.swampland, BiomeGenBase.taiga, BiomeGenBase.taigaHills});
		
		//Hollow Stalker
		EntityRegistry.registerGlobalEntityID(EntityHollowStalker.class, "HollowStalker", EntityRegistry.findGlobalUniqueEntityId(), 0x000000, 0x634673);
		EntityRegistry.addSpawn(EntityHollowStalker.class, 6, 2, 4, EnumCreatureType.monster, new BiomeGenBase[] {BleachBiomes.HuecoMundo, BiomeGenBase.beach, BiomeGenBase.birchForest, BiomeGenBase.birchForestHills, BiomeGenBase.coldBeach, BiomeGenBase.coldTaiga, BiomeGenBase.coldTaigaHills, BiomeGenBase.desert, BiomeGenBase.desertHills, BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.extremeHillsPlus, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.frozenOcean, BiomeGenBase.frozenRiver, BiomeGenBase.iceMountains, BiomeGenBase.icePlains, BiomeGenBase.jungle, BiomeGenBase.jungleEdge, BiomeGenBase.jungleHills, BiomeGenBase.megaTaiga, BiomeGenBase.megaTaigaHills, BiomeGenBase.mesa, BiomeGenBase.mesaPlateau, BiomeGenBase.mesaPlateau_F, BiomeGenBase.plains, BiomeGenBase.river, BiomeGenBase.roofedForest, BiomeGenBase.savanna, BiomeGenBase.savannaPlateau, BiomeGenBase.stoneBeach, BiomeGenBase.swampland, BiomeGenBase.taiga, BiomeGenBase.taigaHills});
		
		//Hollow Ore
		EntityRegistry.registerGlobalEntityID(EntityHollowOre.class, "HollowOre", EntityRegistry.findGlobalUniqueEntityId(), 0x000000, 0x57599);
		EntityRegistry.addSpawn(EntityHollowOre.class, 0, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] {BleachBiomes.HuecoMundo, BiomeGenBase.beach, BiomeGenBase.birchForest, BiomeGenBase.birchForestHills, BiomeGenBase.coldBeach, BiomeGenBase.coldTaiga, BiomeGenBase.coldTaigaHills, BiomeGenBase.desert, BiomeGenBase.desertHills, BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.extremeHillsPlus, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.frozenOcean, BiomeGenBase.frozenRiver, BiomeGenBase.iceMountains, BiomeGenBase.icePlains, BiomeGenBase.jungle, BiomeGenBase.jungleEdge, BiomeGenBase.jungleHills, BiomeGenBase.megaTaiga, BiomeGenBase.megaTaigaHills, BiomeGenBase.mesa, BiomeGenBase.mesaPlateau, BiomeGenBase.mesaPlateau_F, BiomeGenBase.plains, BiomeGenBase.river, BiomeGenBase.roofedForest, BiomeGenBase.savanna, BiomeGenBase.savannaPlateau, BiomeGenBase.stoneBeach, BiomeGenBase.swampland, BiomeGenBase.taiga, BiomeGenBase.taigaHills});
				
		//Hollow Wolf
		EntityRegistry.registerGlobalEntityID(EntityHollowWolf.class, "HollowWolf", EntityRegistry.findGlobalUniqueEntityId(), 0x191970, 0x634673);
		EntityRegistry.addSpawn(EntityHollowWolf.class, 6, 3, 5, EnumCreatureType.monster, new BiomeGenBase[] {BleachBiomes.HuecoMundo, BiomeGenBase.beach, BiomeGenBase.birchForest, BiomeGenBase.birchForestHills, BiomeGenBase.coldBeach, BiomeGenBase.coldTaiga, BiomeGenBase.coldTaigaHills, BiomeGenBase.desert, BiomeGenBase.desertHills, BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.extremeHillsPlus, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.frozenOcean, BiomeGenBase.frozenRiver, BiomeGenBase.iceMountains, BiomeGenBase.icePlains, BiomeGenBase.jungle, BiomeGenBase.jungleEdge, BiomeGenBase.jungleHills, BiomeGenBase.megaTaiga, BiomeGenBase.megaTaigaHills, BiomeGenBase.mesa, BiomeGenBase.mesaPlateau, BiomeGenBase.mesaPlateau_F, BiomeGenBase.plains, BiomeGenBase.river, BiomeGenBase.roofedForest, BiomeGenBase.savanna, BiomeGenBase.savannaPlateau, BiomeGenBase.stoneBeach, BiomeGenBase.swampland, BiomeGenBase.taiga, BiomeGenBase.taigaHills});
		
		
		//Small Hollow Lizard
		EntityRegistry.registerGlobalEntityID(EntitySmallHollowLizard.class, "SmallHollowLizard", EntityRegistry.findGlobalUniqueEntityId(), 0x8B4513, 0xB22222);
		EntityRegistry.addSpawn(EntitySmallHollowLizard.class, 10, 1, 1, EnumCreatureType.creature, BleachBiomes.HuecoMundo);
		
		
		//Menos Grande
		EntityRegistry.registerGlobalEntityID(EntityMenosGrande.class, "MenosGrande", EntityRegistry.findGlobalUniqueEntityId(), 0x000000, 0xFFFFFF);
		EntityRegistry.addSpawn(EntityMenosGrande.class, 15, 1, 1, EnumCreatureType.monster, new BiomeGenBase[]{BiomeGenBase.hell});
		
		//Grand Fisher
		EntityRegistry.registerGlobalEntityID(EntityFisher.class, "Fisher", EntityRegistry.findGlobalUniqueEntityId(), 0x000000, 0x663300);
		EntityRegistry.addSpawn(EntityFisher.class, 8, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] {BiomeGenBase.hell});
		
		//Decoy
		EntityRegistry.registerGlobalEntityID(EntityDecoy.class, "Decoy", EntityRegistry.findGlobalUniqueEntityId(), 0x000000, 0x000000);
		EntityRegistry.addSpawn(EntityDecoy.class, 8, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] {BleachBiomes.HuecoMundo, BiomeGenBase.beach, BiomeGenBase.birchForest, BiomeGenBase.birchForestHills, BiomeGenBase.coldBeach, BiomeGenBase.coldTaiga, BiomeGenBase.coldTaigaHills, BiomeGenBase.desert, BiomeGenBase.desertHills, BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.extremeHillsPlus, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.frozenOcean, BiomeGenBase.frozenRiver, BiomeGenBase.iceMountains, BiomeGenBase.icePlains, BiomeGenBase.jungle, BiomeGenBase.jungleEdge, BiomeGenBase.jungleHills, BiomeGenBase.megaTaiga, BiomeGenBase.megaTaigaHills, BiomeGenBase.mesa, BiomeGenBase.mesaPlateau, BiomeGenBase.mesaPlateau_F, BiomeGenBase.plains, BiomeGenBase.river, BiomeGenBase.roofedForest, BiomeGenBase.savanna, BiomeGenBase.savannaPlateau, BiomeGenBase.stoneBeach, BiomeGenBase.swampland, BiomeGenBase.taiga, BiomeGenBase.taigaHills});
		
		
		
		//Shinigami
		EntityRegistry.registerGlobalEntityID(EntityShinigami.class, "Shinigami", EntityRegistry.findGlobalUniqueEntityId(), 0x000000, 0x677279);
		EntityRegistry.addSpawn(EntityShinigami.class, 8, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] {BleachBiomes.HuecoMundo, BiomeGenBase.beach, BiomeGenBase.birchForest, BiomeGenBase.birchForestHills, BiomeGenBase.coldBeach, BiomeGenBase.coldTaiga, BiomeGenBase.coldTaigaHills, BiomeGenBase.desert, BiomeGenBase.desertHills, BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.extremeHillsPlus, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.frozenOcean, BiomeGenBase.frozenRiver, BiomeGenBase.iceMountains, BiomeGenBase.icePlains, BiomeGenBase.jungle, BiomeGenBase.jungleEdge, BiomeGenBase.jungleHills, BiomeGenBase.megaTaiga, BiomeGenBase.megaTaigaHills, BiomeGenBase.mesa, BiomeGenBase.mesaPlateau, BiomeGenBase.mesaPlateau_F, BiomeGenBase.plains, BiomeGenBase.river, BiomeGenBase.roofedForest, BiomeGenBase.savanna, BiomeGenBase.savannaPlateau, BiomeGenBase.stoneBeach, BiomeGenBase.swampland, BiomeGenBase.taiga, BiomeGenBase.taigaHills});
		
		
		//Ashido
		//EntityRegistry.registerGlobalEntityID(EntityAshido.class, "Ashido", EntityRegistry.findGlobalUniqueEntityId(), 0x8B4513, 0x000000);
		//EntityRegistry.addSpawn(EntityAshido.class, 0, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] {BiomeGenBase.desert});

				
		//Arrows
		EntityRegistry.registerGlobalEntityID(EntityEnergyArrow.class, "EnergyArrow", EntityRegistry.findGlobalUniqueEntityId());
		EntityRegistry.registerModEntity(EntityEnergyArrow.class, "EnergyArrow", 0, BleachMod.instance, 128, 1, true);
		
		EntityRegistry.registerGlobalEntityID(EntitySeeleArrow.class, "SeeleArrow", EntityRegistry.findGlobalUniqueEntityId());
		EntityRegistry.registerModEntity(EntitySeeleArrow.class, "SeeleArrow", 1, BleachMod.instance, 128, 1, true);
		
		EntityRegistry.registerGlobalEntityID(EntityGetsuga.class, "Getsuga", EntityRegistry.findGlobalUniqueEntityId());
		EntityRegistry.registerModEntity(EntityGetsuga.class, "Getsuga", 2, BleachMod.instance, 128, 1, true);
	
		EntityRegistry.registerGlobalEntityID(EntityShotBlock.class, "EntityShotBlock", EntityRegistry.findGlobalUniqueEntityId());
		EntityRegistry.registerModEntity(EntityShotBlock.class, "EntityShotBlock", 3, BleachMod.instance, 128, 1, true);

		EntityRegistry.registerGlobalEntityID(EntityBlock.class, "EntityBlock", EntityRegistry.findGlobalUniqueEntityId());
		EntityRegistry.registerModEntity(EntityBlock.class, "EntityBlock", 4, BleachMod.instance, 128, 1, true);
		
		EntityRegistry.registerGlobalEntityID(EntityCero.class, "EntityCero", EntityRegistry.findGlobalUniqueEntityId());
		EntityRegistry.registerModEntity(EntityCero.class, "EntityCero", 5, BleachMod.instance, 128, 1, true);
		
	}
	
	


}
