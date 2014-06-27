package littlebreadloaf.bleach.blocks;

import java.util.Random;

import littlebreadloaf.bleach.BleachModInfo;
import littlebreadloaf.bleach.items.BleachItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockPoisonShroom extends Block 
{

	protected BlockPoisonShroom() 
	{
		super(Material.plants);
		this.setBlockTextureName("poison_shroom");
		this.setBlockName("poison_shroom");
		this.setHardness(1.0F);
		this.setResistance(1.0F);
		
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister icon)
	{
		blockIcon = icon.registerIcon(BleachModInfo.ID.toLowerCase() + ":poison_shroom");
	}
	
	@Override
	 /**
     * Checks to see if its valid to put this block at the specified coordinates. Args: world, x, y, z
     */
    public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
    {
        return super.canPlaceBlockAt(par1World, par2, par3, par4) && canBlockStay(par1World, par2, par3, par4);
    }

	@Override
	 /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor blockID
     */
    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, Block block)
    {
        super.onNeighborBlockChange(par1World, par2, par3, par4, block);
        this.checkFlowerChange(par1World, par2, par3, par4);
    }



	
    protected final void checkFlowerChange(World par1World, int par2, int par3, int par4)
    {
        if (!this.canBlockStay(par1World, par2, par3, par4))
        {
            this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
            par1World.setBlock(par2, par3, par4, Blocks.air, 0, 2);
        }
    }
    @Override
    /**
     * Can this block stay at this position.  Similar to canPlaceBlockAt except gets checked often with plants.
     */
    public boolean canBlockStay(World par1World, int par2, int par3, int par4)
    {
        return par1World.getBlock(par2, par3-1, par4) == Blocks.grass ? true : par1World.getBlock(par2, par3-1, par4) == Blocks.dirt ? true : false; 
                
    }

	@Override
    /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        return null;
    }
	@Override
    /**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    public boolean isOpaqueCube()
    {
        return false;
    }
	@Override
    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    public boolean renderAsNormalBlock()
    {
        return false;
    }
	@Override
    /**
     * The type of render function that is called for this block
     */
    public int getRenderType()
    {
        return 1;
    }
	
	@Override
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
	{
		if(entity instanceof EntityLivingBase)
		{
			if(((EntityLivingBase) entity).getActivePotionEffect(Potion.poison) == null)
			{
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(Potion.poison.id, 200, 0));
				world.setBlockToAir(x, y, z);
			}
		}
	}
    int iceMeltTimer = 1200;
    

    @Override
    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
    	this.checkFlowerChange(par1World, par2, par3, par4);
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
        return 2;
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
