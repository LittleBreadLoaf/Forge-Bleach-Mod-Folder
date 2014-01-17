package littlebreadloaf.bleach.blocks;

import littlebreadloaf.bleach.Names;
import littlebreadloaf.bleach.items.BleachItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BleachBlock extends Block
{

	public BleachBlock(int par1, Material par2Material)
	{
		super(par1, par2Material);
		this.setCreativeTab(BleachItems.tabBleach);
	}

}
