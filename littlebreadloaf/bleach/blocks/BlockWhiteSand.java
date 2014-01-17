package littlebreadloaf.bleach.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import littlebreadloaf.bleach.BleachModInfo;
import littlebreadloaf.bleach.Names;
import littlebreadloaf.bleach.items.BleachItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;

public class BlockWhiteSand extends Block
{
	public BlockWhiteSand(int id)
	{
		super(id, Material.sand);
		this.setCreativeTab(BleachItems.tabBleach);
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
