package littlebreadloaf.bleach.blocks;

import littlebreadloaf.bleach.BleachModInfo;
import littlebreadloaf.bleach.Names;
import littlebreadloaf.bleach.items.BleachItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockReiatsu extends Block
{
	public BlockReiatsu()
	{
		super(Material.iron);
		this.setCreativeTab(BleachItems.tabBleach);
		this.setBlockName(Names.ReiatsuBlock_UnlocalizedName);
		this.setHardness(5F);
		this.setResistance(15F);
		this.setStepSound(Block.soundTypeStone);
		this.setLightLevel(0.9F);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister icon)
	{
		blockIcon = icon.registerIcon(BleachModInfo.ID.toLowerCase() + ":" + Names.ReiatsuBlock_UnlocalizedName);
	}
	
	
	
}
