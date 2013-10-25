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

public class BlockSoulQuartzLamp extends Block
{
	public BlockSoulQuartzLamp(int id)
	{
		super(id, Material.rock);
		this.setCreativeTab(Items.tabBleach);
		this.setUnlocalizedName(Names.SoulQuartzLamp_UnlocalizedName);
		this.setHardness(3F);
		this.setResistance(10F);
		this.setStepSound(Block.soundStoneFootstep);
		this.setLightValue(1.0F);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon)
	{
		blockIcon = icon.registerIcon(BleachModInfo.ID.toLowerCase() + ":" + Names.SoulQuartzLamp_UnlocalizedName);
	}
}
