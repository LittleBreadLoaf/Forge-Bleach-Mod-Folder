package littlebreadloaf.bleach.blocks;

import java.util.List;
import java.util.Random;

import littlebreadloaf.bleach.BleachIds;
import littlebreadloaf.bleach.BleachModInfo;
import littlebreadloaf.bleach.items.BleachItems;
import littlebreadloaf.bleach.world.SoulSocietyTeleporter;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockSSPortal extends BlockPane
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
    private Icon theIcon;

    protected BlockSSPortal(int par1, String par2Str, String par3Str, Material par4Material, boolean par5)
    {
        super(par1, par3Str, par3Str, par4Material, par5);
        this.sideTextureIndex = BleachModInfo.ID.toLowerCase() + ":" + par3Str;
        this.canDropItself = par5;
        this.field_94402_c = BleachModInfo.ID.toLowerCase() + ":" + par2Str;
        this.setCreativeTab(BleachItems.tabBleach);
        this.setLightValue(1.0F);
        this.setTickRandomly(false);
        this.timeRemaining = 0;
    }

    
    
    public int tickRate(World par1World)
    {
        return 10;
    }
    
    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return 0;
    }

    /**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    public boolean isOpaqueCube()
    {
        return false;
    }

    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    /**
     * The type of render function that is called for this block
     */
    public int getRenderType()
    {
        return 18;
    }

    @SideOnly(Side.CLIENT)

    /**
     * Returns true if the given side of this block type should be rendered, if the adjacent block is at the given
     * coordinates.  Args: blockAccess, x, y, z, side
     */
    public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
    {
        int i1 = par1IBlockAccess.getBlockId(par2, par3, par4);
        return i1 == this.blockID ? false : super.shouldSideBeRendered(par1IBlockAccess, par2, par3, par4, par5);
    }

    /**
     * Adds all intersecting collision boxes to a list. (Be sure to only add boxes to the list if they intersect the
     * mask.) Parameters: World, X, Y, Z, mask, list, colliding entity
     */
    public void addCollisionBoxesToList(World par1World, int par2, int par3, int par4, AxisAlignedBB par5AxisAlignedBB, List par6List, Entity par7Entity)
    {
        boolean flag = this.canwallConnectTo(par1World,par2, par3, par4,ForgeDirection.NORTH);
        boolean flag1 = this.canwallConnectTo(par1World,par2, par3, par4,ForgeDirection.SOUTH);
        boolean flag2 = this.canwallConnectTo(par1World,par2, par3, par4,ForgeDirection.WEST);
        boolean flag3 = this.canwallConnectTo(par1World,par2, par3, par4,ForgeDirection.EAST);

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

    /**
     * Sets the block's bounds for rendering it as an item
     */
    public void setBlockBoundsForItemRender()
    {
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }

    /**
     * Updates the blocks bounds based on its current state. Args: world, x, y, z
     */
    public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        float f = 0.4375F;
        float f1 = 0.5625F;
        float f2 = 0.4375F;
        float f3 = 0.5625F;
        boolean flag = this.canwallConnectTo(par1IBlockAccess,par2, par3, par4,ForgeDirection.NORTH);
        boolean flag1 = this.canwallConnectTo(par1IBlockAccess,par2, par3, par4,ForgeDirection.SOUTH);
        boolean flag2 = this.canwallConnectTo(par1IBlockAccess,par2, par3, par4,ForgeDirection.WEST);
        boolean flag3 = this.canwallConnectTo(par1IBlockAccess,par2, par3, par4,ForgeDirection.EAST);

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

    @SideOnly(Side.CLIENT)

    /**
     * Returns the texture index of the thin side of the pane.
     */
    public Icon getSideTextureIndex()
    {
        return this.theIcon;
    }

    /**
     * Gets passed in the blockID of the block adjacent and supposed to return true if its allowed to connect to the
     * type of blockID passed in. Args: blockID
     */
    public final boolean canThiswallConnectToThisBlockID(int par1)
    {
        return par1 == this.blockID || par1 == Block.wood.blockID;
    }

    /**
     * Return true if a player with Silk Touch can harvest this block directly, and not its normal drops.
     */
    protected boolean canSilkHarvest()
    {
        return true;
    }

    /**
     * Returns an item stack containing a single instance of the current block type. 'i' is the block's subtype/damage
     * and is ignored for blocks which do not support subtypes. Blocks which cannot be harvested should return null.
     */
    protected ItemStack createStackedBlock(int par1)
    {
        return new ItemStack(this.blockID, 1, par1);
    }

    @SideOnly(Side.CLIENT)

    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon(this.field_94402_c);
        this.theIcon = par1IconRegister.registerIcon(this.sideTextureIndex);
    }

    // FORGE START
    public boolean canwallConnectTo(IBlockAccess access, int x, int y, int z, ForgeDirection dir)
    {
        return canThiswallConnectToThisBlockID(access.getBlockId(x+dir.offsetX, y+dir.offsetY, z+dir.offsetZ)) || access.isBlockSolidOnSide(x+dir.offsetX, y+dir.offsetY, z+dir.offsetZ, dir.getOpposite(), false);
    }
    
    
    

    /**
     * Triggered whenever an entity collides with this block (enters into the block). Args: world, x, y, z, entity
     */
    public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity)
    {
    	if(par5Entity instanceof EntityPlayerMP)
    	{
    		EntityPlayerMP playermp = (EntityPlayerMP) par5Entity;
			if (playermp.dimension == BleachIds.worldSoulSocietyID)
			{
				playermp.mcServer.getConfigurationManager().transferPlayerToDimension(playermp, 0, new SoulSocietyTeleporter(playermp.mcServer.worldServerForDimension(0)));
			} 
			else
			{
				playermp.mcServer.getConfigurationManager().transferPlayerToDimension(playermp, BleachIds.worldSoulSocietyID,
					new SoulSocietyTeleporter(playermp.mcServer.worldServerForDimension(BleachIds.worldSoulSocietyID)));
			}
    	}
    }
    
    
    int timeRemaining = 0;
    public void updateTick(World var1, int var2, int var3, int var4, Random var5)
    {
        ++this.timeRemaining;

        
        if (this.timeRemaining >= 120)
        {
        	
        	var1.setBlock(var2, var3, var4, BleachBlocks.paperwall.blockID);
        	
        }
        else
        {
        	var1.scheduleBlockUpdate(var2, var3, var4, this.blockID, this.tickRate(var1));
        }
    }
}
