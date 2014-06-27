package littlebreadloaf.bleach.blocks;

import java.util.Random;

import littlebreadloaf.bleach.items.BleachItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockShikaiIce extends BlockBreakable
{
    public BlockShikaiIce()
    {
        super("ice", Material.ice, false);
        this.slipperiness = 0.98F;
        this.setTickRandomly(true);
        this.setCreativeTab(BleachItems.tabBleach);
        this.setBlockName("icey");
    }

    @Override
    @SideOnly(Side.CLIENT)

    /**
     * Returns which pass should this block be rendered on. 0 for solids and 1 for alpha
     */
    public int getRenderBlockPass()
    {
        return 1;
    }

    @Override
    @SideOnly(Side.CLIENT)

    /**
     * Returns true if the given side of this block type should be rendered, if the adjacent block is at the given
     * coordinates.  Args: blockAccess, x, y, z, side
     */
    public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
    {
        return super.shouldSideBeRendered(par1IBlockAccess, par2, par3, par4, 1 - par5);
    }

    @Override
    /**
     * Called when the player destroys a block with an item that can harvest it. (i, j, k) are the coordinates of the
     * block and l is the block's subtype/damage.
     */
    public void harvestBlock(World par1World, EntityPlayer par2EntityPlayer, int par3, int par4, int par5, int par6)
    {
        par2EntityPlayer.addExhaustion(0.025F);

        if (this.canSilkHarvest() && EnchantmentHelper.getSilkTouchModifier(par2EntityPlayer))
        {
           
        }
        else
        {
            if (par1World.provider.isHellWorld)
            {
                par1World.setBlockToAir(par3, par4, par5);
                return;
            }

            Material material = par1World.getBlock(par3, par4 - 1, par5).getMaterial();

            if (material.blocksMovement() || material.isLiquid())
            {
                par1World.setBlock(par3, par4, par5, Blocks.water);
            }
        }
    }

    @Override
    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random par1Random)
    {
        return 0;
    }

    int iceMeltTimer = 10;
    

    @Override
    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
    	iceMeltTimer--;
        if(iceMeltTimer < 0)
        {
        	par1World.setBlock(par2, par3, par4, Blocks.water);
            par1World.scheduleBlockUpdate(par2, par3, par4, this, 10);
        }
        par1World.scheduleBlockUpdate(par2, par3, par4, this, 10);
    }

    /**
     * Returns the mobility information of the block, 0 = free, 1 = can't push but can move over, 2 = total immobility
     * and stop pistons
     */

    @Override
    public int getMobilityFlag()
    {
        return 0;
    }
    
    

	/**
	 * Called when the block is placed in the world.
	 */
	@Override
	public void onBlockPlacedBy(World world, int i, int j, int k, EntityLivingBase entity, ItemStack ItemStack)
	{
		world.scheduleBlockUpdate(i, j, k, this, 10);
	}
}
