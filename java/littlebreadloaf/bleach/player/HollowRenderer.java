package littlebreadloaf.bleach.player;

import static net.minecraftforge.client.IItemRenderer.ItemRenderType.EQUIPPED;
import static net.minecraftforge.client.IItemRenderer.ItemRendererHelper.BLOCK_3D;
import littlebreadloaf.bleach.BleachModInfo;
import littlebreadloaf.bleach.events.ExtendedPlayer;
import littlebreadloaf.bleach.player.models.ModelPlayerHollow;
import net.minecraft.block.Block;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.tileentity.TileEntitySkullRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.common.MinecraftForge;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;




	@SideOnly(Side.CLIENT)
	public class HollowRenderer extends RenderPlayer

	{

		private static final ResourceLocation texture1 = new ResourceLocation(BleachModInfo.ID.toLowerCase() + ":textures/models/mobs/player_hollow_1.png");
		
		private final ModelPlayerHollow modelBipedMain;

		private final ModelBiped modelFirstPerson;



		public HollowRenderer()
		{

			super();

			modelBipedMain = new ModelPlayerHollow();
			modelFirstPerson = new ModelBiped();
		}
	
	@Override
	protected void renderEquippedItems(AbstractClientPlayer par1AbstractClientPlayer, float par2)
	{
        ItemStack itemstack = par1AbstractClientPlayer.getHeldItem();
        ExtendedPlayer props = ExtendedPlayer.get(par1AbstractClientPlayer);
        if(props.getFaction() == 3)
        	mainModel = modelBipedMain;
        else
        	mainModel = modelFirstPerson;
        float f1 = 1.0F;
        GL11.glColor3f(f1, f1, f1);
        float f2;

        if (itemstack != null)
        {
       
       
        	if(props.getFaction() == 3)
        	{
        		GL11.glPushMatrix();

        		if (this.mainModel.isChild)
        		{
        			f2 = 1.0F;
        			GL11.glTranslatef(0.0F, 0.625F, 0.0F);
        			GL11.glRotatef(-20.0F, -1.0F, 0.0F, 0.0F);
        			GL11.glScalef(f2, f2, f2);
        		}

        		this.modelBipedMain.default_armR3.postRender(0.0625F);

          
           
        		f2 = 0.625F;
        		GL11.glScalef(f2, f2, f2);
        		
        		GL11.glTranslatef(-1.5F, 0.85F, -0.5F);
        		
        		GL11.glRotatef(-120F, 0F, 0F, 0F);
        		
        		GL11.glRotated(-20F, 0.1F, 0.0F, 0F);
        		GL11.glRotated(-0F, 0.0F, 0.1F, 0F);
        		GL11.glRotated(-70F, 0F, 0.0F, 0.1F);
        		

        		GL11.glRotated(20F, 0.1F, 0.1F, 0F);
        		GL11.glRotated(10F, 0.0F, 0.1F, 0.1F);
        		GL11.glRotated(7F, 0.1F, 0F, 0.1F);
        		

        		this.renderManager.itemRenderer.renderItem(par1AbstractClientPlayer, itemstack, 0);
           



        		GL11.glPopMatrix();
        	}
       
        	else 
        	{
        		super.renderEquippedItems(par1AbstractClientPlayer, par2);
        		super.renderArrowsStuckInEntity(par1AbstractClientPlayer, par2);
        		GL11.glPushMatrix();
        		((ModelBiped)mainModel).bipedHead.postRender(0.0625F);
                float float1;

                if (itemstack.getItem() instanceof ItemBlock)
                {
                    IItemRenderer customRenderer = MinecraftForgeClient.getItemRenderer(itemstack, EQUIPPED);
                    boolean is3D = (customRenderer != null && customRenderer.shouldUseRenderHelper(EQUIPPED, itemstack, BLOCK_3D));

                    if (is3D || RenderBlocks.renderItemIn3d(Block.getBlockFromItem(itemstack.getItem()).getRenderType()))
                    {
                        float1 = 0.625F;
                        GL11.glTranslatef(0.0F, -0.25F, 0.0F);
                        GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
                        GL11.glScalef(float1, -float1, -float1);
                    }

                    this.renderManager.itemRenderer.renderItem(par1AbstractClientPlayer, itemstack, 0);
                }
                else if (itemstack.getItem() == Items.skull)
                {
                    float1 = 1.0625F;
                    GL11.glScalef(float1, -float1, -float1);
                    String s = "";

                    if (itemstack.hasTagCompound() && itemstack.getTagCompound().hasKey("SkullOwner", 8))
                    {
                        s = itemstack.getTagCompound().getString("SkullOwner");
                    }

                    TileEntitySkullRenderer.field_147536_b.func_147530_a(-0.5F, 0.0F, -0.5F, 1, 180.0F, itemstack.getItemDamage(), s);
                }

                GL11.glPopMatrix();
       	}
       
       
       
       }
    }

	@Override
	protected int shouldRenderPass(AbstractClientPlayer par1AbstractClientPlayer, int par2, float par3)
	{
		ExtendedPlayer props = ExtendedPlayer.get(par1AbstractClientPlayer);

		if(props.getFaction() == 3)
			return -1;
		ItemStack itemstack = par1AbstractClientPlayer.inventory.armorItemInSlot(3 - par2);

			RenderPlayerEvent.SetArmorModel event = new RenderPlayerEvent.SetArmorModel(par1AbstractClientPlayer, this, 3 - par2, par3, itemstack);
			MinecraftForge.EVENT_BUS.post(event);
			if (event.result != -1)
			{
				return event.result;
			}

        if (itemstack != null)
        {
            Item item = itemstack.getItem();

            if (item instanceof ItemArmor)
            {
                ItemArmor itemarmor = (ItemArmor)item;
                this.bindTexture(RenderBiped.getArmorResource(par1AbstractClientPlayer, itemstack, par2, null));
                ModelBiped modelbiped = par2 == 2 ? this.modelArmor : this.modelArmorChestplate;
                modelbiped.bipedHead.showModel = par2 == 0;
                modelbiped.bipedHeadwear.showModel = par2 == 0;
                modelbiped.bipedBody.showModel = par2 == 1 || par2 == 2;
                modelbiped.bipedRightArm.showModel = par2 == 1;
                modelbiped.bipedLeftArm.showModel = par2 == 1;
                modelbiped.bipedRightLeg.showModel = par2 == 2 || par2 == 3;
                modelbiped.bipedLeftLeg.showModel = par2 == 2 || par2 == 3;
                modelbiped = ForgeHooksClient.getArmorModel(par1AbstractClientPlayer, itemstack, par2, modelbiped);
                this.setRenderPassModel(modelbiped);
                modelbiped.onGround = this.mainModel.onGround;
                modelbiped.isRiding = this.mainModel.isRiding;
                modelbiped.isChild = this.mainModel.isChild;

                //Move outside if to allow for more then just CLOTH
                int j = itemarmor.getColor(itemstack);
                if (j != -1)
                {
                    float f1 = (float)(j >> 16 & 255) / 255.0F;
                    float f2 = (float)(j >> 8 & 255) / 255.0F;
                    float f3 = (float)(j & 255) / 255.0F;
                    GL11.glColor3f(f1, f2, f3);

                    if (itemstack.isItemEnchanted())
                    {
                        return 31;
                    }

                    return 16;
                }

                GL11.glColor3f(1.0F, 1.0F, 1.0F);

                if (itemstack.isItemEnchanted())
                {
                    return 15;
                }

                return 1;
            }
        }

        return -1;
	}
	public void doRender(EntityLivingBase entityLivingBase, double posX, double posY, double posZ, float rotationYaw, float rotationPitch)
	
	{

		super.doRender((AbstractClientPlayer) entityLivingBase, posX, posY, posZ, rotationYaw, rotationPitch);

	}


	protected ResourceLocation getEntityTexture(Entity entity)

	{

		if(entity instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer)entity;
			ExtendedPlayer props = ExtendedPlayer.get(player);
			
			if(props.getFaction() == 3)
				return texture1;

		}
		
			return this.getEntityTexture((AbstractClientPlayer)entity);


	}	

}