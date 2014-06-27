package littlebreadloaf.bleach.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import littlebreadloaf.bleach.BleachModInfo;
import littlebreadloaf.bleach.Names;
import littlebreadloaf.bleach.items.BleachItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.world.World;

public class BleachBlock extends Block
{

	public BleachBlock()
	{
		super(Material.rock);
		this.setCreativeTab(BleachItems.tabBleach);
	}



	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister itemIcon)
	{
		this.blockIcon = itemIcon.registerIcon(BleachModInfo.ID + ":" + this.getUnlocalizedName().substring(5));
	}
}
