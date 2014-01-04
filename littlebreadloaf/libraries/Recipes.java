package littlebreadloaf.libraries;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import littlebreadloaf.armor.Armor;
import littlebreadloaf.blocks.Blocks;
import littlebreadloaf.items.Items;
import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes 
{
	public static void init()
	{
		//Reiatsu Block
		GameRegistry.addRecipe(new ItemStack(Blocks.reiatsuBlock, 1), new Object[]{
			"***",
			"***",
			"***",
			
			'*', Items.reiatsu
		});
		//Reiatsu 
				GameRegistry.addRecipe(new ItemStack(Items.reiatsu, 9), new Object[]{
					"*",
					
					'*', Blocks.reiatsuBlock
				});
		
		//Hollow Bait
				GameRegistry.addRecipe(new ItemStack(Blocks.hollowBait, 1), new Object[]{
					" * ",
					"*#*",
					" * ",
					
					'*', Blocks.reiatsuBlock, '#', Items.maskshard
				});
		//Reiatsu Block
		GameRegistry.addRecipe(new ItemStack(Blocks.paperwall, 8), new Object[]{
			"*#*",
			"###",
			"*#*",
			
			'*', Items.soulcloth, '#', Item.stick
		});
		//Soul Cloth
		GameRegistry.addRecipe(new ItemStack(Items.soulcloth, 1), new Object [] {
			"***",
			"*#*",
			"***",
			'*', Items.reiatsu, '#', Blocks.reiatsuBlock
		});
		
		//Zanpakuto
		GameRegistry.addRecipe(new ItemStack(Items.zanpakuto, 1), new Object[]{
			"*",
			"*",
			"#",
			
			'*', Blocks.reiatsuBlock, '#', Items.soulsteel
		});
		
		//Seeleschneider
		GameRegistry.addRecipe(new ItemStack(Items.seele, 1), new Object[]{
			"*",
			"#",
			"#",
			
			'*', Blocks.reiatsuBlock, '#', Items.soulsteel
		});
		
		//Hollow Masks
		GameRegistry.addRecipe(new ItemStack(Armor.HollowHelmet, 1), new Object[]{
			"***",
			"***",
			"***",
			
			'*', Items.maskshard
		});
		
		GameRegistry.addRecipe(new ItemStack(Items.maskshard, 1), new Object[]{"*", '*', Armor.BatHelmet});
		GameRegistry.addRecipe(new ItemStack(Items.maskshard, 1), new Object[]{"*", '*', Armor.SpiderHelmet});
		GameRegistry.addRecipe(new ItemStack(Items.maskshard, 1), new Object[]{"*", '*', Armor.BlazeHelmet});
		GameRegistry.addRecipe(new ItemStack(Items.maskshard, 1), new Object[]{"*", '*', Armor.SnakeHelmet});
		GameRegistry.addRecipe(new ItemStack(Items.maskshard, 1), new Object[]{"*", '*', Armor.GolemHelmet});
		GameRegistry.addRecipe(new ItemStack(Items.maskshard, 1), new Object[]{"*", '*', Armor.WaspHelmet});
		GameRegistry.addRecipe(new ItemStack(Items.maskshard, 1), new Object[]{"*", '*', Armor.StalkerHelmet});
		GameRegistry.addRecipe(new ItemStack(Items.maskshard, 2), new Object[]{"*", '*', Items.oremask});
		GameRegistry.addRecipe(new ItemStack(Items.maskshard, 1), new Object[]{"*", '*', Armor.WolfHelmet});
		GameRegistry.addRecipe(new ItemStack(Items.maskshard, 1), new Object[]{"*", '*', Items.fishermask});
		GameRegistry.addRecipe(new ItemStack(Items.maskshard, 3), new Object[]{"*", '*', Items.menosmask});
		
	
				
			//Soul Steel
			GameRegistry.addRecipe(new ItemStack(Items.soulsteel, 1), new Object[]{
				"***",
				"*#*",
				"***",
				
				'*', Items.reiatsu, '#', Item.ingotIron
			});
			//Quincy Cross
			GameRegistry.addRecipe(new ItemStack(Items.quincypendant, 1, 0), new Object[]{
				" * ",
				"*#*",
				" * ",
				
				'*', Items.soulsteel, '#', Blocks.reiatsuBlock
			});
			ItemStack quincyPendant = new ItemStack(Items.quincypendant,1,0);
			//Quincy Pentacle
			GameRegistry.addRecipe(new ItemStack(Items.quincypendant, 1, 1), new Object[]{
				"* *",
				" # ",
				"* *",
					
					'*', Items.soulsteel, '#', quincyPendant.getItem()
				});
			//Hollow Book
			GameRegistry.addRecipe(new ItemStack(Items.hollowbook, 1), new Object[]{
				" * ",
				"&#&",
				" * ",
					
					'*', Items.maskshard, '&', Items.soulcloth, '#', Item.book
				});
				//Shinigami Armor
				GameRegistry.addRecipe(new ItemStack(Armor.ShiniRobe, 1), new Object[]{
					"* *",
					"***",
					"***",
					
					'*', Items.soulcloth
				});
				GameRegistry.addRecipe(new ItemStack(Armor.ShiniPants, 1), new Object[]{
					"***",
					"* *",
					"* *",
					
					'*', Items.soulcloth
				});
				GameRegistry.addRecipe(new ItemStack(Armor.Sandals, 1), new Object[]{
					"* *",
					"* *",
					
					'*', Items.soulcloth
				});
				
				//Quincy Armor
				GameRegistry.addRecipe(new ItemStack(Armor.QuincyRobe, 1), new Object[]{
					"* *",
					"*#*",
					"*#*",
					
					'*', Items.soulcloth, '#', Block.blockLapis
				});
				GameRegistry.addRecipe(new ItemStack(Armor.QuincyPants, 1), new Object[]{
					"###",
					"* *",
					"* *",
					
					'*', Items.soulcloth, '#', Block.blockLapis
				});
				GameRegistry.addRecipe(new ItemStack(Armor.QuincyShoes, 1), new Object[]{
					"# #",
					"* *",
					
					'*', Items.soulcloth, '#', Block.blockLapis
				});
				
				
	}
	
	

}
