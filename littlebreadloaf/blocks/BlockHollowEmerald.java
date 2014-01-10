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

public class BlockHollowEmerald extends Block
{
	public BlockHollowEmerald(int id)
	{
		super(id, Material.rock);
		this.setCreativeTab(Items.tabBleach);
		this.setUnlocalizedName(Names.HollowEmerald_UnlocalizedName);
		this.setHardness(6F);
		this.setResistance(8F);
		this.setStepSound(Block.soundStoneFootstep);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon)
	{
		blockIcon = icon.registerIcon(BleachModInfo.ID.toLowerCase() + ":" + Names.HollowEmerald_UnlocalizedName);
	}
}
