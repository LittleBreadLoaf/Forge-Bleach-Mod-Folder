package littlebreadloaf.bleach.blocks;

import java.util.Random;

import littlebreadloaf.bleach.BleachModInfo;
import littlebreadloaf.bleach.Names;
import littlebreadloaf.bleach.entities.EntityHollowBat;
import littlebreadloaf.bleach.entities.EntityHollowBlaze;
import littlebreadloaf.bleach.entities.EntityHollowGolem;
import littlebreadloaf.bleach.entities.EntityHollowOre;
import littlebreadloaf.bleach.entities.EntityHollowSnake;
import littlebreadloaf.bleach.entities.EntityHollowSpider;
import littlebreadloaf.bleach.entities.EntityHollowStalker;
import littlebreadloaf.bleach.entities.EntityHollowWasp;
import littlebreadloaf.bleach.entities.EntityHollowWolf;
import littlebreadloaf.bleach.entities.EntityMenosGrande;
import littlebreadloaf.bleach.extras.ParticleEffects;
import littlebreadloaf.bleach.items.BleachItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockHollowBait extends Block
{
    @SideOnly(Side.CLIENT)
    private IIcon cakeTopIcon;
    @SideOnly(Side.CLIENT)
    private IIcon cakeBottomIcon;
    @SideOnly(Side.CLIENT)
    private IIcon field_94382_c;

    protected Random rand;
    public int posX;
    public int posY;
    public int posZ;
    public boolean activated;
    public int baitTimer;
    
    protected BlockHollowBait()
    {
        super(Material.cake);
        this.setTickRandomly(false);
        this.rand = new Random();
        this.setCreativeTab(BleachItems.tabBleach);
		this.setBlockName(Names.HollowBait_UnlocalizedName);
		this.setHardness(3F);
		this.setResistance(15F);
		this.setStepSound(Block.soundTypeStone);
    }
    
    @Override
    public int tickRate(World par1World)
    {
        return 10;
    }

    
    
    @Override
    /**
     * Updates the blocks bounds based on its current state. Args: world, x, y, z
     */
    public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        int l = par1IBlockAccess.getBlockMetadata(par2, par3, par4);
        float f = 0.0625F;
        float f1 = (float)(1 + l * 2) / 16.0F;
        float f2 = 0.5F;
        this.setBlockBounds(f1, 0.0F, f, 1.0F - f, f2, 1.0F - f);
    }

    
    @Override
    /**
     * Sets the block's bounds for rendering it as an item
     */
    public void setBlockBoundsForItemRender()
    {
        float f = 0.0625F;
        float f1 = 0.5F;
        this.setBlockBounds(f, 0.0F, f, 1.0F - f, f1, 1.0F - f);
    }

    
    
    @Override
    /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        int l = par1World.getBlockMetadata(par2, par3, par4);
        float f = 0.0625F;
        float f1 = (float)(1 + l * 2) / 16.0F;
        float f2 = 0.5F;
        return AxisAlignedBB.getAABBPool().getAABB((double)((float)par2 + f1), (double)par3, (double)((float)par4 + f), (double)((float)(par2 + 1) - f), (double)((float)par3 + f2 - f), (double)((float)(par4 + 1) - f));
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
    @SideOnly(Side.CLIENT)

    /**
     * Returns the bounding box of the wired rectangular prism to render.
     */
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        int l = par1World.getBlockMetadata(par2, par3, par4);
        float f = 0.0625F;
        float f1 = (float)(1 + l * 2) / 16.0F;
        float f2 = 0.5F;
        return AxisAlignedBB.getAABBPool().getAABB((double)((float)par2 + f1), (double)par3, (double)((float)par4 + f), (double)((float)(par2 + 1) - f), (double)((float)par3 + f2), (double)((float)(par4 + 1) - f));
    }
    
    @Override
    @SideOnly(Side.CLIENT)

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public IIcon getIcon(int par1, int par2)
    {
        return par1 == 1 ? this.cakeTopIcon : (par1 == 0 ? this.cakeBottomIcon : (par2 > 0 && par1 == 4 ? this.field_94382_c : this.blockIcon));
    }

    @Override
    @SideOnly(Side.CLIENT)

    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon(BleachModInfo.ID.toLowerCase() + ":" + Names.HollowBait_UnlocalizedName + "2");
        this.field_94382_c = par1IconRegister.registerIcon("cake_inner");
        this.cakeTopIcon = par1IconRegister.registerIcon(BleachModInfo.ID.toLowerCase() + ":" + Names.HollowBait_UnlocalizedName + "1");
        this.cakeBottomIcon = par1IconRegister.registerIcon(BleachModInfo.ID.toLowerCase() + ":" + Names.HollowBait_UnlocalizedName + "2");
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
     * Called upon block activation (right click on the block.)
     */
    public boolean onBlockActivated(World var1, int var2, int var3, int var4, EntityPlayer var5, int var6, float var7, float var8, float var9)
    {
        this.baitTimer = 0;
        var1.scheduleBlockUpdate(var2, var3, var4, this, this.tickRate(var1));
        this.posX = var2;
        this.posY = var3;
        this.posZ = var4;
        this.activated = true;
        return true;
    }

    
    
    @Override
    /**
     * Called when the block is clicked by a player. Args: x, y, z, entityPlayer
     */
    public void onBlockClicked(World var1, int var2, int var3, int var4, EntityPlayer var5)
    {
        this.baitTimer = 0;
        var1.scheduleBlockUpdate(var2, var3, var4, this, this.tickRate(var1));
        this.posX = var2;
        this.posY = var3;
        this.posZ = var4;
        this.activated = true;
    }

   

    
    
    @Override
    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor blockID
     */
    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, Block par5)
    {
        if (!this.canBlockStay(par1World, par2, par3, par4))
        {
            par1World.setBlockToAir(par2, par3, par4);
        }
    }
    
    boolean var18 = false;
    
    @Override
    public void updateTick(World var1, int var2, int var3, int var4, Random var5)
    {
        ++this.baitTimer;

        if (this.baitTimer < 840)
        {
            EntityHollowBat var6 = new EntityHollowBat(var1);
            EntityHollowBlaze var7 = new EntityHollowBlaze(var1);
            EntityHollowSpider var8 = new EntityHollowSpider(var1);
            EntityMenosGrande var9 = new EntityMenosGrande(var1);
            EntityHollowSnake var14 = new EntityHollowSnake(var1);
            EntityHollowGolem var15 = new EntityHollowGolem(var1);
            EntityHollowWasp var16 = new EntityHollowWasp(var1);
            EntityHollowStalker var17 = new EntityHollowStalker(var1);
            EntityHollowOre var18 = new EntityHollowOre(var1);
            EntityHollowWolf var19 = new EntityHollowWolf(var1);
            
            int var10 = this.posX + this.rand.nextInt(100) - this.rand.nextInt(100);
            int var11 = this.posY + 60;
            int var12 = this.posZ + this.rand.nextInt(100) - this.rand.nextInt(100);
            
            var6.setLocationAndAngles((double)var10, (double)var11, (double)var12, 0.0F, 0.0F);
            var7.setLocationAndAngles((double)var10, (double)var11, (double)var12, 0.0F, 0.0F);
            var8.setLocationAndAngles((double)var10, (double)var11, (double)var12, 0.0F, 0.0F);
            var9.setLocationAndAngles((double)var10, (double)var11, (double)var12, 0.0F, 0.0F);
            var14.setLocationAndAngles((double)var10, (double)var11, (double)var12, 0.0F, 0.0F);
            var15.setLocationAndAngles((double)var10, (double)var11, (double)var12, 0.0F, 0.0F);
            var16.setLocationAndAngles((double)var10, (double)var11, (double)var12, 0.0F, 0.0F);
            var17.setLocationAndAngles((double)var10, (double)var11, (double)var12, 0.0F, 0.0F);
            var18.setLocationAndAngles((double)var10, (double)var11, (double)var12, 0.0F, 0.0F);
            var19.setLocationAndAngles((double)var10, (double)var11, (double)var12, 0.0F, 0.0F);
            
            int randomHollows = rand.nextInt(90); 
            int randomMenos = rand.nextInt(2000);
            
            if (randomHollows == 0)
            {
                var1.spawnEntityInWorld(var6);
            }

            if (randomHollows == 1)
            {
                var1.spawnEntityInWorld(var7);
            }

            if (randomHollows == 2)
            {
                var1.spawnEntityInWorld(var8);
            }
            
            if(randomHollows == 4)
            {
              var1.spawnEntityInWorld(var14);
            }
            if(randomHollows == 5)
            {
              var1.spawnEntityInWorld(var15);
            }
            if(randomHollows == 6)
            {
              var1.spawnEntityInWorld(var16);
            }
            if(randomHollows == 7)
            {
              var1.spawnEntityInWorld(var17);
            }
            if(randomHollows == 8)
            {
            	var1.spawnEntityInWorld(var18);
            }
            if(randomHollows == 9)
            {
            	var1.spawnEntityInWorld(var19);
            }

            if (randomMenos == 3)
            {
                var1.spawnEntityInWorld(var9);
            }

            var1.scheduleBlockUpdate(var2, var3, var4, this, this.tickRate(var1));
        }

        if (this.baitTimer >= 840)
        {
        	var1.setBlockToAir(var2, var3, var4);
            this.baitTimer = 0;
            this.activated = false;
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

    
    @Override
    /**
     * Returns the ID of the items to drop on destruction.
     */
    public Item getItemDropped(int par1, Random par2Random, int par3)
    {
        return null;
    }
    
    
    @Override
    /**
     * A randomly called display update to be able to add particles or other items for display
     */
    public void randomDisplayTick(World var1, int var2, int var3, int var4, Random var5)
    {
        double var6 = (double)((float)var2 + 0.1F + var5.nextFloat() * 0.8F);
        double var8 = (double)((float)var3 + 0.3F + var5.nextFloat() * 0.3F);
        double var10 = (double)((float)var4 + 0.1F + var5.nextFloat() * 0.8F);
        ParticleEffects.spawnParticle("soul", var6, var8, var10, 0.0D, 0.0D, 0.0D);
    }
    
}
