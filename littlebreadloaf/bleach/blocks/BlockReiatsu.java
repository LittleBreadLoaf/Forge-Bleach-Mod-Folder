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

public class BlockReiatsu extends Block
{
	public BlockReiatsu(int id)
	{
		super(id, Material.iron);
		this.setCreativeTab(BleachItems.tabBleach);
		this.setUnlocalizedName(Names.ReiatsuBlock_UnlocalizedName);
		this.setHardness(5F);
		this.setResistance(15F);
		this.setStepSound(Block.soundStoneFootstep);
		this.setLightValue(0.9F);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon)
	{
		blockIcon = icon.registerIcon(BleachModInfo.ID.toLowerCase() + ":" + Names.ReiatsuBlock_UnlocalizedName);
	}
}
