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

public class BlockReiatsuOre extends Block
{
	private Random rand = new Random();
	public BlockReiatsuOre(int id)
	{
		super(id, Material.rock);
		this.setCreativeTab(Items.tabBleach);
		this.setUnlocalizedName(Names.ReiatsuOre_UnlocalizedName);
		this.setHardness(4F);
		this.setResistance(10F);
		this.setStepSound(Block.soundStoneFootstep);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon)
	{
		blockIcon = icon.registerIcon(BleachModInfo.ID.toLowerCase() + ":" + Names.ReiatsuOre_UnlocalizedName);
	}
	
	
    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random par1Random)
    {
        return (5 + rand.nextInt(5));
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return Items.reiatsu.itemID;
    }
}
