package littlebreadloaf.bleach.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import littlebreadloaf.bleach.BleachIds;
import littlebreadloaf.bleach.BleachModInfo;
import littlebreadloaf.bleach.Names;
import littlebreadloaf.bleach.tiles.TileLantern;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockLantern extends BleachBlockContainer
{

	public BlockLantern(int id, Material material)
	{
		super(id, material);

		this.setUnlocalizedName("lantern_item");
		this.setHardness(5F);
		this.setResistance(15F);
		this.setStepSound(Block.soundGlassFootstep);
		this.setLightValue(0.9F);
	}

	@Override
	public int getRenderType()
	{
		return BleachIds.lanternRenderingID;
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
		return new TileLantern();
	}
}
