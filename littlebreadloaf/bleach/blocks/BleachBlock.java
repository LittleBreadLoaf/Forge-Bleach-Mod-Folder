package littlebreadloaf.bleach.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import littlebreadloaf.bleach.BleachModInfo;
import littlebreadloaf.bleach.Names;
import littlebreadloaf.bleach.items.BleachItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.World;

public class BleachBlock extends Block
{

	public BleachBlock(int id, Material material)
	{
		super(id, material);
		this.setCreativeTab(BleachItems.tabBleach);
	}

	/**
	 * Used during tree growth to determine if newly generated leaves can replace this block.
	 *
	 * @param world The current world
	 * @param x X Position
	 * @param y Y Position
	 * @param z Z Position
	 * @return true if this block can be replaced by growing leaves.
	 */
	@Override
	public boolean canBeReplacedByLeaves(World world, int x, int y, int z)
	{
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister itemIcon)
	{
		this.blockIcon = itemIcon.registerIcon(BleachModInfo.ID + ":" + this.getUnlocalizedName().substring(5));
	}
}
