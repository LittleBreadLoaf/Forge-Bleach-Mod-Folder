package littlebreadloaf.bleach.blocks;

import java.util.List;
import java.util.Random;

import littlebreadloaf.bleach.BleachModInfo;
import littlebreadloaf.bleach.items.BleachItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockPaperWall extends BlockPane
{
    /**
     * Holds the texture index of the side of the pane (the thin lateral side)
     */
    private final String sideTextureIndex;

    /**
     * If this field is true, the pane block drops itself when destroyed (like the iron fences), otherwise, it's just
     * destroyed (like glass panes)
     */
    private final boolean canDropItself;
    private final String field_94402_c;
    @SideOnly(Side.CLIENT)
    private IIcon theIcon;

    protected BlockPaperWall(String par2Str, String par3Str, Material par4Material, boolean par5)
    {
        super(par3Str, par3Str, par4Material, par5);
        this.sideTextureIndex = BleachModInfo.ID.toLowerCase() + ":" + par3Str;
        this.canDropItself = par5;
        this.field_94402_c = BleachModInfo.ID.toLowerCase() + ":" + par2Str;
        this.setCreativeTab(BleachItems.tabBleach);
    }


    @Override
    /**
     * Returns the ID of the items to drop on destruction.
     */
    public Item getItemDropped(int par1, Random par2Random, int par3)
    {
        return !this.canDropItself ? null : super.getItemDropped(par1, par2Random, par3);
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
        return 41;
    }

    @Override
    @SideOnly(Side.CLIENT)

    /**
     * Returns true if the given side of this block type should be rendered, if the adjacent block is at the given
     * coordinates.  Args: blockAccess, x, y, z, side
     */
    public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
    {
        Block i1 = par1IBlockAccess.getBlock(par2, par3, par4);
        return i1 == this ? false : super.shouldSideBeRendered(par1IBlockAccess, par2, par3, par4, par5);
    }

    @Override
    /**
     * Adds all intersecting collision boxes to a list. (Be sure to only add boxes to the list if they intersect the
     * mask.) Parameters: World, X, Y, Z, mask, list, colliding entity
     */
    public void addCollisionBoxesToList(World par1World, int par2, int par3, int par4, AxisAlignedBB par5AxisAlignedBB, List par6List, Entity par7Entity)
    {
        boolean flag = this.canPaneConnectTo(par1World,par2, par3, par4,ForgeDirection.NORTH);
        boolean flag1 = this.canPaneConnectTo(par1World,par2, par3, par4,ForgeDirection.SOUTH);
        boolean flag2 = this.canPaneConnectTo(par1World,par2, par3, par4,ForgeDirection.WEST);
        boolean flag3 = this.canPaneConnectTo(par1World,par2, par3, par4,ForgeDirection.EAST);

        if ((!flag2 || !flag3) && (flag2 || flag3 || flag || flag1))
        {
            if (flag2 && !flag3)
            {
                this.setBlockBounds(0.0F, 0.0F, 0.4375F, 0.5F, 1.0F, 0.5625F);
                super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
            }
            else if (!flag2 && flag3)
            {
                this.setBlockBounds(0.5F, 0.0F, 0.4375F, 1.0F, 1.0F, 0.5625F);
                super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
            }
        }
        else
        {
            this.setBlockBounds(0.0F, 0.0F, 0.4375F, 1.0F, 1.0F, 0.5625F);
            super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
        }

        if ((!flag || !flag1) && (flag2 || flag3 || flag || flag1))
        {
            if (flag && !flag1)
            {
                this.setBlockBounds(0.4375F, 0.0F, 0.0F, 0.5625F, 1.0F, 0.5F);
                super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
            }
            else if (!flag && flag1)
            {
                this.setBlockBounds(0.4375F, 0.0F, 0.5F, 0.5625F, 1.0F, 1.0F);
                super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
            }
        }
        else
        {
            this.setBlockBounds(0.4375F, 0.0F, 0.0F, 0.5625F, 1.0F, 1.0F);
            super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
        }
    }

    @Override
    /**
     * Sets the block's bounds for rendering it as an item
     */
    public void setBlockBoundsForItemRender()
    {
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }

    @Override
    /**
     * Updates the blocks bounds based on its current state. Args: world, x, y, z
     */
    public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        float f = 0.4375F;
        float f1 = 0.5625F;
        float f2 = 0.4375F;
        float f3 = 0.5625F;
        boolean flag = this.canPaneConnectTo(par1IBlockAccess,par2, par3, par4,ForgeDirection.NORTH);
        boolean flag1 = this.canPaneConnectTo(par1IBlockAccess,par2, par3, par4,ForgeDirection.SOUTH);
        boolean flag2 = this.canPaneConnectTo(par1IBlockAccess,par2, par3, par4,ForgeDirection.WEST);
        boolean flag3 = this.canPaneConnectTo(par1IBlockAccess,par2, par3, par4,ForgeDirection.EAST);

        if ((!flag2 || !flag3) && (flag2 || flag3 || flag || flag1))
        {
            if (flag2 && !flag3)
            {
                f = 0.0F;
            }
            else if (!flag2 && flag3)
            {
                f1 = 1.0F;
            }
        }
        else
        {
            f = 0.0F;
            f1 = 1.0F;
        }

        if ((!flag || !flag1) && (flag2 || flag3 || flag || flag1))
        {
            if (flag && !flag1)
            {
                f2 = 0.0F;
            }
            else if (!flag && flag1)
            {
                f3 = 1.0F;
            }
        }
        else
        {
            f2 = 0.0F;
            f3 = 1.0F;
        }

        this.setBlockBounds(f, 0.0F, f2, f1, 1.0F, f3);
    }

    @Override
    @SideOnly(Side.CLIENT)

    /**
     * Returns the texture index of the thin side of the pane.
     */
    public IIcon func_150097_e()
    {
        return this.theIcon;
    }

   

    /**
     * Return true if a player with Silk Touch can harvest this block directly, and not its normal drops.
     */
    protected boolean canSilkHarvest()
    {
        return true;
    }

    @Override
    /**
     * Returns an item stack containing a single instance of the current block type. 'i' is the block's subtype/damage
     * and is ignored for blocks which do not support subtypes. Blocks which cannot be harvested should return null.
     */
    protected ItemStack createStackedBlock(int par1)
    {
        return new ItemStack(this, 1, par1);
    }

    @Override
    @SideOnly(Side.CLIENT)

    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon(this.field_94402_c);
        this.theIcon = par1IconRegister.registerIcon(this.sideTextureIndex);
    }

    @Override
    // FORGE START
    public boolean canPaneConnectTo(IBlockAccess access, int x, int y, int z, ForgeDirection dir)
    {
        return canPaneConnectToBlock(access.getBlock(x+dir.offsetX, y+dir.offsetY, z+dir.offsetZ)) || access.isSideSolid(x+dir.offsetX, y+dir.offsetY, z+dir.offsetZ, dir.getOpposite(), false);
    }
    
    
    
    
    
    
    
//    /**
//     * Called upon block activation (right click on the block.)
//     */
//    public boolean onBlockActivated(World var1, int var2, int var3, int var4, EntityPlayer var5, int var6, float var7, float var8, float var9)
//    {
//    	ExtendedPlayer props = (ExtendedPlayer)var5.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);
//		
//    	if(var5.inventory.getCurrentItem().getItem() == BleachItems.zanpakuto && props.getFaction() == 1 && props.getCurrentEnergy() >= (float)50 / (float)props.getCurrentCap())
//    	{
//
//            this.checkPossiblePortal(var1, var2, var3, var4, var5);
//        
//    	}
//        return true;
//    }
//
//	public void checkPossiblePortal(World var1, int var2, int var3, int var4, EntityPlayer var5) 
//	{
//		int requirements = 0;
//		for(int checkX = -1; checkX <= 1; checkX++)
//		{
//			for(int checkY = -1; checkY <= 1; checkY++)
//			{
//				for(int woodY = -1; woodY <= 1; woodY++)
//				{
//					if(var1.getBlockId(var2 + 2, var3 + woodY, var4) == Block.wood.blockID && var1.getBlockId(var2 - 2, var3 + woodY, var4) == Block.wood.blockID)
//					{
//						requirements++;
//					}
//				}
//				
//			}
//		}
//		if(requirements == 27)
//		{
//			this.createPortal(var1, var2, var3, var4, var5, 1);
//		}
//		
//		requirements = 1;
//		
//		for(int checkZ = -1; checkZ <= 1; checkZ++)
//		{
//			for(int checkY = -1; checkY <= 1; checkY++)
//			{
//				if(var1.getBlockId(var2, var3 + checkY, var4 + checkZ) == BleachBlocks.paperwall.blockID)
//				{
//					for(int woodY = -1; woodY <= 1; woodY++)
//					{
//						if(var1.getBlockId(var2, var3 + woodY, var4 + 2) == Block.wood.blockID && var1.getBlockId(var2, var3 + woodY, var4 - 2) == Block.wood.blockID)
//						{
//							requirements++;
//						}
//					}
//				}
//				
//			}
//		}
//		if(requirements == 28)
//		{
//			this.createPortal(var1, var2, var3, var4, var5, 2);
//		}
//	}
//
//	private void createPortal(World var1, int var2, int var3, int var4, EntityPlayer var5, int var6) 
//	{
//		ExtendedPlayer props = (ExtendedPlayer)var5.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);
//		props.consumeEnergy(50);
//		if(var6 ==1)
//		{
//			for(int checkX = -1; checkX <= 1; checkX++)
//			{
//				for(int checkY = -1; checkY <= 1; checkY++)
//				{
//					var1.setBlock(var2 + checkX, var3 + checkY, var4, BleachBlocks.ssportal.blockID);
//					var1.scheduleBlockUpdate(var2+ checkX, var3+ checkY, var4, BleachBlocks.ssportal.blockID, 10);
//				}
//			}
//		}
//		else if(var6 == 2)
//		{
//			for(int checkZ = -1; checkZ <= 1; checkZ++)
//			{
//				for(int checkY = -1; checkY <= 1; checkY++)
//				{
//					var1.setBlock(var2, var3 + checkY, var4 + checkZ, BleachBlocks.ssportal.blockID);
//					var1.scheduleBlockUpdate(var2, var3+ checkY, var4 + checkZ, BleachBlocks.ssportal.blockID, 10);
//					
//				}
//			}
//		}
//		
//	}
//    
//    
    
    
    
}
