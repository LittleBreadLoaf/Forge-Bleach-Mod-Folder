package littlebreadloaf.entities.renders;

import static net.minecraftforge.client.IItemRenderer.ItemRenderType.EQUIPPED;
import static net.minecraftforge.client.IItemRenderer.ItemRendererHelper.BLOCK_3D;

import org.lwjgl.opengl.GL11;

import littlebreadloaf.entities.classes.EntityShinigami;
import littlebreadloaf.items.Items;
import littlebreadloaf.libraries.BleachModInfo;
import net.minecraft.block.Block;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.tileentity.TileEntitySkullRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;

public class RenderShinigami extends RenderBiped
{
	private static final ResourceLocation texture1 = new ResourceLocation(BleachModInfo.ID.toLowerCase() + ":textures/models/mobs/shinigami.png");
	private static final ResourceLocation texture2 = new ResourceLocation(BleachModInfo.ID.toLowerCase() + ":textures/models/mobs/shinigami1.png");
	private static final ResourceLocation texture3 = new ResourceLocation(BleachModInfo.ID.toLowerCase() + ":textures/models/mobs/shinigami2.png");
	private static final ResourceLocation texture4 = new ResourceLocation(BleachModInfo.ID.toLowerCase() + ":textures/models/mobs/shinigami3.png");
	private static final ResourceLocation texture5 = new ResourceLocation(BleachModInfo.ID.toLowerCase() + ":textures/models/mobs/shinigami4.png");
	private static final ResourceLocation texture6 = new ResourceLocation(BleachModInfo.ID.toLowerCase() + ":textures/models/mobs/shinigami5.png");
	private static final ResourceLocation texture7 = new ResourceLocation(BleachModInfo.ID.toLowerCase() + ":textures/models/mobs/shinigami6.png");
	private static final ResourceLocation texture8 = new ResourceLocation(BleachModInfo.ID.toLowerCase() + ":textures/models/mobs/shinigami7.png");
	private static final ResourceLocation texture9 = new ResourceLocation(BleachModInfo.ID.toLowerCase() + ":textures/models/mobs/shinigami8.png");
	private static final ResourceLocation texture10 = new ResourceLocation(BleachModInfo.ID.toLowerCase() + ":textures/models/mobs/shinigami9.png");
	private static final ResourceLocation texture11 = new ResourceLocation(BleachModInfo.ID.toLowerCase() + ":textures/models/mobs/shinigami10.png");
	protected ModelBiped model;

	public RenderShinigami(ModelBiped par1ModelBiped, float par2)
	{
		super(par1ModelBiped, par2);
		model = ((ModelBiped) mainModel);
	}
	protected void renderEquippedItems(EntityLivingBase entity, float par2)
    {
        float f1 = 1.0F;
        GL11.glColor3f(f1, f1, f1);
        super.renderEquippedItems(entity, par2);
        ItemStack itemstack = entity.getHeldItem();
        ItemStack itemstack1 = ((EntityLiving) entity).func_130225_q(3);
        float f2;

        if (itemstack1 != null)
        {
            GL11.glPushMatrix();
            this.modelBipedMain.bipedHead.postRender(0.0625F);

            IItemRenderer customRenderer = MinecraftForgeClient.getItemRenderer(itemstack1, EQUIPPED);
            boolean is3D = (customRenderer != null && customRenderer.shouldUseRenderHelper(EQUIPPED, itemstack1, BLOCK_3D));

            if (itemstack1.getItem() instanceof ItemBlock)
            {
                if (is3D || RenderBlocks.renderItemIn3d(Block.blocksList[itemstack1.itemID].getRenderType()))
                {
                    f2 = 0.625F;
                    GL11.glTranslatef(0.0F, -0.25F, 0.0F);
                    GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
                    GL11.glScalef(f2, -f2, -f2);
                }

                this.renderManager.itemRenderer.renderItem(entity, itemstack1, 0);
            }
            else if (itemstack1.getItem().itemID == Item.skull.itemID)
            {
                f2 = 1.0625F;
                GL11.glScalef(f2, -f2, -f2);
                String s = "";

                if (itemstack1.hasTagCompound() && itemstack1.getTagCompound().hasKey("SkullOwner"))
                {
                    s = itemstack1.getTagCompound().getString("SkullOwner");
                }

                TileEntitySkullRenderer.skullRenderer.func_82393_a(-0.5F, 0.0F, -0.5F, 1, 180.0F, itemstack1.getItemDamage(), s);
            }

            GL11.glPopMatrix();
        }

        if (itemstack != null)
        {
            GL11.glPushMatrix();

            if (this.mainModel.isChild)
            {
                f2 = 0.5F;
                GL11.glTranslatef(0.0F, 0.625F, 0.0F);
                GL11.glRotatef(-20.0F, -1.0F, 0.0F, 0.0F);
                GL11.glScalef(f2, f2, f2);
            }

            this.modelBipedMain.bipedRightArm.postRender(0.0625F);
            GL11.glTranslatef(-0.0625F, 0.4375F, 0.0625F);

            IItemRenderer customRenderer = MinecraftForgeClient.getItemRenderer(itemstack, EQUIPPED);
            boolean is3D = (customRenderer != null && customRenderer.shouldUseRenderHelper(EQUIPPED, itemstack, BLOCK_3D));

            if (itemstack.getItem() instanceof ItemBlock && (is3D || RenderBlocks.renderItemIn3d(Block.blocksList[itemstack.itemID].getRenderType())))
            {
                f2 = 0.5F;
                GL11.glTranslatef(0.0F, 0.1875F, -0.3125F);
                f2 *= 0.75F;
                GL11.glRotatef(20.0F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
                GL11.glScalef(-f2, -f2, f2);
            }
            else if (itemstack.itemID == Items.zanpakuto.itemID)
            {//TODO: fix rotation
                f2 = 0.625F;
                GL11.glTranslatef(0.0F, 0.125F, 0.3125F);
                GL11.glRotatef(-20.0F, 0.0F, 1.0F, 0.0F);
                GL11.glScalef(f2, -f2, f2);
                GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
            }
            else if (Item.itemsList[itemstack.itemID].isFull3D())
            {
                f2 = 0.625F;

                if (Item.itemsList[itemstack.itemID].shouldRotateAroundWhenRendering())
                {
                    GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
                    GL11.glTranslatef(0.0F, -0.125F, 0.0F);
                }

                this.func_82422_c();
                GL11.glScalef(f2, -f2, f2);
                GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
            }
            else
            {
                f2 = 0.375F;
                GL11.glTranslatef(0.25F, 0.1875F, -0.1875F);
                GL11.glScalef(f2, f2, f2);
                GL11.glRotatef(60.0F, 0.0F, 0.0F, 1.0F);
                GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(20.0F, 0.0F, 0.0F, 1.0F);
            }

            this.renderManager.itemRenderer.renderItem(entity, itemstack, 0);

            if (itemstack.getItem().requiresMultipleRenderPasses())
            {
                for (int x = 1; x < itemstack.getItem().getRenderPasses(itemstack.getItemDamage()); x++)
                {
                    this.renderManager.itemRenderer.renderItem(entity, itemstack, x);
                }
            }

            GL11.glPopMatrix();
        }
    }
	
	public void renderShinigami(EntityShinigami par1, double par2, double par3, double par4, float par5, float par6)
	{
		super.doRenderLiving(par1, par2, par3, par4, par5, par6);
	}

	public void doRenderLiving(EntityLiving par1, double par2, double par3, double par4, float par5, float par6)
	{
		this.renderShinigami((EntityShinigami) par1, par2, par3, par4, par5, par6);
	}

	@Override
	public void doRender(Entity par1, double par2, double par3, double par4, float par5, float par6)
	{
		this.renderShinigami((EntityShinigami) par1, par2, par3, par4, par5, par6);
	}

	protected ResourceLocation getEntityTexture(Entity entity)
	{
		switch (((EntityShinigami) entity).getTexture())
		{
			case 0:
				return texture2;
			case 1:
				return texture3;
			case 2:
				return texture4;
			case 3:
				return texture5;
			case 4:
				return texture6;
			case 5:
				return texture7;
			case 6:
				return texture8;
			case 7:
				return texture9;
			case 8:
				return texture10;
			case 9:
				return texture11;
			default:
				return texture1;

		}
	}

}
