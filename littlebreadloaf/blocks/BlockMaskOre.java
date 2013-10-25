package littlebreadloaf.blocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import littlebreadloaf.items.Items;
import littlebreadloaf.libraries.BleachModInfo;
import littlebreadloaf.libraries.Names;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;

public class BlockMaskOre extends Block
{
	private Random rand = new Random();
	public BlockMaskOre(int id)
	{
		super(id, Material.rock);
		this.setCreativeTab(Items.tabBleach);
		this.setUnlocalizedName(Names.MaskOre_UnlocalizedName);
		this.setHardness(3F);
		this.setResistance(10F);
		this.setStepSound(Block.soundStoneFootstep);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon)
	{
		blockIcon = icon.registerIcon(BleachModInfo.ID.toLowerCase() + ":" + Names.MaskOre_UnlocalizedName);
	}
	
	
    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random par1Random)
    {
        return rand.nextInt(3);
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return Items.maskshard.itemID;
    }
}
