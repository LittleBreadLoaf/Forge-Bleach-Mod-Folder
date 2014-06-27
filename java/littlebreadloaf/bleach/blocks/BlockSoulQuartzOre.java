package littlebreadloaf.bleach.blocks;

import java.util.Random;

import littlebreadloaf.bleach.BleachModInfo;
import littlebreadloaf.bleach.Names;
import littlebreadloaf.bleach.items.BleachItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockSoulQuartzOre extends Block
{
	private Random rand = new Random();
	public BlockSoulQuartzOre()
	{
		super(Material.rock);
		this.setCreativeTab(BleachItems.tabBleach);
		this.setBlockName(Names.SoulQuartzOre_UnlocalizedName);
		this.setHardness(3F);
		this.setResistance(10F);
		this.setStepSound(Block.soundTypeStone);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister icon)
	{
		blockIcon = icon.registerIcon(BleachModInfo.ID.toLowerCase() + ":" + Names.SoulQuartzOre_UnlocalizedName);
	}
	
	@Override
    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random par1Random)
    {
        return (2 + rand.nextInt(3));
    }

	
	@Override
    /**
     * Returns the ID of the items to drop on destruction.
     */
    public Item getItemDropped(int par1, Random par2Random, int par3)
    {
        return BleachItems.soulquartz;
    }
}
