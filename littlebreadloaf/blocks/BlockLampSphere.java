package littlebreadloaf.blocks;

import littlebreadloaf.items.Items;
import littlebreadloaf.libraries.Ids;
import littlebreadloaf.libraries.Names;
import littlebreadloaf.tiles.TileSphereLamp;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockLampSphere extends BlockContainer
{

	public BlockLampSphere(int id, Material material)
	{
		super(id, material);
		this.setCreativeTab(Items.tabBleach);
		this.setUnlocalizedName(Names.SphereLamp_UnlocalizedName);
		this.setHardness(5F);
		this.setResistance(15F);
		this.setStepSound(Block.soundGlassFootstep);
		this.setLightValue(0.9F);
	}

	@Override
	public int getRenderType()
	{
		return Ids.sphereLampRenderID;
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
		return new TileSphereLamp();
	}
	
	/**
	 * Called when the block is placed in the world.
	 */
	@Override
	public void onBlockPlacedBy(World world, int i, int j, int k, EntityLivingBase entity, ItemStack ItemStack)
	{
		if(world.getBlockTileEntity(i, j, k) instanceof TileSphereLamp && entity instanceof EntityPlayer)
		{
			((TileSphereLamp) world.getBlockTileEntity(i, j, k)).setOwnerEntity((EntityPlayer) entity);
		}
	}
}
