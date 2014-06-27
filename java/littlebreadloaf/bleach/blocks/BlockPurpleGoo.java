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

public class BlockPurpleGoo extends Block
{
	public BlockPurpleGoo()
	{
		super(Material.cake);
		this.setCreativeTab(BleachItems.tabBleach);
		this.setBlockName(Names.PurpleGoo_UnlocalizedName);
		this.setHardness(4F);
		this.setResistance(40F);
		this.setStepSound(Block.soundTypeStone);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister icon)
	{
		blockIcon = icon.registerIcon(BleachModInfo.ID.toLowerCase() + ":" + Names.PurpleGoo_UnlocalizedName);
	}
	
	
	@Override
	/**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random par1Random)
    {
        return 0;
    }
	
	@Override
    /**
     * Returns the ID of the items to drop on destruction.
     */
    public Item getItemDropped(int par1, Random par2Random, int par3)
    {
        return null;
    }
}

