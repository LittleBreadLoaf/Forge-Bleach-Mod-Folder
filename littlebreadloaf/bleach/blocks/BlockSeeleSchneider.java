package littlebreadloaf.bleach.blocks;

import java.util.Random;

import littlebreadloaf.bleach.BleachIds;
import littlebreadloaf.bleach.Names;
import littlebreadloaf.bleach.items.BleachItems;
import littlebreadloaf.bleach.tiles.TileSeeleSchneider;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class BlockSeeleSchneider extends BleachBlockContainer
{

	public BlockSeeleSchneider(int id, Material mat)
	{
		super(id, mat);
		this.setCreativeTab(null);

		this.setUnlocalizedName("seeles");
		this.setHardness(5F);
		this.setResistance(15F);
		this.setStepSound(Block.soundMetalFootstep);
		this.setLightValue(0.9F);

		this.setBlockBounds(7 / 16F, 0F, 7 / 16F, 1F - (7 / 16F), 1F + 8F / 16F, 1F - (7 / 16F));
	}

	@Override
	public int getRenderType()
	{
		return BleachIds.seeleSchneiderRenderingID;
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World world)
	{
		return new TileSeeleSchneider();
	}

	/**
	 * Called upon block activation (right click on the block.)
	 */
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
	{
		if(player.getCurrentEquippedItem() == null)
		{
			this.dropBlockAsItem(world, x, y, z, 1, 0);
			world.setBlockToAir(x, y, z);
		}
		return false;
	}

	/**
	 * Returns the ID of the items to drop on destruction.
	 */
	@Override
	public int idDropped(int par1, Random par2Random, int par3)
	{
		return BleachItems.seele.itemID;
	}

	/**
	 * Determines the damage on the item the block drops. Used in cloth and
	 * wood.
	 */
	@Override
	public int damageDropped(int par1)
	{
		return 1;
	}

	/**
	 * Lets the block know when one of its neighbor changes. Doesn't know which
	 * neighbor changed (coordinates passed are their own) Args: x, y, z,
	 * neighbor blockID
	 */
	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, int id)
	{
		if (world.getBlockId(x, y - 1, z) == 0)
		{
			this.dropBlockAsItem(world, x, y, z, 1, 0);
			world.setBlockToAir(x, y, z);
		}
	}

	@Override
	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z)
	{
		return new ItemStack(BleachItems.seele, 1, 1);
	}
}
