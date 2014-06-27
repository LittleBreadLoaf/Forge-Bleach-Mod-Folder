package littlebreadloaf.bleach.blocks;

import littlebreadloaf.bleach.BleachModInfo;
import littlebreadloaf.bleach.Names;
import littlebreadloaf.bleach.items.BleachItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockHollowEmerald extends Block
{
	public BlockHollowEmerald()
	{
		super(Material.rock);
		this.setCreativeTab(BleachItems.tabBleach);
		this.setBlockName(Names.HollowEmerald_UnlocalizedName);
		this.setHardness(6F);
		this.setResistance(8F);
		this.setStepSound(Block.soundTypeStone);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister icon)
	{
		blockIcon = icon.registerIcon(BleachModInfo.ID.toLowerCase() + ":" + Names.HollowEmerald_UnlocalizedName);
	}
}
