package littlebreadloaf.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import littlebreadloaf.items.Items;
import littlebreadloaf.libraries.BleachModInfo;
import littlebreadloaf.libraries.Names;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;

public class BlockSoulQuartzBlock extends Block
{
	public BlockSoulQuartzBlock(int id)
	{
		super(id, Material.rock);
		this.setCreativeTab(Items.tabBleach);
		this.setUnlocalizedName(Names.SoulQuartzBlock_UnlocalizedName);
		this.setHardness(4F);
		this.setResistance(10F);
		this.setStepSound(Block.soundStoneFootstep);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon)
	{
		blockIcon = icon.registerIcon(BleachModInfo.ID.toLowerCase() + ":" + Names.SoulQuartzBlock_UnlocalizedName);
	}
}
