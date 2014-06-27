package littlebreadloaf.bleach.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import littlebreadloaf.bleach.BleachIds;
import littlebreadloaf.bleach.BleachModInfo;
import littlebreadloaf.bleach.Names;
import littlebreadloaf.bleach.tiles.TileLantern;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockLantern extends BleachBlockContainer
{

	public BlockLantern(Material material)
	{
		super(material);

		this.setBlockTextureName("lantern_item");
		this.setBlockName(Names.Lantern_UnlocalizedName);
		this.setHardness(5F);
		this.setResistance(15F);
		this.setStepSound(Block.soundTypeGlass);
		this.setLightLevel(1.0F);
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
	public TileEntity createNewTileEntity(World world, int metadata)
	{
		return new TileLantern();
	}
}
