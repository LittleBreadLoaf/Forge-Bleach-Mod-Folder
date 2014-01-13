package littlebreadloaf.blocks;

import littlebreadloaf.items.Items;
import littlebreadloaf.libraries.Names;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BleachBlock extends Block
{

	public BleachBlock(int par1, Material par2Material)
	{
		super(par1, par2Material);
		this.setCreativeTab(Items.tabBleach);
	}

}
