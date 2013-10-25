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

public class BlockWhiteSand extends Block
{
	public BlockWhiteSand(int id)
	{
		super(id, Material.sand);
		this.setCreativeTab(Items.tabBleach);
		this.setUnlocalizedName(Names.WhiteSand_UnlocalizedName);
		this.setHardness(2F);
		this.setResistance(6F);
		this.setStepSound(Block.soundStoneFootstep);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon)
	{
		blockIcon = icon.registerIcon(BleachModInfo.ID.toLowerCase() + ":" + Names.WhiteSand_UnlocalizedName);
	}
}
