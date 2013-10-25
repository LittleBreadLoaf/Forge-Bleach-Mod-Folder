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
			
			'*', Blocks.reiatsuBlock, '#', Item.ingotIron
		});
		
		//Seeleschneider
		GameRegistry.addRecipe(new ItemStack(Items.seele, 1), new Object[]{
			"*",
			"#",
			"#",
			
			'*', Blocks.reiatsuBlock, '#', Item.ingotIron
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
		GameRegistry.addRecipe(new ItemStack(Items.maskshard, 1), new Object[]{"*", '*', Items.fishermask});
		GameRegistry.addRecipe(new ItemStack(Items.maskshard, 3), new Object[]{"*", '*', Items.menosmask});
		
		//Quincy Bow
				GameRegistry.addRecipe(new ItemStack(Items.quincybow, 1), new Object[]{
					" *#",
					"* #",
					" *#",
					
					'*', Blocks.reiatsuBlock, '#', Items.reiatsu
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
