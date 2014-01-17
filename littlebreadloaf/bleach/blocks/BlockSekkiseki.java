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

public class BlockSekkiseki extends Block
{
	public BlockSekkiseki(int id)
	{
		super(id, Material.iron);
		this.setCreativeTab(BleachItems.tabBleach);
		this.setUnlocalizedName(Names.Sekkiseki_UnlocalizedName);
		this.setHardness(10F);
		this.setResistance(30F);
		this.setStepSound(Block.soundStoneFootstep);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon)
	{
		blockIcon = icon.registerIcon(BleachModInfo.ID.toLowerCase() + ":" + Names.Sekkiseki_UnlocalizedName);
	}
}
