package littlebreadloaf.bleach;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import littlebreadloaf.bleach.armor.Armor;
import littlebreadloaf.bleach.blocks.BleachBlocks;
import littlebreadloaf.bleach.items.BleachItems;
import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes 
{
	public static void init()
	{
		//Reiatsu Block
		GameRegistry.addRecipe(new ItemStack(BleachBlocks.reiatsuBlock, 1), new Object[]{
			"***",
			"***",
			"***",
			
			'*', BleachItems.reiatsu
		});
		//Reiatsu 
				GameRegistry.addRecipe(new ItemStack(BleachItems.reiatsu, 9), new Object[]{
					"*",
					
					'*', BleachBlocks.reiatsuBlock
				});
		
		//Hollow Bait
				GameRegistry.addRecipe(new ItemStack(BleachBlocks.hollowBait, 1), new Object[]{
					" * ",
					"*#*",
					" * ",
					
					'*', BleachBlocks.reiatsuBlock, '#', BleachItems.maskshard
				});
		//Reiatsu Block
		GameRegistry.addRecipe(new ItemStack(BleachBlocks.paperwall, 8), new Object[]{
			"*#*",
			"###",
			"*#*",
			
			'*', BleachItems.soulcloth, '#', Item.stick
		});
		//Soul Cloth
		GameRegistry.addRecipe(new ItemStack(BleachItems.soulcloth, 1), new Object [] {
			"***",
			"*#*",
			"***",
			'*', BleachItems.reiatsu, '#', BleachBlocks.reiatsuBlock
		});
		
		//Zanpakuto
		GameRegistry.addRecipe(new ItemStack(BleachItems.zanpakuto, 1), new Object[]{
			"*",
			"*",
			"#",
			
			'*', BleachBlocks.reiatsuBlock, '#', BleachItems.soulsteel
		});
		
		//Seeleschneider
		GameRegistry.addRecipe(new ItemStack(BleachItems.seele, 1), new Object[]{
			"*",
			"#",
			"#",
			
			'*', BleachBlocks.reiatsuBlock, '#', BleachItems.soulsteel
		});
		
		//Hollow Masks
		GameRegistry.addRecipe(new ItemStack(Armor.HollowHelmet, 1), new Object[]{
			"***",
			"***",
			"***",
			
			'*', BleachItems.maskshard
		});
		
		GameRegistry.addRecipe(new ItemStack(BleachItems.maskshard, 1), new Object[]{"*", '*', Armor.BatHelmet});
		GameRegistry.addRecipe(new ItemStack(BleachItems.maskshard, 1), new Object[]{"*", '*', Armor.SpiderHelmet});
		GameRegistry.addRecipe(new ItemStack(BleachItems.maskshard, 1), new Object[]{"*", '*', Armor.BlazeHelmet});
		GameRegistry.addRecipe(new ItemStack(BleachItems.maskshard, 1), new Object[]{"*", '*', Armor.SnakeHelmet});
		GameRegistry.addRecipe(new ItemStack(BleachItems.maskshard, 1), new Object[]{"*", '*', Armor.GolemHelmet});
		GameRegistry.addRecipe(new ItemStack(BleachItems.maskshard, 1), new Object[]{"*", '*', Armor.WaspHelmet});
		GameRegistry.addRecipe(new ItemStack(BleachItems.maskshard, 1), new Object[]{"*", '*', Armor.StalkerHelmet});
		GameRegistry.addRecipe(new ItemStack(BleachItems.maskshard, 2), new Object[]{"*", '*', BleachItems.oremask});
		GameRegistry.addRecipe(new ItemStack(BleachItems.maskshard, 1), new Object[]{"*", '*', Armor.WolfHelmet});
		GameRegistry.addRecipe(new ItemStack(BleachItems.maskshard, 1), new Object[]{"*", '*', BleachItems.fishermask});
		GameRegistry.addRecipe(new ItemStack(BleachItems.maskshard, 3), new Object[]{"*", '*', BleachItems.menosmask});
		
	
				
			//Soul Steel
			GameRegistry.addRecipe(new ItemStack(BleachItems.soulsteel, 1), new Object[]{
				"***",
				"*#*",
				"***",
				
				'*', BleachItems.reiatsu, '#', Item.ingotIron
			});
			//Quincy Cross
			GameRegistry.addRecipe(new ItemStack(BleachItems.quincypendant, 1, 0), new Object[]{
				" * ",
				"*#*",
				" * ",
				
				'*', BleachItems.soulsteel, '#', BleachBlocks.reiatsuBlock
			});
			ItemStack quincyPendant = new ItemStack(BleachItems.quincypendant,1,0);
			//Quincy Pentacle
			GameRegistry.addRecipe(new ItemStack(BleachItems.quincypendant, 1, 1), new Object[]{
				"* *",
				" # ",
				"* *",
					
					'*', BleachItems.soulsteel, '#', quincyPendant.getItem()
				});
			
			//Paper Lantern
			GameRegistry.addRecipe(new ItemStack(BleachBlocks.paperLamp, 4), new Object[]{
				"***",
				"&#&",
				"***",
					
					'&', BleachItems.soulcloth, '#', Block.torchWood, '*', Item.paper
				});
			
			//Hollow Book
			GameRegistry.addRecipe(new ItemStack(BleachItems.hollowbook, 1), new Object[]{
				" * ",
				"&#&",
				" * ",
					
					'*', BleachItems.maskshard, '&', BleachItems.soulcloth, '#', Item.book
				});
				//Shinigami Armor
				GameRegistry.addRecipe(new ItemStack(Armor.ShiniRobe, 1), new Object[]{
					"* *",
					"***",
					"***",
					
					'*', BleachItems.soulcloth
				});
				GameRegistry.addRecipe(new ItemStack(Armor.ShiniPants, 1), new Object[]{
					"***",
					"* *",
					"* *",
					
					'*', BleachItems.soulcloth
				});
				GameRegistry.addRecipe(new ItemStack(Armor.Sandals, 1), new Object[]{
					"* *",
					"* *",
					
					'*', BleachItems.soulcloth
				});
				
				//Quincy Armor
				GameRegistry.addRecipe(new ItemStack(Armor.QuincyRobe, 1), new Object[]{
					"* *",
					"*#*",
					"*#*",
					
					'*', BleachItems.soulcloth, '#', Block.blockLapis
				});
				GameRegistry.addRecipe(new ItemStack(Armor.QuincyPants, 1), new Object[]{
					"###",
					"* *",
					"* *",
					
					'*', BleachItems.soulcloth, '#', Block.blockLapis
				});
				GameRegistry.addRecipe(new ItemStack(Armor.QuincyShoes, 1), new Object[]{
					"# #",
					"* *",
					
					'*', BleachItems.soulcloth, '#', Block.blockLapis
				});
				
				
	}
	
	

}
