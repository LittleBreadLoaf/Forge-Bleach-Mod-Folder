package littlebreadloaf.bleach.blocks;

import littlebreadloaf.bleach.BleachIds;
import littlebreadloaf.bleach.Names;
import littlebreadloaf.bleach.items.BleachItems;
import littlebreadloaf.bleach.tiles.TileSphereLamp;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockLampSphere extends BleachBlockContainer
{

	public BlockLampSphere()
	{
		super(Material.glass);
		this.setBlockName(Names.SphereLamp_UnlocalizedName);
		this.setHardness(5F);
		this.setResistance(15F);
		this.setStepSound(Block.soundTypeGlass);
		this.setLightLevel(0.9F);
	}

	@Override
	public int getRenderType()
	{
		return BleachIds.sphereLampRenderID;
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
	public TileEntity createNewTileEntity(World world, int metadata)
	{
		return new TileSphereLamp();
	}
	
	/**
	 * Called when the block is placed in the world.
	 */
	@Override
	public void onBlockPlacedBy(World world, int i, int j, int k, EntityLivingBase entity, ItemStack ItemStack)
	{
		if(world.getTileEntity(i, j, k) instanceof TileSphereLamp && entity instanceof EntityPlayer)
		{
			((TileSphereLamp) world.getTileEntity(i, j, k)).setOwnerEntity((EntityPlayer) entity);
		}
	}

	
}
