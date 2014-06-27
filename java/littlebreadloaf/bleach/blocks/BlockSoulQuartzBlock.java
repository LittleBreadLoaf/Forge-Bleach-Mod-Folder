package littlebreadloaf.bleach.blocks;

import littlebreadloaf.bleach.BleachModInfo;
import littlebreadloaf.bleach.Names;
import littlebreadloaf.bleach.items.BleachItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockSoulQuartzBlock extends Block
{
	public BlockSoulQuartzBlock()
	{
		super(Material.rock);
		this.setCreativeTab(BleachItems.tabBleach);
		this.setBlockName(Names.SoulQuartzBlock_UnlocalizedName);
		this.setHardness(4F);
		this.setResistance(10F);
		this.setStepSound(Block.soundTypeStone);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister icon)
	{
		blockIcon = icon.registerIcon(BleachModInfo.ID.toLowerCase() + ":" + Names.SoulQuartzBlock_UnlocalizedName);
	}
}
